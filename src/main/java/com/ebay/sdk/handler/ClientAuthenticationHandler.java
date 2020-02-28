/*
Copyright (c) 2017 eBay, Inc.
This program is licensed under the terms of the eBay Common Development and
Distribution License (CDDL) Version 1.0 (the "License") and any subsequent  version 
thereof released by eBay.  The then-current version of the License can be found 
at http://www.opensource.org/licenses/cddl1.php and in the eBaySDKLicense file that 
is under the eBay SDK ../docs directory.
*/
package com.ebay.sdk.handler;

import java.util.Set;

import javax.xml.namespace.QName;
import javax.xml.soap.SOAPElement;
import javax.xml.soap.SOAPEnvelope;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPHeader;
import javax.xml.soap.SOAPHeaderElement;
import javax.xml.soap.SOAPMessage;
import javax.xml.ws.handler.soap.SOAPHandler;
import javax.xml.ws.handler.soap.SOAPMessageContext;

import com.ebay.sdk.ApiAccount;
import com.ebay.sdk.ApiContext;
import com.ebay.sdk.ApiLogging;
import com.ebay.sdk.EBayConstants;
import com.ebay.sdk.eBayAccount;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * A hander to add eBay API credentials in SOAP header
 * @author boyang
 * @version 1.0
 *
 */
public class ClientAuthenticationHandler extends
		BaseHandler<SOAPMessageContext> implements
		SOAPHandler<SOAPMessageContext> {
	
	private final String HANDLER_NAME = "ClientAuthenticationHandler";
	
	private static final Logger log = LoggerFactory.getLogger(ClientAuthenticationHandler.class);

	public ClientAuthenticationHandler() {
		super();
		super.setHandlerName(HANDLER_NAME);
	}

	public boolean handleMessage(SOAPMessageContext smc) {

		boolean request = ((Boolean) smc
				.get(SOAPMessageContext.MESSAGE_OUTBOUND_PROPERTY))
				.booleanValue();

		if (request) {
			
	    	//get ApiContext from SOAPMessageContext
	    	ApiContext apiContext = (ApiContext)smc.get(HandlerConstants.API_CONTEXT);
	    	
	    	//is this soap request need full credentials?
	    	boolean enableFullCredentials = false;
	    	Object obj = smc.get(HandlerConstants.ENABLE_FULL_CREDENTIALS);
	    	if (obj != null) {
	    		enableFullCredentials = ((Boolean)obj).booleanValue();
	    	}
	    	
	    	//is this soap request only need api account?
	    	boolean needApiAccountOnly = false;
	    	obj = smc.get(HandlerConstants.NEED_API_ACCOUNT_ONLY);
	    	if (obj != null) {
	    		needApiAccountOnly = ((Boolean)obj).booleanValue();
	    	}
			//OAuth Support 02/02/2017
			//is this soap request need SOAP RequesterCredential Header: <soapenv:Header><urn:RequesterCredentials></urn:RequesterCredentials></soapenv:Header> ?  
	    	boolean needSoapRequesterCredentialsHeader = false;
	    	obj =smc.get(HandlerConstants.NEED_SOAP_REQUESTERCREDENTIALS_HEADER);
	    	if (obj != null) {
	    		needSoapRequesterCredentialsHeader=((Boolean)obj).booleanValue();
	    	}//OAuth Support 02/02/2017
			// for request message, we add api credentials
			try {
				SOAPMessage msg = smc.getMessage();
				SOAPEnvelope env = msg.getSOAPPart().getEnvelope();
				SOAPHeader header = env.getHeader();
				if(header == null) {
					header = env.addHeader();
				}
        
               if (needSoapRequesterCredentialsHeader){ //soap request header is needed for this SOAP request //OAuth Support 02/02/2017
				    addSecurityHeader(header, apiContext, enableFullCredentials, needApiAccountOnly);
			   }
			} catch (SOAPException e) {
		    	//get ApiLogging
		    	ApiLogging apiLogging = apiContext.getApiLogging();
		    	
				if (apiLogging != null && apiLogging.isLogExceptions()) {
			    	//logging
					log.error(HANDLER_NAME + " : fail to add security headers.");
					log.error(e.getMessage());
				} else {
					e.printStackTrace();
				}
			}

		} else {
			
			// for response message, we do nothing
			
		}

		return true;
	}
	
	private void addSecurityHeader(SOAPHeader header, ApiContext apiContext, 
			boolean enableFullCredentials, boolean needApiAccountOnly) throws SOAPException { 
		
	      SOAPElement reqCred = header.addChildElement("RequesterCredentials", "ebl", EBayConstants.EBLNS);
	      ((SOAPHeaderElement)reqCred).setMustUnderstand(false);
	      reqCred.addNamespaceDeclaration(EBayConstants.EBL_PREFIX, EBayConstants.EBLNS);
	
	      String tokenString = apiContext.getApiCredential().geteBayToken();
	      
	      //some api calls(GetTokenStatus, RevokeToken) need full credentials
	      if(enableFullCredentials) {
		        SOAPElement credNode = reqCred.addChildElement("Credentials", EBayConstants.EBL_PREFIX);
		        ApiAccount ac = apiContext.getApiCredential().getApiAccount();
		        credNode.addChildElement("AppId", EBayConstants.EBL_PREFIX).addTextNode(ac.getApplication());
		        credNode.addChildElement("DevId", EBayConstants.EBL_PREFIX).addTextNode(ac.getDeveloper());
		        credNode.addChildElement("AuthCert", EBayConstants.EBL_PREFIX).addTextNode(ac.getCertificate());
		        
		        reqCred.addChildElement("eBayAuthToken", EBayConstants.EBL_PREFIX).addTextNode(tokenString);
		        
		        return;
	      }
	      
	      //some api calls(GetSessionID/FetchToken) only need Api Account
	      if(needApiAccountOnly) {
		        SOAPElement credNode = reqCred.addChildElement("Credentials", EBayConstants.EBL_PREFIX);
		        ApiAccount ac = apiContext.getApiCredential().getApiAccount();
		        credNode.addChildElement("AppId", EBayConstants.EBL_PREFIX).addTextNode(ac.getApplication());
		        credNode.addChildElement("DevId", EBayConstants.EBL_PREFIX).addTextNode(ac.getDeveloper());
		        credNode.addChildElement("AuthCert", EBayConstants.EBL_PREFIX).addTextNode(ac.getCertificate());
		        
		        //for FetchToken call, need Username if SecretID is used
		        eBayAccount ec = apiContext.getApiCredential().geteBayAccount();
		        if (ec != null && ec.getUsername() != null) {
		        	credNode.addChildElement("Username", EBayConstants.EBL_PREFIX).addTextNode(ec.getUsername());
		        }
		        
		        return;
	      }
	
	      if (tokenString == null || tokenString.length() == 0) {
	        SOAPElement credNode = reqCred.addChildElement("Credentials", EBayConstants.EBL_PREFIX);
	        ApiAccount ac = apiContext.getApiCredential().getApiAccount();
	        credNode.addChildElement("AppId", EBayConstants.EBL_PREFIX).addTextNode(ac.getApplication());
	        credNode.addChildElement("DevId", EBayConstants.EBL_PREFIX).addTextNode(ac.getDeveloper());
	        credNode.addChildElement("AuthCert", EBayConstants.EBL_PREFIX).addTextNode(ac.getCertificate());
	      } else {
	          reqCred.addChildElement("eBayAuthToken", EBayConstants.EBL_PREFIX).addTextNode(tokenString);
	      }
	}

	public Set<QName> getHeaders() {
		return null;
	}
	
}
