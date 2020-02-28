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

import com.ebay.sdk.*;
import com.ebay.soap.eBLBaseComponents.*;
/**
 * Wrapper class of the GetShippingDiscountProfiles call of eBay SOAP API.
 * <br>
 * <p>Title: SOAP API wrapper library.</p>
 * <p>Description: Contains wrapper classes for eBay SOAP APIs.</p>
 * <p>Copyright: Copyright (c) 2009</p>
 * <p>Company: eBay Inc.</p>
 * <br> <B>Output property:</B> <code>ReturnedCurrencyID</code> - The three-digit code of the currency to be used for shipping cost discounts. A discount profile can only be associated with a listing if the <b>CurrencyID</b> value of the profile matches the <b>Item.Currency</b> value specified in a listing.
 * <br> <B>Output property:</B> <code>ReturnedFlatShippingDiscount</code> - This container consists of one or more flat-rate shipping discount rules that are set up for a seller's account. This container is returned as an empty element if no flat-rate shipping discount rules are currently set for the seller's account.
 * <br> <B>Output property:</B> <code>ReturnedCalculatedShippingDiscount</code> - This container consists of one or more calculated shipping discount rules that are set up for a seller's account. This container is returned as an empty element if no calculated shipping discount rules are currently set for the seller's account.
 * <br> <B>Output property:</B> <code>ReturnedPromotionalShippingDiscount</code> - This field indicates whether or not a seller has set up a promotional shipping discount rule in the seller's account. Only one promotional shipping discount may be defined for a seller's account at any given time. This field is returned whether <code>false</code> or <code>true</code>. If <code>true</code>, details of the rule can be found in the <b>PromotionalShippingDiscountDetails</b> container.
 * <br> <B>Output property:</B> <code>ReturnedCalculatedHandlingDiscount</code> - This container consists of the handling discount applicable to a calculated shipping discount rule that is set up for a seller's account. This container is not returned if no calculated shipping discount rules are currently set for the seller's account.
 * <br> <B>Output property:</B> <code>ReturnedPromotionalShippingDiscountDetails</code> - This container consists of information related to the promotional shipping discount rule that is set up for a seller's account. This container is not returned if no promotional shipping discount rule is set up for the seller's account.
 * <br> <B>Output property:</B> <code>ReturnedShippingInsurance</code> - This container is deprecated.
 * <br> <B>Output property:</B> <code>ReturnedInternationalShippingInsurance</code> - This container is deprecated.
 * <br> <B>Output property:</B> <code>ReturnedCombinedDuration</code> - This field indicates the number of days after the sale of an item in which the buyer or seller can combine multiple and mutual order line items into one Combined Invoice order. In a Combined Invoice order, the buyer makes one payment for all order line items, hence only unpaid order line items can be combined into a Combined Invoice order.
 * 
 * @author Ron Murphy
 * @version 1.0
 */

public class GetShippingDiscountProfilesCall extends com.ebay.sdk.ApiCall
{
  
  private CurrencyCodeType returnedCurrencyID=null;
  private FlatShippingDiscountType returnedFlatShippingDiscount=null;
  private CalculatedShippingDiscountType returnedCalculatedShippingDiscount=null;
  private Boolean returnedPromotionalShippingDiscount=null;
  private CalculatedHandlingDiscountType returnedCalculatedHandlingDiscount=null;
  private PromotionalShippingDiscountDetailsType returnedPromotionalShippingDiscountDetails=null;
  private ShippingInsuranceType returnedShippingInsurance=null;
  private ShippingInsuranceType returnedInternationalShippingInsurance=null;
  private CombinedPaymentPeriodCodeType returnedCombinedDuration=null;


  /**
   * Constructor.
   */
  public GetShippingDiscountProfilesCall() {
  }

  /**
   * Constructor.
   * @param apiContext The ApiContext object to be used to make the call.
   */
  public GetShippingDiscountProfilesCall(ApiContext apiContext) {
    super(apiContext);
    

  }

