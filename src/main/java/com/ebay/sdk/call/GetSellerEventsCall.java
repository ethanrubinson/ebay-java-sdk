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
import java.util.Calendar;

import com.ebay.sdk.*;
import com.ebay.soap.eBLBaseComponents.*;
/**
 * Wrapper class of the GetSellerEvents call of eBay SOAP API.
 * <br>
 * <p>Title: SOAP API wrapper library.</p>
 * <p>Description: Contains wrapper classes for eBay SOAP APIs.</p>
 * <p>Copyright: Copyright (c) 2009</p>
 * <p>Company: eBay Inc.</p>
 * <br> <B>Input property:</B> <code>UserID</code> - <span class="tablenote"><strong>Note:</strong>
 * This field should no longer be used, and will be ignored if it is included in a <b>GetSellerEvents</b> request. There are plans to remove this field from the public WSDL. The only eBay user ID that can be used is the one associated with the authentication token.
 * </span>
 * <br> <B>Input property:</B> <code>StartTimeFilter</code> - Helper wrapper to set GetSellerEventsRequestType StartTimeFrom, StartTimeTo:
 * TimeFrom sets GetSellerEventsRequestType.StartTimeFrom: 
 * Describes the earliest (oldest) time to use in a time range filter based
 * on item start time. Must be specified if <b>StartTimeTo</b> is specified.
 * <br/><br/>
 * Either
 * the <b>StartTimeFrom</b>, <b>EndTimeFrom</b>, or <b>ModTimeFrom</b> filter must be specified.
 * <br/><br/>
 * If you do not specify the corresponding <b>To</b> filter,
 * it is set to the time you make the call.
 * <br/><br/>
 * For better results, the time period you use should be less than 48 hours.
 * If 3000 or more items are found, use a smaller time range.<br>
 * <br>
 * Include a 2-minute, overlapping buffer between requests.
 * For example, if <b>StartTimeTo</b> was 6:58 in a prior request,
 * the current request should use 6:56 in <b>StartTimeFrom</b>
 * (e.g., use ranges like 5:56-6:58, 6:56-7:58, 7:56-8:58).
 * TimeTo sets GetSellerEventsRequestType.StartTimeTo: 
 * Describes the latest (most recent) date to use in a time range filter
 * based on item start time. If you specify the corresponding <b>From</b> filter,
 * but you do not include <b>StartTimeTo</b>, the <b>StartTimeTo</b> is set to
 * the time you make the call.
 * <br> <B>Input property:</B> <code>EndTimeFilter</code> - Helper wrapper to set GetSellerEventsRequestType EndTimeFrom, EndTimeTo:
 * TimeFrom sets GetSellerEventsRequestType.EndTimeFrom: 
 * Describes the earliest (oldest) date to use in a time range filter based
 * on item end time. Must be specified if <b>EndTimeTo</b> is specified.
 * <br/><br/>
 * Either
 * the <b>StartTimeFrom</b>, <b>EndTimeFrom</b>, or <b>ModTimeFrom</b> filter must be specified.
 * If you do not specify the corresponding To filter,
 * it is set to the time you make the call.<br>
 * <br>
 * For better results, the time range you use should be less than 48 hours.
 * If 3000 or more items are found, use a smaller time range.<br>
 * <br>
 * Include a 2-minute, overlapping buffer between requests.
 * For example, if <b>EndTimeTo</b> was 6:58 in a prior request,
 * the current request should use 6:56 in <b>EndTimeFrom</b>
 * (e.g., use ranges like 5:56-6:58, 6:56-7:58, 7:56-8:58).
 * TimeTo sets GetSellerEventsRequestType.EndTimeTo: 
 * Describes the latest (most recent) date to use in a time range filter
 * based on item end time.
 * <br/><br/>
 * If you specify the corresponding <b>From</b> filter,
 * but you do not include <b>EndTimeTo</b>, then <b>EndTimeTo</b> is set
 * to the time you make the call.
 * <br> <B>Input property:</B> <code>ModTimeFilter</code> - Helper wrapper to set GetSellerEventsRequestType ModTimeFrom, ModTimeTo:
 * TimeFrom sets GetSellerEventsRequestType.ModTimeFrom: 
 * Describes the earliest (oldest) date to use in a time range filter based
 * on item modification time. Must be specified if <b>ModTimeTo</b> is specified. Either
 * the <b>StartTimeFrom</b>, <b>EndTimeFrom</b>, or <b>ModTimeFrom</b> filter must be specified.
 * If you do not specify the corresponding To filter,
 * it is set to the time you make the call.<br>
 * <br>
 * Include a 2-minute, overlapping buffer between requests.
 * For example, if <b>ModTimeTo</b> was 6:58 in a prior request,
 * the current request should use 6:56 in <b>ModTimeFrom</b>
 * (e.g., use ranges like 5:56-6:58, 6:56-7:58, 7:56-8:58).
 * <br><br>
 * For better results, the time range you use should be less than 48 hours.
 * If 3000 or more items are found, use a smaller time range.
 * <br><br>
 * If an unexpected item is returned (including an old item
 * or an unchanged active item), please ignore the item.
 * Although a maintenance process may have triggered a change in the modification time, item characteristics are unchanged.
 * TimeTo sets GetSellerEventsRequestType.ModTimeTo: 
 * Describes the latest (most recent) date and time to use in a time range filter based on the time an item's record was modified. If you specify the corresponding <b>From</b> filter, but you do not include <b>ModTimeTo</b> , then <b>ModTimeTo</b> is set to the time you make the call. Include a 2-minute buffer between the current time and the <b>ModTimeTo</b> filter.
 * <br> <B>Input property:</B> <code>IncludeNewItem</code> - If true, response includes only items that have been modified
 * within the <b>ModTime</b> range. If false, response includes all items.
 * <br> <B>Input property:</B> <code>IncludeWatchCount</code> - The seller can include this field and set its value to <code>true</code> if that seller wants to see how many prospective bidders/buyers currently have an item added to their Watch Lists. The Watch count is returned in the <b>WatchCount</b> field for each item in the response.
 * <br> <B>Input property:</B> <code>IncludeVariationSpecifics</code> - Specifies whether to force the response to include
 * variation specifics for multiple-variation listings. <br>
 * <br>
 * If false (or not specified), eBay keeps the response as small as
 * possible by not returning <b>Variation.VariationSpecifics</b>.
 * It only returns <b>Variation.SKU</b> as an identifier
 * (along with the variation price and other selling details).
 * If the variation has no SKU, then <b>Variation.VariationSpecifics</b>
 * is returned as the variation's unique identifier.<br>
 * <br>
 * If true, <b>Variation.VariationSpecifics</b> is returned.
 * (<b>Variation.SKU</b> is also returned, if the variation has a SKU.)
 * This may be useful for applications that don't track variations
 * by SKU.<br>
 * <br>
 * Ignored when <b>HideVariations</b> is set to <b>true</b>.
 * <br>
 * <br>
 * <b>Note:</b>  If the seller includes a large number of
 * variations in many listings, using this flag may degrade the
 * call's performance. Therefore, when you use this flag, you may
 * need to reduce the total number of items you're requesting at
 * once. For example, you may need to use shorter time ranges in
 * the <b>StartTimeFrom</b>, <b>EndTimeFrom</b>, or <b>ModTimeFrom</b> filters.
 * <br> <B>Input property:</B> <code>HideVariations</code> - Specifies whether to force the response to hide
 * variation details for multiple-variation listings.<br>
 * <br>
 * If false (or not specified), eBay returns variation details (if
 * any). In this case, the amount of detail can be controlled by
 * using <b>IncludeVariationSpecifics</b>.<br>
 * <br>
 * If true, variation details are not returned (and
 * <b>IncludeVariationSpecifics</b> has no effect). This may be useful for applications that use other calls, notifications, alerts, or reports to track price and quantity details.
 * <br> <B>Output property:</B> <code>TimeTo</code> - Indicates the latest (most recent) date for any date-based filtering specified as
 * input. Specifically, this field contains the value you specified in the <b>StartTimeFrom</b>, <b>EndTimeFrom</b>, or <b>ModTimeFrom</b> filter, if you used a time filter in the request. If no time filter was specified, <b>TimeTo</b> returns the current time.
 * <br> <B>Output property:</B> <code>ReturnedSellerEvents</code> - Collection of items whose last modified time matches
 * the filters specified in the request.
 * Returns empty if no items were modified within the
 * time range of the request.<br/><br/>
 * If 1 to 2999 items are returned, then the results are
 * complete. If 3000 or more items are returned, it usually means
 * additional items exist within the time range you requested,
 * but they were not all returned.
 * <br/><br/>
 * To retrieve complete results,
 * use a smaller time range in the request so that fewer than
 * 3000 are returned per response.
 * 
 * @author Ron Murphy
 * @version 1.0
 */

