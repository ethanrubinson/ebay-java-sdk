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
 * Wrapper class of the SetStorePreferences call of eBay SOAP API.
 * <br>
 * <p>Title: SOAP API wrapper library.</p>
 * <p>Description: Contains wrapper classes for eBay SOAP APIs.</p>
 * <p>Copyright: Copyright (c) 2009</p>
 * <p>Company: eBay Inc.</p>
 * <br> <B>Input property:</B> <code>StorePreferences</code> - This container is used to set the eBay Store's preferences. Currently, the only applicable eBay Store preferences are Store vacation preferences.
 * 
 * @author Ron Murphy
 * @version 1.0
 */

public class SetStorePreferencesCall extends com.ebay.sdk.ApiCall
{
  
  private StorePreferencesType storePreferences = null;


  /**
   * Constructor.
   */
  public SetStorePreferencesCall() {
  }

  /**
   * Constructor.
   * @param apiContext The ApiContext object to be used to make the call.
   */
  public SetStorePreferencesCall(ApiContext apiContext) {
    super(apiContext);
    

  }

  /**
   * Sets the preferences for a user's eBay Store. Sellers must have an eBay Store subscription in order to use this call.
   * 
   * <br>
   * @throws ApiException
   * @throws SdkException
   * @throws Exception
   * @return The void object.
   */
  public void setStorePreferences()
      throws com.ebay.sdk.ApiException, com.ebay.sdk.SdkException, java.lang.Exception
  {
    SetStorePreferencesRequestType req;
    req = new SetStorePreferencesRequestType();

    if( this.storePreferences == null )
      throw new SdkException("StorePreferences property is not set.");

    if (this.storePreferences != null)
      req.setStorePreferences(this.storePreferences);

    SetStorePreferencesResponseType resp = (SetStorePreferencesResponseType) execute(req);


  }

  /**
   * Gets the SetStorePreferencesRequestType.storePreferences.
   * @return StorePreferencesType
   */
  public StorePreferencesType getStorePreferences()
  {
    return this.storePreferences;
  }

  /**
   * Sets the SetStorePreferencesRequestType.storePreferences.
   * @param storePreferences StorePreferencesType
   */
  public void setStorePreferences(StorePreferencesType storePreferences)
  {
    this.storePreferences = storePreferences;
  }

}

