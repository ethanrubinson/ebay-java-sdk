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
 * Wrapper class of the AddMemberMessageAAQToPartner call of eBay SOAP API.
 * <br>
 * <p>Title: SOAP API wrapper library.</p>
 * <p>Description: Contains wrapper classes for eBay SOAP APIs.</p>
 * <p>Copyright: Copyright (c) 2009</p>
 * <p>Company: eBay Inc.</p>
 * <br> <B>Input property:</B> <code>ItemID</code> - Unique identifier for the listing that is being discussed between the two order partners.
 * <br> <B>Input property:</B> <code>MemberMessage</code> - This container holds the message, and includes the subject, message body, and other details related to the message.
 * 
 * @author Ron Murphy
 * @version 1.0
 */

public class AddMemberMessageAAQToPartnerCall extends com.ebay.sdk.ApiCall
{
  
  private String itemID = null;
  private MemberMessageType memberMessage = null;


  /**
   * Constructor.
   */
  public AddMemberMessageAAQToPartnerCall() {
  }

  /**
   * Constructor.
   * @param apiContext The ApiContext object to be used to make the call.
   */
  public AddMemberMessageAAQToPartnerCall(ApiContext apiContext) {
    super(apiContext);
    

  }

  /**
   * Enables a buyer and seller in an order relationship to
   * send messages to each other's My Messages Inboxes.
   * 
   * <br>
   * @throws ApiException
   * @throws SdkException
   * @throws Exception
   * @return The void object.
   */
  public void addMemberMessageAAQToPartner()
      throws com.ebay.sdk.ApiException, com.ebay.sdk.SdkException, java.lang.Exception
  {
    AddMemberMessageAAQToPartnerRequestType req;
    req = new AddMemberMessageAAQToPartnerRequestType();
    if (this.itemID != null)
      req.setItemID(this.itemID);
    if (this.memberMessage != null)
      req.setMemberMessage(this.memberMessage);

    AddMemberMessageAAQToPartnerResponseType resp = (AddMemberMessageAAQToPartnerResponseType) execute(req);


  }

  /**
   * Gets the AddMemberMessageAAQToPartnerRequestType.itemID.
   * @return String
   */
  public String getItemID()
  {
    return this.itemID;
  }

  /**
   * Sets the AddMemberMessageAAQToPartnerRequestType.itemID.
   * @param itemID String
   */
  public void setItemID(String itemID)
  {
    this.itemID = itemID;
  }

  /**
   * Gets the AddMemberMessageAAQToPartnerRequestType.memberMessage.
   * @return MemberMessageType
   */
  public MemberMessageType getMemberMessage()
  {
    return this.memberMessage;
  }

  /**
   * Sets the AddMemberMessageAAQToPartnerRequestType.memberMessage.
   * @param memberMessage MemberMessageType
   */
  public void setMemberMessage(MemberMessageType memberMessage)
  {
    this.memberMessage = memberMessage;
  }

}

