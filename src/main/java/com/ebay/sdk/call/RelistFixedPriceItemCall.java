/*
Copyright (c) 2013 eBay, Inc.
This program is licensed under the terms of the eBay Common Development and
Distribution License (CDDL) Version 1.0 (the "License") and any subsequent  version 
thereof released by eBay.  The then-current version of the License can be found 
at http://www.opensource.org/licenses/cddl1.php and in the eBaySDKLicense file that 
is under the eBay SDK ../docs directory.
*/

package com.ebay.sdk.call;

import com.ebay.sdk.pictureservice.*;
import com.ebay.sdk.pictureservice.eps.*;
import java.lang.String;
import java.util.Calendar;

import com.ebay.sdk.*;
import com.ebay.soap.eBLBaseComponents.*;
/**
 * Wrapper class of the RelistFixedPriceItem call of eBay SOAP API.
 * <br>
 * <p>Title: SOAP API wrapper library.</p>
 * <p>Description: Contains wrapper classes for eBay SOAP APIs.</p>
 * <p>Copyright: Copyright (c) 2009</p>
 * <p>Company: eBay Inc.</p>
 * <br> <B>Input property:</B> <code>ItemToBeRelisted</code> - The <b>Item</b> container is used to configure the item that will be relisted. If the seller plans to relist the item with no changes, the only field under the <b>Item</b> container that is required is the <b>ItemID</b> field. In the <b>ItemID</b> field, the seller specifies the item that will be relisted. If the seller wishes to change anything else for the listing, the seller should include this field in the call request and give it a new value.
 * <br/><br/>
 * If the seller wants to delete one or more optional settings in the listing, the seller should use the <b>DeletedField</b> tag.
 * <br> <B>Input property:</B> <code>DeletedField</code> - Specifies the name of the field to delete from a listing.
 * See <a href="http://developer.ebay.com/Devzone/guides/features-guide/default.html#development/Listings-RelistingItems.html">Relisting Items</a> for rules on deleting values when relisting items.
 * Also see the relevant field descriptions to determine when to use <b>DeletedField</b> (and potential consequences).
 * The request can contain zero, one, or many instances of <b>DeletedField</b> (one for each field to be deleted).
 * <br>
 * <br>
 * Some data (such as <b>Variation</b> nodes within <b>Variations</b>)
 * can't be deleted by using a <b>DeletedField</b> tag. See the relevant field
 * descriptions for how to delete such data.
 * <br>
 * <br>
 * Case-sensitivity must be taken into account when using a <b>DeletedField</b> tag to delete a field. The value passed into a <b>DeletedField</b> tag must either match the case of the schema element names in the full field path (Item.PictureDetails.GalleryURL), or the initial letter of each schema element name in the full field path must be lowercase (item.pictureDetails.galleryURL).
 * Do not change the case of letters in the middle of a field name.
 * For example, item.picturedetails.galleryUrl is not allowed.<br><br>
 * To delete a listing enhancement like 'BoldTitle', specify the value you are deleting;
 * for example, Item.ListingEnhancement[BoldTitle].
 * <br> <B>Output property:</B> <code>ReturnedItemID</code> - The unique identifier for the relisted item. Note that the <b>ItemID</b> value changes when a listing is relisted, so this will not be the same <b>ItemID</b> value that was passed in the call request.
 * <br/><br/>
 * <br> <B>Output property:</B> <code>ReturnedSKU</code> - The seller-defined SKU value for the new listing (if a SKU value exists for the item).
 * <br/><br/>
 * Note that variation-level SKU values will not be returned if a multiple-variation listing was relisted. The seller would have to make a <b>GetItem</b> call to get variation-level SKU values.
 * <br> <B>Output property:</B> <code>ListingFees</code> - This container consists of the estimated listing fees for the relisted item. Each type of fee is returned even if it is not appplicable (has a value of <code>0.0</code>. The Final Value Fee (FVF) is not in this container, as this value cannot be determined until a sale is made.
 * <br> <B>Output property:</B> <code>ReturnedStartTime</code> - This timestamp indicates the date and time when the relisted item became active on the eBay site.
 * <br> <B>Output property:</B> <code>ReturnedEndTime</code> - Date and time when the relisted item is scheduled to end based on the start time and the listing duration value that was set in the <b>ListingDuration</b> field. If the value of <b>ListingDuration</b> was set to <code>GTC</code> (Good 'Til Cancelled), this value will be set 30 days ahead of the start time, although this value will be updated if the GTC listing is still alive and automatically renewed 30 days after start time.
 * <br><br>
 * <span class="tablenote"><b>Note: </b>
 * Starting July 1, 2019, the Good 'Til Cancelled renewal schedule will be modified from every 30 days to once per calendar month. For example, if a GTC listing is created July 5, the next monthly renewal date will be August 5. If a GTC listing is created on the 31st of the month, but the following month only has 30 days, the renewal will happen on the 30th in the following month. Finally, if a GTC listing is created on January 29-31, the renewal will happen on February 28th (or 29th during a 'Leap Year'). See the
 * <a href="https://pages.ebay.com/seller-center/seller-updates/2019-spring/marketplace-updates.html#good-til-cancelled" target="_blank">Good 'Til Cancelled listings update</a> in the <b>Spring 2019 Seller Updates</b> for more information about this change.
 * </span>
 * <br> <B>Output property:</B> <code>ReturnedCategoryID</code> - Unique identifier of the primary eBay category in which the item was relisted. This field is only returned if the <b>Item.CategoryMappingAllowed</b> field was included and set to <code>true</code> in the request and the category ID passed in the <b>Item.PrimaryCategory</b> field was mapped to a new category ID by eBay. If the primary category has not changed or it has expired with no replacement, this field is not returned.
 * <br/><br/>
 * <br> <B>Output property:</B> <code>ReturnedCategory2ID</code> - Unique identifier of the secondary eBay category (if one was used) in which the item was relisted. This field is only returned if the <b>Item.CategoryMappingAllowed</b> field was included and set to <code>true</code> in the request and the category ID passed in the <b>Item.SecondaryCategory</b> field was mapped to a new category ID by eBay. If the secondary category has not changed or it has expired with no replacement, this field is not returned.
 * <br/><br/>
 * <br> <B>Output property:</B> <code>ReturnedDiscountReason</code> - This field is returned if an eBay special offer or promotion is applicable to the listing.
 * <br> <B>Output property:</B> <code>ReturnedProductSuggestions</code> - Provides a list of products recommended by eBay which match the item information
 * provided by the seller.
 * <br> <B>Output property:</B> <code>ReturnedListingRecommendations</code> - Container consisting of one or more <b>Recommendation</b> containers. Each <b>Recommendation</b> container provides a message to the seller on how a listing can be improved or brought up to standard in regards to top-rated seller/listing requirements, mandated or recommended Item Specifics, picture quality requirements, pricing and/or listing format recommendations, recommended keywords and/or Item Specifics in a Title, and/or a recommendation to offer fast handling (same-day handling or handling time of 1 day) and/or a free shipping option in order to qualify the listing for a Fast 'N Free badge.
 * <br><br>
 * This container is only returned if the <b>IncludeRecommendations</b>
 * flag was included and set to 'true' in the <b>RelistFixedPriceItem</b> request, and if
 * at least one listing recommendation exists for the newly relisted item. If one or more listing recommendations are returned, it will be at the seller's discretion about whether to revise the item based on eBay's listing recommendation(s).
 * 
 * @author Ron Murphy
 * @version 1.0
 */

