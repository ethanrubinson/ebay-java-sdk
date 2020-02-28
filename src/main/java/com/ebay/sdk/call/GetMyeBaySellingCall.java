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

import com.ebay.sdk.*;
import com.ebay.soap.eBLBaseComponents.*;
/**
 * Wrapper class of the GetMyeBaySelling call of eBay SOAP API.
 * <br>
 * <p>Title: SOAP API wrapper library.</p>
 * <p>Description: Contains wrapper classes for eBay SOAP APIs.</p>
 * <p>Copyright: Copyright (c) 2009</p>
 * <p>Company: eBay Inc.</p>
 * <br> <B>Input property:</B> <code>ScheduledList</code> - Include this container and set the <b>ScheduledList.Include</b> field to <code>true</code> to return the list of items that are scheduled to become active listings on eBay.com at a future date/time.
 * <br><br>
 * The user also has the option of using pagination and sorting for the list of Scheduled listings that will be returned.
 * <br> <B>Input property:</B> <code>ActiveList</code> - Include this container and set the <b>ActiveList.Include</b> field to <code>true</code> to return the list of active listings on eBay.com.
 * <br><br>
 * The user also has the option of using pagination and sorting for the list of active listings that will be returned.
 * <br> <B>Input property:</B> <code>SoldList</code> - Include this container and set the <b>SoldList.Include</b> field to <code>true</code> to return the list of sold order line items.
 * <br><br>
 * The user also has the option of using pagination and sorting for the list of sold items that will be returned.
 * <br> <B>Input property:</B> <code>UnsoldList</code> - Include this container and set the <b>UnsoldList.Include</b> field to <code>true</code> to return the listings that have ended without a purchase.
 * <br><br>
 * The user also has the option of using pagination and sorting for the list of unsold items that will be returned.
 * <br> <B>Input property:</B> <code>BidList</code> - This container is deprecated as a Bid List is no longer returned in <b>GetMyeBaySelling</b>.
 * <br> <B>Input property:</B> <code>DeletedFromSoldList</code> - Include this container and set the <b>DeletedFromSoldList.Include</b> field to <code>true</code> to return the list of sold order line items that have since been deleted from the seller's My eBay page.
 * <br><br>
 * The user also has the option of using pagination and sorting for the list of deleted, sold items that will be returned.
 * <br> <B>Input property:</B> <code>DeletedFromUnsoldList</code> - Include this container and set the <b>DeletedFromUnsoldList.Include</b> field to <code>true</code> to return the list of unsold order line items that have since been deleted from the seller's My eBay page.
 * <br><br>
 * The user also has the option of using pagination and sorting for the list of deleted, unsold items that will be returned.
 * <br> <B>Input property:</B> <code>SellingSummary</code> - Include this container and set the <b>SellingSummary.Include</b> field to <code>true</code> to return the <b>SellingSummary</b> container in the response. The <b>SellingSummary</b> container consists of selling activity counts and values.
 * <br> <B>Input property:</B> <code>HideVariations</code> - If this field is included and set to <code>true</code>, the <b>Variations</b> node (and all variation data) is omitted for all multiple-variation listings in the response. If this field is omitted or set to <code>false</code>, the <b>Variations</b> node is returned for all multiple-variation listings in the response.
 * <br>
 * <br> <B>Output property:</B> <code>ReturnedSellingSummary</code> - This container consists of seller activity counts and values. For this container to be returned, the user must include the <b>SellingSummary.Include</b> field in the request and set its value to <code>true</code>.
 * <br> <B>Output property:</B> <code>ReturnedScheduledList</code> - This container consists of the items that are scheduled to become active at a future date/time. This container will be returned if the eBay user has one or more listings scheduled to become active at a future date/time.
 * <br><br>
 * This container will not be returned in the response (even if there are listings scheduled to become active) if the <b>DetailLevel</b> value is set to <code>ReturnSummary</code> and the <b>ScheduledList.Include</b> field is omitted or set to <code>false</code>.
 * <br> <B>Output property:</B> <code>ReturnedActiveList</code> - This container consists of active listings. This container will be returned if the eBay user has one or more active listings on eBay.com.
 * <br><br>
 * This container will not be returned in the response (even if there are one or more active listings) if the <b>DetailLevel</b> value is set to <code>ReturnSummary</code> and the <b>ActiveList.Include</b> field is omitted or set to <code>false</code>.
 * <br> <B>Output property:</B> <code>ReturnedSoldList</code> - This container consists of order line items that have been sold. This container will be returned if the eBay user has one or more listings that have had recent sales.
 * <br><br>
 * This container will not be returned in the response (even if there are one or more sales) if the <b>DetailLevel</b> value is set to <code>ReturnSummary</code> and the <b>SoldList.Include</b> field is omitted or set to <code>false</code>.
 * <br> <B>Output property:</B> <code>ReturnedUnsoldList</code> - This container consists of listings that have ended without sales. This container will be returned if the eBay user has one or more listings that have ended without sales.
 * <br><br>
 * This container will not be returned in the response (even if there are one or more listings that ended without sales) if the <b>DetailLevel</b> value is set to <code>ReturnSummary</code> and the <b>UnsoldList.Include</b> field is omitted or set to <code>false</code>.
 * <br> <B>Output property:</B> <code>ReturnedSummary</code> - This container consists of seller activity counts and values. This container is always returned if there has been recent sell activity.
 * <br> <B>Output property:</B> <code>ReturnedBidList</code> - This container is no longer applicable to <b>GetMyeBaySelling</b>.
 * <br> <B>Output property:</B> <code>ReturnedDeletedFromSoldList</code> - This container consists of listings that have had sales but have been deleted from My eBay. This container will be returned if the eBay user has one or more listings with sales that have been deleted from My eBay.
 * <br><br>
 * This container will not be returned in the response (even if there are one or more listings that have sales but have been deleted) if the <b>DetailLevel</b> value is set to <code>ReturnSummary</code> and the <b>DeletedFromSoldList.Include</b> field is omitted or set to <code>false</code>.
 * <br> <B>Output property:</B> <code>ReturnedDeletedFromUnsoldList</code> - This container consists of listings that have ended without sales and have been deleted from My eBay. This container will be returned if the eBay user has one or more listings with sales that have been deleted from My eBay.
 * <br><br>
 * This container will not be returned in the response (even if there are one or more listings that have sales but have been deleted) if the <b>DetailLevel</b> value is set to <code>ReturnSummary</code> and the <b>DeletedFromSoldList.Include</b> field is omitted or set to <code>false</code>.
 * 
 * @author Ron Murphy
 * @version 1.0
 */

