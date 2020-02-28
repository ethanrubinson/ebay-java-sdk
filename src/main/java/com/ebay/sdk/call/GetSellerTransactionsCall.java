/*
Copyright (c) 2013 eBay, Inc.
This program is licensed under the terms of the eBay Common Development and
Distribution License (CDDL) Version 1.0 (the "License") and any subsequent  version 
thereof released by eBay.  The then-current version of the License can be found 
at http://www.opensource.org/licenses/cddl1.php and in the eBaySDKLicense file that 
is under the eBay SDK ../docs directory.
*/

package com.ebay.sdk.call;

import java.util.List;
import java.util.ArrayList;


import java.lang.Boolean;
import java.lang.Integer;
import java.util.Calendar;

import com.ebay.sdk.*;
import com.ebay.soap.eBLBaseComponents.*;
/**
 * Wrapper class of the GetSellerTransactions call of eBay SOAP API.
 * <br>
 * <p>Title: SOAP API wrapper library.</p>
 * <p>Description: Contains wrapper classes for eBay SOAP APIs.</p>
 * <p>Copyright: Copyright (c) 2009</p>
 * <p>Company: eBay Inc.</p>
 * <br> <B>Input property:</B> <code>ModifiedTimeFilter</code> - Helper wrapper to set GetSellerTransactionsRequestType ModTimeFrom, ModTimeTo:
 * TimeFrom sets GetSellerTransactionsRequestType.ModTimeFrom: 
 * The <b>ModTimeFrom</b> and <b>ModTimeTo</b> fields are used to specify a date range for retrieving order line items associated with the seller. The <b>ModTimeFrom</b> field is the starting date range. All of the seller's order line items that were created (or last modified) within this date range are returned in the output.  The maximum date range that may be specified is 30 days. This value cannot be set back more than 90 days in the past, as this call cannot retrieve sales older than 90 days. This field is not applicable if the <b>NumberOfDays</b> date filter is used.
 * <br><br>
 * If you don't specify a <b>ModTimeFrom</b>/<b>ModTimeTo</b> filter, the <b>NumberOfDays</b> time filter is used and it defaults to 30 (days).
 * TimeTo sets GetSellerTransactionsRequestType.ModTimeTo: 
 * The <b>ModTimeFrom</b> and <b>ModTimeTo</b> fields are used to specify a date range for retrieving order line items associated with the seller. The <b>ModTimeTo</b> field is the ending date range. All of the seller's order line items that were created (or last modified) within this date range are returned in the output. The maximum date range that may be specified is 30 days.
 * <br/><br/>
 * If the <b>ModTimeFrom</b> field is
 * used and the <b>ModTimeTo</b> field is omitted, the <b>ModTimeTo</b> value defaults to
 * the present time or to 30 days past the <b>ModTimeFrom</b> value (if
 * <b>ModTimeFrom</b> value is more than 30 days in the past). This field is not
 * applicable if the <b>NumberOfDays</b> date filter is used.
 * <br><br>
 * If you don't specify a <b>ModTimeFrom</b>/<b>ModTimeTo</b> filter, the <b>NumberOfDays</b>
 * time filter is used and it defaults to 30 (days).
 * <br> <B>Input property:</B> <code>Pagination</code> - If many order line items are	available to retrieve, you may need to call <b>GetSellerTransactions</b> multiple times to retrieve all the data. Each result set is returned as a page of order line items. Use the <b>Pagination</b> filters to control the maximum number of order line items to retrieve per page (i.e., per call), and the page number to retrieve.
 * <br> <B>Input property:</B> <code>IncludeFinalValueFee</code> - This field is included and set to <code>true</code> if the user wants to view the Final Value Fee (FVF) for all order line items in the response. The Final Value Fee is returned in the <b>Transaction.FinalValueFee</b> field. The Final Value Fee is assessed right after the creation of an order line item.
 * <br/>
 * <br> <B>Input property:</B> <code>IncludeContainingOrder</code> - This field is included and set to <code>true</code> if the user wants to view order-level details, including the unique identifier of the order and the status of the order. The order-level details will be shown in the <b>ContainingOrder</b> container in the response.
 * <br/>
 * <br> <B>Input property:</B> <code>SKUArray</code> - This container is used to search for order line items generated from one or more product SKU values. The response will only include order line items for the seller's product(s) that are represented by the specified SKU value(s).
 * <br> <br>
 * If a user wants to retrieve order line items based on SKUs, the
 * <b>InventoryTrackingMethod</b> must be set to <code>SKU</code>. The <b>InventoryTrackingMethod</b> value can be set when the seller lists the item through an <b>AddFixedPriceItem</b> call, or it can be set by including the <b>InventoryTrackingMethod</b> field in a <b>GetSellerTransactions</b> call and setting its value to <code>SKU</code>.
 * <br> <br>
 * <span class="tablenote"><b>Note: </b> SKU values must be defined for products in listings for this container to be applicable.
 * </span>
 * <br> <B>Input property:</B> <code>Platform</code> - <span class="tablenote"><b>Note: </b> This field should no longer be used since its sole purpose was to allow the seller to filter between eBay orders and Half.com orders, and the Half.com site no longer exists.
 * </span>
 * <br> <B>Input property:</B> <code>NumberOfDays</code> - This field is used to specify how many days (24-hour periods) back in the past you wish to retrieve order line items. All order line items created (or last modified) within this period are retrieved. This value can be set between 1 (day) and 30 (days), and defaults to 30 (days) if omitted from the call.
 * <br/><br/>
 * If the <b>NumberOfDays</b> filter is used, <b>ModTimeFrom</b> and <b>ModTimeTo</b> date range filters are ignored (if included in the same request).
 * <br/>
 * <br> <B>Input property:</B> <code>InventoryTrackingMethod</code> - This filter is used if the seller wishes to set/change the inventory tracking method. When creating a listing with the <b>AddFixedPriceItem</b> call (or relisting with <b>RelistFixedPriceItem</b> call), sellers can decide whether to track their inventory by Item ID (generated by eBay at listing time) or by seller-defined SKU value.
 * <br><br>
 * This field is needed (and its value must be set to <code>SKU</code>) if the seller wishes to retrieve order line items based on specified SKU values (specified through <b>SKUArray</b> container) and the current inventory tracking method is set to Item ID.
 * <br><br>
 * A seller can use a <b>GetItem</b> call for a listing (and look for the <b>Item.InventoryTrackingMethod</b> in the response) to see which inventory tracking method is used for the listing/product.
 * <br> <B>Input property:</B> <code>IncludeCodiceFiscale</code> - If this field is included in the call request and set to <code>true</code>, taxpayer identification information for the buyer is returned under the <b>BuyerTaxIdentifier</b> container.
 * <br><br>
 * Codice Fiscale is only applicable to buyers on the Italy and Spain sites. It is required that buyers on the Italy site provide their Codice Fiscale ID before buying an item, and sellers on the Spain site have the option of requiring buyers on the Spain site to provide their taxpayer ID.
 * <br> <B>Output property:</B> <code>PaginationResult</code> - Container consisting of the total number of order line items that match the input criteria and the total number of pages that must be scrolled through to view all order line items. To scroll through each page of order line item data, make subsequent <b>GetSellerTransactions</b> calls, incrementing the <b>Pagination.PageNumber</b> field by a value of '1' each time.
 * <br> <B>Output property:</B> <code>HasMoreTransactions</code> - This flag indicates whether there are additional pages of order line items to view. This field will be returned as <code>true</code> if there are additional pages or order line items to <code>view</code>, or <code>false</code> if the current page of order line item data is the last page of data.
 * <br> <B>Output property:</B> <code>ReturnedTransactionsPerPage</code> - This value indicates the number of order line items returned per page (per call) and is controlled by the <b>Pagination.EntriesPerPage</b> value passed in the call request. Unless it is the last (or possibly only) page of data (<b>HasMoreTransactions=false</b>), the <b>TransactionsPerPage</b> value should equal the <b>Pagination.EntriesPerPage</b> value passed in the call request. <br> <br> <span class="tablenote"><b>Note:</b> Due to the fact that item data on the eBay platform has a shorter retention period than order data, it is possible that some retrieved pages will contain no data. For pages that contain no data, the <b>ReturnedTransactionCountActual</b> value will be '0'. It is also possible that pages 2, 3, and 4 have no data, but pages 1 and 5 do have data. Therefore, we recommend that you scroll through each page of data (making subsequent <b>GetSellerTransactions</b> calls and incrementing the <b>Pagination.PageNumber</b> value by '1' each time) until you reach the last page, indicated by <b>HasMoreTransactions=false</b>. </span>
 * <br> <B>Output property:</B> <code>ReturnedPageNumber</code> - This value indicates the page number of retrieved order line items that match the input criteria. This value is controlled by the <b>Pagination.PageNumber</b> value passed in the call request. To scroll through all pages of order line items that match the input criteria, you increment the <b>Pagination.PageNumber</b> value by <code>1</code> with each subsequent <b>GetSellerTransactions</b> call.
 * <br> <B>Output property:</B> <code>ReturnedTransactionCountActual</code> - This value indicates the total number of (non-empty) order line items retrieved in the current page of results. The <b>ReturnedTransactionCountActual</b> value will be lower than the <b>TransactionsPerPage</b> value if one or more empty order line items are retrieved on the page. <br> <br> <span class="tablenote"><b>Note:</b> Due to the fact that item data on the eBay platform has a shorter retention period than order data, it is possible that some retrieved pages will contain no data. For pages that contain no order line item data, the <b>ReturnedTransactionCountActual</b> value will be '0'. It is also possible that pages 2, 3, and 4 have no data, but pages 1 and 5 do have data. Therefore, we recommend that you scroll through each page of data (making subsequent <b>GetSellerTransactions</b> calls and incrementing the <b>Pagination.PageNumber</b> value by '1' each time) until you reach the last page, indicated by <b>HasMoreTransactions=false</b>. </span>
 * <br> <B>Output property:</B> <code>Seller</code> - Contains information about the seller whose order line items are being returned.
 * See the reference guide for information about the <b>Seller</b> object fields
 * that are returned.
 * <br> <B>Output property:</B> <code>ReturnedTransactions</code> - List of <b>Transaction</b> objects representing the seller's recent sales.
 * Each <b>Transaction</b> object contains the data for one purchase
 * (of one or more items in the same listing).
 * See the reference guide for more information about the fields that are returned
 * for each order line item.
 * <br> <B>Output property:</B> <code>PayPalPreferred</code> - Indicates whether the seller has the preference enabled that shows that the seller
 * prefers PayPal as the method of payment for an item. This preference is indicated on
 * an item's View Item page and is intended to influence a buyer to use PayPal
 * to pay for the item.
 * 
 * @author Ron Murphy
 * @version 1.0
 */

