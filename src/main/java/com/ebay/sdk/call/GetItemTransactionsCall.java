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
import java.lang.String;
import java.util.Calendar;

import com.ebay.sdk.*;
import com.ebay.soap.eBLBaseComponents.*;
/**
 * Wrapper class of the GetItemTransactions call of eBay SOAP API.
 * <br>
 * <p>Title: SOAP API wrapper library.</p>
 * <p>Description: Contains wrapper classes for eBay SOAP APIs.</p>
 * <p>Copyright: Copyright (c) 2009</p>
 * <p>Company: eBay Inc.</p>
 * <br> <B>Input property:</B> <code>ItemID</code> - Unique identifier for an eBay listing. A listing can have multiple order line items, but only one <b>ItemID</b>. When you use <b>ItemID</b> alone, eBay returns all order line items that are associated with the <b>ItemID</b>. If you pair <b>ItemID</b> with a specific <b>TransactionID</b>, data on a specific order line item is returned. An <b>OrderLineItemID</b> value can be used instead of an <b>ItemID</b>/<b>TransactionID</b> pair to identify an order line item, and if an <b>OrderLineItemID</b> is specified in the request, any <b>ItemID</b>/<b>TransactionID</b> pair specified in the same request is ignored.
 * <br>
 * <br>
 * <span class="tablenote"><b>Note:</b>
 * <b>GetItemTransactions</b> doesn't support SKU as an input because this
 * call requires an identifier that is unique across your active
 * and ended listings. Even when <b>InventoryTrackingMethod</b> is set to
 * <b>SKU</b> in a listing, the SKU is only unique across your active
 * listings (not your ended listings). To retrieve order line items
 * by SKU, use <b>GetSellerTransactions</b> or <b>GetOrderTransactions</b> instead.
 * </span>
 * <br> <B>Input property:</B> <code>ModifiedTimeFilter</code> - Helper wrapper to set GetItemTransactionsRequestType ModTimeFrom, ModTimeTo:
 * TimeFrom sets GetItemTransactionsRequestType.ModTimeFrom: 
 * The <b>ModTimeFrom</b> and <b>ModTimeTo</b> fields specify a date range for retrieving order line items associated with the specified <b>ItemID</b> value.  The <b>ModTimeFrom</b> field is the starting date range. All of the listing's order line items that were generated (or last modified)within this date range are returned in the output.  The maximum date range that may be specified is 30 days. This value cannot be set back more than 90 days in the past, as this call cannot retrieve sales older than 90 days old. The maximum date range that may be specified is 30 days. This field is not applicable (and is ignored) if the user is looking for a specific order line item by either using an <b>ItemID</b>/<b>TransactionID</b> pair, or an <b>OrderLineItemID</b> value.
 * TimeTo sets GetItemTransactionsRequestType.ModTimeTo: 
 * The <b>ModTimeFrom</b> and <b>ModTimeTo</b> fields specify a date range for retrieving order line items associated with the specified <b>ItemID</b> value. The <b>ModTimeTo</b> field is the ending date range. All eBay order line items that were generated (or last modified) within this date range are returned in the output. The maximum date range that may be specified is 30 days. If the <b>ModTimeFrom</b> field is used and the <b>ModTimeTo</b> field is omitted, the <b>ModTimeTo</b> value defaults to the present time or to 30 days after the date specified with the <b>ModTimeFrom</b> value (if <b>ModTimeFrom</b> value is more than 30 days in the past). This field is not applicable (and is ignored) if the user is looking for a specific order line item by either using an <b>ItemID</b>/<b>TransactionID</b> pair, or an <b>OrderLineItemID</b> value.
 * <br> <B>Input property:</B> <code>TransactionID</code> - Include a <b>TransactionID</b> field in the request if you want to retrieve the data for a specific order line item for the listing specified in the <b>ItemID</b> field. This field is really only applicable for a multiple-quantity or multiple-variation, fixed-price listing that may have multiple sales. An auction listing or a single-quantity, fixed-price listing will only result in one order line item, so this field is not needed in these two cases. If an <b>OrderLineItemID</b> value is used instead to identify an order line item, this field is ignored.
 * <br><br>
 * If this field is used, any specified date filter is ignored.
 * <br> <B>Input property:</B> <code>Pagination</code> - This container controls how many order line items should be returned per page of data, as well as which page of data to return (if there are multiple pages of order line items).  Use the <b>EntriesPerPage</b> property to control the number of order line items to return per call and the <b>PageNumber</b> property to specify the specific page of data to return. If multiple pages of order line items are returned based on input criteria and <b>Pagination</b> properties, <b>GetItemTransactions</b> will need to be called multiple times (with the <b>PageNumber</b> value being increased by 1 each time) to scroll through all results.
 * <br> <B>Input property:</B> <code>IncludeFinalValueFee</code> - This field is included and set to <code>true</code> if the user wants to view the Final Value Fee (FVF) for all order line items in the response. The Final Value Fee is returned in the <b>Transaction.FinalValueFee</b> field. The Final Value Fee is assessed right after the creation of an order line item.
 * <br/><br/>
 * <br> <B>Input property:</B> <code>IncludeContainingOrder</code> - This field is included and set to <code>true</code> if the user wants to view order-level details, including the unique identifier of the order and the status of the order. The order-level details will be shown in the <b>ContainingOrder</b> container in the response.
 * <br/>
 * <br> <B>Input property:</B> <code>Platform</code> - <span class="tablenote"><b>Note: </b> This field is should no longer be used, as its purpose in the past was to give the user the ability to retrieve only eBay marketplace order line items or only Half.com listings, and since the Half.com site no longer exists, this field is no longer relevant.
 * </span>
 * <br> <B>Input property:</B> <code>NumberOfDays</code> - This date range filter specifies the number of days (24-hour periods) in the past to search for order line items. All eBay order line items that were either created or modified within this period are returned in the response. If specified, <b>NumberOfDays</b> will override any date range specified with the <b>ModTimeFrom</b>/<b>ModTimeTo</b> date range filters. This field is not applicable if a specific order line item is specified either through an <b>ItemID</b><b>TransactionID</b> pair or an <b>OrderLineItemID</b> value.
 * <br> <B>Input property:</B> <code>IncludeVariations</code> - If this field is included in the request and set to <code>true</code>, details on all variations defined in the specified multiple-variation listing are returned, including variations that have no sales. If this field is not included in the request or set to <code>false</code>, the variations with sales are still returned in separate <b>Transaction</b> nodes. This information is intended to help sellers to reconcile their local inventory with eBay's records, while processing order line items (without requiring a separate call to <b>GetItem</b>).
 * <br> <B>Input property:</B> <code>OrderLineItemID</code> - A unique identifier for an eBay order line item. This identifier is created once there is a commitment to buy (bidder wins the auction, buyer clicks buy button, or buyer purchases item through <b>PlaceOffer</b> call). If you want to retrieve data on a
 * specific order line item, you can use an <b>OrderLineItemID</b> value in the
 * request instead of an <b>ItemID</b>/<b>TransactionID</b> pair. If an <b>OrderLineItemID</b> is
 * provided, any specified date range filter is ignored.
 * <br> <B>Output property:</B> <code>PaginationResult</code> - Contains the total number of pages (<b>TotalNumberOfPages</b>) and the total number
 * of entries (<b>TotalNumberOfEntries</b>) that could be returned given repeated calls
 * that use the same selection criteria as the call that returned this response.
 * <br> <B>Output property:</B> <code>HasMoreTransactions</code> - Indicates whether there are additional order line items to retrieve.
 * That is, indicates whether more pages of data are available to be
 * returned, given the filters that were specified in the request.
 * Returns false for the last page of data.
 * <br> <B>Output property:</B> <code>ReturnedTransactionsPerPage</code> - Number of order line items returned per page (per call). May be a higher value
 * than <b>ReturnedTransactionCountActual</b> if the page returned is the last page
 * and more than one page of data exists.
 * <br> <B>Output property:</B> <code>ReturnedPageNumber</code> - Page number for the page of order line items the response returned.
 * <br> <B>Output property:</B> <code>ReturnedTransactionCountActual</code> - Number of order line items retrieved in the current page of results just returned.
 * May be a lower value than <b>TransactionsPerPage</b> if the page returned is the last
 * page and more than one page of data exists.
 * <br> <B>Output property:</B> <code>Item</code> - <b>Item</b> object that spawned the order line item. It is a purchase from this item's listing
 * that the order line item represents.
 * <br> <B>Output property:</B> <code>ReturnedTransactions</code> - List of <b>Transaction</b> objects representing the order line items resulting
 * from the listing. Each <b>Transaction</b> object contains the data for one purchase
 * (of one or more items in the same listing). The <b>Transaction.Item</b> field is not
 * returned because the <b>Item</b> object is returned at the root level of the response.
 * See the reference guide for more information about the fields that are returned.
 * <br> <B>Output property:</B> <code>PayPalPreferred</code> - Indicates whether the item's seller has the preference enabled that shows
 * that the seller prefers PayPal as the method of payment for an item. This
 * preference is indicated on an item's View Item page and is intended to
 * influence a buyer to use PayPal
 * to pay for the item.
 * 
 * @author Ron Murphy
 * @version 1.0
 */

