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
 * Wrapper class of the GetSellingManagerInventoryFolder call of eBay SOAP API.
 * <br>
 * <p>Title: SOAP API wrapper library.</p>
 * <p>Description: Contains wrapper classes for eBay SOAP APIs.</p>
 * <p>Copyright: Copyright (c) 2009</p>
 * <p>Company: eBay Inc.</p>
 * <br> <B>Input property:</B> <code>FolderID</code> - A unique identifier for a Selling Manager Inventory folder. The <b>FolderID</b> is used if the seller wants to retrieve a specific folder.
 * <br> <B>Input property:</B> <code>MaxDepth</code> - This field is used to specify the number of levels of subfolders to be returned in the response. If 0, the parent folder is returned. If 1, the parent and child folders are returned. If 2, the parent and two levels of child folders are returned. Ignored if the <b>FullRecursion</b> field is included and set to <code>True</code>.
 * <br/>
 * <br> <B>Input property:</B> <code>FullRecursion</code> - Displays the entire tree of a user's Selling Manager Inventory folders. If this is provided, the <b>FolderID</b> and <b>MaxDepth</b> fields are no longer applicable.
 * <br> <B>Output property:</B> <code>ReturnedFolder</code> - This container consists of detailed information on the Selling Manager Inventory folder that matches the input criteria, as well as detailed information about any child folders if <b>FullRecursion</b> was set to <code>true</code> or if the <b>MaxDepth</b> field is set to an integer value greater than <code>0</code>.
 * 
 * @author Ron Murphy
 * @version 1.0
 */

public class GetSellingManagerInventoryFolderCall extends com.ebay.sdk.ApiCall
{
  
  private Long folderID = null;
  private Integer maxDepth = null;
  private Boolean fullRecursion = null;
  private SellingManagerFolderDetailsType returnedFolder=null;


  /**
   * Constructor.
   */
  public GetSellingManagerInventoryFolderCall() {
  }

  /**
   * Constructor.
   * @param apiContext The ApiContext object to be used to make the call.
   */
  public GetSellingManagerInventoryFolderCall(ApiContext apiContext) {
    super(apiContext);
    

  }

  /**
   * Retrieves Selling Manager Inventory folders.
   * This call is subject to change without notice; the deprecation process is
   * inapplicable to this call. The user must have a Selling Manager Pro subscription to use this call.
   * 
   * <br>
   * @throws ApiException
   * @throws SdkException
   * @throws Exception
   * @return The SellingManagerFolderDetailsType object.
   */
  public SellingManagerFolderDetailsType getSellingManagerInventoryFolder()
      throws com.ebay.sdk.ApiException, com.ebay.sdk.SdkException, java.lang.Exception
  {
    GetSellingManagerInventoryFolderRequestType req;
    req = new GetSellingManagerInventoryFolderRequestType();
    if (this.folderID != null)
      req.setFolderID(this.folderID);
    if (this.maxDepth != null)
      req.setMaxDepth(this.maxDepth);
    if (this.fullRecursion != null)
      req.setFullRecursion(this.fullRecursion);

    GetSellingManagerInventoryFolderResponseType resp = (GetSellingManagerInventoryFolderResponseType) execute(req);

    this.returnedFolder = resp.getFolder();
    return this.getReturnedFolder();
  }

  /**
   * Gets the GetSellingManagerInventoryFolderRequestType.folderID.
   * @return Long
   */
  public Long getFolderID()
  {
    return this.folderID;
  }

  /**
   * Sets the GetSellingManagerInventoryFolderRequestType.folderID.
   * @param folderID Long
   */
  public void setFolderID(Long folderID)
  {
    this.folderID = folderID;
  }

  /**
   * Gets the GetSellingManagerInventoryFolderRequestType.fullRecursion.
   * @return Boolean
   */
  public Boolean getFullRecursion()
  {
    return this.fullRecursion;
  }

  /**
   * Sets the GetSellingManagerInventoryFolderRequestType.fullRecursion.
   * @param fullRecursion Boolean
   */
  public void setFullRecursion(Boolean fullRecursion)
  {
    this.fullRecursion = fullRecursion;
  }

  /**
   * Gets the GetSellingManagerInventoryFolderRequestType.maxDepth.
   * @return Integer
   */
  public Integer getMaxDepth()
  {
    return this.maxDepth;
  }

  /**
   * Sets the GetSellingManagerInventoryFolderRequestType.maxDepth.
   * @param maxDepth Integer
   */
  public void setMaxDepth(Integer maxDepth)
  {
    this.maxDepth = maxDepth;
  }

  /**
   * Valid after executing the API.
   * Gets the returned GetSellingManagerInventoryFolderResponseType.returnedFolder.
   * 
   * @return SellingManagerFolderDetailsType
   */
  public SellingManagerFolderDetailsType getReturnedFolder()
  {
    return this.returnedFolder;
  }

}

