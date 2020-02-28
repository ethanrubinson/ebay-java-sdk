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
 * Wrapper class of the GetNotificationPreferences call of eBay SOAP API.
 * <br>
 * <p>Title: SOAP API wrapper library.</p>
 * <p>Description: Contains wrapper classes for eBay SOAP APIs.</p>
 * <p>Copyright: Copyright (c) 2009</p>
 * <p>Company: eBay Inc.</p>
 * <br> <B>Input property:</B> <code>PreferenceLevel</code> - Specifies the type of preferences to retrieve. For example, preferences can be associated with a user, with
 * an application, or with events.
 * <br>
 * <br> <B>Output property:</B> <code>ReturnedApplicationDeliveryPreferences</code> - Specifies application-based event preferences that have been enabled.
 * <br> <B>Output property:</B> <code>ReturnedDeliveryURLName</code> - Specifies application delivery URL Name associated with this user.
 * <br> <B>Output property:</B> <code>ReturnedUserDeliveryPreferenceArray</code> - Specifies user-based event preferences that have been enabled or disabled.
 * <br> <B>Output property:</B> <code>UserData</code> - Returns user data for notification settings, such as set mobile phone.
 * <br> <B>Output property:</B> <code>EventProperty</code> - Contains names and values assigned to a notification event.
 * Currently can only be set for wireless applications.
 * 
 * @author Ron Murphy
 * @version 1.0
 */

public class GetNotificationPreferencesCall extends com.ebay.sdk.ApiCall
{
  
  private NotificationRoleCodeType preferenceLevel = null;
  private ApplicationDeliveryPreferencesType returnedApplicationDeliveryPreferences=null;
  private String returnedDeliveryURLName=null;
  private NotificationEnableArrayType returnedUserDeliveryPreferenceArray=null;
  private NotificationUserDataType userData=null;
  private NotificationEventPropertyType[] eventProperty=null;


  /**
   * Constructor.
   */
  public GetNotificationPreferencesCall() {
  }

  /**
   * Constructor.
   * @param apiContext The ApiContext object to be used to make the call.
   */
  public GetNotificationPreferencesCall(ApiContext apiContext) {
    super(apiContext);
    

  }

  /**
   * Retrieves the requesting application's notification preferences. Details are only returned for events for which a preference has been set. For example, if you enabled notification for the <b>EndOfAuction</b> event and later disabled it, the <b>GetNotificationPreferences</b> response would cite the <b>EndOfAuction</b> event preference as <b>Disabled</b>. Otherwise, no details would be returned regarding <b>EndOfAuction</b>.
   * 
   * <br>
   * @throws ApiException
   * @throws SdkException
   * @throws Exception
   * @return The GetNotificationPreferencesResponseType object.
   */
  public GetNotificationPreferencesResponseType getNotificationPreferences()
      throws com.ebay.sdk.ApiException, com.ebay.sdk.SdkException, java.lang.Exception
  {
    GetNotificationPreferencesRequestType req;
    req = new GetNotificationPreferencesRequestType();
    req.setDetailLevel(this.getDetailLevel());
    if (this.preferenceLevel != null)
      req.setPreferenceLevel(this.preferenceLevel);

    GetNotificationPreferencesResponseType resp = (GetNotificationPreferencesResponseType) execute(req);

    this.returnedApplicationDeliveryPreferences = resp.getApplicationDeliveryPreferences();
    this.returnedDeliveryURLName = resp.getDeliveryURLName();
    this.returnedUserDeliveryPreferenceArray = resp.getUserDeliveryPreferenceArray();
    this.userData = resp.getUserData();
    this.eventProperty = resp.getEventProperty();
    return resp;
  }

  /**
   * Gets the GetNotificationPreferencesRequestType.preferenceLevel.
   * @return NotificationRoleCodeType
   */
  public NotificationRoleCodeType getPreferenceLevel()
  {
    return this.preferenceLevel;
  }

  /**
   * Sets the GetNotificationPreferencesRequestType.preferenceLevel.
   * @param preferenceLevel NotificationRoleCodeType
   */
  public void setPreferenceLevel(NotificationRoleCodeType preferenceLevel)
  {
    this.preferenceLevel = preferenceLevel;
  }

  /**
   * Valid after executing the API.
   * Gets the returned GetNotificationPreferencesResponseType.eventProperty.
   * 
   * @return NotificationEventPropertyType[]
   */
  public NotificationEventPropertyType[] getEventProperty()
  {
    return this.eventProperty;
  }

  /**
   * Valid after executing the API.
   * Gets the returned GetNotificationPreferencesResponseType.returnedApplicationDeliveryPreferences.
   * 
   * @return ApplicationDeliveryPreferencesType
   */
  public ApplicationDeliveryPreferencesType getReturnedApplicationDeliveryPreferences()
  {
    return this.returnedApplicationDeliveryPreferences;
  }

  /**
   * Valid after executing the API.
   * Gets the returned GetNotificationPreferencesResponseType.returnedDeliveryURLName.
   * 
   * @return String
   */
  public String getReturnedDeliveryURLName()
  {
    return this.returnedDeliveryURLName;
  }

  /**
   * Valid after executing the API.
   * Gets the returned GetNotificationPreferencesResponseType.returnedUserDeliveryPreferenceArray.
   * 
   * @return NotificationEnableArrayType
   */
  public NotificationEnableArrayType getReturnedUserDeliveryPreferenceArray()
  {
    return this.returnedUserDeliveryPreferenceArray;
  }

  /**
   * Valid after executing the API.
   * Gets the returned GetNotificationPreferencesResponseType.userData.
   * 
   * @return NotificationUserDataType
   */
  public NotificationUserDataType getUserData()
  {
    return this.userData;
  }

}

