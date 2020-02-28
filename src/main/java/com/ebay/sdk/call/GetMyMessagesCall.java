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
import java.util.Calendar;

import com.ebay.sdk.*;
import com.ebay.soap.eBLBaseComponents.*;
/**
 * Wrapper class of the GetMyMessages call of eBay SOAP API.
 * <br>
 * <p>Title: SOAP API wrapper library.</p>
 * <p>Description: Contains wrapper classes for eBay SOAP APIs.</p>
 * <p>Copyright: Copyright (c) 2009</p>
 * <p>Company: eBay Inc.</p>
 * <br> <B>Input property:</B> <code>AlertIDs</code> - This container is deprecated.
 * <br> <B>Input property:</B> <code>MessageIDs</code> - This container can be used to retrieve one or more specific messages identified with their unique <b>MessageID</b> values. Up to  10 <b>MessageID</b> values can be specified with one call.
 * <br> <B>Input property:</B> <code>FolderID</code> - A unique identifier for a My Messages folder. If a <b>FolderID</b> value is provided,
 * only messages from the specified folder are returned in the response.
 * <br> <B>Input property:</B> <code>StartTime</code> - The beginning of the date-range filter.
 * Filtering takes into account the entire timestamp of when messages were sent.
 * Messages expire after one year.
 * <br> <B>Input property:</B> <code>EndTime</code> - The end of the date-range filter. See StartTime
 * (which is the beginning of the date-range filter).
 * <br> <B>Input property:</B> <code>ExternalMessageIDs</code> - This field is currently available on the US site. A container for IDs that
 * uniquely identify messages for a given user. If provided at the time of message
 * creation, this ID can be used to retrieve messages and will take precedence
 * over message ID.
 * <br> <B>Input property:</B> <code>Pagination</code> - Specifies how to create virtual pages in the returned list (such as total
 * number of entries and total number of pages to return).
 * Default value for <b>EntriesPerPage</b> with <b>GetMyMessages</b> is 25.
 * <br> <B>Input property:</B> <code>IncludeHighPriorityMessageOnly</code> - If this field is included in the request and set to <code>true</code>, only High Priority messages are returned in the response.
 * <br> <B>Output property:</B> <code>ReturnedSummary</code> - Summary data for a given user's messages. This includes the numbers of new
 * messages, flagged messages, and total messages. The amount and type of
 * data returned is the same whether or not the request includes specific
 * Message IDs. Always/Conditionally returned logic assumes a detail level of
 * ReturnMessages.
 * <br> <B>Output property:</B> <code>ReturnedAlerts</code> - This container is deprecated.
 * <br> <B>Output property:</B> <code>ReturnedMyMessages</code> - This container consists of an array of one or more messages that match the search criteria in the call request.
 * 
 * @author Ron Murphy
 * @version 1.0
 */

public class GetMyMessagesCall extends com.ebay.sdk.ApiCall
{
  
  private String[] alertIDs = null;
  private String[] messageIDs = null;
  private long folderID = 0;
  private Calendar startTime = null;
  private Calendar endTime = null;
  private MyMessagesExternalMessageIDArrayType externalMessageIDs = null;
  private PaginationType pagination = null;
  private Boolean includeHighPriorityMessageOnly = null;
  private MyMessagesSummaryType returnedSummary=null;
  private MyMessagesAlertType[] returnedAlerts=null;
  private MyMessagesMessageType[] returnedMyMessages=null;


  /**
   * Constructor.
   */
  public GetMyMessagesCall() {
  }

  /**
   * Constructor.
   * @param apiContext The ApiContext object to be used to make the call.
   */
  public GetMyMessagesCall(ApiContext apiContext) {
    super(apiContext);
    

  }

  /**
   * Retrieves information about the messages sent to a given user.
   * 
   * <br>
   * @throws ApiException
   * @throws SdkException
   * @throws Exception
   * @return The void object.
   */
  public void getMyMessages()
      throws com.ebay.sdk.ApiException, com.ebay.sdk.SdkException, java.lang.Exception
  {
    GetMyMessagesRequestType req;
    req = new GetMyMessagesRequestType();
    if (this.alertIDs != null)
    {
      MyMessagesAlertIDArrayType ary = new MyMessagesAlertIDArrayType();
      ary.setAlertID(this.alertIDs);
      req.setAlertIDs(ary);
    }
    if (this.messageIDs != null)
    {
      MyMessagesMessageIDArrayType ary = new MyMessagesMessageIDArrayType();
      ary.setMessageID(this.messageIDs);
      req.setMessageIDs(ary);
    }
    if (this.folderID != 0)
      req.setFolderID(new Long(this.folderID));
    if (this.startTime != null)
      req.setStartTime(this.startTime);
    if (this.endTime != null)
      req.setEndTime(this.endTime);
    if (this.externalMessageIDs != null)
      req.setExternalMessageIDs(this.externalMessageIDs);
    if (this.pagination != null)
      req.setPagination(this.pagination);
    if (this.includeHighPriorityMessageOnly != null)
      req.setIncludeHighPriorityMessageOnly(this.includeHighPriorityMessageOnly);

    GetMyMessagesResponseType resp = (GetMyMessagesResponseType) execute(req);

    this.returnedSummary = resp.getSummary();
    this.returnedAlerts = (resp.getAlerts() == null? null: resp.getAlerts().getAlert());
    this.returnedMyMessages = (resp.getMessages() == null? null: resp.getMessages().getMessage());

  }