public class GetSellerTransactionsCall extends com.ebay.sdk.ApiCall
{
  
  private TimeFilter modifiedTimeFilter = null;
  private PaginationType pagination = null;
  private Boolean includeFinalValueFee = null;
  private Boolean includeContainingOrder = null;
  private SKUArrayType sKUArray = null;
  private TransactionPlatformCodeType platform = null;
  private Integer numberOfDays = null;
  private InventoryTrackingMethodCodeType inventoryTrackingMethod = null;
  private Boolean includeCodiceFiscale = null;
  private PaginationResultType paginationResult=null;
  private boolean hasMoreTransactions=false;
  private Integer returnedTransactionsPerPage=null;
  private Integer returnedPageNumber=null;
  private int returnedTransactionCountActual=0;
  private UserType seller=null;
  private TransactionType[] returnedTransactions=null;
  private boolean payPalPreferred=false;


  /**
   * Constructor.
   */
  public GetSellerTransactionsCall() {
  }

  /**
   * Constructor.
   * @param apiContext The ApiContext object to be used to make the call.
   */
  public GetSellerTransactionsCall(ApiContext apiContext) {
    super(apiContext);
    

  }

  /**
   * Retrieves transaction information for the user for which the call is made (and
   * not for any other user), where a transaction is the information about the sale
   * of one or more items by one buyer from a single listing. (To retrieve
   * transactions for another seller's listing, use GetItemTransactions.)
   * 
   * <br>
   * @throws ApiException
   * @return The TransactionType[] object.
   */
  public TransactionType[] getSellerTransactions()
      throws com.ebay.sdk.ApiException, com.ebay.sdk.SdkException, java.lang.Exception
  {
    GetSellerTransactionsRequestType req;
    req = new GetSellerTransactionsRequestType();

    if( this.modifiedTimeFilter == null )
      throw new SdkException("ModifiedTimeFilter property is not set.");

    req.setDetailLevel(this.getDetailLevel());
    if (this.modifiedTimeFilter != null)
    {
      req.setModTimeFrom(this.modifiedTimeFilter.getTimeFrom());
      req.setModTimeTo(this.modifiedTimeFilter.getTimeTo());
    }
    if (this.pagination != null)
      req.setPagination(this.pagination);
    if (this.includeFinalValueFee != null)
      req.setIncludeFinalValueFee(this.includeFinalValueFee);
    if (this.includeContainingOrder != null)
      req.setIncludeContainingOrder(this.includeContainingOrder);
    if (this.sKUArray != null)
      req.setSKUArray(this.sKUArray);
    if (this.platform != null)
      req.setPlatform(this.platform);
    if (this.inventoryTrackingMethod != null)
      req.setInventoryTrackingMethod(this.inventoryTrackingMethod);
    if(this.includeCodiceFiscale !=null)
      req.setIncludeCodiceFiscale(this.includeCodiceFiscale);

    GetSellerTransactionsResponseType resp = (GetSellerTransactionsResponseType) execute(req);

    this.paginationResult = resp.getPaginationResult();
    this.hasMoreTransactions = (resp.isHasMoreTransactions() == null? false: resp.isHasMoreTransactions().booleanValue());
    this.returnedTransactionsPerPage = resp.getTransactionsPerPage();
    this.returnedPageNumber = resp.getPageNumber();
    this.returnedTransactionCountActual = (resp.getReturnedTransactionCountActual() == null? 0: resp.getReturnedTransactionCountActual().intValue());
    this.seller = resp.getSeller();
    this.returnedTransactions = (resp.getTransactionArray() == null? null: resp.getTransactionArray().getTransaction());
    this.payPalPreferred = (resp.isPayPalPreferred() == null? false: resp.isPayPalPreferred().booleanValue());
    return this.getReturnedTransactions();
  }

