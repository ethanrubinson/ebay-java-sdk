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
 * Wrapper class of the SetNotificationPreferences call of eBay SOAP API.
 * <br>
 * <p>Title: SOAP API wrapper library.</p>
 * <p>Description: Contains wrapper classes for eBay SOAP APIs.</p>
 * <p>Copyright: Copyright (c) 2009</p>
 * <p>Company: eBay Inc.</p>
 * <br> <B>Input property:</B> <code>ApplicationDeliveryPreferences</code> - Specifies application-level event preferences that have been enabled,
 * including the URL to which notifications should be delivered and whether
 * notifications should be enabled or disabled (although the
 * <b>UserDeliveryPreferenceArray</b> input property specifies specific
 * notification subscriptions).
 * <br> <B>Input property:</B> <code>UserDeliveryPreferenceArray</code> - Specifies events and whether or not they are enabled.
 * <br> <B>Input property:</B> <code>UserData</code> - Specifies user data for notification settings, such as mobile phone number.
 * <br> <B>Input property:</B> <code>EventProperty</code> - Characteristics or details of an event such as type, name and value.
 * Currently can only be set for wireless applications.
 * <br> <B>Input property:</B> <code>DeliveryURLName</code> - Specifies up to 25 ApplicationDeliveryPreferences.DeliveryURLDetails.DeliveryURLName to associate with a user token sent in a SetNotificationPreferences request. To specify multiple DeliveryURLNames, create separate instances of ApplicationDeliveryPreferences.DeliveryURLDetails.DeliveryURLName, and then enable up to 25 DeliveryURLNames by including them in comma-separated format in this field.
 * 
 * @author Ron Murphy
 * @version 1.0
 */

public class SetNotificationPreferencesCall extends com.ebay.sdk.ApiCall
{
  
  private ApplicationDeliveryPreferencesType applicationDeliveryPreferences = null;
  private NotificationEnableArrayType userDeliveryPreferenceArray = null;
  private NotificationUserDataType userData = null;
  private NotificationEventPropertyType[] eventProperty = null;
  private String deliveryURLName = null;


  /**
   * Constructor.
   */
  public SetNotificationPreferencesCall() {
  }

  /**
   * Constructor.
   * @param apiContext The ApiContext object to be used to make the call.
   */
  public SetNotificationPreferencesCall(ApiContext apiContext) {
    super(apiContext);
    

  }

  /**
   * Manages notification and alert preferences for applications and users.
   * 
   * <br>
   * @throws ApiException
   * @throws SdkException
   * @throws Exception
   * @return The SetNotificationPreferencesResponseType object.
   */
  public SetNotificationPreferencesResponseType setNotificationPreferences()
      throws com.ebay.sdk.ApiException, com.ebay.sdk.SdkException, java.lang.Exception
  {
    SetNotificationPreferencesRequestType req;
    req = new SetNotificationPreferencesRequestType();
    if (this.applicationDeliveryPreferences != null)
      req.setApplicationDeliveryPreferences(this.applicationDeliveryPreferences);
    if (this.userDeliveryPreferenceArray != null)
      req.setUserDeliveryPreferenceArray(this.userDeliveryPreferenceArray);
    if (this.userData != null)
      req.setUserData(this.userData);
    if (this.eventProperty != null)
      req.setEventProperty(this.eventProperty);
    if (this.deliveryURLName != null)
      req.setDeliveryURLName(this.deliveryURLName);

    SetNotificationPreferencesResponseType resp = (SetNotificationPreferencesResponseType) execute(req);

    return resp;
  }

  /**
   * Gets the SetNotificationPreferencesRequestType.applicationDeliveryPreferences.
   * @return ApplicationDeliveryPreferencesType
   */
  public ApplicationDeliveryPreferencesType getApplicationDeliveryPreferences()
  {
    return this.applicationDeliveryPreferences;
  }

  /**
   * Sets the SetNotificationPreferencesRequestType.applicationDeliveryPreferences.
   * @param applicationDeliveryPreferences ApplicationDeliveryPreferencesType
   */
  public void setApplicationDeliveryPreferences(ApplicationDeliveryPreferencesType applicationDeliveryPreferences)
  {
    this.applicationDeliveryPreferences = applicationDeliveryPreferences;
  }

  /**
   * Gets the SetNotificationPreferencesRequestType.deliveryURLName.
   * @return String
   */
  public String getDeliveryURLName()
  {
    return this.deliveryURLName;
  }

  /**
   * Sets the SetNotificationPreferencesRequestType.deliveryURLName.
   * @param deliveryURLName String
   */
  public void setDeliveryURLName(String deliveryURLName)
  {
    this.deliveryURLName = deliveryURLName;
  }

  /**
   * Gets the SetNotificationPreferencesRequestType.eventProperty.
   * @return NotificationEventPropertyType[]
   */
  public NotificationEventPropertyType[] getEventProperty()
  {
    return this.eventProperty;
  }

  /**
   * Sets the SetNotificationPreferencesRequestType.eventProperty.
   * @param eventProperty NotificationEventPropertyType[]
   */
  public void setEventProperty(NotificationEventPropertyType[] eventProperty)
  {
    this.eventProperty = eventProperty;
  }

  /**
   * Gets the SetNotificationPreferencesRequestType.userData.
   * @return NotificationUserDataType
   */
  public NotificationUserDataType getUserData()
  {
    return this.userData;
  }

  /**
   * Sets the SetNotificationPreferencesRequestType.userData.
   * @param userData NotificationUserDataType
   */
  public void setUserData(NotificationUserDataType userData)
  {
    this.userData = userData;
  }

  /**
   * Gets the SetNotificationPreferencesRequestType.userDeliveryPreferenceArray.
   * @return NotificationEnableArrayType
   */
  public NotificationEnableArrayType getUserDeliveryPreferenceArray()
  {
    return this.userDeliveryPreferenceArray;
  }

  /**
   * Sets the SetNotificationPreferencesRequestType.userDeliveryPreferenceArray.
   * @param userDeliveryPreferenceArray NotificationEnableArrayType
   */
  public void setUserDeliveryPreferenceArray(NotificationEnableArrayType userDeliveryPreferenceArray)
  {
    this.userDeliveryPreferenceArray = userDeliveryPreferenceArray;
  }

}

