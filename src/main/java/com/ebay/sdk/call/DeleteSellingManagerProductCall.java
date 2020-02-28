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
 * Wrapper class of the DeleteSellingManagerProduct call of eBay SOAP API.
 * <br>
 * <p>Title: SOAP API wrapper library.</p>
 * <p>Description: Contains wrapper classes for eBay SOAP APIs.</p>
 * <p>Copyright: Copyright (c) 2009</p>
 * <p>Company: eBay Inc.</p>
 * <br> <B>Input property:</B> <code>ProductID</code> - The unique identifier of the Selling Manager product to be deleted.
 * <br> <B>Output property:</B> <code>ReturnedDeletedSellingManagerProductDetails</code> - This container consists of the unique identifier and name of the Seller
 * Manager product.
 * 
 * @author Ron Murphy
 * @version 1.0
 */

public class DeleteSellingManagerProductCall extends com.ebay.sdk.ApiCall
{
  
  private Long productID = null;
  private SellingManagerProductDetailsType returnedDeletedSellingManagerProductDetails=null;


  /**
   * Constructor.
   */
  public DeleteSellingManagerProductCall() {
  }

  /**
   * Constructor.
   * @param apiContext The ApiContext object to be used to make the call.
   */
  public DeleteSellingManagerProductCall(ApiContext apiContext) {
    super(apiContext);
    

  }

  /**
   * Deletes a Selling Manager product.
   * This call is subject to change without notice; the
   * deprecation process is inapplicable to this call.
   * 
   * <br>
   * @throws ApiException
   * @throws SdkException
   * @throws Exception
   * @return The SellingManagerProductDetailsType object.
   */
  public SellingManagerProductDetailsType deleteSellingManagerProduct()
      throws com.ebay.sdk.ApiException, com.ebay.sdk.SdkException, java.lang.Exception
  {
    DeleteSellingManagerProductRequestType req;
    req = new DeleteSellingManagerProductRequestType();
    if (this.productID != null)
      req.setProductID(this.productID);

    DeleteSellingManagerProductResponseType resp = (DeleteSellingManagerProductResponseType) execute(req);

    this.returnedDeletedSellingManagerProductDetails = resp.getDeletedSellingManagerProductDetails();
    return this.getReturnedDeletedSellingManagerProductDetails();
  }

  /**
   * Gets the DeleteSellingManagerProductRequestType.productID.
   * @return Long
   */
  public Long getProductID()
  {
    return this.productID;
  }

  /**
   * Sets the DeleteSellingManagerProductRequestType.productID.
   * @param productID Long
   */
  public void setProductID(Long productID)
  {
    this.productID = productID;
  }

  /**
   * Valid after executing the API.
   * Gets the returned DeleteSellingManagerProductResponseType.returnedDeletedSellingManagerProductDetails.
   * 
   * @return SellingManagerProductDetailsType
   */
  public SellingManagerProductDetailsType getReturnedDeletedSellingManagerProductDetails()
  {
    return this.returnedDeletedSellingManagerProductDetails;
  }

}

