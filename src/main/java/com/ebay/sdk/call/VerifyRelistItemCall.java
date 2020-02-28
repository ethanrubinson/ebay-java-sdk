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
 * Wrapper class of the VerifyRelistItem call of eBay SOAP API.
 * <br>
 * <p>Title: SOAP API wrapper library.</p>
 * <p>Description: Contains wrapper classes for eBay SOAP APIs.</p>
 * <p>Copyright: Copyright (c) 2009</p>
 * <p>Company: eBay Inc.</p>
 * <br> <B>Input property:</B> <code>Item</code> - The <b>Item</b> container is used to configure the item that will be relisted. If the seller plans to relist the item with no changes, the only field under the <b>Item</b> container that is required is the <b>ItemID</b> field. In the <b>ItemID</b> field, the seller specifies the item that will be relisted. If the seller wishes to change anything else for the listing, the seller should include this field in the call request and give it a new value.
 * <br/><br/>
 * If the seller wants to delete one or more optional settings in the listing, the seller should use the <b>DeletedField</b> tag.
 * <br> <B>Input property:</B> <code>DeletedField</code> - Specifies the name of the field to delete from a listing. See the eBay Features Guide for rules on deleting values when relisting items. Also see the relevant field descriptions to determine when to use <b>DeletedField</b> (and potential consequences).
 * The request can contain zero, one, or many instances of <b>DeletedField</b> (one for each field to be deleted).
 * <br><br>
 * Case-sensitivity must be taken into account when using a <b>DeletedField</b> tag to delete a field. The value passed into a <b>DeletedField</b> tag must either match the case of the schema element names in the full field path (Item.PictureDetails.GalleryURL), or the initial letter of each schema element name in the full field path must be  lowercase (item.pictureDetails.galleryURL).
 * Do not change the case of letters in the middle of a field name.
 * For example, item.picturedetails.galleryUrl is not allowed.<br><br>
 * To delete a listing enhancement like 'BoldTitle', specify the value you are deleting;
 * for example, Item.ListingEnhancement[BoldTitle].
 * <br> <B>Output property:</B> <code>ReturnedItemID</code> - With a successful <b>VerifyRelistItem</b> call, this field is always returned, but the returned value is always <code>0</code>, since this call only validates the data passed in through the request payload and does not actually relist an item.
 * <br> <B>Output property:</B> <code>ReturnedFees</code> - This container consists of the estimated listing fees for the item that is to be relisted. Each type of fee is returned even if it is not appplicable (has a value of <code>0.0</code>. The Final Value Fee (FVF) is not in this container, as this value cannot be determined until a sale is made.
 * <br> <B>Output property:</B> <code>ReturnedStartTime</code> - This timestamp indicates the date and time when the item to be relisted became active on the eBay site.
 * <br> <B>Output property:</B> <code>ReturnedEndTime</code> - This timestamp indicates the date and time when the item to be relisted is scheduled to end on the eBay site. This date/time is calculated by using the <b>StartTime</b> and the the listing duration.
 * <br><br>
 * <span class="tablenote"><b>Note: </b>
 * Starting July 1, 2019, the Good 'Til Cancelled renewal schedule will be modified from every 30 days to once per calendar month. For example, if a GTC listing is created July 5, the next monthly renewal date will be August 5. If a GTC listing is created on the 31st of the month, but the following month only has 30 days, the renewal will happen on the 30th in the following month. Finally, if a GTC listing is created on January 29-31, the renewal will happen on February 28th (or 29th during a 'Leap Year'). See the
 * <a href="https://pages.ebay.com/seller-center/seller-updates/2019-spring/marketplace-updates.html#good-til-cancelled" target="_blank">Good 'Til Cancelled listings update</a> in the <b>Spring 2019 Seller Updates</b> for more information about this change.
 * </span>
 * <br> <B>Output property:</B> <code>ReturnedDiscountReason</code> - This field is returned if an eBay special offer or promotion is applicable to the listing.
 * <br> <B>Output property:</B> <code>ReturnedProductSuggestions</code> - Provides a list of products recommended by eBay which match the item information provided by the seller.
 * <br> <B>Output property:</B> <code>ReturnedListingRecommendations</code> - Container consisting of one or more <b>Recommendation</b> containers. Each <b>Recommendation</b> container provides a message to the seller on how a listing can be improved or brought up to standard in regards to top-rated seller/listing requirements, mandated or recommended Item Specifics, picture quality requirements, pricing and/or listing format recommendations, recommended keywords and/or Item Specifics in a Title, and/or a recommendation to offer fast handling (same-day handling or handling time of 1 day) and/or a free shipping option in order to qualify the listing for a Fast 'N Free badge.
 * <br><br>
 * This container is only returned if the <b>IncludeRecommendations</b> flag was included and set to 'true' in the <b>VerifyRelistItem</b> request, and if at least one listing recommendation exists for the item about to be relisted. If one or more listing recommendations are returned, it will be at the seller's discretion about whether to revise the item based on eBay's listing recommendation(s) before actually relisting the item through a <b>RelistItem</b> call.
 * 
 * @author Ron Murphy
 * @version 1.0
 */

public class VerifyRelistItemCall extends com.ebay.sdk.ApiCall
{
  
  private ItemType item = null;
  private String[] deletedField = null;
  private String returnedItemID=null;
  private FeesType returnedFees=null;
  private Calendar returnedStartTime=null;
  private Calendar returnedEndTime=null;
  private DiscountReasonCodeType[] returnedDiscountReason=null;
  private ProductSuggestionsType returnedProductSuggestions=null;
  private ListingRecommendationsType returnedListingRecommendations=null;


  /**
   * Constructor.
   */
  public VerifyRelistItemCall() {
  }

  /**
   * Constructor.
   * @param apiContext The ApiContext object to be used to make the call.
   */
  public VerifyRelistItemCall(ApiContext apiContext) {
    super(apiContext);
    

  }

  /**
   * Enable the seller to verify that the data they plan to pass into a <b>RelistItem</b> call will produce the results that you are expecting, including a successful call with no errors.
   * 
   * <br>
   * @throws ApiException
   * @throws SdkException
   * @throws Exception
   * @return The String object.
   */
  public String verifyRelistItem()
      throws com.ebay.sdk.ApiException, com.ebay.sdk.SdkException, java.lang.Exception
  {
    VerifyRelistItemRequestType req;
    req = new VerifyRelistItemRequestType();
    if (this.item != null)
      req.setItem(this.item);
    if (this.deletedField != null)
      req.setDeletedField(this.deletedField);

    VerifyRelistItemResponseType resp = (VerifyRelistItemResponseType) execute(req);

    this.returnedItemID = resp.getItemID();
    this.returnedFees = resp.getFees();
    this.returnedStartTime = resp.getStartTime();
    this.returnedEndTime = resp.getEndTime();
    this.returnedDiscountReason = resp.getDiscountReason();
    this.returnedProductSuggestions = resp.getProductSuggestions();
    this.returnedListingRecommendations = resp.getListingRecommendations();
    return this.getReturnedItemID();
  }

  /**
   * Gets the VerifyRelistItemRequestType.deletedField.
   * @return String[]
   */
  public String[] getDeletedField()
  {
    return this.deletedField;
  }

  /**
   * Sets the VerifyRelistItemRequestType.deletedField.
   * @param deletedField String[]
   */
  public void setDeletedField(String[] deletedField)
  {
    this.deletedField = deletedField;
  }

  /**
   * Gets the VerifyRelistItemRequestType.item.
   * @return ItemType
   */
  public ItemType getItem()
  {
    return this.item;
  }

  /**
   * Sets the VerifyRelistItemRequestType.item.
   * @param item ItemType
   */
  public void setItem(ItemType item)
  {
    this.item = item;
  }

  /**
   * Valid after executing the API.
   * Gets the returned VerifyRelistItemResponseType.returnedDiscountReason.
   * 
   * @return DiscountReasonCodeType[]
   */
  public DiscountReasonCodeType[] getReturnedDiscountReason()
  {
    return this.returnedDiscountReason;
  }

  /**
   * Valid after executing the API.
   * Gets the returned VerifyRelistItemResponseType.returnedEndTime.
   * 
   * @return Calendar
   */
  public Calendar getReturnedEndTime()
  {
    return this.returnedEndTime;
  }

  /**
   * Valid after executing the API.
   * Gets the returned VerifyRelistItemResponseType.returnedFees.
   * 
   * @return FeesType
   */
  public FeesType getReturnedFees()
  {
    return this.returnedFees;
  }

  /**
   * Valid after executing the API.
   * Gets the returned VerifyRelistItemResponseType.returnedItemID.
   * 
   * @return String
   */
  public String getReturnedItemID()
  {
    return this.returnedItemID;
  }

  /**
   * Valid after executing the API.
   * Gets the returned VerifyRelistItemResponseType.returnedListingRecommendations.
   * 
   * @return ListingRecommendationsType
   */
  public ListingRecommendationsType getReturnedListingRecommendations()
  {
    return this.returnedListingRecommendations;
  }

  /**
   * Valid after executing the API.
   * Gets the returned VerifyRelistItemResponseType.returnedProductSuggestions.
   * 
   * @return ProductSuggestionsType
   */
  public ProductSuggestionsType getReturnedProductSuggestions()
  {
    return this.returnedProductSuggestions;
  }

  /**
   * Valid after executing the API.
   * Gets the returned VerifyRelistItemResponseType.returnedStartTime.
   * 
   * @return Calendar
   */
  public Calendar getReturnedStartTime()
  {
    return this.returnedStartTime;
  }

}

