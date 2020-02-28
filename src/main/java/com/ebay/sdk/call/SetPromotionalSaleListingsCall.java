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

import com.ebay.sdk.*;
import com.ebay.soap.eBLBaseComponents.*;
/**
 * Wrapper class of the SetPromotionalSaleListings call of eBay SOAP API.
 * <br>
 * <p>Title: SOAP API wrapper library.</p>
 * <p>Description: Contains wrapper classes for eBay SOAP APIs.</p>
 * <p>Copyright: Copyright (c) 2009</p>
 * <p>Company: eBay Inc.</p>
 * <br> <B>Input property:</B> <code>PromotionalSaleID</code> - The unique identifier of the seller's promotional sale. Based on the <b>Action</b>
 * value, listings will either be added to or removed from the promotional sale.
 * <br> <B>Input property:</B> <code>Action</code> - This required field determines whether you are adding (specify 'Add') or
 * removing (specify 'Delete) one or more listings from the promotional sale
 * identified by the <b>PromotionalSaleID</b> value in the request.
 * <br><br>
 * If you specify 'Delete', you must include one or more <b>ItemID</b> values under the <b>PromotionalSaleItemIDArray</b> container, and you cannot use the other filter options in the request. If you specify 'Add', you can add one or more listings using any of the filtering options in the request. Active auction listings that have one or more bids cannot be added to or removed from a promotional sale.
 * <br> <B>Input property:</B> <code>PromotionalSaleItemIDArray</code> - Container consisting of one or more <b>ItemID</b> values. Based on the <b>Action</b> value, the listings identified by these <b>ItemID</b> values are either added to or removed from the promotional sale. <br><br> This container is required if listings are being removed (<b>Action</b>='Delete') from the promotional sale.
 * <br> <B>Input property:</B> <code>StoreCategoryID</code> - If a <b>StoreCategoryID</b> value is included in the call request, all active items in this eBay Store category are added to the promotional sale. This field cannot be used if the <b>Action</b> field is set to 'Delete'.
 * <br> <B>Input property:</B> <code>CategoryID</code> - If a <b>CategoryID</b> value is included in the call request, all active items in this eBay category are added to the promotional sale. This field cannot be used if the <b>Action</b> field is set to 'Delete'.
 * <br> <B>Input property:</B> <code>AllFixedPriceItems</code> - If this field is included and set to 'true' in the call request, all fixed-price listings are added to the promotional sale. This field cannot be used if the <b>Action</b> field is set to 'Delete'.
 * <br> <B>Input property:</B> <code>AllStoreInventoryItems</code> - This field is deprecated and should no longer be used because Store Inventory is no longer a supported listing format.
 * <br> <B>Input property:</B> <code>AllAuctionItems</code> - If this field is included and set to 'true' in the call request, all auction listings are added to the promotional sale. This field cannot be used if the <b>Action</b> field is set to 'Delete'.
 * <br> <B>Output property:</B> <code>ReturnedStatus</code> - The enumeration value in this field indicates the status of the promotional sale action (add or delete). See <b>PromotionalSaleStatusCodeType</b> for more information on status values.
 * 
 * @author Ron Murphy
 * @version 1.0
 */

public class SetPromotionalSaleListingsCall extends com.ebay.sdk.ApiCall
{
  
  private Long promotionalSaleID = null;
  private ModifyActionCodeType action = null;
  private ItemIDArrayType promotionalSaleItemIDArray = null;
  private Long storeCategoryID = null;
  private Long categoryID = null;
  private Boolean allFixedPriceItems = null;
  private Boolean allStoreInventoryItems = null;
  private Boolean allAuctionItems = null;
  private PromotionalSaleStatusCodeType returnedStatus=null;


  /**
   * Constructor.
   */
  public SetPromotionalSaleListingsCall() {
  }

  /**
   * Constructor.
   * @param apiContext The ApiContext object to be used to make the call.
   */
  public SetPromotionalSaleListingsCall(ApiContext apiContext) {
    super(apiContext);
    

  }

  /**
   * Enables the seller to change the item listings that are affected by a promotional sale. To use this call, the seller must be a registered eBay Store owner.
   * 
   * <br>
   * @throws ApiException
   * @throws SdkException
   * @throws Exception
   * @return The PromotionalSaleStatusCodeType object.
   */
  public PromotionalSaleStatusCodeType setPromotionalSaleListings()
      throws com.ebay.sdk.ApiException, com.ebay.sdk.SdkException, java.lang.Exception
  {
    SetPromotionalSaleListingsRequestType req;
    req = new SetPromotionalSaleListingsRequestType();
    if (this.promotionalSaleID != null)
      req.setPromotionalSaleID(this.promotionalSaleID);
    if (this.action != null)
      req.setAction(this.action);
    if (this.promotionalSaleItemIDArray != null)
      req.setPromotionalSaleItemIDArray(this.promotionalSaleItemIDArray);
    if (this.storeCategoryID != null)
      req.setStoreCategoryID(this.storeCategoryID);
    if (this.categoryID != null)
      req.setCategoryID(this.categoryID);
    if (this.allFixedPriceItems != null)
      req.setAllFixedPriceItems(this.allFixedPriceItems);
    if (this.allStoreInventoryItems != null)
      req.setAllStoreInventoryItems(this.allStoreInventoryItems);
    if (this.allAuctionItems != null)
      req.setAllAuctionItems(this.allAuctionItems);

    SetPromotionalSaleListingsResponseType resp = (SetPromotionalSaleListingsResponseType) execute(req);

    this.returnedStatus = resp.getStatus();
    return this.getReturnedStatus();
  }

