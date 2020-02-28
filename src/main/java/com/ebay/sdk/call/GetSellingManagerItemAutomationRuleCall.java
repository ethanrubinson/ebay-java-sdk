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
 * Wrapper class of the GetSellingManagerItemAutomationRule call of eBay SOAP API.
 * <br>
 * <p>Title: SOAP API wrapper library.</p>
 * <p>Description: Contains wrapper classes for eBay SOAP APIs.</p>
 * <p>Copyright: Copyright (c) 2009</p>
 * <p>Company: eBay Inc.</p>
 * <br> <B>Input property:</B> <code>ItemID</code> - The unique identifier of the listing whose Selling Manager automation rules you want to retrieve.
 * <br> <B>Output property:</B> <code>ReturnedAutomatedListingRule</code> - The information for the automated listing rule associated with the item.
 * This field is only returned if the item was listed from a template.
 * The value in this field refers to that template's automated listing rule.
 * <br> <B>Output property:</B> <code>ReturnedAutomatedRelistingRule</code> - The information for the automated relisting rule associated with the item.
 * <br> <B>Output property:</B> <code>ReturnedAutomatedSecondChanceOfferRule</code> - The information for the automated Second Chance Offer rule associated with the item.
 * <br> <B>Output property:</B> <code>ReturnedFees</code> - Contains fees that may be incurred when items are listed using the
 * automation rule (e.g., a scheduled listing fee). Use of an automation rule
 * does not in itself have a fee, but use can result in a fee.
 * 
 * @author Ron Murphy
 * @version 1.0
 */

public class GetSellingManagerItemAutomationRuleCall extends com.ebay.sdk.ApiCall
{
  
  private String itemID = null;
  private SellingManagerAutoListType returnedAutomatedListingRule=null;
  private SellingManagerAutoRelistType returnedAutomatedRelistingRule=null;
  private SellingManagerAutoSecondChanceOfferType returnedAutomatedSecondChanceOfferRule=null;
  private FeesType returnedFees=null;


  /**
   * Constructor.
   */
  public GetSellingManagerItemAutomationRuleCall() {
  }

  /**
   * Constructor.
   * @param apiContext The ApiContext object to be used to make the call.
   */
  public GetSellingManagerItemAutomationRuleCall(ApiContext apiContext) {
    super(apiContext);
    

  }

  /**
   * Retrieves the set of Selling Manager automation rules associated with an item. This call is subject to change without notice; the deprecation process is inapplicable to this call. The user must have a Selling Manager Pro subscription to use this call.
   * 
   * <br>
   * @throws ApiException
   * @throws SdkException
   * @throws Exception
   * @return The SellingManagerAutoListType object.
   */
  public SellingManagerAutoListType getSellingManagerItemAutomationRule()
      throws com.ebay.sdk.ApiException, com.ebay.sdk.SdkException, java.lang.Exception
  {
    GetSellingManagerItemAutomationRuleRequestType req;
    req = new GetSellingManagerItemAutomationRuleRequestType();
    if (this.itemID != null)
      req.setItemID(this.itemID);

    GetSellingManagerItemAutomationRuleResponseType resp = (GetSellingManagerItemAutomationRuleResponseType) execute(req);

    this.returnedAutomatedListingRule = resp.getAutomatedListingRule();
    this.returnedAutomatedRelistingRule = resp.getAutomatedRelistingRule();
    this.returnedAutomatedSecondChanceOfferRule = resp.getAutomatedSecondChanceOfferRule();
    this.returnedFees = resp.getFees();
    return this.getReturnedAutomatedListingRule();
  }

  /**
   * Gets the GetSellingManagerItemAutomationRuleRequestType.itemID.
   * @return String
   */
  public String getItemID()
  {
    return this.itemID;
  }

  /**
   * Sets the GetSellingManagerItemAutomationRuleRequestType.itemID.
   * @param itemID String
   */
  public void setItemID(String itemID)
  {
    this.itemID = itemID;
  }

  /**
   * Valid after executing the API.
   * Gets the returned GetSellingManagerItemAutomationRuleResponseType.returnedAutomatedListingRule.
   * 
   * @return SellingManagerAutoListType
   */
  public SellingManagerAutoListType getReturnedAutomatedListingRule()
  {
    return this.returnedAutomatedListingRule;
  }

  /**
   * Valid after executing the API.
   * Gets the returned GetSellingManagerItemAutomationRuleResponseType.returnedAutomatedRelistingRule.
   * 
   * @return SellingManagerAutoRelistType
   */
  public SellingManagerAutoRelistType getReturnedAutomatedRelistingRule()
  {
    return this.returnedAutomatedRelistingRule;
  }

  /**
   * Valid after executing the API.
   * Gets the returned GetSellingManagerItemAutomationRuleResponseType.returnedAutomatedSecondChanceOfferRule.
   * 
   * @return SellingManagerAutoSecondChanceOfferType
   */
  public SellingManagerAutoSecondChanceOfferType getReturnedAutomatedSecondChanceOfferRule()
  {
    return this.returnedAutomatedSecondChanceOfferRule;
  }

  /**
   * Valid after executing the API.
   * Gets the returned GetSellingManagerItemAutomationRuleResponseType.returnedFees.
   * 
   * @return FeesType
   */
  public FeesType getReturnedFees()
  {
    return this.returnedFees;
  }

}

