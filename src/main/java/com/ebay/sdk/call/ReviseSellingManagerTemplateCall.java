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
import java.lang.Long;
import java.lang.String;

import com.ebay.sdk.*;
import com.ebay.soap.eBLBaseComponents.*;
/**
 * Wrapper class of the ReviseSellingManagerTemplate call of eBay SOAP API.
 * <br>
 * <p>Title: SOAP API wrapper library.</p>
 * <p>Description: Contains wrapper classes for eBay SOAP APIs.</p>
 * <p>Copyright: Copyright (c) 2009</p>
 * <p>Company: eBay Inc.</p>
 * <br> <B>Input property:</B> <code>SaleTemplateID</code> - The unique identifier of the Selling Manager template. You can obtain a
 * <b>SaleTemplateID</b> value by calling <b>GetSellingManagerInventory</b>.
 * <br> <B>Input property:</B> <code>ProductID</code> - Reserved for future use.
 * <br> <B>Input property:</B> <code>SaleTemplateName</code> - The name of the Selling Manager template.
 * <br> <B>Input property:</B> <code>Item</code> - This container is used to modify the Selling Manager template. In the <b>Item.ItemID</b> field, you specify the same value as the
 * one specified in <b>SaleTemplateID</b>.
 * Other child elements hold the values for properties that are being changed.
 * Set values in the Item object only for those properties that are
 * changing. Use <b>DeletedField</b> to remove a property.
 * <br> <B>Input property:</B> <code>DeletedField</code> - Specifies the name of a field to remove from a template.
 * See the eBay Web Services guide for rules on removing values when revising items.
 * Also see the relevant field descriptions to determine when to use DeletedField (and potential consequences).
 * The request can contain zero, one, or many instances of DeletedField (one for each field to be removed).
 * DeletedField accepts the following path names, which remove the corresponding fields:
 * <br><br>
 * Item.ApplicationData<br>
 * Item.AttributeSetArray<br>
 * Item.ConditionID<br>
 * Item.ItemSpecifics<br>
 * Item.ListingCheckoutRedirectPreference.ProStoresStoreName<br>
 * Item.ListingCheckoutRedirectPreference.SellerThirdPartyUsername<br>
 * Item.ListingDesigner.LayoutID<br>
 * Item.ListingDesigner.ThemeID<br>
 * Item.ListingEnhancement[Value]<br>
 * Item.PayPalEmailAddress<br>
 * Item.PictureDetails.GalleryURL<br>
 * Item.PictureDetails.PictureURL<br>
 * Item.PostalCode<br>
 * Item.ProductListingDetails<br>
 * item.ShippingDetails.PaymentInstructions<br>
 * item.SKU<br>
 * Item.SubTitle<br><br>
 * These values are case-sensitive. Use values that match the case of the schema element names
 * (Item.PictureDetails.GalleryURL) or make the initial letter of each field name lowercase (item.pictureDetails.galleryURL).
 * However, do not change the case of letters in the middle of a field name (e.g., item.picturedetails.galleryUrl is not allowed).
 * <br><br>
 * Depending on how you have configured your pictures, you cannot necessarily delete
 * both GalleryURL and PictureURL from an existing listing.
 * If GalleryType was already set for the item you are revising, you cannot remove it.
 * This means you still need to include either a first picture
 * or a gallery URL in your revised listing.
 * <br> <B>Input property:</B> <code>VerifyOnly</code> - Use this field to verify the template instead of revising it.
 * <br> <B>Output property:</B> <code>ReturnedSaleTemplateID</code> - This sale template ID uniquely identifies the template that was revised
 * in the request. This sale template ID should match the
 * template ID specified in the request.
 * specified for the call.
 * <br> <B>Output property:</B> <code>ReturnedFees</code> - Child elements contain the estimated listing fees for the revised item
 * listing. The fees do not include the Final Value Fee (FVF), which cannot
 * be determined until an item is sold. Revising an item does not itself
 * incur a fee. However, certain item properties are fee-based and result
 * in the return of fees in the call's response.
 * <br> <B>Output property:</B> <code>ReturnedCategoryID</code> - ID of the primary category in which the item was listed.
 * Only returned if you set Item.CategoryMappingAllowed to true in the request
 * and the ID passed in Item.PrimaryCategory was mapped to a new ID by eBay.
 * If the primary category has not changed or it has expired with no replacement,
 * CategoryID does not return a value.
 * <br> <B>Output property:</B> <code>ReturnedCategory2ID</code> - ID of the secondary category in which the item was listed.
 * Only returned if you set Item.CategoryMappingAllowed to true in the request
 * and the ID passed in Item.SecondaryCategory was mapped to a new ID by eBay.
 * If the secondary category has not changed or it has expired with no replacement,
 * Category2ID does not return a value.
 * <br> <B>Output property:</B> <code>ReturnedVerifyOnly</code> - Instead of revising, only verifies the template.
 * <br> <B>Output property:</B> <code>ReturnedSaleTemplateName</code> - The name of the sale template.
 * <br> <B>Output property:</B> <code>ReturnedSellingManagerProductDetails</code> - The details of the product that this template belongs to.
 * 
 * @author Ron Murphy
 * @version 1.0
 */

