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
 * Wrapper class of the AddSellingManagerTemplate call of eBay SOAP API.
 * <br>
 * <p>Title: SOAP API wrapper library.</p>
 * <p>Description: Contains wrapper classes for eBay SOAP APIs.</p>
 * <p>Copyright: Copyright (c) 2009</p>
 * <p>Company: eBay Inc.</p>
 * <br> <B>Input property:</B> <code>Item</code> - This <b>Item</b> container is similar to the one that is used in standard Add/Revise/Relist/Verify Item calls, with the difference being that some of the product-specific data/settings will be inherited through the Selling Manager product that is referenced in the call request, and not through this <b>Item</b> container. The data that is passed in this container will become part of the listing template that is created with this call.
 * <br> <B>Input property:</B> <code>SaleTemplateName</code> - The name of the Selling Manager listing template is provided in this field. If you don't specify a name, then the value in the <b>Item.Title</b> field will be used as the name instead.
 * <br> <B>Input property:</B> <code>ProductID</code> - The unique identifier of the Selling Manager product that will be associated with the listing template being created. Selling Manager Product IDs are returned in the response of a <b>AddSellingManagerProduct</b> call.
 * Alternatively, the <b>GetSellingManagerInventory</b> call can be used to retrieve active Selling Manager products for the user's account.
 * <br> <B>Output property:</B> <code>ReturnedCategoryID</code> - The unique identifier of the eBay category in which the product associated with the Selling Manager template will be listed. The primary listing category is provided through the <b>PrimaryCategoryID</b> field of an <b>AddSellingManagerProduct</b> call or through the <b>Item.PrimaryCategory.CategoryID</b> field.
 * <br> <B>Output property:</B> <code>ReturnedCategory2ID</code> - The unique identifier of the secondary eBay category in which the product associated with the Selling Manager template will be listed. This field will only be returned if defined through a <b>Item.SecondaryCategory.CategoryID</b> field.
 * <br> <B>Output property:</B> <code>ReturnedSaleTemplateID</code> - This is the unique identifier of the new Selling Manager template. This value is created by eBay upon successful creation of the Selling Manager template.
 * <br> <B>Output property:</B> <code>ReturnedSaleTemplateGroupID</code> - Ihis field is deprecated.
 * <br> <B>Output property:</B> <code>ReturnedSaleTemplateName</code> - This is the unique name of the newly created Selling Manager template. This name will be the value that was provided in the <b>SaleTemplateName</b> field of the call request. If the <b>SaleTemplateName</b> field was omitted the Selling Manager template inherits the name specified in the <b>Item.Title</b> field instead.
 * <br> <B>Output property:</B> <code>ReturnedSellingManagerProductDetails</code> - This container consists of details related to the Selling Manager product associated with the Selling Manager template, including the unique identifer, product name, and current quantity available.
 * <br> <B>Output property:</B> <code>ReturnedFees</code> - This container consists of listing fees that can be expected to be assessed against an eBay listing created with Selling Manager template. Each <b>Fee</b> container will contain the name of the listing fee, the expected amount, and any eBay promotional discount that will be applied towards the expected fee. The Final Value Fee (FVF) will never be returned in this container, as this fee cannot be determined until an item is sold.
 * 
 * @author Ron Murphy
 * @version 1.0
 */

public class AddSellingManagerTemplateCall extends com.ebay.sdk.ApiCall
{
  
  private ItemType item = null;
  private String saleTemplateName = null;
  private Long productID = null;
  private Long returnedCategoryID=null;
  private Long returnedCategory2ID=null;
  private Long returnedSaleTemplateID=null;
  private Long returnedSaleTemplateGroupID=null;
  private String returnedSaleTemplateName=null;
  private SellingManagerProductDetailsType returnedSellingManagerProductDetails=null;
  private FeesType returnedFees=null;


  /**
   * Constructor.
   */
  public AddSellingManagerTemplateCall() {
  }

  /**
   * Constructor.
   * @param apiContext The ApiContext object to be used to make the call.
   */
  public AddSellingManagerTemplateCall(ApiContext apiContext) {
    super(apiContext);
    

  }