public class GetItemTransactionsCall extends com.ebay.sdk.ApiCall
{
  
  private String itemID = null;
  private TimeFilter modifiedTimeFilter = null;
  private String transactionID = null;
  private PaginationType pagination = null;
  private Boolean includeFinalValueFee = null;
  private Boolean includeContainingOrder = null;
  private TransactionPlatformCodeType platform = null;
  private Integer numberOfDays = null;
  private Boolean includeVariations = null;
  private String orderLineItemID = null;
  private PaginationResultType paginationResult=null;
  private boolean hasMoreTransactions=false;
  private Integer returnedTransactionsPerPage=null;
  private Integer returnedPageNumber=null;
  private int returnedTransactionCountActual=0;
  private ItemType item=null;
  private TransactionType[] returnedTransactions=null;
  private boolean payPalPreferred=false;


  /**
   * Constructor.
   */
  public GetItemTransactionsCall() {
  }

  /**
   * Constructor.
   * @param apiContext The ApiContext object to be used to make the call.
   */
  public GetItemTransactionsCall(ApiContext apiContext) {
    super(apiContext);
    

  }

  /**
   * This  call retrieves details on one or more order line items for a specified eBay listing. Auctions and single-quantity, fixed-price listings can only have one order line item, but a multiple-quantity and/or multiple-variation, fixed-priced listing can have numerous order line items.
   * <br><br>
   * To find one or more order line items for an eBay listing, an <b>ItemID</b> value can be passed in. If a user wanted to retrieve a specific order line item, an <b>ItemID</b> value and a an <b>TransactionID</b> value can be passed in, or an <b>OrderLineItemID</b> value can be passed in instead of an <b>ItemID</b>/<b>TransactionID</b> pair.
   * <br><br>
   * The <b>NumberOfDays</b> or the <b>ModTimeFrom</b> and <b>ModTimeTo</b> date range filters can be used to retrieve order line items generated (or last modified) within a specific range of time. The maximum date range that can be set is 30 days, and the <b>ModTimeFrom</b> date value cannot be set any further back than 90 days in the past. If no date range filters are used, all order line items (associated with the specified listing) generated (or last  modified) in the last 30 days are retrieved. Date ranges are generally only used for multiple-quantity or multiple-variation, fixed-price listings that can have multiple order line items.
   * <br><br>
   * There are also pagination filters available that allow the user to control how many and which order line items are returned on each page of a results set.
   * 
   * <br>
   * @throws ApiException
   * @throws SdkException
   * @throws Exception
   * @return The TransactionType[] object.
   */
  public TransactionType[] getItemTransactions()
      throws com.ebay.sdk.ApiException, com.ebay.sdk.SdkException, java.lang.Exception
  {
    GetItemTransactionsRequestType req;
    req = new GetItemTransactionsRequestType();

    if( this.itemID == null )
      throw new SdkException("ItemID property is not set.");

    req.setDetailLevel(this.getDetailLevel());
    if (this.itemID != null)
      req.setItemID(this.itemID);
    if (this.modifiedTimeFilter != null)
    {
      req.setModTimeFrom(this.modifiedTimeFilter.getTimeFrom());
      req.setModTimeTo(this.modifiedTimeFilter.getTimeTo());
    }
    if (this.transactionID != null)
      req.setTransactionID(this.transactionID);
    if (this.pagination != null)
      req.setPagination(this.pagination);
    if (this.includeFinalValueFee != null)
      req.setIncludeFinalValueFee(this.includeFinalValueFee);
    if (this.includeContainingOrder != null)
      req.setIncludeContainingOrder(this.includeContainingOrder);
    if (this.platform != null)
      req.setPlatform(this.platform);
    if (this.numberOfDays != null)
      req.setNumberOfDays(this.numberOfDays);
    if (this.includeVariations != null)
      req.setIncludeVariations(this.includeVariations);
    if (this.orderLineItemID != null)
      req.setOrderLineItemID(this.orderLineItemID);

    GetItemTransactionsResponseType resp = (GetItemTransactionsResponseType) execute(req);

    this.paginationResult = resp.getPaginationResult();
    this.hasMoreTransactions = (resp.isHasMoreTransactions() == null? false: resp.isHasMoreTransactions().booleanValue());
    this.returnedTransactionsPerPage = resp.getTransactionsPerPage();
    this.returnedPageNumber = resp.getPageNumber();
    this.returnedTransactionCountActual = (resp.getReturnedTransactionCountActual() == null? 0: resp.getReturnedTransactionCountActual().intValue());
    this.item = resp.getItem();
    this.returnedTransactions = (resp.getTransactionArray() == null? null: resp.getTransactionArray().getTransaction());
    this.payPalPreferred = (resp.isPayPalPreferred() == null? false: resp.isPayPalPreferred().booleanValue());
    return this.getReturnedTransactions();
  }

