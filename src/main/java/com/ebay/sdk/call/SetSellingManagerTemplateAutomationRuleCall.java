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
 * Wrapper class of the SetSellingManagerTemplateAutomationRule call of eBay SOAP API.
 * <br>
 * <p>Title: SOAP API wrapper library.</p>
 * <p>Description: Contains wrapper classes for eBay SOAP APIs.</p>
 * <p>Copyright: Copyright (c) 2009</p>
 * <p>Company: eBay Inc.</p>
 * <br> <B>Input property:</B> <code>SaleTemplateID</code> - The ID of the Selling Manager template whose automation rules you want to change. You can obtain a <b>SaleTemplateID</b> by calling <b>GetSellingManagerInventory</b>.
 * <br> <B>Input property:</B> <code>AutomatedListingRule</code> - The information for the automated listing rule to be associated with the template.
 * <br> <B>Input property:</B> <code>AutomatedRelistingRule</code> - The information for the automated relisting rule to be associated with the template.
 * <br> <B>Input property:</B> <code>AutomatedSecondChanceOfferRule</code> - The information for the automated Second Chance Offer rule to be associated with the template.
 * <br> <B>Output property:</B> <code>ReturnedAutomatedListingRule</code> - Contains the automated listing rule associated with this template.
 * <br> <B>Output property:</B> <code>ReturnedAutomatedRelistingRule</code> - Contains the automated relisting rule associated with this template.
 * <br> <B>Output property:</B> <code>ReturnedAutomatedSecondChanceOfferRule</code> - Contains the automated Second Chance Offer rule associated with this template.
 * <br> <B>Output property:</B> <code>ReturnedFees</code> - Contains fees that may be incurred when items are listed using the
 * automation rules (e.g., a scheduled listing fee). Use of an automation rule
 * does not in itself have a fee, but use can result in a fee.
 * 
 * @author Ron Murphy
 * @version 1.0
 */

public class SetSellingManagerTemplateAutomationRuleCall extends com.ebay.sdk.ApiCall
{
  
  private Long saleTemplateID = null;
  private SellingManagerAutoListType automatedListingRule = null;
  private SellingManagerAutoRelistType automatedRelistingRule = null;
  private SellingManagerAutoSecondChanceOfferType automatedSecondChanceOfferRule = null;
  private SellingManagerAutoListType returnedAutomatedListingRule=null;
  private SellingManagerAutoRelistType returnedAutomatedRelistingRule=null;
  private SellingManagerAutoSecondChanceOfferType returnedAutomatedSecondChanceOfferRule=null;
  private FeesType returnedFees=null;


  /**
   * Constructor.
   */
  public SetSellingManagerTemplateAutomationRuleCall() {
  }

  /**
   * Constructor.
   * @param apiContext The ApiContext object to be used to make the call.
   */
  public SetSellingManagerTemplateAutomationRuleCall(ApiContext apiContext) {
    super(apiContext);
    

  }

  /**
   * Revises, or adds to, the Selling Manager automation rules associated with a template.
   * <br>
   * <br>
   * This call is subject to change without notice; the deprecation process is inapplicable to this call. You must have a Selling Manager Pro subscription to use this call.
   * <br>
   * <br>
   * Using this call, you can add either an automated listing or relisting rule, but not both. You also can add a Second Chance Offer rule.
   * <br>
   * <br>
   * This call also enables you to specify particular information about automation rules.
   * <br>
   * <br>
   * If a node is not passed in the call, the setting for the corresponding automation rule remains unchanged.
   * 
   * <br>
   * @throws ApiException
   * @throws SdkException
   * @throws Exception
   * @return The SellingManagerAutoListType object.
   */
  public SellingManagerAutoListType setSellingManagerTemplateAutomationRule()
      throws com.ebay.sdk.ApiException, com.ebay.sdk.SdkException, java.lang.Exception
  {
    SetSellingManagerTemplateAutomationRuleRequestType req;
    req = new SetSellingManagerTemplateAutomationRuleRequestType();
    if (this.saleTemplateID != null)
      req.setSaleTemplateID(this.saleTemplateID);
    if (this.automatedListingRule != null)
      req.setAutomatedListingRule(this.automatedListingRule);
    if (this.automatedRelistingRule != null)
      req.setAutomatedRelistingRule(this.automatedRelistingRule);
    if (this.automatedSecondChanceOfferRule != null)
      req.setAutomatedSecondChanceOfferRule(this.automatedSecondChanceOfferRule);

    SetSellingManagerTemplateAutomationRuleResponseType resp = (SetSellingManagerTemplateAutomationRuleResponseType) execute(req);

    this.returnedAutomatedListingRule = resp.getAutomatedListingRule();
    this.returnedAutomatedRelistingRule = resp.getAutomatedRelistingRule();
    this.returnedAutomatedSecondChanceOfferRule = resp.getAutomatedSecondChanceOfferRule();
    this.returnedFees = resp.getFees();
    return this.getReturnedAutomatedListingRule();
  }