public class GetSellerEventsCall extends com.ebay.sdk.ApiCall
{
  
  private String userID = null;
  private TimeFilter startTimeFilter = null;
  private TimeFilter endTimeFilter = null;
  private TimeFilter modTimeFilter = null;
  private boolean includeNewItem = false;
  private Boolean includeWatchCount = null;
  private Boolean includeVariationSpecifics = null;
  private Boolean hideVariations = null;
  private Calendar timeTo=null;
  private ItemType[] returnedSellerEvents=null;


  /**
   * Constructor.
   */
  public GetSellerEventsCall() {
  }

  /**
   * Constructor.
   * @param apiContext The ApiContext object to be used to make the call.
   */
  public GetSellerEventsCall(ApiContext apiContext) {
    super(apiContext);
    

  }

  /**
   * This call is used by a seller to retrieve changes to their own listings that have occurred within the last 48 hours, including price changes, available quantity, and other revisions to listing.
   * <br/><br/>
   * One of the available date range filters must be used with this call.
   * 
   * <br>
   * @throws ApiException
   * @throws SdkException
   * @throws Exception
   * @return The ItemType[] object.
   */
  public ItemType[] getSellerEvents()
      throws com.ebay.sdk.ApiException, com.ebay.sdk.SdkException, java.lang.Exception
  {
    GetSellerEventsRequestType req;
    req = new GetSellerEventsRequestType();
    req.setDetailLevel(this.getDetailLevel());
    if (this.userID != null)
      req.setUserID(this.userID);
    if (this.startTimeFilter != null)
    {
      req.setStartTimeFrom(this.startTimeFilter.getTimeFrom());
      req.setStartTimeTo(this.startTimeFilter.getTimeTo());
    }
    if (this.endTimeFilter != null)
    {
      req.setEndTimeFrom(this.endTimeFilter.getTimeFrom());
      req.setEndTimeTo(this.endTimeFilter.getTimeTo());
    }
    if (this.modTimeFilter != null)
    {
      req.setModTimeFrom(this.modTimeFilter.getTimeFrom());
      req.setModTimeTo(this.modTimeFilter.getTimeTo());
    }
    if (this.includeNewItem != false)
      req.setNewItemFilter(new Boolean(this.includeNewItem));
    if (this.includeWatchCount != null)
      req.setIncludeWatchCount(this.includeWatchCount);
    if (this.includeVariationSpecifics != null)
      req.setIncludeVariationSpecifics(this.includeVariationSpecifics);
    if (this.hideVariations != null)
      req.setHideVariations(this.hideVariations);

    GetSellerEventsResponseType resp = (GetSellerEventsResponseType) execute(req);

    this.timeTo = resp.getTimeTo();
    this.returnedSellerEvents = (resp.getItemArray() == null? null: resp.getItemArray().getItem());
    return this.getReturnedSellerEvents();
  }