  /**
   * Gets the GetItemTransactionsRequestType.includeContainingOrder.
   * @return Boolean
   */
  public Boolean getIncludeContainingOrder()
  {
    return this.includeContainingOrder;
  }

  /**
   * Sets the GetItemTransactionsRequestType.includeContainingOrder.
   * @param includeContainingOrder Boolean
   */
  public void setIncludeContainingOrder(Boolean includeContainingOrder)
  {
    this.includeContainingOrder = includeContainingOrder;
  }

  /**
   * Gets the GetItemTransactionsRequestType.includeFinalValueFee.
   * @return Boolean
   */
  public Boolean getIncludeFinalValueFee()
  {
    return this.includeFinalValueFee;
  }

  /**
   * Sets the GetItemTransactionsRequestType.includeFinalValueFee.
   * @param includeFinalValueFee Boolean
   */
  public void setIncludeFinalValueFee(Boolean includeFinalValueFee)
  {
    this.includeFinalValueFee = includeFinalValueFee;
  }

  /**
   * Gets the GetItemTransactionsRequestType.includeVariations.
   * @return Boolean
   */
  public Boolean getIncludeVariations()
  {
    return this.includeVariations;
  }

  /**
   * Sets the GetItemTransactionsRequestType.includeVariations.
   * @param includeVariations Boolean
   */
  public void setIncludeVariations(Boolean includeVariations)
  {
    this.includeVariations = includeVariations;
  }

