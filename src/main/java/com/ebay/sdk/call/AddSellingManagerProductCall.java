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
 * Wrapper class of the AddSellingManagerProduct call of eBay SOAP API.
 * <br>
 * <p>Title: SOAP API wrapper library.</p>
 * <p>Description: Contains wrapper classes for eBay SOAP APIs.</p>
 * <p>Copyright: Copyright (c) 2009</p>
 * <p>Company: eBay Inc.</p>
 * <br> <B>Input property:</B> <code>SellingManagerProductDetails</code> - This container is used to provide details about the Selling Manager product, such as product name, quantity available, and unit price.
 * <br> <B>Input property:</B> <code>FolderID</code> - This is the unique identifier of the folder in which the new product will be placed. This folder can be a new folder or a folder that already exists for the seller in Selling Manager Pro. If no folder is specified through this field, the new product is place into the <em>My Products</em> folder by default.
 * <br> <B>Input property:</B> <code>SellingManagerProductSpecifics</code> - This container allows the seller to specify item specifics for a product, to create a product variation group and variation specifics, and/or to specify a listing category for the product or product variation group. A product variation group can be transferred into a listing template that can create a multiple-variation listing. The listing category can either be provided through the <b>PrimaryCategoryID</b> value of this call, or through the <b>Item.PrimaryCategory.CategoryID</b> field of the subsequent <b>AddSellingManagerTemplate</b> call.
 * <br> <B>Output property:</B> <code>ReturnedSellingManagerProductDetails</code> - This container includes the same information that was passed into the <b>SellingManagerProductDetails</b> container in the request, as well as a new <b>ProductID</b> value if the new product was successfully created.
 * 
 * @author Ron Murphy
 * @version 1.0
 */

public class AddSellingManagerProductCall extends com.ebay.sdk.ApiCall
{
  
  private SellingManagerProductDetailsType sellingManagerProductDetails = null;
  private Long folderID = null;
  private SellingManagerProductSpecificsType sellingManagerProductSpecifics = null;
  private SellingManagerProductDetailsType returnedSellingManagerProductDetails=null;


  /**
   * Constructor.
   */
  public AddSellingManagerProductCall() {
  }

  /**
   * Constructor.
   * @param apiContext The ApiContext object to be used to make the call.
   */
  public AddSellingManagerProductCall(ApiContext apiContext) {
    super(apiContext);
    

  }

  /**
   * The base request type of the <b>AddSellingManagerProduct</b> call, which is used to create a product or a group of product variations within the Selling Manager Pro system. Once a Selling Manager Pro product or production variation group is created, the product settings and product specifics can be transferred over into a Selling Manager Pro listing template with the <b>AddSellingManagerTemplate</b> call.
   * 
   * <br>
   * @throws ApiException
   * @throws SdkException
   * @throws Exception
   * @return The SellingManagerProductDetailsType object.
   */
  public SellingManagerProductDetailsType addSellingManagerProduct()
      throws com.ebay.sdk.ApiException, com.ebay.sdk.SdkException, java.lang.Exception
  {
    AddSellingManagerProductRequestType req;
    req = new AddSellingManagerProductRequestType();
    if (this.sellingManagerProductDetails != null)
      req.setSellingManagerProductDetails(this.sellingManagerProductDetails);
    if (this.folderID != null)
      req.setFolderID(this.folderID);
    if (this.sellingManagerProductSpecifics != null)
      req.setSellingManagerProductSpecifics(this.sellingManagerProductSpecifics);

    AddSellingManagerProductResponseType resp = (AddSellingManagerProductResponseType) execute(req);

    this.returnedSellingManagerProductDetails = resp.getSellingManagerProductDetails();
    return this.getReturnedSellingManagerProductDetails();
  }

  /**
   * Gets the AddSellingManagerProductRequestType.folderID.
   * @return Long
   */
  public Long getFolderID()
  {
    return this.folderID;
  }

  /**
   * Sets the AddSellingManagerProductRequestType.folderID.
   * @param folderID Long
   */
  public void setFolderID(Long folderID)
  {
    this.folderID = folderID;
  }

  /**
   * Gets the AddSellingManagerProductRequestType.sellingManagerProductDetails.
   * @return SellingManagerProductDetailsType
   */
  public SellingManagerProductDetailsType getSellingManagerProductDetails()
  {
    return this.sellingManagerProductDetails;
  }

  /**
   * Sets the AddSellingManagerProductRequestType.sellingManagerProductDetails.
   * @param sellingManagerProductDetails SellingManagerProductDetailsType
   */
  public void setSellingManagerProductDetails(SellingManagerProductDetailsType sellingManagerProductDetails)
  {
    this.sellingManagerProductDetails = sellingManagerProductDetails;
  }

  /**
   * Gets the AddSellingManagerProductRequestType.sellingManagerProductSpecifics.
   * @return SellingManagerProductSpecificsType
   */
  public SellingManagerProductSpecificsType getSellingManagerProductSpecifics()
  {
    return this.sellingManagerProductSpecifics;
  }

  /**
   * Sets the AddSellingManagerProductRequestType.sellingManagerProductSpecifics.
   * @param sellingManagerProductSpecifics SellingManagerProductSpecificsType
   */
  public void setSellingManagerProductSpecifics(SellingManagerProductSpecificsType sellingManagerProductSpecifics)
  {
    this.sellingManagerProductSpecifics = sellingManagerProductSpecifics;
  }

  /**
   * Valid after executing the API.
   * Gets the returned AddSellingManagerProductResponseType.returnedSellingManagerProductDetails.
   * 
   * @return SellingManagerProductDetailsType
   */
  public SellingManagerProductDetailsType getReturnedSellingManagerProductDetails()
  {
    return this.returnedSellingManagerProductDetails;
  }

}

