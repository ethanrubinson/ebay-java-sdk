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
 * Wrapper class of the VerifyAddSecondChanceItem call of eBay SOAP API.
 * <br>
 * <p>Title: SOAP API wrapper library.</p>
 * <p>Description: Contains wrapper classes for eBay SOAP APIs.</p>
 * <p>Copyright: Copyright (c) 2009</p>
 * <p>Company: eBay Inc.</p>
 * <br> <B>Input property:</B> <code>RecipientBidderUserID</code> - Specifies the bidder from the original, ended listing to whom the seller
 * is extending the second chance offer. Specify only one
 * <b>RecipientBidderUserID</b> per call. If multiple users are specified (each in a
 * <b>RecipientBidderUserID</b> node), only the last one specified receives the
 * offer.
 * <br> <B>Input property:</B> <code>BuyItNowPrice</code> - Specifies the amount the offer recipient must pay to purchase the item
 * from the Second Chance Offer listing. Use only when the original item was
 * an eBay Motors (or in some categories on U.S. and international sites for
 * high-priced items, such as items in many U.S. and Canada Business and
 * Industrial categories) and it ended unsold because the reserve price was
 * not met. Call fails with an error for any other item conditions.
 * <br> <B>Input property:</B> <code>Duration</code> - Specifies the length of time the Second Chance Offer listing will be
 * active. The recipient bidder has that much time to purchase the item or
 * the listing expires.
 * <br> <B>Input property:</B> <code>ItemID</code> - This field is used to identify the recently-ended auction listing for which a Second Chance Offer will be made to one of the non-winning bidders on the recently-ended auction listing.
 * <br> <B>Input property:</B> <code>SellerMessage</code> - Message content. Cannot contain HTML, asterisks, or quotes. This content
 * is included in the Second Chance Offer email sent to the recipient, which
 * can be retrieved with <b>GetMyMessages</b>.
 * <br> <B>Output property:</B> <code>ReturnedStartTime</code> - Indicates the date and time when the the new
 * Second Chance Offer listing became active and
 * the recipient user could purchase the item.
 * <br> <B>Output property:</B> <code>ReturnedEndTime</code> - Indicates the date and time when the Second Chance Offer listing expires, at which time
 * the listing ends (if the recipient user does
 * not purchase the item first).
 * 
 * @author Ron Murphy
 * @version 1.0
 */

public class VerifyAddSecondChanceItemCall extends com.ebay.sdk.ApiCall
{
  
  private String recipientBidderUserID = null;
  private AmountType buyItNowPrice = null;
  private SecondChanceOfferDurationCodeType duration = null;
  private String itemID = null;
  private String sellerMessage = null;
  private Calendar returnedStartTime=null;
  private Calendar returnedEndTime=null;


  /**
   * Constructor.
   */
  public VerifyAddSecondChanceItemCall() {
  }

  /**
   * Constructor.
   * @param apiContext The ApiContext object to be used to make the call.
   */
  public VerifyAddSecondChanceItemCall(ApiContext apiContext) {
    super(apiContext);
    

  }

  /**
   * Simulates the creation of a new Second Chance Offer
   * listing of an item without actually creating a listing.
   * 
   * <br>
   * @throws ApiException
   * @throws SdkException
   * @throws Exception
   * @return The VerifyAddSecondChanceItemResponseType object.
   */
  public VerifyAddSecondChanceItemResponseType verifyAddSecondChanceItem()
      throws com.ebay.sdk.ApiException, com.ebay.sdk.SdkException, java.lang.Exception
  {
    VerifyAddSecondChanceItemRequestType req;
    req = new VerifyAddSecondChanceItemRequestType();
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

    VerifyAddSecondChanceItemResponseType resp = (VerifyAddSecondChanceItemResponseType) execute(req);

    this.returnedStartTime = resp.getStartTime();
    this.returnedEndTime = resp.getEndTime();
    return resp;
  }

  /**
   * Gets the VerifyAddSecondChanceItemRequestType.buyItNowPrice.
   * @return AmountType
   */
  public AmountType getBuyItNowPrice()
  {
    return this.buyItNowPrice;
  }

  /**
   * Sets the VerifyAddSecondChanceItemRequestType.buyItNowPrice.
   * @param buyItNowPrice AmountType
   */
  public void setBuyItNowPrice(AmountType buyItNowPrice)
  {
    this.buyItNowPrice = buyItNowPrice;
  }

  /**
   * Gets the VerifyAddSecondChanceItemRequestType.duration.
   * @return SecondChanceOfferDurationCodeType
   */
  public SecondChanceOfferDurationCodeType getDuration()
  {
    return this.duration;
  }

  /**
   * Sets the VerifyAddSecondChanceItemRequestType.duration.
   * @param duration SecondChanceOfferDurationCodeType
   */
  public void setDuration(SecondChanceOfferDurationCodeType duration)
  {
    this.duration = duration;
  }

  /**
   * Gets the VerifyAddSecondChanceItemRequestType.itemID.
   * @return String
   */
  public String getItemID()
  {
    return this.itemID;
  }

  /**
   * Sets the VerifyAddSecondChanceItemRequestType.itemID.
   * @param itemID String
   */
  public void setItemID(String itemID)
  {
    this.itemID = itemID;
  }

  /**
   * Gets the VerifyAddSecondChanceItemRequestType.recipientBidderUserID.
   * @return String
   */
  public String getRecipientBidderUserID()
  {
    return this.recipientBidderUserID;
  }

  /**
   * Sets the VerifyAddSecondChanceItemRequestType.recipientBidderUserID.
   * @param recipientBidderUserID String
   */
  public void setRecipientBidderUserID(String recipientBidderUserID)
  {
    this.recipientBidderUserID = recipientBidderUserID;
  }

  /**
   * Gets the VerifyAddSecondChanceItemRequestType.sellerMessage.
   * @return String
   */
  public String getSellerMessage()
  {
    return this.sellerMessage;
  }

  /**
   * Sets the VerifyAddSecondChanceItemRequestType.sellerMessage.
   * @param sellerMessage String
   */
  public void setSellerMessage(String sellerMessage)
  {
    this.sellerMessage = sellerMessage;
  }

  /**
   * Valid after executing the API.
   * Gets the returned VerifyAddSecondChanceItemResponseType.returnedEndTime.
   * 
   * @return Calendar
   */
  public Calendar getReturnedEndTime()
  {
    return this.returnedEndTime;
  }

  /**
   * Valid after executing the API.
   * Gets the returned VerifyAddSecondChanceItemResponseType.returnedStartTime.
   * 
   * @return Calendar
   */
  public Calendar getReturnedStartTime()
  {
    return this.returnedStartTime;
  }

}

