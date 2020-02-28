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
import java.lang.Integer;
import java.util.Calendar;

import com.ebay.sdk.*;
import com.ebay.soap.eBLBaseComponents.*;
/**
 * Wrapper class of the GetOrders call of eBay SOAP API.
 * <br>
 * <p>Title: SOAP API wrapper library.</p>
 * <p>Description: Contains wrapper classes for eBay SOAP APIs.</p>
 * <p>Copyright: Copyright (c) 2009</p>
 * <p>Company: eBay Inc.</p>
 * <br> <B>Input property:</B> <code>OrderIDArray</code> - This container is used if the user wants to retrieve one or more specific orders in which they are involved as either the seller or buyer. If one or more order IDs are specified in this container, any order role, order status, or date range filters are ignored if specified in the request.
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
 * <br> <B>Input property:</B> <code>CreateTimeFrom</code> - The <b>CreateTimeFrom</b> and <b>CreateTimeTo</b> fields specify a date range for retrieving orders that were created during this time period. The <b>CreateTimeFrom</b> field is the starting date range. All eBay orders that were created within this date range are returned in the output. The maximum date range that may be specified with the <b>CreateTimeFrom</b> and <b>CreateTimeTo</b> fields is 90 days. <b>CreateTimeFrom</b>/<b>CreateTimeTo</b> date filters are ignored if the <b>NumberOfDays</b> date filter is used in the request, or if one or more order IDs are passed in the request. This value cannot be set back more than 90 days in the past, as this call cannot retrieve sales older than 90 days old.
 * <br><br>
 * <span class="tablenote"><strong>Note:</strong>
 * Unless one or more <b>OrderID</b> values are used, one of the three available date range filters must be used.
 * </span>
 * <br> <B>Input property:</B> <code>CreateTimeTo</code> - The <b>CreateTimeFrom</b> and <b>CreateTimeTo</b> fields specify a date range for retrieving orders that were created during this time period. The <b>CreateTimeTo</b> field is the ending date range. All eBay orders that were created within this date range are returned in the output. The maximum date range that may be specified with the <b>CreateTimeFrom</b> and <b>CreateTimeTo</b> fields is 90 days. If the <b>CreateTimeFrom</b> field is used and the <b>CreateTimeTo</b> field is omitted, the "TimeTo" value defaults to the present time or to 90 days past the <b>CreateTimeFrom</b> value (if <b>CreateTimeFrom</b> value is more than 90 days in the past). <b>CreateTimeFrom</b>/<b>CreateTimeTo</b> date filters are ignored if the <b>NumberOfDays</b> date filter is used in the request, or if one or more order IDs are passed in the request.
 * <br><br>
 * <span class="tablenote"><strong>Note:</strong> If a <b>GetOrders</b> call is made within a few seconds after the creation of a multiple line item order, the caller runs the risk of retrieving orders that are in an inconsistent state, since the order consolidation involved in a multiple line item order may not have been completed. For this reason, it is recommended that sellers include the <b>CreateTimeTo</b> field in the call, and set its value to: <i>Current Time</i> - 2 minutes.
 * </span>
 * <br>
 * <span class="tablenote"><strong>Note:</strong>
 * Unless one or more <b>OrderID</b> values are used, one of the three available date range filters must be used.
 * </span>
 * <br> <B>Input property:</B> <code>OrderRole</code> - This filter is used to toggle between retrieving orders based on the role of the user (seller or buyer). The order role defaults to <code>Seller</code> if this field is not used. If this field is used with a date filter, returned orders must satisfy both the date range and the <b>OrderRole</b> value.
 * <br>
 * <br> <B>Input property:</B> <code>OrderStatus</code> - The field is used to retrieve eBay orders that are in a specific state. If this field is used with a date filter, only orders that satisfy both the date range and the <b>OrderStatus</b> value are retrieved. <br><br> If one or more <b>OrderID</b> values are specified through the <b>OrderIDArray</b> container, the <b>OrderStatus</b> field should not be used, and it is ignored if it is used. If an <b>OrderStatus</b> value is not used and no <b>OrderID</b> values are specified, orders in all states are returned.
 * <br>
 * <br> <B>Input property:</B> <code>ListingType</code> - <span class="tablenote"><b>Note: </b> This field's purpose was to allow the seller to retrieve only Half.com listings. Since the Half.com site has been shut down, this field is no longer applicable.
 * </span>
 * <br> <B>Input property:</B> <code>Pagination</code> - If many orders are	available to retrieve, you may need to call <b>GetOrders</b> multiple times to retrieve all the data. Each result set is returned as a page of orders. Use the <b>Pagination</b> filters to control the maximum number of orders to retrieve per page (i.e., per call), and the page number to retrieve.
 * <br> <B>Input property:</B> <code>ModTimeFrom</code> - The <b>ModTimeFrom</b> and <b>ModTimeTo</b> fields specify a date range for retrieving existing orders that have been modified within this time period (for example, <code>Incomplete</code> status to <code>Pending</code> status or <code>Pending</code> status to <code>Complete</code> status). The <b>ModTimeFrom</b> field is the starting date range. All eBay orders that were last modified within this date range are returned in the output. Unlike the <b>CreateTimeFrom</b>/<b>CreateTimeTo</b> filters, which may cover a maximum period of 90 days, the maximum date range that may be specified with the <b>ModTimeFrom</b> and <b>ModTimeTo</b> fields is only 30 days. This value cannot be set back more than 90 days in the past, as this call cannot retrieve sales older than 90 days old. <b>ModTimeFrom</b>/<b>ModTimeTo</b> date filters are ignored if the <b>CreateTimeFrom</b>/<b>CreateTimeTo</b> or <b>NumberOfDays</b> date filters are used in the request, or if one or more order IDs are passed in the request.
 * <br><br>
 * <span class="tablenote"><strong>Note:</strong>
 * Unless one or more <b>OrderID</b> values are used, one of the three available date range filters must be used.
 * </span>
 * <br> <B>Input property:</B> <code>ModTimeTo</code> - The <b>ModTimeFrom</b> and <b>ModTimeTo</b> fields specify a date range for retrieving existing orders that have been modified within this time window (for example, <code>Incomplete</code> status to <code>Pending</code> status or <code>Pending</code> status to <code>Complete</code> status). The <b>ModTimeTo</b> field is the ending date range. All eBay orders that were last modified within this date range are returned in the output. Unlike the <b>CreateTimeFrom</b>/<b>CreateTimeTo</b> filters, which may cover a maximum period of 90 days, the maximum date range that may be specified with the <b>ModTimeFrom</b> and <b>ModTimeTo</b> fields is 30 days. If the <b>ModTimeFrom</b> field is used and the <b>ModTimeTo</b> field is omitted, the 'TimeTo' value defaults to the present time (if <b>ModTimeFrom</b> value is less than 30 days in the past) or to 30 days past the <b>ModTimeFrom</b> value. <b>ModTimeFrom</b>/<b>ModTimeTo</b> date filters are ignored if the <b>CreateTimeFrom</b>/<b>CreateTimeTo</b> or <b>NumberOfDays</b> date filters are used in the request, or if one or more order IDs are passed in the request.
 * <br><br>
 * <span class="tablenote"><strong>Note:</strong>
 * Unless one or more <b>OrderID</b> values are used, one of the three available date range filters must be used.
 * </span>
 * <br> <B>Input property:</B> <code>NumberOfDays</code> - This filter specifies the number of days (24-hour periods) in the past to search for orders. All eBay orders that were either created or modified within this period are returned in the output. This field cannot be used in conjunction with the <b>CreateTimeFrom</b>/<b>CreateTimeTo</b> or <b>ModTimeFrom</b>/<b>ModTimeTo</b> date filters.
 * <br><br>
 * <span class="tablenote"><strong>Note:</strong>
 * This date filter only allows you to retrieve orders created/modified within the last 30 days. So, if you wish to retrieve orders created and/or modified more than 30 days in the past, the <b>CreateTimeFrom</b>/<b>CreateTimeTo</b> or <b>ModTimeFrom</b>/<b>ModTimeTo</b> date filters should be used instead.
 * </span>
 * <br>
 * <span class="tablenote"><strong>Note:</strong>
 * Unless one or more <b>OrderID</b> values are used, one of the three available date range filters must be used.
 * </span>
 * <br> <B>Input property:</B> <code>IncludeFinalValueFee</code> - This field is included and set to <code>true</code> if the user wants to view the Final Value Fee (FVF) for all orders in the response. The Final Value Fee is returned in the <b>Transaction.FinalValueFee</b> field. The Final Value Fee is assessed right after the creation of an order line item.
 * <br/>
 * <br> <B>Input property:</B> <code>SortingOrder</code> - This filter controls whether orders are retrieved in ascending order (oldest to newest according to modification date) or descending order (newest to oldest according to modification date). The default is <code>Ascending</code>, so the user will need to include this field and set it to <code>Descending</code> if the user wishes to view the most recent orders first in the retrieved output.
 * <br>
 * <br> <B>Output property:</B> <code>ReturnedPaginationResult</code> - Contains information regarding the pagination of data, including the total number of pages and the total number of orders.
 * <br> <B>Output property:</B> <code>ReturnedHasMoreOrders</code> - A true value indicates that there are more orders to be retrieved. Additional <b>GetOrders</b> calls with higher page numbers or more entries per page must be made to retrieve these orders. If false, no more orders are available or no orders match the request (based on the input filters).
 * <br> <B>Output property:</B> <code>ReturnedOrderArray</code> - The set of orders that match the order IDs or filter criteria specified.
 * <br> <B>Output property:</B> <code>ReturnedOrdersPerPage</code> - Indicates the number of orders that can be returned per page of data (i.e., per call). This is the same value specified in the <b>Pagination.EntriesPerPage</b> input (or the default value, if <b>EntriesPerPage</b> was not specified). This is not necessarily the actual number of orders returned per page (see <b>ReturnedOrderCountActual</b>).
 * <br> <B>Output property:</B> <code>ReturnedPageNumber</code> - Indicates the page number of data returned in the response. This is the same value specified in the <b>Pagination.PageNumber</b> input. If orders are returned, the first page is 1.
 * <br> <B>Output property:</B> <code>ReturnedReturnedOrderCountActual</code> - Indicates the total number of orders returned.
 * 
 * @author Ron Murphy
 * @version 1.0
 */

