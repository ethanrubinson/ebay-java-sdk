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
 * Wrapper class of the CompleteSale call of eBay SOAP API.
 * <br>
 * <p>Title: SOAP API wrapper library.</p>
 * <p>Description: Contains wrapper classes for eBay SOAP APIs.</p>
 * <p>Copyright: Copyright (c) 2009</p>
 * <p>Company: eBay Inc.</p>
 * <br> <B>Input property:</B> <code>ItemID</code> - Unique identifier for an eBay listing. An <b>ItemID</b> value can be paired up with a corresponding <b>TransactionID</b> value in a <b>CompleteSale</b> request to identify a single order line item. Alternatively, the <b>OrderLineItemID</b> value for the order line item can be used.
 * <br><br>
 * Unless an <b>OrderLineItemID</b> value is used to identify a single order line item, or the <b>OrderID</b> value is used to identify a single or multiple line item order, the <b>ItemID</b>/<b>TransactionID</b> pair must be specified. To perform an action on an entire multiple line item order, the <b>OrderID</b> field must be used. If an <b>OrderID</b> or <b>OrderLineItemID</b> value is specified, an <b>ItemID</b>/<b>TransactionID</b> pair will be ignored (if present in the same request).
 * <br> <B>Input property:</B> <code>TransactionID</code> - Unique identifier for a sales transaction. A <b>TransactionID</b> identifier is created once there is a commitment to buy (bidder wins the auction, buyer clicks buy button, or buyer purchases item through <b>PlaceOffer</b> call). The
 * <b>TransactionID</b> can be paired up with the corresponding <b>ItemID</b> value in a <b>CompleteSale</b> request to identify a single order line item. Alternatively, the <b>OrderLineItemID</b> value for the order line item can be used.
 * <br><br>
 * Unless an <b>OrderLineItemID</b> value is used to identify a single order line item, or the <b>OrderID</b> value is used to identify a single or multiple line item order, the <b>ItemID</b>/<b>TransactionID</b> pair must be specified. To perform an action on an entire multiple line item order, the <b>OrderID</b> field must be used. If an <b>OrderID</b> or <b>OrderLineItemID</b> value is specified, an <b>ItemID</b>/<b>TransactionID</b> pair will be ignored (if present in the same request).
 * <br> <B>Input property:</B> <code>FeedbackInfo</code> - This container is used by the seller to leave feedback for the buyer for the order line item identified in the call request. The seller must include and specify all fields of this type, including the buyer's eBay User ID, the Feedback rating (a seller can only leave a buyer a 'Positive' rating), and a comment, which helps justify the Feedback rating. The eBay User ID must match the buyer who bought the order line item, or an error will occur. An error will also occur if Feedback has already been left for the buyer (either through API or the Web flow).
 * <br><br>
 * To determine if Feedback has already been left for an order line item, you can call <b class="con">GetFeedback</b>, passing in the <b class="con">OrderLineItemID</b> value in the call request.
 * <br><br>
 * <span class="tablenote"><b>Note: </b> Feedback entries are submitted at the order line item level, so either an <b>OrderLineItemID</b> value or an <b>ItemID</b>/<b>TransactionID</b> pair should be specified to identify the order line item (and not an <b>OrderLineItemID</b> value). To leave Feedback for all line items in a multiple line item order, the seller would need a separate <b>CompleteSale</b> request for each order line item.
 * </span>
 * <br> <B>Input property:</B> <code>Shipped</code> - The seller includes and sets this field to true if the order or order line item has been shipped. If the call is successful, the order line item(s) are marked as Shipped in My eBay.
 * <br><br>
 * If the seller includes and sets this field to false, the order or order line item are marked (or remain) as 'Not Shipped' in eBay's system.
 * <br><br>
 * If this field is not included, the shipped status of the order or order line item remain unchanged in My eBay.
 * <br><br>
 * If shipment tracking information is provided for an order or order line item through the <b>Shipment</b> container in the same request, the <b>Shipped</b> status is set to <code>true</code> automatically, and the <b>Shipped</b> field is not necessary.
 * <br> <B>Input property:</B> <code>Paid</code> - The seller includes and sets this field to true if the order has been
 * paid for by the buyer. If the call is successful, the order line item(s)
 * are marked as 'Paid' in eBay's system.
 * <br><br>
 * If the seller includes and sets this field to <code>false</code>, the order line item(s) are marked (or remain) as 'Not Paid' in eBay's system.
 * <br><br>
 * If this field is not included, the paid status of the order line item(s) remain unchanged in eBay's system.
 * <br> <B>Input property:</B> <code>ListingType</code> - <span class="tablenote"><b>Note: </b> DO NOT USE THIS FIELD. Previously, this field's only purpose was to classify the order to be updated as a Half.com order. However, since the Half.com site has been shut down, this field is no longer applicable.
 * </span>
 * <br> <B>Input property:</B> <code>Shipment</code> - Container consisting of shipment tracking information, shipped time, and an optional text field to provide additional details to the buyer. Setting the tracking number and shipping carrier automatically marks the order line item as shipped and the <b>Shipped</b> field is not necessary.
 * <br><br>
 * If you supply <b>ShipmentTrackingNumber</b>, you must also supply <b>ShippingCarrierUsed</b>; otherwise you will get an error.
 * <br><br>
 * To modify the shipping tracking number and/or shipping carrier, supply the new number in the <b>ShipmentTrackingNumber</b> field or supply the value for <b>ShippingCarrierUsed</b>, or both. The old number and carrier are deleted and the new ones are added.
 * <br><br>
 * To simply delete the current tracking details altogether, supply empty <b>Shipment</b> tags.
 * <br> <br>
 * <span class="tablenote"><b>Note:</b> Top-Rated sellers must have a record of uploading shipment tracking information (through site or through API) for at least 95 percent of their order line items (purchased by U.S. buyers) to keep their status as Top-Rated sellers. For more information on the requirements to becoming a Top-Rated Seller, see the <a href="http://pages.ebay.com/help/sell/top-rated.html">Becoming a Top-Rated Seller and qualifying for Top-Rated Plus</a> customer support page. </span> <br>
 * <br> <B>Input property:</B> <code>OrderID</code> - A unique identifier for an eBay order. An <b>OrderID</b> value should only be used in a <b>CompleteSale</b> call for a single line item order. For a multiple line item order, the <b>OrderLineItemID</b> or <b>ItemID</b>/<b>TransactionID</b> pair must be used to identify an order line item within the order.
 * <br><br>
 * <b>OrderID</b> overrides an <b>OrderLineItemID</b> or <b>ItemID</b>/<b>TransactionID</b> pair if these fields are also specified in the same request.
 * <br><br>
 * <span class="tablenote"><b>Note: </b> As of June 2019, eBay has changed the format of order identifier values. The new format is a non-parsable string, globally unique across all eBay marketplaces, and consistent for both single line item and multiple line item orders. Unlike in the past, instead of just being known and exposed to the seller, these unique order identifiers will also be known and used/referenced by the buyer and eBay customer support.
 * <br><br>
 * For developers and sellers who are already integrated with the Trading API's order management calls, this change shouldn't impact your integration unless you parse the existing order identifiers (e.g., <b>OrderID</b> or <b>OrderLineItemID</b>), or otherwise infer meaning from the format (e.g., differentiating between a single line item order versus a multiple line item order). Because we realize that some integrations may have logic that is dependent upon the old identifier format, eBay is rolling out this Trading API change with version control to support a transition period of approximately 9 months before applications must switch to the new format completely.
 * <br><br>
 * During the transition period, for developers/sellers using a Trading WSDL older than Version 1113, they can use the <b>X-EBAY-API-COMPATIBILITY-LEVEL</b> HTTP header in API calls to control whether the new or old <b>OrderID</b> format is returned in call response payloads. To get the new <b>OrderID</b> format, the value of the <b>X-EBAY-API-COMPATIBILITY-LEVEL</b> HTTP header must be set to <code>1113</code>. During the transition period and even after, the new and old <b>OrderID</b> formats will still be supported/accepted in all Trading API call request payloads. After the transition period (which will be announced), only the new <b>OrderID</b> format will be returned in all Trading API call response payloads, regardless of the Trading WSDL version used or specified compatibility level.
 * </span>
 * <br>
 * <span class="tablenote"><b>Note: </b> For sellers integrated with the new order ID format, please note that the identifier for an order will change as it goes from unpaid to paid status. Sellers can check to see if an order has been paid by looking for a value of 'Complete' in the <b>CheckoutStatus.Status</b> field in the response of <b>GetOrders</b> or <b>GetOrderTransactions</b> call, or in the <b>Status.CompleteStatus</b> field in the response of <b>GetItemTransactions</b> or <b>GetSellerTransactions</b> call. Sellers should  not fulfill orders until buyer has made payment. When using a <b>CompleteSale</b> call, either of these order IDs (paid or unpaid status) can be used to update an order. Similarly, either of these order IDs (paid or unpaid status) can be used in <b>GetOrders</b> or <b>GetOrderTransactions</b> call to retrieve specific order(s).
 * </span>
 * <br> <B>Input property:</B> <code>OrderLineItemID</code> - A unique identifier for an eBay order line item. <b>OrderLineItemID</b> values are returned (at the order line item level) in Trading API's order management calls. This identifier is created once there is a commitment to buy (bidder wins the auction, buyer clicks buy button, or buyer purchases item through <b>PlaceOffer</b> call). An <b>OrderLineItemID</b> value can be used in a <b>CompleteSale</b> request to identify a line item within an order. Alternatively, an <b>ItemID</b>/<b>TransactionID</b> pair can also be used to identify a line item.
 * <br><br>
 * Unless an <b>ItemID</b>/<b>TransactionID</b> pair is used to identify an order line
 * item, or an <b>OrderID</b> value is used to identify an order, the <b>OrderLineItemID</b> must be specified. If <b>OrderLineItemID</b> is specified, the <b>ItemID</b>/<b>TransactionID</b> pair are
 * ignored if present in the same request.
 * 
 * @author Ron Murphy
 * @version 1.0
 */

