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
 * Wrapper class of the GetChallengeToken call of eBay SOAP API.
 * <br>
 * <p>Title: SOAP API wrapper library.</p>
 * <p>Description: Contains wrapper classes for eBay SOAP APIs.</p>
 * <p>Copyright: Copyright (c) 2009</p>
 * <p>Company: eBay Inc.</p>
 * <br> <B>Output property:</B> <code>ReturnedChallengeToken</code> - Botblock token that is used to validate that the user is a human and not a bot.
 * <br> <B>Output property:</B> <code>ReturnedImageChallengeURL</code> - The URL of the image your application should display to
 * the user for a botblock challenge.
 * <br> <B>Output property:</B> <code>ReturnedAudioChallengeURL</code> - The URL of the audio clip your application should provide for sight-impaired users.
 * The audio clip corresponds to the image.
 * 
 * @author Ron Murphy
 * @version 1.0
 */

public class GetChallengeTokenCall extends com.ebay.sdk.ApiCall
{
  
  private String returnedChallengeToken=null;
  private String returnedImageChallengeURL=null;
  private String returnedAudioChallengeURL=null;


  /**
   * Constructor.
   */
  public GetChallengeTokenCall() {
  }

  /**
   * Constructor.
   * @param apiContext The ApiContext object to be used to make the call.
   */
  public GetChallengeTokenCall(ApiContext apiContext) {
    super(apiContext);
    

  }

  /**
   * This is the base request type for the <b>GetChallengeToken</b> call. This call retrieves a botblock token and URLs for an image or audio clip that the user is to match.
   * <br/><br/>
   * This call does not have any call-specific input parameters.
   * 
   * <br>
   * @throws ApiException
   * @throws SdkException
   * @throws Exception
   * @return The String object.
   */
  public String getChallengeToken()
      throws com.ebay.sdk.ApiException, com.ebay.sdk.SdkException, java.lang.Exception
  {
    GetChallengeTokenRequestType req;
    req = new GetChallengeTokenRequestType();

    GetChallengeTokenResponseType resp = (GetChallengeTokenResponseType) execute(req);

    this.returnedChallengeToken = resp.getChallengeToken();
    this.returnedImageChallengeURL = resp.getImageChallengeURL();
    this.returnedAudioChallengeURL = resp.getAudioChallengeURL();
    return this.getReturnedChallengeToken();
  }

  /**
   * Valid after executing the API.
   * Gets the returned GetChallengeTokenResponseType.returnedAudioChallengeURL.
   * 
   * @return String
   */
  public String getReturnedAudioChallengeURL()
  {
    return this.returnedAudioChallengeURL;
  }

  /**
   * Valid after executing the API.
   * Gets the returned GetChallengeTokenResponseType.returnedChallengeToken.
   * 
   * @return String
   */
  public String getReturnedChallengeToken()
  {
    return this.returnedChallengeToken;
  }

  /**
   * Valid after executing the API.
   * Gets the returned GetChallengeTokenResponseType.returnedImageChallengeURL.
   * 
   * @return String
   */
  public String getReturnedImageChallengeURL()
  {
    return this.returnedImageChallengeURL;
  }

}

