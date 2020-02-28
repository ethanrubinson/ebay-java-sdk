/*
Copyright (c) 2013 eBay, Inc.
This program is licensed under the terms of the eBay Common Development and
Distribution License (CDDL) Version 1.0 (the "License") and any subsequent  version 
thereof released by eBay.  The then-current version of the License can be found 
at http://www.opensource.org/licenses/cddl1.php and in the eBaySDKLicense file that 
is under the eBay SDK ../docs directory.
*/

package com.ebay.sdk.call;

import java.lang.String;
import java.util.Calendar;

import com.ebay.sdk.*;
import com.ebay.soap.eBLBaseComponents.*;
/**
 * Wrapper class of the EndItem call of eBay SOAP API.
 * <br>
 * <p>Title: SOAP API wrapper library.</p>
 * <p>Description: Contains wrapper classes for eBay SOAP APIs.</p>
 * <p>Copyright: Copyright (c) 2009</p>
 * <p>Company: eBay Inc.</p>
 * <br> <B>Input property:</B> <code>ItemID</code> - Unique item ID that identifies the listing that you want to end.
 * <br> <B>Input property:</B> <code>EndingReason</code> - The seller's reason for ending the listing early is input into this required field. The seller is not allowed to use the <code>ProductDeleted</code> value, as this ending reason can only be used internally by eBay to administratively end a listing due to the associated Catalog product being removed from the eBay Catalog.
 * <br> <B>Input property:</B> <code>SellerInventoryID</code> - This field was previously only used to identify and end Half.com listings, and since the Half.com site has been shut down, this element is no longer applicable.
 * <br> <B>Output property:</B> <code>ReturnedEndTime</code> - This timestamp indicates the date and time (returned in GMT) when the specified eBay listing was ended.
 * 
 * @author Ron Murphy
 * @version 1.0
 */

public class EndItemCall extends com.ebay.sdk.ApiCall
{
  
  private String itemID = null;
  private EndReasonCodeType endingReason = null;
  private String sellerInventoryID = null;
  private Calendar returnedEndTime=null;


  /**
   * Constructor.
   */
  public EndItemCall() {
  }

  /**
   * Constructor.
   * @param apiContext The ApiContext object to be used to make the call.
   */
  public EndItemCall(ApiContext apiContext) {
    super(apiContext);
    

  }

  /**
   * Ends the specified item listing before the date and time at which it would normally end per the listing duration.
   * 
   * <br>
   * @throws ApiException
   * @throws SdkException
   * @throws Exception
   * @return The Calendar object.
   */
  public Calendar endItem()
      throws com.ebay.sdk.ApiException, com.ebay.sdk.SdkException, java.lang.Exception
  {
    EndItemRequestType req;
    req = new EndItemRequestType();

	if( this.itemID == null && this.sellerInventoryID == null)
	  throw new SdkException("Please set ItemID or sellerInventoryID (for Half items) to be ended.");
	if( this.itemID != null && this.sellerInventoryID != null)
	  throw new SdkException("Please set either an ItemID or a sellerInventoryID (for Half items) to be ended.");

    if (this.itemID != null)
      req.setItemID(this.itemID);
    if (this.endingReason != null)
      req.setEndingReason(this.endingReason);
    if (this.sellerInventoryID != null)
      req.setSellerInventoryID(this.sellerInventoryID);

    EndItemResponseType resp = (EndItemResponseType) execute(req);

    this.returnedEndTime = resp.getEndTime();
    return this.getReturnedEndTime();
  }

  /**
   * Gets the EndItemRequestType.endingReason.
   * @return EndReasonCodeType
   */
  public EndReasonCodeType getEndingReason()
  {
    return this.endingReason;
  }

  /**
   * Sets the EndItemRequestType.endingReason.
   * @param endingReason EndReasonCodeType
   */
  public void setEndingReason(EndReasonCodeType endingReason)
  {
    this.endingReason = endingReason;
  }

  /**
   * Gets the EndItemRequestType.itemID.
   * @return String
   */
  public String getItemID()
  {
    return this.itemID;
  }

  /**
   * Sets the EndItemRequestType.itemID.
   * @param itemID String
   */
  public void setItemID(String itemID)
  {
    this.itemID = itemID;
  }

  /**
   * Gets the EndItemRequestType.sellerInventoryID.
   * @return String
   */
  public String getSellerInventoryID()
  {
    return this.sellerInventoryID;
  }

  /**
   * Sets the EndItemRequestType.sellerInventoryID.
   * @param sellerInventoryID String
   */
  public void setSellerInventoryID(String sellerInventoryID)
  {
    this.sellerInventoryID = sellerInventoryID;
  }

  /**
   * Valid after executing the API.
   * Gets the returned EndItemResponseType.returnedEndTime.
   * 
   * @return Calendar
   */
  public Calendar getReturnedEndTime()
  {
    return this.returnedEndTime;
  }

}

