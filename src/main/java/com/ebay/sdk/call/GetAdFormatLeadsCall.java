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
 * Wrapper class of the GetAdFormatLeads call of eBay SOAP API.
 * <br>
 * <p>Title: SOAP API wrapper library.</p>
 * <p>Description: Contains wrapper classes for eBay SOAP APIs.</p>
 * <p>Copyright: Copyright (c) 2009</p>
 * <p>Company: eBay Inc.</p>
 * <br> <B>Input property:</B> <code>ItemID</code> - The unique identifier of an item listed on the eBay site.
 * Returned by eBay when the item is created. This ID must correspond
 * to an ad format item.
 * <br> <B>Input property:</B> <code>Status</code> - Filters the leads based on their status.
 * <br> <B>Input property:</B> <code>IncludeMemberMessages</code> - Boolean which indicates whether to return mail messages for this lead in a MemberMessage node.
 * <br> <B>Input property:</B> <code>StartCreationTime</code> - Used with EndCreationTime to limit the returned leads for a user to only
 * those with a creation date greater than or equal to the specified date and
 * time.
 * <br> <B>Input property:</B> <code>EndCreationTime</code> - Used with StartCreationTime to limit the returned leads for a user to only
 * those with a creation date less than or equal to the specified date and
 * time.
 * <br> <B>Output property:</B> <code>ReturnedAdFormatLeads</code> - Contains contact and other information for one lead. One node is
 * returned for each lead. Only returned at a detail level of ReturnAll. At
 * least one lead must be available for the specified item to return
 * AdFormatLead.
 * <br> <B>Output property:</B> <code>ReturnedAdFormatLeadCount</code> - The total number of leads returned. Only returned if you do not
 * specify a detail level.
 * 
 * @author Ron Murphy
 * @version 1.0
 */

public class GetAdFormatLeadsCall extends com.ebay.sdk.ApiCall
{
  
  private String itemID = null;
  private MessageStatusTypeCodeType status = null;
  private Boolean includeMemberMessages = null;
  private Calendar startCreationTime = null;
  private Calendar endCreationTime = null;
  private AdFormatLeadType[] returnedAdFormatLeads=null;
  private Integer returnedAdFormatLeadCount=null;


  /**
   * Constructor.
   */
  public GetAdFormatLeadsCall() {
  }

  /**
   * Constructor.
   * @param apiContext The ApiContext object to be used to make the call.
   */
  public GetAdFormatLeadsCall(ApiContext apiContext) {
    super(apiContext);
    

  }

  /**
   * Retrieves sales lead information for a lead generation listing.
   * 
   * <br>
   * @throws ApiException
   * @throws SdkException
   * @throws Exception
   * @return The void object.
   */
  public void getAdFormatLeads()
      throws com.ebay.sdk.ApiException, com.ebay.sdk.SdkException, java.lang.Exception
  {
    GetAdFormatLeadsRequestType req;
    req = new GetAdFormatLeadsRequestType();

    if( this.itemID == null )
      throw new SdkException("ItemID property is not set.");

    req.setDetailLevel(this.getDetailLevel());
    if (this.itemID != null)
      req.setItemID(this.itemID);
    if (this.status != null)
      req.setStatus(this.status);
    if (this.includeMemberMessages != null)
      req.setIncludeMemberMessages(this.includeMemberMessages);
    if (this.startCreationTime != null)
      req.setStartCreationTime(this.startCreationTime);
    if (this.endCreationTime != null)
      req.setEndCreationTime(this.endCreationTime);

    GetAdFormatLeadsResponseType resp = (GetAdFormatLeadsResponseType) execute(req);

    this.returnedAdFormatLeads = resp.getAdFormatLead();
    this.returnedAdFormatLeadCount = resp.getAdFormatLeadCount();

  }

  /**
   * Gets the GetAdFormatLeadsRequestType.endCreationTime.
   * @return Calendar
   */
  public Calendar getEndCreationTime()
  {
    return this.endCreationTime;
  }

  /**
   * Sets the GetAdFormatLeadsRequestType.endCreationTime.
   * @param endCreationTime Calendar
   */
  public void setEndCreationTime(Calendar endCreationTime)
  {
    this.endCreationTime = endCreationTime;
  }

  /**
   * Gets the GetAdFormatLeadsRequestType.includeMemberMessages.
   * @return Boolean
   */
  public Boolean getIncludeMemberMessages()
  {
    return this.includeMemberMessages;
  }

  /**
   * Sets the GetAdFormatLeadsRequestType.includeMemberMessages.
   * @param includeMemberMessages Boolean
   */
  public void setIncludeMemberMessages(Boolean includeMemberMessages)
  {
    this.includeMemberMessages = includeMemberMessages;
  }

  /**
   * Gets the GetAdFormatLeadsRequestType.itemID.
   * @return String
   */
  public String getItemID()
  {
    return this.itemID;
  }

  /**
   * Sets the GetAdFormatLeadsRequestType.itemID.
   * @param itemID String
   */
  public void setItemID(String itemID)
  {
    this.itemID = itemID;
  }

  /**
   * Gets the GetAdFormatLeadsRequestType.startCreationTime.
   * @return Calendar
   */
  public Calendar getStartCreationTime()
  {
    return this.startCreationTime;
  }

  /**
   * Sets the GetAdFormatLeadsRequestType.startCreationTime.
   * @param startCreationTime Calendar
   */
  public void setStartCreationTime(Calendar startCreationTime)
  {
    this.startCreationTime = startCreationTime;
  }

  /**
   * Gets the GetAdFormatLeadsRequestType.status.
   * @return MessageStatusTypeCodeType
   */
  public MessageStatusTypeCodeType getStatus()
  {
    return this.status;
  }

  /**
   * Sets the GetAdFormatLeadsRequestType.status.
   * @param status MessageStatusTypeCodeType
   */
  public void setStatus(MessageStatusTypeCodeType status)
  {
    this.status = status;
  }

  /**
   * Valid after executing the API.
   * Gets the returned GetAdFormatLeadsResponseType.returnedAdFormatLeadCount.
   * 
   * @return Integer
   */
  public Integer getReturnedAdFormatLeadCount()
  {
    return this.returnedAdFormatLeadCount;
  }

  /**
   * Valid after executing the API.
   * Gets the returned GetAdFormatLeadsResponseType.returnedAdFormatLeads.
   * 
   * @return AdFormatLeadType[]
   */
  public AdFormatLeadType[] getReturnedAdFormatLeads()
  {
    return this.returnedAdFormatLeads;
  }

}

