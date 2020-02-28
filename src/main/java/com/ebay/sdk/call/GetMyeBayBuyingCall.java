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
 * Wrapper class of the GetMyeBayBuying call of eBay SOAP API.
 * <br>
 * <p>Title: SOAP API wrapper library.</p>
 * <p>Description: Contains wrapper classes for eBay SOAP APIs.</p>
 * <p>Copyright: Copyright (c) 2009</p>
 * <p>Company: eBay Inc.</p>
 * <br> <B>Input property:</B> <code>WatchList</code> - Include this container and set the <b>WatchList.Include</b> field to <code>true</code> to return the list of items on the eBay user's Watch List.
 * <br><br>
 * The user also has the option of using pagination and sorting for the list of watched items that will be returned.
 * <br> <B>Input property:</B> <code>BidList</code> - Include this container and set the <b>BidList.Include</b> field to <code>true</code> to return the list of auction items on which the eBay user has bid.
 * <br><br>
 * The user also has the option of using pagination and sorting for the list of auction items that will be returned.
 * <br> <B>Input property:</B> <code>BestOfferList</code> - Include this container and set the <b>BestOfferList.Include</b> field to <code>true</code> to return the list of items on which the eBay user has made a Best Offer.
 * <br><br>
 * The user also has the option of using pagination and sorting for the list of items that will be returned.
 * <br> <B>Input property:</B> <code>WonList</code> - Include this container and set the <b>WonList.Include</b> field to <code>true</code> to return the list of auction items on which the eBay user has bid on and won.
 * <br><br>
 * The user also has the option of using pagination and sorting for the list of auction items that will be returned.
 * <br> <B>Input property:</B> <code>LostList</code> - Include this container and set the <b>LostList.Include</b> field to <code>true</code> to return the list of auction items on which the eBay user has bid on and lost.
 * <br><br>
 * The user also has the option of using pagination and sorting for the list of auction items that will be returned.
 * <br> <B>Input property:</B> <code>FavoriteSearches</code> - Include this container and set the <b>FavoriteSearches.Include</b> field to <code>true</code> to return the list of the eBay user's saved searches.
 * <br> <B>Input property:</B> <code>FavoriteSellers</code> - Include this container and set the <b>FavoriteSellers.Include</b> field to <code>true</code> to return the list of the eBay user's saved sellers.
 * <br> <B>Input property:</B> <code>SecondChanceOffer</code> - Include this container and set the <b>SecondChanceOffer.Include</b> field to <code>true</code> to return any Second Chance Offers that the eBay user has received.
 * <br> <B>Input property:</B> <code>BidAssistantList</code> - This field is deprecated.
 * <br> <B>Input property:</B> <code>DeletedFromWonList</code> - Include this container and set the <b>DeletedFromWonList.Include</b> field to <code>true</code> to return the list of auction items on which the eBay user has bid on and won, but has deleted from their My eBay page.
 * <br><br>
 * The user also has the option of using pagination and sorting for the list of auction items that will be returned.
 * <br> <B>Input property:</B> <code>DeletedFromLostList</code> - Include this container and set the <b>DeletedFromLostList.Include</b> field to <code>true</code> to return the list of auction items on which the eBay user has bid on and lost, and has deleted from their My eBay page.
 * <br><br>
 * The user also has the option of using pagination and sorting for the list of auction items that will be returned.
 * <br> <B>Input property:</B> <code>BuyingSummary</code> - Include this container and set the <b>BuyingSummary.Include</b> field to <code>true</code> to return the <b>BuyingSummary</b> container in the response. The <b>BuyingSummary</b> container consists of buying/bidding activity counts and values.
 * <br> <B>Input property:</B> <code>UserDefinedLists</code> - Include this container and set the <b>UserDefinedLists.Include</b> field to <code>true</code> to return one or more user-defined lists. User-defined lists are lists created by the user in My eBay and consists of a combination of items, saved sellers, and/or saved searches.
 * <br> <B>Input property:</B> <code>HideVariations</code> - If this field is included and set to <code>true</code>, the <b>Variations</b> node (and all variation data) is omitted for all multiple-variation listings in the response. If this field is omitted or set to <code>false</code>, the <b>Variations</b> node is returned for all multiple-variation listings in the response.
 * <br>
 * <br> <B>Output property:</B> <code>ReturnedBuyingSummary</code> - This container consists of buying/bidding activity counts and values. For this container to be returned, the user must include the <b>BuyingSummary.Include</b> field in the request and set its value to <code>true</code>.
 * <br> <B>Output property:</B> <code>ReturnedWatchList</code> - This container consists of the items on the eBay user's Watch List. This container will be returned if the eBay user has one or more items on their Watch List.
 * <br><br>
 * This container will not be returned in the response (even if there are items on the Watch List) if the <b>DetailLevel</b> value is set to <code>ReturnSummary</code> and the <b>WatchList.Include</b> field is omitted or set to <code>false</code>.
 * <br> <B>Output property:</B> <code>ReturnedBidList</code> - This container consists of the auction items on which the eBay user has bid. This container will be returned if the eBay user has bid on one or more auction items.
 * <br><br>
 * This container will not be returned in the response (even if there are items on the Bid List) if the <b>DetailLevel</b> value is set to <code>ReturnSummary</code> and the <b>BidList.Include</b> field is omitted or set to <code>false</code>.
 * <br> <B>Output property:</B> <code>ReturnedBestOfferList</code> - This container consists of the items on which the eBay user has made Best Offers. This container will be returned if the eBay user has made one or more Best Offers.
 * <br><br>
 * This container will not be returned in the response (even if user has made Best Offers) if the <b>DetailLevel</b> value is set to <code>ReturnSummary</code> and the <b>BestOfferList.Include</b> field is omitted or set to <code>false</code>.
 * <br> <B>Output property:</B> <code>ReturnedWonList</code> - This container consists of the auction items on which the eBay user has won. This container will be returned if the eBay user has won one or more auction items.
 * <br><br>
 * This container will not be returned in the response (even if there are items on the Won List) if the <b>DetailLevel</b> value is set to <code>ReturnSummary</code> and the <b>WonList.Include</b> field is omitted or set to <code>false</code>.
 * <br> <B>Output property:</B> <code>ReturnedLostList</code> - This container consists of the auction items on which the eBay user has bid on but lost. This container will be returned if the eBay user has lost one or more auction items.
 * <br><br>
 * This container will not be returned in the response (even if the buyer has lost one or more auction items) if the <b>DetailLevel</b> value is set to <code>ReturnSummary</code> and the <b>LostList.Include</b> field is omitted or set to <code>false</code>.
 * <br> <B>Output property:</B> <code>ReturnedFavoriteSearches</code> - This container consists of the eBay user's saved searches. This container will be returned if the eBay user has one or more saved searches.
 * <br><br>
 * This container will not be returned in the response (even if the user has saved searches) if the <b>DetailLevel</b> value is set to <code>ReturnSummary</code> and the <b>FavoriteSearches.Include</b> field is omitted or set to <code>false</code>.
 * <br><br>
 * This container consists of the search name, search query, and other search
 * elements. The user can copy and paste the URL in the <b>SearchQuery</b> field into a browser to view the search results again.
 * <br> <B>Output property:</B> <code>ReturnedFavoriteSellers</code> - This container consists of the eBay user's saved sellers. This container will be returned if the eBay user has one or more saved sellers.
 * <br><br>
 * This container will not be returned in the response (even if the user has saved sellers) if the <b>DetailLevel</b> value is set to <code>ReturnSummary</code> and the <b>FavoriteSellers.Include</b> field is omitted or set to <code>false</code>.
 * <br><br>
 * This container consists of the saved sellers' user IDs and eBay Store names (if applicable).
 * <br> <B>Output property:</B> <code>ReturnedSecondChanceOffer</code> - This container consists of the items on which the eBay user has received a Second Chance Offer. This container will be returned if the eBay user has made one or more Second Chance Offers.
 * <br><br>
 * This container will not be returned in the response (even if user has received Second Chance Offers) if the <b>DetailLevel</b> value is set to <code>ReturnSummary</code> and the <b>SecondChanceOffer.Include</b> field is omitted or set to <code>false</code>.
 * <br> <B>Output property:</B> <code>ReturnedBidAssistantList</code> - This field is deprecated.
 * <br> <B>Output property:</B> <code>ReturnedDeletedFromWonList</code> - This container consists of the auction items on which the eBay user has won but deleted from their My eBay page. This container will be returned if the eBay user has won one or more auction items but have deleted these items from My eBay.
 * <br><br>
 * This container will not be returned in the response (even if they have won and then deleted one or more items) if the <b>DetailLevel</b> value is set to <code>ReturnSummary</code> and the <b>DeletedFromWonList.Include</b> field is omitted or set to <code>false</code>.
 * <br> <B>Output property:</B> <code>ReturnedDeletedFromLostList</code> - This container consists of the auction items on which the eBay user has lost and then deleted from their My eBay page. This container will be returned if the eBay user has lost one or more auction items and then deleted those items from My eBay.
 * <br><br>
 * This container will not be returned in the response (even if they have lost and then deleted one or more items) if the <b>DetailLevel</b> value is set to <code>ReturnSummary</code> and the <b>DeletedFromLostList.Include</b> field is omitted or set to <code>false</code>.
 * <br> <B>Output property:</B> <code>ReturnedUserDefinedList</code> - This container consists of data for a user-defined list that was created by the user in My eBay. User-defined lists consists of a combination of items, saved sellers, and/or saved searches.
 * <br><br>
 * This container will not be returned in the response (even if one or more user-defined lists exist) if the <b>DetailLevel</b> value is set to <code>ReturnSummary</code> and the <b>UserDefinedList.Include</b> field is omitted or set to <code>false</code>.
 * 
 * @author Ron Murphy
 * @version 1.0
 */

