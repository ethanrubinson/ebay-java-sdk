/*
Copyright (c) 2013 eBay, Inc.
This program is licensed under the terms of the eBay Common Development and
Distribution License (CDDL) Version 1.0 (the "License") and any subsequent  version 
thereof released by eBay.  The then-current version of the License can be found 
at http://www.opensource.org/licenses/cddl1.php and in the eBaySDKLicense file that 
is under the eBay SDK ../docs directory.
*/

package com.ebay.sdk.call;

import java.lang.Long;

import com.ebay.sdk.*;
import com.ebay.soap.eBLBaseComponents.*;
/**
 * Wrapper class of the SetStoreCategories call of eBay SOAP API.
 * <br>
 * <p>Title: SOAP API wrapper library.</p>
 * <p>Description: Contains wrapper classes for eBay SOAP APIs.</p>
 * <p>Copyright: Copyright (c) 2009</p>
 * <p>Company: eBay Inc.</p>
 * <br> <B>Input property:</B> <code>Action</code> - Specifies the type of action (Add, Move, Delete, or Rename) to carry out
 * for the specified eBay Store categories.
 * <br> <B>Input property:</B> <code>ItemDestinationCategoryID</code> - Items can only be contained within child categories. A parent category
 * cannot contain items. If adding, moving, or deleting categories displaces
 * items, you must specify a destination child category under which the
 * displaced items will be moved. The destination category must have no
 * child categories.
 * <br> <B>Input property:</B> <code>DestinationParentCategoryID</code> - When adding or moving store categories, specifies the category under
 * which the listed categories will be located. To add or move categories to
 * the top level, set the value to -999.
 * <br> <B>Input property:</B> <code>StoreCategories</code> - Specifies the store categories on which to act.
 * <br> <B>Output property:</B> <code>ReturnedTaskID</code> - The task ID associated with the category structure change request. For a
 * simple change, the <b>SetStoreCategories</b> call is processed synchronously.
 * That is, simple changes are made immediately and then the response is
 * returned. For synchronous processing, the task ID in the response is 0.
 * If the category structure changes affect many listings, the changes will
 * be processed asynchronously and the task ID will be a positive number.
 * Use the non-zero task ID with <b>GetStoreCategoryUpdateStatus</b> to monitor
 * the status of asynchronously processed changes.
 * <br> <B>Output property:</B> <code>ReturnedStatus</code> - When an eBay Store category structure change is processed synchronously, the status
 * is returned as 'Complete' or 'Failed'. For asynchronously processed changes,
 * the status is reported as 'InProgress' or 'Pending'. Use <b>GetStoreCategoryUpdateStatus</b> to
 * monitor the status of asynchronously processed changes.
 * <br> <B>Output property:</B> <code>ReturnedCustomCategory</code> - Contains hierarchy data for eBay Store categories that you have created/modified.
 * 
 * @author Ron Murphy
 * @version 1.0
 */

public class SetStoreCategoriesCall extends com.ebay.sdk.ApiCall
{
  
  private StoreCategoryUpdateActionCodeType action = null;
  private Long itemDestinationCategoryID = null;
  private Long destinationParentCategoryID = null;
  private StoreCustomCategoryArrayType storeCategories = null;
  private long returnedTaskID=0;
  private TaskStatusCodeType returnedStatus=null;
  private StoreCustomCategoryArrayType returnedCustomCategory=null;


  /**
   * Constructor.
   */
  public SetStoreCategoriesCall() {
  }

  /**
   * Constructor.
   * @param apiContext The ApiContext object to be used to make the call.
   */
  public SetStoreCategoriesCall(ApiContext apiContext) {
    super(apiContext);
    

  }

