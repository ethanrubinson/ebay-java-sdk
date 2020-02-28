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
 * Wrapper class of the ReviseSellingManagerSaleRecord call of eBay SOAP API.
 * <br>
 * <p>Title: SOAP API wrapper library.</p>
 * <p>Description: Contains wrapper classes for eBay SOAP APIs.</p>
 * <p>Copyright: Copyright (c) 2009</p>
 * <p>Company: eBay Inc.</p>
 * <br> <B>Input property:</B> <code>ItemID</code> - Unique identifier for an eBay listing. A listing can have multiple
 * order line items, but only one <b>ItemID</b> value. An <b>ItemID</b> can be
 * paired up with a corresponding <b>TransactionID</b> and used as an input filter
 * for <b>ReviseSellingManagerSaleRecord</b>. The <b>ItemID</b>/<b>TransactionID</b> pair
 * corresponds to a Selling Manager <b>SaleRecordID</b>, which can be retrieved
 * with the <b>GetSellingManagerSaleRecord</b> call.
 * <br><br>
 * Unless an <b>OrderLineItemID</b> is used to identify an order line item,
 * or the <b>OrderID</b> is used to identify an order, the <b>ItemID</b>/<b>TransactionID</b> pair must be
 * specified. If <b>OrderID</b> or <b>OrderLineItemID</b> are specified, the
 * <b>ItemID</b>/<b>TransactionID</b> pair is ignored if present in the same request.
 * <br> <B>Input property:</B> <code>TransactionID</code> - Unique identifier for an eBay sales transaction. This identifier is created once there is a commitment to buy (bidder wins the auction, buyer clicks buy button, or buyer purchases item through <b>PlaceOffer</b> call). Since an auction listing can only have one sales transaction during the duration of the listing, the <b>TransactionID</b> value for auction listings is always <code>0</code>.
 * <br><br>
 * The <b>ItemID</b>/<b>TransactionID</b> pair can be
 * used to identify an order line item in a  <b>ReviseSellingManagerSaleRecord</b> call. The
 * <b>ItemID</b>/<b>TransactionID</b> pair corresponds to a Selling Manager <b>SaleRecordID</b>,
 * which can be retrieved with the <b>GetSellingManagerSaleRecord</b> call.
 * <br><br>
 * Unless an <b>OrderLineItemID</b> is used to identify an order line item,
 * or the <b>OrderID</b> is used to identify an order, the <b>ItemID</b>/<b>TransactionID</b> pair must be
 * specified. If <b>OrderID</b> or <b>OrderLineItemID</b> are specified, the
 * <b>ItemID</b>/<b>TransactionID</b> pair is ignored if present in the same request.
 * <br> <B>Input property:</B> <code>OrderID</code> - A unique identifier that identifies a single line item or multiple line item order associated with the Selling Manager sale record(s).
 * <br><br>
 * If an <b>OrderID</b> is used in the request, the <b>OrderLineItemID</b> and
 * <b>ItemID</b>/<b>TransactionID</b> pair are ignored if they are specified in the same request.
 * <br><br>
 * <span class="tablenote"><b>Note: </b> As of June 2019, eBay has changed the format of order identifier values. The new format is a non-parsable string, globally unique across all eBay marketplaces, and consistent for both single line item and multiple line item orders. Unlike in the past, instead of just being known and exposed to the seller, these unique order identifiers will also be known and used/referenced by the buyer and eBay customer support.
 * <br><br>
 * For developers and sellers who are already integrated with the Trading API's order management calls, this change shouldn't impact your integration unless you parse the existing order identifiers (e.g., <b>OrderID</b> or <b>OrderLineItemID</b>), or otherwise infer meaning from the format (e.g., differentiating between a single line item order versus a multiple line item order). Because we realize that some integrations may have logic that is dependent upon the old identifier format, eBay is rolling out this Trading API change with version control to support a transition period of approximately 9 months before applications must switch to the new format completely.
 * <br><br>
 * During the transition period, for developers/sellers using a Trading WSDL older than Version 1113, they can use the <b>X-EBAY-API-COMPATIBILITY-LEVEL</b> HTTP header in API calls to control whether the new or old <b>OrderID</b> format is returned in call response payloads. To get the new <b>OrderID</b> format, the value of the <b>X-EBAY-API-COMPATIBILITY-LEVEL</b> HTTP header must be set to <code>1113</code>. During the transition period and even after, the new and old <b>OrderID</b> formats will still be supported/accepted in all Trading API call request payloads. After the transition period (which will be announced), only the new <b>OrderID</b> format will be returned in all Trading API call response payloads, regardless of the Trading WSDL version used or specified compatibility level.
 * </span>
 * <br>
 * <span class="tablenote"><b>Note: </b> For sellers integrated with the new order ID format, please note that the identifier for an order will change as it goes from unpaid to paid status. When using a <b>ReviseSellingManagerSaleRecord</b> call, either of these order IDs (paid or unpaid status) can be used to update a Sale Record.
 * </span>
 * <br> <B>Input property:</B> <code>SellingManagerSoldOrder</code> - Container consisting of order costs, shipping details, order status, and
 * other information. The changes made under this container will update the
 * order in Selling Manager.
 * <br> <B>Input property:</B> <code>OrderLineItemID</code> - A unique identifier for an eBay order line item. This identifier is created once there is a commitment to buy (bidder wins the auction, buyer clicks buy button, or buyer purchases item through <b>PlaceOffer</b> call).
 * <br><br>
 * Unless an <b>ItemID</b>/<b>TransactionID</b> pair is used to identify an order line item, or the <b>OrderID</b> is used to identify an order, the <b>OrderLineItemID</b> must be specified. For a multiple line item order, <b>OrderID</b> should be used. If <b>OrderLineItemID</b> is specified, the <b>ItemID</b>/<b>TransactionID</b> pair are ignored if present in the same request.
 * 
 * @author Ron Murphy
 * @version 1.0
 */