public class GetMyeBayBuyingCall extends com.ebay.sdk.ApiCall
{
  
  private ItemListCustomizationType watchList = null;
  private ItemListCustomizationType bidList = null;
  private ItemListCustomizationType bestOfferList = null;
  private ItemListCustomizationType wonList = null;
  private ItemListCustomizationType lostList = null;
  private MyeBaySelectionType favoriteSearches = null;
  private MyeBaySelectionType favoriteSellers = null;
  private MyeBaySelectionType secondChanceOffer = null;
  private BidAssistantListType bidAssistantList = null;
  private ItemListCustomizationType deletedFromWonList = null;
  private ItemListCustomizationType deletedFromLostList = null;
  private ItemListCustomizationType buyingSummary = null;
  private MyeBaySelectionType userDefinedLists = null;
  private Boolean hideVariations = null;
  private GetMyeBayBuyingRequestType myeBayBuyingRequest=null;
  private BuyingSummaryType returnedBuyingSummary=null;
  private PaginatedItemArrayType returnedWatchList=null;
  private PaginatedItemArrayType returnedBidList=null;
  private PaginatedItemArrayType returnedBestOfferList=null;
  private PaginatedOrderTransactionArrayType returnedWonList=null;
  private PaginatedItemArrayType returnedLostList=null;
  private MyeBayFavoriteSearchListType returnedFavoriteSearches=null;
  private MyeBayFavoriteSellerListType returnedFavoriteSellers=null;
  private ItemType[] returnedSecondChanceOffer=null;
  private BidGroupArrayType returnedBidAssistantList=null;
  private PaginatedOrderTransactionArrayType returnedDeletedFromWonList=null;
  private PaginatedItemArrayType returnedDeletedFromLostList=null;
  private UserDefinedListType[] returnedUserDefinedList=null;