public class ReviseSellingManagerTemplateCall extends com.ebay.sdk.ApiCall
{
  
  private Long saleTemplateID = null;
  private Long productID = null;
  private String saleTemplateName = null;
  private ItemType item = null;
  private String[] deletedField = null;
  private Boolean verifyOnly = null;
  private Long returnedSaleTemplateID=null;
  private FeesType returnedFees=null;
  private String returnedCategoryID=null;
  private String returnedCategory2ID=null;
  private Boolean returnedVerifyOnly=null;
  private String returnedSaleTemplateName=null;
  private SellingManagerProductDetailsType returnedSellingManagerProductDetails=null;


  /**
   * Constructor.
   */
  public ReviseSellingManagerTemplateCall() {
  }

  /**
   * Constructor.
   * @param apiContext The ApiContext object to be used to make the call.
   */
  public ReviseSellingManagerTemplateCall(ApiContext apiContext) {
    super(apiContext);
    

  }

  /**
   * Revises a Selling Manager template.
   * This call is subject to change without notice; the
   * deprecation process is inapplicable to this call. The user must have a Selling Manager Pro subscription to use this call.
   * 
   * <br>
   * @throws ApiException
   * @throws SdkException
   * @throws Exception
   * @return The Long object.
   */
  public Long reviseSellingManagerTemplate()
      throws com.ebay.sdk.ApiException, com.ebay.sdk.SdkException, java.lang.Exception
  {
    ReviseSellingManagerTemplateRequestType req;
    req = new ReviseSellingManagerTemplateRequestType();
    if (this.saleTemplateID != null)
      req.setSaleTemplateID(this.saleTemplateID);
    if (this.productID != null)
      req.setProductID(this.productID);
    if (this.saleTemplateName != null)
      req.setSaleTemplateName(this.saleTemplateName);
    if (this.item != null)
      req.setItem(this.item);
    if (this.deletedField != null)
      req.setDeletedField(this.deletedField);
    if (this.verifyOnly != null)
      req.setVerifyOnly(this.verifyOnly);

    ReviseSellingManagerTemplateResponseType resp = (ReviseSellingManagerTemplateResponseType) execute(req);

    this.returnedSaleTemplateID = resp.getSaleTemplateID();
    this.returnedFees = resp.getFees();
    this.returnedCategoryID = resp.getCategoryID();
    this.returnedCategory2ID = resp.getCategory2ID();
    this.returnedVerifyOnly = resp.isVerifyOnly();
    this.returnedSaleTemplateName = resp.getSaleTemplateName();
    this.returnedSellingManagerProductDetails = resp.getSellingManagerProductDetails();
    return this.getReturnedSaleTemplateID();
  }

  /**
   * Gets the ReviseSellingManagerTemplateRequestType.deletedField.
   * @return String[]
   */
  public String[] getDeletedField()
  {
    return this.deletedField;
  }

  /**
   * Sets the ReviseSellingManagerTemplateRequestType.deletedField.
   * @param deletedField String[]
   */
  public void setDeletedField(String[] deletedField)
  {
    this.deletedField = deletedField;
  }

