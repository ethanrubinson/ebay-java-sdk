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
import java.lang.Long;
import java.util.Calendar;

import com.ebay.sdk.*;
import com.ebay.soap.eBLBaseComponents.*;
/**
 * Wrapper class of the GetVeROReportStatus call of eBay SOAP API.
 * <br>
 * <p>Title: SOAP API wrapper library.</p>
 * <p>Description: Contains wrapper classes for eBay SOAP APIs.</p>
 * <p>Copyright: Copyright (c) 2009</p>
 * <p>Company: eBay Inc.</p>
 * <br> <B>Input property:</B> <code>VeROReportPacketID</code> - Packet identifier associated with the reported items for which you want to
 * retrieve status. By default, reported item details are not returned when
 * you specify the packet ID in the request. Applies only to items reported
 * with the <strong>VeROReportItems</strong> call.
 * <br> <B>Input property:</B> <code>ItemID</code> - Unique identifier for an eBay listing reported for alleged infringement. Applies to items reported with the <strong>VeROReportItems</strong> call or by other means (e.g., through the Web flow).
 * <br> <B>Input property:</B> <code>IncludeReportedItemDetails</code> - Set to true to return reported item details when you specify <strong>VeROReportPacketID</strong> in the request.
 * <br> <B>Input property:</B> <code>TimeFrom</code> - Limits returned items to only those that were submited on or after the
 * date-time specified. If specified, TimeTo must also be specified.
 * Express the date-time in the format YYYY-MM-DD HH:MM:SS, and in GMT.
 * (For information on how to convert between your local time zone
 * and GMT, see Time Values Note.) Applies to items reported with
 * VeROReportItems or by other means (e.g., through the web flow).
 * Infringement reporting data is maintained for two years after the date of
 * submission.
 * This field is ignored if <strong>VeROReportPacketID</strong> or <strong>ItemID</strong> is specified.
 * <br> <B>Input property:</B> <code>TimeTo</code> - Limits returned items to only those that were submited on or before the
 * date-time specified. If specified, TimeFrom must also be specified.
 * Express date-time in the format YYYY-MM-DD HH:MM:SS, and in GMT.
 * (For information on how to convert between your local time zone
 * and GMT, see Time Values Note.) Applies to items reported with
 * VeROReportItems or by other means (e.g., through the web flow).
 * Infringement reporting data is maintained for two years after the date of
 * submission.
 * This field is ignored if <strong>VeROReportPacketID</strong> or <strong>ItemID</strong> is specified.
 * <br> <B>Input property:</B> <code>Pagination</code> - Contains the data controlling the pagination of the returned values: how
 * many items are returned per page of data (per call) and the number of the
 * page to return with the current call.
 * <br> <B>Output property:</B> <code>ReturnedPaginationResult</code> - Contains information regarding the pagination of data (if pagination is
 * used), including total number of pages and total number of entries.
 * <br> <B>Output property:</B> <code>ReturnedHasMoreItems</code> - If true, there are more items yet to be retrieved. Additional
 * calls with higher page numbers or more items per page must
 * be made to retrieve these items. Not returned if no items match the
 * request.
 * <br> <B>Output property:</B> <code>ReturnedItemsPerPage</code> - Indicates the maximum number of Reported Item objects that can be returned in any given call.
 * <br/>
 * <br> <B>Output property:</B> <code>ReturnedPageNumber</code> - Indicates the page of data returned by the current call. For instance,
 * for the first set of items can be returned, this field has a value of
 * one.
 * <br/>
 * <br> <B>Output property:</B> <code>ReturnedVeROReportPacketID</code> - The packet ID for status being returned.
 * <br> <B>Output property:</B> <code>ReturnedVeROReportPacketStatus</code> - Status of the packet.
 * <br> <B>Output property:</B> <code>ReturnedReportedItemDetails</code> - This container of one or more reported items that match the input criteria in the call request. Returns empty if no items are available that match the request.
 * 
 * @author Ron Murphy
 * @version 1.0
 */

