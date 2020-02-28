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
import java.lang.String;
import java.util.Calendar;

import com.ebay.sdk.*;
import com.ebay.soap.eBLBaseComponents.*;
/**
 * Wrapper class of the GetDescriptionTemplates call of eBay SOAP API.
 * <br>
 * <p>Title: SOAP API wrapper library.</p>
 * <p>Description: Contains wrapper classes for eBay SOAP APIs.</p>
 * <p>Copyright: Copyright (c) 2009</p>
 * <p>Company: eBay Inc.</p>
 * <br> <B>Input property:</B> <code>CategoryID</code> - A <b>CategoryID</b> value can be specified if the seller would like to only see the Listing Designer templates that are available for that eBay category. This field will be ignored if the <b>MotorVehicles</b> boolean field is also included in the call request and set to <code>true</code>.
 * <br> <B>Input property:</B> <code>LastModifiedTime</code> - This dateTime filter can be included and used if the user only wants to check for recently-added Listing Designer templates. If this filter is used, only the Listing Designer templates that have been added/modified after the specified timestamp will be returned in the response.
 * <br/><br/>
 * Typically, you will pass in the timestamp value that was returned the last time you refreshed the list of Listing Designer templates.
 * <br> <B>Input property:</B> <code>MotorVehicles</code> - This boolean field should be included and set to <code>true</code> if the user would only like to see the Listing Designer templates that are available for motor vehicle categories. This field will override any <b>CategoryID</b> value that is specified in the call request.
 * <br>
 * <br>
 * <span class="tablenote"><b>Note:</b>
 * Motor vehicle-related Listing Designer templates are only available for eBay Motors on the US and Canada (English) marketplaces. To retrieve eBay US Motors Listing Designer templates, the <b>SITEID</b> HTTP header value must be set to <code>100</code>, which is the identifier of the eBay US Motors vertical (ebay.com/motors).
 * </span>
 * <br> <B>Output property:</B> <code>ReturnedDescriptionTemplate</code> - A <b>DescriptionTemplate</b> container is retrieved for each available Listing Designer template. Each <b>DescriptionTemplate</b> container includes the unique identifier of the template, the Listing Designer Theme Group that it belongs to, the CDATA representation of the Listing Designer template, and the URL to an image that serves as an example of the Listing Designer template.
 * <br> <B>Output property:</B> <code>ReturnedLayoutTotal</code> - This integer value indicates the total number of Listing Designer Layout templates that were retrieved. This field is always returned, even if it is <code>0</code>
 * <br> <B>Output property:</B> <code>ReturnedObsoleteLayoutID</code> - The unique identifier of a Listing Designer Layout template that is now obsolete. An <b>ObsoleteLayoutID</b> field is returned for each obsolete Listing Designer Layout template.
 * <br> <B>Output property:</B> <code>ReturnedObsoleteThemeID</code> - The unique identifier of a Listing Designer Theme template that is now obsolete. An <b>ObsoleteThemeID</b> field is returned for each obsolete Listing Designer Theme template.
 * <br> <B>Output property:</B> <code>ReturnedThemeGroup</code> - A <b>ThemeGroup</b> container is retrieved for each available Listing Designer Theme Group. Each <b>ThemeGroup</b> container includes the unique identifier of the Theme Group, the Theme Group name, and all of the Listing Designer Theme template that belong to that Theme Group.
 * <br> <B>Output property:</B> <code>ReturnedThemeTotal</code> - This integer value indicates the total number of Listing Designer Theme templates that were retrieved. This field is always returned, even if it is <code>0</code>
 * 
 * @author Ron Murphy
 * @version 1.0
 */

public class GetDescriptionTemplatesCall extends com.ebay.sdk.ApiCall
{
  
  private String categoryID = null;
  private Calendar lastModifiedTime = null;
  private Boolean motorVehicles = null;
  private DescriptionTemplateType[] returnedDescriptionTemplate=null;
  private int returnedLayoutTotal=0;
  private int[] returnedObsoleteLayoutID=null;
  private int[] returnedObsoleteThemeID=null;
  private ThemeGroupType[] returnedThemeGroup=null;
  private int returnedThemeTotal=0;


  /**
   * Constructor.
   */
  public GetDescriptionTemplatesCall() {
  }

  /**
   * Constructor.
   * @param apiContext The ApiContext object to be used to make the call.
   */
  public GetDescriptionTemplatesCall(ApiContext apiContext) {
    super(apiContext);
    

  }

