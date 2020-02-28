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
 * Wrapper class of the SetUserPreferences call of eBay SOAP API.
 * <br>
 * <p>Title: SOAP API wrapper library.</p>
 * <p>Description: Contains wrapper classes for eBay SOAP APIs.</p>
 * <p>Copyright: Copyright (c) 2009</p>
 * <p>Company: eBay Inc.</p>
 * <br> <B>Input property:</B> <code>BidderNoticePreferences</code> - This container is included if the seller wishes to receive contact information for unsuccessful bidders. This preference is only applicable for auction listings.
 * <br> <B>Input property:</B> <code>CombinedPaymentPreferences</code> - This container is included if the seller wishes to set the preference for allowing Combined Invoice orders for cases where the buyer has multiple unpaid order line items from the same seller.
 * <br> <B>Input property:</B> <code>CrossPromotionPreferences</code> - This container is deprecated.
 * <br> <B>Input property:</B> <code>SellerPaymentPreferences</code> - This container is included if the seller wishes to set various payment preferences. One or more preferences may be set or modified under this container. Payment preferences specified in a <b>SetUserPreferences</b> call override the settings in My eBay payment preferences.
 * <br> <B>Input property:</B> <code>SellerFavoriteItemPreferences</code> - This container is included if the seller wishes to set preferences for displaying items on a buyer's Favorite Sellers' Items page or Favorite Sellers' Items digest. One or more preferences may be set or modified under this container.
 * <br> <B>Input property:</B> <code>EndOfAuctionEmailPreferences</code> - This container is included if the seller wishes to set preferences for the end-of-auction email sent to the winning bidder. These preferences allow the seller to customize the Email that is sent to buyer at the end of the auction. One or more preferences may be set or modified under this container. These preferences are only applicable for auction listings.
 * <br> <B>Input property:</B> <code>EmailShipmentTrackingNumberPreference</code> - This field is included and set to <code>true</code> if the seller wishes to email the shipment's tracking number to the buyer.
 * <br> <B>Input property:</B> <code>RequiredShipPhoneNumberPreference</code> - This field is included and set to <code>true</code> if the seller wishes to require the buyer to provide a shipping phone number upon checkout. Some shipping carriers require the receiver's phone number.
 * <br> <B>Input property:</B> <code>UnpaidItemAssistancePreferences</code> - This container is included if the seller wishes to set Unpaid Item Assistant preferences. The Unpaid Item Assistant automatically opens an Unpaid Item case on the behalf of the seller if the buyer has not paid for the order after a specified number of days. One or more preferences may be set or modified under this container.
 * <br> <B>Input property:</B> <code>PurchaseReminderEmailPreferences</code> - This container is included if the seller wishes to set the preference for sending a purchase reminder email to buyers.
 * <br> <B>Input property:</B> <code>SellerThirdPartyCheckoutDisabled</code> - This field is no longer applicable, as third-party checkout on eBay is no longer possible.
 * <br> <B>Input property:</B> <code>DispatchCutoffTimePreference</code> - This container is included if the seller wishes to set the order cut off time for same-day shipping. If the seller specifies a value of <code>0</code> in <strong>Item.DispatchTimeMax</strong> to offer same day handling when listing an item, the seller's shipping time commitment depends on the order cut off time set for the listing site, as indicated by the <strong>DispatchCutoffTimePreference.CutoffTime</strong> field.
 * <br>
 * <br>
 * <span class="tablenote"><b>Note:</b> This field is not applicable for sellers who have opted into the Handling Time Option of eBay Guaranteed Delivery, as this field only shows a single order cutoff time, but with the Handling Time Option, a seller can set a different order cutoff time for each business day. Currently, eBay Guaranteed Delivery is only available in the US.</span>
 * <br> <B>Input property:</B> <code>GlobalShippingProgramListingPreference</code> - If this flag is included and set to <code>true</code>, the seller's new listings will enable the Global Shipping Program by default.
 * <br/><br/>
 * <span class="tablenote">
 * <strong>Note:</strong> This field is ignored for sellers who are not opted in to the Global Shipping Program (when GetUserPreferences returns <strong>OfferGlobalShippingProgramPreference</strong> with a value of <code>false</code>).
 * </span>
 * <br> <B>Input property:</B> <code>OverrideGSPserviceWithIntlService</code> - If this flag is included and set to <code>true</code>, and the seller specifies an international shipping service to a particular country for a given listing, the specified service will take precedence and be the listing's default international shipping option for buyers in that country, rather than the Global Shipping Program. The Global Shipping Program will still be the listing's default option for shipping to any Global Shipping-eligible country for which the seller does <em>not</em> specify an international shipping service.
 * <br/><br/>
 * If this flag is set to <code>false</code>, the Global Shipping Program will be each Global Shipping-eligible listing's default option for shipping to any Global Shipping-eligible country, regardless of any international shipping service that the seller specifies for the listing.
 * <br> <B>Input property:</B> <code>OutOfStockControlPreference</code> - If this flag is included and set to <code>true</code>, it enables the Out-of-Stock feature. A seller would use this feature to keep Fixed-Price GTC (Good 'Til Canceled) listings alive even when the "quantity available" value goes to 0 (zero). This is useful when waiting for additional stock and eliminates the need to end the listing and then recreating it when stock arrives. <br/><br/>
 * While the "quantity available" value is 0, the listing would be hidden from eBay search and if that item was specifically searched for with <b>GetItem</b> (or related call), the element <b>HideFromSearch</b> would be returned as 'true' and <b>ReasonHideFromSearch</b> would be returned as 'OutOfStock'.
 * <br/><br/>
 * When stock is available, the seller can use the <b>Revise</b> calls to update the inventory of the item (through the <b>Item.Quantity</b> or <b>Item.Variations.Variation.Quantity</b> fields) and the listing would appear again.
 * <br/><br/>
 * You can return the value of this flag using the <a href="GetUserPreferences.html#Request.ShowOutOfStockControlPreference">GetUserPreferences</a> call and setting the <b>ShowOutOfStockControlPreference</b> field to 'true'. <br/><br/>
 * <span class="tablenote"><b>IMPORTANT: </b> When a listing using the Out-of-Stock feature has zero quantity, the seller has 90 days to add inventory without incurring a listing fee. Fees are changed at the end of each the billing cycle but are then refunded if the item is out-of-stock for an entire billing period. See <a href="../../../../guides/features-guide/default.html#development/Listings-UseOutOfStock.html#FeesForaListingWithZeroQuantity">Fees For a Listing With Zero Quantity</a> for details. </span>
 * 
 * @author Ron Murphy
 * @version 1.0
 */

public class SetUserPreferencesCall extends com.ebay.sdk.ApiCall
{
  
  private BidderNoticePreferencesType bidderNoticePreferences = null;
  private CombinedPaymentPreferencesType combinedPaymentPreferences = null;
  private CrossPromotionPreferencesType crossPromotionPreferences = null;
  private SellerPaymentPreferencesType sellerPaymentPreferences = null;
  private SellerFavoriteItemPreferencesType sellerFavoriteItemPreferences = null;
  private EndOfAuctionEmailPreferencesType endOfAuctionEmailPreferences = null;
  private Boolean emailShipmentTrackingNumberPreference = null;
  private Boolean requiredShipPhoneNumberPreference = null;
  private UnpaidItemAssistancePreferencesType unpaidItemAssistancePreferences = null;
  private PurchaseReminderEmailPreferencesType purchaseReminderEmailPreferences = null;
  private Boolean sellerThirdPartyCheckoutDisabled = null;
  private DispatchCutoffTimePreferencesType dispatchCutoffTimePreference = null;
  private Boolean globalShippingProgramListingPreference = null;
  private Boolean overrideGSPserviceWithIntlService = null;
  private Boolean outOfStockControlPreference = null;


  /**
   * Constructor.
   */
  public SetUserPreferencesCall() {
  }

  /**
   * Constructor.
   * @param apiContext The ApiContext object to be used to make the call.
   */
  public SetUserPreferencesCall(ApiContext apiContext) {
    super(apiContext);
    

  }

  /**
   * This call allows an eBay user to set/modify numerous seller account preferences.
   * 
   * <br>
   * @throws ApiException
   * @throws SdkException
   * @throws Exception
   * @return The void object.
   */
  public void setUserPreferences()
      throws com.ebay.sdk.ApiException, com.ebay.sdk.SdkException, java.lang.Exception
  {
    SetUserPreferencesRequestType req;
    req = new SetUserPreferencesRequestType();
    if (this.bidderNoticePreferences != null)
      req.setBidderNoticePreferences(this.bidderNoticePreferences);
    if (this.combinedPaymentPreferences != null)
      req.setCombinedPaymentPreferences(this.combinedPaymentPreferences);
    if (this.crossPromotionPreferences != null)
      req.setCrossPromotionPreferences(this.crossPromotionPreferences);
    if (this.sellerPaymentPreferences != null)
      req.setSellerPaymentPreferences(this.sellerPaymentPreferences);
    if (this.sellerFavoriteItemPreferences != null)
      req.setSellerFavoriteItemPreferences(this.sellerFavoriteItemPreferences);
    if (this.endOfAuctionEmailPreferences != null)
      req.setEndOfAuctionEmailPreferences(this.endOfAuctionEmailPreferences);
    if (this.emailShipmentTrackingNumberPreference != null)
      req.setEmailShipmentTrackingNumberPreference(this.emailShipmentTrackingNumberPreference);
    if (this.requiredShipPhoneNumberPreference != null)
      req.setRequiredShipPhoneNumberPreference(this.requiredShipPhoneNumberPreference);
    if (this.unpaidItemAssistancePreferences != null)
      req.setUnpaidItemAssistancePreferences(this.unpaidItemAssistancePreferences);
    if (this.purchaseReminderEmailPreferences != null)
      req.setPurchaseReminderEmailPreferences(this.purchaseReminderEmailPreferences);
    if (this.sellerThirdPartyCheckoutDisabled != null)
      req.setSellerThirdPartyCheckoutDisabled(this.sellerThirdPartyCheckoutDisabled);
    if (this.dispatchCutoffTimePreference != null)
      req.setDispatchCutoffTimePreference(this.dispatchCutoffTimePreference);
    if (this.globalShippingProgramListingPreference != null)
      req.setGlobalShippingProgramListingPreference(this.globalShippingProgramListingPreference);
    if (this.overrideGSPserviceWithIntlService != null)
      req.setOverrideGSPserviceWithIntlService(this.overrideGSPserviceWithIntlService);
    if (this.outOfStockControlPreference != null)
      req.setOutOfStockControlPreference(this.outOfStockControlPreference);

    SetUserPreferencesResponseType resp = (SetUserPreferencesResponseType) execute(req);


  }

  /**
   * Gets the SetUserPreferencesRequestType.bidderNoticePreferences.
   * @return BidderNoticePreferencesType
   */
  public BidderNoticePreferencesType getBidderNoticePreferences()
  {
    return this.bidderNoticePreferences;
  }

  /**
   * Sets the SetUserPreferencesRequestType.bidderNoticePreferences.
   * @param bidderNoticePreferences BidderNoticePreferencesType
   */
  public void setBidderNoticePreferences(BidderNoticePreferencesType bidderNoticePreferences)
  {
    this.bidderNoticePreferences = bidderNoticePreferences;
  }

  /**
   * Gets the SetUserPreferencesRequestType.combinedPaymentPreferences.
   * @return CombinedPaymentPreferencesType
   */
  public CombinedPaymentPreferencesType getCombinedPaymentPreferences()
  {
    return this.combinedPaymentPreferences;
  }

  /**
   * Sets the SetUserPreferencesRequestType.combinedPaymentPreferences.
   * @param combinedPaymentPreferences CombinedPaymentPreferencesType
   */
  public void setCombinedPaymentPreferences(CombinedPaymentPreferencesType combinedPaymentPreferences)
  {
    this.combinedPaymentPreferences = combinedPaymentPreferences;
  }

  /**
   * Gets the SetUserPreferencesRequestType.crossPromotionPreferences.
   * @return CrossPromotionPreferencesType
   */
  public CrossPromotionPreferencesType getCrossPromotionPreferences()
  {
    return this.crossPromotionPreferences;
  }

  /**
   * Sets the SetUserPreferencesRequestType.crossPromotionPreferences.
   * @param crossPromotionPreferences CrossPromotionPreferencesType
   */
  public void setCrossPromotionPreferences(CrossPromotionPreferencesType crossPromotionPreferences)
  {
    this.crossPromotionPreferences = crossPromotionPreferences;
  }

  /**
   * Gets the SetUserPreferencesRequestType.dispatchCutoffTimePreference.
   * @return DispatchCutoffTimePreferencesType
   */
  public DispatchCutoffTimePreferencesType getDispatchCutoffTimePreference()
  {
    return this.dispatchCutoffTimePreference;
  }

  /**
   * Sets the SetUserPreferencesRequestType.dispatchCutoffTimePreference.
   * @param dispatchCutoffTimePreference DispatchCutoffTimePreferencesType
   */
  public void setDispatchCutoffTimePreference(DispatchCutoffTimePreferencesType dispatchCutoffTimePreference)
  {
    this.dispatchCutoffTimePreference = dispatchCutoffTimePreference;
  }

  /**
   * Gets the SetUserPreferencesRequestType.emailShipmentTrackingNumberPreference.
   * @return Boolean
   */
  public Boolean getEmailShipmentTrackingNumberPreference()
  {
    return this.emailShipmentTrackingNumberPreference;
  }

  /**
   * Sets the SetUserPreferencesRequestType.emailShipmentTrackingNumberPreference.
   * @param emailShipmentTrackingNumberPreference Boolean
   */
  public void setEmailShipmentTrackingNumberPreference(Boolean emailShipmentTrackingNumberPreference)
  {
    this.emailShipmentTrackingNumberPreference = emailShipmentTrackingNumberPreference;
  }

  /**
   * Gets the SetUserPreferencesRequestType.endOfAuctionEmailPreferences.
   * @return EndOfAuctionEmailPreferencesType
   */
  public EndOfAuctionEmailPreferencesType getEndOfAuctionEmailPreferences()
  {
    return this.endOfAuctionEmailPreferences;
  }

  /**
   * Sets the SetUserPreferencesRequestType.endOfAuctionEmailPreferences.
   * @param endOfAuctionEmailPreferences EndOfAuctionEmailPreferencesType
   */
  public void setEndOfAuctionEmailPreferences(EndOfAuctionEmailPreferencesType endOfAuctionEmailPreferences)
  {
    this.endOfAuctionEmailPreferences = endOfAuctionEmailPreferences;
  }

  /**
   * Gets the SetUserPreferencesRequestType.globalShippingProgramListingPreference.
   * @return Boolean
   */
  public Boolean getGlobalShippingProgramListingPreference()
  {
    return this.globalShippingProgramListingPreference;
  }

  /**
   * Sets the SetUserPreferencesRequestType.globalShippingProgramListingPreference.
   * @param globalShippingProgramListingPreference Boolean
   */
  public void setGlobalShippingProgramListingPreference(Boolean globalShippingProgramListingPreference)
  {
    this.globalShippingProgramListingPreference = globalShippingProgramListingPreference;
  }

  /**
   * Gets the SetUserPreferencesRequestType.outOfStockControlPreference.
   * @return Boolean
   */
  public Boolean getOutOfStockControlPreference()
  {
    return this.outOfStockControlPreference;
  }

  /**
   * Sets the SetUserPreferencesRequestType.outOfStockControlPreference.
   * @param outOfStockControlPreference Boolean
   */
  public void setOutOfStockControlPreference(Boolean outOfStockControlPreference)
  {
    this.outOfStockControlPreference = outOfStockControlPreference;
  }

  /**
   * Gets the SetUserPreferencesRequestType.overrideGSPserviceWithIntlService.
   * @return Boolean
   */
  public Boolean getOverrideGSPserviceWithIntlService()
  {
    return this.overrideGSPserviceWithIntlService;
  }

  /**
   * Sets the SetUserPreferencesRequestType.overrideGSPserviceWithIntlService.
   * @param overrideGSPserviceWithIntlService Boolean
   */
  public void setOverrideGSPserviceWithIntlService(Boolean overrideGSPserviceWithIntlService)
  {
    this.overrideGSPserviceWithIntlService = overrideGSPserviceWithIntlService;
  }

  /**
   * Gets the SetUserPreferencesRequestType.purchaseReminderEmailPreferences.
   * @return PurchaseReminderEmailPreferencesType
   */
  public PurchaseReminderEmailPreferencesType getPurchaseReminderEmailPreferences()
  {
    return this.purchaseReminderEmailPreferences;
  }

  /**
   * Sets the SetUserPreferencesRequestType.purchaseReminderEmailPreferences.
   * @param purchaseReminderEmailPreferences PurchaseReminderEmailPreferencesType
   */
  public void setPurchaseReminderEmailPreferences(PurchaseReminderEmailPreferencesType purchaseReminderEmailPreferences)
  {
    this.purchaseReminderEmailPreferences = purchaseReminderEmailPreferences;
  }

  /**
   * Gets the SetUserPreferencesRequestType.requiredShipPhoneNumberPreference.
   * @return Boolean
   */
  public Boolean getRequiredShipPhoneNumberPreference()
  {
    return this.requiredShipPhoneNumberPreference;
  }

  /**
   * Sets the SetUserPreferencesRequestType.requiredShipPhoneNumberPreference.
   * @param requiredShipPhoneNumberPreference Boolean
   */
  public void setRequiredShipPhoneNumberPreference(Boolean requiredShipPhoneNumberPreference)
  {
    this.requiredShipPhoneNumberPreference = requiredShipPhoneNumberPreference;
  }

  /**
   * Gets the SetUserPreferencesRequestType.sellerFavoriteItemPreferences.
   * @return SellerFavoriteItemPreferencesType
   */
  public SellerFavoriteItemPreferencesType getSellerFavoriteItemPreferences()
  {
    return this.sellerFavoriteItemPreferences;
  }

  /**
   * Sets the SetUserPreferencesRequestType.sellerFavoriteItemPreferences.
   * @param sellerFavoriteItemPreferences SellerFavoriteItemPreferencesType
   */
  public void setSellerFavoriteItemPreferences(SellerFavoriteItemPreferencesType sellerFavoriteItemPreferences)
  {
    this.sellerFavoriteItemPreferences = sellerFavoriteItemPreferences;
  }

  /**
   * Gets the SetUserPreferencesRequestType.sellerPaymentPreferences.
   * @return SellerPaymentPreferencesType
   */
  public SellerPaymentPreferencesType getSellerPaymentPreferences()
  {
    return this.sellerPaymentPreferences;
  }

  /**
   * Sets the SetUserPreferencesRequestType.sellerPaymentPreferences.
   * @param sellerPaymentPreferences SellerPaymentPreferencesType
   */
  public void setSellerPaymentPreferences(SellerPaymentPreferencesType sellerPaymentPreferences)
  {
    this.sellerPaymentPreferences = sellerPaymentPreferences;
  }

  /**
   * Gets the SetUserPreferencesRequestType.sellerThirdPartyCheckoutDisabled.
   * @return Boolean
   */
  public Boolean getSellerThirdPartyCheckoutDisabled()
  {
    return this.sellerThirdPartyCheckoutDisabled;
  }

  /**
   * Sets the SetUserPreferencesRequestType.sellerThirdPartyCheckoutDisabled.
   * @param sellerThirdPartyCheckoutDisabled Boolean
   */
  public void setSellerThirdPartyCheckoutDisabled(Boolean sellerThirdPartyCheckoutDisabled)
  {
    this.sellerThirdPartyCheckoutDisabled = sellerThirdPartyCheckoutDisabled;
  }

  /**
   * Gets the SetUserPreferencesRequestType.unpaidItemAssistancePreferences.
   * @return UnpaidItemAssistancePreferencesType
   */
  public UnpaidItemAssistancePreferencesType getUnpaidItemAssistancePreferences()
  {
    return this.unpaidItemAssistancePreferences;
  }

  /**
   * Sets the SetUserPreferencesRequestType.unpaidItemAssistancePreferences.
   * @param unpaidItemAssistancePreferences UnpaidItemAssistancePreferencesType
   */
  public void setUnpaidItemAssistancePreferences(UnpaidItemAssistancePreferencesType unpaidItemAssistancePreferences)
  {
    this.unpaidItemAssistancePreferences = unpaidItemAssistancePreferences;
  }

}

