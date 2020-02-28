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
import java.lang.Long;

import com.ebay.sdk.*;
import com.ebay.soap.eBLBaseComponents.*;
/**
 * Wrapper class of the GetSellingManagerSoldListings call of eBay SOAP API.
 * <br>
 * <p>Title: SOAP API wrapper library.</p>
 * <p>Description: Contains wrapper classes for eBay SOAP APIs.</p>
 * <p>Copyright: Copyright (c) 2009</p>
 * <p>Company: eBay Inc.</p>
 * <br> <B>Input property:</B> <code>Search</code> - This container is used if the seller would like to search for Selling Manager Sele Records based on certain identifiers like Saler Record ID, Item ID, listing title, buyer user ID, etc. The seller will specify one of the supported search types in <b>SellingManagerSearchTypeCodeType</b>, and then provides the value for that search type.
 * <br> <B>Input property:</B> <code>StoreCategoryID</code> - This field is used if the seller would like to retrieve all Selling Manager Sale Records for products listed in a specific eBay Store Category.
 * <br> <B>Input property:</B> <code>Filter</code> - One or more <b>Filter</b> fields can be used to retrieve Selling Manager Sale Records for orders that are in a certain state. See <b>SellingManagerSoldListingsPropertyTypeCodeType</b> for the supported values.
 * <br> <B>Input property:</B> <code>Archived</code> - This field is included and set to <code>true</code> if the seller would like to retrieve one or more archived orders between 90 and 120 days old.
 * <br> <B>Input property:</B> <code>Sort</code> - This field is used if the seller would like to sort Selling Manager Sale Record results based on a specific aspect such as purchase date, checkout status, total price, etc. See <b>SellingManagerSoldListingsSortTypeCodeType</b> to read more about the available sorting options.
 * <br> <B>Input property:</B> <code>SortOrder</code> - This field allows the seller to sort in ascending or descending order (based on the selected aspect in the <b>Sort</b> field).
 * <br> <B>Input property:</B> <code>Pagination</code> - This container is used if the seller would like to control how many Sale Records are returned per page and which page to view.
 * <br> <B>Input property:</B> <code>SaleDateRange</code> - This container allows the seller to retrieve orders that were purchased within a specified time range. A time range can be set up to 90 days in the past (or up to 120 days if the <b>Archived</b> field is included and set to <code>true</code>.
 * <br> <B>Output property:</B> <code>ReturnedSaleRecord</code> - A <b>SaleRecord</b> container is returned for each order that matches the input criteria.
 * <br> <B>Output property:</B> <code>ReturnedPaginationResult</code> - Contains the total number of pages (<b>TotalNumberOfPages</b>) and the total number of products entries (<b>TotalNumberOfEntries</b>) that can be returned on repeated calls with the same format and report criteria.
 * 
 * @author Ron Murphy
 * @version 1.0
 */

public class GetSellingManagerSoldListingsCall extends com.ebay.sdk.ApiCall
{
  
  private SellingManagerSearchType search = null;
  private Long storeCategoryID = null;
  private SellingManagerSoldListingsPropertyTypeCodeType[] filter = null;
  private Boolean archived = null;
  private SellingManagerSoldListingsSortTypeCodeType sort = null;
  private SortOrderCodeType sortOrder = null;
  private PaginationType pagination = null;
  private TimeRangeType saleDateRange = null;
  private SellingManagerSoldOrderType[] returnedSaleRecord=null;
  private PaginationResultType returnedPaginationResult=null;


  /**
   * Constructor.
   */
  public GetSellingManagerSoldListingsCall() {
  }

  /**
   * Constructor.
   * @param apiContext The ApiContext object to be used to make the call.
   */
  public GetSellingManagerSoldListingsCall(ApiContext apiContext) {
    super(apiContext);
    

  }

  /**
   * Returns a Selling Manager user's sold listings.
   * <br><br>
   * This call is subject to change without notice; the deprecation process is inapplicable to this call. The user must have a Selling Manager Pro subscription to use this call.
   * 
   * <br>
   * @throws ApiException
   * @throws SdkException
   * @throws Exception
   * @return The SellingManagerSoldOrderType[] object.
   */
  public SellingManagerSoldOrderType[] getSellingManagerSoldListings()
      throws com.ebay.sdk.ApiException, com.ebay.sdk.SdkException, java.lang.Exception
  {
    GetSellingManagerSoldListingsRequestType req;
    req = new GetSellingManagerSoldListingsRequestType();
    if (this.search != null)
      req.setSearch(this.search);
    if (this.storeCategoryID != null)
      req.setStoreCategoryID(this.storeCategoryID);
    if (this.filter != null)
      req.setFilter(this.filter);
    if (this.archived != null)
      req.setArchived(this.archived);
    if (this.sort != null)
      req.setSort(this.sort);
    if (this.sortOrder != null)
      req.setSortOrder(this.sortOrder);
    if (this.pagination != null)
      req.setPagination(this.pagination);
    if (this.saleDateRange != null)
      req.setSaleDateRange(this.saleDateRange);

    GetSellingManagerSoldListingsResponseType resp = (GetSellingManagerSoldListingsResponseType) execute(req);

    this.returnedSaleRecord = resp.getSaleRecord();
    this.returnedPaginationResult = resp.getPaginationResult();
    return this.getReturnedSaleRecord();
  }

