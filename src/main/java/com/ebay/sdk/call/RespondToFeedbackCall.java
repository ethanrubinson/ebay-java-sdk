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

import com.ebay.sdk.*;
import com.ebay.soap.eBLBaseComponents.*;
/**
 * Wrapper class of the RespondToFeedback call of eBay SOAP API.
 * <br>
 * <p>Title: SOAP API wrapper library.</p>
 * <p>Description: Contains wrapper classes for eBay SOAP APIs.</p>
 * <p>Copyright: Copyright (c) 2009</p>
 * <p>Company: eBay Inc.</p>
 * <br> <B>Input property:</B> <code>FeedbackID</code> - A unique identifier for a Feedback record. Buying and selling partners
 * leave feedback for one another after the completion of an order.
 * Feedback is left at the order line item level, so a
 * Feedback comment for each order line item in a Combined Payment order is
 * expected from the buyer and seller. A unique <b>FeedbackID</b> is created
 * whenever a buyer leaves feedback for a seller, and vice versa. A
 * <b>FeedbackID</b> is created by eBay when feedback is left through the eBay
 * site, or through the <b>LeaveFeedback</b> call. <b>FeedbackIDs</b> can be retrieved
 * with the <b>GetFeedback</b> call. In the <b>RespondToFeedback</b> call, <b>FeedbackID</b> can
 * be used as an input filter to respond to a specific Feedback comment.
 * Since Feedback is always linked to a unique order line item, an
 * <b>ItemID</b>/<b>TransactionID</b> pair or an <b>OrderLineItemID</b> can also be used to
 * respond to a Feedback comment.
 * <br> <B>Input property:</B> <code>ItemID</code> - Unique identifier for the eBay listing to which the user will be responding to Feedback. A listing can have multiple
 * order line items, but only one <b>ItemID</b> value. An <b>ItemID</b> can be
 * paired up with a corresponding <b>TransactionID</b> and used as an input filter
 * to respond to a Feedback comment in the <b>RespondToFeedback</b> call. Unless
 * the specific Feedback record is identified by a <b>FeedbackID</b> or an
 * <b>OrderLineItemID</b> in the request, an <b>ItemID</b>/<b>TransactionID</b> pair is
 * required.
 * <br> <B>Input property:</B> <code>TransactionID</code> - Unique identifier for an eBay order line item. A
 * <b>TransactionID</b> can be paired up with its corresponding <b>ItemID</b> and used as
 * an input filter to respond to a Feedback comment in the
 * <b>RespondToFeedback</b> call. Unless the specific Feedback record is
 * identified by a <b>FeedbackID</b> or an <b>OrderLineItemID</b> in the request, an
 * <b>ItemID</b>/<b>TransactionID</b> pair is required.
 * <br> <B>Input property:</B> <code>TargetUserID</code> - The eBay user ID of the caller's order partner. The caller is either
 * replyting to or following up on this user's Feedback comment.
 * <br> <B>Input property:</B> <code>ResponseType</code> - Specifies whether the response is a reply or a follow-up to a Feedback
 * comment left by the user identified in the <b>TargetUserID</b> field.
 * <br> <B>Input property:</B> <code>ResponseText</code> - Textual comment that the user who is subject of feedback may leave in
 * response or rebuttal to the Feedback comment. Alternatively, when the
 * <b>ResponseType</b> is <b>FollowUp</b>, this value contains the text of the follow-up
 * comment.
 * <br>
 * <br> <B>Input property:</B> <code>OrderLineItemID</code> - <b>OrderLineItemID</b> is a unique identifier for an eBay order line item. Since Feedback is always linked to a
 * unique order line item, an <b>OrderLineItemID</b> can be used to respond
 * to a Feedback comment.
 * <br><br>
 * Unless an <b>ItemID</b>/<b>TransactionID</b> pair or a <b>FeedbackID</b> is used to identify
 * a Feedback record, the <b>OrderLineItemID</b> must be specified.
 * <br>
 * 
 * @author Ron Murphy
 * @version 1.0
 */

public class RespondToFeedbackCall extends com.ebay.sdk.ApiCall
{
  
  private String feedbackID = null;
  private String itemID = null;
  private String transactionID = null;
  private String targetUserID = null;
  private FeedbackResponseCodeType responseType = null;
  private String responseText = null;
  private String orderLineItemID = null;


  /**
   * Constructor.
   */
  public RespondToFeedbackCall() {
  }

