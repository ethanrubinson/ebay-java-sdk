/*
Copyright (c) 2013 eBay, Inc.
This program is licensed under the terms of the eBay Common Development and
Distribution License (CDDL) Version 1.0 (the "License") and any subsequent  version 
thereof released by eBay.  The then-current version of the License can be found 
at http://www.opensource.org/licenses/cddl1.php and in the eBaySDKLicense file that 
is under the eBay SDK ../docs directory.
*/

package com.ebay.sdk;

import com.ebay.soap.eBLBaseComponents.*;

/**
 * Defines the API context with which an API call will be made. The APi context
 * contains a variety of information, such as the credentials of the application 
 * and the user, the application's RuName, and the API server's URL.
 * <p>If you have an auth token to use as credentials, you need only call
 * {@code ApiCredential#seteBayToken(String)} to apply it. Otherwise you must 
 * call both {@link ApiCredential#setApiAccount(ApiAccount)} to set the application
 * credentials and {@code ApiCredential#seteBayAccount(eBayAccount)} to set the 
 * user credentials.
 * <br>
 * <p>Title:
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2004 - 2007</p>
 * <p>Company: eBay Inc.</p>
 * @author Weijun Li
 * @version 1.0
 */
public class ApiContext {

  private int timeout = 0;
  private String apiServerUrl = null;
  private String epsServerUrl = null;
  private String signInUrl = null;
  private ApiCredential apiCredential = new ApiCredential();
  private java.lang.String errorLanguage;
  private ApiLogging apiLogging = new ApiLogging();
  private CallRetry callRetry = null;
  private int totalCalls = 0;
  private SiteCodeType site = SiteCodeType.US;
  private String requestXml;
  private String responseXml;
  private String wsdlVersion = "1131";
  private String ruName = null;

  /**
   * Routing is no longer needed.
   */
  private String routing = null;  //"beta";

  /**
   * Constructor.
   */
  public ApiContext() {
  }

 /**
  * Get timeout for the HTTP connection.
  * @return the timeout value in milliseconds.
  */
  public int getTimeout() {
    return this.timeout;
  }

  /**
   * Set timeout for the HTTP connection.
   * @param timeout the timeout value in milliseconds.
   */
  public void setTimeout(int timeout) {
    this.timeout = timeout;
  }

  /**
   * Get URL of the eBay API server to which the API call will be sent.
   * @return URL string of the eBay API server.
   */
  public String getApiServerUrl() {
    return this.apiServerUrl;
  }

  /**
   * Set URL of the eBay API server to which the API call will be sent.
   * @param url The URL string to set.
   */
  public void setApiServerUrl(String url) {
    this.apiServerUrl = url;
  }
  
  /**
   * Gets the URL of the User Consent Flow (the procedure in which the user gives
   * consent for an application to perform API calls on his or her behalf).
   * For more information <p>see the description of {@link #setSignInUrl(String)}.
   * @return 	The User Consent Flow's URL. The parameters are not included. 
   */
  public String getSignInUrl() {
    return this.signInUrl;
  }

  /**
   * Sets the URL of the User Consent Flow (the procedure in which the user gives 
   * consent for an application to perform API calls on his or her behalf).
   * <p>For more information about the User Consent Flow, see the Trading API 
   * Reference's section 
   * <a href="http://developer.ebay.com/DevZone/XML/docs/WebHelp/wwhelp/wwhimpl/js/html/wwhelp.htm?context=eBay_XML_API&topic=GettingATokenViaFetchToken">Getting a Token via FetchToken</a>.
   * (Note that this section does use the term "User Consent Flow"; it refers to
   * "the URL that takes the user to the eBay sign-in page for new token creation.")
   * 
   * @param url 	The User Consent Flow's URL. The parameters should not be included.
   */
  public void setSignInUrl(String url) {
    this.signInUrl = url;
  }

  /**
   * Get the ApiCredential object associated with this context.
   * @return 	The ApiCredential object associated with this context.
   */
  public ApiCredential getApiCredential(){
    return this.apiCredential;
  }