  /**
   * Gets the GetSellerTransactionsRequestType.includeCodiceFiscale.
   * @return Boolean
   */
  public Boolean getIncludeCodiceFiscale()
  {
    return this.includeCodiceFiscale;
  }

  /**
   * Sets the GetSellerTransactionsRequestType.includeCodiceFiscale.
   * @param includeCodiceFiscale Boolean
   */
  public void setIncludeCodiceFiscale(Boolean includeCodiceFiscale)
  {
    this.includeCodiceFiscale = includeCodiceFiscale;
  }

  /**
   * Gets the GetSellerTransactionsRequestType.includeContainingOrder.
   * @return Boolean
   */
  public Boolean getIncludeContainingOrder()
  {
    return this.includeContainingOrder;
  }

  /**
   * Sets the GetSellerTransactionsRequestType.includeContainingOrder.
   * @param includeContainingOrder Boolean
   */
  public void setIncludeContainingOrder(Boolean includeContainingOrder)
  {
    this.includeContainingOrder = includeContainingOrder;
  }

  /**
   * Gets the GetSellerTransactionsRequestType.includeFinalValueFee.
   * @return Boolean
   */
  public Boolean getIncludeFinalValueFee()
  {
    return this.includeFinalValueFee;
  }

  /**
   * Sets the GetSellerTransactionsRequestType.includeFinalValueFee.
   * @param includeFinalValueFee Boolean
   */
  public void setIncludeFinalValueFee(Boolean includeFinalValueFee)
  {
    this.includeFinalValueFee = includeFinalValueFee;
  }

