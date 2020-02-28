/*
Copyright (c) 2013 eBay, Inc.
This program is licensed under the terms of the eBay Common Development and
Distribution License (CDDL) Version 1.0 (the "License") and any subsequent  version 
thereof released by eBay.  The then-current version of the License can be found 
at http://www.opensource.org/licenses/cddl1.php and in the eBaySDKLicense file that 
is under the eBay SDK ../docs directory.
*/

package com.ebay.sdk.call;

import java.util.ArrayList;

import java.lang.Boolean;
import java.lang.Integer;
import java.util.Calendar;

import com.ebay.sdk.*;
import com.ebay.soap.eBLBaseComponents.*;
/**
 * Wrapper class of the GetSellerList call of eBay SOAP API.
 * <br>
 * <p>Title: SOAP API wrapper library.</p>
 * <p>Description: Contains wrapper classes for eBay SOAP APIs.</p>
 * <p>Copyright: Copyright (c) 2009</p>
 * <p>Company: eBay Inc.</p>
 * <br> <B>Input property:</B> <code>UserID</code> - <span class="tablenote"><strong>Note:</strong>
 * This field should no longer be used, and will be ignored if it is included in a <b>GetSellerList</b> request. There are plans to remove this field from the public WSDL. The only eBay user ID that can be used is the one associated with the authentication token.
 * </span>
 * <br> <B>Input property:</B> <code>MotorsDealerUsers</code> - Specifies the list of Motors Dealer sellers for which a special set of
 * metrics can be requested. Applies to eBay Motors Pro applications only.
 * <br> <B>Input property:</B> <code>EndTimeFilter</code> - Helper wrapper to set GetSellerListRequestType EndTimeFrom, EndTimeTo:
 * TimeFrom sets GetSellerListRequestType.EndTimeFrom: 
 * Specifies the earliest (oldest) date to use in a date range filter based on
 * item end time. Specify either an end-time range or a start-time range
 * filter in every call request. Each of the time ranges must be a value less than
 * 120 days.
 * TimeTo sets GetSellerListRequestType.EndTimeTo: 
 * Specifies the latest (most recent) date to use in a date range filter based on item end time. Must be specified if <b>EndTimeFrom</b> is specified.
 * <br> <B>Input property:</B> <code>Sort</code> - This field can be used to control the order in which returned listings are sorted (based on the listings' actual/scheduled end dates). Valid values are as follows:
 * <ul>
 * <li><code>1</code> (descending order)</li>
 * <li>code>2</code> (ascending order)</li>
 * </ul>
 * <br> <B>Input property:</B> <code>StartTimeFilter</code> - Helper wrapper to set GetSellerListRequestType StartTimeFrom, StartTimeTo:
 * TimeFrom sets GetSellerListRequestType.StartTimeFrom: 
 * Specifies the earliest (oldest) date to use in a date range filter based on
 * item start time. Each of the time ranges must be a value less than
 * 120 days. In all calls, at least one date-range filter must be specified
 * (i.e., you must specify either the end time range or start time range
 * in every request).
 * TimeTo sets GetSellerListRequestType.StartTimeTo: 
 * Specifies the latest (most recent) date to use in a date range filter based on item start time. Must be specified if <b>StartTimeFrom</b> is specified.
 * <br> <B>Input property:</B> <code>Pagination</code> - This container controls the maximum number of listings that can appear on one page of the result set, as well as the page number of the result to return.
 * <br><br>
 * The <b>GetSellerList</b> call requires that the <b>EntriesPerPage</b> value be set. The <b>PageNumber</b> field is not required but will default to <code>1</code> if not included.
 * <br> <B>Input property:</B> <code>GranularityLevel</code> - This field allows the user to control the amount of data that is returned in the response. See the <a href="#GranularityLevel">Granularity Level</a> table on this page for a list of the fields that are returned for each granularity level. Either <b>GranularityLevel</b> or  <b>DetailLevel</b> can be used in a <b>GetSellerList</b> call, but not both. If both are specified, <b>DetailLevel</b> is ignored. If neither are used, the response fields will be the ones shown for 'Coarse' granularity.
 * <br> <B>Input property:</B> <code>SKUArray</code> - This container can be used to specify one or multiple SKUs, and only listings associated with these SKUs are retrieved. Note that all other request criteria are also considered when one or more SKU values are specified.
 * <br>
 * <br>
 * <span class="tablenote"><b>Note:</b>
 * Listings with matching SKUs are returned regardless of their
 * <b>Item.InventoryTrackingMethod</b> setting.
 * </span>
 * <br> <B>Input property:</B> <code>IncludeWatchCount</code> - This field may be included and set to <code>true</code> if the seller wishes to see the number of eBay users that are watching each listing.
 * <br> <B>Input property:</B> <code>AdminEndedItemsOnly</code> - This boolean field can be included and set to <code>true</code> if the seller would like to retrieve any listings that were administratively ended by eBay due to a listing policy violation.
 * <br> <B>Input property:</B> <code>CategoryID</code> - If you specify a <b>CategoryID</b> value, the response will only contain listings in the category you specify.
 * <br> <B>Input property:</B> <code>IncludeVariations</code> - If this field is included and set to <code>true</code>, the <b>Variations</b> node is returned for all multi-variation listings in the response.
 * <br>
 * <br>
 * <span class="tablenote"><b>Note: </b> If the seller has many multiple-variation listings, that seller may not want to include variations in the <b>GetSellerList</b> response.  Or, a seller can include variations data, but possibly limit the response by specifying shorter date ranges with the date range filters, or by reducing the number of listings returned per results (decreasing the <b>Pagination.EntriesPerPage</b> value).
 * </span>
 * <br> <B>Output property:</B> <code>PaginationResult</code> - This container shows the total number or pages in the result set, as well as the total number of listings that match the current input criteria.
 * <br> <B>Output property:</B> <code>HasMoreItems</code> - This field's value is returned as <code>true</code> if there are more pages in the current result set to view, or <code>false</code> if the current page being viewed is the last (or only) page of the result set.
 * <br/><br/>
 * If there are more listings to view in the result set, additional <b>GetSellerList</b> calls can be made but with changes to the <b>Pagination</b> values in the request. For example, if the <b>Pagination.PageNumber</b> value in the request for the last call was <code>1</code>, you can make another <b>GetSellerList</b> call, keeping everything the same except changing the value of the <b>Pagination.PageNumber</b> field from <code>1</code> to <code>2</code>.
 * <br> <B>Output property:</B> <code>ReturnedItems</code> - This container is an array of one or more listings that match the input criteria. If none of the seller's listings match the input criteria, this container is returned as an empty tag.
 * <br> <B>Output property:</B> <code>ReturnedItemsPerPage</code> - This value reflects the value that was set in the <b>Pagination.EntriesPerPage</b> field in the request. This is the maximum number of listings that may be returned per page of the result set. Note that this value is only the maximum threshold and does not necessarily reflect the number of listings appearing on the current page of data.
 * <br> <B>Output property:</B> <code>ReturnedPageNumber</code> - This value indicates the current page of data in the result set that is being displayed. This value reflects the value specified in the <b>Pagination.PageNumber</b> field in the request. Note that page number defaults to <code>1</code> if the <b>Pagination.PageNumber</b> field was not included in the request.
 * <br> <B>Output property:</B> <code>ReturnedItemCountActual</code> - This value indicates the total number of listings being shown on the current page of the results set.
 * <br> <B>Output property:</B> <code>Seller</code> - This container consists of detailed information about the seller and the seller's account. This container is only returned if the <b>GranularityLevel</b> field is included in the request and set to <code>Fine</code>.
 * 
 * @author Ron Murphy
 * @version 1.0
 */

