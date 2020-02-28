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
 * Wrapper class of the GeteBayOfficialTime call of eBay SOAP API.
 * <br>
 * <p>Title: SOAP API wrapper library.</p>
 * <p>Description: Contains wrapper classes for eBay SOAP APIs.</p>
 * <p>Copyright: Copyright (c) 2009</p>
 * <p>Company: eBay Inc.</p>
 * 
 * @author Ron Murphy
 * @version 1.0
 */

public class GeteBayOfficialTimeCall extends com.ebay.sdk.ApiCall
{
  


  /**
   * Constructor.
   */
  public GeteBayOfficialTimeCall() {
  }

  /**
   * Constructor.
   * @param apiContext The ApiContext object to be used to make the call.
   */
  public GeteBayOfficialTimeCall(ApiContext apiContext) {
    super(apiContext);
    

  }

  /**
   * Gets the official eBay system time in GMT.
   * 
   * <br>
   * @throws ApiException
   * @throws SdkException
   * @throws Exception
   * @return The java.util.Calendar object.
   */
  public java.util.Calendar geteBayOfficialTime()
      throws com.ebay.sdk.ApiException, com.ebay.sdk.SdkException, java.lang.Exception
  {
    GeteBayOfficialTimeRequestType req;
    req = new GeteBayOfficialTimeRequestType();

    GeteBayOfficialTimeResponseType resp = (GeteBayOfficialTimeResponseType) execute(req);

    return resp == null? null: resp.getTimestamp();

  }

}

