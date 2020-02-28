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
 * Wrapper class of the EndFixedPriceItem call of eBay SOAP API.
 * <br>
 * <p>Title: SOAP API wrapper library.</p>
 * <p>Description: Contains wrapper classes for eBay SOAP APIs.</p>
 * <p>Copyright: Copyright (c) 2009</p>
 * <p>Company: eBay Inc.</p>
 * <br> <B>Input property:</B> <code>ItemID</code> - Unique identifier of the listing that you want to end.
 * <br><br>
 * In the <b>EndFixedPriceItem</b> request, either <b>ItemID</b> or <b>SKU</b> value is required.
 * If both are passed in and they don't refer to the same listing, eBay
 * ignores <b>SKU</b> and considers only the <b>ItemID</b>.
 * <br> <B>Input property:</B> <code>EndingReason</code> - The seller's reason for ending the listing early is input into this required field. The seller is not allowed to use the <code>ProductDeleted</code> value, as this ending reason can only be used internally by eBay to administratively end a listing due to the associated Catalog product being removed from the eBay Catalog.
 * <br> <B>Input property:</B> <code>SKU</code> - The seller-defined SKU (stock keeping unit) value of the item in the listing being ended. The <b>SKU</b> field can only be used to end a listing if that listing was created or relisted with an <b>AddFixedPriceItem</b> or <b>RelistFixedPriceItem</b> call, and the <b>Item.InventoryTrackingMethod</b> was included in the call and set to <code>SKU</code>.
 * <br><br>
 * In the <b>EndFixedPriceItem</b> request, either <b>ItemID</b> or <b>SKU</b> is required.
 * If both are passed in and they don't refer to the same listing, eBay
 * ignores <b>SKU</b> and considers only the lt;b>ItemID</b>.
 * <br> <B>Output property:</B> <code>ReturnedEndTime</code> - Timestamp that indicates the date and time (GMT) that the specified  listing was ended.
 * <br> <B>Output property:</B> <code>ReturnedSKU</code> - If a SKU (stock-keeping unit) exists for the item in the listing, it is returned in the response.
 * 
 * @author Ron Murphy
 * @version 1.0
 */

public class EndFixedPriceItemCall extends com.ebay.sdk.ApiCall
{
  
  private String itemID = null;
  private EndReasonCodeType endingReason = null;
  private String sKU = null;
  private Calendar returnedEndTime=null;
  private String returnedSKU=null;


  /**
   * Constructor.
   */
  public EndFixedPriceItemCall() {
  }

  /**
   * Constructor.
   * @param apiContext The ApiContext object to be used to make the call.
   */
  public EndFixedPriceItemCall(ApiContext apiContext) {
    super(apiContext);
    

  }

  /**
   * Ends the specified fixed-price listing before the date and time at which
   * it would normally end (per the listing duration).
   * 
   * <br>
   * @throws ApiException
   * @throws SdkException
   * @throws Exception
   * @return The Calendar object.
   */
  public Calendar endFixedPriceItem()
      throws com.ebay.sdk.ApiException, com.ebay.sdk.SdkException, java.lang.Exception
  {
    EndFixedPriceItemRequestType req;
    req = new EndFixedPriceItemRequestType();
    if (this.itemID != null)
      req.setItemID(this.itemID);
    if (this.endingReason != null)
      req.setEndingReason(this.endingReason);
    if (this.sKU != null)
      req.setSKU(this.sKU);

    EndFixedPriceItemResponseType resp = (EndFixedPriceItemResponseType) execute(req);

    this.returnedEndTime = resp.getEndTime();
    this.returnedSKU = resp.getSKU();
    return this.getReturnedEndTime();
  }

  /**
   * Gets the EndFixedPriceItemRequestType.endingReason.
   * @return EndReasonCodeType
   */
  public EndReasonCodeType getEndingReason()
  {
    return this.endingReason;
  }

  /**
   * Sets the EndFixedPriceItemRequestType.endingReason.
   * @param endingReason EndReasonCodeType
   */
  public void setEndingReason(EndReasonCodeType endingReason)
  {
    this.endingReason = endingReason;
  }

  /**
   * Gets the EndFixedPriceItemRequestType.itemID.
   * @return String
   */
  public String getItemID()
  {
    return this.itemID;
  }

  /**
   * Sets the EndFixedPriceItemRequestType.itemID.
   * @param itemID String
   */
  public void setItemID(String itemID)
  {
    this.itemID = itemID;
  }

  /**
   * Gets the EndFixedPriceItemRequestType.sKU.
   * @return String
   */
  public String getSKU()
  {
    return this.sKU;
  }

  /**
   * Sets the EndFixedPriceItemRequestType.sKU.
   * @param sKU String
   */
  public void setSKU(String sKU)
  {
    this.sKU = sKU;
  }

  /**
   * Valid after executing the API.
   * Gets the returned EndFixedPriceItemResponseType.returnedEndTime.
   * 
   * @return Calendar
   */
  public Calendar getReturnedEndTime()
  {
    return this.returnedEndTime;
  }

  /**
   * Valid after executing the API.
   * Gets the returned EndFixedPriceItemResponseType.returnedSKU.
   * 
   * @return String
   */
  public String getReturnedSKU()
  {
    return this.returnedSKU;
  }

}

