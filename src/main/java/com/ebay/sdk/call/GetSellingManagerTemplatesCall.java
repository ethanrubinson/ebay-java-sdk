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
 * Wrapper class of the GetSellingManagerTemplates call of eBay SOAP API.
 * <br>
 * <p>Title: SOAP API wrapper library.</p>
 * <p>Description: Contains wrapper classes for eBay SOAP APIs.</p>
 * <p>Copyright: Copyright (c) 2009</p>
 * <p>Company: eBay Inc.</p>
 * <br> <B>Input property:</B> <code>SaleTemplateID</code> - The unique identifier of the Selling Manager Template whose data will be returned. A Selling Manager Template contains the data needed to list an item. One or more template IDs can be specified, each in its own field. You can obtain a <b>SaleTemplateID</b> by calling <b>GetSellingManagerInventory</b>.
 * <br> <B>Output property:</B> <code>ReturnedSellingManagerTemplateDetailsArray</code> - This container consists of an array of Selling Manager Templates that match the input criteria.
 * 
 * @author Ron Murphy
 * @version 1.0
 */

public class GetSellingManagerTemplatesCall extends com.ebay.sdk.ApiCall
{
  
  private long[] saleTemplateID = null;
  private SellingManagerTemplateDetailsArrayType returnedSellingManagerTemplateDetailsArray=null;


  /**
   * Constructor.
   */
  public GetSellingManagerTemplatesCall() {
  }

  /**
   * Constructor.
   * @param apiContext The ApiContext object to be used to make the call.
   */
  public GetSellingManagerTemplatesCall(ApiContext apiContext) {
    super(apiContext);
    

  }

  /**
   * Retrieves Selling Manager templates. This call is subject to change without notice; the deprecation process is inapplicable to this call. The user must have a Selling Manager Pro subscription to use this call.
   * 
   * <br>
   * @throws ApiException
   * @throws SdkException
   * @throws Exception
   * @return The SellingManagerTemplateDetailsArrayType object.
   */
  public SellingManagerTemplateDetailsArrayType getSellingManagerTemplates()
      throws com.ebay.sdk.ApiException, com.ebay.sdk.SdkException, java.lang.Exception
  {
    GetSellingManagerTemplatesRequestType req;
    req = new GetSellingManagerTemplatesRequestType();
    if (this.saleTemplateID != null)
      req.setSaleTemplateID(this.saleTemplateID);

    GetSellingManagerTemplatesResponseType resp = (GetSellingManagerTemplatesResponseType) execute(req);

    this.returnedSellingManagerTemplateDetailsArray = resp.getSellingManagerTemplateDetailsArray();
    return this.getReturnedSellingManagerTemplateDetailsArray();
  }

  /**
   * Gets the GetSellingManagerTemplatesRequestType.saleTemplateID.
   * @return long[]
   */
  public long[] getSaleTemplateID()
  {
    return this.saleTemplateID;
  }

  /**
   * Sets the GetSellingManagerTemplatesRequestType.saleTemplateID.
   * @param saleTemplateID long[]
   */
  public void setSaleTemplateID(long[] saleTemplateID)
  {
    this.saleTemplateID = saleTemplateID;
  }

  /**
   * Valid after executing the API.
   * Gets the returned GetSellingManagerTemplatesResponseType.returnedSellingManagerTemplateDetailsArray.
   * 
   * @return SellingManagerTemplateDetailsArrayType
   */
  public SellingManagerTemplateDetailsArrayType getReturnedSellingManagerTemplateDetailsArray()
  {
    return this.returnedSellingManagerTemplateDetailsArray;
  }

}