  /**
   * This call retrieves all shipping discount profiles currently defined by the user, along with other Combined Invoice-related details such as packaging and handling costs.
   * 
   * <br>
   * @throws ApiException
   * @throws SdkException
   * @throws Exception
   * @return The CurrencyCodeType object.
   */
  public CurrencyCodeType getShippingDiscountProfiles()
      throws com.ebay.sdk.ApiException, com.ebay.sdk.SdkException, java.lang.Exception
  {
    GetShippingDiscountProfilesRequestType req;
    req = new GetShippingDiscountProfilesRequestType();

    GetShippingDiscountProfilesResponseType resp = (GetShippingDiscountProfilesResponseType) execute(req);

    this.returnedCurrencyID = resp.getCurrencyID();
    this.returnedFlatShippingDiscount = resp.getFlatShippingDiscount();
    this.returnedCalculatedShippingDiscount = resp.getCalculatedShippingDiscount();
    this.returnedPromotionalShippingDiscount = resp.isPromotionalShippingDiscount();
    this.returnedCalculatedHandlingDiscount = resp.getCalculatedHandlingDiscount();
    this.returnedPromotionalShippingDiscountDetails = resp.getPromotionalShippingDiscountDetails();
    this.returnedShippingInsurance = resp.getShippingInsurance();
    this.returnedInternationalShippingInsurance = resp.getInternationalShippingInsurance();
    this.returnedCombinedDuration = resp.getCombinedDuration();
    return this.getReturnedCurrencyID();
  }

  /**
   * Valid after executing the API.
   * Gets the returned GetShippingDiscountProfilesResponseType.returnedCalculatedHandlingDiscount.
   * 
   * @return CalculatedHandlingDiscountType
   */
  public CalculatedHandlingDiscountType getReturnedCalculatedHandlingDiscount()
  {
    return this.returnedCalculatedHandlingDiscount;
  }

  /**
   * Valid after executing the API.
   * Gets the returned GetShippingDiscountProfilesResponseType.returnedCalculatedShippingDiscount.
   * 
   * @return CalculatedShippingDiscountType
   */
  public CalculatedShippingDiscountType getReturnedCalculatedShippingDiscount()
  {
    return this.returnedCalculatedShippingDiscount;
  }

  /**
   * Valid after executing the API.
   * Gets the returned GetShippingDiscountProfilesResponseType.returnedCombinedDuration.
   * 
   * @return CombinedPaymentPeriodCodeType
   */
  public CombinedPaymentPeriodCodeType getReturnedCombinedDuration()
  {
    return this.returnedCombinedDuration;
  }

  /**
   * Valid after executing the API.
   * Gets the returned GetShippingDiscountProfilesResponseType.returnedCurrencyID.
   * 
   * @return CurrencyCodeType
   */
  public CurrencyCodeType getReturnedCurrencyID()
  {
    return this.returnedCurrencyID;
  }

  /**
   * Valid after executing the API.
   * Gets the returned GetShippingDiscountProfilesResponseType.returnedFlatShippingDiscount.
   * 
   * @return FlatShippingDiscountType
   */
  public FlatShippingDiscountType getReturnedFlatShippingDiscount()
  {
    return this.returnedFlatShippingDiscount;
  }

  /**
   * Valid after executing the API.
   * Gets the returned GetShippingDiscountProfilesResponseType.returnedInternationalShippingInsurance.
   * 
   * @return ShippingInsuranceType
   */
  public ShippingInsuranceType getReturnedInternationalShippingInsurance()
  {
    return this.returnedInternationalShippingInsurance;
  }

  /**
   * Valid after executing the API.
   * Gets the returned GetShippingDiscountProfilesResponseType.returnedPromotionalShippingDiscount.
   * 
   * @return Boolean
   */
  public Boolean getReturnedPromotionalShippingDiscount()
  {
    return this.returnedPromotionalShippingDiscount;
  }

  /**
   * Valid after executing the API.
   * Gets the returned GetShippingDiscountProfilesResponseType.returnedPromotionalShippingDiscountDetails.
   * 
   * @return PromotionalShippingDiscountDetailsType
   */
  public PromotionalShippingDiscountDetailsType getReturnedPromotionalShippingDiscountDetails()
  {
    return this.returnedPromotionalShippingDiscountDetails;
  }

  /**
   * Valid after executing the API.
   * Gets the returned GetShippingDiscountProfilesResponseType.returnedShippingInsurance.
   * 
   * @return ShippingInsuranceType
   */
  public ShippingInsuranceType getReturnedShippingInsurance()
  {
    return this.returnedShippingInsurance;
  }

}