  /**
   * Set the ApiCredential object associated with this context.
   * @param apiCredential 	The ApiCredential object associated with this context.
   */
  public void setApiCredential(ApiCredential apiCredential) {
    this.apiCredential = apiCredential;
  }

  /**
   * Get the language in which to return error messages.
   * @return the error language string.
   */
  public java.lang.String getErrorLanguage() {
    return errorLanguage;
  }

  /**
   * Set the language in which to return error messages.
   * @param errorLanguage the error language string.
   */
  public void setErrorLanguage(java.lang.String errorLanguage) {
    this.errorLanguage = errorLanguage;
  }

  /**
   * Get the ApiLogging object associated with this context.
   * @return The ApiLogging object.
   */
  public ApiLogging getApiLogging() {
    return this.apiLogging;
  }

  /**
   * Set the ApiLogging object associated with this context.
   * @param apiLogging ApiLogging
   */
  public void setApiLogging(ApiLogging apiLogging) {
    this.apiLogging = apiLogging;
  }

  /**
   * Get the CallRetry object.
   * @return The CallRetry object.
   */
  public CallRetry getCallRetry() {
    return this.callRetry;
  }

  /**
   * Set the CallRetry object to be used to control the retry behaviour of calls.
   * It controls the Call-Retry behavior of all API calls made with this ApiContext
   * object. If you set ApiCall.CallRetry property of each individual call,
   * the ApiContext.CallRetry will be overriden or ignored.
   * @param callRetry the CallRetry object to use.
   */
  public void setCallRetry(CallRetry callRetry) {
    this.callRetry = callRetry;
  }

  /**
   * Get total number of API calls that have been made with the ApiContext
   * object. Each time when you successfully made an API call with the ApiContext
   * object, the ApiCall instance will call setTotalCalls() to increment
   * the total number of API calls.
   * @return Total number of calls made.
   */
  public int getTotalCalls() {
    return this.totalCalls;
  }

  /**
   * Set total number of API calls made with the ApiContext object. This method
   * is usually called by ApiCall object only.
   * @param totalCalls Total number of calls to be set to.
   */
  public void setTotalCalls(int totalCalls) {
    this.totalCalls = totalCalls;
  }

  /**
   * Increase number of total calls by one.
   * @return The number of total calls made.
   */
  public int incrementTotalCalls() {
    return (++this.totalCalls);
  }

  /**
   * Returns the epsServerUrl.
   * @return String
   */
  public String getEpsServerUrl() {
	return epsServerUrl;
  }

  /**
   * Sets the gateway routing.
   * @param routing The routing to set
   */
  public void setRouting(String routing) {
    this.routing = routing;
  }

  /**
   * Returns the routing.
   * @return String
   */
  public String getRouting() {
        return routing;
  }

/**
 * Sets the epsServerUrl.
 * @param epsServerUrl The epsServerUrl to set
 */
  public void setEpsServerUrl(String epsServerUrl) {
    this.epsServerUrl = epsServerUrl;
  }

  /**
   * Gets the site for API calls under the context.
   * @return SiteCodeType
   */
  public SiteCodeType getSite() {
    return site;
  }

  /**
   * Sets the common eBay site that for all the APIs calls made with the
   * ApiContext object. If an call object (inherited from ApiCall, e.g., AddItemCall)
   * sets its Site property (ApiCall.setSite()) it will override this common eBay
   * site property.
   * @param site SiteCodeType
   */
  public void setSite(SiteCodeType site) {
    this.site = site;
  }

  /**
   * Gets the version of WSDL version to be used.
   * @return String
   */
  public String getWSDLVersion() {
    return wsdlVersion;
  }

  /**
   * Sets the version of WSDL version to be used.
   * @param wsdlVersion String
   */
  public void setWSDLVersion(String wsdlVersion) {
    this.wsdlVersion = wsdlVersion;
  }

	public String getRequestXml() {
		return requestXml;
	}

	public void setRequestXml(String requestXml) {
		this.requestXml = requestXml;
	}

	public String getResponseXml() {
		return responseXml;
	}

	public void setResponseXml(String responseXml) {
		this.responseXml = responseXml;
	}

	public String getRuName() {
		return ruName;
	}

	public void setRuName(String ruName) {
		this.ruName = ruName;
	}

}