public class CompleteSaleCall extends com.ebay.sdk.ApiCall
{
  
  private String itemID = null;
  private String transactionID = null;
  private FeedbackInfoType feedbackInfo = null;
  private Boolean shipped = null;
  private Boolean paid = null;
  private ListingTypeCodeType listingType = null;
  private ShipmentType shipment = null;
  private String orderID = null;
  private String orderLineItemID = null;


  /**
   * Constructor.
   */
  public CompleteSaleCall() {
  }

  /**
   * Constructor.
   * @param apiContext The ApiContext object to be used to make the call.
   */
  public CompleteSaleCall(ApiContext apiContext) {
    super(apiContext);
    

  }

  /**
   * Enables a seller to perform various tasks with a single or multiple line item order. Tasks available with this call include marking the order as paid, marking the order as shipped, providing shipment tracking details to the buyer, and leaving feedback for the buyer.
   * 
   * <br>
   * @throws ApiException
   * @throws SdkException
   * @throws Exception
   * @return The void object.
   */
  public void completeSale()
      throws com.ebay.sdk.ApiException, com.ebay.sdk.SdkException, java.lang.Exception
  {
    CompleteSaleRequestType req;
    req = new CompleteSaleRequestType();
    if (this.itemID != null)
      req.setItemID(this.itemID);
    if (this.transactionID != null)
      req.setTransactionID(this.transactionID);
    if (this.feedbackInfo != null)
      req.setFeedbackInfo(this.feedbackInfo);
    if (this.shipped != null)
      req.setShipped(this.shipped);
    if (this.paid != null)
      req.setPaid(this.paid);
    if (this.listingType != null)
      req.setListingType(this.listingType);
    if (this.shipment != null)
      req.setShipment(this.shipment);
    if (this.orderID != null)
      req.setOrderID(this.orderID);
    if (this.orderLineItemID != null)
      req.setOrderLineItemID(this.orderLineItemID);

    CompleteSaleResponseType resp = (CompleteSaleResponseType) execute(req);


  }

