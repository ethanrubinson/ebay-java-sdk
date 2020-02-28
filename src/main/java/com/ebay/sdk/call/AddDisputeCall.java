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
 * Wrapper class of the AddDispute call of eBay SOAP API.
 * <br>
 * <p>Title: SOAP API wrapper library.</p>
 * <p>Description: Contains wrapper classes for eBay SOAP APIs.</p>
 * <p>Copyright: Copyright (c) 2009</p>
 * <p>Company: eBay Inc.</p>
 * <br> <B>Input property:</B> <code>DisputeExplanation</code> - This enumerated value gives the explanation of why the seller opened a case (or why seller canceled a single line item order). Not all values contained in <b>DisputeExplanationCodeType</b> are allowed in the <b>AddDispute</b> call, and the values that are allowed must match the <b>DisputeReason</b> value.
 * <br> <B>Input property:</B> <code>DisputeReason</code> - The enumeration value passed into this required field will depend on the action being taken. The seller will pass in <code>BuyerHasNotPaid</code> if the seller is creating an Unpaid Item case against the buyer, or
 * <code>TransactionMutuallyCanceled</code> if the seller is cancelling a single line item order at the request of the buyer, or if the seller has ran out of stock on the item or otherwise cannot fulfill the order.
 * <br> <B>Input property:</B> <code>ItemID</code> - Unique identifier of an eBay listing. To identify a specific order line item, either an <b>ItemID</b>/<b>TransactionID</b> pair or an <b>OrderLineItemID</b> value must be passed in the request. So, unless <b>OrderLineItemID</b> is used, this field is required.
 * <br>
 * <br> <B>Input property:</B> <code>TransactionID</code> - The unique identifier of a buyer's purchase. A <b>TransactionID</b> is created by eBay once a buyer purchases the item through a fixed-priced listing or by using the Buy It Now feature in an auction listing, or when an auction listing ends with a winning bidder. To identify a specific order line item, either an <b>ItemID</b>/<b>TransactionID</b> pair or an <b>OrderLineItemID</b> value must be passed in the request. So, unless <b>OrderLineItemID</b> is used, this field is required.
 * <br>
 * <br> <B>Input property:</B> <code>OrderLineItemID</code> - <b>OrderLineItemID</b> is a unique identifier of an order line item. To identify a specific order line item, either an <b>ItemID</b>/<b>TransactionID</b> pair or an <b>OrderLineItemID</b> value must be passed in the request. So, unless <b>ItemID</b>/<b>TransactionID</b> pair is used, this field is required.
 * <br>
 * <br> <B>Output property:</B> <code>ReturnedDisputeID</code> - This field will show the unique identifier of an Unpaid Item case that was created, or the unique identifier of the order cancellation.
 * 
 * @author Ron Murphy
 * @version 1.0
 */

public class AddDisputeCall extends com.ebay.sdk.ApiCall
{
  
  private DisputeExplanationCodeType disputeExplanation = null;
  private DisputeReasonCodeType disputeReason = null;
  private String itemID = null;
  private String transactionID = null;
  private String orderLineItemID = null;
  private String returnedDisputeID=null;


  /**
   * Constructor.
   */
  public AddDisputeCall() {
  }

  /**
   * Constructor.
   * @param apiContext The ApiContext object to be used to make the call.
   */
  public AddDisputeCall(ApiContext apiContext) {
    super(apiContext);
    

  }

  /**
   * Enables a seller to create an Unpaid Item case against a buyer, or to cancel a
   * single line item order.
   * <br>
   * <br>
   * Although the seller is eligible to open up an Unpaid Item case two days after the buyer purchases the item or wins the item through an auction, it is recommended that the seller contacts the buyer first to try and make it right before opening a case. The <a href="http://pages.ebay.com/help/sell/unpaid-items.html" target="_blank">Unpaid Items</a> help page talks more about how a seller should to handle an unpaid item.
   * <br>
   * <br>
   * To cancel a multiple line item order programmatically, the seller would have to use the <a href="https://developer.ebay.com/Devzone/post-order/post-order_v2_cancellation__post.html" target="_blank">POST /post-order/v2/cancellation</a> call of the <b>Post-Order API</b>.
   * 
   * <br>
   * @throws ApiException
   * @throws SdkException
   * @throws Exception
   * @return The String object.
   */
  public String addDispute()
      throws com.ebay.sdk.ApiException, com.ebay.sdk.SdkException, java.lang.Exception
  {
    AddDisputeRequestType req;
    req = new AddDisputeRequestType();
    if (this.disputeExplanation != null)
      req.setDisputeExplanation(this.disputeExplanation);
    if (this.disputeReason != null)
      req.setDisputeReason(this.disputeReason);
    if (this.itemID != null)
      req.setItemID(this.itemID);
    if (this.transactionID != null)
      req.setTransactionID(this.transactionID);
    if (this.orderLineItemID != null)
      req.setOrderLineItemID(this.orderLineItemID);

    AddDisputeResponseType resp = (AddDisputeResponseType) execute(req);

    this.returnedDisputeID = resp.getDisputeID();
    return this.getReturnedDisputeID();
  }

  /**
   * Gets the AddDisputeRequestType.disputeExplanation.
   * @return DisputeExplanationCodeType
   */
  public DisputeExplanationCodeType getDisputeExplanation()
  {
    return this.disputeExplanation;
  }

  /**
   * Sets the AddDisputeRequestType.disputeExplanation.
   * @param disputeExplanation DisputeExplanationCodeType
   */
  public void setDisputeExplanation(DisputeExplanationCodeType disputeExplanation)
  {
    this.disputeExplanation = disputeExplanation;
  }

  /**
   * Gets the AddDisputeRequestType.disputeReason.
   * @return DisputeReasonCodeType
   */
  public DisputeReasonCodeType getDisputeReason()
  {
    return this.disputeReason;
  }

  /**
   * Sets the AddDisputeRequestType.disputeReason.
   * @param disputeReason DisputeReasonCodeType
   */
  public void setDisputeReason(DisputeReasonCodeType disputeReason)
  {
    this.disputeReason = disputeReason;
  }

  /**
   * Gets the AddDisputeRequestType.itemID.
   * @return String
   */
  public String getItemID()
  {
    return this.itemID;
  }

  /**
   * Sets the AddDisputeRequestType.itemID.
   * @param itemID String
   */
  public void setItemID(String itemID)
  {
    this.itemID = itemID;
  }

  /**
   * Gets the AddDisputeRequestType.orderLineItemID.
   * @return String
   */
  public String getOrderLineItemID()
  {
    return this.orderLineItemID;
  }

  /**
   * Sets the AddDisputeRequestType.orderLineItemID.
   * @param orderLineItemID String
   */
  public void setOrderLineItemID(String orderLineItemID)
  {
    this.orderLineItemID = orderLineItemID;
  }

  /**
   * Gets the AddDisputeRequestType.transactionID.
   * @return String
   */
  public String getTransactionID()
  {
    return this.transactionID;
  }

  /**
   * Sets the AddDisputeRequestType.transactionID.
   * @param transactionID String
   */
  public void setTransactionID(String transactionID)
  {
    this.transactionID = transactionID;
  }

  /**
   * Valid after executing the API.
   * Gets the returned AddDisputeResponseType.returnedDisputeID.
   * 
   * @return String
   */
  public String getReturnedDisputeID()
  {
    return this.returnedDisputeID;
  }

}

