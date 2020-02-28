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
 * Wrapper class of the GetStoreCustomPage call of eBay SOAP API.
 * <br>
 * <p>Title: SOAP API wrapper library.</p>
 * <p>Description: Contains wrapper classes for eBay SOAP APIs.</p>
 * <p>Copyright: Copyright (c) 2009</p>
 * <p>Company: eBay Inc.</p>
 * <br> <B>Input property:</B> <code>PageID</code> - This field is used if the seller wants to retrieved detailed information on a specific custom page. If no <b>PageID</b> is specified, then all of the seller's custom pages are returned, but without the page content.
 * <br> <B>Output property:</B> <code>ReturnedStoreCustomPageArrayType</code> - This array consists of details for one or more of the seller's custom pages. A <b>CustomPage</b> container is returned for each custom page that matches the input criteria.
 * 
 * @author Ron Murphy
 * @version 1.0
 */

public class GetStoreCustomPageCall extends com.ebay.sdk.ApiCall
{
  
  private Long pageID = null;
  private StoreCustomPageArrayType returnedStoreCustomPageArrayType=null;


  /**
   * Constructor.
   */
  public GetStoreCustomPageCall() {
  }

  /**
   * Constructor.
   * @param apiContext The ApiContext object to be used to make the call.
   */
  public GetStoreCustomPageCall(ApiContext apiContext) {
    super(apiContext);
    

  }

  /**
   * This call is used to retrieve a specific custom page or all custom pages created for a seller's eBay Store. The eBay seller must have an eBay Store subscription to use this call.
   * 
   * <br>
   * @throws ApiException
   * @throws SdkException
   * @throws Exception
   * @return The void object.
   */
  public void getStoreCustomPage()
      throws com.ebay.sdk.ApiException, com.ebay.sdk.SdkException, java.lang.Exception
  {
    GetStoreCustomPageRequestType req;
    req = new GetStoreCustomPageRequestType();
    if (this.pageID != null)
      req.setPageID(this.pageID);

    GetStoreCustomPageResponseType resp = (GetStoreCustomPageResponseType) execute(req);

    this.returnedStoreCustomPageArrayType = resp.getCustomPageArray();

  }

  /**
   * Gets the GetStoreCustomPageRequestType.pageID.
   * @return Long
   */
  public Long getPageID()
  {
    return this.pageID;
  }

  /**
   * Sets the GetStoreCustomPageRequestType.pageID.
   * @param pageID Long
   */
  public void setPageID(Long pageID)
  {
    this.pageID = pageID;
  }

  /**
   * Valid after executing the API.
   * Gets the returned GetStoreCustomPageResponseType.returnedStoreCustomPageArrayType.
   * 
   * @return StoreCustomPageArrayType
   */
  public StoreCustomPageArrayType getReturnedStoreCustomPageArrayType()
  {
    return this.returnedStoreCustomPageArrayType;
  }

}

