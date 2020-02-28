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
import java.lang.Boolean;
import java.lang.String;
import java.util.Calendar;

import com.ebay.sdk.*;
import com.ebay.soap.eBLBaseComponents.*;
/**
 * Wrapper class of the ReviseItem call of eBay SOAP API.
 * <br>
 * <p>Title: SOAP API wrapper library.</p>
 * <p>Description: Contains wrapper classes for eBay SOAP APIs.</p>
 * <p>Copyright: Copyright (c) 2009</p>
 * <p>Company: eBay Inc.</p>
 * <br> <B>Input property:</B> <code>ItemToBeRevised</code> - The <b>Item</b> container is used to make changes to the active listing. The seller must pass in the <b>ItemID</b> value for the listing that is being revised. For anything else that the seller wishes to change, such as quantity or price, the seller should include this field in the call request and give it a new value.
 * <br/><br/>
 * If the seller wants to delete one or more optional settings in the listing, the seller should use the <b>DeletedField</b> tag.
 * <br> <B>Input property:</B> <code>DeletedField</code> - Specifies the name of a field to delete from a listing. The request can
 * contain zero, one, or many instances of <b>DeletedField</b> (one for each field
 * to be deleted). See the relevant field descriptions to determine when to
 * use <b>DeletedField</b> (and potential consequences).
 * <br><br>
 * You cannot delete required fields from a listing.
 * <br><br>
 * Some fields are optional when you first list an item (e.g.,
 * <b>SecondaryCategory</b>), but once they are set they cannot be deleted when you
 * revise an item. Some optional fields cannot be deleted if the item has
 * bids and/or ends within 12 hours. Some optional fields cannot be deleted
 * if other fields depend on them.
 * <br><br>
 * Use values that match the case of the
 * schema element names (<b>Item.PictureDetails.GalleryURL</b>) or make the initial
 * letter of each field name lowercase (<b>item.pictureDetails.galleryURL</b>).
 * However, do not change the case of letters in the middle of a field name.
 * For example, <b>item.picturedetails.galleryUrl</b> is not allowed.
 * <br><br>
 * To delete a listing enhancement like <b>BoldTitle</b>, specify the value you are
 * deleting in square brackets ("[ ]"); for example,
 * <b>Item.ListingEnhancement[BoldTitle]</b>.
 * <br> <B>Input property:</B> <code>VerifyOnly</code> - When the <b>VerifyOnly</b> is included and set as <code>true</code>, the active listing is not actually revised, but the same response is returned and the seller gets to see the expected fees based on the changes made, and can also view any listing recommendations if the <b>Item.IncludeRecommedations</b> boolean field is included and set to <code>true</code>.
 * <br> <B>Output property:</B> <code>ReturnedItemID</code> - The unique identifier for the revised listing. Note that the <b>ItemID</b> value does not change when a listing is revised, so this will be the same <b>ItemID</b> value that was passed in the call request.
 * <br/><br/>
 * <br> <B>Output property:</B> <code>ReturnedStartTime</code> - This timestamp indicates the date and time when the listing was created on the eBay site. This value doesn't change when a listing is revised.
 * <br> <B>Output property:</B> <code>ReturnedEndTime</code> - Date and time when the revised listing is scheduled to end based on the listing's start time and the listing duration value that was set for the listing. If the listing duration is 'GTC' (Good 'Til Cancelled), this value will be updated to 30 days in the future if the listing is automatically renewed after 30 days. GTC listings are automatically renewed if quantity still exists for the item. Note that GTC is not applicable to auction listings.
 * <br><br>
 * <span class="tablenote"><b>Note: </b>
 * Starting July 1, 2019, the Good 'Til Cancelled renewal schedule will be modified from every 30 days to once per calendar month. For example, if a GTC listing is created July 5, the next monthly renewal date will be August 5. If a GTC listing is created on the 31st of the month, but the following month only has 30 days, the renewal will happen on the 30th in the following month. Finally, if a GTC listing is created on January 29-31, the renewal will happen on February 28th (or 29th during a 'Leap Year'). See the
 * <a href="https://pages.ebay.com/seller-center/seller-updates/2019-spring/marketplace-updates.html#good-til-cancelled" target="_blank">Good 'Til Cancelled listings update</a> in the <b>Spring 2019 Seller Updates</b> for more information about this change.
 * </span>
 * <br> <B>Output property:</B> <code>ListingFees</code> - This container consists of the estimated listing fees for the revised listing. Each type of fee is returned even if it is not appplicable (has a value of <code>0.0</code>. The Final Value Fee (FVF) is not in this container, as this value cannot be determined until a sale is made.
 * <br> <B>Output property:</B> <code>ReturnedCategoryID</code> - Unique identifier of the primary eBay category for the revised listing. This field is returned if the primary category was changed with the revision, and the primary category can only be changed if a fixed-price listing has no sales/auction listing has no bids, and the listing does not end within 12 hours.
 * <br/><br/>
 * This field can also be returned if the <b>Item.CategoryMappingAllowed</b> field was included and set to <code>true</code> in the request and the category ID passed in the <b>Item.PrimaryCategory</b> field was mapped to a new category ID by eBay. If the primary category has not changed or it has expired with no replacement, this field is not returned.
 * <br/><br/>
 * <br> <B>Output property:</B> <code>ReturnedCategory2ID</code> - Unique identifier of the secondary eBay category for the revised listing. This field is returned if the secondary category was changed with the revision, and the secondary category can only be changed if a fixed-price listing has no sales/auction listing has no bids, and the listing does not end within 12 hours.
 * <br/><br/>
 * This field can also be returned if the <b>Item.CategoryMappingAllowed</b> field was included and set to <code>true</code> in the request and the category ID passed in the <b>Item.PrimaryCategory</b> field was mapped to a new category ID by eBay. If the primary category has not changed or it has expired with no replacement, this field is not returned.
 * <br/><br/>
 * <br> <B>Output property:</B> <code>ReturnedVerifyOnly</code> - This field is returned if the <b>VerifyOnly</b> field was included in the call request and set to <code>true</code>.
 * <br/><br/>
 * If the listing was revised in 'Verify Only' mode, the active listing is not actually revised, but the same response is returned and the seller gets to see the expected fees based on the changes made, and can also view any listing recommendations if the <b>Item.IncludeRecommedations</b> boolean input field was included and set to <code>true</code>.
 * <br> <B>Output property:</B> <code>ReturnedDiscountReason</code> - This field is returned if an eBay special offer or promotion is applicable to the listing.
 * <br> <B>Output property:</B> <code>ReturnedProductSuggestions</code> - Provides a list of products recommended by eBay which match the item information
 * provided by the seller.
 * <br> <B>Output property:</B> <code>ReturnedListingRecommendations</code> - Container consisting of one or more <b>Recommendation</b> containers. Each <b>Recommendation</b> container provides a message to the seller on how a listing can be improved or brought up to standard in regards to top-rated seller/listing requirements, mandated or recommended Item Specifics, picture quality requirements, pricing and/or listing format recommendations, recommended keywords and/or Item Specifics in a Title, and/or a recommendation to offer fast handling (same-day handling or handling time of 1 day) and/or a free shipping option in order to qualify the listing for a Fast 'N Free badge.
 * <br><br>
 * This container is only returned if the <b>IncludeRecommendations</b> flag was included and set to 'true' in the <b>ReviseItem</b> request, and if at least one listing recommendation exists for the listing about to be revised. If one or more listing recommendations are returned, it will be at the seller's discretion about whether to revise the item again based on eBay's listing recommendation(s).
 * 
 * @author Ron Murphy
 * @version 1.0
 */

