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
 * Wrapper class of the GetSellingManagerAlerts call of eBay SOAP API.
 * <br>
 * <p>Title: SOAP API wrapper library.</p>
 * <p>Description: Contains wrapper classes for eBay SOAP APIs.</p>
 * <p>Copyright: Copyright (c) 2009</p>
 * <p>Company: eBay Inc.</p>
 * <br> <B>Output property:</B> <code>ReturnedAlert</code> - Container consisting of details related to a Selling Manager alert. Alert types include listing automation, inventory, item sold, and a general alert.
 * 
 * @author Ron Murphy
 * @version 1.0
 */

public class GetSellingManagerAlertsCall extends com.ebay.sdk.ApiCall
{
  
  private SellingManagerAlertType[] returnedAlert=null;


  /**
   * Constructor.
   */
  public GetSellingManagerAlertsCall() {
  }

  /**
   * Constructor.
   * @param apiContext The ApiContext object to be used to make the call.
   */
  public GetSellingManagerAlertsCall(ApiContext apiContext) {
    super(apiContext);
    

  }

  /**
   * Retrieves Selling Manager alerts.
   * This call is subject to change without notice; the deprecation process is
   * inapplicable to this call.
   * 
   * <br>
   * @throws ApiException
   * @throws SdkException
   * @throws Exception
   * @return The SellingManagerAlertType[] object.
   */
  public SellingManagerAlertType[] getSellingManagerAlerts()
      throws com.ebay.sdk.ApiException, com.ebay.sdk.SdkException, java.lang.Exception
  {
    GetSellingManagerAlertsRequestType req;
    req = new GetSellingManagerAlertsRequestType();

    GetSellingManagerAlertsResponseType resp = (GetSellingManagerAlertsResponseType) execute(req);

    this.returnedAlert = resp.getAlert();
    return this.getReturnedAlert();
  }

  /**
   * Valid after executing the API.
   * Gets the returned GetSellingManagerAlertsResponseType.returnedAlert.
   * 
   * @return SellingManagerAlertType[]
   */
  public SellingManagerAlertType[] getReturnedAlert()
  {
    return this.returnedAlert;
  }

}