public class GetMyeBaySellingCall extends com.ebay.sdk.ApiCall
{
  
  private ItemListCustomizationType scheduledList = null;
  private ItemListCustomizationType activeList = null;
  private ItemListCustomizationType soldList = null;
  private ItemListCustomizationType unsoldList = null;
  private ItemListCustomizationType bidList = null;
  private ItemListCustomizationType deletedFromSoldList = null;
  private ItemListCustomizationType deletedFromUnsoldList = null;
  private ItemListCustomizationType sellingSummary = null;
  private Boolean hideVariations = null;
  private GetMyeBaySellingRequestType myeBaySellingRequest=null;
  private SellingSummaryType returnedSellingSummary=null;
  private PaginatedItemArrayType returnedScheduledList=null;
  private PaginatedItemArrayType returnedActiveList=null;
  private PaginatedOrderTransactionArrayType returnedSoldList=null;
  private PaginatedItemArrayType returnedUnsoldList=null;
  private MyeBaySellingSummaryType returnedSummary=null;
  private PaginatedItemArrayType returnedBidList=null;
  private PaginatedOrderTransactionArrayType returnedDeletedFromSoldList=null;
  private PaginatedItemArrayType returnedDeletedFromUnsoldList=null;


  /**
   * Constructor.
   */
  public GetMyeBaySellingCall() {
  }

  /**
   * Constructor.
   * @param apiContext The ApiContext object to be used to make the call.
   */
  public GetMyeBaySellingCall(ApiContext apiContext) {
    super(apiContext);
    

  }

