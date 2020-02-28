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
import java.lang.String;

import com.ebay.sdk.*;
import com.ebay.soap.eBLBaseComponents.*;
/**
 * Wrapper class of the PlaceOffer call of eBay SOAP API.
 * <br>
 * <p>Title: SOAP API wrapper library.</p>
 * <p>Description: Contains wrapper classes for eBay SOAP APIs.</p>
 * <p>Copyright: Copyright (c) 2009</p>
 * <p>Company: eBay Inc.</p>
 * <br> <B>Input property:</B> <code>Offer</code> - This container specifies the type of offer being made for the listing specified in the <b>ItemID</b> field. The <b>Offer.Action</b> is used to set the action that is being taken on the listing.
 * <br> <B>Input property:</B> <code>ItemID</code> - Unique identifier that identifies the listing for which the action is being submitted.
 * <br><br>
 * For a multiple-variation listing, you must also identify the specific variation within that listing using the <b>VariationSpecifics</b> container.
 * <br> <B>Input property:</B> <code>BlockOnWarning</code> - If a warning message is generated when the call is made, this <b>BlockOnWarning</b> will block the bid/buy action if set to <code>true</code>. If <b>BlockOnWarning</b>
 * is <code>false</code> or omitted, the bid/buy action is allowed, regardless of whether or not a warning message occurs.
 * <br>
 * <br> <B>Input property:</B> <code>AffiliateTrackingDetails</code> - Container for affiliate-related tags, which enable the tracking of user
 * activity. If you include the <b>AffiliateTrackingDetails</b> container in your <b>PlaceOffer</b> call, then
 * it is possible to receive affiliate commissions based on calls made by your
 * application. (See the <a href=
 * "http://www.ebaypartnernetwork.com/" target="_blank">eBay Partner Network</a>
 * for information about commissions.) Please note that affiliate tracking is not
 * available in the Sandbox environment, and that affiliate tracking is not
 * available when you make a Best Offer.
 * <br> <B>Input property:</B> <code>VariationSpecifics</code> - This container is used to identify a specific variation within a multiple-variation listing identified by the <b>ItemID</b> value. This container is required when attempting to perform an action on a multiple-variation listing.
 * <br> <B>Output property:</B> <code>ReturnedSellingStatus</code> - This container indicates the current bidding/purchase state of the order line item regarding the offer extended using <b>PlaceOffer</b>. The fields that are returned under this container will depend on the attempted action and the results of that action.
 * <br> <B>Output property:</B> <code>ReturnedTransactionID</code> - Unique identifier for an eBay order line item. The
 * <b>TransactionID</b> field is only returned if the <b>Offer.Action</b> field was set
 * to <b>Purchase</b> in the input and the purchase was successful. A Purchase
 * action in <b>PlaceOffer</b> can be used for a fixed-price listing, or for an
 * auction listing where the Buy It Now option is available.
 * <br> <B>Output property:</B> <code>ReturnedBestOffer</code> - Container consisting of the status for a Best Offer. This container is
 * only returned if applicable based on the listing and the value set for
 * <b>Offer.Action</b> field in the request.
 * <br> <B>Output property:</B> <code>ReturnedOrderLineItemID</code> - <b>OrderLineItemID</b> is a unique identifier for an eBay order line item. The <b>OrderLineItemID</b> field is only
 * returned if the <b>Offer.Action</b> field is set to <b>Purchase</b> in the input and
 * the purchase is successful. A Purchase action in <b>PlaceOffer</b> can be used
 * for a fixed-price listing, or for an auction listing where the Buy It
 * Now option is available.
 * <br>
 * 
 * @author Ron Murphy
 * @version 1.0
 */

public class PlaceOfferCall extends com.ebay.sdk.ApiCall
{
  
  private OfferType offer = null;
  private String itemID = null;
  private Boolean blockOnWarning = null;
  private AffiliateTrackingDetailsType affiliateTrackingDetails = null;
  private NameValueListArrayType variationSpecifics = null;
  private SellingStatusType returnedSellingStatus=null;
  private String returnedTransactionID=null;
  private BestOfferType returnedBestOffer=null;
  private String returnedOrderLineItemID=null;


  /**
   * Constructor.
   */
  public PlaceOfferCall() {
  }

  /**
   * Constructor.
   * @param apiContext The ApiContext object to be used to make the call.
   */
  public PlaceOfferCall(ApiContext apiContext) {
    super(apiContext);
    

  }

