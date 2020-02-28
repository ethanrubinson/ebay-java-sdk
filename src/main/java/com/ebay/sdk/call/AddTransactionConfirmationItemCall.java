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
 * Wrapper class of the AddTransactionConfirmationItem call of eBay SOAP API.
 * <br>
 * <p>Title: SOAP API wrapper library.</p>
 * <p>Description: Contains wrapper classes for eBay SOAP APIs.</p>
 * <p>Copyright: Copyright (c) 2009</p>
 * <p>Company: eBay Inc.</p>
 * <br> <B>Input property:</B> <code>RecipientUserID</code> - This field is used to specify the recipient of the Transaction
 * Confirmation Request (TCR).
 * <br> <B>Input property:</B> <code>VerifyEligibilityOnly</code> - This field is included and set to <code>true</code> if the seller wants to verify whether or not a new Transaction
 * Confirmation Request (TCR) can be created for the item. If this field is included and its value set to <code>true</code>, no TCR is actually created. If this field is included and its value set to <code>false</code>, or if it is omitted, a Transaction
 * Confirmation Request is actually created.
 * <br> <B>Input property:</B> <code>RecipientPostalCode</code> - This field is used to specify the postal code of the user to whom the seller is offering the Transaction Confirmation Request. This field is only required if the user does not meet the other options listed in <b>RecipientRelationCodeType</b>.
 * <br> <B>Input property:</B> <code>RecipientRelationType</code> - The enumeration value supplied in this field specifies the current relationship between the seller and the potential buyer. A Transaction Confirmation Request (TCR) for an item can be sent to a potential buyer who has at least one of the following criteria: is an active bidder on the auction listing; has made a Best Offer on the fixed-price listing, is an eBay user who has used the Ask Seller a Question feature, or is an eBay user whose postal code is known.
 * <br> <B>Input property:</B> <code>NegotiatedPrice</code> - The amount in this field is the price that the seller is asking for to purchase the motor vehicle.
 * <br> <B>Input property:</B> <code>ListingDuration</code> - The enumeration value specified in this field will control how many days that the recipient of the offer has to purchase the motor vehicle at the price listed in the <b>NegotiatedPrice</b> field.
 * <br> <B>Input property:</B> <code>ItemID</code> - This field is used to identify the eBay Motors listing using the unique identifier of the listing (<b>ItemID</b>).
 * <br> <B>Input property:</B> <code>Comments</code> - This is optional free-form string field that can be used by the seller to provide any comments or additional information about the Transaction Confirmation Item.
 * <br> <B>Output property:</B> <code>ReturnedItemID</code> - This field contains the Item ID associated with the Transaction Confirmation Item that was just created with the <b>AddTransactionConfirmationItem</b> call. This field is not returned if the request was only used to verify that a new TCR could be created.
 * <br> <B>Output property:</B> <code>ReturnedStartTime</code> - This timestamp indicates the date and time when the Transaction Confirmation Item became available to the recipient.
 * <br> <B>Output property:</B> <code>ReturnedEndTime</code> - This timestamp indicates the date and time when the Transaction Confirmation Item will no longer be available for purchase.
 * 
 * @author Ron Murphy
 * @version 1.0
 */

public class AddTransactionConfirmationItemCall extends com.ebay.sdk.ApiCall
{
  
  private String recipientUserID = null;
  private String verifyEligibilityOnly = null;
  private String recipientPostalCode = null;
  private String recipientRelationType = null;
  private AmountType negotiatedPrice = null;
  private SecondChanceOfferDurationCodeType listingDuration = null;
  private String itemID = null;
  private String comments = null;
  private String returnedItemID=null;
  private Calendar returnedStartTime=null;
  private Calendar returnedEndTime=null;


  /**
   * Constructor.
   */
  public AddTransactionConfirmationItemCall() {
  }

  /**
   * Constructor.
   * @param apiContext The ApiContext object to be used to make the call.
   */
  public AddTransactionConfirmationItemCall(ApiContext apiContext) {
    super(apiContext);
    

  }

  /**
   * Base request of the <b>AddTransactionConfirmationItem</b> call, which is used to end an eBay Motors listing and creates a new Transaction Confirmation Request (TCR) for the motor vehichle, thus enabling the TCR recipient to purchase the item. You can also use this call to see if a new TCR can be created for the specified item.
   * 
   * <br>
   * @throws ApiException
   * @throws SdkException
   * @throws Exception
   * @return The String object.
   */
  public String addTransactionConfirmationItem()
      throws com.ebay.sdk.ApiException, com.ebay.sdk.SdkException, java.lang.Exception
  {
    AddTransactionConfirmationItemRequestType req;
    req = new AddTransactionConfirmationItemRequestType();
    if (this.recipientUserID != null)
      req.setRecipientUserID(this.recipientUserID);
    if (this.verifyEligibilityOnly != null)
      req.setVerifyEligibilityOnly(this.verifyEligibilityOnly);
    if (this.recipientPostalCode != null)
      req.setRecipientPostalCode(this.recipientPostalCode);
    if (this.recipientRelationType != null)
      req.setRecipientRelationType(this.recipientRelationType);
    if (this.negotiatedPrice != null)
      req.setNegotiatedPrice(this.negotiatedPrice);
    if (this.listingDuration != null)
      req.setListingDuration(this.listingDuration);
    if (this.itemID != null)
      req.setItemID(this.itemID);
    if (this.comments != null)
      req.setComments(this.comments);

    AddTransactionConfirmationItemResponseType resp = (AddTransactionConfirmationItemResponseType) execute(req);

    this.returnedItemID = resp.getItemID();
    this.returnedStartTime = resp.getStartTime();
    this.returnedEndTime = resp.getEndTime();
    return this.getReturnedItemID();
  }

