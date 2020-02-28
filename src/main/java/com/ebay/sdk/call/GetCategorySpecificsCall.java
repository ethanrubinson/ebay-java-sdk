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
import java.lang.Integer;
import java.lang.String;
import java.util.Calendar;

import com.ebay.sdk.*;
import com.ebay.soap.eBLBaseComponents.*;
/**
 * Wrapper class of the GetCategorySpecifics call of eBay SOAP API.
 * <br>
 * <p>Title: SOAP API wrapper library.</p>
 * <p>Description: Contains wrapper classes for eBay SOAP APIs.</p>
 * <p>Copyright: Copyright (c) 2009</p>
 * <p>Company: eBay Inc.</p>
 * <br> <B>Input property:</B> <code>CategoryID</code> - A unique identifer for an eBay leaf-level category. Recommended Item Specifics names and values will be retrieved for each eBay category that is specified. Up to 100 <b>CategoryID</b> values may be specified in one call.
 * <br><br>
 * A <b>GetCategorySpecifics</b> call request requires at least one of the following: a <b>CategoryID</b> value, a <b>CategorySpecifics.CategoryID</b> value, or the
 * <b>CategorySpecificsFileInfo</b> field with its value set to <code>true</code>. <b>CategoryID</b> values and
 * <b>CategorySpecific.CategoryID</b> values can both be used in the same request.
 * <br><br>
 * Keep in mind that a high number of specified categories can result in
 * longer response times and larger result sets. If your call request happens to time out, you might want specify fewer categories. If any
 * <b>CategoryID</b> values are specified more than once, only the first instance will be used.
 * <br> <B>Input property:</B> <code>LastUpdateTime</code> - This dateTime filter can be included and used if the user only wants to check for recently-added Item Specifics names and values for one or more categories. If this filter is used, the Item Specifics recommendation engine will only check for Item Specifics names and values that have been added/changed since the date that was passed in to this field. If this field is used, the call will not return any Item Specifics data; it will only return the <b>Recommendations.Updated</b> boolean field for each specified eBay category. A <code>true</code> value in this field will indicate that the recommended Item Specifics names/values for the eBay category have changed since the timestamp passed in the <b>LastUpdateTime</b> field, and a <code>false</code> value in this field will indicate that the recommended Item Specifics names/values for the eBay category have not changed since the timestamp passed in the <b>LastUpdateTime</b> field.
 * <br><br>
 * Typically, you will pass in the timestamp value that was returned the last time you refreshed the list of Item Specifics names and values for the same categories. If the <b>Recommendations.Updated</b> flag returns <code>true</code> for any eBay categories in the response, you will want to call <b>GetCategorySpecifics</b> again for those eBay categories to get the latest names and values. As downloading all the data may affect your application's performance, it may help to only download Item Specifics data for an eBay category if the data has changed since you last checked.
 * <br> <B>Input property:</B> <code>MaxNames</code> - This field can be used if you want to control the number of Item Specifics that are returned for each specified eBay category. If you only wanted to retrieve the 10 most popular Item Specifics per category, you would include this field and set its value to <code>10</code>. Note that mandatory Item Specifics are always returned first in the response. If this field is omitted, all available Item Specifics names for each specified category are returned. If this field's value is set to a value that is higher than the number of Item Specific names available, all Item Specific names are still returned.
 * <br>
 * <br>
 * <span class="tablenote"><b>Note:</b>
 * In October 2019, eBay has updated the <b>GetCategorySpecifics</b> call to retrieve all available Item Specifics name-value pairs for each specified category by default. Previously, 30 Item Specifics names would be returned by default (if the <b>MaxNames</b> filter wasn't used) and 25 corresponding Item Specifics values would be returned by default (if the <b>MaxValuesPerName</b> filter wasn't used). However, if a user wants to limit the number of Item Specifics names and corresponding values that are returned, they can still use the <b>MaxNames</b> and/or <b>MaxValuesPerName</b> filters to do this.
 * </span>
 * <br>
 * <br> <B>Input property:</B> <code>MaxValuesPerName</code> - This field can be used if you want to control the number of corresponding values that are returned for each returned Item Specific name in each specified eBay category. If you only wanted to retrieve the 10 most popular values/options for each returned Item Specific name in each category, you would include this field and set its value to <code>10</code>. If this field is omitted, all available values for the corresponding Item Specifics name for each category are returned. If this field's value is set to a value that is higher than the number of Item Specific values available for any Item Specific name, all Item Specific values are still returned.
 * <br>
 * <br>
 * <span class="tablenote"><b>Note:</b>
 * In October 2019, eBay has updated the <b>GetCategorySpecifics</b> call to retrieve all available Item Specifics name-value pairs for each specified category by default. Previously, 30 Item Specifics names would be returned by default (if the <b>MaxNames</b> filter wasn't used) and 25 corresponding Item Specifics values would be returned by default (if the <b>MaxValuesPerName</b> filter wasn't used). However, if a user wants to limit the number of Item Specifics names and corresponding values that are returned, they can still use the <b>MaxNames</b> and/or <b>MaxValuesPerName</b> filters to do this.
 * </span>
 * <br>
 * <br> <B>Input property:</B> <code>Name</code> - This field can be used if you already have an Item Specific name in mind, and you only want the recommended values for this Item Specifics name.
 * If you specify multiple eBay categories in the request, the recommendation engine may find a matching Item Specifics name for some categories, but not for others. For eBay categories where the Item Specifics name is not found, recommended Item Specifics names and values will be returned. The Item Specifics name passed in this field is case-sensitive, and wildcards are not supported.
 * <br><br>
 * <br> <B>Input property:</B> <code>CategorySpecific</code> - This container can be used instead of, or in conjunction with <b>CategoryID</b> values specified at the call request root level. The <b>CategorySpecific</b> container can actually be more powerful since you can pass in multiple Category ID and Item Specifics name combinations, and if you specify <b>CategoryID</b> values at the root level, only one (Item Specifics) <b>Name</b> value can be used.
 * <br><br>
 * A <b>GetCategorySpecifics</b> call request requires at least one of the following: a <b>CategoryID</b> value, a <b>CategorySpecifics.CategoryID</b> value, or the
 * <b>CategorySpecificsFileInfo</b> field with its value set to <code>true</code>. <b>CategoryID</b> values and
 * <b>CategorySpecific.CategoryID</b> values can both be used in the same request.
 * <br><br>
 * Keep in mind that a high number of specified categories can result in
 * longer response times and larger result sets. If your call request happens to time out, you might want specify fewer categories. If any
 * <b>CategorySpecifics.CategoryID</b> values are specified more than once, only the first instance will be used.
 * <br> <B>Input property:</B> <code>ExcludeRelationships</code> - If this boolean field is included and set to <code>true</code>, the <b>Relationship</b> container will not be returned for any Item Specifics name or value recommendations. Relationship recommendations tell you whether an Item Specific has a logical dependency another Item Specific.
 * <br> <br>
 * For example, in a clothing category, Size Type could be
 * recommended as a parent of Size, because Size=Small would
 * mean something different to buyers depending on whether
 * Size Type=Petite or Size Type=Plus.<br>
 * <br>
 * In general, it is a good idea to retrieve and use relationship
 * recommendations, as this data can help buyers find the items
 * they want more easily.
 * <br> <B>Input property:</B> <code>IncludeConfidence</code> - If this boolean field is included and set to <code>true</code>, eBay's level of confidence in the popularity of each Item Specific name and value for the specified category is returned in the response. Some sellers may find this useful when choosing whether to use eBay's recommendation or their own Item Specifics names or values.
 * <br> <br>
 * If this field is used, either one or more <b>CategoryID</b> values and/or one or more <b>CategorySpecific.CategoryID</b> values must be specified. If you try to use this field solely with the <b>CategorySpecificsFileInfo</b> field, the request fails and no <b>TaskReferenceID</b> or <b>FileReferenceID</b> values are returned.
 * <br> <B>Input property:</B> <code>CategorySpecificsFileInfo</code> - If this boolean field is included and set to <code>true</code>, the response includes a <b>FileReferenceID</b> and
 * <b>TaskReferenceID</b> value. Use these identifiers as inputs to the <b>downloadFile</b>
 * call in the eBay File Transfer API. That API lets you retrieve
 * a single (bulk) <b>GetCategorySpecifics</b> response with all the Item
 * Specifics recommendations available for the requested site ID.
 * (The <b>downloadFile</b> call downloads a .zip file as an
 * attachment.)<br>
 * <br>
 * Either the <b>CategorySpecificsFileInfo</b> field or one or more <b>CategoryID</b> and/or <b>CategorySpecific.CategoryID</b> values are required
 * in a <b>GetCategorySpecifics</b> call. <br>
 * <br>
 * <span class="tablenote"><b>Note:</b>
 * You can use the File Transfer API without using or learning
 * about the Bulk Data Exchange API or other
 * Large Merchant Services APIs.
 * </span>
 * <br> <B>Output property:</B> <code>ReturnedRecommendations</code> - This container provide details about relevant Item Specifics for the specified category. Required Item Specifics are generally returned at the top of the response payload, followed by the other most common/popular Item Specifics for the category. If an Item Specific is required, a  <b>MinValues</b> field will be returned with a value of <code>1</code>, and the corresponding <b>UsageConstraint</b> field will show a value of <code>Required</code>. Optional Item Specifics are returned after required and recommended Item Specifics, but sellers should still provide any optional Item Specific name-value pairs if known and relevant for the product.
 * <br>
 * <br>
 * As mentioned above, the most relevant Item Specifics are returned first, and similarly, if an Item Specific
 * has multiple suggested values, these values are sorted according to popularity (most popular to less popular/common).<br>
 * <br>
 * This node returns empty (or it's not returned) for a category if
 * there is no applicable data (such as when you request a parent category, a category that has no popular Item Specifics yet,
 * or a duplicate category that was already returned).
 * If you pass in the <b>CategoryID</b> and <b>Name</b> fields together, but no
 * matching values are found for the name, eBay returns the name
 * with no values (even if the name is not recommended).<br>
 * <br>
 * If <b>GetCategoryFeatures</b> indicates that Item Specifics are
 * enabled for a leaf category, but <b>GetCategorySpecifics</b> doesn't
 * return any recommendations for that category, the seller can still
 * specify their own Item Specifics in that category.
 * <br> <B>Output property:</B> <code>ReturnedTaskReferenceID</code> - A <b>TaskReferenceID</b> and a <b>FileReferenceID</b> value are returned if the <b>CategorySpecificsFileInfo</b> field is included in the call request and set to <code>true</code>. These values will be used as inputs in the <b>downloadFile</b> call of the File Transfer API. That API lets you retrieve a single (bulk) <b>GetCategorySpecifics</b> response with all the Item Specifics recommendations available for the requested site ID. (The <b>downloadFile</b> call downloads a .zip file as an attachment.)
 * <br> <B>Output property:</B> <code>ReturnedFileReferenceID</code> - A <b>TaskReferenceID</b> and a <b>FileReferenceID</b> value are returned if the <b>CategorySpecificsFileInfo</b> field is included in the call request and set to <code>true</code>. These values will be used as inputs in the <b>downloadFile</b> call of the File Transfer API. That API lets you retrieve a single (bulk) <b>GetCategorySpecifics</b> response with all the Item Specifics recommendations available for the requested site ID. (The <b>downloadFile</b> call downloads a .zip file as an attachment.)
 * 
 * @author Ron Murphy
 * @version 1.0
 */

