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
import java.lang.Long;

import com.ebay.sdk.*;
import com.ebay.soap.eBLBaseComponents.*;
/**
 * Wrapper class of the DeleteSellingManagerTemplateAutomationRule call of eBay SOAP API.
 * <br>
 * <p>Title: SOAP API wrapper library.</p>
 * <p>Description: Contains wrapper classes for eBay SOAP APIs.</p>
 * <p>Copyright: Copyright (c) 2009</p>
 * <p>Company: eBay Inc.</p>
 * <br> <B>Input property:</B> <code>SaleTemplateID</code> - The unique identifier of the Selling Manager template from which you want to remove automation rules.
 * You can obtain a <b>SaleTemplateID</b> by calling <b>GetSellingManagerInventory</b>.
 * <br> <B>Input property:</B> <code>DeleteAutomatedListingRule</code> - This field is included and set to <code>true</code> if the user would like to disable the automated listing rule for the Selling Manager template.
 * <br> <B>Input property:</B> <code>DeleteAutomatedRelistingRule</code> - This field is included and set to <code>true</code> if the user would like to disable the automated relisting rule for the Selling Manager template.
 * <br> <B>Input property:</B> <code>DeleteAutomatedSecondChanceOfferRule</code> - This field is included and set to <code>true</code> if the user would like to disable the automated Second Chance Offer rule for the Selling Manager template.
 * <br> <B>Output property:</B> <code>ReturnedAutomatedListingRule</code> - This container is returned if automated listing rules are set up for the Selling Manager template.
 * <br> <B>Output property:</B> <code>ReturnedAutomatedRelistingRule</code> - This container is returned if automated relisting rules are set up for the Selling Manager template.
 * <br> <B>Output property:</B> <code>ReturnedAutomatedSecondChanceOfferRule</code> - This container is returned if automated Second Chance Offer rules are set up for the Selling Manager template.
 * <br> <B>Output property:</B> <code>ReturnedFees</code> - Contains fees that may be incurred when items are listed using the
 * automation rules (e.g., a scheduled listing fee). Use of an automation rule
 * does not in itself have a fee, but use can result in a fee.
 * 
 * @author Ron Murphy
 * @version 1.0
 */

public class DeleteSellingManagerTemplateAutomationRuleCall extends com.ebay.sdk.ApiCall
{
  
  private Long saleTemplateID = null;
  private Boolean deleteAutomatedListingRule = null;
  private Boolean deleteAutomatedRelistingRule = null;
  private Boolean deleteAutomatedSecondChanceOfferRule = null;
  private SellingManagerAutoListType returnedAutomatedListingRule=null;
  private SellingManagerAutoRelistType returnedAutomatedRelistingRule=null;
  private SellingManagerAutoSecondChanceOfferType returnedAutomatedSecondChanceOfferRule=null;
  private FeesType returnedFees=null;


  /**
   * Constructor.
   */
  public DeleteSellingManagerTemplateAutomationRuleCall() {
  }

  /**
   * Constructor.
   * @param apiContext The ApiContext object to be used to make the call.
   */
  public DeleteSellingManagerTemplateAutomationRuleCall(ApiContext apiContext) {
    super(apiContext);
    

  }

  /**
   * Removes the association of Selling Manager automation rules
   * to a template. Returns the remaining rules in the response.
   * This call is subject to change without notice; the
   * deprecation process is inapplicable to this call.
   * 
   * <br>
   * @throws ApiException
   * @throws SdkException
   * @throws Exception
   * @return The SellingManagerAutoListType object.
   */
  public SellingManagerAutoListType deleteSellingManagerTemplateAutomationRule()
      throws com.ebay.sdk.ApiException, com.ebay.sdk.SdkException, java.lang.Exception
  {
    DeleteSellingManagerTemplateAutomationRuleRequestType req;
    req = new DeleteSellingManagerTemplateAutomationRuleRequestType();
    if (this.saleTemplateID != null)
      req.setSaleTemplateID(this.saleTemplateID);
    if (this.deleteAutomatedListingRule != null)
      req.setDeleteAutomatedListingRule(this.deleteAutomatedListingRule);
    if (this.deleteAutomatedRelistingRule != null)
      req.setDeleteAutomatedRelistingRule(this.deleteAutomatedRelistingRule);
    if (this.deleteAutomatedSecondChanceOfferRule != null)
      req.setDeleteAutomatedSecondChanceOfferRule(this.deleteAutomatedSecondChanceOfferRule);

    DeleteSellingManagerTemplateAutomationRuleResponseType resp = (DeleteSellingManagerTemplateAutomationRuleResponseType) execute(req);

    this.returnedAutomatedListingRule = resp.getAutomatedListingRule();
    this.returnedAutomatedRelistingRule = resp.getAutomatedRelistingRule();
    this.returnedAutomatedSecondChanceOfferRule = resp.getAutomatedSecondChanceOfferRule();
    this.returnedFees = resp.getFees();
    return this.getReturnedAutomatedListingRule();
  }

