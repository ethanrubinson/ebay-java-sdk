/*
Copyright (c) 2013 eBay, Inc.
This program is licensed under the terms of the eBay Common Development and
Distribution License (CDDL) Version 1.0 (the "License") and any subsequent  version 
thereof released by eBay.  The then-current version of the License can be found 
at http://www.opensource.org/licenses/cddl1.php and in the eBaySDKLicense file that 
is under the eBay SDK ../docs directory.
*/

package com.ebay.sdk.call;


import com.ebay.sdk.*;
import com.ebay.soap.eBLBaseComponents.*;
/**
 * Wrapper class of the SetShippingDiscountProfiles call of eBay SOAP API.
 * <br>
 * <p>Title: SOAP API wrapper library.</p>
 * <p>Description: Contains wrapper classes for eBay SOAP APIs.</p>
 * <p>Copyright: Copyright (c) 2009</p>
 * <p>Company: eBay Inc.</p>
 * <br> <B>Input property:</B> <code>CurrencyID</code> - The three-digit code of the currency to be used for shipping discounts on  Combined Invoice orders. A discount profile can only be associated with a listing if the <b>CurrencyID</b> value of the profile matches the <b>Item.Currency</b> value specified in a listing. This field is required if the user is adding or updating one or more shipping discount profiles.
 * <br><br>
 * Note that There is a <b>currencyID</b> attribute on all   <b>SetShippingDiscountProfiles</b> elements involving money. To avoid a call error, be sure to use the same currency type in these attributes as what is set for the <b>CurrencyID</b> field.
 * <br> <B>Input property:</B> <code>CombinedDuration</code> - This field is used to specify the number of days after the purchase of an
 * item that the buyer or seller can combine multiple and mutual order
 * line items into one Combined Invoice order. In a Combined Invoice order,
 * the buyer makes one payment for all order line items, hence only unpaid
 * order line items can be combined into a Combined Invoice order.
 * <br> <B>Input property:</B> <code>ModifyActionCode</code> - This field is used to set which action is being taken (<code>Add</code>, <code>Update</code>, or <code>Delete</code>) in the call. If you are adding a shipping discount rule, you will have to supply a name for that shipping discount profile. If you want to update or delete a shipping discount profile, you'll have to provide the unique identifier of this rule through the corresponding containers. The unique identifiers of these rules can be retrieved with the <b>GetShippingDiscountRules</b> call, or the seller can view these identifiers in My eBay Shipping Preferences.
 * <br> <B>Input property:</B> <code>FlatShippingDiscount</code> - This container allows you to create, update, or delete a flat-rate shipping discount profile.
 * <br> <B>Input property:</B> <code>CalculatedShippingDiscount</code> - This container allows you to create, update, or delete a calculated shipping discount profile.
 * <br> <B>Input property:</B> <code>CalculatedHandlingDiscount</code> - This container allows you to create, update, or delete a calculated handling discount profile.
 * <br> <B>Input property:</B> <code>PromotionalShippingDiscountDetails</code> - This container allows you to create, update, or delete a promotional shipping discount profile.
 * <br> <B>Input property:</B> <code>ShippingInsurance</code> - This field is no longer applicable as it is not longer possible for a seller to offer a buyer shipping insurance.
 * <br> <B>Input property:</B> <code>InternationalShippingInsurance</code> - This field is no longer applicable as it is not longer possible for a seller to offer a buyer shipping insurance.
 * 
 * @author Ron Murphy
 * @version 1.0
 */

public class SetShippingDiscountProfilesCall extends com.ebay.sdk.ApiCall
{
  
  private CurrencyCodeType currencyID = null;
  private CombinedPaymentPeriodCodeType combinedDuration = null;
  private ModifyActionCodeType modifyActionCode = null;
  private FlatShippingDiscountType flatShippingDiscount = null;
  private CalculatedShippingDiscountType calculatedShippingDiscount = null;
  private CalculatedHandlingDiscountType calculatedHandlingDiscount = null;
  private PromotionalShippingDiscountDetailsType promotionalShippingDiscountDetails = null;
  private ShippingInsuranceType shippingInsurance = null;
  private ShippingInsuranceType internationalShippingInsurance = null;


