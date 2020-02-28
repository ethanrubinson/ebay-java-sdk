/*
Copyright (c) 2013 eBay, Inc.
This program is licensed under the terms of the eBay Common Development and
Distribution License (CDDL) Version 1.0 (the "License") and any subsequent  version 
thereof released by eBay.  The then-current version of the License can be found 
at http://www.opensource.org/licenses/cddl1.php and in the eBaySDKLicense file that 
is under the eBay SDK ../docs directory.
*/

package com.ebay.sdk;

import java.util.*;

import com.ebay.soap.eBLBaseComponents.*;

/**
 * Implements exception matching for call retry and for exception payload logging. <br>
 * 1) If no exceptions are registered, all call exceptions match.
 *<br>
 * 2) If the current exception is registered by type name, it matches.
 *<br>
 * 3) If the current exception is an ApiException (XML API) or SdkSoapException
 *    (SOAP API) and the returned API error code is registered in the
 *    TriggerApiErrorCodes property, it matches.
 *<br>
 * 4) If the current exception is an SdkHTTPException and the returned HTTP
 *    response code is registered in the TriggerHTTPErrorCodes property, it matches.
 * <br><br>
 * <br>
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: eBay Inc.</p>
 * @author Ron Murphy
 * @version 1.0
 */
public class ExceptionFilter {

  private String[] triggerApiErrorCodes;
  private int[] triggerHTTPErrorCodes;
  private java.lang.Class[] triggerExceptions;

  /**
   * Constructor.
   */
  public ExceptionFilter() {
  }

  public ExceptionFilter(String errorCodes, String exceptions, String httpStatusCodes)
  {
          triggerApiErrorCodes = parseTriggerErrorCodes(errorCodes);
          triggerHTTPErrorCodes = parseTriggerHttpStatusCodes(httpStatusCodes);
          triggerExceptions = parseTriggerExceptions(exceptions);
  }

  /**
   * parseTriggerExceptions
   *
   * @param exceptions String
   * @return Class[]
   */
  private Class[] parseTriggerExceptions(String exceptions) {
    if (exceptions == null || exceptions.length() == 0)
            return null;
    StringTokenizer st = new StringTokenizer(exceptions, ";");
    List outList = new ArrayList();
    while (st.hasMoreTokens()) {
      String exceptionName = st.nextToken();
      Class c = getClassFromName(exceptionName);
      outList.add(c);
    }
    Class[] ret = new Class[outList.size()];
    for (int i=0; i < outList.size(); i++)
	ret[i] = (Class)outList.get(i);
    return ret;
  }

  /**
   * getClassFromName
   *
   * @param exceptionName String
   * @return Class
   */
  private static Class getClassFromName(String name) {
    try {
      return Thread.currentThread().getContextClassLoader().loadClass(name);
    }
    catch (ClassNotFoundException ex) {
      return null;
    }
  }

  /**
   * parseTriggerHttpStatusCodes
   *
   * @param httpStatusCodes String
   * @return int[]
   */
  private int[] parseTriggerHttpStatusCodes(String httpStatusCodes) {
    if (httpStatusCodes == null || httpStatusCodes.length() == 0)
            return null;
    StringTokenizer st = new StringTokenizer(httpStatusCodes, ";");
    int[] outCodes = new int[st.countTokens()];
    for (int i = 0; i < outCodes.length; i++) {
      String statusCode = st.nextToken();
      outCodes[i] = Integer.parseInt(statusCode);
    }
    return outCodes;
  }

  /**
   * parseTriggerErrorCodes
   *
   * @param errorCodes String
   * @return Token[]
   */
  private String[] parseTriggerErrorCodes(String errorCodes) {
    if (errorCodes == null || errorCodes.length() == 0)
            return null;
    StringTokenizer st = new StringTokenizer(errorCodes, ";");
    List outList = new ArrayList();
    while (st.hasMoreTokens()) {
      String errCode = st.nextToken();
      outList.add(errCode);
    }
    return (String[]) outList.toArray();
  }

