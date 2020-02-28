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
 * Wrapper class of the GetStorePreferences call of eBay SOAP API.
 * <br>
 * <p>Title: SOAP API wrapper library.</p>
 * <p>Description: Contains wrapper classes for eBay SOAP APIs.</p>
 * <p>Copyright: Copyright (c) 2009</p>
 * <p>Company: eBay Inc.</p>
 * <br> <B>Output property:</B> <code>ReturnedStorePreferencesType</code> - This container consists of the seller's current eBay Store preferences. Currently, the only eBay Store preferences are related to putting an eBay Store on vacation mode, but more preferences may get added in the future.
 * 
 * @author Ron Murphy
 * @version 1.0
 */

public class GetStorePreferencesCall extends com.ebay.sdk.ApiCall
{
  
  private StorePreferencesType returnedStorePreferencesType=null;


  /**
   * Constructor.
   */
  public GetStorePreferencesCall() {
  }

  /**
   * Constructor.
   * @param apiContext The ApiContext object to be used to make the call.
   */
  public GetStorePreferencesCall(ApiContext apiContext) {
    super(apiContext);
    

  }

  /**
   * This call is used to retrieve an eBay seller's Store preferences. This call does not have any call-specific request payload.
   * 
   * <br>
   * @throws ApiException
   * @throws SdkException
   * @throws Exception
   * @return The void object.
   */
  public void getStorePreferences()
      throws com.ebay.sdk.ApiException, com.ebay.sdk.SdkException, java.lang.Exception
  {
    GetStorePreferencesRequestType req;
    req = new GetStorePreferencesRequestType();

    GetStorePreferencesResponseType resp = (GetStorePreferencesResponseType) execute(req);

    this.returnedStorePreferencesType = resp.getStorePreferences();

  }

  /**
   * Valid after executing the API.
   * Gets the returned GetStorePreferencesResponseType.returnedStorePreferencesType.
   * 
   * @return StorePreferencesType
   */
  public StorePreferencesType getReturnedStorePreferencesType()
  {
    return this.returnedStorePreferencesType;
  }

}