public class ReviseItemCall extends com.ebay.sdk.ApiCall
{
  
  private ItemType itemToBeRevised = null;
  private String[] deletedField = null;
  private Boolean verifyOnly = null;
  private String returnedItemID=null;
  private Calendar returnedStartTime=null;
  private Calendar returnedEndTime=null;
  private FeesType listingFees=null;
  private String returnedCategoryID=null;
  private String returnedCategory2ID=null;
  private Boolean returnedVerifyOnly=null;
  private DiscountReasonCodeType[] returnedDiscountReason=null;
  private ProductSuggestionsType returnedProductSuggestions=null;
  private ListingRecommendationsType returnedListingRecommendations=null;

  private TimeFilter listingDuration = null;
  private PictureService pictureService;


  /**
   * Constructor.
   */
  public ReviseItemCall() {
  }

  /**
   * Constructor.
   * @param apiContext The ApiContext object to be used to make the call.
   */
  public ReviseItemCall(ApiContext apiContext) {
    super(apiContext);
    
    this.pictureService = eBayPictureServiceFactory.getPictureService(apiContext);       
  }

  /**
   * Enables a seller to revise a listing on a specified eBay site. To revise an active listing, the seller specifies the <b>ItemID</b> value for the listing. The seller makes one or multiple changes to the listing through the <b>Item</b> container, and the seller can also use one or more <b>DeletedField</b> tags to remove an optional field/setting from the listing.
   * <br>
   * <br>
   * After a multiple-quantity, fixed-price listing has one or more sales, or less than 12 hours remain before the listing is scheduled to end, you can not edit the values in the Listing Title, Primary Category, Secondary Category, Listing Duration, and Listing Type fields for that listing. The same applies to an auction listing that has at least one bid.
   * <br>
   * <br>
   * To revise a multiple-variation, fixed-price listing, the <b>ReviseFixedPriceItem</b> call should be used instead, as the <b>ReviseItem</b> call does not support variation-level edits.
   * 
   * <br>
   * @throws ApiException
   * @throws SdkException
   * @throws Exception
   * @return The FeesType object.
   */
  public FeesType reviseItem()
      throws com.ebay.sdk.ApiException, com.ebay.sdk.SdkException, java.lang.Exception
  {
    ReviseItemRequestType req;
    req = new ReviseItemRequestType();

    if( this.itemToBeRevised == null )
      throw new SdkException("ItemToBeRevised property is not set.");
 
    if (this.itemToBeRevised != null)
      req.setItem(this.itemToBeRevised);
    if (this.deletedField != null)
      req.setDeletedField(this.deletedField);
    if (this.verifyOnly != null)
      req.setVerifyOnly(this.verifyOnly);

    ReviseItemResponseType resp = (ReviseItemResponseType) execute(req);

    this.returnedItemID = resp.getItemID();
    this.returnedStartTime = resp.getStartTime();
    this.returnedEndTime = resp.getEndTime();
    this.listingFees = resp.getFees();
    this.returnedCategoryID = resp.getCategoryID();
    this.returnedCategory2ID = resp.getCategory2ID();
    this.returnedVerifyOnly = resp.isVerifyOnly();
    this.returnedDiscountReason = resp.getDiscountReason();
    this.returnedProductSuggestions = resp.getProductSuggestions();
    this.returnedListingRecommendations = resp.getListingRecommendations();
    Calendar startTime = resp.getStartTime();
    if (null != startTime)
    {
    	listingDuration = new TimeFilter(startTime, resp.getEndTime());
    }
    return this.getListingFees();
  }

