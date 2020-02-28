/*
Copyright (c) 2013 eBay, Inc.
This program is licensed under the terms of the eBay Common Development and
Distribution License (CDDL) Version 1.0 (the "License") and any subsequent  version 
thereof released by eBay.  The then-current version of the License can be found 
at http://www.opensource.org/licenses/cddl1.php and in the eBaySDKLicense file that 
is under the eBay SDK ../docs directory.
*/

package com.ebay.sdk;

import com.ebay.soap.eBLBaseComponents.SeverityCodeType;

/**
 * Represents one or more errors reported by an API call. Note that an API 
 * call can also return warnings, which do not trigger an ApiException.
 *
 * <br>
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: eBay Inc.</p>
 * @author Weijun Li & William Yang
 * @version 1.0
 */
public class ApiException extends SdkException {

  private com.ebay.soap.eBLBaseComponents.ErrorType[] errors;

  /**
   * Constructor.
   */
  public ApiException() {
  }

  /**
   * Constructor.
   * @param errors The array of errors of the exception.
   */
  public ApiException(com.ebay.soap.eBLBaseComponents.ErrorType[] errors) {
    this.errors = errors;
  }

  /**
   * Get list of errors included in the exception.
   * @return ErrorType[]
   */
  public com.ebay.soap.eBLBaseComponents.ErrorType[] getErrors() {
      return errors;
  }

  /**
   * Set list of errors to be included in the exception.
   * @param errors ErrorType[]
   */
  public void setErrors(com.ebay.soap.eBLBaseComponents.ErrorType[] errors) {
      this.errors = errors;
  }

  private int countErrors(String token)
  {
    int count = 0;
    for(int i = 0; i < this.errors.length; i ++)
    {
    	SeverityCodeType severity = errors[i].getSeverityCode();
        if( severity != null && severity.value().equals(token))
          count ++;
    }
    return count;
  }

  /**
   * Count number of errors with the severity of SeverityCodeType.ERROR
   * in the error list.
   * @return int
   */
  public int getSeverityErrorCount() {
    return countErrors(com.ebay.soap.eBLBaseComponents.SeverityCodeType.ERROR.value());
  }

  /**
   * Count number of errors with the severity of SeverityCodeType.WARNING
   * in the error list.
   * @return int
   */
  public int getSeverityWarningCount() {
    return countErrors(com.ebay.soap.eBLBaseComponents.SeverityCodeType.WARNING.value());
  }

  /**
   * Overrides Exception.getMessage().
   * @return String
   */
  public String getMessage() {
    String message = "";

    if (this.errors != null) {
      for (int i = 0; i < errors.length; i++)
      {
        if (i > 0)
          message += "\n";

        String s = errors[i].getLongMessage();
        if( s == null || s.length() == 0 )
        {
          s = errors[i].getShortMessage();
          if( s == null || s.length() == 0 ) {
        	  String errorCode = errors[i].getErrorCode();
              if (errorCode != null) {
            	  s = errorCode;
              } else {
            	  s = "";
              }
          }
        }
        
        message += s;
      }
    }

    return message;
  }

  /**
   * Overrides Exception.getLocalizedMessage().
   * @return String
   */
  public String getLocalizedMessage() {
    return getMessage();
  }

  public boolean containsErrorCode(String errorCode)
{
  for(int i = 0; i < errors.length; i++ )
  {
    String errCode = errors[i].getErrorCode();
    if( errCode != null && errCode.equals(errorCode) )
      return true;
  }
  return false;
}

}
