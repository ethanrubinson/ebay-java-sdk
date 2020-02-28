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
 * Wrapper class of the AddSecondChanceItem call of eBay SOAP API.
 * <br>
 * <p>Title: SOAP API wrapper library.</p>
 * <p>Description: Contains wrapper classes for eBay SOAP APIs.</p>
 * <p>Copyright: Copyright (c) 2009</p>
 * <p>Company: eBay Inc.</p>
 * <br> <B>Input property:</B> <code>RecipientBidderUserID</code> - This field is used to specify the bidder that is being offered the Second Chance Offer. The eBay User ID of the bidder is used in this field. Specify only one <b>RecipientBidderUserID</b> per call. If multiple users are specified, only the last one specified receives the offer. User ID values will be returned in the <b>Offer.User.UserID</b> field of the <b>GetAllBidders</b> call response.
 * <br> <B>Input property:</B> <code>BuyItNowPrice</code> - The amount the offer recipient must pay to purchase the item as a Second Chance Offer. This field should only be used when the original item was listed in an eBay Motors vehicle category (or in some categories on U.S. and international sites for high-priced items, such as items in many U.S. and Canada Business and Industrial categories) and it ended unsold because the reserve price was not met. Otherwise, eBay establishes the price and no price should be submitted. The price offered to the Second Chance Offer recipient is generally the highest bid that the user made on the original listing.
 * <br> <B>Input property:</B> <code>Duration</code> - This enumeration value indicates the length of time (in days) that the Second Chance Offer will be available to the recipient. Upon receiving the Second Chance Offer, the recipient bidder will have this many days to accept the offer before the offer expires. One of the values in <b>SecondChanceOfferDurationCodeType</b> must be used.
 * <br> <B>Input property:</B> <code>ItemID</code> - This field is used to identify the original auction listing through its unique identifier (Item ID). Upon a successful call, the Second Chance Offer will be identified by a new <b>ItemID</b> in the response.
 * <br> <B>Input property:</B> <code>SellerMessage</code> - This optional field is used to provide a message to the recipient of the Second Chance Offer. This message cannot contain HTML, asterisks, or quotes. The content in this field will be included in the Second Chance Offer email that is sent to the recipient.
 * <br> <B>Output property:</B> <code>ReturnedItemID</code> - This field contains the Item ID for the Second Chance Offer that was just created with the <b>AddSecondChanceItem</b> call. Note that this Item ID will be different from the Item ID in the original auction listing that was passed in the request.
 * <br> <B>Output property:</B> <code>ReturnedStartTime</code> - This timestamp indicates the date and time when the Second Chance Offer became available to the recipient.
 * <br> <B>Output property:</B> <code>ReturnedEndTime</code> - This timestamp indicates the date and time when the Second Chance Offer listing will expire, at which time the recipient will no longer be able to purchase the item.
 * 
 * @author Ron Murphy
 * @version 1.0
 */

public class AddSecondChanceItemCall extends com.ebay.sdk.ApiCall
{
  
  private String recipientBidderUserID = null;
  private AmountType buyItNowPrice = null;
  private SecondChanceOfferDurationCodeType duration = null;
  private String itemID = null;
  private String sellerMessage = null;
  private String returnedItemID=null;
  private Calendar returnedStartTime=null;
  private Calendar returnedEndTime=null;


  /**
   * Constructor.
   */
  public AddSecondChanceItemCall() {
  }

  /**
   * Constructor.
   * @param apiContext The ApiContext object to be used to make the call.
   */
  public AddSecondChanceItemCall(ApiContext apiContext) {
    super(apiContext);
    

  }

  /**
   * Used by the seller of an auction listing to provide a Second Chance Offer to one of that auction item's non-winning bidders. A Second Chance Offer is used by sellers whenever the seller was unable to complete the sale with the winning bidder because the bidder didn't pay, or if the auction listing ended without the Reserve Price being met, or if that seller has multiple identical items for sale and wants to give other bidders a chance to purchase the item.
   * <br>
   * <br>
   * To get information on the bidders for a recently-ended auction listing, the seller can use the <b>GetAllBidders</b> call and pass the corresponding <b>ItemID</b> value into the call request.
   * <br>
   * <br>
   * For more information on the specifics of Second Chance Offers, see the <a href="https://pages.ebay.com/help/sell/second_chance_offer.html" target="_blank">Making a Second Chance Offer</a> help page.
   * 
   * <br>
   * @throws ApiException
   * @throws SdkException
   * @throws Exception
   * @return The String object.
   */
  public String addSecondChanceItem()
      throws com.ebay.sdk.ApiException, com.ebay.sdk.SdkException, java.lang.Exception
  {
    AddSecondChanceItemRequestType req;
    req = new AddSecondChanceItemRequestType();

    if( this.recipientBidderUserID == null )
      throw new SdkException("RecipientBidderUserID property is not set.");
    if( this.itemID == null )
      throw new SdkException("ItemID should be set to the original item ID that you want to make an offer for.");

    if (this.recipientBidderUserID != null)
      req.setRecipientBidderUserID(this.recipientBidderUserID);
    if (this.buyItNowPrice != null)
      req.setBuyItNowPrice(this.buyItNowPrice);
    if (this.duration != null)
      req.setDuration(this.duration);
    if (this.itemID != null)
      req.setItemID(this.itemID);
    if (this.sellerMessage != null)
      req.setSellerMessage(this.sellerMessage);

    AddSecondChanceItemResponseType resp = (AddSecondChanceItemResponseType) execute(req);

    this.returnedItemID = resp.getItemID();
    this.returnedStartTime = resp.getStartTime();
    this.returnedEndTime = resp.getEndTime();
    return this.getReturnedItemID();
  }