public class GetOrdersCall extends com.ebay.sdk.ApiCall
{
  
  private OrderIDArrayType orderIDArray = null;
  private Calendar createTimeFrom = null;
  private Calendar createTimeTo = null;
  private TradingRoleCodeType orderRole = null;
  private OrderStatusCodeType orderStatus = null;
  private ListingTypeCodeType listingType = null;
  private PaginationType pagination = null;
  private Calendar modTimeFrom = null;
  private Calendar modTimeTo = null;
  private Integer numberOfDays = null;
  private Boolean includeFinalValueFee = null;
  private SortOrderCodeType sortingOrder = null;
  private PaginationResultType returnedPaginationResult=null;
  private Boolean returnedHasMoreOrders=null;
  private OrderType[] returnedOrderArray=null;
  private Integer returnedOrdersPerPage=null;
  private Integer returnedPageNumber=null;
  private Integer returnedReturnedOrderCountActual=null;


  /**
   * Constructor.
   */
  public GetOrdersCall() {
  }

  /**
   * Constructor.
   * @param apiContext The ApiContext object to be used to make the call.
   */
  public GetOrdersCall(ApiContext apiContext) {
    super(apiContext);
    

  }

  /**
   * Retrieves the orders for which the authenticated user is a participant, either as the buyer or the seller. The call returns all the orders that meet the request criteria. Orders older than 90 days old will not be returned.
   * 
   * <br>
   * @throws ApiException
   * @throws SdkException
   * @throws Exception
   * @return The OrderType[] object.
   */
  public OrderType[] getOrders()
      throws com.ebay.sdk.ApiException, com.ebay.sdk.SdkException, java.lang.Exception
  {
    GetOrdersRequestType req;
    req = new GetOrdersRequestType();
    req.setDetailLevel(this.getDetailLevel());
    if (this.orderIDArray != null)
      req.setOrderIDArray(this.orderIDArray);
    if (this.createTimeFrom != null)
      req.setCreateTimeFrom(this.createTimeFrom);
    if (this.createTimeTo != null)
      req.setCreateTimeTo(this.createTimeTo);
    if (this.orderRole != null)
      req.setOrderRole(this.orderRole);
    if (this.orderStatus != null)
      req.setOrderStatus(this.orderStatus);
    if (this.listingType != null)
      req.setListingType(this.listingType);
    if (this.pagination != null)
      req.setPagination(this.pagination);
    if (this.modTimeFrom != null)
      req.setModTimeFrom(this.modTimeFrom);
    if (this.modTimeTo != null)
      req.setModTimeTo(this.modTimeTo);
    if (this.numberOfDays != null)
      req.setNumberOfDays(this.numberOfDays);
    if (this.includeFinalValueFee != null)
      req.setIncludeFinalValueFee(this.includeFinalValueFee);
    if (this.sortingOrder != null)
      req.setSortingOrder(this.sortingOrder);

    GetOrdersResponseType resp = (GetOrdersResponseType) execute(req);

    this.returnedPaginationResult = resp.getPaginationResult();
    this.returnedHasMoreOrders = resp.isHasMoreOrders();
    this.returnedOrderArray = (resp.getOrderArray() == null? null: resp.getOrderArray().getOrder());
    this.returnedOrdersPerPage = resp.getOrdersPerPage();
    this.returnedPageNumber = resp.getPageNumber();
    this.returnedReturnedOrderCountActual = resp.getReturnedOrderCountActual();
    return this.getReturnedOrderArray();
  }

