/*
Copyright (c) 2013 eBay, Inc.
This program is licensed under the terms of the eBay Common Development and
Distribution License (CDDL) Version 1.0 (the "License") and any subsequent  version 
thereof released by eBay.  The then-current version of the License can be found 
at http://www.opensource.org/licenses/cddl1.php and in the eBaySDKLicense file that 
is under the eBay SDK ../docs directory.
*/

package com.ebay.sdk.call;

import java.lang.Boolean;
import java.lang.String;

import com.ebay.sdk.*;
import com.ebay.soap.eBLBaseComponents.*;
/**
 * Wrapper class of the LeaveFeedback call of eBay SOAP API.
 * <br>
 * <p>Title: SOAP API wrapper library.</p>
 * <p>Description: Contains wrapper classes for eBay SOAP APIs.</p>
 * <p>Copyright: Copyright (c) 2009</p>
 * <p>Company: eBay Inc.</p>
 * <br> <B>Input property:</B> <code>FeedbackDetail</code> - Helper wrapper to set LeaveFeedbackRequestType CommentText, CommentType, ItemID:
 * CommentText sets LeaveFeedbackRequestType.CommentText: 
 * Textual comment that explains, clarifies, or justifies the feedback
 * score specified in <b>CommentType</b>.
 * <br>
 * CommentType sets LeaveFeedbackRequestType.CommentType: 
 * Score for the Feedback being left. May be Positive, Neutral, or Negative.
 * <br><br>
 * <span class="tablenote"><b>Note:</b>
 * Sellers can not leave neutral or negative feedback for buyers. In addition, buyers can not leave neutral or negative feedback within 7 days from the completion of the order for active Power Sellers who have been on eBay for 12 months.
 * </span>
 * ItemID sets LeaveFeedbackRequestType.ItemID: 
 * Unique identifier for an eBay listing. A listing can have multiple
 * order line items, but only one <b>ItemID</b>. Unless an
 * <b>OrderLineItemID</b> is specified in the <b>LeaveFeedback</b> request, the <b>ItemID</b> is
 * required along with the <b>TargetUser</b> to identify an order line item
 * existing between the caller and the <b>TargetUser</b> that requires feedback. A
 * Feedback comment will be posted for this order line item. If there are
 * multiple order line items between the two order partners that still
 * require feedback, the <b>TransactionID</b> will also be required to isolate the
 * targeted order line item. Feedback cannot be left for order line items
 * with creation dates more than 60 days in the past.
 * <br> <B>Input property:</B> <code>TransactionID</code> - Unique identifier for an eBay order line item. If there
 * are multiple order line items between the two order partners that still
 * require Feedback, the <b>TransactionID</b> is required along with the
 * corresponding <b>ItemID</b> and <b>TargetUser</b> to isolate the targeted order line
 * item. If an <b>OrderLineItemID</b> is included in the response to identify a
 * specific order line item, none of the preceding fields (<b>ItemID</b>,
 * <b>TransactionID</b>, <b>TargetUser</b>) are needed. Feedback cannot be left for order
 * line items with creation dates more than 60 days in the past.
 * <br> <B>Input property:</B> <code>TargetUser</code> - Specifies the recipient user about whom the Feedback is being left.
 * <br> <B>Input property:</B> <code>SellerItemRatingDetailArray</code> - Container for detailed seller ratings (DSRs). If a buyer is providing DSRs, they are specified in this container. Sellers have access to the number of ratings they've received, as well as to the averages of the DSRs they've received in each DSR area (i.e., to the average of ratings in the item-description area, etc.).
 * <br> <B>Input property:</B> <code>OrderLineItemID</code> - <b>OrderLineItemID</b> is a unique identifier for an eBay order line item. If an <b>OrderLineItemID</b> is included in
 * the request, the <b>ItemID</b>, <b>TransactionID</b>, and <b>TargetUser</b> fields are not
 * required. Feedback cannot be left for order line items with creation
 * dates more than 60 days in the past.
 * <br>
 * <br> <B>Input property:</B> <code>ItemArrivedWithinEDDType</code> - This field or the <b>ItemDeliveredWithinEDD</b> field should be included if it is the buyer leaving feedback for the seller. This field will inform eBay about whether or not the buyer received the order line item within the estimated delivery date, which is established once a buyer purchases or commits to buy an item.
 * <br>
 * <br>
 * <span class="tablenote"><b>Note:</b> A new "Late shipment rate" metric became a new component of Seller Standards beginning in February 2016. On-time shipping means that the seller shipped the item before the "handling time" expired and/or the item was received by the buyer within the estimated delivery date window, which is established once the buyer pays for the order line item. Previously, a seller's account could be dinged just for getting a low rating for the "shippping time" Detailed Seller Rating. </span>
 * <br> <B>Input property:</B> <code>ItemDeliveredWithinEDD</code> - This field or the <b>ItemArrivedWithinEDDType</b> field should be included if it is the buyer leaving feedback for the seller. This field will inform eBay about whether or not the buyer received the order line item within the estimated delivery date window, which is established once a buyer purchases or commits to buy an item. The value of this field is set to <code>true</code> if the item did arrive within the estimated delivery date, or <code>false</code> if the item arrived past the estimated delivery date.
 * <br>
 * <br>
 * <span class="tablenote"><b>Note:</b> A new "Late shipment rate" metric became a new component of Seller Standards beginning in February 2016. On-time shipping means that the seller shipped the item before the "handling time" expired and/or the item was received by the buyer within the estimated delivery date window, which is established once the buyer pays for the order line item. Previously, a seller's account could be dinged just for getting a low rating for the "shippping time" Detailed Seller Rating. </span>
 * <br> <B>Output property:</B> <code>ReturnedFeedbackID</code> - The unique identifier of the Feedback entry that has been submitted by the caller.
 * 
 * @author Ron Murphy
 * @version 1.0
 */

