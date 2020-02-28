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
 * Wrapper class of the SetStoreCustomPage call of eBay SOAP API.
 * <br>
 * <p>Title: SOAP API wrapper library.</p>
 * <p>Description: Contains wrapper classes for eBay SOAP APIs.</p>
 * <p>Copyright: Copyright (c) 2009</p>
 * <p>Company: eBay Inc.</p>
 * <br> <B>Input property:</B> <code>StoreCustomPage</code> - This container is used to create a new eBay Store custom page or modify an existing custom page.
 * <br> <B>Output property:</B> <code>ReturnedStoreCustomPageType</code> - This container consists of details for the newly-added or modified eBay Store custom page.
 * 
 * @author Ron Murphy
 * @version 1.0
 */

public class SetStoreCustomPageCall extends com.ebay.sdk.ApiCall
{
  
  private StoreCustomPageType storeCustomPage = null;
  private StoreCustomPageType returnedStoreCustomPageType=null;


  /**
   * Constructor.
   */
  public SetStoreCustomPageCall() {
  }

  /**
   * Constructor.
   * @param apiContext The ApiContext object to be used to make the call.
   */
  public SetStoreCustomPageCall(ApiContext apiContext) {
    super(apiContext);
    

  }

  /**
   * Creates or updates a custom page on a user's eBay Store. Sellers must have an eBay Store subscription in order to use this call.
   * 
   * <br>
   * @throws ApiException
   * @throws SdkException
   * @throws Exception
   * @return The void object.
   */
  public void setStoreCustomPage()
      throws com.ebay.sdk.ApiException, com.ebay.sdk.SdkException, java.lang.Exception
  {
    SetStoreCustomPageRequestType req;
    req = new SetStoreCustomPageRequestType();

    if( this.storeCustomPage == null )
      throw new SdkException("StoreCustomPage property is not set.");

    if (this.storeCustomPage != null)
      req.setCustomPage(this.storeCustomPage);

    SetStoreCustomPageResponseType resp = (SetStoreCustomPageResponseType) execute(req);

    this.returnedStoreCustomPageType = resp.getCustomPage();

  }

  /**
   * Gets the SetStoreCustomPageRequestType.storeCustomPage.
   * @return StoreCustomPageType
   */
  public StoreCustomPageType getStoreCustomPage()
  {
    return this.storeCustomPage;
  }

  /**
   * Sets the SetStoreCustomPageRequestType.storeCustomPage.
   * @param storeCustomPage StoreCustomPageType
   */
  public void setStoreCustomPage(StoreCustomPageType storeCustomPage)
  {
    this.storeCustomPage = storeCustomPage;
  }

  /**
   * Valid after executing the API.
   * Gets the returned SetStoreCustomPageResponseType.returnedStoreCustomPageType.
   * 
   * @return StoreCustomPageType
   */
  public StoreCustomPageType getReturnedStoreCustomPageType()
  {
    return this.returnedStoreCustomPageType;
  }

}

