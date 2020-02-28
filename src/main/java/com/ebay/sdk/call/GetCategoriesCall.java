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
import java.lang.Double;
import java.lang.Integer;
import java.lang.String;
import java.util.Calendar;

import com.ebay.sdk.*;
import com.ebay.soap.eBLBaseComponents.*;
/**
 * Wrapper class of the GetCategories call of eBay SOAP API.
 * <br>
 * <p>Title: SOAP API wrapper library.</p>
 * <p>Description: Contains wrapper classes for eBay SOAP APIs.</p>
 * <p>Copyright: Copyright (c) 2009</p>
 * <p>Company: eBay Inc.</p>
 * <br> <B>Input property:</B> <code>CategorySiteID</code> - This field is used if the user wants to retrieve category data for another eBay site (other than the one specified in the <code>X-EBAY-API-SITEID</code> request header).
 * <br>
 * <br>
 * If the user wishes to retrieve category data for the US eBay Motors site, the user must set the Site ID in the <code>X-EBAY-API-SITEID</code> request header to <code>0</code>, and then set this field's value to <code>100</code>.
 * <br> <B>Input property:</B> <code>ParentCategories</code> - This field is used if the user wishes to retrieve category hierarchy information on one or more specific eBay categories, and optionally, one or more levels of each category's children (if a category has one or more levels of children). For example, if you wanted to view the entire category hierarchy under the <em>Home & Garden</em> L1 category, you would include this field and set its value to <code>11700</code>. As long as the <b>LevelLimit</b> field is omitted, all of  <em>Home & Garden</em>'s child categories are returned. If you only wanted to see the next level (L2s) of <em>Home & Garden</em> categories, you would include the <b>LevelLimit</b> field and set its value to <code>2</code>, allowing the L1 category (<em>Home & Garden</em>) and all of its L2 categories to appear in the response.
 * <br>
 * <br>
 * If you wanted to see all of the Category IDs for the eBay site's L1 categories, you could omit the <b>CategoryParent</b> field but include the  <b>LevelLimit</b> field and set its value to <code>1</code>.
 * <br>
 * <br>
 * <span class="tablenote"><b>Note:</b>
 * Numerous Category IDs may be specified under multiple <b>CategoryParent</b> fields in a <b>GetCategories</b> request, but if multiple <b>CategoryParent</b> fields are used, the specified Category IDs should all be at the same level (L1, L2, L3, etc.).
 * </span>
 * <br> <B>Input property:</B> <code>LevelLimit</code> - This field is used if the user wants to control the maximum depth of the category hierarchy to retrieve, or in other words, how many levels of eBay categories that are returned in the response. If this field is omitted, every eBay category from the root on down will be returned, or, if a <b>CategoryParent</b> category is specified, the specified category and all of its children (down to the leaf categories) are returned.
 * <br>
 * <br>
 * If the <b>CategoryParent</b> is not used, but the <b>LevelLimit</b> field is used and set to <code>1</code>, only the top-level categories (also known as L1 categories) are returned in the response.
 * <br> <B>Input property:</B> <code>ViewAllNodes</code> - This flag controls whether all eBay categories (that satisfy input filters) are returned, or only leaf categories (you can only list items in leaf categories) are returned. The default value is 'true', so if this field is omitted, all eBay categories will be returned. If you only want to retrieve leaf categories, include this flag and set it to <code>false</code>.
 * <br>
 * <br> <B>Output property:</B> <code>ReturnedCategoryArray</code> - List of the returned categories. The category array contains one CategoryType
 * object for each returned category. Returns empty if no detail level is specified.
 * <br> <B>Output property:</B> <code>ReturnedCategoryCount</code> - Indicates the number of categories returned (i.e., the number of CategoryType
 * objects in CategoryArray).
 * <br> <B>Output property:</B> <code>ReturnedCategoryUpdateTime</code> - Indicates the last date and time that eBay modified the category hierarchy for the
 * specified eBay site.
 * <br> <B>Output property:</B> <code>ReturnedCategoryVersion</code> - Indicates the version of the category hierarchy on the
 * specified eBay site.
 * <br> <B>Output property:</B> <code>ReturnedReservePriceAllowed</code> - If true, <b>ReservePriceAllowed</b> indicates that all categories on the
 * site allow the seller to specify a reserve price for an item.
 * If false, this field is not returned in the response and all categories on the site do not normally allow sellers to specify reserve prices.
 * The Category.ORPA (override reserve price allowed) field can override (or toggle)
 * the reserve price allowed setting for a given category.
 * For example, if <b>ReservePriceAllowed</b> is false and Category.ORPA is true,
 * the category overrides the site setting and supports reserve prices.
 * If <b>ReservePriceAllowed</b> is true and Category.ORPA is true, the category
 * overrides the site setting and does does not support reserve prices.
 * <br> <B>Output property:</B> <code>MinimumReservePrice</code> - Indicates the lowest possible reserve price allowed for any item
 * listed in any category on the site. You can use the fields returned by <b>GetCategoryFeatures</b> to determine if a different Minimum Reserve Price is defined for the category you want to use.
 * <br> <B>Output property:</B> <code>ReturnedReduceReserveAllowed</code> - If true, <b>ReduceReserveAllowed</b> indicates that all categories on the
 * site allow the seller to reduce an item's reserve price.
 * If false, this field is not returned in the response and all categories on the site do not normally allow sellers to reduce an
 * item's reserve price.
 * The Category.ORRA (override reduce reserve price) field can override (or toggle)
 * the reserve price reduction setting for a given category.
 * For example, if <b>ReduceReserveAllowed</b> is false and Category.ORRA is true,
 * the category overrides the site setting and supports reducing reserve prices.
 * If <b>ReduceReserveAllowed</b> is true and Category.ORRA is true, the category
 * overrides the site setting and does does not support reducing reserve prices.
 * 
 * @author Ron Murphy
 * @version 1.0
 */