  /**
   * Constructor.
   */
  public SetShippingDiscountProfilesCall() {
  }

  /**
   * Constructor.
   * @param apiContext The ApiContext object to be used to make the call.
   */
  public SetShippingDiscountProfilesCall(ApiContext apiContext) {
    super(apiContext);
    

  }

  /**
   * This call enables a seller to create and manage shipping discounts rules. These are the same shipping discount rules that can be created or managed in My eBay Shipping Preferences.
   * <br/><br/>
   * The types of shipping discount rules that can be created and managed with this call include flat-rate shipping rules, calculated shipping rules, and promotional shipping rules. This call can also be used by sellers to set whether or not they allow buyers to combine separate line items into one Combined Invoice order, and how many days they allow buyers to perform that action.
   * <br/><br/>
   * A seller can only create, update, or delete one discount rule type with each call. The action to take (either <code>Add</code>, <code>Update</code>, or <code>Delete</code>) is set and controlled with the <b>ModifyActionCode</b> field.
   * 
   * <br>
   * @throws ApiException
   * @throws SdkException
   * @throws Exception
   * @return The void object.
   */
  public void setShippingDiscountProfiles()
      throws com.ebay.sdk.ApiException, com.ebay.sdk.SdkException, java.lang.Exception
  {
    SetShippingDiscountProfilesRequestType req;
    req = new SetShippingDiscountProfilesRequestType();
    if (this.currencyID != null)
      req.setCurrencyID(this.currencyID);
    if (this.combinedDuration != null)
      req.setCombinedDuration(this.combinedDuration);
    if (this.modifyActionCode != null)
      req.setModifyActionCode(this.modifyActionCode);
    if (this.flatShippingDiscount != null)
      req.setFlatShippingDiscount(this.flatShippingDiscount);
    if (this.calculatedShippingDiscount != null)
      req.setCalculatedShippingDiscount(this.calculatedShippingDiscount);
    if (this.calculatedHandlingDiscount != null)
      req.setCalculatedHandlingDiscount(this.calculatedHandlingDiscount);
    if (this.promotionalShippingDiscountDetails != null)
      req.setPromotionalShippingDiscountDetails(this.promotionalShippingDiscountDetails);
    if (this.shippingInsurance != null)
      req.setShippingInsurance(this.shippingInsurance);
    if (this.internationalShippingInsurance != null)
      req.setInternationalShippingInsurance(this.internationalShippingInsurance);

    SetShippingDiscountProfilesResponseType resp = (SetShippingDiscountProfilesResponseType) execute(req);


  }

  /**
   * Gets the SetShippingDiscountProfilesRequestType.calculatedHandlingDiscount.
   * @return CalculatedHandlingDiscountType
   */
  public CalculatedHandlingDiscountType getCalculatedHandlingDiscount()
  {
    return this.calculatedHandlingDiscount;
  }

  /**
   * Sets the SetShippingDiscountProfilesRequestType.calculatedHandlingDiscount.
   * @param calculatedHandlingDiscount CalculatedHandlingDiscountType
   */
  public void setCalculatedHandlingDiscount(CalculatedHandlingDiscountType calculatedHandlingDiscount)
  {
    this.calculatedHandlingDiscount = calculatedHandlingDiscount;
  }

  /**
   * Gets the SetShippingDiscountProfilesRequestType.calculatedShippingDiscount.
   * @return CalculatedShippingDiscountType
   */
  public CalculatedShippingDiscountType getCalculatedShippingDiscount()
  {
    return this.calculatedShippingDiscount;
  }

  /**
   * Sets the SetShippingDiscountProfilesRequestType.calculatedShippingDiscount.
   * @param calculatedShippingDiscount CalculatedShippingDiscountType
   */
  public void setCalculatedShippingDiscount(CalculatedShippingDiscountType calculatedShippingDiscount)
  {
    this.calculatedShippingDiscount = calculatedShippingDiscount;
  }