public class LeaveFeedbackCall extends com.ebay.sdk.ApiCall
{
  
  private FeedbackDetailType feedbackDetail = null;
  private String transactionID = null;
  private String targetUser = null;
  private ItemRatingDetailArrayType sellerItemRatingDetailArray = null;
  private String orderLineItemID = null;
  private ItemArrivedWithinEDDCodeType itemArrivedWithinEDDType = null;
  private Boolean itemDeliveredWithinEDD = null;
  private String returnedFeedbackID=null;


  /**
   * Constructor.
   */
  public LeaveFeedbackCall() {
  }

  /**
   * Constructor.
   * @param apiContext The ApiContext object to be used to make the call.
   */
  public LeaveFeedbackCall(ApiContext apiContext) {
    super(apiContext);
    

  }

  /**
   * Enables a buyer and seller to leave Feedback for their order partner at the
   * conclusion of a successful order.
   * 
   * <br>
   * @throws ApiException
   * @throws SdkException
   * @throws Exception
   * @return The void object.
   */
  public void leaveFeedback()
      throws com.ebay.sdk.ApiException, com.ebay.sdk.SdkException, java.lang.Exception
  {
    LeaveFeedbackRequestType req;
    req = new LeaveFeedbackRequestType();

    if( this.targetUser == null )
      throw new SdkException("TargetUser property is not set.");
    if( this.feedbackDetail == null )
      throw new SdkException("FeedbackDetail property is not set.");
    if( this.feedbackDetail.getItemID() == null )
      throw new SdkException("FeedbackDetail.getItemID() property is not set.");
    if( this.feedbackDetail.getCommentText() == null )
      throw new SdkException("FeedbackDetail.getCommentText() property is not set.");
    if( this.feedbackDetail.getCommentType() == null )
      throw new SdkException("FeedbackDetail.getCommentType() property is not set.");

    req.setDetailLevel(this.getDetailLevel());
    if (this.feedbackDetail != null)
    {
      req.setCommentText(this.feedbackDetail.getCommentText());
      req.setCommentType(this.feedbackDetail.getCommentType());
      req.setItemID(this.feedbackDetail.getItemID());
    }
    if (this.transactionID != null)
      req.setTransactionID(this.transactionID);
    if (this.targetUser != null)
      req.setTargetUser(this.targetUser);
    if (this.sellerItemRatingDetailArray != null)
      req.setSellerItemRatingDetailArray(this.sellerItemRatingDetailArray);
    if (this.orderLineItemID != null)
      req.setOrderLineItemID(this.orderLineItemID);
    if (this.itemArrivedWithinEDDType != null)
      req.setItemArrivedWithinEDDType(this.itemArrivedWithinEDDType);
    if (this.itemDeliveredWithinEDD != null)
      req.setItemDeliveredWithinEDD(this.itemDeliveredWithinEDD);

    LeaveFeedbackResponseType resp = (LeaveFeedbackResponseType) execute(req);

    this.returnedFeedbackID = resp.getFeedbackID();

  }

