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

import com.ebay.sdk.*;
import com.ebay.soap.eBLBaseComponents.*;
/**
 * Wrapper class of the ConfirmIdentity call of eBay SOAP API.
 * <br>
 * <p>Title: SOAP API wrapper library.</p>
 * <p>Description: Contains wrapper classes for eBay SOAP APIs.</p>
 * <p>Copyright: Copyright (c) 2009</p>
 * <p>Company: eBay Inc.</p>
 * <br> <B>Input property:</B> <code>SessionID</code> - A string obtained by making a <b>GetSessionID</b> call, passed in redirect URL to the eBay signin page.
 * <br> <B>Output property:</B> <code>ReturnedUserID</code> - Unique eBay user ID for the user.
 * 
 * @author Ron Murphy
 * @version 1.0
 */

public class ConfirmIdentityCall extends com.ebay.sdk.ApiCall
{
  
  private String sessionID = null;
  private String returnedUserID=null;


  /**
   * Constructor.
   */
  public ConfirmIdentityCall() {
  }

  /**
   * Constructor.
   * @param apiContext The ApiContext object to be used to make the call.
   */
  public ConfirmIdentityCall(ApiContext apiContext) {
    super(apiContext);
    

  }

  /**
   * Returns the ID of a user who has gone through an application's consent flow
   * process for obtaining an authorization token.
   * 
   * <br>
   * @throws ApiException
   * @throws SdkException
   * @throws Exception
   * @return The String object.
   */
  public String confirmIdentity()
      throws com.ebay.sdk.ApiException, com.ebay.sdk.SdkException, java.lang.Exception
  {
    ConfirmIdentityRequestType req;
    req = new ConfirmIdentityRequestType();
    if (this.sessionID != null)
      req.setSessionID(this.sessionID);

    ConfirmIdentityResponseType resp = (ConfirmIdentityResponseType) execute(req);

    this.returnedUserID = resp.getUserID();
    return this.getReturnedUserID();
  }

  /**
   * Gets the ConfirmIdentityRequestType.sessionID.
   * @return String
   */
  public String getSessionID()
  {
    return this.sessionID;
  }

  /**
   * Sets the ConfirmIdentityRequestType.sessionID.
   * @param sessionID String
   */
  public void setSessionID(String sessionID)
  {
    this.sessionID = sessionID;
  }

  /**
   * Valid after executing the API.
   * Gets the returned ConfirmIdentityResponseType.returnedUserID.
   * 
   * @return String
   */
  public String getReturnedUserID()
  {
    return this.returnedUserID;
  }

}