  /**
   * Gets the GetSellingManagerSoldListingsRequestType.archived.
   * @return Boolean
   */
  public Boolean getArchived()
  {
    return this.archived;
  }

  /**
   * Sets the GetSellingManagerSoldListingsRequestType.archived.
   * @param archived Boolean
   */
  public void setArchived(Boolean archived)
  {
    this.archived = archived;
  }

  /**
   * Gets the GetSellingManagerSoldListingsRequestType.filter.
   * @return SellingManagerSoldListingsPropertyTypeCodeType[]
   */
  public SellingManagerSoldListingsPropertyTypeCodeType[] getFilter()
  {
    return this.filter;
  }

  /**
   * Sets the GetSellingManagerSoldListingsRequestType.filter.
   * @param filter SellingManagerSoldListingsPropertyTypeCodeType[]
   */
  public void setFilter(SellingManagerSoldListingsPropertyTypeCodeType[] filter)
  {
    this.filter = filter;
  }

  /**
   * Gets the GetSellingManagerSoldListingsRequestType.pagination.
   * @return PaginationType
   */
  public PaginationType getPagination()
  {
    return this.pagination;
  }

  /**
   * Sets the GetSellingManagerSoldListingsRequestType.pagination.
   * @param pagination PaginationType
   */
  public void setPagination(PaginationType pagination)
  {
    this.pagination = pagination;
  }

  /**
   * Gets the GetSellingManagerSoldListingsRequestType.saleDateRange.
   * @return TimeRangeType
   */
  public TimeRangeType getSaleDateRange()
  {
    return this.saleDateRange;
  }

  /**
   * Sets the GetSellingManagerSoldListingsRequestType.saleDateRange.
   * @param saleDateRange TimeRangeType
   */
  public void setSaleDateRange(TimeRangeType saleDateRange)
  {
    this.saleDateRange = saleDateRange;
  }

  /**
   * Gets the GetSellingManagerSoldListingsRequestType.search.
   * @return SellingManagerSearchType
   */
  public SellingManagerSearchType getSearch()
  {
    return this.search;
  }

  /**
   * Sets the GetSellingManagerSoldListingsRequestType.search.
   * @param search SellingManagerSearchType
   */
  public void setSearch(SellingManagerSearchType search)
  {
    this.search = search;
  }

  /**
   * Gets the GetSellingManagerSoldListingsRequestType.sort.
   * @return SellingManagerSoldListingsSortTypeCodeType
   */
  public SellingManagerSoldListingsSortTypeCodeType getSort()
  {
    return this.sort;
  }

  /**
   * Sets the GetSellingManagerSoldListingsRequestType.sort.
   * @param sort SellingManagerSoldListingsSortTypeCodeType
   */
  public void setSort(SellingManagerSoldListingsSortTypeCodeType sort)
  {
    this.sort = sort;
  }

  /**
   * Gets the GetSellingManagerSoldListingsRequestType.sortOrder.
   * @return SortOrderCodeType
   */
  public SortOrderCodeType getSortOrder()
  {
    return this.sortOrder;
  }

  /**
   * Sets the GetSellingManagerSoldListingsRequestType.sortOrder.
   * @param sortOrder SortOrderCodeType
   */
  public void setSortOrder(SortOrderCodeType sortOrder)
  {
    this.sortOrder = sortOrder;
  }

  /**
   * Gets the GetSellingManagerSoldListingsRequestType.storeCategoryID.
   * @return Long
   */
  public Long getStoreCategoryID()
  {
    return this.storeCategoryID;
  }

  /**
   * Sets the GetSellingManagerSoldListingsRequestType.storeCategoryID.
   * @param storeCategoryID Long
   */
  public void setStoreCategoryID(Long storeCategoryID)
  {
    this.storeCategoryID = storeCategoryID;
  }

  /**
   * Valid after executing the API.
   * Gets the returned GetSellingManagerSoldListingsResponseType.returnedPaginationResult.
   * 
   * @return PaginationResultType
   */
  public PaginationResultType getReturnedPaginationResult()
  {
    return this.returnedPaginationResult;
  }

  /**
   * Valid after executing the API.
   * Gets the returned GetSellingManagerSoldListingsResponseType.returnedSaleRecord.
   * 
   * @return SellingManagerSoldOrderType[]
   */
  public SellingManagerSoldOrderType[] getReturnedSaleRecord()
  {
    return this.returnedSaleRecord;
  }

}

