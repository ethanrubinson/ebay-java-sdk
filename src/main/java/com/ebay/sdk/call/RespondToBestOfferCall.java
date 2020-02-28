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
import java.lang.String;

import com.ebay.sdk.*;
import com.ebay.soap.eBLBaseComponents.*;
/**
 * Wrapper class of the RespondToBestOffer call of eBay SOAP API.
 * <br>
 * <p>Title: SOAP API wrapper library.</p>
 * <p>Description: Contains wrapper classes for eBay SOAP APIs.</p>
 * <p>Copyright: Copyright (c) 2009</p>
 * <p>Company: eBay Inc.</p>
 * <br> <B>Input property:</B> <code>ItemID</code> - The unique identifier of the listing to which the seller is responding to a Best Offer.
 * <br> <B>Input property:</B> <code>BestOfferIDs</code> - The unique identifier of a buyer's Best Offer for the order line item. This ID is created once the buyer makes a Best Offer. It is possible that a seller will get multiple Best Offers for an order line item, and if that seller would like to decline multiple/all of the Best Offers with one <b>RespondToBestOffer</b> call, the seller would pass in each of these identifiers in a separate <b>BestOfferID</b> field. However, the seller can only accept or counter offer one Best Offer at a time.
 * <br> <B>Input property:</B> <code>BestOfferAction</code> - The enumeration value that the seller passes in to this field will control whether the seller accepts or make a counter offer to a single buyer's Best Offer, or declines one or more buyers' Best Offers. A seller can decline multiple Best Offers with one call, but the seller cannot accept or counter offer multiple Best Offers with one call.
 * <br> <B>Input property:</B> <code>SellerResponse</code> - This optional text field allows the seller to provide more details to the buyer about the action being taken against the buyer's Best Offer.
 * <br>
 * <br> <B>Input property:</B> <code>CounterOfferPrice</code> - The seller inserts counter offer price into this field. This field is conditionally required and only applicable when the <b>Action</b> value is set to <code>Counter</code>, The counter offer price cannot exceed the Buy It Now price for a single quantity item. However, the dollar value in this field may exceed the Buy It Now price if the buyer is requesting or the seller is offering multiple quantity of the item (in a multiple-quantity listing). The quantity of the item must be specified in the <b>CounterOfferQuantity</b> field if the seller is making a counter offer.
 * <br> <B>Input property:</B> <code>CounterOfferQuantity</code> - The seller inserts the quantity of items in the counter offer into this field. This field is conditionally required and only applicable when the <b>Action</b> value is set to <code>Counter</code>, The counter offer price must be specified in the <b>CounterOfferPrice</b> field if the seller is making a counter offer. This price should reflect the quantity of items in the counter offer. So, if the seller's counter offer 'unit' price is 15 dollars, and the item quantity is '2', the dollar value passed into the <b>CounterOfferPrice</b> field would be <code>30.0</code>.
 * <br> <B>Output property:</B> <code>ReturnedBestOffers</code> - The <b>BestOffer.CallStatus</b> value returned in this container will indicate whether or not the action specified in the call request (accept, decline, or counter offer) was successful. The accept and counter offer actions can only be applied toward a single Best Offer. However, multiple Best Offers on a listing can be declined with one call. All Best Offers must be successfully declined with the <b>RespondToBestOffer</b> call for the <b> BestOffer.CallStatus</b> value to be <code>Success</code>.
 * 
 * @author Ron Murphy
 * @version 1.0
 */

public class RespondToBestOfferCall extends com.ebay.sdk.ApiCall
{
  
  private String itemID = null;
  private String[] bestOfferIDs = null;
  private BestOfferActionCodeType bestOfferAction = null;
  private String sellerResponse = null;
  private AmountType counterOfferPrice = null;
  private Integer counterOfferQuantity = null;
  private BestOfferType[] returnedBestOffers=null;


  /**
   * Constructor.
   */
  public RespondToBestOfferCall() {
  }

  /**
   * Constructor.
   * @param apiContext The ApiContext object to be used to make the call.
   */
  public RespondToBestOfferCall(ApiContext apiContext) {
    super(apiContext);
    

  }