  /**
   * Gets the GetSellerTransactionsRequestType.inventoryTrackingMethod.
   * @return InventoryTrackingMethodCodeType
   */
  public InventoryTrackingMethodCodeType getInventoryTrackingMethod()
  {
    return this.inventoryTrackingMethod;
  }

  /**
   * Sets the GetSellerTransactionsRequestType.inventoryTrackingMethod.
   * @param inventoryTrackingMethod InventoryTrackingMethodCodeType
   */
  public void setInventoryTrackingMethod(InventoryTrackingMethodCodeType inventoryTrackingMethod)
  {
    this.inventoryTrackingMethod = inventoryTrackingMethod;
  }

  /**
   * Gets the GetSellerTransactionsRequestType.modifiedTimeFilter.
   * @return TimeFilter
   */
  public TimeFilter getModifiedTimeFilter()
  {
    return this.modifiedTimeFilter;
  }

  /**
   * Sets the GetSellerTransactionsRequestType.modifiedTimeFilter.
   * @param modifiedTimeFilter TimeFilter
   */
  public void setModifiedTimeFilter(TimeFilter modifiedTimeFilter)
  {
    this.modifiedTimeFilter = modifiedTimeFilter;
  }

  /**
   * Gets the GetSellerTransactionsRequestType.numberOfDays.
   * @return Integer
   */
  public Integer getNumberOfDays()
  {
    return this.numberOfDays;
  }