  /**
   * Gets the CompleteSaleRequestType.feedbackInfo.
   * @return FeedbackInfoType
   */
  public FeedbackInfoType getFeedbackInfo()
  {
    return this.feedbackInfo;
  }

  /**
   * Sets the CompleteSaleRequestType.feedbackInfo.
   * @param feedbackInfo FeedbackInfoType
   */
  public void setFeedbackInfo(FeedbackInfoType feedbackInfo)
  {
    this.feedbackInfo = feedbackInfo;
  }

  /**
   * Gets the CompleteSaleRequestType.itemID.
   * @return String
   */
  public String getItemID()
  {
    return this.itemID;
  }

  /**
   * Sets the CompleteSaleRequestType.itemID.
   * @param itemID String
   */
  public void setItemID(String itemID)
  {
    this.itemID = itemID;
  }

  /**
   * Gets the CompleteSaleRequestType.listingType.
   * @return ListingTypeCodeType
   */
  public ListingTypeCodeType getListingType()
  {
    return this.listingType;
  }

  /**
   * Sets the CompleteSaleRequestType.listingType.
   * @param listingType ListingTypeCodeType
   */
  public void setListingType(ListingTypeCodeType listingType)
  {
    this.listingType = listingType;
  }

  /**
   * Gets the CompleteSaleRequestType.orderID.
   * @return String
   */
  public String getOrderID()
  {
    return this.orderID;
  }