  /**
   * Constructor.
   */
  public GetMyeBayBuyingCall() {
  }

  /**
   * Constructor.
   * @param apiContext The ApiContext object to be used to make the call.
   */
  public GetMyeBayBuyingCall(ApiContext apiContext) {
    super(apiContext);
    

  }

  /**
   * Retrieves information regarding a user's buying activity, such as items they are watching, bidding on, have won, did not win, and have made Best Offers on.
   * 
   * <br>
   * @throws ApiException
   * @throws SdkException
   * @throws Exception
   * @return The void object.
   */
  public void getMyeBayBuying()
      throws com.ebay.sdk.ApiException, com.ebay.sdk.SdkException, java.lang.Exception
  {
    GetMyeBayBuyingRequestType req;
    if (this.myeBayBuyingRequest != null)
    {
      req = this.myeBayBuyingRequest;
    } else {
      req = new GetMyeBayBuyingRequestType();
      if (this.watchList != null)
        req.setWatchList(this.watchList);
      if (this.bidList != null)
        req.setBidList(this.bidList);
      if (this.bestOfferList != null)
        req.setBestOfferList(this.bestOfferList);
      if (this.wonList != null)
        req.setWonList(this.wonList);
      if (this.lostList != null)
        req.setLostList(this.lostList);
      if (this.favoriteSearches != null)
        req.setFavoriteSearches(this.favoriteSearches);
      if (this.favoriteSellers != null)
        req.setFavoriteSellers(this.favoriteSellers);
      if (this.secondChanceOffer != null)
        req.setSecondChanceOffer(this.secondChanceOffer);
      if (this.bidAssistantList != null)
        req.setBidAssistantList(this.bidAssistantList);
      if (this.deletedFromWonList != null)
        req.setDeletedFromWonList(this.deletedFromWonList);
      if (this.deletedFromLostList != null)
        req.setDeletedFromLostList(this.deletedFromLostList);
      if (this.buyingSummary != null)
        req.setBuyingSummary(this.buyingSummary);
      if (this.userDefinedLists != null)
        req.setUserDefinedLists(this.userDefinedLists);
      if (this.hideVariations != null)
        req.setHideVariations(this.hideVariations);
  
    }

    GetMyeBayBuyingResponseType resp = (GetMyeBayBuyingResponseType) execute(req);

    this.returnedBuyingSummary = resp.getBuyingSummary();
    this.returnedWatchList = resp.getWatchList();
    this.returnedBidList = resp.getBidList();
    this.returnedBestOfferList = resp.getBestOfferList();
    this.returnedWonList = resp.getWonList();
    this.returnedLostList = resp.getLostList();
    this.returnedFavoriteSearches = resp.getFavoriteSearches();
    this.returnedFavoriteSellers = resp.getFavoriteSellers();
    this.returnedSecondChanceOffer = resp.getSecondChanceOffer();
    this.returnedBidAssistantList = resp.getBidAssistantList();
    this.returnedDeletedFromWonList = resp.getDeletedFromWonList();
    this.returnedDeletedFromLostList = resp.getDeletedFromLostList();
    this.returnedUserDefinedList = resp.getUserDefinedList();

  }