public class GetCategoriesCall extends com.ebay.sdk.ApiCall
{
  
  private SiteCodeType categorySiteID = SiteCodeType.US;
  private String[] parentCategories = null;
  private int levelLimit = 0;
  private Boolean viewAllNodes = null;
  private CategoryType[] returnedCategoryArray=null;
  private Integer returnedCategoryCount=null;
  private Calendar returnedCategoryUpdateTime=null;
  private String returnedCategoryVersion=null;
  private Boolean returnedReservePriceAllowed=null;
  private Double minimumReservePrice=null;
  private Boolean returnedReduceReserveAllowed=null;

  private GetCategoriesResponseType response;

  /**
   * Constructor.
   */
  public GetCategoriesCall() {
  }

  /**
   * Constructor.
   * @param apiContext The ApiContext object to be used to make the call.
   */
  public GetCategoriesCall(ApiContext apiContext) {
    super(apiContext);
    

  }

  /**
   * Retrieves the latest eBay category hierarchy for a given eBay site.
   * Information returned for each category includes the category name
   * and the unique ID for the category (unique within the eBay site for which
   * categories are retrieved). A category ID is a required input when you list most items.
   * 
   * <br>
   * @throws ApiException
   * @throws SdkException
   * @throws Exception
   * @return The CategoryType[] object.
   */
  public CategoryType[] getCategories()
      throws com.ebay.sdk.ApiException, com.ebay.sdk.SdkException, java.lang.Exception
  {
    GetCategoriesRequestType req;
    req = new GetCategoriesRequestType();
    req.setDetailLevel(this.getDetailLevel());
    if (this.categorySiteID != null)
      req.setCategorySiteID(stringFromSiteCodeType(this.categorySiteID));
    if (this.parentCategories != null)
      req.setCategoryParent(this.parentCategories);
    if (this.levelLimit != 0)
      req.setLevelLimit(new Integer(this.levelLimit));
    if (this.viewAllNodes != null)
      req.setViewAllNodes(this.viewAllNodes);

    GetCategoriesResponseType resp = (GetCategoriesResponseType) execute(req);

    this.returnedCategoryArray = (resp.getCategoryArray() == null? null: resp.getCategoryArray().getCategory());
    this.returnedCategoryCount = resp.getCategoryCount();
    this.returnedCategoryUpdateTime = resp.getUpdateTime();
    this.returnedCategoryVersion = resp.getCategoryVersion();
    this.returnedReservePriceAllowed = resp.isReservePriceAllowed();
    this.minimumReservePrice = resp.getMinimumReservePrice();
    this.returnedReduceReserveAllowed = resp.isReduceReserveAllowed();
    response = resp;

    return this.getReturnedCategoryArray();
  }

