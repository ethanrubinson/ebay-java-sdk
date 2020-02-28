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
 * Wrapper class of the DeleteSellingManagerInventoryFolder call of eBay SOAP API.
 * <br>
 * <p>Title: SOAP API wrapper library.</p>
 * <p>Description: Contains wrapper classes for eBay SOAP APIs.</p>
 * <p>Copyright: Copyright (c) 2009</p>
 * <p>Company: eBay Inc.</p>
 * <br> <B>Input property:</B> <code>FolderID</code> - Unique ID of the Selling Manager Inventory folder to be deleted.
 * 
 * @author Ron Murphy
 * @version 1.0
 */

public class DeleteSellingManagerInventoryFolderCall extends com.ebay.sdk.ApiCall
{
  
  private Long folderID = null;


  /**
   * Constructor.
   */
  public DeleteSellingManagerInventoryFolderCall() {
  }

  /**
   * Constructor.
   * @param apiContext The ApiContext object to be used to make the call.
   */
  public DeleteSellingManagerInventoryFolderCall(ApiContext apiContext) {
    super(apiContext);
    

  }

  /**
   * Removes an inventory folder when a user deletes it in My eBay. This call is subject to change without notice; the deprecation process is inapplicable to this call.
   * 
   * <br>
   * @throws ApiException
   * @throws SdkException
   * @throws Exception
   * @return The void object.
   */
  public void deleteSellingManagerInventoryFolder()
      throws com.ebay.sdk.ApiException, com.ebay.sdk.SdkException, java.lang.Exception
  {
    DeleteSellingManagerInventoryFolderRequestType req;
    req = new DeleteSellingManagerInventoryFolderRequestType();
    if (this.folderID != null)
      req.setFolderID(this.folderID);

    DeleteSellingManagerInventoryFolderResponseType resp = (DeleteSellingManagerInventoryFolderResponseType) execute(req);


  }

  /**
   * Gets the DeleteSellingManagerInventoryFolderRequestType.folderID.
   * @return Long
   */
  public Long getFolderID()
  {
    return this.folderID;
  }

  /**
   * Sets the DeleteSellingManagerInventoryFolderRequestType.folderID.
   * @param folderID Long
   */
  public void setFolderID(Long folderID)
  {
    this.folderID = folderID;
  }

}

