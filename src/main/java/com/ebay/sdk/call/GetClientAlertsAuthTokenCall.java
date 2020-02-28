/*
Copyright (c) 2013 eBay, Inc.
This program is licensed under the terms of the eBay Common Development and
Distribution License (CDDL) Version 1.0 (the "License") and any subsequent  version 
thereof released by eBay.  The then-current version of the License can be found 
at http://www.opensource.org/licenses/cddl1.php and in the eBaySDKLicense file that 
is under the eBay SDK ../docs directory.
*/

package com.ebay.sdk.call;

import java.lang.String;
import java.util.Calendar;

import com.ebay.sdk.*;
import com.ebay.soap.eBLBaseComponents.*;
/**
 * Wrapper class of the GetClientAlertsAuthToken call of eBay SOAP API.
 * <br>
 * <p>Title: SOAP API wrapper library.</p>
 * <p>Description: Contains wrapper classes for eBay SOAP APIs.</p>
 * <p>Copyright: Copyright (c) 2009</p>
 * <p>Company: eBay Inc.</p>
 * <br> <B>Output property:</B> <code>ReturnedClientAlertsAuthToken</code> - This token string is required for the Login call in the Client Alerts API.
 * The Client Alerts GetUserAlerts call, which returns alerts about events
 * associated with a specific user, requires Login.
 * <br> <B>Output property:</B> <code>ReturnedHardExpirationTime</code> - A Client Alerts token expires after seven days.
 * 
 * @author Ron Murphy
 * @version 1.0
 */

public class GetClientAlertsAuthTokenCall extends com.ebay.sdk.ApiCall
{
  
  private String returnedClientAlertsAuthToken=null;
  private Calendar returnedHardExpirationTime=null;


  /**
   * Constructor.
   */
  public GetClientAlertsAuthTokenCall() {
  }

  /**
   * Constructor.
   * @param apiContext The ApiContext object to be used to make the call.
   */
  public GetClientAlertsAuthTokenCall(ApiContext apiContext) {
    super(apiContext);
    

  }

  /**
   * This is the base request type for the <b>GetClientAlertsAuthToken</b> call. This call retrieves a Client Alerts token for the user, which is required when the user makes a <b>GetUserAlerts</b> call (Client Alerts API).
   * 
   * <br>
   * @throws ApiException
   * @throws SdkException
   * @throws Exception
   * @return The String object.
   */
  public String getClientAlertsAuthToken()
      throws com.ebay.sdk.ApiException, com.ebay.sdk.SdkException, java.lang.Exception
  {
    GetClientAlertsAuthTokenRequestType req;
    req = new GetClientAlertsAuthTokenRequestType();

    GetClientAlertsAuthTokenResponseType resp = (GetClientAlertsAuthTokenResponseType) execute(req);

    this.returnedClientAlertsAuthToken = resp.getClientAlertsAuthToken();
    this.returnedHardExpirationTime = resp.getHardExpirationTime();
    return this.getReturnedClientAlertsAuthToken();
  }

  /**
   * Valid after executing the API.
   * Gets the returned GetClientAlertsAuthTokenResponseType.returnedClientAlertsAuthToken.
   * 
   * @return String
   */
  public String getReturnedClientAlertsAuthToken()
  {
    return this.returnedClientAlertsAuthToken;
  }

  /**
   * Valid after executing the API.
   * Gets the returned GetClientAlertsAuthTokenResponseType.returnedHardExpirationTime.
   * 
   * @return Calendar
   */
  public Calendar getReturnedHardExpirationTime()
  {
    return this.returnedHardExpirationTime;
  }

}