  /**
   * Gets the GetSellerEventsRequestType.endTimeFilter.
   * @return TimeFilter
   */
  public TimeFilter getEndTimeFilter()
  {
    return this.endTimeFilter;
  }

  /**
   * Sets the GetSellerEventsRequestType.endTimeFilter.
   * @param endTimeFilter TimeFilter
   */
  public void setEndTimeFilter(TimeFilter endTimeFilter)
  {
    this.endTimeFilter = endTimeFilter;
  }

  /**
   * Gets the GetSellerEventsRequestType.hideVariations.
   * @return Boolean
   */
  public Boolean getHideVariations()
  {
    return this.hideVariations;
  }

  /**
   * Sets the GetSellerEventsRequestType.hideVariations.
   * @param hideVariations Boolean
   */
  public void setHideVariations(Boolean hideVariations)
  {
    this.hideVariations = hideVariations;
  }

  /**
   * Gets the GetSellerEventsRequestType.includeNewItem.
   * @return boolean
   */
  public boolean getIncludeNewItem()
  {
    return this.includeNewItem;
  }

  /**
   * Sets the GetSellerEventsRequestType.includeNewItem.
   * @param includeNewItem boolean
   */
  public void setIncludeNewItem(boolean includeNewItem)
  {
    this.includeNewItem = includeNewItem;
  }