public class GetVeROReportStatusCall extends com.ebay.sdk.ApiCall
{
  
  private Long veROReportPacketID = null;
  private String itemID = null;
  private Boolean includeReportedItemDetails = null;
  private Calendar timeFrom = null;
  private Calendar timeTo = null;
  private PaginationType pagination = null;
  private PaginationResultType returnedPaginationResult=null;
  private Boolean returnedHasMoreItems=null;
  private Integer returnedItemsPerPage=null;
  private Integer returnedPageNumber=null;
  private Long returnedVeROReportPacketID=null;
  private VeROReportPacketStatusCodeType returnedVeROReportPacketStatus=null;
  private VeROReportedItemDetailsType returnedReportedItemDetails=null;


  /**
   * Constructor.
   */
  public GetVeROReportStatusCall() {
  }

  /**
   * Constructor.
   * @param apiContext The ApiContext object to be used to make the call.
   */
  public GetVeROReportStatusCall(ApiContext apiContext) {
    super(apiContext);
    

  }

  /**
   * Retrieves status information about VeRO reported items you have submitted. You
   * can receive the status of individual items you have reported or, by specifying
   * <strong>VeROReportPacketID</strong>, you can retrieve status for all items reported with a given
   * <strong>VeROReportItems</strong> request. You can also retrieve items that were reported during a
   * given time period. If no input parameters are specified, status is returned on all
   * items you have reported in the last two years.
   * You must be a member of the Verified Rights Owner (VeRO) Program to use this
   * call.
   * 
   * <br>
   * @throws ApiException
   * @throws SdkException
   * @throws Exception
   * @return The PaginationResultType object.
   */
  public PaginationResultType getVeROReportStatus()
      throws com.ebay.sdk.ApiException, com.ebay.sdk.SdkException, java.lang.Exception
  {
    GetVeROReportStatusRequestType req;
    req = new GetVeROReportStatusRequestType();
    if (this.veROReportPacketID != null)
      req.setVeROReportPacketID(this.veROReportPacketID);
    if (this.itemID != null)
      req.setItemID(this.itemID);
    if (this.includeReportedItemDetails != null)
      req.setIncludeReportedItemDetails(this.includeReportedItemDetails);
    if (this.timeFrom != null)
      req.setTimeFrom(this.timeFrom);
    if (this.timeTo != null)
      req.setTimeTo(this.timeTo);
    if (this.pagination != null)
      req.setPagination(this.pagination);

    GetVeROReportStatusResponseType resp = (GetVeROReportStatusResponseType) execute(req);

    this.returnedPaginationResult = resp.getPaginationResult();
    this.returnedHasMoreItems = resp.isHasMoreItems();
    this.returnedItemsPerPage = resp.getItemsPerPage();
    this.returnedPageNumber = resp.getPageNumber();
    this.returnedVeROReportPacketID = resp.getVeROReportPacketID();
    this.returnedVeROReportPacketStatus = resp.getVeROReportPacketStatus();
    this.returnedReportedItemDetails = resp.getReportedItemDetails();
    return this.getReturnedPaginationResult();
  }

  /**
   * Gets the GetVeROReportStatusRequestType.includeReportedItemDetails.
   * @return Boolean
   */
  public Boolean getIncludeReportedItemDetails()
  {
    return this.includeReportedItemDetails;
  }

  /**
   * Sets the GetVeROReportStatusRequestType.includeReportedItemDetails.
   * @param includeReportedItemDetails Boolean
   */
  public void setIncludeReportedItemDetails(Boolean includeReportedItemDetails)
  {
    this.includeReportedItemDetails = includeReportedItemDetails;
  }

  /**
   * Gets the GetVeROReportStatusRequestType.itemID.
   * @return String
   */
  public String getItemID()
  {
    return this.itemID;
  }