  /**
   * Sets the CompleteSaleRequestType.orderID.
   * @param orderID String
   */
  public void setOrderID(String orderID)
  {
    this.orderID = orderID;
  }

  /**
   * Gets the CompleteSaleRequestType.orderLineItemID.
   * @return String
   */
  public String getOrderLineItemID()
  {
    return this.orderLineItemID;
  }

  /**
   * Sets the CompleteSaleRequestType.orderLineItemID.
   * @param orderLineItemID String
   */
  public void setOrderLineItemID(String orderLineItemID)
  {
    this.orderLineItemID = orderLineItemID;
  }

  /**
   * Gets the CompleteSaleRequestType.paid.
   * @return Boolean
   */
  public Boolean getPaid()
  {
    return this.paid;
  }

  /**
   * Sets the CompleteSaleRequestType.paid.
   * @param paid Boolean
   */
  public void setPaid(Boolean paid)
  {
    this.paid = paid;
  }

  /**
   * Gets the CompleteSaleRequestType.shipment.
   * @return ShipmentType
   */
  public ShipmentType getShipment()
  {
    return this.shipment;
  }

  /**
   * Sets the CompleteSaleRequestType.shipment.
   * @param shipment ShipmentType
   */
  public void setShipment(ShipmentType shipment)
  {
    this.shipment = shipment;
  }

  /**
   * Gets the CompleteSaleRequestType.shipped.
   * @return Boolean
   */
  public Boolean getShipped()
  {
    return this.shipped;
  }

  /**
   * Sets the CompleteSaleRequestType.shipped.
   * @param shipped Boolean
   */
  public void setShipped(Boolean shipped)
  {
    this.shipped = shipped;
  }

  /**
   * Gets the CompleteSaleRequestType.transactionID.
   * @return String
   */
  public String getTransactionID()
  {
    return this.transactionID;
  }

  /**
   * Sets the CompleteSaleRequestType.transactionID.
   * @param transactionID String
   */
  public void setTransactionID(String transactionID)
  {
    this.transactionID = transactionID;
  }

}