  /**
   * Sets the GetSellerTransactionsRequestType.numberOfDays.
   * @param numberOfDays Integer
   */
  public void setNumberOfDays(Integer numberOfDays)
  {
    this.numberOfDays = numberOfDays;
  }

  /**
   * Gets the GetSellerTransactionsRequestType.pagination.
   * @return PaginationType
   */
  public PaginationType getPagination()
  {
    return this.pagination;
  }

  /**
   * Sets the GetSellerTransactionsRequestType.pagination.
   * @param pagination PaginationType
   */
  public void setPagination(PaginationType pagination)
  {
    this.pagination = pagination;
  }

  /**
   * Gets the GetSellerTransactionsRequestType.platform.
   * @return TransactionPlatformCodeType
   */
  public TransactionPlatformCodeType getPlatform()
  {
    return this.platform;
  }

  /**
   * Sets the GetSellerTransactionsRequestType.platform.
   * @param platform TransactionPlatformCodeType
   */
  public void setPlatform(TransactionPlatformCodeType platform)
  {
    this.platform = platform;
  }

  /**
   * Gets the GetSellerTransactionsRequestType.sKUArray.
   * @return SKUArrayType
   */
  public SKUArrayType getSKUArray()
  {
    return this.sKUArray;
  }

  /**
   * Sets the GetSellerTransactionsRequestType.sKUArray.
   * @param sKUArray SKUArrayType
   */
  public void setSKUArray(SKUArrayType sKUArray)
  {
    this.sKUArray = sKUArray;
  }
/**
   * Get all seller transactions in specified date range.
   * It handles pagination internally and ignores the Pagination property.
   * GetSellerTransactionsCall.TimeFilter will be ignored.
   * @throws ApiException
   * @throws SdkException
   * @throws Exception
   * @return TransactionType[]
   */
  public TransactionType[] getEntireSellerTransactions()
      throws com.ebay.sdk.ApiException, com.ebay.sdk.SdkException, java.lang.Exception
  {
    if( this.modifiedTimeFilter == null )
      throw new SdkException("TimeFilter is not set.");
    return getEntireSellerTransactions(this.modifiedTimeFilter);
  }
/**
   * Get all seller transactions in specified date range.
   * It handles pagination internally and ignores the Pagination property.
   *
   * @param modifiedTimeFilter TimeFilter
   * @throws ApiException
   * @throws SdkException
   * @throws Exception
   * @return TransactionType[]
   */
  public TransactionType[] getEntireSellerTransactions(TimeFilter modifiedTimeFilter)
      throws com.ebay.sdk.ApiException, com.ebay.sdk.SdkException, java.lang.Exception
  {
    GetSellerTransactionsRequestType req = new GetSellerTransactionsRequestType();

    // Modified time filter is mandatory.
    req.setModTimeFrom(modifiedTimeFilter.getTimeFrom());
    req.setModTimeTo(modifiedTimeFilter.getTimeTo());

    int pageNum = 1;
    PaginationType pgn = new PaginationType();
    pgn.setEntriesPerPage(new Integer(100));
    pgn.setPageNumber(new Integer(pageNum++));

    req.setPagination(pgn);
    
    if (this.includeFinalValueFee != null)
        req.setIncludeFinalValueFee(this.includeFinalValueFee);
    if (this.includeContainingOrder != null)
        req.setIncludeContainingOrder(this.includeContainingOrder);
    if (this.sKUArray != null)
        req.setSKUArray(this.sKUArray);
    if (this.platform != null)
        req.setPlatform(this.platform);
    if (this.inventoryTrackingMethod != null)
        req.setInventoryTrackingMethod(this.inventoryTrackingMethod);
     if(this.includeCodiceFiscale !=null)
        req.setIncludeCodiceFiscale(this.includeCodiceFiscale);

    ArrayList transList = new ArrayList();

    while(true)
    {
      GetSellerTransactionsResponseType resp = (GetSellerTransactionsResponseType)this.execute(req);
      TransactionArrayType tarray = resp.getTransactionArray();
      TransactionType[] tm = (tarray == null) ? null : tarray.getTransaction();
      if( tm != null )
      {
        for (int i = 0; i < tm.length; i++)
          transList.add(tm[i]);
      }

      if( resp.getReturnedTransactionCountActual() != null )
        this.returnedTransactionCountActual = resp.getReturnedTransactionCountActual().intValue();
      if( !resp.isHasMoreTransactions().booleanValue() )
        break;

      pgn.setPageNumber(new Integer(pageNum++));
    }

    // Build results.
    this.returnedTransactions = new TransactionType[transList.size()];
    for(int i = 0; i < this.returnedTransactions.length; i ++)
    {
      this.returnedTransactions[i] = (TransactionType)transList.get(i);
    }
    return this.returnedTransactions;
  }

/**
   * Executes the API. GetSellerTransactionsCall.TimeFilter will be ignored.
   * @param modifiedTimeFilter TimeFilter
   * @throws ApiException
   * @throws SdkException
   * @throws Exception
   * @return TransactionType[]
   */
  public TransactionType[] getSellerTransactions(TimeFilter modifiedTimeFilter)
      throws com.ebay.sdk.ApiException, com.ebay.sdk.SdkException, java.lang.Exception
  {
     this.modifiedTimeFilter = modifiedTimeFilter;
     return getSellerTransactions();
  }
/**
   *
   * @return TimeFilter
   */
  public TimeFilter getTimeFilter() {
    return this.modifiedTimeFilter;
  }
/**
   * Sets time filter for transactions to be returned.
   * @param timeFilter TimeFilter
   */
  public void setTimeFilter(TimeFilter timeFilter) {
    this.modifiedTimeFilter = timeFilter;
  }

