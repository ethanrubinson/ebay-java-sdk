/*
Copyright (c) 2013 eBay, Inc.
This program is licensed under the terms of the eBay Common Development and
Distribution License (CDDL) Version 1.0 (the "License") and any subsequent  version 
thereof released by eBay.  The then-current version of the License can be found 
at http://www.opensource.org/licenses/cddl1.php and in the eBaySDKLicense file that 
is under the eBay SDK ../docs directory.
*/

package com.ebay.sdk.call;

import java.lang.Integer;
import java.util.Calendar;

import com.ebay.sdk.*;
import com.ebay.soap.eBLBaseComponents.*;
/**
 * Wrapper class of the GetUserDisputes call of eBay SOAP API.
 * <br>
 * <p>Title: SOAP API wrapper library.</p>
 * <p>Description: Contains wrapper classes for eBay SOAP APIs.</p>
 * <p>Copyright: Copyright (c) 2009</p>
 * <p>Company: eBay Inc.</p>
 * <br> <B>Input property:</B> <code>DisputeFilterType</code> - An inclusive filter that isolates the returned disputes to a certain type such as Item Not Received or Unpaid Item disputes. eBay Money Back Guarantee cases are not retrieved with this call, even if the <b>ItemNotReceivedDisputes</b> filter is included in the request.
 * <br> <B>Input property:</B> <code>DisputeSortType</code> - One of the values defined in <b>DisputeSortTypeCodeType</b> is used here to control the order of disputes that are returned.
 * <br> <B>Input property:</B> <code>TimeFilter</code> - Helper wrapper to set GetUserDisputesRequestType ModTimeFrom, ModTimeTo:
 * TimeFrom sets GetUserDisputesRequestType.ModTimeFrom: 
 * A filter that retrieves disputes whose <b>DisputeModifiedTime</b> is later than or equal to this value. Specify the time value in GMT. See the eBay Features Guide for information about specifying time values. For more precise control of the date range filter, it is a good practice to also specify <b>ModTimeTo</b>. Otherwise, the end of the date range is the present time. Filtering by date range is optional. You can use date range filters in combination with other filters like <b>DisputeFilterType</b> to control the amount of data returned.
 * TimeTo sets GetUserDisputesRequestType.ModTimeTo: 
 * A filter that retrieves disputes whose <b>DisputeModifiedTime</b> is earlier than or equal to this value. Specify the time value in GMT. See the eBay Features Guide for information about specifying time values. For more precise control of the date range filter, it is a good practice to also specify <b>ModTimeFrom</b>. Otherwise, all available disputes modified prior to the <b>ModTimeTo</b> value are returned. Filtering by date range is optional. You can use date range filters in combination with other filters like <b>DisputeFilterType</b> to control the amount of data returned.
 * <br> <B>Input property:</B> <code>Pagination</code> - The virtual page number of the result set to display. A result set has a number of disputes divided into virtual pages, with 200 disputes per page. The response can only display one page. The first page in the result set is number 1. Required. If not specified, a warning is returned and <b>Pagination.PageNumber</b> is set to 1 by default.
 * <br> <B>Output property:</B> <code>ReturnedStartingDisputeID</code> - The index of the first dispute in the current result set, relative to the total number of disputes available. Primarily useful for interpreting paginated results. For example, if 228 disputes are available and 200 results are returned per page: The first page returns a <b>StartingDisputeID</b> value of 1 and the second page returns a <b>StartingDisputeID</b> value of 201.
 * <br> <B>Output property:</B> <code>ReturnedEndingDisputeID</code> - The index of the last dispute in the current result set, relative to the total number of disputes available. Primarily useful for interpreting paginated results. For example, if 228 disputes are available and 200 results are returned per page: The first page returns an <b>EndingDisputeID</b> value of 200 and the second page returns an <b>EndingDisputeID</b> value of 228.
 * <br> <B>Output property:</B> <code>ReturnedDisputeArray</code> - The array of disputes returned.
 * <br> <B>Output property:</B> <code>ReturnedItemsPerPage</code> - The number of disputes on each virtual page in the result set.
 * The virtual page returned is determined by <b>PageNumber</b>.
 * <br> <B>Output property:</B> <code>ReturnedPageNumber</code> - The page of the total result set returned in the call. The entire result set
 * is virtual and the call returns only one page of it.
 * <br> <B>Output property:</B> <code>ReturnedDisputeFilterCount</code> - The number of disputes that involve the requester as
 * buyer or seller and match a given filter type.
 * <br> <B>Output property:</B> <code>ReturnedPaginationResult</code> - The result of the pagination, including the total number
 * of virtual pages in the result set and the total number of
 * disputes returned.
 * 
 * @author Ron Murphy
 * @version 1.0
 */

public class GetUserDisputesCall extends com.ebay.sdk.ApiCall
{
  
  private DisputeFilterTypeCodeType disputeFilterType = null;
  private DisputeSortTypeCodeType disputeSortType = null;
  private TimeFilter timeFilter = null;
  private PaginationType pagination = null;
  private String returnedStartingDisputeID=null;
  private String returnedEndingDisputeID=null;
  private DisputeArrayType returnedDisputeArray=null;
  private Integer returnedItemsPerPage=null;
  private Integer returnedPageNumber=null;
  private DisputeFilterCountType[] returnedDisputeFilterCount=null;
  private PaginationResultType returnedPaginationResult=null;


  /**
   * Constructor.
   */
  public GetUserDisputesCall() {
  }

  /**
   * Constructor.
   * @param apiContext The ApiContext object to be used to make the call.
   */
  public GetUserDisputesCall(ApiContext apiContext) {
    super(apiContext);
    

  }

