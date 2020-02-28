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
import java.lang.Integer;
import java.util.Calendar;

import com.ebay.sdk.*;
import com.ebay.soap.eBLBaseComponents.*;
/**
 * Wrapper class of the ValidateTestUserRegistration call of eBay SOAP API.
 * <br>
 * <p>Title: SOAP API wrapper library.</p>
 * <p>Description: Contains wrapper classes for eBay SOAP APIs.</p>
 * <p>Copyright: Copyright (c) 2009</p>
 * <p>Company: eBay Inc.</p>
 * <br> <B>Input property:</B> <code>FeedbackStore</code> - Value for the feedback score of a user. If no value is passed in the request,
 * or if the value is zero, the feedback score is unchanged. This element is not intended
 * for regularly testing feedback because the feedback value can change after the request.
 * <br> <B>Input property:</B> <code>RegistrationDate</code> - Value for the date and time that a user's registration begins.
 * <br> <B>Input property:</B> <code>SubscribeSA</code> - This field is no longer applicable since the Seller Assistant feature is no longer available.
 * <br> <B>Input property:</B> <code>SubscribeSAPro</code> - This field is no longer applicable since the Seller Assistant Pro feature is no longer available.
 * <br> <B>Input property:</B> <code>SubscribeSM</code> - Indicates if a user subscribes to Selling Manager. You cannot
 * request to subscribe a user to both Selling Manager and
 * Selling Manager Pro. You cannot request to unsubscribe a user.
 * <br> <B>Input property:</B> <code>SubscribeSMPro</code> - Indicates if a user subscribes to Selling Manager Pro. You cannot
 * request to subscribe a user to both Selling Manager and
 * Selling Manager Pro. You cannot request to unsubscribe a user.
 * 
 * @author Ron Murphy
 * @version 1.0
 */

public class ValidateTestUserRegistrationCall extends com.ebay.sdk.ApiCall
{
  
  private Integer feedbackStore = null;
  private Calendar registrationDate = null;
  private Boolean subscribeSA = null;
  private Boolean subscribeSAPro = null;
  private Boolean subscribeSM = null;
  private Boolean subscribeSMPro = null;


  /**
   * Constructor.
   */
  public ValidateTestUserRegistrationCall() {
  }

  /**
   * Constructor.
   * @param apiContext The ApiContext object to be used to make the call.
   */
  public ValidateTestUserRegistrationCall(ApiContext apiContext) {
    super(apiContext);
    

  }

  /**
   * Requests to enable a test user to sell items in the Sandbox environment.
   * 
   * <br>
   * @throws ApiException
   * @throws SdkException
   * @throws Exception
   * @return The void object.
   */
  public void validateTestUserRegistration()
      throws com.ebay.sdk.ApiException, com.ebay.sdk.SdkException, java.lang.Exception
  {
    ValidateTestUserRegistrationRequestType req;
    req = new ValidateTestUserRegistrationRequestType();
    req.setDetailLevel(this.getDetailLevel());
    if (this.feedbackStore != null)
      req.setFeedbackScore(this.feedbackStore);
    if (this.registrationDate != null)
      req.setRegistrationDate(this.registrationDate);
    if (this.subscribeSA != null)
      req.setSubscribeSA(this.subscribeSA);
    if (this.subscribeSAPro != null)
      req.setSubscribeSAPro(this.subscribeSAPro);
    if (this.subscribeSM != null)
      req.setSubscribeSM(this.subscribeSM);
    if (this.subscribeSMPro != null)
      req.setSubscribeSMPro(this.subscribeSMPro);

    ValidateTestUserRegistrationResponseType resp = (ValidateTestUserRegistrationResponseType) execute(req);


  }

  /**
   * Gets the ValidateTestUserRegistrationRequestType.feedbackStore.
   * @return Integer
   */
  public Integer getFeedbackStore()
  {
    return this.feedbackStore;
  }

  /**
   * Sets the ValidateTestUserRegistrationRequestType.feedbackStore.
   * @param feedbackStore Integer
   */
  public void setFeedbackStore(Integer feedbackStore)
  {
    this.feedbackStore = feedbackStore;
  }

  /**
   * Gets the ValidateTestUserRegistrationRequestType.registrationDate.
   * @return Calendar
   */
  public Calendar getRegistrationDate()
  {
    return this.registrationDate;
  }

  /**
   * Sets the ValidateTestUserRegistrationRequestType.registrationDate.
   * @param registrationDate Calendar
   */
  public void setRegistrationDate(Calendar registrationDate)
  {
    this.registrationDate = registrationDate;
  }

  /**
   * Gets the ValidateTestUserRegistrationRequestType.subscribeSA.
   * @return Boolean
   */
  public Boolean getSubscribeSA()
  {
    return this.subscribeSA;
  }

  /**
   * Sets the ValidateTestUserRegistrationRequestType.subscribeSA.
   * @param subscribeSA Boolean
   */
  public void setSubscribeSA(Boolean subscribeSA)
  {
    this.subscribeSA = subscribeSA;
  }

  /**
   * Gets the ValidateTestUserRegistrationRequestType.subscribeSAPro.
   * @return Boolean
   */
  public Boolean getSubscribeSAPro()
  {
    return this.subscribeSAPro;
  }

  /**
   * Sets the ValidateTestUserRegistrationRequestType.subscribeSAPro.
   * @param subscribeSAPro Boolean
   */
  public void setSubscribeSAPro(Boolean subscribeSAPro)
  {
    this.subscribeSAPro = subscribeSAPro;
  }

  /**
   * Gets the ValidateTestUserRegistrationRequestType.subscribeSM.
   * @return Boolean
   */
  public Boolean getSubscribeSM()
  {
    return this.subscribeSM;
  }

  /**
   * Sets the ValidateTestUserRegistrationRequestType.subscribeSM.
   * @param subscribeSM Boolean
   */
  public void setSubscribeSM(Boolean subscribeSM)
  {
    this.subscribeSM = subscribeSM;
  }

  /**
   * Gets the ValidateTestUserRegistrationRequestType.subscribeSMPro.
   * @return Boolean
   */
  public Boolean getSubscribeSMPro()
  {
    return this.subscribeSMPro;
  }

  /**
   * Sets the ValidateTestUserRegistrationRequestType.subscribeSMPro.
   * @param subscribeSMPro Boolean
   */
  public void setSubscribeSMPro(Boolean subscribeSMPro)
  {
    this.subscribeSMPro = subscribeSMPro;
  }

}

