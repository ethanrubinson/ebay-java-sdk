/*
Copyright (c) 2013 eBay, Inc.
This program is licensed under the terms of the eBay Common Development and
Distribution License (CDDL) Version 1.0 (the "License") and any subsequent  version 
thereof released by eBay.  The then-current version of the License can be found 
at http://www.opensource.org/licenses/cddl1.php and in the eBaySDKLicense file that 
is under the eBay SDK ../docs directory.
*/

package com.ebay.sdk.call;

import java.util.Calendar;

import com.ebay.sdk.*;
import com.ebay.soap.eBLBaseComponents.*;
/**
 * Wrapper class of the AddOrder call of eBay SOAP API.
 * <br>
 * <p>Title: SOAP API wrapper library.</p>
 * <p>Description: Contains wrapper classes for eBay SOAP APIs.</p>
 * <p>Copyright: Copyright (c) 2009</p>
 * <p>Company: eBay Inc.</p>
 * <br> <B>Input property:</B> <code>Order</code> - The root container of the <b>AddOrder</b> request. In this call, the seller identifies two or more unpaid order line items from the same buyer through the <b>TransactionArray</b> container, specifies one or more accepted payment methods through the <b>PaymentMethods</b> field(s), and specifies available shipping services and other shipping details through the <b>ShippingDetails</b> container.
 * <br> <B>Output property:</B> <code>ReturnedOrderID</code> - The unique identifier of the successfully-created 'Combined Invoice' order. This value is only created and returned if the <b>AddOrder</b> call is successful in creating the new order.
 * <br/><br/>
 * This value can be used as an input filter in <b>GetOrders</b> and <b>GetOrderTransactions</b> calls to retrieve the order.
 * <br><br>
 * <span class="tablenote"><b>Note: </b> As of June 2019, eBay has changed the format of order identifier values. The new format is a non-parsable string, globally unique across all eBay marketplaces, and consistent for both single line item and multiple line item orders. Unlike in the past, instead of just being known and exposed to the seller, these unique order identifiers will also be known and used/referenced by the buyer and eBay customer support.
 * <br><br>
 * For developers and sellers who are already integrated with the Trading API's order management calls, this change shouldn't impact your integration unless you parse the existing order identifiers (e.g., <b>OrderID</b> or <b>OrderLineItemID</b>), or otherwise infer meaning from the format (e.g., differentiating between a single line item order versus a multiple line item order). Because we realize that some integrations may have logic that is dependent upon the old identifier format, eBay is rolling out this Trading API change with version control to support a transition period of approximately 9 months before applications must switch to the new format completely.
 * <br><br>
 * During the transition period, for developers/sellers using a Trading WSDL older than Version 1113, they can use the <b>X-EBAY-API-COMPATIBILITY-LEVEL</b> HTTP header in API calls to control whether the new or old <b>OrderID</b> format is returned in call response payloads. To get the new <b>OrderID</b> format, the value of the <b>X-EBAY-API-COMPATIBILITY-LEVEL</b> HTTP header must be set to <code>1113</code>. During the transition period and even after, the new and old <b>OrderID</b> formats will still be supported/accepted in all Trading API call request payloads. After the transition period (which will be announced), only the new <b>OrderID</b> format will be returned in all Trading API call response payloads, regardless of the Trading WSDL version used or specified compatibility level.
 * </span>
 * <br>
 * <span class="tablenote"><b>Note: </b> For sellers integrated with the new order ID format, please note that the identifier for an order will change as it goes from unpaid to paid status. Sellers can check to see if an order has been paid by looking for a value of 'Complete' in the <b>CheckoutStatus.Status</b> field in the response of <b>GetOrders</b> or <b>GetOrderTransactions</b> call, or in the <b>Status.CompleteStatus</b> field in the response of <b>GetItemTransactions</b> or <b>GetSellerTransactions</b> call. Sellers should  not fulfill orders until buyer has made payment. When using a <b>GetOrders</b> or <b>GetOrderTransactions</b> call to retrieve specific order(s), either of these order IDs (paid or unpaid status) can be used to retrieve an order.
 * </span>
 * <br> <B>Output property:</B> <code>ReturnedCreatedTime</code> - Timestamp that indicates the date and time that the 'Combined Invoice' order was created.
 * 
 * @author Ron Murphy
 * @version 1.0
 */

public class AddOrderCall extends com.ebay.sdk.ApiCall
{
  
  private OrderType order = null;
  private String returnedOrderID=null;
  private Calendar returnedCreatedTime=null;


  /**
   * Constructor.
   */
  public AddOrderCall() {
  }

  /**
   * Constructor.
   * @param apiContext The ApiContext object to be used to make the call.
   */
  public AddOrderCall(ApiContext apiContext) {
    super(apiContext);
    

  }

  /**
   * The <b>AddOrder</b> call can be used by a seller to combine two or more unpaid, single line item orders from the same buyer into one 'Combined Invoice' order with multiple line items. Once multiple line items are combined into one order, the buyer can make one single payment for multiple line item order. If possible and agreed to, the seller can then ship multiple line items in the same shipping package, saving on shipping costs, and possibly passing that savings down to the buyer through Combined Shipping Discount rules set up in My eBay.
   * 
   * <br>
   * @throws ApiException
   * @throws SdkException
   * @throws Exception
   * @return The AddOrderResponseType object.
   */
  public AddOrderResponseType addOrder()
      throws com.ebay.sdk.ApiException, com.ebay.sdk.SdkException, java.lang.Exception
  {
    AddOrderRequestType req;
    req = new AddOrderRequestType();
    if (this.order != null)
      req.setOrder(this.order);

    AddOrderResponseType resp = (AddOrderResponseType) execute(req);

    this.returnedOrderID = resp.getOrderID();
    this.returnedCreatedTime = resp.getCreatedTime();
    return resp;
  }

  /**
   * Gets the AddOrderRequestType.order.
   * @return OrderType
   */
  public OrderType getOrder()
  {
    return this.order;
  }

  /**
   * Sets the AddOrderRequestType.order.
   * @param order OrderType
   */
  public void setOrder(OrderType order)
  {
    this.order = order;
  }

  /**
   * Valid after executing the API.
   * Gets the returned AddOrderResponseType.returnedCreatedTime.
   * 
   * @return Calendar
   */
  public Calendar getReturnedCreatedTime()
  {
    return this.returnedCreatedTime;
  }

  /**
   * Valid after executing the API.
   * Gets the returned AddOrderResponseType.returnedOrderID.
   * 
   * @return String
   */
  public String getReturnedOrderID()
  {
    return this.returnedOrderID;
  }

}