  /**
   * Gets the ReviseItemRequestType.deletedField.
   * @return String[]
   */
  public String[] getDeletedField()
  {
    return this.deletedField;
  }

  /**
   * Sets the ReviseItemRequestType.deletedField.
   * @param deletedField String[]
   */
  public void setDeletedField(String[] deletedField)
  {
    this.deletedField = deletedField;
  }

  /**
   * Gets the ReviseItemRequestType.itemToBeRevised.
   * @return ItemType
   */
  public ItemType getItemToBeRevised()
  {
    return this.itemToBeRevised;
  }

  /**
   * Sets the ReviseItemRequestType.itemToBeRevised.
   * @param itemToBeRevised ItemType
   */
  public void setItemToBeRevised(ItemType itemToBeRevised)
  {
    this.itemToBeRevised = itemToBeRevised;
  }

  /**
   * Gets the ReviseItemRequestType.verifyOnly.
   * @return Boolean
   */
  public Boolean getVerifyOnly()
  {
    return this.verifyOnly;
  }

  /**
   * Sets the ReviseItemRequestType.verifyOnly.
   * @param verifyOnly Boolean
   */
  public void setVerifyOnly(Boolean verifyOnly)
  {
    this.verifyOnly = verifyOnly;
  }
/**
   * 
   * @return the listing duration.
   */
  public TimeFilter getListingDuration() {
  	return listingDuration;
  }

