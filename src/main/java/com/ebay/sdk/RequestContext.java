/*
Copyright (c) 2017 eBay, Inc.
This program is licensed under the terms of the eBay Common Development and
Distribution License (CDDL) Version 1.0 (the "License") and any subsequent  version 
thereof released by eBay.  The then-current version of the License can be found 
at http://www.opensource.org/licenses/cddl1.php and in the eBaySDKLicense file that 
is under the eBay SDK ../docs directory.
*/

package com.ebay.sdk;

/**
 * A value object holding some request context parameters
 * @author boyang
 * @version 1.0
 *
 */
class RequestContext {
	
	private boolean httpCompressionEnabled = true;
	private boolean fullCredentialsEnabled = false;
	private boolean apiAccountOnly = false;
	private String endPointAddress = "https://api.ebay.com/wsapi";
	//OAuth Support 02/02/2017
    private boolean oAuthTokenCredentialHTTPHeader = false;
	
	//OAuth Support 02/02/2017
	public boolean isoAuthTokenCredentialHTTPHeader() {
		return oAuthTokenCredentialHTTPHeader;
	}
	//OAuth Support 02/02/2017
	/**
   * Set the oAuthToken HTTPHeader  flag. 
   * @param oAuthTokenCredentialHTTPHeader flag
   */
	public void setoAuthTokenCredentialHTTPHeader(boolean oAuthTokenCredentialHTTPHeader) {
		this.oAuthTokenCredentialHTTPHeader = oAuthTokenCredentialHTTPHeader;
	}
	
	public boolean isHttpCompressionEnabled() {
		return httpCompressionEnabled;
	}
	public void setHttpCompressionEnabled(boolean httpCompressionEnabled) {
		this.httpCompressionEnabled = httpCompressionEnabled;
	}
	public boolean isFullCredentialsEnabled() {
		return fullCredentialsEnabled;
	}
	public void setFullCredentialsEnabled(boolean fullCredentialsEnabled) {
		this.fullCredentialsEnabled = fullCredentialsEnabled;
	}
	public String getEndPointAddress() {
		return endPointAddress;
	}
	public void setEndPointAddress(String endPointAddress) {
		this.endPointAddress = endPointAddress;
	}
	public boolean isApiAccountOnly() {
		return apiAccountOnly;
	}
	public void setApiAccountOnly(boolean apiAccountOnly) {
		this.apiAccountOnly = apiAccountOnly;
	}

}