  /**
   * This is the base request type for the <b>GetDescriptionTemplates</b> call. This call retrieves detailed information on the Listing Designer templates that are available for use by the seller.
   * 
   * <br>
   * @throws ApiException
   * @throws SdkException
   * @throws Exception
   * @return The void object.
   */
  public void getDescriptionTemplates()
      throws com.ebay.sdk.ApiException, com.ebay.sdk.SdkException, java.lang.Exception
  {
    GetDescriptionTemplatesRequestType req;
    req = new GetDescriptionTemplatesRequestType();
    if (this.categoryID != null)
      req.setCategoryID(this.categoryID);
    if (this.lastModifiedTime != null)
      req.setLastModifiedTime(this.lastModifiedTime);
    if (this.motorVehicles != null)
      req.setMotorVehicles(this.motorVehicles);

    GetDescriptionTemplatesResponseType resp = (GetDescriptionTemplatesResponseType) execute(req);

    this.returnedDescriptionTemplate = resp.getDescriptionTemplate();
    this.returnedLayoutTotal = (resp.getLayoutTotal() == null? 0: resp.getLayoutTotal().intValue());
    this.returnedObsoleteLayoutID = resp.getObsoleteLayoutID();
    this.returnedObsoleteThemeID = resp.getObsoleteThemeID();
    this.returnedThemeGroup = resp.getThemeGroup();
    this.returnedThemeTotal = (resp.getThemeTotal() == null? 0: resp.getThemeTotal().intValue());

  }

  /**
   * Gets the GetDescriptionTemplatesRequestType.categoryID.
   * @return String
   */
  public String getCategoryID()
  {
    return this.categoryID;
  }

  /**
   * Sets the GetDescriptionTemplatesRequestType.categoryID.
   * @param categoryID String
   */
  public void setCategoryID(String categoryID)
  {
    this.categoryID = categoryID;
  }

  /**
   * Gets the GetDescriptionTemplatesRequestType.lastModifiedTime.
   * @return Calendar
   */
  public Calendar getLastModifiedTime()
  {
    return this.lastModifiedTime;
  }

  /**
   * Sets the GetDescriptionTemplatesRequestType.lastModifiedTime.
   * @param lastModifiedTime Calendar
   */
  public void setLastModifiedTime(Calendar lastModifiedTime)
  {
    this.lastModifiedTime = lastModifiedTime;
  }

  /**
   * Gets the GetDescriptionTemplatesRequestType.motorVehicles.
   * @return Boolean
   */
  public Boolean getMotorVehicles()
  {
    return this.motorVehicles;
  }

  /**
   * Sets the GetDescriptionTemplatesRequestType.motorVehicles.
   * @param motorVehicles Boolean
   */
  public void setMotorVehicles(Boolean motorVehicles)
  {
    this.motorVehicles = motorVehicles;
  }

  /**
   * Valid after executing the API.
   * Gets the returned GetDescriptionTemplatesResponseType.returnedDescriptionTemplate.
   * 
   * @return DescriptionTemplateType[]
   */
  public DescriptionTemplateType[] getReturnedDescriptionTemplate()
  {
    return this.returnedDescriptionTemplate;
  }

  /**
   * Valid after executing the API.
   * Gets the returned GetDescriptionTemplatesResponseType.returnedLayoutTotal.
   * 
   * @return int
   */
  public int getReturnedLayoutTotal()
  {
    return this.returnedLayoutTotal;
  }

  /**
   * Valid after executing the API.
   * Gets the returned GetDescriptionTemplatesResponseType.returnedObsoleteLayoutID.
   * 
   * @return int[]
   */
  public int[] getReturnedObsoleteLayoutID()
  {
    return this.returnedObsoleteLayoutID;
  }

  /**
   * Valid after executing the API.
   * Gets the returned GetDescriptionTemplatesResponseType.returnedObsoleteThemeID.
   * 
   * @return int[]
   */
  public int[] getReturnedObsoleteThemeID()
  {
    return this.returnedObsoleteThemeID;
  }

  /**
   * Valid after executing the API.
   * Gets the returned GetDescriptionTemplatesResponseType.returnedThemeGroup.
   * 
   * @return ThemeGroupType[]
   */
  public ThemeGroupType[] getReturnedThemeGroup()
  {
    return this.returnedThemeGroup;
  }

  /**
   * Valid after executing the API.
   * Gets the returned GetDescriptionTemplatesResponseType.returnedThemeTotal.
   * 
   * @return int
   */
  public int getReturnedThemeTotal()
  {
    return this.returnedThemeTotal;
  }

}

