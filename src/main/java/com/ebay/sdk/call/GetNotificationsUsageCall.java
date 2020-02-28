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
 * Wrapper class of the GetNotificationsUsage call of eBay SOAP API.
 * <br>
 * <p>Title: SOAP API wrapper library.</p>
 * <p>Description: Contains wrapper classes for eBay SOAP APIs.</p>
 * <p>Copyright: Copyright (c) 2009</p>
 * <p>Company: eBay Inc.</p>
 * <br> <B>Input property:</B> <code>StartTime</code> - Specifies the start date and time for which notification information will be retrieved. <b>StartTime</b> is optional. If no <b>StartTime</b> is specified, the default value of 24 hours prior to the call time is used. If no <b>StartTime</b> is specified or if an invalid <b>StartTime</b> is specified, date range errors are returned in the response. For a <b>StartTime</b> to be valid, it must be no more than 72 hours before the time of the call, it cannot be more recent than the <b>EndTime</b>, and it cannot be later than the time of the call. If an invalid <b>StartTime</b> is specified, the default value is used.
 * <br> <B>Input property:</B> <code>EndTime</code> - Specifies the end date and time for which notification information will be retrieved. <b>EndTime</b> is optional. <br/><br/> If no <b>EndTime</b> is specified, the current time (the time the call is made) is used. If no <b>EndTime</b> is specified or if an invalid <b>EndTime</b> is specified, date range errors are returned in the response. For an <b>EndTime</b> to be valid, it must be no more than 72 hours before the time the of the call, it cannot be before the <b>StartTime</b>, and it cannot be later than the time of the call. If an invalid <b>EndTime</b> is specified, the current time is used.
 * <br> <B>Input property:</B> <code>ItemID</code> - Specifies an item ID for which detailed notification information will be retrieved. <b>ItemID</b> is optional. If no <b>ItemID</b> is specified, the response will not include any individual notification details.
 * <br> <B>Output property:</B> <code>ReturnedStartTime</code> - Returns the start date and time for the notification information that is
 * returned by this call.
 * <br> <B>Output property:</B> <code>ReturnedEndTime</code> - Returns the end date and time for the notification information that is
 * returned by this call.
 * <br> <B>Output property:</B> <code>ReturnedNotificationDetailsArray</code> - List of notification objects representing the notifications sent to an
 * application for the given time period. It will only be returned if ItemID
 * was specified in the input request.
 * <br> <B>Output property:</B> <code>ReturnedMarkUpMarkDownHistory</code> - List of objects representing <b>MarkUp</b> or <b>MarkDown</b> history for a given appID
 * and for given <b>StartTime</b> and <b>EndTime</b>. This node will always be returned.
 * <br> <B>Output property:</B> <code>ReturnedNotificationStatistics</code> - Summary information about number of notifications that were successfully
 * delivered, queued, failed, connection attempts made, connection timeouts,
 * http errors for the given appID and given time period. By default, statistics
 * for only one day (Now-1day) is included. Maximum time duration allowed is 3 days
 * (Now-3days).
 * 
 * @author Ron Murphy
 * @version 1.0
 */

public class GetNotificationsUsageCall extends com.ebay.sdk.ApiCall
{
  
  private Calendar startTime = null;
  private Calendar endTime = null;
  private String itemID = null;
  private Calendar returnedStartTime=null;
  private Calendar returnedEndTime=null;
  private NotificationDetailsArrayType returnedNotificationDetailsArray=null;
  private MarkUpMarkDownHistoryType returnedMarkUpMarkDownHistory=null;
  private NotificationStatisticsType returnedNotificationStatistics=null;


  /**
   * Constructor.
   */
  public GetNotificationsUsageCall() {
  }

  /**
   * Constructor.
   * @param apiContext The ApiContext object to be used to make the call.
   */
  public GetNotificationsUsageCall(ApiContext apiContext) {
    super(apiContext);
    

  }