  /**
   * Gets the GetMyeBayBuyingRequestType.myeBayBuyingRequest.
   * @return GetMyeBayBuyingRequestType
   */
  public GetMyeBayBuyingRequestType getMyeBayBuyingRequest()
  {
    return this.myeBayBuyingRequest;
  }


  /**
   * Sets the GetMyeBayBuyingRequestType.myeBayBuyingRequest.
   * @param myeBayBuyingRequest GetMyeBayBuyingRequestType
   */
  public void setMyeBayBuyingRequest(GetMyeBayBuyingRequestType myeBayBuyingRequest)
  {
    this.myeBayBuyingRequest = myeBayBuyingRequest;
  }

  /**
   * Gets the GetMyeBayBuyingRequestType.bestOfferList.
   * @return ItemListCustomizationType
   */
  public ItemListCustomizationType getBestOfferList()
  {
    return this.bestOfferList;
  }

  /**
   * Sets the GetMyeBayBuyingRequestType.bestOfferList.
   * @param bestOfferList ItemListCustomizationType
   */
  public void setBestOfferList(ItemListCustomizationType bestOfferList)
  {
    this.bestOfferList = bestOfferList;
  }

  /**
   * Gets the GetMyeBayBuyingRequestType.bidAssistantList.
   * @return BidAssistantListType
   */
  public BidAssistantListType getBidAssistantList()
  {
    return this.bidAssistantList;
  }

  /**
   * Sets the GetMyeBayBuyingRequestType.bidAssistantList.
   * @param bidAssistantList BidAssistantListType
   */
  public void setBidAssistantList(BidAssistantListType bidAssistantList)
  {
    this.bidAssistantList = bidAssistantList;
  }

  /**
   * Gets the GetMyeBayBuyingRequestType.bidList.
   * @return ItemListCustomizationType
   */
  public ItemListCustomizationType getBidList()
  {
    return this.bidList;
  }

  /**
   * Sets the GetMyeBayBuyingRequestType.bidList.
   * @param bidList ItemListCustomizationType
   */
  public void setBidList(ItemListCustomizationType bidList)
  {
    this.bidList = bidList;
  }

  /**
   * Gets the GetMyeBayBuyingRequestType.buyingSummary.
   * @return ItemListCustomizationType
   */
  public ItemListCustomizationType getBuyingSummary()
  {
    return this.buyingSummary;
  }

  /**
   * Sets the GetMyeBayBuyingRequestType.buyingSummary.
   * @param buyingSummary ItemListCustomizationType
   */
  public void setBuyingSummary(ItemListCustomizationType buyingSummary)
  {
    this.buyingSummary = buyingSummary;
  }

  /**
   * Gets the GetMyeBayBuyingRequestType.deletedFromLostList.
   * @return ItemListCustomizationType
   */
  public ItemListCustomizationType getDeletedFromLostList()
  {
    return this.deletedFromLostList;
  }

  /**
   * Sets the GetMyeBayBuyingRequestType.deletedFromLostList.
   * @param deletedFromLostList ItemListCustomizationType
   */
  public void setDeletedFromLostList(ItemListCustomizationType deletedFromLostList)
  {
    this.deletedFromLostList = deletedFromLostList;
  }