public class GetSellerListCall extends com.ebay.sdk.ApiCall
{
  
  private String userID = null;
  private UserIDArrayType motorsDealerUsers = null;
  private TimeFilter endTimeFilter = null;
  private int sort = 0;
  private TimeFilter startTimeFilter = null;
  private PaginationType pagination = null;
  private GranularityLevelCodeType granularityLevel = null;
  private SKUArrayType sKUArray = null;
  private Boolean includeWatchCount = null;
  private Boolean adminEndedItemsOnly = null;
  private Integer categoryID = null;
  private Boolean includeVariations = null;
  private GetSellerListRequestType request=null;
  private PaginationResultType paginationResult=null;
  private boolean hasMoreItems=false;
  private ItemType[] returnedItems=null;
  private Integer returnedItemsPerPage=null;
  private Integer returnedPageNumber=null;
  private int returnedItemCountActual=0;
  private UserType seller=null;


  /**
   * Constructor.
   */
  public GetSellerListCall() {
  }

  /**
   * Constructor.
   * @param apiContext The ApiContext object to be used to make the call.
   */
  public GetSellerListCall(ApiContext apiContext) {
    super(apiContext);
    

  }

  /**
   * This call is used to retrieve an array of listings for the seller. The seller must be associated with the user/application token being used to make the call.
   * <br/><br/>
   * This call requires that either the 'Start Time' or 'End Time' date range filters be used. The date range specified by either of these filters can not exceed 120 days or an error will occur.
   * <br/><br/>
   * This call also requires that pagination be used.
   * 
   * <br>
   * @throws ApiException
   * @throws SdkException
   * @throws Exception
   * @return The ItemType[] object.
   */
  public ItemType[] getSellerList()
      throws com.ebay.sdk.ApiException, com.ebay.sdk.SdkException, java.lang.Exception
  {
    GetSellerListRequestType req;
    if (this.request != null)
    {
      req = this.request;
    } else {
      req = new GetSellerListRequestType();
      req.setDetailLevel(this.getDetailLevel());
      if (this.userID != null)
        req.setUserID(this.userID);
      if (this.motorsDealerUsers != null)
        req.setMotorsDealerUsers(this.motorsDealerUsers);
      if (this.endTimeFilter != null)
      {
        req.setEndTimeFrom(this.endTimeFilter.getTimeFrom());
        req.setEndTimeTo(this.endTimeFilter.getTimeTo());
      }
      if (this.sort != 0)
        req.setSort(new Integer(this.sort));
      if (this.startTimeFilter != null)
      {
        req.setStartTimeFrom(this.startTimeFilter.getTimeFrom());
        req.setStartTimeTo(this.startTimeFilter.getTimeTo());
      }
      if (this.pagination != null)
        req.setPagination(this.pagination);
      if (this.granularityLevel != null)
        req.setGranularityLevel(this.granularityLevel);
      if (this.sKUArray != null)
        req.setSKUArray(this.sKUArray);
      if (this.includeWatchCount != null)
        req.setIncludeWatchCount(this.includeWatchCount);
      if (this.adminEndedItemsOnly != null)
        req.setAdminEndedItemsOnly(this.adminEndedItemsOnly);
      if (this.categoryID != null)
        req.setCategoryID(this.categoryID);
      if (this.includeVariations != null)
        req.setIncludeVariations(this.includeVariations);
  
    }

    GetSellerListResponseType resp = (GetSellerListResponseType) execute(req);

    this.paginationResult = resp.getPaginationResult();
    this.hasMoreItems = (resp.isHasMoreItems() == null? false: resp.isHasMoreItems().booleanValue());
    this.returnedItems = (resp.getItemArray() == null? null: resp.getItemArray().getItem());
    this.returnedItemsPerPage = resp.getItemsPerPage();
    this.returnedPageNumber = resp.getPageNumber();
    this.returnedItemCountActual = (resp.getReturnedItemCountActual() == null? 0: resp.getReturnedItemCountActual().intValue());
    this.seller = resp.getSeller();
    return this.getReturnedItems();
  }

