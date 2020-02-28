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
 * Wrapper class of the GetSellerDashboard call of eBay SOAP API.
 * <br>
 * <p>Title: SOAP API wrapper library.</p>
 * <p>Description: Contains wrapper classes for eBay SOAP APIs.</p>
 * <p>Copyright: Copyright (c) 2009</p>
 * <p>Company: eBay Inc.</p>
 * <br> <B>Output property:</B> <code>ReturnedSearchStanding</code> - Provides information about the visibility level you have earned for your
 * listings. The higher your search standing rating, the higher your items
 * will be placed in search results sorted by Best Match. Because your search
 * standing rating is directly tied to your customer service record, this
 * rating is an important way that eBay rewards you as a good seller--it
 * encourages you to give buyers the best possible shopping experience.
 * <br><br>
 * This field is returned <b>only</b> for the following sites.
 * <br><br>
 * <table>
 * <tr>  <th>Site</th> <th>Id</th>  </tr>
 * <tr>  <td>AU</td> <td>15</td>  </tr>
 * <tr>  <td>BEFR</td> <td>23</td>  </tr>
 * <tr>  <td>BENL</td> <td>123</td>  </tr>
 * <tr>  <td>CA</td> <td>2</td>  </tr>
 * <tr>  <td>ES</td> <td>186</td>  </tr>
 * <tr>  <td>FR</td> <td>71</td>  </tr>
 * <tr>  <td>IN</td> <td>203</td>  </tr>
 * <tr>  <td>IT</td> <td>101</td>  </tr>
 * <tr>  <td>MOTORS</td> <td>100</td>  </tr>
 * <tr>  <td>NL</td> <td>146</td>  </tr>
 * <tr>  <td>PL</td> <td>212</td>  </tr>
 * </table>
 * <br> <B>Output property:</B> <code>ReturnedSellerFeeDiscount</code> - This container provides the percentage discount that the seller is eligible to receive on the Final Value Fee for each order line item. Top-Rated Sellers may be eligible for Final Value Fee discounts if their listings meet all requirements for the discount.
 * <br><br>
 * This container is still returned even if the seller is not receiving a Final Value Fee discount (returned as <code>0.0</code>)
 * <br> <B>Output property:</B> <code>ReturnedPowerSellerStatus</code> - This container provides the seller's PowerSeller status, as well as any informational alerts related to the seller's PowerSeller status. If the seller has not achieved Power Seller status, a value of <code>None</code> will be returned in the <b>PowerSellerStatus.Level</b> field. A <b>PowerSellerStatus.Alert</b> container will only be returned if there is an alert/message related to the seller's PowerSeller status.
 * <br><br>
 * For eBay Germany and France, you must be a registered business seller to
 * see your Power Seller status.
 * <br> <B>Output property:</B> <code>ReturnedPolicyCompliance</code> - This container is no longer returned in <b>GetSellerDashboard</b>.
 * <br> <B>Output property:</B> <code>ReturnedBuyerSatisfaction</code> - This container provides the seller's Buyer Satisfaction status, as well as any informational alerts related to the seller's Buyer Satisfaction status. A <b>BuyerSatisfaction.Alert</b> container will only be returned if there is an alert/message related to the seller's Buyer Satisfaction status.
 * <br><br>
 * This field is not returned for all sites.
 * <br> <B>Output property:</B> <code>ReturnedSellerAccount</code> - This container provides the seller's account status, as well as any informational alerts related to the seller's account status. A seller's account status can either be 'current' (all selling fees paid), 'past due' (seller is late paying selling fees), or 'on hold' (seller will be blocked from listing and is in danger of being suspended until selling fees are brought current). A <b>SellerAccount.Alert</b> container will only be returned if there is an alert/message related to the seller's account status.
 * <br> <B>Output property:</B> <code>ReturnedPerformance</code> - This container provides the seller's performance level, as well as any informational alerts related to the seller's performance level. A <b>Performance.Alert</b> container will only be returned if there is an alert/message related to the seller's performance level.
 * 
 * @author Ron Murphy
 * @version 1.0
 */

public class GetSellerDashboardCall extends com.ebay.sdk.ApiCall
{
  
