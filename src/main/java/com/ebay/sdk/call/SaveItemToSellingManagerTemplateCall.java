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
 * Wrapper class of the SaveItemToSellingManagerTemplate call of eBay SOAP API.
 * <br>
 * <p>Title: SOAP API wrapper library.</p>
 * <p>Description: Contains wrapper classes for eBay SOAP APIs.</p>
 * <p>Copyright: Copyright (c) 2009</p>
 * <p>Company: eBay Inc.</p>
 * <br> <B>Input property:</B> <code>ItemID</code> - The unique identifier of the eBay listing which should be used as a model to create the Selling Manager template and save it to Selling Manager inventory.
 * <br> <B>Input property:</B> <code>ProductID</code> - Associates the new template with a product.
 * <br> <B>Input property:</B> <code>TemplateName</code> - Name associated with the template. If no name is submitted, the template will be named automatically.
 * <br> <B>Output property:</B> <code>ReturnedTemplateID</code> - The unique identifier of the newly-created Selling Manager template. As long as the call was successful, this field is always returned.
 * 
 * @author Ron Murphy
 * @version 1.0
 */

public class SaveItemToSellingManagerTemplateCall extends com.ebay.sdk.ApiCall
{
  
  private String itemID = null;
  private Long productID = null;
  private String templateName = null;
  private Long returnedTemplateID=null;


  /**
   * Constructor.
   */
  public SaveItemToSellingManagerTemplateCall() {
  }

  /**
   * Constructor.
   * @param apiContext The ApiContext object to be used to make the call.
   */
  public SaveItemToSellingManagerTemplateCall(ApiContext apiContext) {
    super(apiContext);
    

  }

  /**
   * Creates a Selling Manager template based on an existing eBay listing.
   * This call is subject to change without notice; the
   * deprecation process is inapplicable to this call. The user must have a Selling Manager Pro subscription to use this call.
   * 
   * <br>
   * @throws ApiException
   * @throws SdkException
   * @throws Exception
   * @return The Long object.
   */
  public Long saveItemToSellingManagerTemplate()
      throws com.ebay.sdk.ApiException, com.ebay.sdk.SdkException, java.lang.Exception
  {
    SaveItemToSellingManagerTemplateRequestType req;
    req = new SaveItemToSellingManagerTemplateRequestType();
    if (this.itemID != null)
      req.setItemID(this.itemID);
    if (this.productID != null)
      req.setProductID(this.productID);
    if (this.templateName != null)
      req.setTemplateName(this.templateName);

    SaveItemToSellingManagerTemplateResponseType resp = (SaveItemToSellingManagerTemplateResponseType) execute(req);

    this.returnedTemplateID = resp.getTemplateID();
    return this.getReturnedTemplateID();
  }

  /**
   * Gets the SaveItemToSellingManagerTemplateRequestType.itemID.
   * @return String
   */
  public String getItemID()
  {
    return this.itemID;
  }

  /**
   * Sets the SaveItemToSellingManagerTemplateRequestType.itemID.
   * @param itemID String
   */
  public void setItemID(String itemID)
  {
    this.itemID = itemID;
  }

  /**
   * Gets the SaveItemToSellingManagerTemplateRequestType.productID.
   * @return Long
   */
  public Long getProductID()
  {
    return this.productID;
  }

  /**
   * Sets the SaveItemToSellingManagerTemplateRequestType.productID.
   * @param productID Long
   */
  public void setProductID(Long productID)
  {
    this.productID = productID;
  }

  /**
   * Gets the SaveItemToSellingManagerTemplateRequestType.templateName.
   * @return String
   */
  public String getTemplateName()
  {
    return this.templateName;
  }

  /**
   * Sets the SaveItemToSellingManagerTemplateRequestType.templateName.
   * @param templateName String
   */
  public void setTemplateName(String templateName)
  {
    this.templateName = templateName;
  }

  /**
   * Valid after executing the API.
   * Gets the returned SaveItemToSellingManagerTemplateResponseType.returnedTemplateID.
   * 
   * @return Long
   */
  public Long getReturnedTemplateID()
  {
    return this.returnedTemplateID;
  }

}