  /**
   * Gets the GetCategoriesRequestType.categorySiteID.
   * @return SiteCodeType
   */
  public SiteCodeType getCategorySiteID()
  {
    return this.categorySiteID;
  }

  /**
   * Sets the GetCategoriesRequestType.categorySiteID.
   * @param categorySiteID SiteCodeType
   */
  public void setCategorySiteID(SiteCodeType categorySiteID)
  {
    this.categorySiteID = categorySiteID;
  }

  /**
   * Gets the GetCategoriesRequestType.levelLimit.
   * @return int
   */
  public int getLevelLimit()
  {
    return this.levelLimit;
  }

  /**
   * Sets the GetCategoriesRequestType.levelLimit.
   * @param levelLimit int
   */
  public void setLevelLimit(int levelLimit)
  {
    this.levelLimit = levelLimit;
  }

  /**
   * Gets the GetCategoriesRequestType.parentCategories.
   * @return String[]
   */
  public String[] getParentCategories()
  {
    return this.parentCategories;
  }

  /**
   * Sets the GetCategoriesRequestType.parentCategories.
   * @param parentCategories String[]
   */
  public void setParentCategories(String[] parentCategories)
  {
    this.parentCategories = parentCategories;
  }

  /**
   * Gets the GetCategoriesRequestType.viewAllNodes.
   * @return Boolean
   */
  public Boolean getViewAllNodes()
  {
    return this.viewAllNodes;
  }

  /**
   * Sets the GetCategoriesRequestType.viewAllNodes.
   * @param viewAllNodes Boolean
   */
  public void setViewAllNodes(Boolean viewAllNodes)
  {
    this.viewAllNodes = viewAllNodes;
  }
/**
   * Call eBay API to downloads all categories in asynchronized mode to reduce
   * consumption of system resource.
   * Usually if you use GetCategoriesCall.getCategories()
   * to retrieve all categories it will require large amount of memory.
   * This static method devides all categories into small
   * groups then call GetCategories for each group.
   *
   * @param apiContext ApiContext
   * @param siteID SiteCodeType The eBay site associated with the categories.
   * @param levelLimit int Used to download parent categories to start from.
   * These parent categories will be devided into groups with the size of groupSize.
   * CatCategories API will be called for each group then all results will be cominbed together.
   * @param detailLevel DetailLevelCodeType The detail level to use to download categories.
   * @param groupSize int Size of parent category group.
   * @param listener CategoryEventListener Listener to receive downloaded categories.
   * @throws Exception
   * @return int Total number of categories received.
   */
  public static int getAllCategories(ApiContext apiContext, SiteCodeType siteID, int levelLimit, DetailLevelCodeType detailLevel, int groupSize, CategoryEventListener listener)
      throws Exception
  {
     GetCategoriesCall api = new GetCategoriesCall(apiContext);
    api.setSite(siteID);
    api.setDetailLevel(new DetailLevelCodeType[] {detailLevel});
    api.setLevelLimit(levelLimit);
    api.setCategorySiteID(siteID);
    api.setViewAllNodes(true);
    
    // Download root categories then devide them into groups for downloading.
    CategoryType[] rootCats = api.getCategories();
    
    //remove top level categories to the tail of the array
    int tail=rootCats.length-1;
    int length=0;
    for(length = 0;length <= tail;){
    	if(rootCats[length].getCategoryLevel()==levelLimit&&(rootCats[length].isLeafCategory()==null||rootCats[length].isLeafCategory()==false)){
    		length++;
    		continue;
    	}
    	CategoryType temp = rootCats[length];
    	rootCats[length] = rootCats[tail];
    	rootCats[tail] = temp;
    	tail--;
    }
    //send top categories
    int topLength = rootCats.length-length;
    CategoryType[] topCategories = new CategoryType[topLength];
    for(int i = length;i < rootCats.length;i++){
    	topCategories[i-length] = rootCats[length];
    }
    listener.receivedCategories(siteID, topCategories, api.returnedCategoryVersion);
    
    int totalDownloaded = topLength;

    for(int fromId = 0; fromId < length; ) {
      api = new GetCategoriesCall(apiContext);
      api.setSite(siteID);
      api.setDetailLevel(new DetailLevelCodeType[] {detailLevel});
      api.setViewAllNodes(true);
      api.setCategorySiteID(siteID);

      int toId = fromId + groupSize - 1;
      if( toId >= length ) {
        toId = length - 1;
      }
      int num = toId - fromId + 1;
      String[] parentIdList = new String[num];
      for(int n = 0; n < num; n++ ) {
        parentIdList[n] = rootCats[fromId + n].getCategoryID();
      }
      api.setParentCategory(parentIdList);

      CategoryType cats[] = api.getCategories();
      if( cats != null && cats.length > 0 ) {
        totalDownloaded += cats.length;
        listener.receivedCategories(siteID, cats, api.returnedCategoryVersion);
      }

      if( toId >= rootCats.length - 1 ) {
        break;
      }

      fromId = toId + 1;
    }

    return totalDownloaded;
  }

/**
   * Gets the GetCategoriesResponseType.
   * @return GetCategoriesResponseType
   */ 
  public GetCategoriesResponseType getResponse() {
	return response;
  }
/**
   * No longer supported - do not use.
   */
  public void setMinimumReservePrice(java.lang.Double minimumReservePrice) {
      this.minimumReservePrice = minimumReservePrice;
  }
/**
   * Backward compatible function - use setParentCategories instead.
   * @param parentCategories String[]
   */
  public void setParentCategory(String[] parentCategories) {
    this.parentCategories = parentCategories;
  }
/**
   *
   * @param strList String[]
   * @return ItemIDType[]
   */
  public static String stringFromSiteCodeType(SiteCodeType categorySiteID)
  {
	return new Integer(SiteIDUtil.toNumericalID(categorySiteID)).toString();
  }


