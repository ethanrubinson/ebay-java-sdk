/*
Copyright (c) 2013 eBay, Inc.
This program is licensed under the terms of the eBay Common Development and
Distribution License (CDDL) Version 1.0 (the "License") and any subsequent  version 
thereof released by eBay.  The then-current version of the License can be found 
at http://www.opensource.org/licenses/cddl1.php and in the eBaySDKLicense file that 
is under the eBay SDK ../docs directory.
*/

package com.ebay.sdk;

import javax.xml.soap.SOAPFault;
import javax.xml.ws.soap.SOAPFaultException;

import com.ebay.sdk.util.*;
import com.ebay.soap.eBLBaseComponents.*;

/**
 * Wraps SOAP exception (SOAPFaultException) for SDK.
 * It exatracts an ErrorType object from the SOAPFaultException.
 * <br>
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: eBay Inc.</p>
 * @author weijun.li & william.yang
 * @version 1.0
 */
public class SdkSoapException extends SdkException {

  private com.ebay.soap.eBLBaseComponents.ErrorType errorType;

  /**
   * Create an instance of SdkSoapException object from SOAPFaultException.
   * @param sfe SOAPFaultException
   * @return SdkSoapException
   */
  static public SdkSoapException fromSOAPFaultException(SOAPFaultException sfe)
  {
    ErrorType errorType = new ErrorType();
    SOAPFault sf = sfe.getFault();
    errorType.setShortMessage(sf.getFaultString());

    org.w3c.dom.Element elem = sf.getDetail();
    if (elem != null)
    {
      try {
        String s = XmlUtil.getChildString(elem, "//Severity");
        if (s != null && s.length() > 0)
          errorType.setSeverityCode(SeverityCodeType.fromValue(s));

        s = XmlUtil.getChildString(elem, "//ErrorCode");
        if (s != null && s.length() > 0)
          errorType.setErrorCode(s);

        s = XmlUtil.getChildString(elem, "//DetailedMessage");
        if (s != null && s.length() > 0)
          errorType.setLongMessage(s);
      } catch(Exception e) {
      }
    }

    return new SdkSoapException(errorType, sfe);
  }

  /**
   * Constructor.
   * @param errorType ErrorType
   * @param innerException Exception
   */
  protected SdkSoapException(com.ebay.soap.eBLBaseComponents.ErrorType errorType, Exception innerException) {
    super(innerException);
    this.errorType = errorType;
  }

  /**
   * Gets the associated ErrorType object.
   * @return ErrorType
   */
  public com.ebay.soap.eBLBaseComponents.ErrorType getErrorType() {
    return this.errorType;
  }

  /**
   * Sets the associated ErrorType object.
   * @param errorType ErrorType
   */
  public void setErrorType(com.ebay.soap.eBLBaseComponents.ErrorType errorType) {
    this.errorType = errorType;
  }

  /**
   * Overrides Exception.GetMessage() to return short message if there's one.
   * @return String
   */
  public String getMessage() {
    String txt;

    txt = this.errorType.getLongMessage();
    if( txt != null )
      return txt;

    txt = this.errorType.getShortMessage();
    if( txt != null )
      return txt;

    return this.errorType.getErrorCode().toString();
  }
  public boolean containsErrorCode(String errorCode)
  {
    if (this.errorType.getErrorCode().toString().equals(errorCode) )
      return true;
    else
      return false;
  }
}