  /**
   * Gets the GetSellerEventsRequestType.includeVariationSpecifics.
   * @return Boolean
   */
  public Boolean getIncludeVariationSpecifics()
  {
    return this.includeVariationSpecifics;
  }

  /**
   * Sets the GetSellerEventsRequestType.includeVariationSpecifics.
   * @param includeVariationSpecifics Boolean
   */
  public void setIncludeVariationSpecifics(Boolean includeVariationSpecifics)
  {
    this.includeVariationSpecifics = includeVariationSpecifics;
  }

  /**
   * Gets the GetSellerEventsRequestType.includeWatchCount.
   * @return Boolean
   */
  public Boolean getIncludeWatchCount()
  {
    return this.includeWatchCount;
  }

  /**
   * Sets the GetSellerEventsRequestType.includeWatchCount.
   * @param includeWatchCount Boolean
   */
  public void setIncludeWatchCount(Boolean includeWatchCount)
  {
    this.includeWatchCount = includeWatchCount;
  }

  /**
   * Gets the GetSellerEventsRequestType.modTimeFilter.
   * @return TimeFilter
   */
  public TimeFilter getModTimeFilter()
  {
    return this.modTimeFilter;
  }

  /**
   * Sets the GetSellerEventsRequestType.modTimeFilter.
   * @param modTimeFilter TimeFilter
   */
  public void setModTimeFilter(TimeFilter modTimeFilter)
  {
    this.modTimeFilter = modTimeFilter;
  }

  /**
   * Gets the GetSellerEventsRequestType.startTimeFilter.
   * @return TimeFilter
   */
  public TimeFilter getStartTimeFilter()
  {
    return this.startTimeFilter;
  }

  /**
   * Sets the GetSellerEventsRequestType.startTimeFilter.
   * @param startTimeFilter TimeFilter
   */
  public void setStartTimeFilter(TimeFilter startTimeFilter)
  {
    this.startTimeFilter = startTimeFilter;
  }

  /**
   * Gets the GetSellerEventsRequestType.userID.
   * @return String
   */
  public String getUserID()
  {
    return this.userID;
  }

  /**
   * Sets the GetSellerEventsRequestType.userID.
   * @param userID String
   */
  public void setUserID(String userID)
  {
    this.userID = userID;
  }

  /**
   * Valid after executing the API.
   * Gets the returned GetSellerEventsResponseType.returnedSellerEvents.
   * 
   * @return ItemType[]
   */
  public ItemType[] getReturnedSellerEvents()
  {
    return this.returnedSellerEvents;
  }

  /**
   * Valid after executing the API.
   * Gets the returned GetSellerEventsResponseType.timeTo.
   * 
   * @return Calendar
   */
  public Calendar getTimeTo()
  {
    return this.timeTo;
  }

}