  /**
   * Gets the GetSellerListRequestType.request.
   * @return GetSellerListRequestType
   */
  public GetSellerListRequestType getRequest()
  {
    return this.request;
  }


  /**
   * Sets the GetSellerListRequestType.request.
   * @param request GetSellerListRequestType
   */
  public void setRequest(GetSellerListRequestType request)
  {
    this.request = request;
  }

  /**
   * Gets the GetSellerListRequestType.adminEndedItemsOnly.
   * @return Boolean
   */
  public Boolean getAdminEndedItemsOnly()
  {
    return this.adminEndedItemsOnly;
  }

  /**
   * Sets the GetSellerListRequestType.adminEndedItemsOnly.
   * @param adminEndedItemsOnly Boolean
   */
  public void setAdminEndedItemsOnly(Boolean adminEndedItemsOnly)
  {
    this.adminEndedItemsOnly = adminEndedItemsOnly;
  }

  /**
   * Gets the GetSellerListRequestType.categoryID.
   * @return Integer
   */
  public Integer getCategoryID()
  {
    return this.categoryID;
  }

  /**
   * Sets the GetSellerListRequestType.categoryID.
   * @param categoryID Integer
   */
  public void setCategoryID(Integer categoryID)
  {
    this.categoryID = categoryID;
  }