  /**
   * Gets the SetSellingManagerTemplateAutomationRuleRequestType.automatedListingRule.
   * @return SellingManagerAutoListType
   */
  public SellingManagerAutoListType getAutomatedListingRule()
  {
    return this.automatedListingRule;
  }

  /**
   * Sets the SetSellingManagerTemplateAutomationRuleRequestType.automatedListingRule.
   * @param automatedListingRule SellingManagerAutoListType
   */
  public void setAutomatedListingRule(SellingManagerAutoListType automatedListingRule)
  {
    this.automatedListingRule = automatedListingRule;
  }

  /**
   * Gets the SetSellingManagerTemplateAutomationRuleRequestType.automatedRelistingRule.
   * @return SellingManagerAutoRelistType
   */
  public SellingManagerAutoRelistType getAutomatedRelistingRule()
  {
    return this.automatedRelistingRule;
  }

  /**
   * Sets the SetSellingManagerTemplateAutomationRuleRequestType.automatedRelistingRule.
   * @param automatedRelistingRule SellingManagerAutoRelistType
   */
  public void setAutomatedRelistingRule(SellingManagerAutoRelistType automatedRelistingRule)
  {
    this.automatedRelistingRule = automatedRelistingRule;
  }

  /**
   * Gets the SetSellingManagerTemplateAutomationRuleRequestType.automatedSecondChanceOfferRule.
   * @return SellingManagerAutoSecondChanceOfferType
   */
  public SellingManagerAutoSecondChanceOfferType getAutomatedSecondChanceOfferRule()
  {
    return this.automatedSecondChanceOfferRule;
  }

  /**
   * Sets the SetSellingManagerTemplateAutomationRuleRequestType.automatedSecondChanceOfferRule.
   * @param automatedSecondChanceOfferRule SellingManagerAutoSecondChanceOfferType
   */
  public void setAutomatedSecondChanceOfferRule(SellingManagerAutoSecondChanceOfferType automatedSecondChanceOfferRule)
  {
    this.automatedSecondChanceOfferRule = automatedSecondChanceOfferRule;
  }

  /**
   * Gets the SetSellingManagerTemplateAutomationRuleRequestType.saleTemplateID.
   * @return Long
   */
  public Long getSaleTemplateID()
  {
    return this.saleTemplateID;
  }

  /**
   * Sets the SetSellingManagerTemplateAutomationRuleRequestType.saleTemplateID.
   * @param saleTemplateID Long
   */
  public void setSaleTemplateID(Long saleTemplateID)
  {
    this.saleTemplateID = saleTemplateID;
  }

  /**
   * Valid after executing the API.
   * Gets the returned SetSellingManagerTemplateAutomationRuleResponseType.returnedAutomatedListingRule.
   * 
   * @return SellingManagerAutoListType
   */
  public SellingManagerAutoListType getReturnedAutomatedListingRule()
  {
    return this.returnedAutomatedListingRule;
  }

  /**
   * Valid after executing the API.
   * Gets the returned SetSellingManagerTemplateAutomationRuleResponseType.returnedAutomatedRelistingRule.
   * 
   * @return SellingManagerAutoRelistType
   */
  public SellingManagerAutoRelistType getReturnedAutomatedRelistingRule()
  {
    return this.returnedAutomatedRelistingRule;
  }

  /**
   * Valid after executing the API.
   * Gets the returned SetSellingManagerTemplateAutomationRuleResponseType.returnedAutomatedSecondChanceOfferRule.
   * 
   * @return SellingManagerAutoSecondChanceOfferType
   */
  public SellingManagerAutoSecondChanceOfferType getReturnedAutomatedSecondChanceOfferRule()
  {
    return this.returnedAutomatedSecondChanceOfferRule;
  }

  /**
   * Valid after executing the API.
   * Gets the returned SetSellingManagerTemplateAutomationRuleResponseType.returnedFees.
   * 
   * @return FeesType
   */
  public FeesType getReturnedFees()
  {
    return this.returnedFees;
  }

}

