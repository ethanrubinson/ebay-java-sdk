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
 * Wrapper class of the RevokeToken call of eBay SOAP API.
 * <br>
 * <p>Title: SOAP API wrapper library.</p>
 * <p>Description: Contains wrapper classes for eBay SOAP APIs.</p>
 * <p>Copyright: Copyright (c) 2009</p>
 * <p>Company: eBay Inc.</p>
 * <br> <B>Input property:</B> <code>UnsubscribeNotification</code> - Cancels notification subscriptions for the user/application if set to true. Default value is false.
 * 
 * @author Ron Murphy
 * @version 1.0
 */

public class RevokeTokenCall extends com.ebay.sdk.ApiCall
{
  
  private Boolean unsubscribeNotification = null;


  /**
   * Constructor.
   */
  public RevokeTokenCall() {
  }

  /**
   * Constructor.
   * @param apiContext The ApiContext object to be used to make the call.
   */
  public RevokeTokenCall(ApiContext apiContext) {
    super(apiContext);
    

  }

  /**
   * Revokes a token before it would otherwise expire.
   * 
   * <br>
   * @throws ApiException
   * @throws SdkException
   * @throws Exception
   * @return The void object.
   */
  public void revokeToken()
      throws com.ebay.sdk.ApiException, com.ebay.sdk.SdkException, java.lang.Exception
  {
    RevokeTokenRequestType req;
    req = new RevokeTokenRequestType();
    if (this.unsubscribeNotification != null)
      req.setUnsubscribeNotification(this.unsubscribeNotification);

    RevokeTokenResponseType resp = (RevokeTokenResponseType) execute(req);


  }

  /**
   * Gets the RevokeTokenRequestType.unsubscribeNotification.
   * @return Boolean
   */
  public Boolean getUnsubscribeNotification()
  {
    return this.unsubscribeNotification;
  }

  /**
   * Sets the RevokeTokenRequestType.unsubscribeNotification.
   * @param unsubscribeNotification Boolean
   */
  public void setUnsubscribeNotification(Boolean unsubscribeNotification)
  {
    this.unsubscribeNotification = unsubscribeNotification;
  }

}