  /**
   * Sets the GetVeROReportStatusRequestType.itemID.
   * @param itemID String
   */
  public void setItemID(String itemID)
  {
    this.itemID = itemID;
  }

  /**
   * Gets the GetVeROReportStatusRequestType.pagination.
   * @return PaginationType
   */
  public PaginationType getPagination()
  {
    return this.pagination;
  }

  /**
   * Sets the GetVeROReportStatusRequestType.pagination.
   * @param pagination PaginationType
   */
  public void setPagination(PaginationType pagination)
  {
    this.pagination = pagination;
  }

  /**
   * Gets the GetVeROReportStatusRequestType.timeFrom.
   * @return Calendar
   */
  public Calendar getTimeFrom()
  {
    return this.timeFrom;
  }

  /**
   * Sets the GetVeROReportStatusRequestType.timeFrom.
   * @param timeFrom Calendar
   */
  public void setTimeFrom(Calendar timeFrom)
  {
    this.timeFrom = timeFrom;
  }

  /**
   * Gets the GetVeROReportStatusRequestType.timeTo.
   * @return Calendar
   */
  public Calendar getTimeTo()
  {
    return this.timeTo;
  }

  /**
   * Sets the GetVeROReportStatusRequestType.timeTo.
   * @param timeTo Calendar
   */
  public void setTimeTo(Calendar timeTo)
  {
    this.timeTo = timeTo;
  }

  /**
   * Gets the GetVeROReportStatusRequestType.veROReportPacketID.
   * @return Long
   */
  public Long getVeROReportPacketID()
  {
    return this.veROReportPacketID;
  }

  /**
   * Sets the GetVeROReportStatusRequestType.veROReportPacketID.
   * @param veROReportPacketID Long
   */
  public void setVeROReportPacketID(Long veROReportPacketID)
  {
    this.veROReportPacketID = veROReportPacketID;
  }

  /**
   * Valid after executing the API.
   * Gets the returned GetVeROReportStatusResponseType.returnedHasMoreItems.
   * 
   * @return Boolean
   */
  public Boolean getReturnedHasMoreItems()
  {
    return this.returnedHasMoreItems;
  }

  /**
   * Valid after executing the API.
   * Gets the returned GetVeROReportStatusResponseType.returnedItemsPerPage.
   * 
   * @return Integer
   */
  public Integer getReturnedItemsPerPage()
  {
    return this.returnedItemsPerPage;
  }

  /**
   * Valid after executing the API.
   * Gets the returned GetVeROReportStatusResponseType.returnedPageNumber.
   * 
   * @return Integer
   */
  public Integer getReturnedPageNumber()
  {
    return this.returnedPageNumber;
  }

  /**
   * Valid after executing the API.
   * Gets the returned GetVeROReportStatusResponseType.returnedPaginationResult.
   * 
   * @return PaginationResultType
   */
  public PaginationResultType getReturnedPaginationResult()
  {
    return this.returnedPaginationResult;
  }

  /**
   * Valid after executing the API.
   * Gets the returned GetVeROReportStatusResponseType.returnedReportedItemDetails.
   * 
   * @return VeROReportedItemDetailsType
   */
  public VeROReportedItemDetailsType getReturnedReportedItemDetails()
  {
    return this.returnedReportedItemDetails;
  }

  /**
   * Valid after executing the API.
   * Gets the returned GetVeROReportStatusResponseType.returnedVeROReportPacketID.
   * 
   * @return Long
   */
  public Long getReturnedVeROReportPacketID()
  {
    return this.returnedVeROReportPacketID;
  }

  /**
   * Valid after executing the API.
   * Gets the returned GetVeROReportStatusResponseType.returnedVeROReportPacketStatus.
   * 
   * @return VeROReportPacketStatusCodeType
   */
  public VeROReportPacketStatusCodeType getReturnedVeROReportPacketStatus()
  {
    return this.returnedVeROReportPacketStatus;
  }

}

