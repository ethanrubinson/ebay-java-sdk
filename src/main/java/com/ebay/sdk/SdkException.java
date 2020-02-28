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
 * The super class of all SDK exception types.
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: eBay Inc.</p>
 * @author Weijun Li
 * @version 1.0
 */
public class SdkException extends Exception {

  private Throwable innerThrowable = null;

  /**
   * Constructor.
   */
  public SdkException() {
  }

  /**
   * Constructor.
   * @param message - the detail message (which is saved for later retrieval
   * by the Throwable.getMessage() method).
   */
  public SdkException(String message) {
    super(message);
  }

  /**
   * Constructor.
   * @param message String
   * @param innerThrowable Throwable
   */
  public SdkException(String message, Throwable innerThrowable) {
    super(message);
    this.innerThrowable = innerThrowable;
  }

  /**
   * Constructor.
   * @param innerThrowable Throwable
   */
  public SdkException(Throwable innerThrowable) {
    this.innerThrowable = innerThrowable;
  }

  /**
   * Get the inner exception object.
   * @return Throwable
   */
  public Throwable getInnerThrowable() {
    return this.innerThrowable;
  }

  /**
   * Returns combined error message.
   * @return String
   */
  public String getMessage()
  {
    String message = super.getMessage();
    if( (message == null || message.length() == 0) && innerThrowable != null )
    {
      message = innerThrowable.getMessage();
      // If there's no message let's use class name instead.
      if( message == null )
        message = innerThrowable.getClass().getName();
    }

    if( message == null )
    {
      // If there's no message let's use class name instead.
      message = this.getClass().getName();
    }

    return message;
  }
}