  /**
   * Gets the AddTransactionConfirmationItemRequestType.comments.
   * @return String
   */
  public String getComments()
  {
    return this.comments;
  }

  /**
   * Sets the AddTransactionConfirmationItemRequestType.comments.
   * @param comments String
   */
  public void setComments(String comments)
  {
    this.comments = comments;
  }

  /**
   * Gets the AddTransactionConfirmationItemRequestType.itemID.
   * @return String
   */
  public String getItemID()
  {
    return this.itemID;
  }

  /**
   * Sets the AddTransactionConfirmationItemRequestType.itemID.
   * @param itemID String
   */
  public void setItemID(String itemID)
  {
    this.itemID = itemID;
  }

  /**
   * Gets the AddTransactionConfirmationItemRequestType.listingDuration.
   * @return SecondChanceOfferDurationCodeType
   */
  public SecondChanceOfferDurationCodeType getListingDuration()
  {
    return this.listingDuration;
  }

  /**
   * Sets the AddTransactionConfirmationItemRequestType.listingDuration.
   * @param listingDuration SecondChanceOfferDurationCodeType
   */
  public void setListingDuration(SecondChanceOfferDurationCodeType listingDuration)
  {
    this.listingDuration = listingDuration;
  }

  /**
   * Gets the AddTransactionConfirmationItemRequestType.negotiatedPrice.
   * @return AmountType
   */
  public AmountType getNegotiatedPrice()
  {
    return this.negotiatedPrice;
  }

  /**
   * Sets the AddTransactionConfirmationItemRequestType.negotiatedPrice.
   * @param negotiatedPrice AmountType
   */
  public void setNegotiatedPrice(AmountType negotiatedPrice)
  {
    this.negotiatedPrice = negotiatedPrice;
  }

  /**
   * Gets the AddTransactionConfirmationItemRequestType.recipientPostalCode.
   * @return String
   */
  public String getRecipientPostalCode()
  {
    return this.recipientPostalCode;
  }

  /**
   * Sets the AddTransactionConfirmationItemRequestType.recipientPostalCode.
   * @param recipientPostalCode String
   */
  public void setRecipientPostalCode(String recipientPostalCode)
  {
    this.recipientPostalCode = recipientPostalCode;
  }

  /**
   * Gets the AddTransactionConfirmationItemRequestType.recipientRelationType.
   * @return String
   */
  public String getRecipientRelationType()
  {
    return this.recipientRelationType;
  }

  /**
   * Sets the AddTransactionConfirmationItemRequestType.recipientRelationType.
   * @param recipientRelationType String
   */
  public void setRecipientRelationType(String recipientRelationType)
  {
    this.recipientRelationType = recipientRelationType;
  }

  /**
   * Gets the AddTransactionConfirmationItemRequestType.recipientUserID.
   * @return String
   */
  public String getRecipientUserID()
  {
    return this.recipientUserID;
  }

  /**
   * Sets the AddTransactionConfirmationItemRequestType.recipientUserID.
   * @param recipientUserID String
   */
  public void setRecipientUserID(String recipientUserID)
  {
    this.recipientUserID = recipientUserID;
  }

  /**
   * Gets the AddTransactionConfirmationItemRequestType.verifyEligibilityOnly.
   * @return String
   */
  public String getVerifyEligibilityOnly()
  {
    return this.verifyEligibilityOnly;
  }

  /**
   * Sets the AddTransactionConfirmationItemRequestType.verifyEligibilityOnly.
   * @param verifyEligibilityOnly String
   */
  public void setVerifyEligibilityOnly(String verifyEligibilityOnly)
  {
    this.verifyEligibilityOnly = verifyEligibilityOnly;
  }

  /**
   * Valid after executing the API.
   * Gets the returned AddTransactionConfirmationItemResponseType.returnedEndTime.
   * 
   * @return Calendar
   */
  public Calendar getReturnedEndTime()
  {
    return this.returnedEndTime;
  }

  /**
   * Valid after executing the API.
   * Gets the returned AddTransactionConfirmationItemResponseType.returnedItemID.
   * 
   * @return String
   */
  public String getReturnedItemID()
  {
    return this.returnedItemID;
  }

  /**
   * Valid after executing the API.
   * Gets the returned AddTransactionConfirmationItemResponseType.returnedStartTime.
   * 
   * @return Calendar
   */
  public Calendar getReturnedStartTime()
  {
    return this.returnedStartTime;
  }

}