  /**
   * Gets the GetItemTransactionsRequestType.itemID.
   * @return String
   */
  public String getItemID()
  {
    return this.itemID;
  }

  /**
   * Sets the GetItemTransactionsRequestType.itemID.
   * @param itemID String
   */
  public void setItemID(String itemID)
  {
    this.itemID = itemID;
  }

  /**
   * Gets the GetItemTransactionsRequestType.modifiedTimeFilter.
   * @return TimeFilter
   */
  public TimeFilter getModifiedTimeFilter()
  {
    return this.modifiedTimeFilter;
  }

  /**
   * Sets the GetItemTransactionsRequestType.modifiedTimeFilter.
   * @param modifiedTimeFilter TimeFilter
   */
  public void setModifiedTimeFilter(TimeFilter modifiedTimeFilter)
  {
    this.modifiedTimeFilter = modifiedTimeFilter;
  }

  /**
   * Gets the GetItemTransactionsRequestType.numberOfDays.
   * @return Integer
   */
  public Integer getNumberOfDays()
  {
    return this.numberOfDays;
  }

  /**
   * Sets the GetItemTransactionsRequestType.numberOfDays.
   * @param numberOfDays Integer
   */
  public void setNumberOfDays(Integer numberOfDays)
  {
    this.numberOfDays = numberOfDays;
  }