  /**
   * This call enables the seller to accept or decline a buyer's Best Offer on an item, or make a counter offer to the buyer's Best Offer. A seller can decline multiple Best Offers with one call, but the seller cannot accept or counter offer multiple Best Offers with one call. Best Offers are not applicable to auction listings.
   * <br/><br/>
   * <span class="tablenote"><b>Note: </b>
   * Historically, the Best Offer feature has not been available for auction listings, but beginning with Version 1027, sellers in the US, UK, and DE sites are able to offer the Best Offer feature in auction listings. The seller can offer Buy It Now or Best Offer in an auction listing, but not both.
   * </span>
   * 
   * <br>
   * @throws ApiException
   * @throws SdkException
   * @throws Exception
   * @return The void object.
   */
  public void respondToBestOffer()
      throws com.ebay.sdk.ApiException, com.ebay.sdk.SdkException, java.lang.Exception
  {
    RespondToBestOfferRequestType req;
    req = new RespondToBestOfferRequestType();

    if( this.itemID == null )
      throw new Exception("ItemID property is not set.");
    if( this.bestOfferAction == null )
      throw new Exception("BestOfferAction property is not set.");
    if( this.bestOfferIDs == null || this.bestOfferIDs.length == 0 )
      throw new Exception("Please specify one or more BestOfferIDs.");

    if (this.itemID != null)
      req.setItemID(this.itemID);
    if (this.bestOfferIDs != null)
      req.setBestOfferID(this.bestOfferIDs);
    if (this.bestOfferAction != null)
      req.setAction(this.bestOfferAction);
    if (this.sellerResponse != null)
      req.setSellerResponse(this.sellerResponse);
    if (this.counterOfferPrice != null)
      req.setCounterOfferPrice(this.counterOfferPrice);
    if (this.counterOfferQuantity != null)
      req.setCounterOfferQuantity(this.counterOfferQuantity);

    RespondToBestOfferResponseType resp = (RespondToBestOfferResponseType) execute(req);

    this.returnedBestOffers = (resp.getRespondToBestOffer() == null? null: resp.getRespondToBestOffer().getBestOffer());

  }

  /**
   * Gets the RespondToBestOfferRequestType.bestOfferAction.
   * @return BestOfferActionCodeType
   */
  public BestOfferActionCodeType getBestOfferAction()
  {
    return this.bestOfferAction;
  }

  /**
   * Sets the RespondToBestOfferRequestType.bestOfferAction.
   * @param bestOfferAction BestOfferActionCodeType
   */
  public void setBestOfferAction(BestOfferActionCodeType bestOfferAction)
  {
    this.bestOfferAction = bestOfferAction;
  }

  /**
   * Gets the RespondToBestOfferRequestType.bestOfferIDs.
   * @return String[]
   */
  public String[] getBestOfferIDs()
  {
    return this.bestOfferIDs;
  }

  /**
   * Sets the RespondToBestOfferRequestType.bestOfferIDs.
   * @param bestOfferIDs String[]
   */
  public void setBestOfferIDs(String[] bestOfferIDs)
  {
    this.bestOfferIDs = bestOfferIDs;
  }

  /**
   * Gets the RespondToBestOfferRequestType.counterOfferPrice.
   * @return AmountType
   */
  public AmountType getCounterOfferPrice()
  {
    return this.counterOfferPrice;
  }

  /**
   * Sets the RespondToBestOfferRequestType.counterOfferPrice.
   * @param counterOfferPrice AmountType
   */
  public void setCounterOfferPrice(AmountType counterOfferPrice)
  {
    this.counterOfferPrice = counterOfferPrice;
  }

  /**
   * Gets the RespondToBestOfferRequestType.counterOfferQuantity.
   * @return Integer
   */
  public Integer getCounterOfferQuantity()
  {
    return this.counterOfferQuantity;
  }

  /**
   * Sets the RespondToBestOfferRequestType.counterOfferQuantity.
   * @param counterOfferQuantity Integer
   */
  public void setCounterOfferQuantity(Integer counterOfferQuantity)
  {
    this.counterOfferQuantity = counterOfferQuantity;
  }

  /**
   * Gets the RespondToBestOfferRequestType.itemID.
   * @return String
   */
  public String getItemID()
  {
    return this.itemID;
  }

  /**
   * Sets the RespondToBestOfferRequestType.itemID.
   * @param itemID String
   */
  public void setItemID(String itemID)
  {
    this.itemID = itemID;
  }

  /**
   * Gets the RespondToBestOfferRequestType.sellerResponse.
   * @return String
   */
  public String getSellerResponse()
  {
    return this.sellerResponse;
  }

  /**
   * Sets the RespondToBestOfferRequestType.sellerResponse.
   * @param sellerResponse String
   */
  public void setSellerResponse(String sellerResponse)
  {
    this.sellerResponse = sellerResponse;
  }

  /**
   * Valid after executing the API.
   * Gets the returned RespondToBestOfferResponseType.returnedBestOffers.
   * 
   * @return BestOfferType[]
   */
  public BestOfferType[] getReturnedBestOffers()
  {
    return this.returnedBestOffers;
  }

}

