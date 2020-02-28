/*
Copyright (c) 2013 eBay, Inc.
This program is licensed under the terms of the eBay Common Development and
Distribution License (CDDL) Version 1.0 (the "License") and any subsequent  version 
thereof released by eBay.  The then-current version of the License can be found 
at http://www.opensource.org/licenses/cddl1.php and in the eBaySDKLicense file that 
is under the eBay SDK ../docs directory.
*/

package com.ebay.sdk.call;

import java.lang.Integer;

import com.ebay.sdk.*;
import com.ebay.soap.eBLBaseComponents.*;
/**
 * Wrapper class of the GetBestOffers call of eBay SOAP API.
 * <br>
 * <p>Title: SOAP API wrapper library.</p>
 * <p>Description: Contains wrapper classes for eBay SOAP APIs.</p>
 * <p>Copyright: Copyright (c) 2009</p>
 * <p>Company: eBay Inc.</p>
 * <br> <B>Input property:</B> <code>ItemID</code> - The unique identifier of an eBay listing. If an <b>ItemID</b> is used by itself in the call request, all Best Offers in all states are retrieved for this listing. However, the seller can also combine <b>ItemID</b> and a <b>BestOfferStatus</b> value if that seller only wants to see Best Offers in a specific state. If a <b>BestOfferID</b> field is included in the call request, any <b>ItemID</b> value will be ignored since eBay will only search for and return the Best Offer identified in the <b>BestOfferID</b> field.
 * <br> <B>Input property:</B> <code>BestOfferID</code> - The unique identifier of a Best Offer. An identifier for a Best Offer is automatically created by eBay once a prospective buyer makes a Best Offer on a Best Offer-enabled listing. If a <b>BestOfferID</b> value is supplied in the call request, any <b>ItemID</b> or <b>BestOfferStatus</b> values will be ignored. Only the Best Offer identified by the <b>BestOfferID</b> value will be returned.
 * <br> <B>Input property:</B> <code>BestOfferStatus</code> - This field can be used if the seller wants to retrieve Best Offers in a specific state. The typical use case for this field is when the seller wants to retrieve Best Offers in all states for a specific listing. In fact, the <b>All</b> value can only be used if an <b>ItemID</b> value is also supplied in the call request. If a <b>BestOfferID</b> field is included in the call request, any <b>BestOfferStatus</b> value will be ignored since eBay will only search for and return the Best Offer identified in the <b>BestOfferID</b> field.
 * <br/>
 * <br> <B>Input property:</B> <code>Pagination</code> - This container can be used if the seller is expecting that the <b>GetBestOffers</b> call will retrieve a large number of results, so that seller wishes to view just a subset (one page of multiple pages) of those results at a time. See this container's child fields for more information on how pagination is used.
 * <br> <B>Output property:</B> <code>ReturnedBestOffers</code> - All Best Offers for the item according to the filter or Best Offer ID (or both) used in the input. The buyer and seller messages are returned only if the detail level is defined. Includes the buyer and seller message only if the <code>ReturnAll</code> detail level is used. Only returned if Best Offers have been made.
 * <br> <B>Output property:</B> <code>ReturnedItem</code> - This container consists of several details about the listing for which a Best Offer has been made, including the Item ID, the current price of the item (not the Best Offer price), and the time that the listing is scheduled to end.
 * <br> <B>Output property:</B> <code>ReturnedItemBestOffersArray</code> - A collection of details about the Best Offers received for a specific item. Empty if there are no Best Offers.
 * <br> <B>Output property:</B> <code>ReturnedPageNumber</code> - This integer value indicates the current page number of Best Offers that is currently being shown. This value will be the same value passed into the <b>Pagination.PageNumber</b> field in the request.
 * <br> <B>Output property:</B> <code>ReturnedPaginationResult</code> - Provides information about the data returned, including the number of pages and the number
 * of entries.
 * 
 * @author Ron Murphy
 * @version 1.0
 */

public class GetBestOffersCall extends com.ebay.sdk.ApiCall
{
  
  private String itemID = null;
  private String bestOfferID = null;
  private BestOfferStatusCodeType bestOfferStatus = null;
  private PaginationType pagination = null;
  private BestOfferType[] returnedBestOffers=null;
  private ItemType returnedItem=null;
  private ItemBestOffersArrayType returnedItemBestOffersArray=null;
  private Integer returnedPageNumber=null;
  private PaginationResultType returnedPaginationResult=null;


  /**
   * Constructor.
   */
  public GetBestOffersCall() {
  }

  /**
   * Constructor.
   * @param apiContext The ApiContext object to be used to make the call.
   */
  public GetBestOffersCall(ApiContext apiContext) {
    super(apiContext);
    

  }

