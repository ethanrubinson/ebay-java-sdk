/*
Copyright (c) 2013 eBay, Inc.
This program is licensed under the terms of the eBay Common Development and
Distribution License (CDDL) Version 1.0 (the "License") and any subsequent  version 
thereof released by eBay.  The then-current version of the License can be found 
at http://www.opensource.org/licenses/cddl1.php and in the eBaySDKLicense file that 
is under the eBay SDK ../docs directory.
*/

package com.ebay.sdk.call;


import com.ebay.sdk.*;
import com.ebay.soap.eBLBaseComponents.*;
/**
 * Wrapper class of the ReviseSellingManagerInventoryFolder call of eBay SOAP API.
 * <br>
 * <p>Title: SOAP API wrapper library.</p>
 * <p>Description: Contains wrapper classes for eBay SOAP APIs.</p>
 * <p>Copyright: Copyright (c) 2009</p>
 * <p>Company: eBay Inc.</p>
 * <br> <B>Input property:</B> <code>Folder</code> - This container is used to identify the Selling Manager Inventory folder that will be renamed and/or moved.
 * <br> <B>Output property:</B> <code>ReturnedFolder</code> - This container will show the results of the action made on the Selling Manager Inventory folder.
 * 
 * @author Ron Murphy
 * @version 1.0
 */

public class ReviseSellingManagerInventoryFolderCall extends com.ebay.sdk.ApiCall
{
  
  private SellingManagerFolderDetailsType folder = null;
  private SellingManagerFolderDetailsType returnedFolder=null;


  /**
   * Constructor.
   */
  public ReviseSellingManagerInventoryFolderCall() {
  }

  /**
   * Constructor.
   * @param apiContext The ApiContext object to be used to make the call.
   */
  public ReviseSellingManagerInventoryFolderCall(ApiContext apiContext) {
    super(apiContext);
    

  }

  /**
   * This call is uses to rename and/or move a Selling Manager Inventory folder.
   * This call is subject to change without notice; the deprecation process is
   * inapplicable to this call. The user must have a Selling Manager Pro subscription to use this call.
   * 
   * <br>
   * @throws ApiException
   * @throws SdkException
   * @throws Exception
   * @return The SellingManagerFolderDetailsType object.
   */
  public SellingManagerFolderDetailsType reviseSellingManagerInventoryFolder()
      throws com.ebay.sdk.ApiException, com.ebay.sdk.SdkException, java.lang.Exception
  {
    ReviseSellingManagerInventoryFolderRequestType req;
    req = new ReviseSellingManagerInventoryFolderRequestType();
    if (this.folder != null)
      req.setFolder(this.folder);

    ReviseSellingManagerInventoryFolderResponseType resp = (ReviseSellingManagerInventoryFolderResponseType) execute(req);

    this.returnedFolder = resp.getFolder();
    return this.getReturnedFolder();
  }

  /**
   * Gets the ReviseSellingManagerInventoryFolderRequestType.folder.
   * @return SellingManagerFolderDetailsType
   */
  public SellingManagerFolderDetailsType getFolder()
  {
    return this.folder;
  }

  /**
   * Sets the ReviseSellingManagerInventoryFolderRequestType.folder.
   * @param folder SellingManagerFolderDetailsType
   */
  public void setFolder(SellingManagerFolderDetailsType folder)
  {
    this.folder = folder;
  }

  /**
   * Valid after executing the API.
   * Gets the returned ReviseSellingManagerInventoryFolderResponseType.returnedFolder.
   * 
   * @return SellingManagerFolderDetailsType
   */
  public SellingManagerFolderDetailsType getReturnedFolder()
  {
    return this.returnedFolder;
  }

}

