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
 * Wrapper class of the GetCategoryFeatures call of eBay SOAP API.
 * <br>
 * <p>Title: SOAP API wrapper library.</p>
 * <p>Description: Contains wrapper classes for eBay SOAP APIs.</p>
 * <p>Copyright: Copyright (c) 2009</p>
 * <p>Company: eBay Inc.</p>
 * <br> <B>Input property:</B> <code>CategoryID</code> - Specifies the category for which you want to retrieve the feature settings.
 * <br><br>
 * Specify a CategoryID, set DetailLevel to ReturnAll, and set
 * ViewAllNodes to true to return the default site settings, the
 * overrides for the specified category, plus all the child
 * categories that have overrides on the features they inherit.
 * <br><br>
 * If you also set AllFeaturesForCategory to true, eBay returns the site
 * defaults, plus all the settings for the specified category. Child
 * category information is not returned in this case.
 * <br><br>
 * If CategoryID is not specified, eBay returns the feature settings for
 * the site. To return details on all categories that have overrides on
 * the properties they inherit, set DetailLevel to ReturnAll, and set
 * ViewAllNodes to true. If you also set AllFeaturesForCategory to true,
 * eBay returns only the site defaults with no child category information.
 * <br> <B>Input property:</B> <code>LevelLimit</code> - This field is used if the user wants to control the maximum depth of the category hierarchy to retrieve, or in other words, how many levels of eBay categories that are returned in the response. If this field is omitted, and no <b>CategoryID</b> is specified, eBay feature metadata for every eBay category from the root on down will be returned. If this field is omitted, but a <b>CategoryID</b> is specified, the specified category and all of its children (down to the leaf categories) are returned.
 * <br>
 * <br>
 * If the <b>CategoryID</b> field is not used, but the <b>LevelLimit</b> field is used and set to <code>1</code>, eBay feature metadata is only returned for the top-level categories (also known as L1 categories).
 * <br> <B>Input property:</B> <code>ViewAllNodes</code> - You must set <b>DetailLevel</b> to <code>ReturnAll</code> in order to correctly populate the
 * response when you set <b>ViewAllNodes</b> to true. In this case, eBay returns the
 * site defaults along with all the categories that override the feature
 * settings they inherit. Here, each Category container shows only the
 * features that it has overridden from its parent node.
 * <br><br>
 * If you also specify a <b>CategoryID</b>, eBay returns the details for that category,
 * along with containers for each of its child categories that have feature
 * overrides.
 * <br><br>
 * Note that if <b>ViewAllNodes</b> is set to false (the default) and <b>DetailLevel</b> is
 * set to <code>ReturnAll</code>, eBay returns only the leaf categories that have features
 * that override the settings they inherit. In this case, the call will not
 * return leaf categories that do not have overrides.
 * <br> <B>Input property:</B> <code>FeatureIDs</code> - Use this field if you want to know if specific features are enabled at the site or root category level. Multiple <b>FeatureID</b> elements can be used in the request. If no <b>FeatureID</b> elements are used, the call retrieves data for all features, as applicable to the other request parameters.
 * <br> <B>Input property:</B> <code>AllFeaturesForCategory</code> - Use this switch to view all of the feature settings for a specific category.
 * All feature settings are returned, regardless of the site default settings.
 * This element works in conjunction with CategoryID--refer to the notes for
 * that element for more details.
 * <br><br>
 * If you also set FeatureID, eBay returns the status of the specified
 * features only, for the specified category.
 * <br> <B>Output property:</B> <code>ReturnedCategoryVersion</code> - Returns the current version of the set of feature meta-data.
 * Compare this value to the version of the last version you
 * downloaded to determine whether the data may have changed.
 * <br> <B>Output property:</B> <code>ReturnUpdateTime</code> - Gives the time in GMT that the feature flags for the
 * category hierarchy were last updated.
 * <br> <B>Output property:</B> <code>ReturnedCategory</code> - A category whose feature settings are different from the settings of its parent category.<br>
 * <br>
 * For example, suppose there is a branch of the category tree with 5 category levels
 * (L1, L2, L3, L4, and L5). Suppose the feature settings for SiteDefaults, L1, L4, and L5
 * are all "A", and the settings for L2 and L3 are "B". In this case:<br>
 * L1's settings (A) match the site default, so L1 is not returned.<br>
 * L2's settings (B) are different from L1's, so L2 is returned.<br>
 * L3's settings (B) are the same as L2's, so L3 is not returned<br>
 * L4's settings (A) are different from L3's, so L4 is returned<br>
 * L5's settings (A) are the same as L4's, so L5 is not returned.<br>
 * <br>
 * If you specified a particular FeatureID in the request, this field
 * only returns feature settings for that feature.
 * Only returned when the category is different from its parent.
 * If the category has children and they aren't returned,
 * it means the children inherit the category's feature settings.
 * <br> <B>Output property:</B> <code>ReturnedSiteDefaults</code> - Returns the feature settings defined for most categories on the site. Most categories share these settings. However, some categories can override some settings, as indicated in the Category nodes (if any).
 * <br> <B>Output property:</B> <code>ReturnedFeatureDefinitions</code> - Returns definitions of the various features on the site,
 * or the features you requested in FeatureID (if any).
 * Each feature has a node within FeatureDefinitions.
 * 
 * @author Ron Murphy
 * @version 1.0
 */

public class GetCategoryFeaturesCall extends com.ebay.sdk.ApiCall
{
  
  private String categoryID = null;
  private Integer levelLimit = null;
  private Boolean viewAllNodes = null;
  private FeatureIDCodeType[] featureIDs = null;
  private Boolean allFeaturesForCategory = null;
  private String returnedCategoryVersion=null;
  private Calendar returnUpdateTime=null;
  private CategoryFeatureType[] returnedCategory=null;
  private SiteDefaultsType returnedSiteDefaults=null;
  private FeatureDefinitionsType returnedFeatureDefinitions=null;