public class RelistFixedPriceItemCall extends com.ebay.sdk.ApiCall
{
  
  private ItemType itemToBeRelisted = null;
  private String[] deletedField = null;
  private String returnedItemID=null;
  private String returnedSKU=null;
  private FeesType listingFees=null;
  private Calendar returnedStartTime=null;
  private Calendar returnedEndTime=null;
  private String returnedCategoryID=null;
  private String returnedCategory2ID=null;
  private DiscountReasonCodeType[] returnedDiscountReason=null;
  private ProductSuggestionsType returnedProductSuggestions=null;
  private ListingRecommendationsType returnedListingRecommendations=null;

  private PictureService pictureService;


  /**
   * Constructor.
   */
  public RelistFixedPriceItemCall() {
  }

  /**
   * Constructor.
   * @param apiContext The ApiContext object to be used to make the call.
   */
  public RelistFixedPriceItemCall(ApiContext apiContext) {
    super(apiContext);
    
    this.pictureService = eBayPictureServiceFactory.getPictureService(apiContext);       

  }

  /**
   * Enables a seller to relist a fixed-price listing that has recently ended on a specified eBay site. A seller has to up to 90 days to relist an ended listing. When an item is relisted, it will receive a new <b>ItemID</b> value, but this item will remain on other users' Watch Lists after it is relisted. The seller has the opportunity to make changes to the listing through the <b>Item</b> container, and the seller can also use one or more <b>DeletedField</b> tags to remove an optional field/setting from the listing.
   * 
   * <br>
   * @throws ApiException
   * @throws SdkException
   * @throws Exception
   * @return The FeesType object.
   */
  public FeesType relistFixedPriceItem()
      throws com.ebay.sdk.ApiException, com.ebay.sdk.SdkException, java.lang.Exception
  {
    RelistFixedPriceItemRequestType req;
    req = new RelistFixedPriceItemRequestType();

    if( this.itemToBeRelisted == null )
      throw new SdkException("ItemToBeRelisted property is not set.");
    String origItemID = this.itemToBeRelisted.getItemID();
    req.setItem(this.itemToBeRelisted);
    if (this.itemToBeRelisted != null)
      req.setItem(this.itemToBeRelisted);
    if (this.deletedField != null)
      req.setDeletedField(this.deletedField);

    RelistFixedPriceItemResponseType resp = (RelistFixedPriceItemResponseType) execute(req);

    this.returnedItemID = resp.getItemID();
    this.returnedSKU = resp.getSKU();
    this.listingFees = resp.getFees();
    this.returnedStartTime = resp.getStartTime();
    this.returnedEndTime = resp.getEndTime();
    this.returnedCategoryID = resp.getCategoryID();
    this.returnedCategory2ID = resp.getCategory2ID();
    this.returnedDiscountReason = resp.getDiscountReason();
    this.returnedProductSuggestions = resp.getProductSuggestions();
    this.returnedListingRecommendations = resp.getListingRecommendations();
    if( this.itemToBeRelisted.getListingDetails() == null )
      this.itemToBeRelisted.setListingDetails(new ListingDetailsType());
    this.itemToBeRelisted.getListingDetails().setRelistedItemID(origItemID);

    this.itemToBeRelisted.setItemID(resp.getItemID());
    return this.getListingFees();
  }

