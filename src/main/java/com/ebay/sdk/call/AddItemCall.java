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
 * Wrapper class of the AddItem call of eBay SOAP API.
 * <br>
 * <p>Title: SOAP API wrapper library.</p>
 * <p>Description: Contains wrapper classes for eBay SOAP APIs.</p>
 * <p>Copyright: Copyright (c) 2009</p>
 * <p>Company: eBay Inc.</p>
 * <br> <B>Input property:</B> <code>Item</code> - This container is used to specify all of the values and settings that define a new listing.
 * <br> <B>Output property:</B> <code>ReturnedItemID</code> - Unique identifier for the new listing. This field is returned as long as the listing was successfully created.
 * <br> <B>Output property:</B> <code>ReturnedStartTime</code> - Starting date and time for the new listing. This value is based on the time the listing was received and processed, or the time the item will be listed if the seller included the <b>Item.ScheduleTime</b> field in the request and set a custom start time of the listing (in the future).
 * <br> <B>Output property:</B> <code>ReturnedEndTime</code> - Date and time when the new listing is scheduled to end based on the start time and the listing duration value that was set in the <b>ListingDuration</b> field at listing time. If the value of <b>ListingDuration</b> was set to <code>GTC</code> (Good 'Til Cancelled) this value will be set 30 days ahead of the start time, although this value will be updated if the GTC listing is still alive and automatically renewed 30 days after start time. Note that GTC is not an option with auction listings.
 * <br><br>
 * <span class="tablenote"><b>Note: </b>
 * As of July 1, 2019, the Good 'Til Cancelled renewal schedule has been modified from every 30 days to once per calendar month. For example, if a GTC listing is created July 5, the next monthly renewal date will be August 5. If a GTC listing is created on the 31st of the month, but the following month only has 30 days, the renewal will happen on the 30th in the following month. Finally, if a GTC listing is created on January 29-31, the renewal will happen on February 28th (or 29th during a 'Leap Year'). See the
 * <a href="https://pages.ebay.com/seller-center/seller-updates/2019-spring/marketplace-updates.html#good-til-cancelled" target="_blank">Good 'Til Cancelled listings update</a> in the <b>Spring 2019 Seller Updates</b> for more information about this change.
 * </span>
 * <br> <B>Output property:</B> <code>ReturnedFees</code> - This container is an array of fees associated with the creation of the listing. The fees do not include the Final Value Fee (FVF), which cannot be determined until an item is sold.
 * <br> <B>Output property:</B> <code>ReturnedCategoryID</code> - The unique identifier of the primary category in which the item was listed. This field is only returned if the <b>Item.CategoryMappingAllowed</b> boolean field is set to <code>true</code> in the request (or omitted) and the Category ID passed in as the primary listing category was automatically mapped to a new Category ID by eBay. If the primary category ID passed in the request is still active/valid, this field is not returned.
 * <br/><br/>
 * <span class="tablenote"><b>Note: </b> The <b>Item.CategoryMappingAllowed</b> field value in the request now defaults to <code>true</code> if omitted. Previously, the default value was <code>false</code>, so a user had to include this field and set it to <code>true</code> in order for eBay to map an outdated Primary or Secondary Category ID to the updated Category ID.
 * </span>
 * <br> <B>Output property:</B> <code>ReturnedCategory2ID</code> - Unique identifier of the secondary category in which the item was listed. This field is only returned if the <b>Item.CategoryMappingAllowed</b> boolean field is set to <code>true</code> in the request (or omitted) and the Category ID passed in as the secondary listing category was automatically mapped to a new Category ID by eBay. If the secondary category ID passed in the request is still active/valid, this field is not returned.
 * <br/><br/>
 * <span class="tablenote"><b>Note: </b> The <b>Item.CategoryMappingAllowed</b> field value in the request now defaults to <code>true</code> if omitted. Previously, the default value was <code>false</code>, so a user had to include this field and set it to <code>true</code> in order for eBay to map an outdated Primary or Secondary Category ID to the updated Category ID.
 * </span>
 * <br> <B>Output property:</B> <code>ReturnedDiscountReason</code> - This container is an array of one or more listing fee/upgrade discount types being offered by eBay to the seller.
 * <br> <B>Output property:</B> <code>ReturnedProductSuggestions</code> - This container holds an array of one or more products in the eBay product catalog that appear to match the product being listed, just based on the information in the listing. This container will not be returned if no similar products were found in the eBay product catalog.
 * <br> <B>Output property:</B> <code>ReturnedListingRecommendations</code> - Container consisting of one or more <b>Recommendation</b> containers. Each <b>Recommendation</b> container provides a message to the seller on how a listing can be improved or brought up to standard in regards to top-rated seller/listing requirements, mandated or recommended Item Specifics, picture quality requirements, pricing and/or listing format recommendations, recommended keywords and/or Item Specifics in a Title, and/or a recommendation to offer fast handling (same-day handling or handling time of 1 day) and/or a free shipping option in order to qualify the listing for a Fast 'N Free badge.
 * <br><br>
 * This container is only returned if the <b>IncludeRecommendations</b> flag was included and set to 'true' in the <b>AddItem</b> request, and if at least one listing recommendation exists for the newly created listing. If one or more listing recommendations are returned, it will be at the seller's discretion about whether to revise the item based on eBay's listing recommendation(s).
 * 
 * @author Ron Murphy
 * @version 1.0
 */

public class AddItemCall extends com.ebay.sdk.ApiCall
{
  
  private ItemType item = null;
  private String returnedItemID=null;
  private Calendar returnedStartTime=null;
  private Calendar returnedEndTime=null;
  private FeesType returnedFees=null;
  private String returnedCategoryID=null;
  private String returnedCategory2ID=null;
  private DiscountReasonCodeType[] returnedDiscountReason=null;
  private ProductSuggestionsType returnedProductSuggestions=null;
  private ListingRecommendationsType returnedListingRecommendations=null;

  private PictureService pictureService;
  private String[] pictureFiles = null;
  private boolean autoSetItemUUID = false;
  

  /**
   * Constructor.
   */
  public AddItemCall() {
  }

  /**
   * Constructor.
   * @param apiContext The ApiContext object to be used to make the call.
   */
  public AddItemCall(ApiContext apiContext) {
    super(apiContext);
    
    pictureService = eBayPictureServiceFactory.getPictureService(apiContext);

  }

  /**
   * Base request type for the <b>AddItem</b> call, which is used to create a fixed-price, auction, or classified ad listing.
   * 
   * <br>
   * @throws ApiException
   * @throws SdkException
   * @throws Exception
   * @return The FeesType object.
   */
  public FeesType addItem()
      throws com.ebay.sdk.ApiException, com.ebay.sdk.SdkException, java.lang.Exception
  {
    AddItemRequestType req;
    req = new AddItemRequestType();

    if(autoSetItemUUID && item.getUUID() == null)
      resetItemUUID(item);

    // Call picture service to upload picture files.
    String epsUrl = getApiContext().getEpsServerUrl();
    if(pictureFiles != null && epsUrl != null ) {
	  		PictureDetailsType pictureDetails = item.getPictureDetails();
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
	  		item.setPictureDetails(pictureDetails);
	  		PhotoDisplayCodeType photoDisplay = item.getPictureDetails().getPhotoDisplay();

	  		PictureInfo[] piList = new PictureInfo[pictureFiles.length];
	  		for(int i = 0; i < pictureFiles.length; i ++) {
	  			piList[i] = new PictureInfo();
	  			piList[i].setPictureFilePath(pictureFiles[i]);
	  		}
	  		int uploads = pictureService.uploadPictures(photoDisplay, piList);
	  		if( uploads != piList.length ) {
	  			// Build error message.
	  			StringBuffer sb = new StringBuffer();
	  			for(int i = 0; i < piList.length; i ++ ) {
	  				if (piList[i].hasError()) {
	  					sb.append(piList[i].getErrorType() + " : " + piList[i].getErrorMessage() + "\n");
	  				}
	  			}
	  			throw new SdkException(sb.toString());
	  		}

	  		// Save urls back to item object.
	  		String[] uris = new String[piList.length];
	  		for(int i = 0; i < piList.length; i ++) {
	  			uris[i] = piList[i].getURL();
	  		}
	  		item.getPictureDetails().setPictureURL(uris);
    }

    if (this.item != null)
      req.setItem(this.item);

    AddItemResponseType resp = (AddItemResponseType) execute(req);

    this.returnedItemID = resp.getItemID();
    this.returnedStartTime = resp.getStartTime();
    this.returnedEndTime = resp.getEndTime();
    this.returnedFees = resp.getFees();
    this.returnedCategoryID = resp.getCategoryID();
    this.returnedCategory2ID = resp.getCategory2ID();
    this.returnedDiscountReason = resp.getDiscountReason();
    this.returnedProductSuggestions = resp.getProductSuggestions();
    this.returnedListingRecommendations = resp.getListingRecommendations();
    item.setItemID(resp.getItemID());
    if( item.getListingDetails() == null )
      item.setListingDetails(new ListingDetailsType());
    if( resp.getStartTime() != null )
      item.getListingDetails().setStartTime(resp.getStartTime());
    if( resp.getEndTime() != null )
      item.getListingDetails().setEndTime(resp.getEndTime());
    return this.getReturnedFees();
  }

  /**
   * Gets the AddItemRequestType.item.
   * @return ItemType
   */
  public ItemType getItem()
  {
    return this.item;
  }

  /**
   * Sets the AddItemRequestType.item.
   * @param item ItemType
   */
  public void setItem(ItemType item)
  {
    this.item = item;
  }
/**
   * Returns AutoSetItemUUID property.
   * @return true means if UUID property of item (item.getUUID()) is null,
   * the call object will automatically generate an UUID and
   * fills it to the item object (item.setUUID()).
   */
  public boolean getAutoSetItemUUID() {
    return autoSetItemUUID;
  }
/**
   * Gets list of picture files for the item.
   * @return String[]
   */
  public String[] getPictureFiles() {
    return pictureFiles;
  }
/**
   * Gets the PictureService object that will be used to upload picture files
   * specified in setPictureFiles().
   * @return The PictureService instance.
   */
  public PictureService getPictureService() {
    return pictureService;
  }
/**
   * Generates a UUID.
   * @return The UUID String object.
   */
  public static String newUUID() {
  	String uuid = java.util.UUID.randomUUID().toString();
    
    	StringBuffer goodUuid = new StringBuffer();
    	for(int i = 0; i < uuid.length(); i ++) {
      		char c = uuid.charAt(i);
      		if( c != '-' ) {
        		goodUuid.append(c);
        	}
	}

    return goodUuid.toString();
  }


/**
   * Reset the UUID property of eBay item object.
   * @param item The ItemType object whose UUID property will be reset.
   */
  public static void resetItemUUID(ItemType item) {
    item.setUUID(newUUID());
  }
/**
   * Sets AutoSetItemUUID property. true means if UUID property of item is null,
   * the call object will automatically generate an UUID and fills it
   * to the item object (item.setUUID()).
   * @param autoSetItemUUID boolean
   */
  public void setAutoSetItemUUID(boolean autoSetItemUUID) {
    this.autoSetItemUUID = autoSetItemUUID;
  }
/**
   * Sets list of picture files for the item. Before listing
   * the item, the attached picture service object (setPictureService())
   * to upload these picture files then set the picture property of the
   * item object.
   * @param pictureFiles String[]
   */
  public void setPictureFiles(String[] pictureFiles) {
    this.pictureFiles = pictureFiles;
  }
/**
   * Set the PictureService object that will be used to upload picture files
   * specified in setPictureFiles().
   * @param pictureService the PictureService object.
   */
  public void setPictureService(PictureService pictureService) {
    this.pictureService = pictureService;
  }

  /**
   * Valid after executing the API.
   * Gets the returned AddItemResponseType.returnedCategory2ID.
   * 
   * @return String
   */
  public String getReturnedCategory2ID()
  {
    return this.returnedCategory2ID;
  }

  /**
   * Valid after executing the API.
   * Gets the returned AddItemResponseType.returnedCategoryID.
   * 
   * @return String
   */
  public String getReturnedCategoryID()
  {
    return this.returnedCategoryID;
  }

  /**
   * Valid after executing the API.
   * Gets the returned AddItemResponseType.returnedDiscountReason.
   * 
   * @return DiscountReasonCodeType[]
   */
  public DiscountReasonCodeType[] getReturnedDiscountReason()
  {
    return this.returnedDiscountReason;
  }

  /**
   * Valid after executing the API.
   * Gets the returned AddItemResponseType.returnedEndTime.
   * 
   * @return Calendar
   */
  public Calendar getReturnedEndTime()
  {
    return this.returnedEndTime;
  }

  /**
   * Valid after executing the API.
   * Gets the returned AddItemResponseType.returnedFees.
   * 
   * @return FeesType
   */
  public FeesType getReturnedFees()
  {
    return this.returnedFees;
  }

  /**
   * Valid after executing the API.
   * Gets the returned AddItemResponseType.returnedItemID.
   * 
   * @return String
   */
  public String getReturnedItemID()
  {
    return this.returnedItemID;
  }

  /**
   * Valid after executing the API.
   * Gets the returned AddItemResponseType.returnedListingRecommendations.
   * 
   * @return ListingRecommendationsType
   */
  public ListingRecommendationsType getReturnedListingRecommendations()
  {
    return this.returnedListingRecommendations;
  }

  /**
   * Valid after executing the API.
   * Gets the returned AddItemResponseType.returnedProductSuggestions.
   * 
   * @return ProductSuggestionsType
   */
  public ProductSuggestionsType getReturnedProductSuggestions()
  {
    return this.returnedProductSuggestions;
  }

  /**
   * Valid after executing the API.
   * Gets the returned AddItemResponseType.returnedStartTime.
   * 
   * @return Calendar
   */
  public Calendar getReturnedStartTime()
  {
    return this.returnedStartTime;
  }

}

