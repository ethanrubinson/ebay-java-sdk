/*
Copyright (c) 2013 eBay, Inc.
This program is licensed under the terms of the eBay Common Development and
Distribution License (CDDL) Version 1.0 (the "License") and any subsequent  version 
thereof released by eBay.  The then-current version of the License can be found 
at http://www.opensource.org/licenses/cddl1.php and in the eBaySDKLicense file that 
is under the eBay SDK ../docs directory.
*/
package com.ebay.sdk.handler;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.ws.handler.LogicalHandler;
import javax.xml.ws.handler.LogicalMessageContext;
import javax.xml.ws.handler.MessageContext;

import com.ebay.sdk.logging.MetricsLogger;

/**
 * For performance metrics purpose
 * @author boyang
 * @version 1.0
 *
 */
public class MetricsLogHandler extends
             BaseHandler<LogicalMessageContext> implements
             LogicalHandler<LogicalMessageContext> {

	public boolean handleMessage(LogicalMessageContext lmc) {
		
		if (!MetricsLogger.metricsLoggingEnabled()) {
			return true;
		}
		
		Boolean request = (Boolean)lmc.get(MessageContext.MESSAGE_OUTBOUND_PROPERTY);
		if (request.booleanValue()) {
			MetricsLogger.startSdkJAXBCallInvoke();
			
			Map<String, List<String>> http_req_headers = (Map<String, List<String>>)lmc.get(MessageContext.HTTP_REQUEST_HEADERS);
			if (http_req_headers == null) {
				http_req_headers = new HashMap<String, List<String>>();
			} 
			
			http_req_headers.put("X-EBAY-API-METRICS", Collections.singletonList("true"));
			lmc.put(MessageContext.HTTP_REQUEST_HEADERS, http_req_headers);
			
		}
		else{
			MetricsLogger.endSdkJAXBCallInvoke();
			
			Map http_resp_headers = (Map) lmc.get(MessageContext.HTTP_RESPONSE_HEADERS);
			if (http_resp_headers != null) {
				Object value = http_resp_headers.get("X-EBAY-API-PROCESS-TIME");
				if (value != null) {
					String sTime = value.toString();
					sTime = removeChars(sTime, '[', ']');
					long lTime = convertProcessingTime(sTime);
					MetricsLogger.recordServerProcessingTime(lTime);
				}
			}
		}
		return true;
	}
	
	public String removeChars(String s, char c1, char c2) {
		StringBuffer r = new StringBuffer();
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) != c1 && s.charAt(i) != c2) {
				r.append(s.charAt(i));
			}
		}
		return r.toString();
	}
	
	private long convertProcessingTime(String val) {
		if (val == null)
			return 0;
		long retval = 0;
		
		try {
		    retval = (long)Float.parseFloat(val);
		} catch (NumberFormatException nfe) {
			
		}
		return retval;
	}
}