  /**
   * Gets the SetShippingDiscountProfilesRequestType.combinedDuration.
   * @return CombinedPaymentPeriodCodeType
   */
  public CombinedPaymentPeriodCodeType getCombinedDuration()
  {
    return this.combinedDuration;
  }

  /**
   * Sets the SetShippingDiscountProfilesRequestType.combinedDuration.
   * @param combinedDuration CombinedPaymentPeriodCodeType
   */
  public void setCombinedDuration(CombinedPaymentPeriodCodeType combinedDuration)
  {
    this.combinedDuration = combinedDuration;
  }

  /**
   * Gets the SetShippingDiscountProfilesRequestType.currencyID.
   * @return CurrencyCodeType
   */
  public CurrencyCodeType getCurrencyID()
  {
    return this.currencyID;
  }

  /**
   * Sets the SetShippingDiscountProfilesRequestType.currencyID.
   * @param currencyID CurrencyCodeType
   */
  public void setCurrencyID(CurrencyCodeType currencyID)
  {
    this.currencyID = currencyID;
  }

  /**
   * Gets the SetShippingDiscountProfilesRequestType.flatShippingDiscount.
   * @return FlatShippingDiscountType
   */
  public FlatShippingDiscountType getFlatShippingDiscount()
  {
    return this.flatShippingDiscount;
  }

  /**
   * Sets the SetShippingDiscountProfilesRequestType.flatShippingDiscount.
   * @param flatShippingDiscount FlatShippingDiscountType
   */
  public void setFlatShippingDiscount(FlatShippingDiscountType flatShippingDiscount)
  {
    this.flatShippingDiscount = flatShippingDiscount;
  }

  /**
   * Gets the SetShippingDiscountProfilesRequestType.internationalShippingInsurance.
   * @return ShippingInsuranceType
   */
  public ShippingInsuranceType getInternationalShippingInsurance()
  {
    return this.internationalShippingInsurance;
  }

  /**
   * Sets the SetShippingDiscountProfilesRequestType.internationalShippingInsurance.
   * @param internationalShippingInsurance ShippingInsuranceType
   */
  public void setInternationalShippingInsurance(ShippingInsuranceType internationalShippingInsurance)
  {
    this.internationalShippingInsurance = internationalShippingInsurance;
  }

  /**
   * Gets the SetShippingDiscountProfilesRequestType.modifyActionCode.
   * @return ModifyActionCodeType
   */
  public ModifyActionCodeType getModifyActionCode()
  {
    return this.modifyActionCode;
  }

  /**
   * Sets the SetShippingDiscountProfilesRequestType.modifyActionCode.
   * @param modifyActionCode ModifyActionCodeType
   */
  public void setModifyActionCode(ModifyActionCodeType modifyActionCode)
  {
    this.modifyActionCode = modifyActionCode;
  }

  /**
   * Gets the SetShippingDiscountProfilesRequestType.promotionalShippingDiscountDetails.
   * @return PromotionalShippingDiscountDetailsType
   */
  public PromotionalShippingDiscountDetailsType getPromotionalShippingDiscountDetails()
  {
    return this.promotionalShippingDiscountDetails;
  }

  /**
   * Sets the SetShippingDiscountProfilesRequestType.promotionalShippingDiscountDetails.
   * @param promotionalShippingDiscountDetails PromotionalShippingDiscountDetailsType
   */
  public void setPromotionalShippingDiscountDetails(PromotionalShippingDiscountDetailsType promotionalShippingDiscountDetails)
  {
    this.promotionalShippingDiscountDetails = promotionalShippingDiscountDetails;
  }

  /**
   * Gets the SetShippingDiscountProfilesRequestType.shippingInsurance.
   * @return ShippingInsuranceType
   */
  public ShippingInsuranceType getShippingInsurance()
  {
    return this.shippingInsurance;
  }

  /**
   * Sets the SetShippingDiscountProfilesRequestType.shippingInsurance.
   * @param shippingInsurance ShippingInsuranceType
   */
  public void setShippingInsurance(ShippingInsuranceType shippingInsurance)
  {
    this.shippingInsurance = shippingInsurance;
  }

}