  /**
   * Requests a list of disputes the requester is involved in as buyer or seller. eBay Money Back Guarantee Item Not Received and Return cases are not returned with this call. To retrieve eBay Money Back Guarantee cases, use the <b>Search Cases</b> call of the Post-Order API (or alternatively, the <b>getUserCases</b> call of the Resolution Case Management API.
   * 
   * <br>
   * @throws ApiException
   * @throws SdkException
   * @throws Exception
   * @return The GetUserDisputesResponseType object.
   */
  public GetUserDisputesResponseType getUserDisputes()
      throws com.ebay.sdk.ApiException, com.ebay.sdk.SdkException, java.lang.Exception
  {
    GetUserDisputesRequestType req;
    req = new GetUserDisputesRequestType();
    req.setDetailLevel(this.getDetailLevel());
    if (this.disputeFilterType != null)
      req.setDisputeFilterType(this.disputeFilterType);
    if (this.disputeSortType != null)
      req.setDisputeSortType(this.disputeSortType);
    if (this.timeFilter != null)
    {
      req.setModTimeFrom(this.timeFilter.getTimeFrom());
      req.setModTimeTo(this.timeFilter.getTimeTo());
    }
    if (this.pagination != null)
      req.setPagination(this.pagination);

    GetUserDisputesResponseType resp = (GetUserDisputesResponseType) execute(req);

    this.returnedStartingDisputeID = resp.getStartingDisputeID();
    this.returnedEndingDisputeID = resp.getEndingDisputeID();
    this.returnedDisputeArray = resp.getDisputeArray();
    this.returnedItemsPerPage = resp.getItemsPerPage();
    this.returnedPageNumber = resp.getPageNumber();
    this.returnedDisputeFilterCount = resp.getDisputeFilterCount();
    this.returnedPaginationResult = resp.getPaginationResult();
    return resp;
  }

  /**
   * Gets the GetUserDisputesRequestType.disputeFilterType.
   * @return DisputeFilterTypeCodeType
   */
  public DisputeFilterTypeCodeType getDisputeFilterType()
  {
    return this.disputeFilterType;
  }

  /**
   * Sets the GetUserDisputesRequestType.disputeFilterType.
   * @param disputeFilterType DisputeFilterTypeCodeType
   */
  public void setDisputeFilterType(DisputeFilterTypeCodeType disputeFilterType)
  {
    this.disputeFilterType = disputeFilterType;
  }

  /**
   * Gets the GetUserDisputesRequestType.disputeSortType.
   * @return DisputeSortTypeCodeType
   */
  public DisputeSortTypeCodeType getDisputeSortType()
  {
    return this.disputeSortType;
  }

  /**
   * Sets the GetUserDisputesRequestType.disputeSortType.
   * @param disputeSortType DisputeSortTypeCodeType
   */
  public void setDisputeSortType(DisputeSortTypeCodeType disputeSortType)
  {
    this.disputeSortType = disputeSortType;
  }

  /**
   * Gets the GetUserDisputesRequestType.pagination.
   * @return PaginationType
   */
  public PaginationType getPagination()
  {
    return this.pagination;
  }

  /**
   * Sets the GetUserDisputesRequestType.pagination.
   * @param pagination PaginationType
   */
  public void setPagination(PaginationType pagination)
  {
    this.pagination = pagination;
  }

  /**
   * Gets the GetUserDisputesRequestType.timeFilter.
   * @return TimeFilter
   */
  public TimeFilter getTimeFilter()
  {
    return this.timeFilter;
  }

  /**
   * Sets the GetUserDisputesRequestType.timeFilter.
   * @param timeFilter TimeFilter
   */
  public void setTimeFilter(TimeFilter timeFilter)
  {
    this.timeFilter = timeFilter;
  }

  /**
   * Valid after executing the API.
   * Gets the returned GetUserDisputesResponseType.returnedDisputeArray.
   * 
   * @return DisputeArrayType
   */
  public DisputeArrayType getReturnedDisputeArray()
  {
    return this.returnedDisputeArray;
  }

  /**
   * Valid after executing the API.
   * Gets the returned GetUserDisputesResponseType.returnedDisputeFilterCount.
   * 
   * @return DisputeFilterCountType[]
   */
  public DisputeFilterCountType[] getReturnedDisputeFilterCount()
  {
    return this.returnedDisputeFilterCount;
  }

  /**
   * Valid after executing the API.
   * Gets the returned GetUserDisputesResponseType.returnedEndingDisputeID.
   * 
   * @return String
   */
  public String getReturnedEndingDisputeID()
  {
    return this.returnedEndingDisputeID;
  }

  /**
   * Valid after executing the API.
   * Gets the returned GetUserDisputesResponseType.returnedItemsPerPage.
   * 
   * @return Integer
   */
  public Integer getReturnedItemsPerPage()
  {
    return this.returnedItemsPerPage;
  }

  /**
   * Valid after executing the API.
   * Gets the returned GetUserDisputesResponseType.returnedPageNumber.
   * 
   * @return Integer
   */
  public Integer getReturnedPageNumber()
  {
    return this.returnedPageNumber;
  }

  /**
   * Valid after executing the API.
   * Gets the returned GetUserDisputesResponseType.returnedPaginationResult.
   * 
   * @return PaginationResultType
   */
  public PaginationResultType getReturnedPaginationResult()
  {
    return this.returnedPaginationResult;
  }

  /**
   * Valid after executing the API.
   * Gets the returned GetUserDisputesResponseType.returnedStartingDisputeID.
   * 
   * @return String
   */
  public String getReturnedStartingDisputeID()
  {
    return this.returnedStartingDisputeID;
  }

}

