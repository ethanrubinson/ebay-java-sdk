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
 * Wrapper class of the DisableUnpaidItemAssistance call of eBay SOAP API.
 * <br>
 * <p>Title: SOAP API wrapper library.</p>
 * <p>Description: Contains wrapper classes for eBay SOAP APIs.</p>
 * <p>Copyright: Copyright (c) 2009</p>
 * <p>Company: eBay Inc.</p>
 * <br> <B>Input property:</B> <code>ItemID</code> - Unique identifier for an eBay listing. A listing can have multiple order line items, but only one <b>ItemID</b>. To identify a specific order line item for which to disable the Unpaid Item Assistant mechanism, either an <b>ItemID</b>/<b>TransactionID</b> pair, an <b>OrderLineItemID</b>, or a <b>DisputeID</b> (if an Unpaid Item case already exists) is required in the request.
 * <br> <B>Input property:</B> <code>TransactionID</code> - The unique identifier of an order line item. An order line item is created once there is a commitment from a buyer to purchase an item. To identify a specific order line item for which to disable the Unpaid Item Assistant mechanism, either an <b>ItemID</b>/<b>TransactionID</b> pair, an <b>OrderLineItemID</b>, or a <b>DisputeID</b> (if an Unpaid Item case already exists) is required in the request.
 * <br> <B>Input property:</B> <code>DisputeID</code> - A unique identifier for an Unpaid Item case that is filed against an order line item. If an <b>ItemID</b>/<b>TransactionID</b> pair or an <b>OrderLineItemID</b> is used to identify an order line item, <b>DisputeID</b> cannot be used and will be ignored if it is included in the request.
 * <br> <B>Input property:</B> <code>OrderLineItemID</code> - <b>OrderLineItemID</b> is a unique identifier for an eBay order line item. To identify a specific order line item for which to disable the Unpaid Item Assistant mechanism, either an <b>ItemID</b>/<b>TransactionID</b> pair, an <b>OrderLineItemID</b>, or a <b>DisputeID</b> is required in the request.
 * 
 * @author Ron Murphy
 * @version 1.0
 */

public class DisableUnpaidItemAssistanceCall extends com.ebay.sdk.ApiCall
{
  
  private String itemID = null;
  private String transactionID = null;
  private String disputeID = null;
  private String orderLineItemID = null;


  /**
   * Constructor.
   */
  public DisableUnpaidItemAssistanceCall() {
  }

  /**
   * Constructor.
   * @param apiContext The ApiContext object to be used to make the call.
   */
  public DisableUnpaidItemAssistanceCall(ApiContext apiContext) {
    super(apiContext);
    

  }

  /**
   * Enables a seller who has opted into the automated Unpaid Item Assistant mechanism to disable the Unpaid Item Assistant at the order line item level. This call can be made whether or not a Unpaid Item case exists for the order line item. If an Unpaid Item case has already been created by the Unpaid Item Assistant, it is converted to a "manual" case for the seller to manage like any other manually-created case.
   * 
   * <br>
   * @throws ApiException
   * @throws SdkException
   * @throws Exception
   * @return The void object.
   */
  public void disableUnpaidItemAssistance()
      throws com.ebay.sdk.ApiException, com.ebay.sdk.SdkException, java.lang.Exception
  {
    DisableUnpaidItemAssistanceRequestType req;
    req = new DisableUnpaidItemAssistanceRequestType();
    if (this.itemID != null)
      req.setItemID(this.itemID);
    if (this.transactionID != null)
      req.setTransactionID(this.transactionID);
    if (this.disputeID != null)
      req.setDisputeID(this.disputeID);
    if (this.orderLineItemID != null)
      req.setOrderLineItemID(this.orderLineItemID);

    DisableUnpaidItemAssistanceResponseType resp = (DisableUnpaidItemAssistanceResponseType) execute(req);


  }

  /**
   * Gets the DisableUnpaidItemAssistanceRequestType.disputeID.
   * @return String
   */
  public String getDisputeID()
  {
    return this.disputeID;
  }

  /**
   * Sets the DisableUnpaidItemAssistanceRequestType.disputeID.
   * @param disputeID String
   */
  public void setDisputeID(String disputeID)
  {
    this.disputeID = disputeID;
  }

  /**
   * Gets the DisableUnpaidItemAssistanceRequestType.itemID.
   * @return String
   */
  public String getItemID()
  {
    return this.itemID;
  }

  /**
   * Sets the DisableUnpaidItemAssistanceRequestType.itemID.
   * @param itemID String
   */
  public void setItemID(String itemID)
  {
    this.itemID = itemID;
  }

  /**
   * Gets the DisableUnpaidItemAssistanceRequestType.orderLineItemID.
   * @return String
   */
  public String getOrderLineItemID()
  {
    return this.orderLineItemID;
  }

  /**
   * Sets the DisableUnpaidItemAssistanceRequestType.orderLineItemID.
   * @param orderLineItemID String
   */
  public void setOrderLineItemID(String orderLineItemID)
  {
    this.orderLineItemID = orderLineItemID;
  }

  /**
   * Gets the DisableUnpaidItemAssistanceRequestType.transactionID.
   * @return String
   */
  public String getTransactionID()
  {
    return this.transactionID;
  }

  /**
   * Sets the DisableUnpaidItemAssistanceRequestType.transactionID.
   * @param transactionID String
   */
  public void setTransactionID(String transactionID)
  {
    this.transactionID = transactionID;
  }

}