  /**
   * Gets the GetItemTransactionsRequestType.orderLineItemID.
   * @return String
   */
  public String getOrderLineItemID()
  {
    return this.orderLineItemID;
  }

  /**
   * Sets the GetItemTransactionsRequestType.orderLineItemID.
   * @param orderLineItemID String
   */
  public void setOrderLineItemID(String orderLineItemID)
  {
    this.orderLineItemID = orderLineItemID;
  }

  /**
   * Gets the GetItemTransactionsRequestType.pagination.
   * @return PaginationType
   */
  public PaginationType getPagination()
  {
    return this.pagination;
  }

  /**
   * Sets the GetItemTransactionsRequestType.pagination.
   * @param pagination PaginationType
   */
  public void setPagination(PaginationType pagination)
  {
    this.pagination = pagination;
  }

  /**
   * Gets the GetItemTransactionsRequestType.platform.
   * @return TransactionPlatformCodeType
   */
  public TransactionPlatformCodeType getPlatform()
  {
    return this.platform;
  }

  /**
   * Sets the GetItemTransactionsRequestType.platform.
   * @param platform TransactionPlatformCodeType
   */
  public void setPlatform(TransactionPlatformCodeType platform)
  {
    this.platform = platform;
  }

  /**
   * Gets the GetItemTransactionsRequestType.transactionID.
   * @return String
   */
  public String getTransactionID()
  {
    return this.transactionID;
  }

