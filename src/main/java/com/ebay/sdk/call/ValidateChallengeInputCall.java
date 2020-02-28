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
import java.lang.String;

import com.ebay.sdk.*;
import com.ebay.soap.eBLBaseComponents.*;
/**
 * Wrapper class of the ValidateChallengeInput call of eBay SOAP API.
 * <br>
 * <p>Title: SOAP API wrapper library.</p>
 * <p>Description: Contains wrapper classes for eBay SOAP APIs.</p>
 * <p>Copyright: Copyright (c) 2009</p>
 * <p>Company: eBay Inc.</p>
 * <br> <B>Input property:</B> <code>ChallengeToken</code> - Botblock token that was returned by <b>GetChallengeToken</b>.
 * <br> <B>Input property:</B> <code>UserInput</code> - User response to a bot block challenge.
 * <br> <B>Input property:</B> <code>KeepTokenValid</code> - This boolean field is included and set to 'true' if the challenge token should remain valid for up to two minutes.
 * <br> <B>Output property:</B> <code>ReturnedValidToken</code> - Indicates whether the token is valid.
 * 
 * @author Ron Murphy
 * @version 1.0
 */

public class ValidateChallengeInputCall extends com.ebay.sdk.ApiCall
{
  
  private String challengeToken = null;
  private String userInput = null;
  private Boolean keepTokenValid = null;
  private Boolean returnedValidToken=null;


  /**
   * Constructor.
   */
  public ValidateChallengeInputCall() {
  }

  /**
   * Constructor.
   * @param apiContext The ApiContext object to be used to make the call.
   */
  public ValidateChallengeInputCall(ApiContext apiContext) {
    super(apiContext);
    

  }

  /**
   * Validates the user response to a <b class="con">GetChallengeToken</b>
   * botblock challenge.
   * 
   * <br>
   * @throws ApiException
   * @throws SdkException
   * @throws Exception
   * @return The Boolean object.
   */
  public Boolean validateChallengeInput()
      throws com.ebay.sdk.ApiException, com.ebay.sdk.SdkException, java.lang.Exception
  {
    ValidateChallengeInputRequestType req;
    req = new ValidateChallengeInputRequestType();
    if (this.challengeToken != null)
      req.setChallengeToken(this.challengeToken);
    if (this.userInput != null)
      req.setUserInput(this.userInput);
    if (this.keepTokenValid != null)
      req.setKeepTokenValid(this.keepTokenValid);

    ValidateChallengeInputResponseType resp = (ValidateChallengeInputResponseType) execute(req);

    this.returnedValidToken = resp.isValidToken();
    return this.getReturnedValidToken();
  }

  /**
   * Gets the ValidateChallengeInputRequestType.challengeToken.
   * @return String
   */
  public String getChallengeToken()
  {
    return this.challengeToken;
  }

  /**
   * Sets the ValidateChallengeInputRequestType.challengeToken.
   * @param challengeToken String
   */
  public void setChallengeToken(String challengeToken)
  {
    this.challengeToken = challengeToken;
  }

  /**
   * Gets the ValidateChallengeInputRequestType.keepTokenValid.
   * @return Boolean
   */
  public Boolean getKeepTokenValid()
  {
    return this.keepTokenValid;
  }

  /**
   * Sets the ValidateChallengeInputRequestType.keepTokenValid.
   * @param keepTokenValid Boolean
   */
  public void setKeepTokenValid(Boolean keepTokenValid)
  {
    this.keepTokenValid = keepTokenValid;
  }

  /**
   * Gets the ValidateChallengeInputRequestType.userInput.
   * @return String
   */
  public String getUserInput()
  {
    return this.userInput;
  }

  /**
   * Sets the ValidateChallengeInputRequestType.userInput.
   * @param userInput String
   */
  public void setUserInput(String userInput)
  {
    this.userInput = userInput;
  }

  /**
   * Valid after executing the API.
   * Gets the returned ValidateChallengeInputResponseType.returnedValidToken.
   * 
   * @return Boolean
   */
  public Boolean getReturnedValidToken()
  {
    return this.returnedValidToken;
  }

}