  /**
   * This call allows you to set or modify the category structure of an eBay Store. Sellers must have an eBay Store subscription in order to use this call.
   * 
   * <br>
   * @throws ApiException
   * @throws SdkException
   * @throws Exception
   * @return The long object.
   */
  public long setStoreCategories()
      throws com.ebay.sdk.ApiException, com.ebay.sdk.SdkException, java.lang.Exception
  {
    SetStoreCategoriesRequestType req;
    req = new SetStoreCategoriesRequestType();
    if (this.action != null)
      req.setAction(this.action);
    if (this.itemDestinationCategoryID != null)
      req.setItemDestinationCategoryID(this.itemDestinationCategoryID);
    if (this.destinationParentCategoryID != null)
      req.setDestinationParentCategoryID(this.destinationParentCategoryID);
    if (this.storeCategories != null)
      req.setStoreCategories(this.storeCategories);

    SetStoreCategoriesResponseType resp = (SetStoreCategoriesResponseType) execute(req);

    this.returnedTaskID = (resp.getTaskID() == null? 0: resp.getTaskID().longValue());
    this.returnedStatus = resp.getStatus();
    this.returnedCustomCategory = resp.getCustomCategory();
    return this.getReturnedTaskID();
  }

  /**
   * Gets the SetStoreCategoriesRequestType.action.
   * @return StoreCategoryUpdateActionCodeType
   */
  public StoreCategoryUpdateActionCodeType getAction()
  {
    return this.action;
  }

  /**
   * Sets the SetStoreCategoriesRequestType.action.
   * @param action StoreCategoryUpdateActionCodeType
   */
  public void setAction(StoreCategoryUpdateActionCodeType action)
  {
    this.action = action;
  }

  /**
   * Gets the SetStoreCategoriesRequestType.destinationParentCategoryID.
   * @return Long
   */
  public Long getDestinationParentCategoryID()
  {
    return this.destinationParentCategoryID;
  }

  /**
   * Sets the SetStoreCategoriesRequestType.destinationParentCategoryID.
   * @param destinationParentCategoryID Long
   */
  public void setDestinationParentCategoryID(Long destinationParentCategoryID)
  {
    this.destinationParentCategoryID = destinationParentCategoryID;
  }

  /**
   * Gets the SetStoreCategoriesRequestType.itemDestinationCategoryID.
   * @return Long
   */
  public Long getItemDestinationCategoryID()
  {
    return this.itemDestinationCategoryID;
  }

  /**
   * Sets the SetStoreCategoriesRequestType.itemDestinationCategoryID.
   * @param itemDestinationCategoryID Long
   */
  public void setItemDestinationCategoryID(Long itemDestinationCategoryID)
  {
    this.itemDestinationCategoryID = itemDestinationCategoryID;
  }

  /**
   * Gets the SetStoreCategoriesRequestType.storeCategories.
   * @return StoreCustomCategoryArrayType
   */
  public StoreCustomCategoryArrayType getStoreCategories()
  {
    return this.storeCategories;
  }

  /**
   * Sets the SetStoreCategoriesRequestType.storeCategories.
   * @param storeCategories StoreCustomCategoryArrayType
   */
  public void setStoreCategories(StoreCustomCategoryArrayType storeCategories)
  {
    this.storeCategories = storeCategories;
  }

  /**
   * Valid after executing the API.
   * Gets the returned SetStoreCategoriesResponseType.returnedCustomCategory.
   * 
   * @return StoreCustomCategoryArrayType
   */
  public StoreCustomCategoryArrayType getReturnedCustomCategory()
  {
    return this.returnedCustomCategory;
  }

  /**
   * Valid after executing the API.
   * Gets the returned SetStoreCategoriesResponseType.returnedStatus.
   * 
   * @return TaskStatusCodeType
   */
  public TaskStatusCodeType getReturnedStatus()
  {
    return this.returnedStatus;
  }

  /**
   * Valid after executing the API.
   * Gets the returned SetStoreCategoriesResponseType.returnedTaskID.
   * 
   * @return long
   */
  public long getReturnedTaskID()
  {
    return this.returnedTaskID;
  }

}