  /**
   * Sets the GetItemTransactionsRequestType.transactionID.
   * @param transactionID String
   */
  public void setTransactionID(String transactionID)
  {
    this.transactionID = transactionID;
  }
/**
   * Get all item transactions in specified date range.
   * It handles pagination internally and ignores the Pagination property.
   * GetItemTransactionsCall.ItemID and
   * GetItemTransactionsCall.ModifiedTimeFilter will be ignored.
   * @param modifiedTimeFilter TimeFilter
   * @throws ApiException
   * @throws SdkException
   * @throws Exception
   * @return TransactionType[]
   */
  public TransactionType[] getEntireItemTransactions()
      throws com.ebay.sdk.ApiException, com.ebay.sdk.SdkException, java.lang.Exception
  {
    if( this.itemID == null )
      throw new SdkException("ItemID is not set.");
    if( this.modifiedTimeFilter == null )
      throw new SdkException("ModifiedTimeFilter is not set.");
    return getEntireItemTransactions();
  }
/**
   * Execute the API call. GetItemTransactionsCall.ItemID and
   * GetItemTransactionsCall.ModifiedTimeFilter will be ignored.
   * @param itemID String Unique ID of item that you are retrieving transactions for.
   * @param modifiedTimeFilter TimeFilter Range of transactions that you are retrieving.
   * @throws ApiException
   * @throws SdkException
   * @throws Exception
   * @return TransactionType[]
   */
  public TransactionType[] getItemTransactions(String itemID, TimeFilter modifiedTimeFilter)
      throws com.ebay.sdk.ApiException, com.ebay.sdk.SdkException, java.lang.Exception
  {
    GetItemTransactionsRequestType req = new GetItemTransactionsRequestType();

    req.setItemID(itemID);
    req.setModTimeFrom(modifiedTimeFilter.getTimeFrom());
	req.setModTimeTo(modifiedTimeFilter.getTimeTo());
	if (null != includeContainingOrder)
		req.setIncludeContainingOrder(includeContainingOrder);
	if (null != includeFinalValueFee)
		req.setIncludeFinalValueFee(includeFinalValueFee);

    if( this.pagination != null )
      req.setPagination(this.pagination);

    if( this.transactionID != null && this.transactionID.length() > 0 )
      req.setTransactionID(this.transactionID);

    // Call eBay
    GetItemTransactionsResponseType resp = (GetItemTransactionsResponseType)this.execute(req);

    this.returnedTransactions = resp.getTransactionArray() == null ? null :
        resp.getTransactionArray().getTransaction();
    this.paginationResult = resp.getPaginationResult();
    this.item = resp.getItem();

    if( resp.isHasMoreTransactions() != null )
      this.hasMoreTransactions = resp.isHasMoreTransactions().booleanValue();
	if( resp.isPayPalPreferred() != null )
	  this.payPalPreferred = resp.isPayPalPreferred().booleanValue();
    if( resp.getReturnedTransactionCountActual() != null )
      this.returnedTransactionCountActual = resp.getReturnedTransactionCountActual().intValue();

    // Save EntriesPerPage and PageNumber back to the input PaginationType.
    if( this.pagination == null )
      this.pagination = new PaginationType();
    if( resp.getTransactionsPerPage() != null )
      this.pagination.setEntriesPerPage(resp.getTransactionsPerPage());
    if( resp.getPageNumber() != null )
      this.pagination.setPageNumber(resp.getPageNumber());

    return this.returnedTransactions;
  }


/**
   * Backward compatible function - do not use
   */
  public void setIncludeFinalValueFe(Boolean includeFinalValueFee) {
	this.includeFinalValueFee = includeFinalValueFee;
  }

  /**
   * Valid after executing the API.
   * Gets the returned GetItemTransactionsResponseType.hasMoreTransactions.
   * 
   * @return boolean
   */
  public boolean getHasMoreTransactions()
  {
    return this.hasMoreTransactions;
  }

  /**
   * Valid after executing the API.
   * Gets the returned GetItemTransactionsResponseType.item.
   * 
   * @return ItemType
   */
  public ItemType getItem()
  {
    return this.item;
  }

  /**
   * Valid after executing the API.
   * Gets the returned GetItemTransactionsResponseType.paginationResult.
   * 
   * @return PaginationResultType
   */
  public PaginationResultType getPaginationResult()
  {
    return this.paginationResult;
  }

  /**
   * Valid after executing the API.
   * Gets the returned GetItemTransactionsResponseType.payPalPreferred.
   * 
   * @return boolean
   */
  public boolean getPayPalPreferred()
  {
    return this.payPalPreferred;
  }

  /**
   * Valid after executing the API.
   * Gets the returned GetItemTransactionsResponseType.returnedPageNumber.
   * 
   * @return Integer
   */
  public Integer getReturnedPageNumber()
  {
    return this.returnedPageNumber;
  }

  /**
   * Valid after executing the API.
   * Gets the returned GetItemTransactionsResponseType.returnedTransactionCountActual.
   * 
   * @return int
   */
  public int getReturnedTransactionCountActual()
  {
    return this.returnedTransactionCountActual;
  }

  /**
   * Valid after executing the API.
   * Gets the returned GetItemTransactionsResponseType.returnedTransactions.
   * 
   * @return TransactionType[]
   */
  public TransactionType[] getReturnedTransactions()
  {
    return this.returnedTransactions;
  }

  /**
   * Valid after executing the API.
   * Gets the returned GetItemTransactionsResponseType.returnedTransactionsPerPage.
   * 
   * @return Integer
   */
  public Integer getReturnedTransactionsPerPage()
  {
    return this.returnedTransactionsPerPage;
  }

}

