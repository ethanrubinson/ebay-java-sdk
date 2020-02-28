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
 * Interface to identify that a data object can store related error.
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: eBay Inc.</p>
 * @author Weijun Li
 * @version 1.0
 */
public interface ErrorInfo {

  /**
   * Indicates if there's error.
   * @return true means there's error.
   */
  boolean hasError();

  /**
   * Clear the error.
   */
  void clearError();

  /**
   * Get error type string.
   * @return error type string.
   */
  String getErrorType();

  /**
   * Set error type string.
   * @param errorType the error type string to set.
   */
  void setErrorType(String errorType);

  /**
   * Get error message string.
   * @return error message string.
   */
  String getErrorMessage();

  /**
   * Set error message string.
   * @param errorMessage error message string to set.
   */
  void setErrorMessage(String errorMessage);
}