  private SearchStandingDashboardType returnedSearchStanding=null;
  private SellerFeeDiscountDashboardType returnedSellerFeeDiscount=null;
  private PowerSellerDashboardType returnedPowerSellerStatus=null;
  private PolicyComplianceDashboardType returnedPolicyCompliance=null;
  private BuyerSatisfactionDashboardType returnedBuyerSatisfaction=null;
  private SellerAccountDashboardType returnedSellerAccount=null;
  private PerformanceDashboardType[] returnedPerformance=null;


  /**
   * Constructor.
   */
  public GetSellerDashboardCall() {
  }

  /**
   * Constructor.
   * @param apiContext The ApiContext object to be used to make the call.
   */
  public GetSellerDashboardCall(ApiContext apiContext) {
    super(apiContext);
    

  }

  /**
   * The base request type for the <b>GetSellerDashboard</b> call. This call retrieves seller performance data, including seller standards level, Power Seller status, Buyer Satisfaction status, eBay Search standing, and any seller fee discounts.
   * 
   * <br>
   * @throws ApiException
   * @throws SdkException
   * @throws Exception
   * @return The SearchStandingDashboardType object.
   */
  public SearchStandingDashboardType getSellerDashboard()
      throws com.ebay.sdk.ApiException, com.ebay.sdk.SdkException, java.lang.Exception
  {
    GetSellerDashboardRequestType req;
    req = new GetSellerDashboardRequestType();

    GetSellerDashboardResponseType resp = (GetSellerDashboardResponseType) execute(req);

    this.returnedSearchStanding = resp.getSearchStanding();
    this.returnedSellerFeeDiscount = resp.getSellerFeeDiscount();
    this.returnedPowerSellerStatus = resp.getPowerSellerStatus();
    this.returnedPolicyCompliance = resp.getPolicyCompliance();
    this.returnedBuyerSatisfaction = resp.getBuyerSatisfaction();
    this.returnedSellerAccount = resp.getSellerAccount();
    this.returnedPerformance = resp.getPerformance();
    return this.getReturnedSearchStanding();
  }

  /**
   * Valid after executing the API.
   * Gets the returned GetSellerDashboardResponseType.returnedBuyerSatisfaction.
   * 
   * @return BuyerSatisfactionDashboardType
   */
  public BuyerSatisfactionDashboardType getReturnedBuyerSatisfaction()
  {
    return this.returnedBuyerSatisfaction;
  }

  /**
   * Valid after executing the API.
   * Gets the returned GetSellerDashboardResponseType.returnedPerformance.
   * 
   * @return PerformanceDashboardType[]
   */
  public PerformanceDashboardType[] getReturnedPerformance()
  {
    return this.returnedPerformance;
  }

  /**
   * Valid after executing the API.
   * Gets the returned GetSellerDashboardResponseType.returnedPolicyCompliance.
   * 
   * @return PolicyComplianceDashboardType
   */
  public PolicyComplianceDashboardType getReturnedPolicyCompliance()
  {
    return this.returnedPolicyCompliance;
  }

  /**
   * Valid after executing the API.
   * Gets the returned GetSellerDashboardResponseType.returnedPowerSellerStatus.
   * 
   * @return PowerSellerDashboardType
   */
  public PowerSellerDashboardType getReturnedPowerSellerStatus()
  {
    return this.returnedPowerSellerStatus;
  }

  /**
   * Valid after executing the API.
   * Gets the returned GetSellerDashboardResponseType.returnedSearchStanding.
   * 
   * @return SearchStandingDashboardType
   */
  public SearchStandingDashboardType getReturnedSearchStanding()
  {
    return this.returnedSearchStanding;
  }

  /**
   * Valid after executing the API.
   * Gets the returned GetSellerDashboardResponseType.returnedSellerAccount.
   * 
   * @return SellerAccountDashboardType
   */
  public SellerAccountDashboardType getReturnedSellerAccount()
  {
    return this.returnedSellerAccount;
  }

  /**
   * Valid after executing the API.
   * Gets the returned GetSellerDashboardResponseType.returnedSellerFeeDiscount.
   * 
   * @return SellerFeeDiscountDashboardType
   */
  public SellerFeeDiscountDashboardType getReturnedSellerFeeDiscount()
  {
    return this.returnedSellerFeeDiscount;
  }

}