public class GetCategorySpecificsCall extends com.ebay.sdk.ApiCall
{
  
  private String[] categoryID = null;
  private Calendar lastUpdateTime = null;
  private Integer maxNames = null;
  private Integer maxValuesPerName = null;
  private String name = null;
  private CategoryItemSpecificsType[] categorySpecific = null;
  private Boolean excludeRelationships = null;
  private Boolean includeConfidence = null;
  private Boolean categorySpecificsFileInfo = null;
  private RecommendationsType[] returnedRecommendations=null;
  private String returnedTaskReferenceID=null;
  private String returnedFileReferenceID=null;


  /**
   * Constructor.
   */
  public GetCategorySpecificsCall() {
  }

  /**
   * Constructor.
   * @param apiContext The ApiContext object to be used to make the call.
   */
  public GetCategorySpecificsCall(ApiContext apiContext) {
    super(apiContext);
    

  }

  /**
   * This is the base request type for the <b>GetCategorySpecifics</b> call. This call is used to retrieve recommended Item Specifics names and values for one or multiple eBay Categories.
   * 
   * <br>
   * @throws ApiException
   * @throws SdkException
   * @throws Exception
   * @return The RecommendationsType[] object.
   */
  public RecommendationsType[] getCategorySpecifics()
      throws com.ebay.sdk.ApiException, com.ebay.sdk.SdkException, java.lang.Exception
  {
    GetCategorySpecificsRequestType req;
    req = new GetCategorySpecificsRequestType();
    if (this.categoryID != null)
      req.setCategoryID(this.categoryID);
    if (this.lastUpdateTime != null)
      req.setLastUpdateTime(this.lastUpdateTime);
    if (this.maxNames != null)
      req.setMaxNames(this.maxNames);
    if (this.maxValuesPerName != null)
      req.setMaxValuesPerName(this.maxValuesPerName);
    if (this.name != null)
      req.setName(this.name);
    if (this.categorySpecific != null)
      req.setCategorySpecific(this.categorySpecific);
    if (this.excludeRelationships != null)
      req.setExcludeRelationships(this.excludeRelationships);
    if (this.includeConfidence != null)
      req.setIncludeConfidence(this.includeConfidence);
    if (this.categorySpecificsFileInfo != null)
      req.setCategorySpecificsFileInfo(this.categorySpecificsFileInfo);

    GetCategorySpecificsResponseType resp = (GetCategorySpecificsResponseType) execute(req);

    this.returnedRecommendations = resp.getRecommendations();
    this.returnedTaskReferenceID = resp.getTaskReferenceID();
    this.returnedFileReferenceID = resp.getFileReferenceID();
    return this.getReturnedRecommendations();
  }