  /**
   * Gets the SetPromotionalSaleListingsRequestType.action.
   * @return ModifyActionCodeType
   */
  public ModifyActionCodeType getAction()
  {
    return this.action;
  }

  /**
   * Sets the SetPromotionalSaleListingsRequestType.action.
   * @param action ModifyActionCodeType
   */
  public void setAction(ModifyActionCodeType action)
  {
    this.action = action;
  }

  /**
   * Gets the SetPromotionalSaleListingsRequestType.allAuctionItems.
   * @return Boolean
   */
  public Boolean getAllAuctionItems()
  {
    return this.allAuctionItems;
  }

  /**
   * Sets the SetPromotionalSaleListingsRequestType.allAuctionItems.
   * @param allAuctionItems Boolean
   */
  public void setAllAuctionItems(Boolean allAuctionItems)
  {
    this.allAuctionItems = allAuctionItems;
  }

  /**
   * Gets the SetPromotionalSaleListingsRequestType.allFixedPriceItems.
   * @return Boolean
   */
  public Boolean getAllFixedPriceItems()
  {
    return this.allFixedPriceItems;
  }

  /**
   * Sets the SetPromotionalSaleListingsRequestType.allFixedPriceItems.
   * @param allFixedPriceItems Boolean
   */
  public void setAllFixedPriceItems(Boolean allFixedPriceItems)
  {
    this.allFixedPriceItems = allFixedPriceItems;
  }

  /**
   * Gets the SetPromotionalSaleListingsRequestType.allStoreInventoryItems.
   * @return Boolean
   */
  public Boolean getAllStoreInventoryItems()
  {
    return this.allStoreInventoryItems;
  }

  /**
   * Sets the SetPromotionalSaleListingsRequestType.allStoreInventoryItems.
   * @param allStoreInventoryItems Boolean
   */
  public void setAllStoreInventoryItems(Boolean allStoreInventoryItems)
  {
    this.allStoreInventoryItems = allStoreInventoryItems;
  }

  /**
   * Gets the SetPromotionalSaleListingsRequestType.categoryID.
   * @return Long
   */
  public Long getCategoryID()
  {
    return this.categoryID;
  }

  /**
   * Sets the SetPromotionalSaleListingsRequestType.categoryID.
   * @param categoryID Long
   */
  public void setCategoryID(Long categoryID)
  {
    this.categoryID = categoryID;
  }

  /**
   * Gets the SetPromotionalSaleListingsRequestType.promotionalSaleID.
   * @return Long
   */
  public Long getPromotionalSaleID()
  {
    return this.promotionalSaleID;
  }

  /**
   * Sets the SetPromotionalSaleListingsRequestType.promotionalSaleID.
   * @param promotionalSaleID Long
   */
  public void setPromotionalSaleID(Long promotionalSaleID)
  {
    this.promotionalSaleID = promotionalSaleID;
  }

  /**
   * Gets the SetPromotionalSaleListingsRequestType.promotionalSaleItemIDArray.
   * @return ItemIDArrayType
   */
  public ItemIDArrayType getPromotionalSaleItemIDArray()
  {
    return this.promotionalSaleItemIDArray;
  }

  /**
   * Sets the SetPromotionalSaleListingsRequestType.promotionalSaleItemIDArray.
   * @param promotionalSaleItemIDArray ItemIDArrayType
   */
  public void setPromotionalSaleItemIDArray(ItemIDArrayType promotionalSaleItemIDArray)
  {
    this.promotionalSaleItemIDArray = promotionalSaleItemIDArray;
  }

  /**
   * Gets the SetPromotionalSaleListingsRequestType.storeCategoryID.
   * @return Long
   */
  public Long getStoreCategoryID()
  {
    return this.storeCategoryID;
  }

  /**
   * Sets the SetPromotionalSaleListingsRequestType.storeCategoryID.
   * @param storeCategoryID Long
   */
  public void setStoreCategoryID(Long storeCategoryID)
  {
    this.storeCategoryID = storeCategoryID;
  }

  /**
   * Valid after executing the API.
   * Gets the returned SetPromotionalSaleListingsResponseType.returnedStatus.
   * 
   * @return PromotionalSaleStatusCodeType
   */
  public PromotionalSaleStatusCodeType getReturnedStatus()
  {
    return this.returnedStatus;
  }

}