  /**
   * Gets the GetMyeBayBuyingRequestType.deletedFromWonList.
   * @return ItemListCustomizationType
   */
  public ItemListCustomizationType getDeletedFromWonList()
  {
    return this.deletedFromWonList;
  }

  /**
   * Sets the GetMyeBayBuyingRequestType.deletedFromWonList.
   * @param deletedFromWonList ItemListCustomizationType
   */
  public void setDeletedFromWonList(ItemListCustomizationType deletedFromWonList)
  {
    this.deletedFromWonList = deletedFromWonList;
  }

  /**
   * Gets the GetMyeBayBuyingRequestType.favoriteSearches.
   * @return MyeBaySelectionType
   */
  public MyeBaySelectionType getFavoriteSearches()
  {
    return this.favoriteSearches;
  }

  /**
   * Sets the GetMyeBayBuyingRequestType.favoriteSearches.
   * @param favoriteSearches MyeBaySelectionType
   */
  public void setFavoriteSearches(MyeBaySelectionType favoriteSearches)
  {
    this.favoriteSearches = favoriteSearches;
  }

  /**
   * Gets the GetMyeBayBuyingRequestType.favoriteSellers.
   * @return MyeBaySelectionType
   */
  public MyeBaySelectionType getFavoriteSellers()
  {
    return this.favoriteSellers;
  }

  /**
   * Sets the GetMyeBayBuyingRequestType.favoriteSellers.
   * @param favoriteSellers MyeBaySelectionType
   */
  public void setFavoriteSellers(MyeBaySelectionType favoriteSellers)
  {
    this.favoriteSellers = favoriteSellers;
  }

  /**
   * Gets the GetMyeBayBuyingRequestType.hideVariations.
   * @return Boolean
   */
  public Boolean getHideVariations()
  {
    return this.hideVariations;
  }

  /**
   * Sets the GetMyeBayBuyingRequestType.hideVariations.
   * @param hideVariations Boolean
   */
  public void setHideVariations(Boolean hideVariations)
  {
    this.hideVariations = hideVariations;
  }

  /**
   * Gets the GetMyeBayBuyingRequestType.lostList.
   * @return ItemListCustomizationType
   */
  public ItemListCustomizationType getLostList()
  {
    return this.lostList;
  }

  /**
   * Sets the GetMyeBayBuyingRequestType.lostList.
   * @param lostList ItemListCustomizationType
   */
  public void setLostList(ItemListCustomizationType lostList)
  {
    this.lostList = lostList;
  }

  /**
   * Gets the GetMyeBayBuyingRequestType.secondChanceOffer.
   * @return MyeBaySelectionType
   */
  public MyeBaySelectionType getSecondChanceOffer()
  {
    return this.secondChanceOffer;
  }

  /**
   * Sets the GetMyeBayBuyingRequestType.secondChanceOffer.
   * @param secondChanceOffer MyeBaySelectionType
   */
  public void setSecondChanceOffer(MyeBaySelectionType secondChanceOffer)
  {
    this.secondChanceOffer = secondChanceOffer;
  }

  /**
   * Gets the GetMyeBayBuyingRequestType.userDefinedLists.
   * @return MyeBaySelectionType
   */
  public MyeBaySelectionType getUserDefinedLists()
  {
    return this.userDefinedLists;
  }

  /**
   * Sets the GetMyeBayBuyingRequestType.userDefinedLists.
   * @param userDefinedLists MyeBaySelectionType
   */
  public void setUserDefinedLists(MyeBaySelectionType userDefinedLists)
  {
    this.userDefinedLists = userDefinedLists;
  }

  /**
   * Gets the GetMyeBayBuyingRequestType.watchList.
   * @return ItemListCustomizationType
   */
  public ItemListCustomizationType getWatchList()
  {
    return this.watchList;
  }

  /**
   * Sets the GetMyeBayBuyingRequestType.watchList.
   * @param watchList ItemListCustomizationType
   */
  public void setWatchList(ItemListCustomizationType watchList)
  {
    this.watchList = watchList;
  }

  /**
   * Gets the GetMyeBayBuyingRequestType.wonList.
   * @return ItemListCustomizationType
   */
  public ItemListCustomizationType getWonList()
  {
    return this.wonList;
  }

  /**
   * Sets the GetMyeBayBuyingRequestType.wonList.
   * @param wonList ItemListCustomizationType
   */
  public void setWonList(ItemListCustomizationType wonList)
  {
    this.wonList = wonList;
  }