  /**
   * Gets the GetSellerListRequestType.endTimeFilter.
   * @return TimeFilter
   */
  public TimeFilter getEndTimeFilter()
  {
    return this.endTimeFilter;
  }

  /**
   * Sets the GetSellerListRequestType.endTimeFilter.
   * @param endTimeFilter TimeFilter
   */
  public void setEndTimeFilter(TimeFilter endTimeFilter)
  {
    this.endTimeFilter = endTimeFilter;
  }

  /**
   * Gets the GetSellerListRequestType.granularityLevel.
   * @return GranularityLevelCodeType
   */
  public GranularityLevelCodeType getGranularityLevel()
  {
    return this.granularityLevel;
  }

  /**
   * Sets the GetSellerListRequestType.granularityLevel.
   * @param granularityLevel GranularityLevelCodeType
   */
  public void setGranularityLevel(GranularityLevelCodeType granularityLevel)
  {
    this.granularityLevel = granularityLevel;
  }

  /**
   * Gets the GetSellerListRequestType.includeVariations.
   * @return Boolean
   */
  public Boolean getIncludeVariations()
  {
    return this.includeVariations;
  }

  /**
   * Sets the GetSellerListRequestType.includeVariations.
   * @param includeVariations Boolean
   */
  public void setIncludeVariations(Boolean includeVariations)
  {
    this.includeVariations = includeVariations;
  }

  /**
   * Gets the GetSellerListRequestType.includeWatchCount.
   * @return Boolean
   */
  public Boolean getIncludeWatchCount()
  {
    return this.includeWatchCount;
  }

  /**
   * Sets the GetSellerListRequestType.includeWatchCount.
   * @param includeWatchCount Boolean
   */
  public void setIncludeWatchCount(Boolean includeWatchCount)
  {
    this.includeWatchCount = includeWatchCount;
  }

  /**
   * Gets the GetSellerListRequestType.motorsDealerUsers.
   * @return UserIDArrayType
   */
  public UserIDArrayType getMotorsDealerUsers()
  {
    return this.motorsDealerUsers;
  }

  /**
   * Sets the GetSellerListRequestType.motorsDealerUsers.
   * @param motorsDealerUsers UserIDArrayType
   */
  public void setMotorsDealerUsers(UserIDArrayType motorsDealerUsers)
  {
    this.motorsDealerUsers = motorsDealerUsers;
  }

  /**
   * Gets the GetSellerListRequestType.pagination.
   * @return PaginationType
   */
  public PaginationType getPagination()
  {
    return this.pagination;
  }

  /**
   * Sets the GetSellerListRequestType.pagination.
   * @param pagination PaginationType
   */
  public void setPagination(PaginationType pagination)
  {
    this.pagination = pagination;
  }

  /**
   * Gets the GetSellerListRequestType.sKUArray.
   * @return SKUArrayType
   */
  public SKUArrayType getSKUArray()
  {
    return this.sKUArray;
  }

  /**
   * Sets the GetSellerListRequestType.sKUArray.
   * @param sKUArray SKUArrayType
   */
  public void setSKUArray(SKUArrayType sKUArray)
  {
    this.sKUArray = sKUArray;
  }

  /**
   * Gets the GetSellerListRequestType.sort.
   * @return int
   */
  public int getSort()
  {
    return this.sort;
  }

  /**
   * Sets the GetSellerListRequestType.sort.
   * @param sort int
   */
  public void setSort(int sort)
  {
    this.sort = sort;
  }

  /**
   * Gets the GetSellerListRequestType.startTimeFilter.
   * @return TimeFilter
   */
  public TimeFilter getStartTimeFilter()
  {
    return this.startTimeFilter;
  }

  /**
   * Sets the GetSellerListRequestType.startTimeFilter.
   * @param startTimeFilter TimeFilter
   */
  public void setStartTimeFilter(TimeFilter startTimeFilter)
  {
    this.startTimeFilter = startTimeFilter;
  }

  /**
   * Gets the GetSellerListRequestType.userID.
   * @return String
   */
  public String getUserID()
  {
    return this.userID;
  }

