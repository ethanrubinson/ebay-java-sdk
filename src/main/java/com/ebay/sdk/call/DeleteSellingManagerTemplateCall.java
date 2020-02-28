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
 * Wrapper class of the DeleteSellingManagerTemplate call of eBay SOAP API.
 * <br>
 * <p>Title: SOAP API wrapper library.</p>
 * <p>Description: Contains wrapper classes for eBay SOAP APIs.</p>
 * <p>Copyright: Copyright (c) 2009</p>
 * <p>Company: eBay Inc.</p>
 * <br> <B>Input property:</B> <code>SaleTemplateID</code> - Unique identifier of the Selling Manager template to be deleted.
 * You can obtain a <b>SaleTemplateID</b> by calling <b>GetSellingManagerInventory</b>.
 * <br> <B>Output property:</B> <code>ReturnedDeletedSaleTemplateID</code> - The unique identifier of the Selling Manager template.
 * <br> <B>Output property:</B> <code>ReturnedDeletedSaleTemplateName</code> - The name of the Selling Manager template.
 * 
 * @author Ron Murphy
 * @version 1.0
 */

public class DeleteSellingManagerTemplateCall extends com.ebay.sdk.ApiCall
{
  
  private Long saleTemplateID = null;
  private String returnedDeletedSaleTemplateID=null;
  private String returnedDeletedSaleTemplateName=null;


  /**
   * Constructor.
   */
  public DeleteSellingManagerTemplateCall() {
  }

  /**
   * Constructor.
   * @param apiContext The ApiContext object to be used to make the call.
   */
  public DeleteSellingManagerTemplateCall(ApiContext apiContext) {
    super(apiContext);
    

  }

  /**
   * Deletes a Selling Manager template.
   * This call is subject to change without notice; the
   * deprecation process is inapplicable to this call.
   * 
   * <br>
   * @throws ApiException
   * @throws SdkException
   * @throws Exception
   * @return The String object.
   */
  public String deleteSellingManagerTemplate()
      throws com.ebay.sdk.ApiException, com.ebay.sdk.SdkException, java.lang.Exception
  {
    DeleteSellingManagerTemplateRequestType req;
    req = new DeleteSellingManagerTemplateRequestType();
    if (this.saleTemplateID != null)
      req.setSaleTemplateID(this.saleTemplateID);

    DeleteSellingManagerTemplateResponseType resp = (DeleteSellingManagerTemplateResponseType) execute(req);

    this.returnedDeletedSaleTemplateID = resp.getDeletedSaleTemplateID();
    this.returnedDeletedSaleTemplateName = resp.getDeletedSaleTemplateName();
    return this.getReturnedDeletedSaleTemplateID();
  }

  /**
   * Gets the DeleteSellingManagerTemplateRequestType.saleTemplateID.
   * @return Long
   */
  public Long getSaleTemplateID()
  {
    return this.saleTemplateID;
  }

  /**
   * Sets the DeleteSellingManagerTemplateRequestType.saleTemplateID.
   * @param saleTemplateID Long
   */
  public void setSaleTemplateID(Long saleTemplateID)
  {
    this.saleTemplateID = saleTemplateID;
  }

  /**
   * Valid after executing the API.
   * Gets the returned DeleteSellingManagerTemplateResponseType.returnedDeletedSaleTemplateID.
   * 
   * @return String
   */
  public String getReturnedDeletedSaleTemplateID()
  {
    return this.returnedDeletedSaleTemplateID;
  }

  /**
   * Valid after executing the API.
   * Gets the returned DeleteSellingManagerTemplateResponseType.returnedDeletedSaleTemplateName.
   * 
   * @return String
   */
  public String getReturnedDeletedSaleTemplateName()
  {
    return this.returnedDeletedSaleTemplateName;
  }

}