  /**
   * Valid after executing the API.
   * Gets the returned GetMyeBayBuyingResponseType.
   * 
   * @return GetMyeBayBuyingResponseType
   */
  public GetMyeBayBuyingResponseType getReturnedGetMyeBayBuyingResponse()
  {
    return (GetMyeBayBuyingResponseType) this.getResponseObject();
  }

  /**
   * Valid after executing the API.
   * Gets the returned GetMyeBayBuyingResponseType.returnedBestOfferList.
   * 
   * @return PaginatedItemArrayType
   */
  public PaginatedItemArrayType getReturnedBestOfferList()
  {
    return this.returnedBestOfferList;
  }

  /**
   * Valid after executing the API.
   * Gets the returned GetMyeBayBuyingResponseType.returnedBidAssistantList.
   * 
   * @return BidGroupArrayType
   */
  public BidGroupArrayType getReturnedBidAssistantList()
  {
    return this.returnedBidAssistantList;
  }

  /**
   * Valid after executing the API.
   * Gets the returned GetMyeBayBuyingResponseType.returnedBidList.
   * 
   * @return PaginatedItemArrayType
   */
  public PaginatedItemArrayType getReturnedBidList()
  {
    return this.returnedBidList;
  }

  /**
   * Valid after executing the API.
   * Gets the returned GetMyeBayBuyingResponseType.returnedBuyingSummary.
   * 
   * @return BuyingSummaryType
   */
  public BuyingSummaryType getReturnedBuyingSummary()
  {
    return this.returnedBuyingSummary;
  }

  /**
   * Valid after executing the API.
   * Gets the returned GetMyeBayBuyingResponseType.returnedDeletedFromLostList.
   * 
   * @return PaginatedItemArrayType
   */
  public PaginatedItemArrayType getReturnedDeletedFromLostList()
  {
    return this.returnedDeletedFromLostList;
  }

  /**
   * Valid after executing the API.
   * Gets the returned GetMyeBayBuyingResponseType.returnedDeletedFromWonList.
   * 
   * @return PaginatedOrderTransactionArrayType
   */
  public PaginatedOrderTransactionArrayType getReturnedDeletedFromWonList()
  {
    return this.returnedDeletedFromWonList;
  }

  /**
   * Valid after executing the API.
   * Gets the returned GetMyeBayBuyingResponseType.returnedFavoriteSearches.
   * 
   * @return MyeBayFavoriteSearchListType
   */
  public MyeBayFavoriteSearchListType getReturnedFavoriteSearches()
  {
    return this.returnedFavoriteSearches;
  }

  /**
   * Valid after executing the API.
   * Gets the returned GetMyeBayBuyingResponseType.returnedFavoriteSellers.
   * 
   * @return MyeBayFavoriteSellerListType
   */
  public MyeBayFavoriteSellerListType getReturnedFavoriteSellers()
  {
    return this.returnedFavoriteSellers;
  }

  /**
   * Valid after executing the API.
   * Gets the returned GetMyeBayBuyingResponseType.returnedLostList.
   * 
   * @return PaginatedItemArrayType
   */
  public PaginatedItemArrayType getReturnedLostList()
  {
    return this.returnedLostList;
  }

  /**
   * Valid after executing the API.
   * Gets the returned GetMyeBayBuyingResponseType.returnedSecondChanceOffer.
   * 
   * @return ItemType[]
   */
  public ItemType[] getReturnedSecondChanceOffer()
  {
    return this.returnedSecondChanceOffer;
  }

  /**
   * Valid after executing the API.
   * Gets the returned GetMyeBayBuyingResponseType.returnedUserDefinedList.
   * 
   * @return UserDefinedListType[]
   */
  public UserDefinedListType[] getReturnedUserDefinedList()
  {
    return this.returnedUserDefinedList;
  }

  /**
   * Valid after executing the API.
   * Gets the returned GetMyeBayBuyingResponseType.returnedWatchList.
   * 
   * @return PaginatedItemArrayType
   */
  public PaginatedItemArrayType getReturnedWatchList()
  {
    return this.returnedWatchList;
  }

  /**
   * Valid after executing the API.
   * Gets the returned GetMyeBayBuyingResponseType.returnedWonList.
   * 
   * @return PaginatedOrderTransactionArrayType
   */
  public PaginatedOrderTransactionArrayType getReturnedWonList()
  {
    return this.returnedWonList;
  }

}