  /**
   * Retrieves information regarding the user's selling activity, such as items that the user is currently selling (the Active list), auction listings that have bids, sold items, and unsold items.
   * 
   * <br>
   * @throws ApiException
   * @throws SdkException
   * @throws Exception
   * @return The void object.
   */
  public void getMyeBaySelling()
      throws com.ebay.sdk.ApiException, com.ebay.sdk.SdkException, java.lang.Exception
  {
    GetMyeBaySellingRequestType req;
    if (this.myeBaySellingRequest != null)
    {
      req = this.myeBaySellingRequest;
    } else {
      req = new GetMyeBaySellingRequestType();
      if (this.scheduledList != null)
        req.setScheduledList(this.scheduledList);
      if (this.activeList != null)
        req.setActiveList(this.activeList);
      if (this.soldList != null)
        req.setSoldList(this.soldList);
      if (this.unsoldList != null)
        req.setUnsoldList(this.unsoldList);
      if (this.bidList != null)
        req.setBidList(this.bidList);
      if (this.deletedFromSoldList != null)
        req.setDeletedFromSoldList(this.deletedFromSoldList);
      if (this.deletedFromUnsoldList != null)
        req.setDeletedFromUnsoldList(this.deletedFromUnsoldList);
      if (this.sellingSummary != null)
        req.setSellingSummary(this.sellingSummary);
      if (this.hideVariations != null)
        req.setHideVariations(this.hideVariations);
  
    }

    GetMyeBaySellingResponseType resp = (GetMyeBaySellingResponseType) execute(req);

    this.returnedSellingSummary = resp.getSellingSummary();
    this.returnedScheduledList = resp.getScheduledList();
    this.returnedActiveList = resp.getActiveList();
    this.returnedSoldList = resp.getSoldList();
    this.returnedUnsoldList = resp.getUnsoldList();
    this.returnedSummary = resp.getSummary();
    this.returnedBidList = resp.getBidList();
    this.returnedDeletedFromSoldList = resp.getDeletedFromSoldList();
    this.returnedDeletedFromUnsoldList = resp.getDeletedFromUnsoldList();

  }

  /**
   * Gets the GetMyeBaySellingRequestType.myeBaySellingRequest.
   * @return GetMyeBaySellingRequestType
   */
  public GetMyeBaySellingRequestType getMyeBaySellingRequest()
  {
    return this.myeBaySellingRequest;
  }


  /**
   * Sets the GetMyeBaySellingRequestType.myeBaySellingRequest.
   * @param myeBaySellingRequest GetMyeBaySellingRequestType
   */
  public void setMyeBaySellingRequest(GetMyeBaySellingRequestType myeBaySellingRequest)
  {
    this.myeBaySellingRequest = myeBaySellingRequest;
  }

  /**
   * Gets the GetMyeBaySellingRequestType.activeList.
   * @return ItemListCustomizationType
   */
  public ItemListCustomizationType getActiveList()
  {
    return this.activeList;
  }

  /**
   * Sets the GetMyeBaySellingRequestType.activeList.
   * @param activeList ItemListCustomizationType
   */
  public void setActiveList(ItemListCustomizationType activeList)
  {
    this.activeList = activeList;
  }

  /**
   * Gets the GetMyeBaySellingRequestType.bidList.
   * @return ItemListCustomizationType
   */
  public ItemListCustomizationType getBidList()
  {
    return this.bidList;
  }

  /**
   * Sets the GetMyeBaySellingRequestType.bidList.
   * @param bidList ItemListCustomizationType
   */
  public void setBidList(ItemListCustomizationType bidList)
  {
    this.bidList = bidList;
  }

  /**
   * Gets the GetMyeBaySellingRequestType.deletedFromSoldList.
   * @return ItemListCustomizationType
   */
  public ItemListCustomizationType getDeletedFromSoldList()
  {
    return this.deletedFromSoldList;
  }

  /**
   * Sets the GetMyeBaySellingRequestType.deletedFromSoldList.
   * @param deletedFromSoldList ItemListCustomizationType
   */
  public void setDeletedFromSoldList(ItemListCustomizationType deletedFromSoldList)
  {
    this.deletedFromSoldList = deletedFromSoldList;
  }

  /**
   * Gets the GetMyeBaySellingRequestType.deletedFromUnsoldList.
   * @return ItemListCustomizationType
   */
  public ItemListCustomizationType getDeletedFromUnsoldList()
  {
    return this.deletedFromUnsoldList;
  }

  /**
   * Sets the GetMyeBaySellingRequestType.deletedFromUnsoldList.
   * @param deletedFromUnsoldList ItemListCustomizationType
   */
  public void setDeletedFromUnsoldList(ItemListCustomizationType deletedFromUnsoldList)
  {
    this.deletedFromUnsoldList = deletedFromUnsoldList;
  }

  /**
   * Gets the GetMyeBaySellingRequestType.hideVariations.
   * @return Boolean
   */
  public Boolean getHideVariations()
  {
    return this.hideVariations;
  }

  /**
   * Sets the GetMyeBaySellingRequestType.hideVariations.
   * @param hideVariations Boolean
   */
  public void setHideVariations(Boolean hideVariations)
  {
    this.hideVariations = hideVariations;
  }

  /**
   * Gets the GetMyeBaySellingRequestType.scheduledList.
   * @return ItemListCustomizationType
   */
  public ItemListCustomizationType getScheduledList()
  {
    return this.scheduledList;
  }

  /**
   * Sets the GetMyeBaySellingRequestType.scheduledList.
   * @param scheduledList ItemListCustomizationType
   */
  public void setScheduledList(ItemListCustomizationType scheduledList)
  {
    this.scheduledList = scheduledList;
  }