  /**
   * Gets the GetMyMessagesRequestType.alertIDs.
   * @return String[]
   */
  public String[] getAlertIDs()
  {
    return this.alertIDs;
  }

  /**
   * Sets the GetMyMessagesRequestType.alertIDs.
   * @param alertIDs String[]
   */
  public void setAlertIDs(String[] alertIDs)
  {
    this.alertIDs = alertIDs;
  }

  /**
   * Gets the GetMyMessagesRequestType.endTime.
   * @return Calendar
   */
  public Calendar getEndTime()
  {
    return this.endTime;
  }

  /**
   * Sets the GetMyMessagesRequestType.endTime.
   * @param endTime Calendar
   */
  public void setEndTime(Calendar endTime)
  {
    this.endTime = endTime;
  }

  /**
   * Gets the GetMyMessagesRequestType.externalMessageIDs.
   * @return MyMessagesExternalMessageIDArrayType
   */
  public MyMessagesExternalMessageIDArrayType getExternalMessageIDs()
  {
    return this.externalMessageIDs;
  }

  /**
   * Sets the GetMyMessagesRequestType.externalMessageIDs.
   * @param externalMessageIDs MyMessagesExternalMessageIDArrayType
   */
  public void setExternalMessageIDs(MyMessagesExternalMessageIDArrayType externalMessageIDs)
  {
    this.externalMessageIDs = externalMessageIDs;
  }

  /**
   * Gets the GetMyMessagesRequestType.folderID.
   * @return long
   */
  public long getFolderID()
  {
    return this.folderID;
  }

  /**
   * Sets the GetMyMessagesRequestType.folderID.
   * @param folderID long
   */
  public void setFolderID(long folderID)
  {
    this.folderID = folderID;
  }

  /**
   * Gets the GetMyMessagesRequestType.includeHighPriorityMessageOnly.
   * @return Boolean
   */
  public Boolean getIncludeHighPriorityMessageOnly()
  {
    return this.includeHighPriorityMessageOnly;
  }

  /**
   * Sets the GetMyMessagesRequestType.includeHighPriorityMessageOnly.
   * @param includeHighPriorityMessageOnly Boolean
   */
  public void setIncludeHighPriorityMessageOnly(Boolean includeHighPriorityMessageOnly)
  {
    this.includeHighPriorityMessageOnly = includeHighPriorityMessageOnly;
  }

  /**
   * Gets the GetMyMessagesRequestType.messageIDs.
   * @return String[]
   */
  public String[] getMessageIDs()
  {
    return this.messageIDs;
  }

  /**
   * Sets the GetMyMessagesRequestType.messageIDs.
   * @param messageIDs String[]
   */
  public void setMessageIDs(String[] messageIDs)
  {
    this.messageIDs = messageIDs;
  }

  /**
   * Gets the GetMyMessagesRequestType.pagination.
   * @return PaginationType
   */
  public PaginationType getPagination()
  {
    return this.pagination;
  }

  /**
   * Sets the GetMyMessagesRequestType.pagination.
   * @param pagination PaginationType
   */
  public void setPagination(PaginationType pagination)
  {
    this.pagination = pagination;
  }

  /**
   * Gets the GetMyMessagesRequestType.startTime.
   * @return Calendar
   */
  public Calendar getStartTime()
  {
    return this.startTime;
  }

  /**
   * Sets the GetMyMessagesRequestType.startTime.
   * @param startTime Calendar
   */
  public void setStartTime(Calendar startTime)
  {
    this.startTime = startTime;
  }

  /**
   * Valid after executing the API.
   * Gets the returned GetMyMessagesResponseType.returnedAlerts.
   * 
   * @return MyMessagesAlertType[]
   */
  public MyMessagesAlertType[] getReturnedAlerts()
  {
    return this.returnedAlerts;
  }

  /**
   * Valid after executing the API.
   * Gets the returned GetMyMessagesResponseType.returnedMyMessages.
   * 
   * @return MyMessagesMessageType[]
   */
  public MyMessagesMessageType[] getReturnedMyMessages()
  {
    return this.returnedMyMessages;
  }

  /**
   * Valid after executing the API.
   * Gets the returned GetMyMessagesResponseType.returnedSummary.
   * 
   * @return MyMessagesSummaryType
   */
  public MyMessagesSummaryType getReturnedSummary()
  {
    return this.returnedSummary;
  }

}

