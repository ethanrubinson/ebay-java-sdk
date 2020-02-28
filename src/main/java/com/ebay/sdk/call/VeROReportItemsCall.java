/*
Copyright (c) 2013 eBay, Inc.
This program is licensed under the terms of the eBay Common Development and
Distribution License (CDDL) Version 1.0 (the "License") and any subsequent  version 
thereof released by eBay.  The then-current version of the License can be found 
at http://www.opensource.org/licenses/cddl1.php and in the eBaySDKLicense file that 
is under the eBay SDK ../docs directory.
*/

package com.ebay.sdk.call;

import java.lang.Long;

import com.ebay.sdk.*;
import com.ebay.soap.eBLBaseComponents.*;
/**
 * Wrapper class of the VeROReportItems call of eBay SOAP API.
 * <br>
 * <p>Title: SOAP API wrapper library.</p>
 * <p>Description: Contains wrapper classes for eBay SOAP APIs.</p>
 * <p>Copyright: Copyright (c) 2009</p>
 * <p>Company: eBay Inc.</p>
 * <br> <B>Input property:</B> <code>RightsOwnerID</code> - User ID of the VeRO member reporting the items.
 * <br> <B>Input property:</B> <code>ReportItems</code> - Container (packet) for items being reported. You can report the same item
 * more than once in a packet if a different reason code is used each time.
 * <br> <B>Output property:</B> <code>ReturnedVeROReportPacketID</code> - A unique packet identifier for the items reported.
 * <br> <B>Output property:</B> <code>ReturnedVeROReportPacketStatus</code> - The processing status of the packet.
 * 
 * @author Ron Murphy
 * @version 1.0
 */

public class VeROReportItemsCall extends com.ebay.sdk.ApiCall
{
  
  private String rightsOwnerID = null;
  private VeROReportItemsType reportItems = null;
  private Long returnedVeROReportPacketID=null;
  private VeROReportPacketStatusCodeType returnedVeROReportPacketStatus=null;


  /**
   * Constructor.
   */
  public VeROReportItemsCall() {
  }

  /**
   * Constructor.
   * @param apiContext The ApiContext object to be used to make the call.
   */
  public VeROReportItemsCall(ApiContext apiContext) {
    super(apiContext);
    

  }

  /**
   * Reports items that allegedly infringe your copyright, trademark, or other
   * intellectual property rights. You can report one or more items at a time with this
   * call. You must be a member of the Verified Rights Owner (VeRO) Program to use this
   * call.
   * 
   * <br>
   * @throws ApiException
   * @throws SdkException
   * @throws Exception
   * @return The Long object.
   */
  public Long veROReportItems()
      throws com.ebay.sdk.ApiException, com.ebay.sdk.SdkException, java.lang.Exception
  {
    VeROReportItemsRequestType req;
    req = new VeROReportItemsRequestType();
    if (this.rightsOwnerID != null)
      req.setRightsOwnerID(this.rightsOwnerID);
    if (this.reportItems != null)
      req.setReportItems(this.reportItems);

    VeROReportItemsResponseType resp = (VeROReportItemsResponseType) execute(req);

    this.returnedVeROReportPacketID = resp.getVeROReportPacketID();
    this.returnedVeROReportPacketStatus = resp.getVeROReportPacketStatus();
    return this.getReturnedVeROReportPacketID();
  }

  /**
   * Gets the VeROReportItemsRequestType.reportItems.
   * @return VeROReportItemsType
   */
  public VeROReportItemsType getReportItems()
  {
    return this.reportItems;
  }

  /**
   * Sets the VeROReportItemsRequestType.reportItems.
   * @param reportItems VeROReportItemsType
   */
  public void setReportItems(VeROReportItemsType reportItems)
  {
    this.reportItems = reportItems;
  }

  /**
   * Gets the VeROReportItemsRequestType.rightsOwnerID.
   * @return String
   */
  public String getRightsOwnerID()
  {
    return this.rightsOwnerID;
  }

  /**
   * Sets the VeROReportItemsRequestType.rightsOwnerID.
   * @param rightsOwnerID String
   */
  public void setRightsOwnerID(String rightsOwnerID)
  {
    this.rightsOwnerID = rightsOwnerID;
  }

  /**
   * Valid after executing the API.
   * Gets the returned VeROReportItemsResponseType.returnedVeROReportPacketID.
   * 
   * @return Long
   */
  public Long getReturnedVeROReportPacketID()
  {
    return this.returnedVeROReportPacketID;
  }

  /**
   * Valid after executing the API.
   * Gets the returned VeROReportItemsResponseType.returnedVeROReportPacketStatus.
   * 
   * @return VeROReportPacketStatusCodeType
   */
  public VeROReportPacketStatusCodeType getReturnedVeROReportPacketStatus()
  {
    return this.returnedVeROReportPacketStatus;
  }

}

