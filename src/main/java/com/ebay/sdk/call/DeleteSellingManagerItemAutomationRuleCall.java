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
 * Wrapper class of the DeleteSellingManagerItemAutomationRule call of eBay SOAP API.
 * <br>
 * <p>Title: SOAP API wrapper library.</p>
 * <p>Description: Contains wrapper classes for eBay SOAP APIs.</p>
 * <p>Copyright: Copyright (c) 2009</p>
 * <p>Company: eBay Inc.</p>
 * <br> <B>Input property:</B> <code>ItemID</code> - The unique identifier of the listing from which to delete automation rules.
 * <br> <B>Input property:</B> <code>DeleteAutomatedRelistingRule</code> - This field is included and set to <code>true</code> if the user would like to disable the automated relisting rule for the listing.
 * <br> <B>Input property:</B> <code>DeleteAutomatedSecondChanceOfferRule</code> - This field is included and set to <code>true</code> if the user would like to disable the automated Second Chance Offer rule for the listing.
 * <br> <B>Output property:</B> <code>ReturnedAutomatedListingRule</code> - This container is returned if automated listing rules are set up for the Selling Manager item.
 * <br> <B>Output property:</B> <code>ReturnedAutomatedRelistingRule</code> - This container is returned if automated relisting rules are set up for the Selling Manager item.
 * <br> <B>Output property:</B> <code>ReturnedAutomatedSecondChanceOfferRule</code> - This container is returned if automated Second Chance Offer rules are set up for the Selling Manager item.
 * <br> <B>Output property:</B> <code>ReturnedFees</code> - Contains fees that may be incurred when items are listed using the
 * automation rules (e.g., a scheduled listing fee). Use of an automation rule
 * does not in itself have a fee, but use can result in a fee.
 * 
 * @author Ron Murphy
 * @version 1.0
 */

public class DeleteSellingManagerItemAutomationRuleCall extends com.ebay.sdk.ApiCall
{
  
  private String itemID = null;
  private Boolean deleteAutomatedRelistingRule = null;
  private Boolean deleteAutomatedSecondChanceOfferRule = null;
  private SellingManagerAutoListType returnedAutomatedListingRule=null;
  private SellingManagerAutoRelistType returnedAutomatedRelistingRule=null;
  private SellingManagerAutoSecondChanceOfferType returnedAutomatedSecondChanceOfferRule=null;
  private FeesType returnedFees=null;


  /**
   * Constructor.
   */
  public DeleteSellingManagerItemAutomationRuleCall() {
  }

  /**
   * Constructor.
   * @param apiContext The ApiContext object to be used to make the call.
   */
  public DeleteSellingManagerItemAutomationRuleCall(ApiContext apiContext) {
    super(apiContext);
    

  }

  /**
   * Removes the association of Selling Manager automation rules
   * to an item. Returns the remaining rules in the response.
   * <br><br>
   * This call is subject to change without notice; the
   * deprecation process is inapplicable to this call.
   * 
   * <br>
   * @throws ApiException
   * @throws SdkException
   * @throws Exception
   * @return The SellingManagerAutoListType object.
   */
  public SellingManagerAutoListType deleteSellingManagerItemAutomationRule()
      throws com.ebay.sdk.ApiException, com.ebay.sdk.SdkException, java.lang.Exception
  {
    DeleteSellingManagerItemAutomationRuleRequestType req;
    req = new DeleteSellingManagerItemAutomationRuleRequestType();
    if (this.itemID != null)
      req.setItemID(this.itemID);
    if (this.deleteAutomatedRelistingRule != null)
      req.setDeleteAutomatedRelistingRule(this.deleteAutomatedRelistingRule);
    if (this.deleteAutomatedSecondChanceOfferRule != null)
      req.setDeleteAutomatedSecondChanceOfferRule(this.deleteAutomatedSecondChanceOfferRule);

    DeleteSellingManagerItemAutomationRuleResponseType resp = (DeleteSellingManagerItemAutomationRuleResponseType) execute(req);

    this.returnedAutomatedListingRule = resp.getAutomatedListingRule();
    this.returnedAutomatedRelistingRule = resp.getAutomatedRelistingRule();
    this.returnedAutomatedSecondChanceOfferRule = resp.getAutomatedSecondChanceOfferRule();
    this.returnedFees = resp.getFees();
    return this.getReturnedAutomatedListingRule();
  }

  /**
   * Gets the DeleteSellingManagerItemAutomationRuleRequestType.deleteAutomatedRelistingRule.
   * @return Boolean
   */
  public Boolean getDeleteAutomatedRelistingRule()
  {
    return this.deleteAutomatedRelistingRule;
  }

  /**
   * Sets the DeleteSellingManagerItemAutomationRuleRequestType.deleteAutomatedRelistingRule.
   * @param deleteAutomatedRelistingRule Boolean
   */
  public void setDeleteAutomatedRelistingRule(Boolean deleteAutomatedRelistingRule)
  {
    this.deleteAutomatedRelistingRule = deleteAutomatedRelistingRule;
  }

  /**
   * Gets the DeleteSellingManagerItemAutomationRuleRequestType.deleteAutomatedSecondChanceOfferRule.
   * @return Boolean
   */
  public Boolean getDeleteAutomatedSecondChanceOfferRule()
  {
    return this.deleteAutomatedSecondChanceOfferRule;
  }

  /**
   * Sets the DeleteSellingManagerItemAutomationRuleRequestType.deleteAutomatedSecondChanceOfferRule.
   * @param deleteAutomatedSecondChanceOfferRule Boolean
   */
  public void setDeleteAutomatedSecondChanceOfferRule(Boolean deleteAutomatedSecondChanceOfferRule)
  {
    this.deleteAutomatedSecondChanceOfferRule = deleteAutomatedSecondChanceOfferRule;
  }

  /**
   * Gets the DeleteSellingManagerItemAutomationRuleRequestType.itemID.
   * @return String
   */
  public String getItemID()
  {
    return this.itemID;
  }

  /**
   * Sets the DeleteSellingManagerItemAutomationRuleRequestType.itemID.
   * @param itemID String
   */
  public void setItemID(String itemID)
  {
    this.itemID = itemID;
  }

  /**
   * Valid after executing the API.
   * Gets the returned DeleteSellingManagerItemAutomationRuleResponseType.returnedAutomatedListingRule.
   * 
   * @return SellingManagerAutoListType
   */
  public SellingManagerAutoListType getReturnedAutomatedListingRule()
  {
    return this.returnedAutomatedListingRule;
  }

  /**
   * Valid after executing the API.
   * Gets the returned DeleteSellingManagerItemAutomationRuleResponseType.returnedAutomatedRelistingRule.
   * 
   * @return SellingManagerAutoRelistType
   */
  public SellingManagerAutoRelistType getReturnedAutomatedRelistingRule()
  {
    return this.returnedAutomatedRelistingRule;
  }

  /**
   * Valid after executing the API.
   * Gets the returned DeleteSellingManagerItemAutomationRuleResponseType.returnedAutomatedSecondChanceOfferRule.
   * 
   * @return SellingManagerAutoSecondChanceOfferType
   */
  public SellingManagerAutoSecondChanceOfferType getReturnedAutomatedSecondChanceOfferRule()
  {
    return this.returnedAutomatedSecondChanceOfferRule;
  }

  /**
   * Valid after executing the API.
   * Gets the returned DeleteSellingManagerItemAutomationRuleResponseType.returnedFees.
   * 
   * @return FeesType
   */
  public FeesType getReturnedFees()
  {
    return this.returnedFees;
  }

}