  /**
   * Gets the ReviseSellingManagerTemplateRequestType.item.
   * @return ItemType
   */
  public ItemType getItem()
  {
    return this.item;
  }

  /**
   * Sets the ReviseSellingManagerTemplateRequestType.item.
   * @param item ItemType
   */
  public void setItem(ItemType item)
  {
    this.item = item;
  }

  /**
   * Gets the ReviseSellingManagerTemplateRequestType.productID.
   * @return Long
   */
  public Long getProductID()
  {
    return this.productID;
  }

  /**
   * Sets the ReviseSellingManagerTemplateRequestType.productID.
   * @param productID Long
   */
  public void setProductID(Long productID)
  {
    this.productID = productID;
  }

  /**
   * Gets the ReviseSellingManagerTemplateRequestType.saleTemplateID.
   * @return Long
   */
  public Long getSaleTemplateID()
  {
    return this.saleTemplateID;
  }

  /**
   * Sets the ReviseSellingManagerTemplateRequestType.saleTemplateID.
   * @param saleTemplateID Long
   */
  public void setSaleTemplateID(Long saleTemplateID)
  {
    this.saleTemplateID = saleTemplateID;
  }

  /**
   * Gets the ReviseSellingManagerTemplateRequestType.saleTemplateName.
   * @return String
   */
  public String getSaleTemplateName()
  {
    return this.saleTemplateName;
  }

  /**
   * Sets the ReviseSellingManagerTemplateRequestType.saleTemplateName.
   * @param saleTemplateName String
   */
  public void setSaleTemplateName(String saleTemplateName)
  {
    this.saleTemplateName = saleTemplateName;
  }

  /**
   * Gets the ReviseSellingManagerTemplateRequestType.verifyOnly.
   * @return Boolean
   */
  public Boolean getVerifyOnly()
  {
    return this.verifyOnly;
  }

  /**
   * Sets the ReviseSellingManagerTemplateRequestType.verifyOnly.
   * @param verifyOnly Boolean
   */
  public void setVerifyOnly(Boolean verifyOnly)
  {
    this.verifyOnly = verifyOnly;
  }

  /**
   * Valid after executing the API.
   * Gets the returned ReviseSellingManagerTemplateResponseType.returnedCategory2ID.
   * 
   * @return String
   */
  public String getReturnedCategory2ID()
  {
    return this.returnedCategory2ID;
  }

  /**
   * Valid after executing the API.
   * Gets the returned ReviseSellingManagerTemplateResponseType.returnedCategoryID.
   * 
   * @return String
   */
  public String getReturnedCategoryID()
  {
    return this.returnedCategoryID;
  }

  /**
   * Valid after executing the API.
   * Gets the returned ReviseSellingManagerTemplateResponseType.returnedFees.
   * 
   * @return FeesType
   */
  public FeesType getReturnedFees()
  {
    return this.returnedFees;
  }

  /**
   * Valid after executing the API.
   * Gets the returned ReviseSellingManagerTemplateResponseType.returnedSaleTemplateID.
   * 
   * @return Long
   */
  public Long getReturnedSaleTemplateID()
  {
    return this.returnedSaleTemplateID;
  }

  /**
   * Valid after executing the API.
   * Gets the returned ReviseSellingManagerTemplateResponseType.returnedSaleTemplateName.
   * 
   * @return String
   */
  public String getReturnedSaleTemplateName()
  {
    return this.returnedSaleTemplateName;
  }

  /**
   * Valid after executing the API.
   * Gets the returned ReviseSellingManagerTemplateResponseType.returnedSellingManagerProductDetails.
   * 
   * @return SellingManagerProductDetailsType
   */
  public SellingManagerProductDetailsType getReturnedSellingManagerProductDetails()
  {
    return this.returnedSellingManagerProductDetails;
  }

  /**
   * Valid after executing the API.
   * Gets the returned ReviseSellingManagerTemplateResponseType.returnedVerifyOnly.
   * 
   * @return Boolean
   */
  public Boolean getReturnedVerifyOnly()
  {
    return this.returnedVerifyOnly;
  }

}

