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
import java.lang.Long;

import com.ebay.sdk.*;
import com.ebay.soap.eBLBaseComponents.*;
/**
 * Wrapper class of the GetStore call of eBay SOAP API.
 * <br>
 * <p>Title: SOAP API wrapper library.</p>
 * <p>Description: Contains wrapper classes for eBay SOAP APIs.</p>
 * <p>Copyright: Copyright (c) 2009</p>
 * <p>Company: eBay Inc.</p>
 * <br> <B>Input property:</B> <code>CategoryStructureOnly</code> - Include this field and set its value to <code>true</code> if you wish to restrict the call response to only the store category hierarchy data. If this field is not included or set to <code>false</code>, store category hierarchy and all store configuration data is returned.
 * <br> <B>Input property:</B> <code>RootCategoryID</code> - The unique identifier of an eBay Store category. This field is used if the user wants to isolate the category hierarchy data to one particular eBay category (and its subcategories if applicable). The <b>LevelLimit</b> value will determine how many additional levels of categories are returned.
 * <br> <B>Input property:</B> <code>LevelLimit</code> - This field allows the seller to limit the number of levels of eBay Store categories that are returned. To return only top-level eBay Store categories, the user can include this field and set its value to <code>1</code> (and not use a <b>RootCategoryID</b> value). To retrieve a specific eBay Store Category and that category's child categories, the user could specify the unique eBay Store Category ID in the <b>RootCategoryID</b> field and then set the <b>LevelLimit</b> value to <code>2</code>.
 * <br/><br/>
 * If <b>LevelLimit</b> is omitted, the complete eBay Store Category hierarchy is returned, or all of specified store category's child categories. Currently, eBay Stores support only three levels of store categories.
 * <br> <B>Input property:</B> <code>UserID</code> - The unique identifier for an eBay Store owner. This field is only required if the user wants to view the eBay Store theme and category information for a different eBay Store owner. If this field is omitted, eBay Store theme and category information is returned for the eBay Store owner that is making the call.
 * <br> <B>Output property:</B> <code>ReturnedStoreType</code> - This container consists of detailed information on the seller's eBay Store. The amount of information in this container will partially depend on the settings made in the call request.
 * 
 * @author Ron Murphy
 * @version 1.0
 */

public class GetStoreCall extends com.ebay.sdk.ApiCall
{
  
  private Boolean categoryStructureOnly = null;
  private Long rootCategoryID = null;
  private Integer levelLimit = null;
  private String userID = null;
  private StoreType returnedStoreType=null;


  /**
   * Constructor.
   */
  public GetStoreCall() {
  }

  /**
   * Constructor.
   * @param apiContext The ApiContext object to be used to make the call.
   */
  public GetStoreCall(ApiContext apiContext) {
    super(apiContext);
    

  }

  /**
   * This call is used to retrieve detailed information on a seller's eBay Store, including store theme information and eBay Store category hierarchy.
   * 
   * <br>
   * @throws ApiException
   * @throws SdkException
   * @throws Exception
   * @return The void object.
   */
  public void getStore()
      throws com.ebay.sdk.ApiException, com.ebay.sdk.SdkException, java.lang.Exception
  {
    GetStoreRequestType req;
    req = new GetStoreRequestType();
    if (this.categoryStructureOnly != null)
      req.setCategoryStructureOnly(this.categoryStructureOnly);
    if (this.rootCategoryID != null)
      req.setRootCategoryID(this.rootCategoryID);
    if (this.levelLimit != null)
      req.setLevelLimit(this.levelLimit);
    if (this.userID != null)
      req.setUserID(this.userID);

    GetStoreResponseType resp = (GetStoreResponseType) execute(req);

    this.returnedStoreType = resp.getStore();

  }

  /**
   * Gets the GetStoreRequestType.categoryStructureOnly.
   * @return Boolean
   */
  public Boolean getCategoryStructureOnly()
  {
    return this.categoryStructureOnly;
  }

  /**
   * Sets the GetStoreRequestType.categoryStructureOnly.
   * @param categoryStructureOnly Boolean
   */
  public void setCategoryStructureOnly(Boolean categoryStructureOnly)
  {
    this.categoryStructureOnly = categoryStructureOnly;
  }

  /**
   * Gets the GetStoreRequestType.levelLimit.
   * @return Integer
   */
  public Integer getLevelLimit()
  {
    return this.levelLimit;
  }

  /**
   * Sets the GetStoreRequestType.levelLimit.
   * @param levelLimit Integer
   */
  public void setLevelLimit(Integer levelLimit)
  {
    this.levelLimit = levelLimit;
  }

  /**
   * Gets the GetStoreRequestType.rootCategoryID.
   * @return Long
   */
  public Long getRootCategoryID()
  {
    return this.rootCategoryID;
  }

  /**
   * Sets the GetStoreRequestType.rootCategoryID.
   * @param rootCategoryID Long
   */
  public void setRootCategoryID(Long rootCategoryID)
  {
    this.rootCategoryID = rootCategoryID;
  }

  /**
   * Gets the GetStoreRequestType.userID.
   * @return String
   */
  public String getUserID()
  {
    return this.userID;
  }

  /**
   * Sets the GetStoreRequestType.userID.
   * @param userID String
   */
  public void setUserID(String userID)
  {
    this.userID = userID;
  }

  /**
   * Valid after executing the API.
   * Gets the returned GetStoreResponseType.returnedStoreType.
   * 
   * @return StoreType
   */
  public StoreType getReturnedStoreType()
  {
    return this.returnedStoreType;
  }

}