public class ReviseSellingManagerSaleRecordCall extends com.ebay.sdk.ApiCall
{
  
  private String itemID = null;
  private String transactionID = null;
  private String orderID = null;
  private SellingManagerSoldOrderType sellingManagerSoldOrder = null;
  private String orderLineItemID = null;


  /**
   * Constructor.
   */
  public ReviseSellingManagerSaleRecordCall() {
  }

  /**
   * Constructor.
   * @param apiContext The ApiContext object to be used to make the call.
   */
  public ReviseSellingManagerSaleRecordCall(ApiContext apiContext) {
    super(apiContext);
    

  }

  /**
   * Request type containing the input fields for the <b>ReviseSellingManagerSaleRecord</b>
   * call. The standard Trading API deprecation process is not applicable to this
   * call. The user must have a Selling Manager Pro subscription to use this call.
   * 
   * <br>
   * @throws ApiException
   * @throws SdkException
   * @throws Exception
   * @return The void object.
   */
  public void reviseSellingManagerSaleRecord()
      throws com.ebay.sdk.ApiException, com.ebay.sdk.SdkException, java.lang.Exception
  {
    ReviseSellingManagerSaleRecordRequestType req;
    req = new ReviseSellingManagerSaleRecordRequestType();
    if (this.itemID != null)
      req.setItemID(this.itemID);
    if (this.transactionID != null)
      req.setTransactionID(this.transactionID);
    if (this.orderID != null)
      req.setOrderID(this.orderID);
    if (this.sellingManagerSoldOrder != null)
      req.setSellingManagerSoldOrder(this.sellingManagerSoldOrder);
    if (this.orderLineItemID != null)
      req.setOrderLineItemID(this.orderLineItemID);

    ReviseSellingManagerSaleRecordResponseType resp = (ReviseSellingManagerSaleRecordResponseType) execute(req);


  }

  /**
   * Gets the ReviseSellingManagerSaleRecordRequestType.itemID.
   * @return String
   */
  public String getItemID()
  {
    return this.itemID;
  }

  /**
   * Sets the ReviseSellingManagerSaleRecordRequestType.itemID.
   * @param itemID String
   */
  public void setItemID(String itemID)
  {
    this.itemID = itemID;
  }

  /**
   * Gets the ReviseSellingManagerSaleRecordRequestType.orderID.
   * @return String
   */
  public String getOrderID()
  {
    return this.orderID;
  }

  /**
   * Sets the ReviseSellingManagerSaleRecordRequestType.orderID.
   * @param orderID String
   */
  public void setOrderID(String orderID)
  {
    this.orderID = orderID;
  }

  /**
   * Gets the ReviseSellingManagerSaleRecordRequestType.orderLineItemID.
   * @return String
   */
  public String getOrderLineItemID()
  {
    return this.orderLineItemID;
  }

  /**
   * Sets the ReviseSellingManagerSaleRecordRequestType.orderLineItemID.
   * @param orderLineItemID String
   */
  public void setOrderLineItemID(String orderLineItemID)
  {
    this.orderLineItemID = orderLineItemID;
  }

  /**
   * Gets the ReviseSellingManagerSaleRecordRequestType.sellingManagerSoldOrder.
   * @return SellingManagerSoldOrderType
   */
  public SellingManagerSoldOrderType getSellingManagerSoldOrder()
  {
    return this.sellingManagerSoldOrder;
  }

  /**
   * Sets the ReviseSellingManagerSaleRecordRequestType.sellingManagerSoldOrder.
   * @param sellingManagerSoldOrder SellingManagerSoldOrderType
   */
  public void setSellingManagerSoldOrder(SellingManagerSoldOrderType sellingManagerSoldOrder)
  {
    this.sellingManagerSoldOrder = sellingManagerSoldOrder;
  }

  /**
   * Gets the ReviseSellingManagerSaleRecordRequestType.transactionID.
   * @return String
   */
  public String getTransactionID()
  {
    return this.transactionID;
  }

  /**
   * Sets the ReviseSellingManagerSaleRecordRequestType.transactionID.
   * @param transactionID String
   */
  public void setTransactionID(String transactionID)
  {
    this.transactionID = transactionID;
  }

}