  /**
   * Valid after executing the API.
   * Gets the returned GetSellerTransactionsResponseType.hasMoreTransactions.
   * 
   * @return boolean
   */
  public boolean getHasMoreTransactions()
  {
    return this.hasMoreTransactions;
  }

  /**
   * Valid after executing the API.
   * Gets the returned GetSellerTransactionsResponseType.paginationResult.
   * 
   * @return PaginationResultType
   */
  public PaginationResultType getPaginationResult()
  {
    return this.paginationResult;
  }

  /**
   * Valid after executing the API.
   * Gets the returned GetSellerTransactionsResponseType.payPalPreferred.
   * 
   * @return boolean
   */
  public boolean getPayPalPreferred()
  {
    return this.payPalPreferred;
  }

  /**
   * Valid after executing the API.
   * Gets the returned GetSellerTransactionsResponseType.returnedPageNumber.
   * 
   * @return Integer
   */
  public Integer getReturnedPageNumber()
  {
    return this.returnedPageNumber;
  }

  /**
   * Valid after executing the API.
   * Gets the returned GetSellerTransactionsResponseType.returnedTransactionCountActual.
   * 
   * @return int
   */
  public int getReturnedTransactionCountActual()
  {
    return this.returnedTransactionCountActual;
  }

  /**
   * Valid after executing the API.
   * Gets the returned GetSellerTransactionsResponseType.returnedTransactions.
   * 
   * @return TransactionType[]
   */
  public TransactionType[] getReturnedTransactions()
  {
    return this.returnedTransactions;
  }

  /**
   * Valid after executing the API.
   * Gets the returned GetSellerTransactionsResponseType.returnedTransactionsPerPage.
   * 
   * @return Integer
   */
  public Integer getReturnedTransactionsPerPage()
  {
    return this.returnedTransactionsPerPage;
  }

  /**
   * Valid after executing the API.
   * Gets the returned GetSellerTransactionsResponseType.seller.
   * 
   * @return UserType
   */
  public UserType getSeller()
  {
    return this.seller;
  }

}

