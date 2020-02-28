/*
Copyright (c) 2017 eBay, Inc.
This program is licensed under the terms of the eBay Common Development and
Distribution License (CDDL) Version 1.0 (the "License") and any subsequent  version 
thereof released by eBay.  The then-current version of the License can be found 
at http://www.opensource.org/licenses/cddl1.php and in the eBaySDKLicense file that 
is under the eBay SDK ../docs directory.
*/
package com.ebay.sdk;

import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.namespace.QName;
import javax.xml.ws.BindingProvider;
import javax.xml.ws.handler.HandlerResolver;
import javax.xml.ws.handler.MessageContext;

import com.ebay.sdk.handler.EBayServiceHandlerResolver;
import com.ebay.sdk.handler.HandlerConstants;
import com.ebay.soap.eBLBaseComponents.EBayAPIInterface;
import com.ebay.soap.eBLBaseComponents.EBayAPIInterfaceService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Service Locator to get eBay API instance
 * @author boyang
 * @version 1.0
 * 
 */

class SdkAPIInterfaceServiceLocator {
	  private static final String JAXWS_CONNECT_TIMEOUT = "com.sun.xml.ws.connect.timeout";
	  //eBay API instance pool
	  private static final ArrayList<EBayAPIInterface> apiPool = new ArrayList<EBayAPIInterface>();
	  //the eBay wsdl is packaged with ebaysdkcore.jar
	  private static final String EBAY_WSDL= "eBaySvc.wsdl";
	  private static final String EBAY_SERVICE_NAME = "eBayAPIInterfaceService";
	  
	  private static final String READ_TIMEOUT = "com.sun.xml.ws.request.timeout";
	  
	  private static final Integer lock = new Integer(0);
	  
	  private static EBayAPIInterfaceService service;
	  
	  private static final Logger log = LoggerFactory.getLogger(SdkAPIInterfaceServiceLocator.class);
	  
	  // initialize eBay service
	  static {
		  try{
			    //by default, wsdl is in the root package
			    URL	url = EBayAPIInterfaceService.class.getClassLoader().getResource(EBAY_WSDL);
			    if (url == null) {
			    	throw new SdkException("fail to load ebay wsdl, please ensure that " + EBAY_WSDL + " is in the classpath!");
			    }
			
				QName qn = new QName(EBayConstants.EBLNS, EBAY_SERVICE_NAME);
				//get eBay service
				log.info("loading wsdl : " + url.toString());
				service = new EBayAPIInterfaceService(url, qn);
				log.info("wsdl loaded and service initialized.");
				//set handler
				HandlerResolver ccResolver = new EBayServiceHandlerResolver();
				service.setHandlerResolver(ccResolver);	
		  } catch (Exception e) {
		      e.printStackTrace();
		  }		  
	  }

	  /**
	   * get eBay API instance from the pool
	   * 
	   * @param apiContext, ApiContext
	   * @param reqContext, RequestContext
	   * @return
	   */
	  static EBayAPIInterface getEBayAPI(ApiContext apiContext, 
			                                    RequestContext reqContext) {
		  EBayAPIInterface api = null;
		  
		  synchronized(lock) {
			  //if there is no port instance in the pool, get one
			  //from EBayAPIInterfaceService
			  if (apiPool.isEmpty()) {
				  api = service.getEBayAPI();
			  } 
			  //otherwise, get one from pool
			  else {
			      api = apiPool.remove(0);
			  }
		  }
		  	  
		  initRequestContext(api, apiContext, reqContext);
		  
		  return api; 
	  }
	  
	  /**
	   * return eBay API instance to the pool
	   * 
	   * @param api EBayAPIInterface
	   */
	  static void releaseEBayAPI(EBayAPIInterface api) {
		  if (api != null) {
			  synchronized(lock) {
				  apiPool.add(api);
			  }
		  }
	  }