  /**
   * Gets the LeaveFeedbackRequestType.feedbackDetail.
   * @return FeedbackDetailType
   */
  public FeedbackDetailType getFeedbackDetail()
  {
    return this.feedbackDetail;
  }

  /**
   * Sets the LeaveFeedbackRequestType.feedbackDetail.
   * @param feedbackDetail FeedbackDetailType
   */
  public void setFeedbackDetail(FeedbackDetailType feedbackDetail)
  {
    this.feedbackDetail = feedbackDetail;
  }

  /**
   * Gets the LeaveFeedbackRequestType.itemArrivedWithinEDDType.
   * @return ItemArrivedWithinEDDCodeType
   */
  public ItemArrivedWithinEDDCodeType getItemArrivedWithinEDDType()
  {
    return this.itemArrivedWithinEDDType;
  }

  /**
   * Sets the LeaveFeedbackRequestType.itemArrivedWithinEDDType.
   * @param itemArrivedWithinEDDType ItemArrivedWithinEDDCodeType
   */
  public void setItemArrivedWithinEDDType(ItemArrivedWithinEDDCodeType itemArrivedWithinEDDType)
  {
    this.itemArrivedWithinEDDType = itemArrivedWithinEDDType;
  }

  /**
   * Gets the LeaveFeedbackRequestType.itemDeliveredWithinEDD.
   * @return Boolean
   */
  public Boolean getItemDeliveredWithinEDD()
  {
    return this.itemDeliveredWithinEDD;
  }

  /**
   * Sets the LeaveFeedbackRequestType.itemDeliveredWithinEDD.
   * @param itemDeliveredWithinEDD Boolean
   */
  public void setItemDeliveredWithinEDD(Boolean itemDeliveredWithinEDD)
  {
    this.itemDeliveredWithinEDD = itemDeliveredWithinEDD;
  }

  /**
   * Gets the LeaveFeedbackRequestType.orderLineItemID.
   * @return String
   */
  public String getOrderLineItemID()
  {
    return this.orderLineItemID;
  }

  /**
   * Sets the LeaveFeedbackRequestType.orderLineItemID.
   * @param orderLineItemID String
   */
  public void setOrderLineItemID(String orderLineItemID)
  {
    this.orderLineItemID = orderLineItemID;
  }

  /**
   * Gets the LeaveFeedbackRequestType.sellerItemRatingDetailArray.
   * @return ItemRatingDetailArrayType
   */
  public ItemRatingDetailArrayType getSellerItemRatingDetailArray()
  {
    return this.sellerItemRatingDetailArray;
  }

  /**
   * Sets the LeaveFeedbackRequestType.sellerItemRatingDetailArray.
   * @param sellerItemRatingDetailArray ItemRatingDetailArrayType
   */
  public void setSellerItemRatingDetailArray(ItemRatingDetailArrayType sellerItemRatingDetailArray)
  {
    this.sellerItemRatingDetailArray = sellerItemRatingDetailArray;
  }

  /**
   * Gets the LeaveFeedbackRequestType.targetUser.
   * @return String
   */
  public String getTargetUser()
  {
    return this.targetUser;
  }

  /**
   * Sets the LeaveFeedbackRequestType.targetUser.
   * @param targetUser String
   */
  public void setTargetUser(String targetUser)
  {
    this.targetUser = targetUser;
  }

  /**
   * Gets the LeaveFeedbackRequestType.transactionID.
   * @return String
   */
  public String getTransactionID()
  {
    return this.transactionID;
  }

  /**
   * Sets the LeaveFeedbackRequestType.transactionID.
   * @param transactionID String
   */
  public void setTransactionID(String transactionID)
  {
    this.transactionID = transactionID;
  }

  /**
   * Valid after executing the API.
   * Gets the returned LeaveFeedbackResponseType.returnedFeedbackID.
   * 
   * @return String
   */
  public String getReturnedFeedbackID()
  {
    return this.returnedFeedbackID;
  }

}