  /**
   * Retrieves usage information about platform notifications for a given application.
   * You can use this notification information to troubleshoot issues with platform
   * notifications. You can call this up to 50 times per hour for a given application.
   * 
   * <br>
   * @throws ApiException
   * @throws SdkException
   * @throws Exception
   * @return The void object.
   */
  public void getNotificationsUsage()
      throws com.ebay.sdk.ApiException, com.ebay.sdk.SdkException, java.lang.Exception
  {
    GetNotificationsUsageRequestType req;
    req = new GetNotificationsUsageRequestType();
    if (this.startTime != null)
      req.setStartTime(this.startTime);
    if (this.endTime != null)
      req.setEndTime(this.endTime);
    if (this.itemID != null)
      req.setItemID(this.itemID);

    GetNotificationsUsageResponseType resp = (GetNotificationsUsageResponseType) execute(req);

    this.returnedStartTime = resp.getStartTime();
    this.returnedEndTime = resp.getEndTime();
    this.returnedNotificationDetailsArray = resp.getNotificationDetailsArray();
    this.returnedMarkUpMarkDownHistory = resp.getMarkUpMarkDownHistory();
    this.returnedNotificationStatistics = resp.getNotificationStatistics();

  }

  /**
   * Gets the GetNotificationsUsageRequestType.endTime.
   * @return Calendar
   */
  public Calendar getEndTime()
  {
    return this.endTime;
  }

  /**
   * Sets the GetNotificationsUsageRequestType.endTime.
   * @param endTime Calendar
   */
  public void setEndTime(Calendar endTime)
  {
    this.endTime = endTime;
  }

  /**
   * Gets the GetNotificationsUsageRequestType.itemID.
   * @return String
   */
  public String getItemID()
  {
    return this.itemID;
  }

  /**
   * Sets the GetNotificationsUsageRequestType.itemID.
   * @param itemID String
   */
  public void setItemID(String itemID)
  {
    this.itemID = itemID;
  }

  /**
   * Gets the GetNotificationsUsageRequestType.startTime.
   * @return Calendar
   */
  public Calendar getStartTime()
  {
    return this.startTime;
  }

  /**
   * Sets the GetNotificationsUsageRequestType.startTime.
   * @param startTime Calendar
   */
  public void setStartTime(Calendar startTime)
  {
    this.startTime = startTime;
  }

  /**
   * Valid after executing the API.
   * Gets the returned GetNotificationsUsageResponseType.returnedEndTime.
   * 
   * @return Calendar
   */
  public Calendar getReturnedEndTime()
  {
    return this.returnedEndTime;
  }

  /**
   * Valid after executing the API.
   * Gets the returned GetNotificationsUsageResponseType.returnedMarkUpMarkDownHistory.
   * 
   * @return MarkUpMarkDownHistoryType
   */
  public MarkUpMarkDownHistoryType getReturnedMarkUpMarkDownHistory()
  {
    return this.returnedMarkUpMarkDownHistory;
  }

  /**
   * Valid after executing the API.
   * Gets the returned GetNotificationsUsageResponseType.returnedNotificationDetailsArray.
   * 
   * @return NotificationDetailsArrayType
   */
  public NotificationDetailsArrayType getReturnedNotificationDetailsArray()
  {
    return this.returnedNotificationDetailsArray;
  }

  /**
   * Valid after executing the API.
   * Gets the returned GetNotificationsUsageResponseType.returnedNotificationStatistics.
   * 
   * @return NotificationStatisticsType
   */
  public NotificationStatisticsType getReturnedNotificationStatistics()
  {
    return this.returnedNotificationStatistics;
  }

  /**
   * Valid after executing the API.
   * Gets the returned GetNotificationsUsageResponseType.returnedStartTime.
   * 
   * @return Calendar
   */
  public Calendar getReturnedStartTime()
  {
    return this.returnedStartTime;
  }

}

