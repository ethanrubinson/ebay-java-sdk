/*
Copyright (c) 2013 eBay, Inc.
This program is licensed under the terms of the eBay Common Development and
Distribution License (CDDL) Version 1.0 (the "License") and any subsequent  version 
thereof released by eBay.  The then-current version of the License can be found 
at http://www.opensource.org/licenses/cddl1.php and in the eBaySDKLicense file that 
is under the eBay SDK ../docs directory.
*/

package com.ebay.sdk;

import javax.xml.ws.http.HTTPException;

/**
 * Wraps HTTP exception (unexpected return codes 300 - 499, 501-599) for SDK.
 * The HTTP return code is available in the ErrorCode property.
 * <br>
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: eBay Inc.</p>
 * @author Ron Murphy & William Yang
 * @version 1.0
 */
public class SdkHTTPException extends SdkException {
    int errorCode = 0;
    
public SdkHTTPException(int code) {
	errorCode = code;
}
  /**
   * Create an instance of SdkHTTPException object from the associated HTTPException.
   * @param he
   * @return the new SdkHTTPException
   */
  static public SdkHTTPException fromHTTPException(HTTPException he)
  {
	  int code = he.getStatusCode();
	  return new SdkHTTPException(code);
  }

  /**
   * Gets the HTTP return code associated with the unexpected HTTP response.
   * @return ErrorType
   */
  public int getErrorCode() {
    return this.errorCode;
  }

  /**
   * Sets the HTTP return code.
   * @param errorCode
   */
  public void setErrorCode(int errorCode) {
    this.errorCode = errorCode;
  }
  
}
