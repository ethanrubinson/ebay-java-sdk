/*
Copyright (c) 2013 eBay, Inc.
This program is licensed under the terms of the eBay Common Development and
Distribution License (CDDL) Version 1.0 (the "License") and any subsequent  version 
thereof released by eBay.  The then-current version of the License can be found 
at http://www.opensource.org/licenses/cddl1.php and in the eBaySDKLicense file that 
is under the eBay SDK ../docs directory.
*/
package com.ebay.sdk.handler;

import java.util.Set;

import javax.xml.namespace.QName;
import javax.xml.soap.SOAPMessage;
import javax.xml.transform.Source;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.handler.soap.SOAPHandler;
import javax.xml.ws.handler.soap.SOAPMessageContext;

import com.ebay.sdk.ApiContext;
import com.ebay.sdk.ApiLogging;
import com.ebay.sdk.util.XmlUtil;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Get xml string from soap message for logging,
 * 
 * @author boyang
 * @version 1.0
 *
 */
public class SOAPMessageLoggingHandler extends BaseHandler<SOAPMessageContext> implements SOAPHandler<SOAPMessageContext> {
    
	private static final String HANDLER_NAME = "SOAPMessageLoggingHandler";
	  private static final Logger log = LoggerFactory.getLogger(SOAPMessageLoggingHandler.class);
     
    public SOAPMessageLoggingHandler(){
		super();
		super.setHandlerName(HANDLER_NAME);		
    }
    
    //log soap message
    public boolean handleMessage(SOAPMessageContext smc) {
    	//get ApiContext from SOAPMessageContext
    	ApiContext apiContext = (ApiContext)smc.get(HandlerConstants.API_CONTEXT);
    	
    	//get ApiLogging
    	ApiLogging apiLogging = apiContext.getApiLogging();
        
    	//get xml string from SOAPMessageContext
        String xmlStr = null;
        try {
        	SOAPMessage message = smc.getMessage();
        	Source payload = message.getSOAPPart().getContent();
    		xmlStr = XmlUtil.getXmlStringFromSource(payload);
    	} catch (Exception e) {
    		if (apiLogging != null && apiLogging.isLogExceptions()) {
    			log.error(HANDLER_NAME + " : fail to get xml string from SOAP message");
    			log.error(e.getMessage());
    		} else {
    			e.printStackTrace();
    		}
    		return true;
    	}        
        
        Boolean request = (Boolean)
             smc.get(MessageContext.MESSAGE_OUTBOUND_PROPERTY);
        if (request.booleanValue()) {//for request message
        	
        	apiContext.setRequestXml(xmlStr);
        	if (apiLogging != null && apiLogging.isLogSOAPMessages()) {
	        	logMessage("Request", xmlStr);
        	}
        	
        } else { //for response message
        	
        	apiContext.setResponseXml(xmlStr);
        	if (apiLogging != null && apiLogging.isLogSOAPMessages()) {
            	logMessage("Response", xmlStr);       		
        	}
        	
        }
   	
        return true;
    }
    
    //log soap fault
	public boolean handleFault(SOAPMessageContext smc) {
    	//get ApiContext from SOAPMessageContext
    	ApiContext apiContext = (ApiContext)smc.get(HandlerConstants.API_CONTEXT);
    	
    	//get ApiLogging
    	ApiLogging apiLogging = apiContext.getApiLogging();
        
    	//get xml string from SOAPMessageContext
        String xmlStr = null;
        try {
        	SOAPMessage message = smc.getMessage();
        	Source payload = message.getSOAPPart().getContent();
    		xmlStr = XmlUtil.getXmlStringFromSource(payload);
    	} catch (Exception e) {
    		if (apiLogging != null && apiLogging.isLogExceptions()) {
    			log.error(HANDLER_NAME + " : fail to get xml string from SOAP message");
    			log.error(e.getMessage());
    		} else {
    			e.printStackTrace();
    		}
    		return true;
    	}
    	
    	apiContext.setResponseXml(xmlStr);
    	if (apiLogging != null && apiLogging.isLogSOAPMessages()) {
        	logMessage("Response", xmlStr);       		
    	}
		
		return true;
		
	}
    
    
	private void logMessage(String msgName, String msgStr) {	
    	String hs = java.text.MessageFormat.format("{0} Message: Length={1}",
                                 new Object[] {msgName, new Integer(msgStr.length())}
                                 );
    	log.info(hs);
    	log.info(msgStr);
	} 

	public Set<QName> getHeaders() {
		return null;
	}
}
