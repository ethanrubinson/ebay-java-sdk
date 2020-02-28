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

import com.ebay.sdk.*;
import com.ebay.soap.eBLBaseComponents.*;
/**
 * Wrapper class of the GetOrderTransactions call of eBay SOAP API.
 * <br>
 * <p>Title: SOAP API wrapper library.</p>
 * <p>Description: Contains wrapper classes for eBay SOAP APIs.</p>
 * <p>Copyright: Copyright (c) 2009</p>
 * <p>Company: eBay Inc.</p>
 * <br> <B>Input property:</B> <code>ItemTransactionIDArray</code> - This container is used if the seller wants to retrieve for one or more order line items. An <b>ItemTransactionID</b> container is required for each order line item that is to be retrieved.  An order line item can be identified with an <b>ItemID</b>/<b>TransactionID</b> pair, with an <b>OrderLineItemID</b> value, or with a <b>SKU</b> value (if a SKU is defined for the order line item).
 * <br> <B>Input property:</B> <code>OrderIDArray</code> - This container is used if the seller wants to search for one or more orders. An <b>OrderID</b> field is required for each order that is to be retrieved.  Up to 20 <b>OrderID</b> fields can be used.
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
 * <br> <B>Input property:</B> <code>Platform</code> - <span class="tablenote"><b>Note: </b> This field should no longer be used since its sole purpose was to allow the seller to filter between eBay orders and Half.com orders, and the Half.com site no longer exists.
 * </span>
 * <br> <B>Input property:</B> <code>IncludeFinalValueFees</code> - This field is included and set to <code>true</code> if the user wants to view the Final Value Fee (FVF) for all order line items in the response. The Final Value Fee is returned in the <b>Transaction.FinalValueFee</b> field. The Final Value Fee is assessed right after the creation of an order line item.
 * <br/>
 * <br> <B>Output property:</B> <code>ReturnedOrderArray</code> - This container consists of an array of eBay orders that match the input criteria that was passed into the call request.
 * 
 * @author Ron Murphy
 * @version 1.0
 */

public class GetOrderTransactionsCall extends com.ebay.sdk.ApiCall
{
  
  private ItemTransactionIDArrayType itemTransactionIDArray = null;
  private OrderIDArrayType orderIDArray = null;
  private TransactionPlatformCodeType platform = null;
  private Boolean includeFinalValueFees = null;
  private OrderArrayType returnedOrderArray=null;


  /**
   * Constructor.
   */
  public GetOrderTransactionsCall() {
  }

  /**
   * Constructor.
   * @param apiContext The ApiContext object to be used to make the call.
   */
  public GetOrderTransactionsCall(ApiContext apiContext) {
    super(apiContext);
    

  }

  /**
   * The base request type for the <b>GetOrderTransactions</b> call. This call retrieves detailed information about one or more orders or order line items created (or modified) in the last 90 days.
   * <br><br>
   * Unlike <b>GetOrders</b>, which can be used to retrieve specific orders, or orders created (or modified) within a specific time period, the <b>GetOrderTransactions</b> call only supports the retrieval of specific orders and/or order line items.
   * 
   * <br>
   * @throws ApiException
   * @throws SdkException
   * @throws Exception
   * @return The OrderArrayType object.
   */
  public OrderArrayType getOrderTransactions()
      throws com.ebay.sdk.ApiException, com.ebay.sdk.SdkException, java.lang.Exception
  {
    GetOrderTransactionsRequestType req;
    req = new GetOrderTransactionsRequestType();
    if (this.itemTransactionIDArray != null)
      req.setItemTransactionIDArray(this.itemTransactionIDArray);
    if (this.orderIDArray != null)
      req.setOrderIDArray(this.orderIDArray);
    if (this.platform != null)
      req.setPlatform(this.platform);
    if (this.includeFinalValueFees != null)
      req.setIncludeFinalValueFees(this.includeFinalValueFees);

    GetOrderTransactionsResponseType resp = (GetOrderTransactionsResponseType) execute(req);

    this.returnedOrderArray = resp.getOrderArray();
    return this.getReturnedOrderArray();
  }

  /**
   * Gets the GetOrderTransactionsRequestType.includeFinalValueFees.
   * @return Boolean
   */
  public Boolean getIncludeFinalValueFees()
  {
    return this.includeFinalValueFees;
  }

  /**
   * Sets the GetOrderTransactionsRequestType.includeFinalValueFees.
   * @param includeFinalValueFees Boolean
   */
  public void setIncludeFinalValueFees(Boolean includeFinalValueFees)
  {
    this.includeFinalValueFees = includeFinalValueFees;
  }

  /**
   * Gets the GetOrderTransactionsRequestType.itemTransactionIDArray.
   * @return ItemTransactionIDArrayType
   */
  public ItemTransactionIDArrayType getItemTransactionIDArray()
  {
    return this.itemTransactionIDArray;
  }

  /**
   * Sets the GetOrderTransactionsRequestType.itemTransactionIDArray.
   * @param itemTransactionIDArray ItemTransactionIDArrayType
   */
  public void setItemTransactionIDArray(ItemTransactionIDArrayType itemTransactionIDArray)
  {
    this.itemTransactionIDArray = itemTransactionIDArray;
  }

  /**
   * Gets the GetOrderTransactionsRequestType.orderIDArray.
   * @return OrderIDArrayType
   */
  public OrderIDArrayType getOrderIDArray()
  {
    return this.orderIDArray;
  }

  /**
   * Sets the GetOrderTransactionsRequestType.orderIDArray.
   * @param orderIDArray OrderIDArrayType
   */
  public void setOrderIDArray(OrderIDArrayType orderIDArray)
  {
    this.orderIDArray = orderIDArray;
  }

  /**
   * Gets the GetOrderTransactionsRequestType.platform.
   * @return TransactionPlatformCodeType
   */
  public TransactionPlatformCodeType getPlatform()
  {
    return this.platform;
  }

  /**
   * Sets the GetOrderTransactionsRequestType.platform.
   * @param platform TransactionPlatformCodeType
   */
  public void setPlatform(TransactionPlatformCodeType platform)
  {
    this.platform = platform;
  }

  /**
   * Valid after executing the API.
   * Gets the returned GetOrderTransactionsResponseType.returnedOrderArray.
   * 
   * @return OrderArrayType
   */
  public OrderArrayType getReturnedOrderArray()
  {
    return this.returnedOrderArray;
  }

}