  /**
   * Sets the GetSellerListRequestType.userID.
   * @param userID String
   */
  public void setUserID(String userID)
  {
    this.userID = userID;
  }
/**
   * Get entire item list of the seller. Properties EndDate and Pagination
   * will be ignored. Patination related return fields (paginationResult,
   * hasMoreItems) will be ignored.
   * @throws ApiException
   * @throws SdkException
   * @throws Exception
   * @return ItemType[]
   */
  public com.ebay.soap.eBLBaseComponents.ItemType[] getEntireSellerList()
      throws com.ebay.sdk.ApiException, com.ebay.sdk.SdkException, java.lang.Exception
  {
    GetSellerListRequestType req = new GetSellerListRequestType();

    setRequest(req);
      req.setDetailLevel(this.getDetailLevel());
      if (this.userID != null)
        req.setUserID(this.userID);
      if (this.endTimeFilter != null)
      {
        req.setEndTimeFrom(this.endTimeFilter.getTimeFrom());
        req.setEndTimeTo(this.endTimeFilter.getTimeTo());
      }
      if (this.sort != 0)
        req.setSort(new Integer(this.sort));
      if (this.startTimeFilter != null)
      {
        req.setStartTimeFrom(this.startTimeFilter.getTimeFrom());
        req.setStartTimeTo(this.startTimeFilter.getTimeTo());
      }
      if (this.granularityLevel != null)
        req.setGranularityLevel(this.granularityLevel);
      if (this.sKUArray != null)
        req.setSKUArray(this.sKUArray);
      if (this.includeWatchCount != null)
        req.setIncludeWatchCount(this.includeWatchCount);

    int pageNum = 1;
    PaginationType pgn = new PaginationType();
    pgn.setEntriesPerPage(new Integer(100));
    pgn.setPageNumber(new Integer(pageNum++));

    req.setPagination(pgn);

    ArrayList items = new ArrayList();

    while(true)
    {
      GetSellerListResponseType resp = (GetSellerListResponseType)this.execute(req);
      ItemType tm[] = resp.getItemArray().getItem();
      if (tm != null) {
        for(int i = 0; i < tm.length; i ++)
          items.add(tm[i]);
      }
      if( resp.isHasMoreItems() == null || !resp.isHasMoreItems().booleanValue() )
        break;
      this.seller = resp.getSeller();
      this.returnedItemCountActual = resp.getReturnedItemCountActual() != null ? resp.getReturnedItemCountActual().intValue()
          : 0;

      // Increment page number.
      pgn.setPageNumber(new Integer(pageNum++));
    }

    // Build results.
    this.returnedItems = new ItemType[items.size()];
    for(int i = 0; i < returnedItems.length; i ++)
    {
      returnedItems[i] = (ItemType)items.get(i);
    }
    return returnedItems;
  }



  /**
   * Valid after executing the API.
   * Gets the returned GetSellerListResponseType.hasMoreItems.
   * 
   * @return boolean
   */
  public boolean getHasMoreItems()
  {
    return this.hasMoreItems;
  }

  /**
   * Valid after executing the API.
   * Gets the returned GetSellerListResponseType.paginationResult.
   * 
   * @return PaginationResultType
   */
  public PaginationResultType getPaginationResult()
  {
    return this.paginationResult;
  }

  /**
   * Valid after executing the API.
   * Gets the returned GetSellerListResponseType.returnedItemCountActual.
   * 
   * @return int
   */
  public int getReturnedItemCountActual()
  {
    return this.returnedItemCountActual;
  }

  /**
   * Valid after executing the API.
   * Gets the returned GetSellerListResponseType.returnedItems.
   * 
   * @return ItemType[]
   */
  public ItemType[] getReturnedItems()
  {
    return this.returnedItems;
  }

  /**
   * Valid after executing the API.
   * Gets the returned GetSellerListResponseType.returnedItemsPerPage.
   * 
   * @return Integer
   */
  public Integer getReturnedItemsPerPage()
  {
    return this.returnedItemsPerPage;
  }

  /**
   * Valid after executing the API.
   * Gets the returned GetSellerListResponseType.returnedPageNumber.
   * 
   * @return Integer
   */
  public Integer getReturnedPageNumber()
  {
    return this.returnedPageNumber;
  }

  /**
   * Valid after executing the API.
   * Gets the returned GetSellerListResponseType.seller.
   * 
   * @return UserType
   */
  public UserType getSeller()
  {
    return this.seller;
  }

}