  /**
   * Gets the GetOrdersRequestType.createTimeFrom.
   * @return Calendar
   */
  public Calendar getCreateTimeFrom()
  {
    return this.createTimeFrom;
  }

  /**
   * Sets the GetOrdersRequestType.createTimeFrom.
   * @param createTimeFrom Calendar
   */
  public void setCreateTimeFrom(Calendar createTimeFrom)
  {
    this.createTimeFrom = createTimeFrom;
  }

  /**
   * Gets the GetOrdersRequestType.createTimeTo.
   * @return Calendar
   */
  public Calendar getCreateTimeTo()
  {
    return this.createTimeTo;
  }

  /**
   * Sets the GetOrdersRequestType.createTimeTo.
   * @param createTimeTo Calendar
   */
  public void setCreateTimeTo(Calendar createTimeTo)
  {
    this.createTimeTo = createTimeTo;
  }

  /**
   * Gets the GetOrdersRequestType.includeFinalValueFee.
   * @return Boolean
   */
  public Boolean getIncludeFinalValueFee()
  {
    return this.includeFinalValueFee;
  }

  /**
   * Sets the GetOrdersRequestType.includeFinalValueFee.
   * @param includeFinalValueFee Boolean
   */
  public void setIncludeFinalValueFee(Boolean includeFinalValueFee)
  {
    this.includeFinalValueFee = includeFinalValueFee;
  }