  /**
   * Gets the GetCategorySpecificsRequestType.categoryID.
   * @return String[]
   */
  public String[] getCategoryID()
  {
    return this.categoryID;
  }

  /**
   * Sets the GetCategorySpecificsRequestType.categoryID.
   * @param categoryID String[]
   */
  public void setCategoryID(String[] categoryID)
  {
    this.categoryID = categoryID;
  }

  /**
   * Gets the GetCategorySpecificsRequestType.categorySpecific.
   * @return CategoryItemSpecificsType[]
   */
  public CategoryItemSpecificsType[] getCategorySpecific()
  {
    return this.categorySpecific;
  }

  /**
   * Sets the GetCategorySpecificsRequestType.categorySpecific.
   * @param categorySpecific CategoryItemSpecificsType[]
   */
  public void setCategorySpecific(CategoryItemSpecificsType[] categorySpecific)
  {
    this.categorySpecific = categorySpecific;
  }

  /**
   * Gets the GetCategorySpecificsRequestType.categorySpecificsFileInfo.
   * @return Boolean
   */
  public Boolean getCategorySpecificsFileInfo()
  {
    return this.categorySpecificsFileInfo;
  }

  /**
   * Sets the GetCategorySpecificsRequestType.categorySpecificsFileInfo.
   * @param categorySpecificsFileInfo Boolean
   */
  public void setCategorySpecificsFileInfo(Boolean categorySpecificsFileInfo)
  {
    this.categorySpecificsFileInfo = categorySpecificsFileInfo;
  }

