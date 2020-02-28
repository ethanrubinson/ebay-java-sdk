/*
Copyright (c) 2013 eBay, Inc.
This program is licensed under the terms of the eBay Common Development and
Distribution License (CDDL) Version 1.0 (the "License") and any subsequent  version 
thereof released by eBay.  The then-current version of the License can be found 
at http://www.opensource.org/licenses/cddl1.php and in the eBaySDKLicense file that 
is under the eBay SDK ../docs directory.
*/
package com.ebay.sdk.handler;

/**
 * constants used by handlers
 * @author boyang
 * @version 1.0
 *
 */
public interface HandlerConstants {
	
	static final String API_CONTEXT = "api_context";
	static final String ENABLE_FULL_CREDENTIALS = "full_credentials";
	static final String NEED_API_ACCOUNT_ONLY = "api_account_only";
	//OAuth Support 02/02/2017
	static final String NEED_SOAP_REQUESTERCREDENTIALS_HEADER = "soap_requestercredentials_header";

}