  /**
   * Gets the GetOrdersRequestType.listingType.
   * @return ListingTypeCodeType
   */
  public ListingTypeCodeType getListingType()
  {
    return this.listingType;
  }

  /**
   * Sets the GetOrdersRequestType.listingType.
   * @param listingType ListingTypeCodeType
   */
  public void setListingType(ListingTypeCodeType listingType)
  {
    this.listingType = listingType;
  }

  /**
   * Gets the GetOrdersRequestType.modTimeFrom.
   * @return Calendar
   */
  public Calendar getModTimeFrom()
  {
    return this.modTimeFrom;
  }

  /**
   * Sets the GetOrdersRequestType.modTimeFrom.
   * @param modTimeFrom Calendar
   */
  public void setModTimeFrom(Calendar modTimeFrom)
  {
    this.modTimeFrom = modTimeFrom;
  }

  /**
   * Gets the GetOrdersRequestType.modTimeTo.
   * @return Calendar
   */
  public Calendar getModTimeTo()
  {
    return this.modTimeTo;
  }

  /**
   * Sets the GetOrdersRequestType.modTimeTo.
   * @param modTimeTo Calendar
   */
  public void setModTimeTo(Calendar modTimeTo)
  {
    this.modTimeTo = modTimeTo;
  }

  /**
   * Gets the GetOrdersRequestType.numberOfDays.
   * @return Integer
   */
  public Integer getNumberOfDays()
  {
    return this.numberOfDays;
  }