  /**
   * This is the base request type of the <b>GetBestOffers</b> call. Depending on the input parameters that are used, this call can be used by a seller to retrieve all active Best Offers, all Best Offers on a specific listing, a specific Best Offer for a specific listing, or Best Offers in a specific state.
   * <br/><br/>
   * <span class="tablenote"><b>Note: </b>
   * The Best Offer feature is now available for auction listings on the following sites: US, Canada, UK, Germany, Australia, France, Italy, and Spain. However, sellers must choose between offering Best Offer or Buy It Now on an auction listing, as both features cannot be enabled on the same auction listing.
   * </span>
   * 
   * <br>
   * @throws ApiException
   * @throws SdkException
   * @throws Exception
   * @return The void object.
   */
  public void getBestOffers()
      throws com.ebay.sdk.ApiException, com.ebay.sdk.SdkException, java.lang.Exception
  {
    GetBestOffersRequestType req;
    req = new GetBestOffersRequestType();
    req.setDetailLevel(this.getDetailLevel());
    if (this.itemID != null)
      req.setItemID(this.itemID);
    if (this.bestOfferID != null)
      req.setBestOfferID(this.bestOfferID);
    if (this.bestOfferStatus != null)
      req.setBestOfferStatus(this.bestOfferStatus);
    if (this.pagination != null)
      req.setPagination(this.pagination);

    GetBestOffersResponseType resp = (GetBestOffersResponseType) execute(req);

    this.returnedBestOffers = (resp.getBestOfferArray() == null? null: resp.getBestOfferArray().getBestOffer());
    this.returnedItem = resp.getItem();
    this.returnedItemBestOffersArray = resp.getItemBestOffersArray();
    this.returnedPageNumber = resp.getPageNumber();
    this.returnedPaginationResult = resp.getPaginationResult();

  }

  /**
   * Gets the GetBestOffersRequestType.bestOfferID.
   * @return String
   */
  public String getBestOfferID()
  {
    return this.bestOfferID;
  }

  /**
   * Sets the GetBestOffersRequestType.bestOfferID.
   * @param bestOfferID String
   */
  public void setBestOfferID(String bestOfferID)
  {
    this.bestOfferID = bestOfferID;
  }

  /**
   * Gets the GetBestOffersRequestType.bestOfferStatus.
   * @return BestOfferStatusCodeType
   */
  public BestOfferStatusCodeType getBestOfferStatus()
  {
    return this.bestOfferStatus;
  }

  /**
   * Sets the GetBestOffersRequestType.bestOfferStatus.
   * @param bestOfferStatus BestOfferStatusCodeType
   */
  public void setBestOfferStatus(BestOfferStatusCodeType bestOfferStatus)
  {
    this.bestOfferStatus = bestOfferStatus;
  }

  /**
   * Gets the GetBestOffersRequestType.itemID.
   * @return String
   */
  public String getItemID()
  {
    return this.itemID;
  }

  /**
   * Sets the GetBestOffersRequestType.itemID.
   * @param itemID String
   */
  public void setItemID(String itemID)
  {
    this.itemID = itemID;
  }

  /**
   * Gets the GetBestOffersRequestType.pagination.
   * @return PaginationType
   */
  public PaginationType getPagination()
  {
    return this.pagination;
  }

  /**
   * Sets the GetBestOffersRequestType.pagination.
   * @param pagination PaginationType
   */
  public void setPagination(PaginationType pagination)
  {
    this.pagination = pagination;
  }

  /**
   * Valid after executing the API.
   * Gets the returned GetBestOffersResponseType.returnedBestOffers.
   * 
   * @return BestOfferType[]
   */
  public BestOfferType[] getReturnedBestOffers()
  {
    return this.returnedBestOffers;
  }

  /**
   * Valid after executing the API.
   * Gets the returned GetBestOffersResponseType.returnedItem.
   * 
   * @return ItemType
   */
  public ItemType getReturnedItem()
  {
    return this.returnedItem;
  }

  /**
   * Valid after executing the API.
   * Gets the returned GetBestOffersResponseType.returnedItemBestOffersArray.
   * 
   * @return ItemBestOffersArrayType
   */
  public ItemBestOffersArrayType getReturnedItemBestOffersArray()
  {
    return this.returnedItemBestOffersArray;
  }

  /**
   * Valid after executing the API.
   * Gets the returned GetBestOffersResponseType.returnedPageNumber.
   * 
   * @return Integer
   */
  public Integer getReturnedPageNumber()
  {
    return this.returnedPageNumber;
  }

  /**
   * Valid after executing the API.
   * Gets the returned GetBestOffersResponseType.returnedPaginationResult.
   * 
   * @return PaginationResultType
   */
  public PaginationResultType getReturnedPaginationResult()
  {
    return this.returnedPaginationResult;
  }

}

