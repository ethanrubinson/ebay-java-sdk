/*
Copyright (c) 2013 eBay, Inc.
This program is licensed under the terms of the eBay Common Development and
Distribution License (CDDL) Version 1.0 (the "License") and any subsequent  version 
thereof released by eBay.  The then-current version of the License can be found 
at http://www.opensource.org/licenses/cddl1.php and in the eBaySDKLicense file that 
is under the eBay SDK ../docs directory.
*/

package com.ebay.sdk.call;


import com.ebay.sdk.*;
import com.ebay.soap.eBLBaseComponents.*;
/**
 * Wrapper class of the DeleteMyMessages call of eBay SOAP API.
 * <br>
 * <p>Title: SOAP API wrapper library.</p>
 * <p>Description: Contains wrapper classes for eBay SOAP APIs.</p>
 * <p>Copyright: Copyright (c) 2009</p>
 * <p>Company: eBay Inc.</p>
 * <br> <B>Input property:</B> <code>AlertIDs</code> - This field is deprecated.
 * <br> <B>Input property:</B> <code>MessageIDs</code> - Contains a list of up to 10 <b>MessageID</b> values.
 * 
 * @author Ron Murphy
 * @version 1.0
 */

public class DeleteMyMessagesCall extends com.ebay.sdk.ApiCall
{
  
  private String[] alertIDs = null;
  private String[] messageIDs = null;


  /**
   * Constructor.
   */
  public DeleteMyMessagesCall() {
  }

  /**
   * Constructor.
   * @param apiContext The ApiContext object to be used to make the call.
   */
  public DeleteMyMessagesCall(ApiContext apiContext) {
    super(apiContext);
    

  }

  /**
   * Removes selected messages for a given user.
   * 
   * <br>
   * @throws ApiException
   * @throws SdkException
   * @throws Exception
   * @return The void object.
   */
  public void deleteMyMessages()
      throws com.ebay.sdk.ApiException, com.ebay.sdk.SdkException, java.lang.Exception
  {
    DeleteMyMessagesRequestType req;
    req = new DeleteMyMessagesRequestType();
    if (this.alertIDs != null)
    {
      MyMessagesAlertIDArrayType ary = new MyMessagesAlertIDArrayType();
      ary.setAlertID(this.alertIDs);
      req.setAlertIDs(ary);
    }
    if (this.messageIDs != null)
    {
      MyMessagesMessageIDArrayType ary = new MyMessagesMessageIDArrayType();
      ary.setMessageID(this.messageIDs);
      req.setMessageIDs(ary);
    }

    DeleteMyMessagesResponseType resp = (DeleteMyMessagesResponseType) execute(req);


  }

  /**
   * Gets the DeleteMyMessagesRequestType.alertIDs.
   * @return String[]
   */
  public String[] getAlertIDs()
  {
    return this.alertIDs;
  }

  /**
   * Sets the DeleteMyMessagesRequestType.alertIDs.
   * @param alertIDs String[]
   */
  public void setAlertIDs(String[] alertIDs)
  {
    this.alertIDs = alertIDs;
  }

  /**
   * Gets the DeleteMyMessagesRequestType.messageIDs.
   * @return String[]
   */
  public String[] getMessageIDs()
  {
    return this.messageIDs;
  }

  /**
   * Sets the DeleteMyMessagesRequestType.messageIDs.
   * @param messageIDs String[]
   */
  public void setMessageIDs(String[] messageIDs)
  {
    this.messageIDs = messageIDs;
  }

}