  /**
   * The base request for the <b>AddSellingManagerTemplate</b> call, which is used to create a Selling Manager listing template. Each Selling Manager listing template must be associated with an existing Selling Manager product, and each product can have up to 20 listing templates associated with it.
   * 
   * <br>
   * @throws ApiException
   * @throws SdkException
   * @throws Exception
   * @return The Long object.
   */
  public Long addSellingManagerTemplate()
      throws com.ebay.sdk.ApiException, com.ebay.sdk.SdkException, java.lang.Exception
  {
    AddSellingManagerTemplateRequestType req;
    req = new AddSellingManagerTemplateRequestType();
    if (this.item != null)
      req.setItem(this.item);
    if (this.saleTemplateName != null)
      req.setSaleTemplateName(this.saleTemplateName);
    if (this.productID != null)
      req.setProductID(this.productID);

    AddSellingManagerTemplateResponseType resp = (AddSellingManagerTemplateResponseType) execute(req);

    this.returnedCategoryID = resp.getCategoryID();
    this.returnedCategory2ID = resp.getCategory2ID();
    this.returnedSaleTemplateID = resp.getSaleTemplateID();
    this.returnedSaleTemplateGroupID = resp.getSaleTemplateGroupID();
    this.returnedSaleTemplateName = resp.getSaleTemplateName();
    this.returnedSellingManagerProductDetails = resp.getSellingManagerProductDetails();
    this.returnedFees = resp.getFees();
    return this.getReturnedCategoryID();
  }

  /**
   * Gets the AddSellingManagerTemplateRequestType.item.
   * @return ItemType
   */
  public ItemType getItem()
  {
    return this.item;
  }

  /**
   * Sets the AddSellingManagerTemplateRequestType.item.
   * @param item ItemType
   */
  public void setItem(ItemType item)
  {
    this.item = item;
  }

  /**
   * Gets the AddSellingManagerTemplateRequestType.productID.
   * @return Long
   */
  public Long getProductID()
  {
    return this.productID;
  }

  /**
   * Sets the AddSellingManagerTemplateRequestType.productID.
   * @param productID Long
   */
  public void setProductID(Long productID)
  {
    this.productID = productID;
  }

  /**
   * Gets the AddSellingManagerTemplateRequestType.saleTemplateName.
   * @return String
   */
  public String getSaleTemplateName()
  {
    return this.saleTemplateName;
  }

  /**
   * Sets the AddSellingManagerTemplateRequestType.saleTemplateName.
   * @param saleTemplateName String
   */
  public void setSaleTemplateName(String saleTemplateName)
  {
    this.saleTemplateName = saleTemplateName;
  }

  /**
   * Valid after executing the API.
   * Gets the returned AddSellingManagerTemplateResponseType.returnedCategory2ID.
   * 
   * @return Long
   */
  public Long getReturnedCategory2ID()
  {
    return this.returnedCategory2ID;
  }

  /**
   * Valid after executing the API.
   * Gets the returned AddSellingManagerTemplateResponseType.returnedCategoryID.
   * 
   * @return Long
   */
  public Long getReturnedCategoryID()
  {
    return this.returnedCategoryID;
  }

  /**
   * Valid after executing the API.
   * Gets the returned AddSellingManagerTemplateResponseType.returnedFees.
   * 
   * @return FeesType
   */
  public FeesType getReturnedFees()
  {
    return this.returnedFees;
  }

  /**
   * Valid after executing the API.
   * Gets the returned AddSellingManagerTemplateResponseType.returnedSaleTemplateGroupID.
   * 
   * @return Long
   */
  public Long getReturnedSaleTemplateGroupID()
  {
    return this.returnedSaleTemplateGroupID;
  }

  /**
   * Valid after executing the API.
   * Gets the returned AddSellingManagerTemplateResponseType.returnedSaleTemplateID.
   * 
   * @return Long
   */
  public Long getReturnedSaleTemplateID()
  {
    return this.returnedSaleTemplateID;
  }

  /**
   * Valid after executing the API.
   * Gets the returned AddSellingManagerTemplateResponseType.returnedSaleTemplateName.
   * 
   * @return String
   */
  public String getReturnedSaleTemplateName()
  {
    return this.returnedSaleTemplateName;
  }

  /**
   * Valid after executing the API.
   * Gets the returned AddSellingManagerTemplateResponseType.returnedSellingManagerProductDetails.
   * 
   * @return SellingManagerProductDetailsType
   */
  public SellingManagerProductDetailsType getReturnedSellingManagerProductDetails()
  {
    return this.returnedSellingManagerProductDetails;
  }

}