  public void uploadPictures(String[] pictureFiles, PictureDetailsType pictureDetails) throws SdkException {
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
        itemToBeRevised.setPictureDetails(pictureDetails);

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
	itemToBeRevised.getPictureDetails().setPictureURL(uris);
  }


  /**
   * Valid after executing the API.
   * Gets the returned ReviseItemResponseType.listingFees.
   * 
   * @return FeesType
   */
  public FeesType getListingFees()
  {
    return this.listingFees;
  }

  /**
   * Valid after executing the API.
   * Gets the returned ReviseItemResponseType.returnedCategory2ID.
   * 
   * @return String
   */
  public String getReturnedCategory2ID()
  {
    return this.returnedCategory2ID;
  }

  /**
   * Valid after executing the API.
   * Gets the returned ReviseItemResponseType.returnedCategoryID.
   * 
   * @return String
   */
  public String getReturnedCategoryID()
  {
    return this.returnedCategoryID;
  }

  /**
   * Valid after executing the API.
   * Gets the returned ReviseItemResponseType.returnedDiscountReason.
   * 
   * @return DiscountReasonCodeType[]
   */
  public DiscountReasonCodeType[] getReturnedDiscountReason()
  {
    return this.returnedDiscountReason;
  }

  /**
   * Valid after executing the API.
   * Gets the returned ReviseItemResponseType.returnedEndTime.
   * 
   * @return Calendar
   */
  public Calendar getReturnedEndTime()
  {
    return this.returnedEndTime;
  }

  /**
   * Valid after executing the API.
   * Gets the returned ReviseItemResponseType.returnedItemID.
   * 
   * @return String
   */
  public String getReturnedItemID()
  {
    return this.returnedItemID;
  }

  /**
   * Valid after executing the API.
   * Gets the returned ReviseItemResponseType.returnedListingRecommendations.
   * 
   * @return ListingRecommendationsType
   */
  public ListingRecommendationsType getReturnedListingRecommendations()
  {
    return this.returnedListingRecommendations;
  }

  /**
   * Valid after executing the API.
   * Gets the returned ReviseItemResponseType.returnedProductSuggestions.
   * 
   * @return ProductSuggestionsType
   */
  public ProductSuggestionsType getReturnedProductSuggestions()
  {
    return this.returnedProductSuggestions;
  }

  /**
   * Valid after executing the API.
   * Gets the returned ReviseItemResponseType.returnedStartTime.
   * 
   * @return Calendar
   */
  public Calendar getReturnedStartTime()
  {
    return this.returnedStartTime;
  }

  /**
   * Valid after executing the API.
   * Gets the returned ReviseItemResponseType.returnedVerifyOnly.
   * 
   * @return Boolean
   */
  public Boolean getReturnedVerifyOnly()
  {
    return this.returnedVerifyOnly;
  }

}