  /**
   * Constructor.
   * @param apiContext The ApiContext object to be used to make the call.
   */
  public RespondToFeedbackCall(ApiContext apiContext) {
    super(apiContext);
    

  }

  /**
   * Enables a seller to reply to Feedback that has been left for a user, or to post a
   * follow-up comment to a Feedback comment the user has left for someone else.
   * 
   * <br>
   * @throws ApiException
   * @throws SdkException
   * @throws Exception
   * @return The void object.
   */
  public void respondToFeedback()
      throws com.ebay.sdk.ApiException, com.ebay.sdk.SdkException, java.lang.Exception
  {
    RespondToFeedbackRequestType req;
    req = new RespondToFeedbackRequestType();

    if( this.targetUserID == null )
      throw new SdkException("TargetUserID property is not set.");
    if( this.responseType == null )
      throw new SdkException("ResponseType property is not set.");
    if( this.responseText == null )
      throw new SdkException("ResponseText property is not set.");

    if (this.feedbackID != null)
      req.setFeedbackID(this.feedbackID);
    if (this.itemID != null)
      req.setItemID(this.itemID);
    if (this.transactionID != null)
      req.setTransactionID(this.transactionID);
    if (this.targetUserID != null)
      req.setTargetUserID(this.targetUserID);
    if (this.responseType != null)
      req.setResponseType(this.responseType);
    if (this.responseText != null)
      req.setResponseText(this.responseText);
    if (this.orderLineItemID != null)
      req.setOrderLineItemID(this.orderLineItemID);

    RespondToFeedbackResponseType resp = (RespondToFeedbackResponseType) execute(req);


  }

  /**
   * Gets the RespondToFeedbackRequestType.feedbackID.
   * @return String
   */
  public String getFeedbackID()
  {
    return this.feedbackID;
  }

  /**
   * Sets the RespondToFeedbackRequestType.feedbackID.
   * @param feedbackID String
   */
  public void setFeedbackID(String feedbackID)
  {
    this.feedbackID = feedbackID;
  }

  /**
   * Gets the RespondToFeedbackRequestType.itemID.
   * @return String
   */
  public String getItemID()
  {
    return this.itemID;
  }

  /**
   * Sets the RespondToFeedbackRequestType.itemID.
   * @param itemID String
   */
  public void setItemID(String itemID)
  {
    this.itemID = itemID;
  }

  /**
   * Gets the RespondToFeedbackRequestType.orderLineItemID.
   * @return String
   */
  public String getOrderLineItemID()
  {
    return this.orderLineItemID;
  }

  /**
   * Sets the RespondToFeedbackRequestType.orderLineItemID.
   * @param orderLineItemID String
   */
  public void setOrderLineItemID(String orderLineItemID)
  {
    this.orderLineItemID = orderLineItemID;
  }

  /**
   * Gets the RespondToFeedbackRequestType.responseText.
   * @return String
   */
  public String getResponseText()
  {
    return this.responseText;
  }

  /**
   * Sets the RespondToFeedbackRequestType.responseText.
   * @param responseText String
   */
  public void setResponseText(String responseText)
  {
    this.responseText = responseText;
  }

  /**
   * Gets the RespondToFeedbackRequestType.responseType.
   * @return FeedbackResponseCodeType
   */
  public FeedbackResponseCodeType getResponseType()
  {
    return this.responseType;
  }

  /**
   * Sets the RespondToFeedbackRequestType.responseType.
   * @param responseType FeedbackResponseCodeType
   */
  public void setResponseType(FeedbackResponseCodeType responseType)
  {
    this.responseType = responseType;
  }

  /**
   * Gets the RespondToFeedbackRequestType.targetUserID.
   * @return String
   */
  public String getTargetUserID()
  {
    return this.targetUserID;
  }

  /**
   * Sets the RespondToFeedbackRequestType.targetUserID.
   * @param targetUserID String
   */
  public void setTargetUserID(String targetUserID)
  {
    this.targetUserID = targetUserID;
  }

  /**
   * Gets the RespondToFeedbackRequestType.transactionID.
   * @return String
   */
  public String getTransactionID()
  {
    return this.transactionID;
  }

  /**
   * Sets the RespondToFeedbackRequestType.transactionID.
   * @param transactionID String
   */
  public void setTransactionID(String transactionID)
  {
    this.transactionID = transactionID;
  }

}