  /**
   * Gets the GetMyeBaySellingRequestType.sellingSummary.
   * @return ItemListCustomizationType
   */
  public ItemListCustomizationType getSellingSummary()
  {
    return this.sellingSummary;
  }

  /**
   * Sets the GetMyeBaySellingRequestType.sellingSummary.
   * @param sellingSummary ItemListCustomizationType
   */
  public void setSellingSummary(ItemListCustomizationType sellingSummary)
  {
    this.sellingSummary = sellingSummary;
  }

  /**
   * Gets the GetMyeBaySellingRequestType.soldList.
   * @return ItemListCustomizationType
   */
  public ItemListCustomizationType getSoldList()
  {
    return this.soldList;
  }

  /**
   * Sets the GetMyeBaySellingRequestType.soldList.
   * @param soldList ItemListCustomizationType
   */
  public void setSoldList(ItemListCustomizationType soldList)
  {
    this.soldList = soldList;
  }

  /**
   * Gets the GetMyeBaySellingRequestType.unsoldList.
   * @return ItemListCustomizationType
   */
  public ItemListCustomizationType getUnsoldList()
  {
    return this.unsoldList;
  }

  /**
   * Sets the GetMyeBaySellingRequestType.unsoldList.
   * @param unsoldList ItemListCustomizationType
   */
  public void setUnsoldList(ItemListCustomizationType unsoldList)
  {
    this.unsoldList = unsoldList;
  }

  /**
   * Valid after executing the API.
   * Gets the returned GetMyeBaySellingResponseType.
   * 
   * @return GetMyeBaySellingResponseType
   */
  public GetMyeBaySellingResponseType getReturnedMyeBaySellingResponse()
  {
    return (GetMyeBaySellingResponseType) this.getResponseObject();
  }

  /**
   * Valid after executing the API.
   * Gets the returned GetMyeBaySellingResponseType.returnedActiveList.
   * 
   * @return PaginatedItemArrayType
   */
  public PaginatedItemArrayType getReturnedActiveList()
  {
    return this.returnedActiveList;
  }

  /**
   * Valid after executing the API.
   * Gets the returned GetMyeBaySellingResponseType.returnedBidList.
   * 
   * @return PaginatedItemArrayType
   */
  public PaginatedItemArrayType getReturnedBidList()
  {
    return this.returnedBidList;
  }

  /**
   * Valid after executing the API.
   * Gets the returned GetMyeBaySellingResponseType.returnedDeletedFromSoldList.
   * 
   * @return PaginatedOrderTransactionArrayType
   */
  public PaginatedOrderTransactionArrayType getReturnedDeletedFromSoldList()
  {
    return this.returnedDeletedFromSoldList;
  }

  /**
   * Valid after executing the API.
   * Gets the returned GetMyeBaySellingResponseType.returnedDeletedFromUnsoldList.
   * 
   * @return PaginatedItemArrayType
   */
  public PaginatedItemArrayType getReturnedDeletedFromUnsoldList()
  {
    return this.returnedDeletedFromUnsoldList;
  }

  /**
   * Valid after executing the API.
   * Gets the returned GetMyeBaySellingResponseType.returnedScheduledList.
   * 
   * @return PaginatedItemArrayType
   */
  public PaginatedItemArrayType getReturnedScheduledList()
  {
    return this.returnedScheduledList;
  }

  /**
   * Valid after executing the API.
   * Gets the returned GetMyeBaySellingResponseType.returnedSellingSummary.
   * 
   * @return SellingSummaryType
   */
  public SellingSummaryType getReturnedSellingSummary()
  {
    return this.returnedSellingSummary;
  }

  /**
   * Valid after executing the API.
   * Gets the returned GetMyeBaySellingResponseType.returnedSoldList.
   * 
   * @return PaginatedOrderTransactionArrayType
   */
  public PaginatedOrderTransactionArrayType getReturnedSoldList()
  {
    return this.returnedSoldList;
  }

  /**
   * Valid after executing the API.
   * Gets the returned GetMyeBaySellingResponseType.returnedSummary.
   * 
   * @return MyeBaySellingSummaryType
   */
  public MyeBaySellingSummaryType getReturnedSummary()
  {
    return this.returnedSummary;
  }

  /**
   * Valid after executing the API.
   * Gets the returned GetMyeBaySellingResponseType.returnedUnsoldList.
   * 
   * @return PaginatedItemArrayType
   */
  public PaginatedItemArrayType getReturnedUnsoldList()
  {
    return this.returnedUnsoldList;
  }

}