  /**
   * Enables the authenticated user to to make a bid on an auction item, propose a Best Offer, or purchase a fixed-price/Buy It Now item. Note that this call cannot be used to purchase items that require immediate payment.
   * 
   * <br>
   * @throws ApiException
   * @throws SdkException
   * @throws Exception
   * @return The SellingStatusType object.
   */
  public SellingStatusType placeOffer()
      throws com.ebay.sdk.ApiException, com.ebay.sdk.SdkException, java.lang.Exception
  {
    PlaceOfferRequestType req;
    req = new PlaceOfferRequestType();
    if (this.offer != null)
      req.setOffer(this.offer);
    if (this.itemID != null)
      req.setItemID(this.itemID);
    if (this.blockOnWarning != null)
      req.setBlockOnWarning(this.blockOnWarning);
    if (this.affiliateTrackingDetails != null)
      req.setAffiliateTrackingDetails(this.affiliateTrackingDetails);
    if (this.variationSpecifics != null)
      req.setVariationSpecifics(this.variationSpecifics);

    PlaceOfferResponseType resp = (PlaceOfferResponseType) execute(req);

    this.returnedSellingStatus = resp.getSellingStatus();
    this.returnedTransactionID = resp.getTransactionID();
    this.returnedBestOffer = resp.getBestOffer();
    this.returnedOrderLineItemID = resp.getOrderLineItemID();
    return this.getReturnedSellingStatus();
  }

  /**
   * Gets the PlaceOfferRequestType.affiliateTrackingDetails.
   * @return AffiliateTrackingDetailsType
   */
  public AffiliateTrackingDetailsType getAffiliateTrackingDetails()
  {
    return this.affiliateTrackingDetails;
  }

  /**
   * Sets the PlaceOfferRequestType.affiliateTrackingDetails.
   * @param affiliateTrackingDetails AffiliateTrackingDetailsType
   */
  public void setAffiliateTrackingDetails(AffiliateTrackingDetailsType affiliateTrackingDetails)
  {
    this.affiliateTrackingDetails = affiliateTrackingDetails;
  }

  /**
   * Gets the PlaceOfferRequestType.blockOnWarning.
   * @return Boolean
   */
  public Boolean getBlockOnWarning()
  {
    return this.blockOnWarning;
  }

  /**
   * Sets the PlaceOfferRequestType.blockOnWarning.
   * @param blockOnWarning Boolean
   */
  public void setBlockOnWarning(Boolean blockOnWarning)
  {
    this.blockOnWarning = blockOnWarning;
  }

  /**
   * Gets the PlaceOfferRequestType.itemID.
   * @return String
   */
  public String getItemID()
  {
    return this.itemID;
  }

  /**
   * Sets the PlaceOfferRequestType.itemID.
   * @param itemID String
   */
  public void setItemID(String itemID)
  {
    this.itemID = itemID;
  }

  /**
   * Gets the PlaceOfferRequestType.offer.
   * @return OfferType
   */
  public OfferType getOffer()
  {
    return this.offer;
  }

  /**
   * Sets the PlaceOfferRequestType.offer.
   * @param offer OfferType
   */
  public void setOffer(OfferType offer)
  {
    this.offer = offer;
  }

  /**
   * Gets the PlaceOfferRequestType.variationSpecifics.
   * @return NameValueListArrayType
   */
  public NameValueListArrayType getVariationSpecifics()
  {
    return this.variationSpecifics;
  }

  /**
   * Sets the PlaceOfferRequestType.variationSpecifics.
   * @param variationSpecifics NameValueListArrayType
   */
  public void setVariationSpecifics(NameValueListArrayType variationSpecifics)
  {
    this.variationSpecifics = variationSpecifics;
  }

  /**
   * Valid after executing the API.
   * Gets the returned PlaceOfferResponseType.returnedBestOffer.
   * 
   * @return BestOfferType
   */
  public BestOfferType getReturnedBestOffer()
  {
    return this.returnedBestOffer;
  }

  /**
   * Valid after executing the API.
   * Gets the returned PlaceOfferResponseType.returnedOrderLineItemID.
   * 
   * @return String
   */
  public String getReturnedOrderLineItemID()
  {
    return this.returnedOrderLineItemID;
  }

  /**
   * Valid after executing the API.
   * Gets the returned PlaceOfferResponseType.returnedSellingStatus.
   * 
   * @return SellingStatusType
   */
  public SellingStatusType getReturnedSellingStatus()
  {
    return this.returnedSellingStatus;
  }

  /**
   * Valid after executing the API.
   * Gets the returned PlaceOfferResponseType.returnedTransactionID.
   * 
   * @return String
   */
  public String getReturnedTransactionID()
  {
    return this.returnedTransactionID;
  }

}