  /**
   * Constructor.
   */
  public GetCategoryFeaturesCall() {
  }

  /**
   * Constructor.
   * @param apiContext The ApiContext object to be used to make the call.
   */
  public GetCategoryFeaturesCall(ApiContext apiContext) {
    super(apiContext);
    

  }

  /**
   * Returns information about the features that are applicable to different categories,
   * such as listing durations, shipping term requirements, and Best Offer support.
   * 
   * <br>
   * @throws ApiException
   * @throws SdkException
   * @throws Exception
   * @return The void object.
   */
  public void getCategoryFeatures()
      throws com.ebay.sdk.ApiException, com.ebay.sdk.SdkException, java.lang.Exception
  {
    GetCategoryFeaturesRequestType req;
    req = new GetCategoryFeaturesRequestType();
    req.setDetailLevel(this.getDetailLevel());
    if (this.categoryID != null)
      req.setCategoryID(this.categoryID);
    if (this.levelLimit != null)
      req.setLevelLimit(this.levelLimit);
    if (this.viewAllNodes != null)
      req.setViewAllNodes(this.viewAllNodes);
    if (this.featureIDs != null)
      req.setFeatureID(this.featureIDs);
    if (this.allFeaturesForCategory != null)
      req.setAllFeaturesForCategory(this.allFeaturesForCategory);

    GetCategoryFeaturesResponseType resp = (GetCategoryFeaturesResponseType) execute(req);

    this.returnedCategoryVersion = resp.getCategoryVersion();
    this.returnUpdateTime = resp.getUpdateTime();
    this.returnedCategory = resp.getCategory();
    this.returnedSiteDefaults = resp.getSiteDefaults();
    this.returnedFeatureDefinitions = resp.getFeatureDefinitions();

  }

  /**
   * Gets the GetCategoryFeaturesRequestType.allFeaturesForCategory.
   * @return Boolean
   */
  public Boolean getAllFeaturesForCategory()
  {
    return this.allFeaturesForCategory;
  }

  /**
   * Sets the GetCategoryFeaturesRequestType.allFeaturesForCategory.
   * @param allFeaturesForCategory Boolean
   */
  public void setAllFeaturesForCategory(Boolean allFeaturesForCategory)
  {
    this.allFeaturesForCategory = allFeaturesForCategory;
  }

  /**
   * Gets the GetCategoryFeaturesRequestType.categoryID.
   * @return String
   */
  public String getCategoryID()
  {
    return this.categoryID;
  }

  /**
   * Sets the GetCategoryFeaturesRequestType.categoryID.
   * @param categoryID String
   */
  public void setCategoryID(String categoryID)
  {
    this.categoryID = categoryID;
  }

  /**
   * Gets the GetCategoryFeaturesRequestType.featureIDs.
   * @return FeatureIDCodeType[]
   */
  public FeatureIDCodeType[] getFeatureIDs()
  {
    return this.featureIDs;
  }

  /**
   * Sets the GetCategoryFeaturesRequestType.featureIDs.
   * @param featureIDs FeatureIDCodeType[]
   */
  public void setFeatureIDs(FeatureIDCodeType[] featureIDs)
  {
    this.featureIDs = featureIDs;
  }

  /**
   * Gets the GetCategoryFeaturesRequestType.levelLimit.
   * @return Integer
   */
  public Integer getLevelLimit()
  {
    return this.levelLimit;
  }

  /**
   * Sets the GetCategoryFeaturesRequestType.levelLimit.
   * @param levelLimit Integer
   */
  public void setLevelLimit(Integer levelLimit)
  {
    this.levelLimit = levelLimit;
  }

  /**
   * Gets the GetCategoryFeaturesRequestType.viewAllNodes.
   * @return Boolean
   */
  public Boolean getViewAllNodes()
  {
    return this.viewAllNodes;
  }

  /**
   * Sets the GetCategoryFeaturesRequestType.viewAllNodes.
   * @param viewAllNodes Boolean
   */
  public void setViewAllNodes(Boolean viewAllNodes)
  {
    this.viewAllNodes = viewAllNodes;
  }

  /**
   * Valid after executing the API.
   * Gets the returned GetCategoryFeaturesResponseType.returnUpdateTime.
   * 
   * @return Calendar
   */
  public Calendar getReturnUpdateTime()
  {
    return this.returnUpdateTime;
  }

  /**
   * Valid after executing the API.
   * Gets the returned GetCategoryFeaturesResponseType.returnedCategory.
   * 
   * @return CategoryFeatureType[]
   */
  public CategoryFeatureType[] getReturnedCategory()
  {
    return this.returnedCategory;
  }

  /**
   * Valid after executing the API.
   * Gets the returned GetCategoryFeaturesResponseType.returnedCategoryVersion.
   * 
   * @return String
   */
  public String getReturnedCategoryVersion()
  {
    return this.returnedCategoryVersion;
  }

  /**
   * Valid after executing the API.
   * Gets the returned GetCategoryFeaturesResponseType.returnedFeatureDefinitions.
   * 
   * @return FeatureDefinitionsType
   */
  public FeatureDefinitionsType getReturnedFeatureDefinitions()
  {
    return this.returnedFeatureDefinitions;
  }

  /**
   * Valid after executing the API.
   * Gets the returned GetCategoryFeaturesResponseType.returnedSiteDefaults.
   * 
   * @return SiteDefaultsType
   */
  public SiteDefaultsType getReturnedSiteDefaults()
  {
    return this.returnedSiteDefaults;
  }

}