    /**
     * initialize the RequestContext
     * @param api, EBayAPIInterface
     * @param apiContext, ApiContext
     * @param reqContext, RequestContext
     */
	private static void initRequestContext(EBayAPIInterface api,
			            ApiContext apiContext, RequestContext reqContext) {
	    
		if (api == null) return;
		
		Map<String, Object> requestContext = ((BindingProvider)api).getRequestContext();
	    Map<String, List<String>> httpHeaders = new HashMap<String, List<String>>();
		//set ApiContext
		requestContext.put(HandlerConstants.API_CONTEXT, apiContext);
		
		//set timeout
		int timeout = apiContext.getTimeout();
		if (timeout > 0) {
			requestContext.put(JAXWS_CONNECT_TIMEOUT, timeout);
			//TODO, need read timeout?(boyang)
			requestContext.put(READ_TIMEOUT, timeout);
		} else {
			if (requestContext.containsKey(JAXWS_CONNECT_TIMEOUT)) {
				requestContext.remove(JAXWS_CONNECT_TIMEOUT);
			}
			if (requestContext.containsKey(READ_TIMEOUT)) {
				requestContext.remove(READ_TIMEOUT);
			}
		}

		//set http gzip compression
		boolean isEnableHTTPCompression = reqContext.isHttpCompressionEnabled();
		if (isEnableHTTPCompression) {
		
			//now our server does not support gzipped request
			//httpHeaders.put("Content-Encoding", Collections.singletonList("gzip"));
			httpHeaders.put("Accept-Encoding", Collections.singletonList("gzip"));
			requestContext.put(MessageContext.HTTP_REQUEST_HEADERS, httpHeaders);
		} else {
			if (requestContext.containsKey(MessageContext.HTTP_REQUEST_HEADERS)) {
				requestContext.remove(MessageContext.HTTP_REQUEST_HEADERS);
			}
		}
	
		//set endpoint address
		requestContext.put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, reqContext.getEndPointAddress());
		
		//OAuth Support 02/02/2017 
		//if not oAuthTokenCredentialHTTPHeader, set SOAPRequesterCredentials Header 
		boolean soapRequesterCredentialsHeader=false;
		if (!reqContext.isoAuthTokenCredentialHTTPHeader() )
        	soapRequesterCredentialsHeader=true;
		
		//set SOAPRequesterCredentials Header or not 02/02/2017 
		if (soapRequesterCredentialsHeader) {
			requestContext.put(HandlerConstants.NEED_SOAP_REQUESTERCREDENTIALS_HEADER,
					soapRequesterCredentialsHeader ? Boolean.TRUE : Boolean.FALSE); //02/02/2017 
		    //enable full credentials or not
		    boolean isEnabledFullCredentials = reqContext.isFullCredentialsEnabled();
		    requestContext.put(HandlerConstants.ENABLE_FULL_CREDENTIALS, 
				isEnabledFullCredentials?Boolean.TRUE:Boolean.FALSE);
		
		    //only need api account or not
		    boolean needApiAccountOnly = reqContext.isApiAccountOnly();
		    requestContext.put(HandlerConstants.NEED_API_ACCOUNT_ONLY, 
				needApiAccountOnly?Boolean.TRUE:Boolean.FALSE);
	    }else {//OAuth Support 02/02/2017 
		    if (requestContext.containsKey(HandlerConstants.NEED_SOAP_REQUESTERCREDENTIALS_HEADER)){
				requestContext.remove(HandlerConstants.NEED_SOAP_REQUESTERCREDENTIALS_HEADER);
			}
		    if (requestContext.containsKey(HandlerConstants.ENABLE_FULL_CREDENTIALS)){
			    requestContext.remove(HandlerConstants.ENABLE_FULL_CREDENTIALS);
			}
			if (requestContext.containsKey(HandlerConstants.NEED_API_ACCOUNT_ONLY)){
			    requestContext.remove(HandlerConstants.NEED_API_ACCOUNT_ONLY);
			}
	        //set  X-EBAY-API-IAF-TOKEN http request header with OAuthToken value
			String oAuthToken = apiContext.getApiCredential().getOAuthToken();
			if (reqContext.isoAuthTokenCredentialHTTPHeader() && (oAuthToken != null && oAuthToken.length() > 0)) {
				
				httpHeaders.put("X-EBAY-API-IAF-TOKEN", Collections.singletonList(oAuthToken));
			}else {
				if (requestContext.containsKey(MessageContext.HTTP_REQUEST_HEADERS)) {
					requestContext.remove(MessageContext.HTTP_REQUEST_HEADERS);
				}
			}	

		}//set  X-EBAY-API-IAF-TOKEN http request header with OAuthToken value  OAuth Support 02/02/2017 

        requestContext.put(MessageContext.HTTP_REQUEST_HEADERS, httpHeaders);
		
	}

}