  /**
   * Get the list of exception names upon any of them the call-retry will be
   * triggered.
   * @return List of exception names.
   */

  public java.lang.Class[] getTriggerExceptions() {
    return this.triggerExceptions;
  }

  /**
   * Set the list of exception names to match against. e.g., "ebay.sdk.ApiException", "java.rmi.RemoteException",
   * @param triggerExceptions String[]
   */
  public void setTriggerExceptions(java.lang.Class[] triggerExceptions) {
    this.triggerExceptions = triggerExceptions;
  }

  /**
   * Get list of API error codes to match against.
   * @return The API error code list.
   */
  public String[] getTriggerApiErrorCodes() {
      return triggerApiErrorCodes;
  }

  /**
   * For the case where the error is an ApiException / SdkSoapException,
   * sets the list of API error codes to match against.
   * @param triggerApiErrorCodes The API error code list.
   */
  public void setTriggerApiErrorCodes(
    String[] triggerApiErrorCodes) {
    this.triggerApiErrorCodes = triggerApiErrorCodes;
  }

  /**
   * Get list of HTTP status codes to match against.
   * @return The HTTP status code list.
   */
  public int[] getTriggerHTTPErrorCodes() {
          return triggerHTTPErrorCodes;
  }

  /**
   * For the case where the error is an SdkHttpException,
   * sets the list of HTTP status codes to match against.
   * @param triggerHTTPErrorCodes The HTTP status code list.
   */
  public void setTriggerHTTPErrorCodes(int[] triggerHTTPErrorCodes) {
          this.triggerHTTPErrorCodes = triggerHTTPErrorCodes;
  }

  private boolean containsErrorCode(String errorCode,
                                    com.ebay.soap.eBLBaseComponents.ErrorType[] errors)
  {
    for(int i = 0; i < errors.length; i++ )
    {
      String errCode = errors[i].getErrorCode();
      if( errCode != null && errCode.equals(errorCode) )
        return true;
    }
    return false;
  }

  private boolean containsException(java.lang.Class[] exceptionList, java.lang.Class exception)
  {
    for(int i = 0; i < exceptionList.length; i++ )
    {
      if( exceptionList[i].getName().equals(exception.getName()) )
        return true;
    }
    return false;
  }

  private boolean containsInt(int[] exceptionList, int code)
  {
    for(int i = 0; i < exceptionList.length; i++ )
    {
      if( exceptionList[i] == code )
        return true;
    }
    return false;
  }

  /**
   * Determines if the exception matches the filter.
   * @param exception The Exception to be matched.
   * @return true indicates the exception matches the filter.
   */
  public boolean matches(Exception exception)
  {
    if ( exception == null )
      return false;

    if( this.triggerExceptions == null )
    {
      if( this.triggerApiErrorCodes == null && this.triggerHTTPErrorCodes == null )
        return true;
    }
    else
    {
      if( containsException(this.triggerExceptions, exception.getClass()) )
        return true;
    }

    if( this.triggerApiErrorCodes != null )
    {
      com.ebay.soap.eBLBaseComponents.ErrorType[] apiErrors = null;
      if( exception instanceof com.ebay.sdk.ApiException)
      {
        ApiException ae = (ApiException) exception;
        apiErrors = ae.getErrors();
      }
      else if( exception instanceof com.ebay.sdk.SdkSoapException )
      {
        com.ebay.sdk.SdkSoapException se = (com.ebay.sdk.SdkSoapException)exception;
        apiErrors = new ErrorType[1];
        apiErrors[0] = se.getErrorType();
      }

      if( apiErrors != null )
      {
        for (int i = 0; i < this.triggerApiErrorCodes.length; i++) {
          if (containsErrorCode(triggerApiErrorCodes[i], apiErrors))
            return true;
        }
      }
    }
    if ( this.triggerHTTPErrorCodes != null && exception instanceof SdkHTTPException ) {
    	SdkHTTPException se = (SdkHTTPException)exception;
    	if (containsInt(this.triggerHTTPErrorCodes, se.getErrorCode()))
    		return true;
    }

    return false;
  }

}