  /**
   * Sets the GetOrdersRequestType.numberOfDays.
   * @param numberOfDays Integer
   */
  public void setNumberOfDays(Integer numberOfDays)
  {
    this.numberOfDays = numberOfDays;
  }

  /**
   * Gets the GetOrdersRequestType.orderIDArray.
   * @return OrderIDArrayType
   */
  public OrderIDArrayType getOrderIDArray()
  {
    return this.orderIDArray;
  }

  /**
   * Sets the GetOrdersRequestType.orderIDArray.
   * @param orderIDArray OrderIDArrayType
   */
  public void setOrderIDArray(OrderIDArrayType orderIDArray)
  {
    this.orderIDArray = orderIDArray;
  }

  /**
   * Gets the GetOrdersRequestType.orderRole.
   * @return TradingRoleCodeType
   */
  public TradingRoleCodeType getOrderRole()
  {
    return this.orderRole;
  }

  /**
   * Sets the GetOrdersRequestType.orderRole.
   * @param orderRole TradingRoleCodeType
   */
  public void setOrderRole(TradingRoleCodeType orderRole)
  {
    this.orderRole = orderRole;
  }

  /**
   * Gets the GetOrdersRequestType.orderStatus.
   * @return OrderStatusCodeType
   */
  public OrderStatusCodeType getOrderStatus()
  {
    return this.orderStatus;
  }

  /**
   * Sets the GetOrdersRequestType.orderStatus.
   * @param orderStatus OrderStatusCodeType
   */
  public void setOrderStatus(OrderStatusCodeType orderStatus)
  {
    this.orderStatus = orderStatus;
  }

  /**
   * Gets the GetOrdersRequestType.pagination.
   * @return PaginationType
   */
  public PaginationType getPagination()
  {
    return this.pagination;
  }

  /**
   * Sets the GetOrdersRequestType.pagination.
   * @param pagination PaginationType
   */
  public void setPagination(PaginationType pagination)
  {
    this.pagination = pagination;
  }

  /**
   * Gets the GetOrdersRequestType.sortingOrder.
   * @return SortOrderCodeType
   */
  public SortOrderCodeType getSortingOrder()
  {
    return this.sortingOrder;
  }

  /**
   * Sets the GetOrdersRequestType.sortingOrder.
   * @param sortingOrder SortOrderCodeType
   */
  public void setSortingOrder(SortOrderCodeType sortingOrder)
  {
    this.sortingOrder = sortingOrder;
  }

  /**
   * Valid after executing the API.
   * Gets the returned GetOrdersResponseType.returnedHasMoreOrders.
   * 
   * @return Boolean
   */
  public Boolean getReturnedHasMoreOrders()
  {
    return this.returnedHasMoreOrders;
  }

  /**
   * Valid after executing the API.
   * Gets the returned GetOrdersResponseType.returnedOrderArray.
   * 
   * @return OrderType[]
   */
  public OrderType[] getReturnedOrderArray()
  {
    return this.returnedOrderArray;
  }

  /**
   * Valid after executing the API.
   * Gets the returned GetOrdersResponseType.returnedOrdersPerPage.
   * 
   * @return Integer
   */
  public Integer getReturnedOrdersPerPage()
  {
    return this.returnedOrdersPerPage;
  }

  /**
   * Valid after executing the API.
   * Gets the returned GetOrdersResponseType.returnedPageNumber.
   * 
   * @return Integer
   */
  public Integer getReturnedPageNumber()
  {
    return this.returnedPageNumber;
  }

  /**
   * Valid after executing the API.
   * Gets the returned GetOrdersResponseType.returnedPaginationResult.
   * 
   * @return PaginationResultType
   */
  public PaginationResultType getReturnedPaginationResult()
  {
    return this.returnedPaginationResult;
  }

  /**
   * Valid after executing the API.
   * Gets the returned GetOrdersResponseType.returnedReturnedOrderCountActual.
   * 
   * @return Integer
   */
  public Integer getReturnedReturnedOrderCountActual()
  {
    return this.returnedReturnedOrderCountActual;
  }

}

