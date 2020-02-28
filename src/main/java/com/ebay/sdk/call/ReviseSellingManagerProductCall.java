/*
Copyright (c) 2013 eBay, Inc.
This program is licensed under the terms of the eBay Common Development and
Distribution License (CDDL) Version 1.0 (the "License") and any subsequent  version 
thereof released by eBay.  The then-current version of the License can be found 
at http://www.opensource.org/licenses/cddl1.php and in the eBaySDKLicense file that 
is under the eBay SDK ../docs directory.
*/

package com.ebay.sdk.call;

import java.lang.String;

import com.ebay.sdk.*;
import com.ebay.soap.eBLBaseComponents.*;
/**
 * Wrapper class of the ReviseSellingManagerProduct call of eBay SOAP API.
 * <br>
 * <p>Title: SOAP API wrapper library.</p>
 * <p>Description: Contains wrapper classes for eBay SOAP APIs.</p>
 * <p>Copyright: Copyright (c) 2009</p>
 * <p>Company: eBay Inc.</p>
 * <br> <B>Input property:</B> <code>SellingManagerProductDetails</code> - The details of the product that is being revised.
 * <br> <B>Input property:</B> <code>SellingManagerFolderDetails</code> - The details of the folder for this product.
 * <br> <B>Input property:</B> <code>DeletedField</code> - Specifies the name of a field to remove from a Selling Manager product.
 * The request can contain zero, one, or many instances of DeletedField (one for each field to be removed).
 * DeletedField accepts the following path names, which remove the corresponding fields:<br><br>
 * SellingManagerProductDetails.CustomLabel<br>
 * SellingManagerProductDetails.QuantityAvailable<br>
 * SellingManagerProductDetails.UnitCost<br>
 * These values are case-sensitive. Use values that match the case of the schema element names.
 * <br> <B>Input property:</B> <code>SellingManagerProductSpecifics</code> - Specifies an eBay category associated with the product,
 * defines Item Specifics that are relevant to the product,
 * and defines variations available for the product
 * (which may be used to create multi-variation listings).
 * <br> <B>Output property:</B> <code>ReturnedSellingManagerProductDetails</code> - The details of the product.
 * 
 * @author Ron Murphy
 * @version 1.0
 */

public class ReviseSellingManagerProductCall extends com.ebay.sdk.ApiCall
{
  
  private SellingManagerProductDetailsType sellingManagerProductDetails = null;
  private SellingManagerFolderDetailsType sellingManagerFolderDetails = null;
  private String[] deletedField = null;
  private SellingManagerProductSpecificsType sellingManagerProductSpecifics = null;
  private SellingManagerProductDetailsType returnedSellingManagerProductDetails=null;


  /**
   * Constructor.
   */
  public ReviseSellingManagerProductCall() {
  }

  /**
   * Constructor.
   * @param apiContext The ApiContext object to be used to make the call.
   */
  public ReviseSellingManagerProductCall(ApiContext apiContext) {
    super(apiContext);
    

  }

  /**
   * Revises a Selling Manager Product.
   * <br><br>
   * This call is subject to change without notice; the
   * deprecation process is inapplicable to this call. The user must have a Selling Manager Pro subscription to use this call.
   * 
   * <br>
   * @throws ApiException
   * @throws SdkException
   * @throws Exception
   * @return The SellingManagerProductDetailsType object.
   */
  public SellingManagerProductDetailsType reviseSellingManagerProduct()
      throws com.ebay.sdk.ApiException, com.ebay.sdk.SdkException, java.lang.Exception
  {
    ReviseSellingManagerProductRequestType req;
    req = new ReviseSellingManagerProductRequestType();
    if (this.sellingManagerProductDetails != null)
      req.setSellingManagerProductDetails(this.sellingManagerProductDetails);
    if (this.sellingManagerFolderDetails != null)
      req.setSellingManagerFolderDetails(this.sellingManagerFolderDetails);
    if (this.deletedField != null)
      req.setDeletedField(this.deletedField);
    if (this.sellingManagerProductSpecifics != null)
      req.setSellingManagerProductSpecifics(this.sellingManagerProductSpecifics);

    ReviseSellingManagerProductResponseType resp = (ReviseSellingManagerProductResponseType) execute(req);

    this.returnedSellingManagerProductDetails = resp.getSellingManagerProductDetails();
    return this.getReturnedSellingManagerProductDetails();
  }

  /**
   * Gets the ReviseSellingManagerProductRequestType.deletedField.
   * @return String[]
   */
  public String[] getDeletedField()
  {
    return this.deletedField;
  }

  /**
   * Sets the ReviseSellingManagerProductRequestType.deletedField.
   * @param deletedField String[]
   */
  public void setDeletedField(String[] deletedField)
  {
    this.deletedField = deletedField;
  }

  /**
   * Gets the ReviseSellingManagerProductRequestType.sellingManagerFolderDetails.
   * @return SellingManagerFolderDetailsType
   */
  public SellingManagerFolderDetailsType getSellingManagerFolderDetails()
  {
    return this.sellingManagerFolderDetails;
  }

  /**
   * Sets the ReviseSellingManagerProductRequestType.sellingManagerFolderDetails.
   * @param sellingManagerFolderDetails SellingManagerFolderDetailsType
   */
  public void setSellingManagerFolderDetails(SellingManagerFolderDetailsType sellingManagerFolderDetails)
  {
    this.sellingManagerFolderDetails = sellingManagerFolderDetails;
  }

  /**
   * Gets the ReviseSellingManagerProductRequestType.sellingManagerProductDetails.
   * @return SellingManagerProductDetailsType
   */
  public SellingManagerProductDetailsType getSellingManagerProductDetails()
  {
    return this.sellingManagerProductDetails;
  }

  /**
   * Sets the ReviseSellingManagerProductRequestType.sellingManagerProductDetails.
   * @param sellingManagerProductDetails SellingManagerProductDetailsType
   */
  public void setSellingManagerProductDetails(SellingManagerProductDetailsType sellingManagerProductDetails)
  {
    this.sellingManagerProductDetails = sellingManagerProductDetails;
  }

  /**
   * Gets the ReviseSellingManagerProductRequestType.sellingManagerProductSpecifics.
   * @return SellingManagerProductSpecificsType
   */
  public SellingManagerProductSpecificsType getSellingManagerProductSpecifics()
  {
    return this.sellingManagerProductSpecifics;
  }

  /**
   * Sets the ReviseSellingManagerProductRequestType.sellingManagerProductSpecifics.
   * @param sellingManagerProductSpecifics SellingManagerProductSpecificsType
   */
  public void setSellingManagerProductSpecifics(SellingManagerProductSpecificsType sellingManagerProductSpecifics)
  {
    this.sellingManagerProductSpecifics = sellingManagerProductSpecifics;
  }

  /**
   * Valid after executing the API.
   * Gets the returned ReviseSellingManagerProductResponseType.returnedSellingManagerProductDetails.
   * 
   * @return SellingManagerProductDetailsType
   */
  public SellingManagerProductDetailsType getReturnedSellingManagerProductDetails()
  {
    return this.returnedSellingManagerProductDetails;
  }

}