  /**
   * Gets the RelistFixedPriceItemRequestType.deletedField.
   * @return String[]
   */
  public String[] getDeletedField()
  {
    return this.deletedField;
  }

  /**
   * Sets the RelistFixedPriceItemRequestType.deletedField.
   * @param deletedField String[]
   */
  public void setDeletedField(String[] deletedField)
  {
    this.deletedField = deletedField;
  }

  /**
   * Gets the RelistFixedPriceItemRequestType.itemToBeRelisted.
   * @return ItemType
   */
  public ItemType getItemToBeRelisted()
  {
    return this.itemToBeRelisted;
  }

  /**
   * Sets the RelistFixedPriceItemRequestType.itemToBeRelisted.
   * @param itemToBeRelisted ItemType
   */
  public void setItemToBeRelisted(ItemType itemToBeRelisted)
  {
    this.itemToBeRelisted = itemToBeRelisted;
  }
 
  public void uploadPictures(String[] pictureFiles, PictureDetailsType pictureDetails) throws SdkException  {
	  if(pictureFiles == null) {
		  return;
	  }
      PictureInfo[] pictureInfoArray = new PictureInfo[pictureFiles.length];
      for(int i = 0; i < pictureFiles.length; i ++) {
    	  pictureInfoArray[i] = new PictureInfo();
    	  pictureInfoArray[i].setPictureFilePath(pictureFiles[i]);
      }
      uploadPictures(pictureInfoArray, pictureDetails);
  }
  