  /**
   * Gets the DeleteSellingManagerTemplateAutomationRuleRequestType.deleteAutomatedListingRule.
   * @return Boolean
   */
  public Boolean getDeleteAutomatedListingRule()
  {
    return this.deleteAutomatedListingRule;
  }

  /**
   * Sets the DeleteSellingManagerTemplateAutomationRuleRequestType.deleteAutomatedListingRule.
   * @param deleteAutomatedListingRule Boolean
   */
  public void setDeleteAutomatedListingRule(Boolean deleteAutomatedListingRule)
  {
    this.deleteAutomatedListingRule = deleteAutomatedListingRule;
  }

  /**
   * Gets the DeleteSellingManagerTemplateAutomationRuleRequestType.deleteAutomatedRelistingRule.
   * @return Boolean
   */
  public Boolean getDeleteAutomatedRelistingRule()
  {
    return this.deleteAutomatedRelistingRule;
  }

  /**
   * Sets the DeleteSellingManagerTemplateAutomationRuleRequestType.deleteAutomatedRelistingRule.
   * @param deleteAutomatedRelistingRule Boolean
   */
  public void setDeleteAutomatedRelistingRule(Boolean deleteAutomatedRelistingRule)
  {
    this.deleteAutomatedRelistingRule = deleteAutomatedRelistingRule;
  }

  /**
   * Gets the DeleteSellingManagerTemplateAutomationRuleRequestType.deleteAutomatedSecondChanceOfferRule.
   * @return Boolean
   */
  public Boolean getDeleteAutomatedSecondChanceOfferRule()
  {
    return this.deleteAutomatedSecondChanceOfferRule;
  }

  /**
   * Sets the DeleteSellingManagerTemplateAutomationRuleRequestType.deleteAutomatedSecondChanceOfferRule.
   * @param deleteAutomatedSecondChanceOfferRule Boolean
   */
  public void setDeleteAutomatedSecondChanceOfferRule(Boolean deleteAutomatedSecondChanceOfferRule)
  {
    this.deleteAutomatedSecondChanceOfferRule = deleteAutomatedSecondChanceOfferRule;
  }

  /**
   * Gets the DeleteSellingManagerTemplateAutomationRuleRequestType.saleTemplateID.
   * @return Long
   */
  public Long getSaleTemplateID()
  {
    return this.saleTemplateID;
  }

  /**
   * Sets the DeleteSellingManagerTemplateAutomationRuleRequestType.saleTemplateID.
   * @param saleTemplateID Long
   */
  public void setSaleTemplateID(Long saleTemplateID)
  {
    this.saleTemplateID = saleTemplateID;
  }

  /**
   * Valid after executing the API.
   * Gets the returned DeleteSellingManagerTemplateAutomationRuleResponseType.returnedAutomatedListingRule.
   * 
   * @return SellingManagerAutoListType
   */
  public SellingManagerAutoListType getReturnedAutomatedListingRule()
  {
    return this.returnedAutomatedListingRule;
  }

  /**
   * Valid after executing the API.
   * Gets the returned DeleteSellingManagerTemplateAutomationRuleResponseType.returnedAutomatedRelistingRule.
   * 
   * @return SellingManagerAutoRelistType
   */
  public SellingManagerAutoRelistType getReturnedAutomatedRelistingRule()
  {
    return this.returnedAutomatedRelistingRule;
  }

  /**
   * Valid after executing the API.
   * Gets the returned DeleteSellingManagerTemplateAutomationRuleResponseType.returnedAutomatedSecondChanceOfferRule.
   * 
   * @return SellingManagerAutoSecondChanceOfferType
   */
  public SellingManagerAutoSecondChanceOfferType getReturnedAutomatedSecondChanceOfferRule()
  {
    return this.returnedAutomatedSecondChanceOfferRule;
  }

  /**
   * Valid after executing the API.
   * Gets the returned DeleteSellingManagerTemplateAutomationRuleResponseType.returnedFees.
   * 
   * @return FeesType
   */
  public FeesType getReturnedFees()
  {
    return this.returnedFees;
  }

}

