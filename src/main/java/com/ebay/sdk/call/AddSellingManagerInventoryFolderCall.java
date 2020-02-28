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
import java.lang.String;

import com.ebay.sdk.*;
import com.ebay.soap.eBLBaseComponents.*;
/**
 * Wrapper class of the AddSellingManagerInventoryFolder call of eBay SOAP API.
 * <br>
 * <p>Title: SOAP API wrapper library.</p>
 * <p>Description: Contains wrapper classes for eBay SOAP APIs.</p>
 * <p>Copyright: Copyright (c) 2009</p>
 * <p>Company: eBay Inc.</p>
 * <br> <B>Input property:</B> <code>FolderName</code> - Name of the new Selling Manager inventory folder.
 * <br> <B>Input property:</B> <code>ParentFolderID</code> - Unique identifier of the parent Selling Manager inventory folder. If no <b>ParentFolderID</b> is submitted, the folder
 * is added at the root level.
 * <br> <B>Input property:</B> <code>Comment</code> - Contains comments that will be associated with this folder.
 * <br> <B>Output property:</B> <code>ReturnedFolderID</code> - The unique identifier of the newly created Selling Manager Inventory Folder. This field will generally be returned unless the call is not successful at creating the new folder.
 * 
 * @author Ron Murphy
 * @version 1.0
 */

public class AddSellingManagerInventoryFolderCall extends com.ebay.sdk.ApiCall
{
  
  private String folderName = null;
  private Long parentFolderID = null;
  private String comment = null;
  private Long returnedFolderID=null;


  /**
   * Constructor.
   */
  public AddSellingManagerInventoryFolderCall() {
  }

  /**
   * Constructor.
   * @param apiContext The ApiContext object to be used to make the call.
   */
  public AddSellingManagerInventoryFolderCall(ApiContext apiContext) {
    super(apiContext);
    

  }

  /**
   * Adds a new product folder to a user's Selling Manager account.
   * 
   * <br>
   * @throws ApiException
   * @throws SdkException
   * @throws Exception
   * @return The Long object.
   */
  public Long addSellingManagerInventoryFolder()
      throws com.ebay.sdk.ApiException, com.ebay.sdk.SdkException, java.lang.Exception
  {
    AddSellingManagerInventoryFolderRequestType req;
    req = new AddSellingManagerInventoryFolderRequestType();
    if (this.folderName != null)
      req.setFolderName(this.folderName);
    if (this.parentFolderID != null)
      req.setParentFolderID(this.parentFolderID);
    if (this.comment != null)
      req.setComment(this.comment);

    AddSellingManagerInventoryFolderResponseType resp = (AddSellingManagerInventoryFolderResponseType) execute(req);

    this.returnedFolderID = resp.getFolderID();
    return this.getReturnedFolderID();
  }

  /**
   * Gets the AddSellingManagerInventoryFolderRequestType.comment.
   * @return String
   */
  public String getComment()
  {
    return this.comment;
  }

  /**
   * Sets the AddSellingManagerInventoryFolderRequestType.comment.
   * @param comment String
   */
  public void setComment(String comment)
  {
    this.comment = comment;
  }

  /**
   * Gets the AddSellingManagerInventoryFolderRequestType.folderName.
   * @return String
   */
  public String getFolderName()
  {
    return this.folderName;
  }

  /**
   * Sets the AddSellingManagerInventoryFolderRequestType.folderName.
   * @param folderName String
   */
  public void setFolderName(String folderName)
  {
    this.folderName = folderName;
  }

  /**
   * Gets the AddSellingManagerInventoryFolderRequestType.parentFolderID.
   * @return Long
   */
  public Long getParentFolderID()
  {
    return this.parentFolderID;
  }

  /**
   * Sets the AddSellingManagerInventoryFolderRequestType.parentFolderID.
   * @param parentFolderID Long
   */
  public void setParentFolderID(Long parentFolderID)
  {
    this.parentFolderID = parentFolderID;
  }

  /**
   * Valid after executing the API.
   * Gets the returned AddSellingManagerInventoryFolderResponseType.returnedFolderID.
   * 
   * @return Long
   */
  public Long getReturnedFolderID()
  {
    return this.returnedFolderID;
  }

}

