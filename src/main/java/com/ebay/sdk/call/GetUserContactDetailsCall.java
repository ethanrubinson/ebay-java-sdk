/*
Copyright (c) 2013 eBay, Inc.
This program is licensed under the terms of the eBay Common Development and
Distribution License (CDDL) Version 1.0 (the "License") and any subsequent  version 
thereof released by eBay.  The then-current version of the License can be found 
at http://www.opensource.org/licenses/cddl1.php and in the eBaySDKLicense file that 
is under the eBay SDK ../docs directory.
*/

package com.ebay.sdk.call;

import java.lang.String;
import java.util.Calendar;

import com.ebay.sdk.*;
import com.ebay.soap.eBLBaseComponents.*;
/**
 * Wrapper class of the GetUserContactDetails call of eBay SOAP API.
 * <br>
 * <p>Title: SOAP API wrapper library.</p>
 * <p>Description: Contains wrapper classes for eBay SOAP APIs.</p>
 * <p>Copyright: Copyright (c) 2009</p>
 * <p>Company: eBay Inc.</p>
 * <br> <B>Input property:</B> <code>ItemID</code> - A unique identifier for the eBay listing that the caller and order partner have in common.
 * <br> <B>Input property:</B> <code>ContactID</code> - An eBay user ID that uniquely identifies a given user for whom the caller is seeking information. Either a seller's or bidder's/buyer's user ID can be specified here, as long as an bidding/order relationship exists between the requester and the user specified by this field. That is, a bidder must be bidding on the seller's active auction item, or a prospective buyer has proposed a Best Offer on a listing.
 * <br> <B>Input property:</B> <code>RequesterID</code> - An eBay user ID that uniquely identifies the person who is making the call. Either a seller's or bidder's/buyer's user ID can be specified here, as long as a bidding/order relationship exists between the requester and the user for whom information is being requested.
 * <br> <B>Output property:</B> <code>ReturnedUserID</code> - An eBay ID that uniquely identifies the given user whose information is given in the call response.
 * <br> <B>Output property:</B> <code>ReturnedContactAddress</code> - Contact information for the requested contact.
 * Note that the email address is NOT returned.
 * <br> <B>Output property:</B> <code>ReturnedRegistrationDate</code> - The date and time that the requested contact
 * registered with eBay.
 * 
 * @author Ron Murphy
 * @version 1.0
 */

public class GetUserContactDetailsCall extends com.ebay.sdk.ApiCall
{
  
  private String itemID = null;
  private String contactID = null;
  private String requesterID = null;
  private String returnedUserID=null;
  private AddressType returnedContactAddress=null;
  private Calendar returnedRegistrationDate=null;


  /**
   * Constructor.
   */
  public GetUserContactDetailsCall() {
  }

  /**
   * Constructor.
   * @param apiContext The ApiContext object to be used to make the call.
   */
  public GetUserContactDetailsCall(ApiContext apiContext) {
    super(apiContext);
    

  }

  /**
   * This call is used to retrieve contact information for a specified eBay user, given that a bidding relationship (as either a buyer or seller) exists between the caller and the user.
   * 
   * <br>
   * @throws ApiException
   * @throws SdkException
   * @throws Exception
   * @return The String object.
   */
  public String getUserContactDetails()
      throws com.ebay.sdk.ApiException, com.ebay.sdk.SdkException, java.lang.Exception
  {
    GetUserContactDetailsRequestType req;
    req = new GetUserContactDetailsRequestType();
    if (this.itemID != null)
      req.setItemID(this.itemID);
    if (this.contactID != null)
      req.setContactID(this.contactID);
    if (this.requesterID != null)
      req.setRequesterID(this.requesterID);

    GetUserContactDetailsResponseType resp = (GetUserContactDetailsResponseType) execute(req);

    this.returnedUserID = resp.getUserID();
    this.returnedContactAddress = resp.getContactAddress();
    this.returnedRegistrationDate = resp.getRegistrationDate();
    return this.getReturnedUserID();
  }

  /**
   * Gets the GetUserContactDetailsRequestType.contactID.
   * @return String
   */
  public String getContactID()
  {
    return this.contactID;
  }

  /**
   * Sets the GetUserContactDetailsRequestType.contactID.
   * @param contactID String
   */
  public void setContactID(String contactID)
  {
    this.contactID = contactID;
  }

  /**
   * Gets the GetUserContactDetailsRequestType.itemID.
   * @return String
   */
  public String getItemID()
  {
    return this.itemID;
  }

  /**
   * Sets the GetUserContactDetailsRequestType.itemID.
   * @param itemID String
   */
  public void setItemID(String itemID)
  {
    this.itemID = itemID;
  }

  /**
   * Gets the GetUserContactDetailsRequestType.requesterID.
   * @return String
   */
  public String getRequesterID()
  {
    return this.requesterID;
  }

  /**
   * Sets the GetUserContactDetailsRequestType.requesterID.
   * @param requesterID String
   */
  public void setRequesterID(String requesterID)
  {
    this.requesterID = requesterID;
  }

  /**
   * Valid after executing the API.
   * Gets the returned GetUserContactDetailsResponseType.returnedContactAddress.
   * 
   * @return AddressType
   */
  public AddressType getReturnedContactAddress()
  {
    return this.returnedContactAddress;
  }

  /**
   * Valid after executing the API.
   * Gets the returned GetUserContactDetailsResponseType.returnedRegistrationDate.
   * 
   * @return Calendar
   */
  public Calendar getReturnedRegistrationDate()
  {
    return this.returnedRegistrationDate;
  }

  /**
   * Valid after executing the API.
   * Gets the returned GetUserContactDetailsResponseType.returnedUserID.
   * 
   * @return String
   */
  public String getReturnedUserID()
  {
    return this.returnedUserID;
  }

}

