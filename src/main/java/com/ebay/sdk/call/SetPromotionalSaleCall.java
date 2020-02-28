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
 * Wrapper class of the SetPromotionalSale call of eBay SOAP API.
 * <br>
 * <p>Title: SOAP API wrapper library.</p>
 * <p>Description: Contains wrapper classes for eBay SOAP APIs.</p>
 * <p>Copyright: Copyright (c) 2009</p>
 * <p>Company: eBay Inc.</p>
 * <br> <B>Input property:</B> <code>Action</code> - The seller must include this field and set it to 'Add' to create a new promotional sale, or set it to 'Update' to modify an existing promotional sale, or set it to 'Delete' to delete a promotional sale.
 * <br> <B>Input property:</B> <code>PromotionalSaleDetails</code> - This container must be included in each <b>SetPromotionalSale</b> call. The fields of this container that will be used will depend on whether the seller is adding a new promotional sale, updating an existing promotional sale, or deleting an existing promotional sale.
 * <br> <B>Output property:</B> <code>ReturnedStatus</code> - The enumeration value in this field indicates the status of the promotional sale action (add or delete). See <b>PromotionalSaleStatusCodeType</b> for more information on status values.
 * <br> <B>Output property:</B> <code>ReturnedPromotionalSaleID</code> - The unique identifier of the new promotional sale, or in the case of a delete or modify action, the unique identifier of the existing promotional sale that was deleted or modified.
 * 
 * @author Ron Murphy
 * @version 1.0
 */

public class SetPromotionalSaleCall extends com.ebay.sdk.ApiCall
{
  
  private ModifyActionCodeType action = null;
  private PromotionalSaleType promotionalSaleDetails = null;
  private PromotionalSaleStatusCodeType returnedStatus=null;
  private Long returnedPromotionalSaleID=null;


  /**
   * Constructor.
   */
  public SetPromotionalSaleCall() {
  }

  /**
   * Constructor.
   * @param apiContext The ApiContext object to be used to make the call.
   */
  public SetPromotionalSaleCall(ApiContext apiContext) {
    super(apiContext);
    

  }

  /**
   * Creates or modifies a promotional sale. Promotional sales enable sellers
   * to apply discounts and/or free shipping across many listings. To use this call, the seller must be a registered eBay Store owner.
   * 
   * <br>
   * @throws ApiException
   * @throws SdkException
   * @throws Exception
   * @return The PromotionalSaleStatusCodeType object.
   */
  public PromotionalSaleStatusCodeType setPromotionalSale()
      throws com.ebay.sdk.ApiException, com.ebay.sdk.SdkException, java.lang.Exception
  {
    SetPromotionalSaleRequestType req;
    req = new SetPromotionalSaleRequestType();
    if (this.action != null)
      req.setAction(this.action);
    if (this.promotionalSaleDetails != null)
      req.setPromotionalSaleDetails(this.promotionalSaleDetails);

    SetPromotionalSaleResponseType resp = (SetPromotionalSaleResponseType) execute(req);

    this.returnedStatus = resp.getStatus();
    this.returnedPromotionalSaleID = resp.getPromotionalSaleID();
    return this.getReturnedStatus();
  }

  /**
   * Gets the SetPromotionalSaleRequestType.action.
   * @return ModifyActionCodeType
   */
  public ModifyActionCodeType getAction()
  {
    return this.action;
  }

  /**
   * Sets the SetPromotionalSaleRequestType.action.
   * @param action ModifyActionCodeType
   */
  public void setAction(ModifyActionCodeType action)
  {
    this.action = action;
  }

  /**
   * Gets the SetPromotionalSaleRequestType.promotionalSaleDetails.
   * @return PromotionalSaleType
   */
  public PromotionalSaleType getPromotionalSaleDetails()
  {
    return this.promotionalSaleDetails;
  }

  /**
   * Sets the SetPromotionalSaleRequestType.promotionalSaleDetails.
   * @param promotionalSaleDetails PromotionalSaleType
   */
  public void setPromotionalSaleDetails(PromotionalSaleType promotionalSaleDetails)
  {
    this.promotionalSaleDetails = promotionalSaleDetails;
  }

  /**
   * Valid after executing the API.
   * Gets the returned SetPromotionalSaleResponseType.returnedPromotionalSaleID.
   * 
   * @return Long
   */
  public Long getReturnedPromotionalSaleID()
  {
    return this.returnedPromotionalSaleID;
  }

  /**
   * Valid after executing the API.
   * Gets the returned SetPromotionalSaleResponseType.returnedStatus.
   * 
   * @return PromotionalSaleStatusCodeType
   */
  public PromotionalSaleStatusCodeType getReturnedStatus()
  {
    return this.returnedStatus;
  }

}