  /**
   * Gets the GetCategorySpecificsRequestType.excludeRelationships.
   * @return Boolean
   */
  public Boolean getExcludeRelationships()
  {
    return this.excludeRelationships;
  }

  /**
   * Sets the GetCategorySpecificsRequestType.excludeRelationships.
   * @param excludeRelationships Boolean
   */
  public void setExcludeRelationships(Boolean excludeRelationships)
  {
    this.excludeRelationships = excludeRelationships;
  }

  /**
   * Gets the GetCategorySpecificsRequestType.includeConfidence.
   * @return Boolean
   */
  public Boolean getIncludeConfidence()
  {
    return this.includeConfidence;
  }

  /**
   * Sets the GetCategorySpecificsRequestType.includeConfidence.
   * @param includeConfidence Boolean
   */
  public void setIncludeConfidence(Boolean includeConfidence)
  {
    this.includeConfidence = includeConfidence;
  }

  /**
   * Gets the GetCategorySpecificsRequestType.lastUpdateTime.
   * @return Calendar
   */
  public Calendar getLastUpdateTime()
  {
    return this.lastUpdateTime;
  }

  /**
   * Sets the GetCategorySpecificsRequestType.lastUpdateTime.
   * @param lastUpdateTime Calendar
   */
  public void setLastUpdateTime(Calendar lastUpdateTime)
  {
    this.lastUpdateTime = lastUpdateTime;
  }

  /**
   * Gets the GetCategorySpecificsRequestType.maxNames.
   * @return Integer
   */
  public Integer getMaxNames()
  {
    return this.maxNames;
  }

  /**
   * Sets the GetCategorySpecificsRequestType.maxNames.
   * @param maxNames Integer
   */
  public void setMaxNames(Integer maxNames)
  {
    this.maxNames = maxNames;
  }

  /**
   * Gets the GetCategorySpecificsRequestType.maxValuesPerName.
   * @return Integer
   */
  public Integer getMaxValuesPerName()
  {
    return this.maxValuesPerName;
  }

  /**
   * Sets the GetCategorySpecificsRequestType.maxValuesPerName.
   * @param maxValuesPerName Integer
   */
  public void setMaxValuesPerName(Integer maxValuesPerName)
  {
    this.maxValuesPerName = maxValuesPerName;
  }

  /**
   * Gets the GetCategorySpecificsRequestType.name.
   * @return String
   */
  public String getName()
  {
    return this.name;
  }

  /**
   * Sets the GetCategorySpecificsRequestType.name.
   * @param name String
   */
  public void setName(String name)
  {
    this.name = name;
  }

  /**
   * Valid after executing the API.
   * Gets the returned GetCategorySpecificsResponseType.returnedFileReferenceID.
   * 
   * @return String
   */
  public String getReturnedFileReferenceID()
  {
    return this.returnedFileReferenceID;
  }

  /**
   * Valid after executing the API.
   * Gets the returned GetCategorySpecificsResponseType.returnedRecommendations.
   * 
   * @return RecommendationsType[]
   */
  public RecommendationsType[] getReturnedRecommendations()
  {
    return this.returnedRecommendations;
  }

  /**
   * Valid after executing the API.
   * Gets the returned GetCategorySpecificsResponseType.returnedTaskReferenceID.
   * 
   * @return String
   */
  public String getReturnedTaskReferenceID()
  {
    return this.returnedTaskReferenceID;
  }

}

