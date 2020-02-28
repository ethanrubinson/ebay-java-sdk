/*
Copyright (c) 2013 eBay, Inc.
This program is licensed under the terms of the eBay Common Development and
Distribution License (CDDL) Version 1.0 (the "License") and any subsequent  version 
thereof released by eBay.  The then-current version of the License can be found 
at http://www.opensource.org/licenses/cddl1.php and in the eBaySDKLicense file that 
is under the eBay SDK ../docs directory.
*/

package com.ebay.sdk;


/**
 * Defines failure-retry condition for API call. <br>
 * 1) If no exceptions are registered, all call exceptions will be retried.
 *<br>
 * 2) If the current exception is registered in the CallRetry object, the call
 *    will  be retried.
 *<br>
 * 3) If the current exception is an ApiException (XML API) or SdkSoapException
 *    (SOAP API) and the returned API error code is registered in the
 *    TriggerApiErrorCodes property, the call will be retried.
 *<br>
 * 4) If the current exception is an SdkHTTPException and the returned HTTP
 *    response code is registered in the TriggerHTTPErrorCodes property, the call
 * will be retried.
 * 
 * <br>
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: eBay Inc.</p>
 * @author Weijun Li
 * @version 1.0
 */
public class CallRetry {

  private ExceptionFilter exceptionFilter = new ExceptionFilter();
  private int maximumRetries;
  private int delayTime;

  /**
   * Constructor.
   */
  public CallRetry() {
  }

  /**
   * Get the list of exception names upon any of them the call-retry will be
   * triggered.
   * @return List of exception names.
   */

  public java.lang.Class[] getTriggerExceptions() {
    return this.exceptionFilter.getTriggerExceptions();
  }

  /**
   * Set the list of exception names upon any of them the call-retry will be
   * triggered. e.g., "ebay.sdk.ApiException", "java.rmi.RemoteException",
   * <p>null means the call-retry will be triggered for any exception.
   * @param triggerExceptions String[]
   */
  public void setTriggerExceptions(java.lang.Class[] triggerExceptions) {
    this.exceptionFilter.setTriggerExceptions(triggerExceptions);;
  }

  /**
   * Get list of API error codes upon which the retry should be triggered.
   * @return The API error code list.
   */
  public String[] getTriggerApiErrorCodes() {
      return this.exceptionFilter.getTriggerApiErrorCodes();
  }

  /**
   * If the trigger exception list (setTriggerExceptions()) contains
   * ebay.sdk.ApiException,
   * sets the list of API error codes upong which the retry should be triggered.
   * <P>null means the retry will be triggered for any API error.
   * @param triggerApiErrorCodes The API error code list.
   */
  public void setTriggerApiErrorCodes(
    String[] triggerApiErrorCodes) {
    this.exceptionFilter.setTriggerApiErrorCodes(triggerApiErrorCodes);
  }

  public int[] getTriggerHTTPErrorCodes() {
    return this.exceptionFilter.getTriggerHTTPErrorCodes();
  }

  public void setTriggerHTTPErrorCodes(int[] triggerHTTPErrorCodes) {
    this.exceptionFilter.setTriggerHTTPErrorCodes(triggerHTTPErrorCodes);
  }

  /**
   * Get maximum number of retries if the failure continues to happen.
   * @return The maximum number of retries.
   */
  public int getMaximumRetries(){
    return this.maximumRetries;
  }

  /**
   * Set maximum number of retries if the failure continues to happen.
   * @param maximumRetries The maximum number of retries to be set to.
   */
  public void setMaximumRetries(int maximumRetries) {
    this.maximumRetries = maximumRetries;
  }

  /**
   * Get delay time for between each retry-API-call.
   * @return The delay time in milliseconds.
   */
  public int getDelayTime() {
    return this.delayTime;
  }

  /**
   * Set delay time between each retry-API-call.
   * @param delayTime The delay time to be set to. In milliseconds.
   */
  public void setDelayTime(int delayTime) {
    this.delayTime = delayTime;
  }

  /**
   * Determines if the Call-Retry should be granted for the given exception.
   * @param exception The catched Exception.
   * @return true means the retry should happen.
   */
  boolean shouldRetry(Exception exception)
  {
    return this.exceptionFilter.matches(exception);
  }
}