  /**
   * Gets the AddSecondChanceItemRequestType.buyItNowPrice.
   * @return AmountType
   */
  public AmountType getBuyItNowPrice()
  {
    return this.buyItNowPrice;
  }

  /**
   * Sets the AddSecondChanceItemRequestType.buyItNowPrice.
   * @param buyItNowPrice AmountType
   */
  public void setBuyItNowPrice(AmountType buyItNowPrice)
  {
    this.buyItNowPrice = buyItNowPrice;
  }

  /**
   * Gets the AddSecondChanceItemRequestType.duration.
   * @return SecondChanceOfferDurationCodeType
   */
  public SecondChanceOfferDurationCodeType getDuration()
  {
    return this.duration;
  }

  /**
   * Sets the AddSecondChanceItemRequestType.duration.
   * @param duration SecondChanceOfferDurationCodeType
   */
  public void setDuration(SecondChanceOfferDurationCodeType duration)
  {
    this.duration = duration;
  }

  /**
   * Gets the AddSecondChanceItemRequestType.itemID.
   * @return String
   */
  public String getItemID()
  {
    return this.itemID;
  }

  /**
   * Sets the AddSecondChanceItemRequestType.itemID.
   * @param itemID String
   */
  public void setItemID(String itemID)
  {
    this.itemID = itemID;
  }

  /**
   * Gets the AddSecondChanceItemRequestType.recipientBidderUserID.
   * @return String
   */
  public String getRecipientBidderUserID()
  {
    return this.recipientBidderUserID;
  }

  /**
   * Sets the AddSecondChanceItemRequestType.recipientBidderUserID.
   * @param recipientBidderUserID String
   */
  public void setRecipientBidderUserID(String recipientBidderUserID)
  {
    this.recipientBidderUserID = recipientBidderUserID;
  }

  /**
   * Gets the AddSecondChanceItemRequestType.sellerMessage.
   * @return String
   */
  public String getSellerMessage()
  {
    return this.sellerMessage;
  }

  /**
   * Sets the AddSecondChanceItemRequestType.sellerMessage.
   * @param sellerMessage String
   */
  public void setSellerMessage(String sellerMessage)
  {
    this.sellerMessage = sellerMessage;
  }
/**
   * Executes VerifyAddSecondChanceItem API. This call is used to evaluate
   * listing fees without actually making the second chance offer.
   * @throws ApiException
   * @throws SdkException
   * @throws Exception
   * @return FeesType
   */
  public void verifyAddSecondChanceItem() throws com.ebay.sdk.ApiException,
     com.ebay.sdk.SdkException, java.lang.Exception
  {
    VerifyAddSecondChanceItemRequestType req = new VerifyAddSecondChanceItemRequestType();

    if( this.recipientBidderUserID == null )
      throw new SdkException("RecipientBidderUserID is not set.");
    req.setRecipientBidderUserID(this.recipientBidderUserID);

    if( this.itemID == null )
      throw new SdkException("ItemID should be set to the original item ID that you want to make offer for.");
    req.setItemID(this.itemID);

    if (null != this.sellerMessage)
    {
    	req.setSellerMessage(this.sellerMessage);
    }

    if( this.buyItNowPrice != null )
      req.setBuyItNowPrice(this.buyItNowPrice);
      
    if( this.duration != null )
      req.setDuration(this.duration);

    // Executes the API.
    VerifyAddSecondChanceItemResponseType resp = (VerifyAddSecondChanceItemResponseType)this.execute(req);
    
  }




  /**
   * Valid after executing the API.
   * Gets the returned AddSecondChanceItemResponseType.returnedEndTime.
   * 
   * @return Calendar
   */
  public Calendar getReturnedEndTime()
  {
    return this.returnedEndTime;
  }

  /**
   * Valid after executing the API.
   * Gets the returned AddSecondChanceItemResponseType.returnedItemID.
   * 
   * @return String
   */
  public String getReturnedItemID()
  {
    return this.returnedItemID;
  }

  /**
   * Valid after executing the API.
   * Gets the returned AddSecondChanceItemResponseType.returnedStartTime.
   * 
   * @return Calendar
   */
  public Calendar getReturnedStartTime()
  {
    return this.returnedStartTime;
  }

}