  /**
   * Valid after executing the API.
   * Gets the returned GetCategoriesResponseType.minimumReservePrice.
   * 
   * @return Double
   */
  public Double getMinimumReservePrice()
  {
    return this.minimumReservePrice;
  }

  /**
   * Valid after executing the API.
   * Gets the returned GetCategoriesResponseType.returnedCategoryArray.
   * 
   * @return CategoryType[]
   */
  public CategoryType[] getReturnedCategoryArray()
  {
    return this.returnedCategoryArray;
  }

  /**
   * Valid after executing the API.
   * Gets the returned GetCategoriesResponseType.returnedCategoryCount.
   * 
   * @return Integer
   */
  public Integer getReturnedCategoryCount()
  {
    return this.returnedCategoryCount;
  }

  /**
   * Valid after executing the API.
   * Gets the returned GetCategoriesResponseType.returnedCategoryUpdateTime.
   * 
   * @return Calendar
   */
  public Calendar getReturnedCategoryUpdateTime()
  {
    return this.returnedCategoryUpdateTime;
  }

  /**
   * Valid after executing the API.
   * Gets the returned GetCategoriesResponseType.returnedCategoryVersion.
   * 
   * @return String
   */
  public String getReturnedCategoryVersion()
  {
    return this.returnedCategoryVersion;
  }

  /**
   * Valid after executing the API.
   * Gets the returned GetCategoriesResponseType.returnedReduceReserveAllowed.
   * 
   * @return Boolean
   */
  public Boolean getReturnedReduceReserveAllowed()
  {
    return this.returnedReduceReserveAllowed;
  }

  /**
   * Valid after executing the API.
   * Gets the returned GetCategoriesResponseType.returnedReservePriceAllowed.
   * 
   * @return Boolean
   */
  public Boolean getReturnedReservePriceAllowed()
  {
    return this.returnedReservePriceAllowed;
  }

}

