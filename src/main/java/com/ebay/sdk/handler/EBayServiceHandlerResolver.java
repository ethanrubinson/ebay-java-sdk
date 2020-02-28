/*
Copyright (c) 2013 eBay, Inc.
This program is licensed under the terms of the eBay Common Development and
Distribution License (CDDL) Version 1.0 (the "License") and any subsequent  version 
thereof released by eBay.  The then-current version of the License can be found 
at http://www.opensource.org/licenses/cddl1.php and in the eBaySDKLicense file that 
is under the eBay SDK ../docs directory.
*/
package com.ebay.sdk.handler;

import java.util.ArrayList;
import java.util.List;

import javax.xml.ws.handler.Handler;
import javax.xml.ws.handler.HandlerResolver;
import javax.xml.ws.handler.PortInfo;

/**
 * A resolver to add handlers
 * @author boyang
 * @version 1.0
 *
 */
public class EBayServiceHandlerResolver implements HandlerResolver {

	public List<Handler> getHandlerChain(PortInfo portInfo) {
		List<Handler> handlerChain = new ArrayList<Handler>();

		ClientAuthenticationHandler authn = new ClientAuthenticationHandler();
		SOAPMessageLoggingHandler logging = new SOAPMessageLoggingHandler();
		HTTPHeaderLoggingHandler httpheader = new HTTPHeaderLoggingHandler();
		MetricsLogHandler metrics = new MetricsLogHandler();
		
		//add handler for eBay API credentials
		handlerChain.add(authn);
		//add handler for soap message logging
		handlerChain.add(logging);
		//add handler for metrics logging
		handlerChain.add(metrics);
		//add handler for http headers logging
		handlerChain.add(httpheader);

		return handlerChain;
	}
}