  public void uploadPictures(PictureInfo[] pictureInfoArray, PictureDetailsType pictureDetails) throws SdkException  {
	    String epsUrl = getApiContext().getEpsServerUrl();
	    if(pictureInfoArray == null || epsUrl == null) {
	    	return;
	    }
	    if(pictureDetails == null) {
	    	pictureDetails = new PictureDetailsType();
	    }
	    if(pictureDetails.getPhotoDisplay() == null) {
	    	pictureDetails.setPhotoDisplay(PhotoDisplayCodeType.NONE);
	    }
	    if(pictureDetails.getGalleryType() == null) {
	    	pictureDetails.setGalleryType(GalleryTypeCodeType.NONE);
	    }
	    if(pictureDetails.getPictureSource() == null) {
	    	pictureDetails.setPictureSource(PictureSourceCodeType.VENDOR);
	    }
	    itemToBeRelisted.setPictureDetails(pictureDetails);

        int uploads = pictureService.uploadPictures(pictureDetails.getPhotoDisplay(), pictureInfoArray);
        if(uploads != pictureInfoArray.length ) {
          // Build error message.
          StringBuffer sb = new StringBuffer();
          for(int i = 0; i < pictureInfoArray.length; i ++ ) {
            if (pictureInfoArray[i].hasError())
              sb.append(pictureInfoArray[i].getErrorType() + " : " +
            		   pictureInfoArray[i].getErrorMessage() + "\n");
          }
          throw new SdkException(sb.toString());
        }
        
        // Save urls back to item object.
	String[] uris = new String[pictureInfoArray.length];
	for(int i = 0; i < pictureInfoArray.length; i ++) {
		uris[i] = pictureInfoArray[i].getURL();
	}
	itemToBeRelisted.getPictureDetails().setPictureURL(uris);
  }


  /**
   * Valid after executing the API.
   * Gets the returned RelistFixedPriceItemResponseType.listingFees.
   * 
   * @return FeesType
   */
  public FeesType getListingFees()
  {
    return this.listingFees;
  }

  /**
   * Valid after executing the API.
   * Gets the returned RelistFixedPriceItemResponseType.returnedCategory2ID.
   * 
   * @return String
   */
  public String getReturnedCategory2ID()
  {
    return this.returnedCategory2ID;
  }

  /**
   * Valid after executing the API.
   * Gets the returned RelistFixedPriceItemResponseType.returnedCategoryID.
   * 
   * @return String
   */
  public String getReturnedCategoryID()
  {
    return this.returnedCategoryID;
  }

  /**
   * Valid after executing the API.
   * Gets the returned RelistFixedPriceItemResponseType.returnedDiscountReason.
   * 
   * @return DiscountReasonCodeType[]
   */
  public DiscountReasonCodeType[] getReturnedDiscountReason()
  {
    return this.returnedDiscountReason;
  }

  /**
   * Valid after executing the API.
   * Gets the returned RelistFixedPriceItemResponseType.returnedEndTime.
   * 
   * @return Calendar
   */
  public Calendar getReturnedEndTime()
  {
    return this.returnedEndTime;
  }

  /**
   * Valid after executing the API.
   * Gets the returned RelistFixedPriceItemResponseType.returnedItemID.
   * 
   * @return String
   */
  public String getReturnedItemID()
  {
    return this.returnedItemID;
  }

  /**
   * Valid after executing the API.
   * Gets the returned RelistFixedPriceItemResponseType.returnedListingRecommendations.
   * 
   * @return ListingRecommendationsType
   */
  public ListingRecommendationsType getReturnedListingRecommendations()
  {
    return this.returnedListingRecommendations;
  }

  /**
   * Valid after executing the API.
   * Gets the returned RelistFixedPriceItemResponseType.returnedProductSuggestions.
   * 
   * @return ProductSuggestionsType
   */
  public ProductSuggestionsType getReturnedProductSuggestions()
  {
    return this.returnedProductSuggestions;
  }

  /**
   * Valid after executing the API.
   * Gets the returned RelistFixedPriceItemResponseType.returnedSKU.
   * 
   * @return String
   */
  public String getReturnedSKU()
  {
    return this.returnedSKU;
  }

  /**
   * Valid after executing the API.
   * Gets the returned RelistFixedPriceItemResponseType.returnedStartTime.
   * 
   * @return Calendar
   */
  public Calendar getReturnedStartTime()
  {
    return this.returnedStartTime;
  }

}

