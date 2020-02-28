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
 * Implementation of ErrorAware interface.
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: eBay Inc.</p>
 * @author Weijun Li
 * @version 1.0
 */
public class ErrorInfoImpl implements ErrorInfo {

  private String errorMessage = "";
  private String errorType = "";

  /**
   * Indicates if there's error.
   * @return true means there's error.
   */
  public boolean hasError() {
    return errorType.length() > 0 || errorMessage.length() > 0;
  }

  /**
   * Clear the error.
   */
  public void clearError() {
    errorType = "";
    errorMessage = "";
  }

  /**
   * Get error type string.
   * @return error type string.
   */
  public String getErrorType() {
    return this.errorType;
  }

  /**
   * Set error type string.
   * @param errorType the error type string to set.
   */
  public void setErrorType(String errorType) {
    this.errorType = errorType;
  }

  /**
   * Get error message string.
   * @return error message string.
   */
  public String getErrorMessage() {
    return this.errorMessage;
  }

  /**
   * Set error message string.
   * @param errorMessage error message string to set.
   */
  public void setErrorMessage(String errorMessage) {
    this.errorMessage = errorMessage;
  }
}
