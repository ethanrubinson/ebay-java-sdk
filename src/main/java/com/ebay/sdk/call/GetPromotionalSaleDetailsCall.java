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
 * Wrapper class of the GetPromotionalSaleDetails call of eBay SOAP API.
 * <br>
 * <p>Title: SOAP API wrapper library.</p>
 * <p>Description: Contains wrapper classes for eBay SOAP APIs.</p>
 * <p>Copyright: Copyright (c) 2009</p>
 * <p>Company: eBay Inc.</p>
 * <br> <B>Input property:</B> <code>PromotionalSaleID</code> - The unique identifier of the promotional sale to retrieve. This field is used if the eBay store owner only wants to retrieve a specific promotional sale. Any <b>PromotionalSaleStatus</b> fields that are included will be ignored if the <b>PromotionalSaleID</b> field is used.
 * <br><br>
 * If neither the <b>PromotionalSaleID</b> nor a <b>PromotionalSaleStatus</b> field is used, then all promotional sales for the eBay store owner are returned.
 * <br> <B>Input property:</B> <code>PromotionalSaleStatus</code> - One or more <b>PromotionalSaleStatus</b> fields are used if the eBay store owner wants to retrieve promotional sales in a specific state, such as <code>Active</code>, <code>Scheduled</code>, or <code>Deleted</code>. A <b>PromotionalSaleStatus</b> field is included for each status. See <a href="types/PromotionalSaleStatusCodeType.html">PromotionalSaleStatusCodeType</a> for a description of the status values that can be used in this field.
 * <br><br>
 * If neither the <b>PromotionalSaleID</b> nor a <b>PromotionalSaleStatus</b> field is used, then all promotional sales for the eBay store owner are returned.
 * <br> <B>Output property:</B> <code>ReturnedPromotionalSaleDetails</code> - This container consists of an array of one or more promotional sales for an eBay store owner. A <b>PromotionalSaleDetails.PromotionalSale</b> container is returned for each promotional sale that matches the input criteria in the call request.
 * 
 * @author Ron Murphy
 * @version 1.0
 */

public class GetPromotionalSaleDetailsCall extends com.ebay.sdk.ApiCall
{
  
  private Long promotionalSaleID = null;
  private PromotionalSaleStatusCodeType[] promotionalSaleStatus = null;
  private PromotionalSaleArrayType returnedPromotionalSaleDetails=null;


  /**
   * Constructor.
   */
  public GetPromotionalSaleDetailsCall() {
  }

  /**
   * Constructor.
   * @param apiContext The ApiContext object to be used to make the call.
   */
  public GetPromotionalSaleDetailsCall(ApiContext apiContext) {
    super(apiContext);
    

  }

  /**
   * The base request type for the <b>GetPromotionalSaleDetails</b> call. This call retrieves information about promotional sales set up by an eBay store owner. The eBay store owner has the option to retrieve all promotional sales, a specific promotional sale, or promotional sales in a specific state.
   * 
   * <br>
   * @throws ApiException
   * @throws SdkException
   * @throws Exception
   * @return The PromotionalSaleArrayType object.
   */
  public PromotionalSaleArrayType getPromotionalSaleDetails()
      throws com.ebay.sdk.ApiException, com.ebay.sdk.SdkException, java.lang.Exception
  {
    GetPromotionalSaleDetailsRequestType req;
    req = new GetPromotionalSaleDetailsRequestType();
    if (this.promotionalSaleID != null)
      req.setPromotionalSaleID(this.promotionalSaleID);
    if (this.promotionalSaleStatus != null)
      req.setPromotionalSaleStatus(this.promotionalSaleStatus);

    GetPromotionalSaleDetailsResponseType resp = (GetPromotionalSaleDetailsResponseType) execute(req);

    this.returnedPromotionalSaleDetails = resp.getPromotionalSaleDetails();
    return this.getReturnedPromotionalSaleDetails();
  }

  /**
   * Gets the GetPromotionalSaleDetailsRequestType.promotionalSaleID.
   * @return Long
   */
  public Long getPromotionalSaleID()
  {
    return this.promotionalSaleID;
  }

  /**
   * Sets the GetPromotionalSaleDetailsRequestType.promotionalSaleID.
   * @param promotionalSaleID Long
   */
  public void setPromotionalSaleID(Long promotionalSaleID)
  {
    this.promotionalSaleID = promotionalSaleID;
  }

  /**
   * Gets the GetPromotionalSaleDetailsRequestType.promotionalSaleStatus.
   * @return PromotionalSaleStatusCodeType[]
   */
  public PromotionalSaleStatusCodeType[] getPromotionalSaleStatus()
  {
    return this.promotionalSaleStatus;
  }

  /**
   * Sets the GetPromotionalSaleDetailsRequestType.promotionalSaleStatus.
   * @param promotionalSaleStatus PromotionalSaleStatusCodeType[]
   */
  public void setPromotionalSaleStatus(PromotionalSaleStatusCodeType[] promotionalSaleStatus)
  {
    this.promotionalSaleStatus = promotionalSaleStatus;
  }

  /**
   * Valid after executing the API.
   * Gets the returned GetPromotionalSaleDetailsResponseType.returnedPromotionalSaleDetails.
   * 
   * @return PromotionalSaleArrayType
   */
  public PromotionalSaleArrayType getReturnedPromotionalSaleDetails()
  {
    return this.returnedPromotionalSaleDetails;
  }

}

