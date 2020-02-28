/*
Copyright (c) 2013 eBay, Inc.
This program is licensed under the terms of the eBay Common Development and
Distribution License (CDDL) Version 1.0 (the "License") and any subsequent  version 
thereof released by eBay.  The then-current version of the License can be found 
at http://www.opensource.org/licenses/cddl1.php and in the eBaySDKLicense file that 
is under the eBay SDK ../docs directory.
*/
package com.ebay.sdk.handler;

import java.util.Map;

import javax.xml.ws.handler.LogicalHandler;
import javax.xml.ws.handler.LogicalMessageContext;
import javax.xml.ws.handler.MessageContext;

import com.ebay.sdk.ApiContext;
import com.ebay.sdk.ApiLogging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * log http request/response headers
 * @author boyang
 * @version 1.0
 *
 */
public class HTTPHeaderLoggingHandler extends
		BaseHandler<LogicalMessageContext> implements
		LogicalHandler<LogicalMessageContext> {
	private static final String HANDLER_NAME = "HTTPHeaderLoggingHandler";
	private static final Logger log = LoggerFactory.getLogger(HTTPHeaderLoggingHandler.class);

	public HTTPHeaderLoggingHandler() {
		super();
		super.setHandlerName(HANDLER_NAME);
	}

	public boolean handleMessage(LogicalMessageContext smc) {
		Boolean request = (Boolean) smc
				.get(LogicalMessageContext.MESSAGE_OUTBOUND_PROPERTY);

		if (request.booleanValue()) {
			//we can not get most of http request headers here
			//so we just leave it empty
		} else {
			
	    	//get ApiContext from SOAPMessageContext
	    	ApiContext apiContext = (ApiContext)smc.get(HandlerConstants.API_CONTEXT);
	        
	    	//get ApiLogging
	    	ApiLogging apiLogging = apiContext.getApiLogging();
	    	// if http headers logging is not enabled, just return.
	    	if (apiLogging == null || !apiLogging.isLogHTTPHeaders()) {
	    		return true;			
	    	}
			
			Map http_req_headers = (Map) smc
					.get(MessageContext.HTTP_REQUEST_HEADERS);
			
			Map http_resp_headers = (Map) smc
			        .get(MessageContext.HTTP_RESPONSE_HEADERS);			
			
			log.info("---[HTTP Request Headers]---");

			if (http_req_headers != null) {
				log.info(HandlerUtil.outputMap(http_req_headers));
			} else {
				log.info("HTTP Request Headers is not available!");
			}

			log.info("---[HTTP Response Headers]---");

			if (http_resp_headers != null) {
				log.info(HandlerUtil.outputMap(http_resp_headers));
			} else {
				log.info("HTTP Response Headers is not available!");
			}
		}
		
		return true;
	}
}
