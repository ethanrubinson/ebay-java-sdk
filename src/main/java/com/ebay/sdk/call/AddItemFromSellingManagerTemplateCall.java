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
import java.lang.String;
import java.util.Calendar;

import com.ebay.sdk.*;
import com.ebay.soap.eBLBaseComponents.*;
/**
 * Wrapper class of the AddItemFromSellingManagerTemplate call of eBay SOAP API.
 * <br>
 * <p>Title: SOAP API wrapper library.</p>
 * <p>Description: Contains wrapper classes for eBay SOAP APIs.</p>
 * <p>Copyright: Copyright (c) 2009</p>
 * <p>Company: eBay Inc.</p>
 * <br> <B>Input property:</B> <code>SaleTemplateID</code> - The unique identifier of the Selling Manager template that a seller is  using to create a listing. Unique identifiers of Selling Manager templates can be retrieved programatically by using the <b>GetSellingManagerInventory</b> call.
 * <br> <B>Input property:</B> <code>ScheduleTime</code> - This field allows the user to specify a time in the future when the listing being created becomes active. If this field is not used, the listing will become active immediately upon being created successfully. The time in this field should be specified in GMT format.
 * <br> <B>Input property:</B> <code>Item</code> - This container is intended for specifying setting in the listing that differ from values in the Selling Manager template being used.
 * <br><br>
 * <span class="tablenote"><strong>Note:</strong>
 * Only the following three values of <b>ItemType</b> may be used for a <b>AddItemFromSellingManagerTemplate</b> call: <b>CategoryMappingAllowed</b>, <b>PaymentMethods</b>, and <b>PayPalEmailAddress</b>.
 * <br> <B>Output property:</B> <code>ReturnedItemID</code> - Unique identifier for the new listing. This field is returned as long as the listing was successfully created.
 * <br> <B>Output property:</B> <code>ReturnedStartTime</code> - Starting date and time for the new listing. This value is based on the time the listing was received and processed, or the time the item will be listed if the seller included the <b>ScheduleTime</b> field in the request and set a custom start time of the listing (in the future).
 * <br> <B>Output property:</B> <code>ReturnedEndTime</code> - Date and time when the new listing is scheduled to end based on the start time and the listing duration value that was set in the <b>ListingDuration</b> field at listing time. If the value of <b>ListingDuration</b> was set to <code>GTC</code> (Good 'Til Cancelled) this value will be set 30 days ahead of the start time, although this value will be updated if the GTC listing is still alive and automatically renewed 30 days after start time. Note that GTC is not an option with auction listings.
 * <br><br>
 * <span class="tablenote"><b>Note: </b>
 * As of July 1, 2019, the Good 'Til Cancelled renewal schedule has been modified from every 30 days to once per calendar month. For example, if a GTC listing is created July 5, the next monthly renewal date will be August 5. If a GTC listing is created on the 31st of the month, but the following month only has 30 days, the renewal will happen on the 30th in the following month. Finally, if a GTC listing is created on January 29-31, the renewal will happen on February 28th (or 29th during a 'Leap Year'). See the
 * <a href="https://pages.ebay.com/seller-center/seller-updates/2019-spring/marketplace-updates.html#good-til-cancelled" target="_blank">Good 'Til Cancelled listings update</a> in the <b>Spring 2019 Seller Updates</b> for more information about this change.
 * </span>
 * <br> <B>Output property:</B> <code>ReturnedFees</code> - This container is an array of fees associated with the creation of the listing. The fees do not include the Final Value Fee (FVF), which cannot be determined until an item is sold.
 * <br> <B>Output property:</B> <code>ReturnedCategoryID</code> - The unique identifier of the primary category in which the item was listed. This field is only returned if the <b>Item.CategoryMappingAllowed</b> boolean field is set to <code>true</code> in the request (or omitted) and the Category ID passed in as the primary listing category was automatically mapped to a new Category ID by eBay. If the primary category ID passed in the request is still active/valid, this field is not returned.
 * <br/><br/>
 * <span class="tablenote"><b>Note: </b> The <b>Item.CategoryMappingAllowed</b> field value in the request now defaults to <code>true</code> if omitted. Previously, the default value was <code>false</code>, so a user had to include this field and set it to <code>true</code> in order for eBay to map an outdated Primary or Secondary Category ID to the updated Category ID.
 * </span>
 * <br> <B>Output property:</B> <code>ReturnedCategory2ID</code> - Unique identifier of the secondary category in which the item was listed. This field is only returned if the <b>Item.CategoryMappingAllowed</b> boolean field is set to <code>true</code> in the request (or omitted) and the Category ID passed in as the secondary listing category was automatically mapped to a new Category ID by eBay. If the secondary category ID passed in the request is still active/valid, this field is not returned.
 * <br/><br/>
 * <span class="tablenote"><b>Note: </b> The <b>Item.CategoryMappingAllowed</b> field value in the request now defaults to <code>true</code> if omitted. Previously, the default value was <code>false</code>, so a user had to include this field and set it to <code>true</code> in order for eBay to map an outdated Primary or Secondary Category ID to the updated Category ID.
 * </span>
 * 
 * @author Ron Murphy
 * @version 1.0
 */

public class AddItemFromSellingManagerTemplateCall extends com.ebay.sdk.ApiCall
{
  
  private Long saleTemplateID = null;
  private Calendar scheduleTime = null;
  private ItemType item = null;
  private String returnedItemID=null;
  private Calendar returnedStartTime=null;
  private Calendar returnedEndTime=null;
  private FeesType returnedFees=null;
  private String returnedCategoryID=null;
  private String returnedCategory2ID=null;


  /**
   * Constructor.
   */
  public AddItemFromSellingManagerTemplateCall() {
  }

  /**
   * Constructor.
   * @param apiContext The ApiContext object to be used to make the call.
   */
  public AddItemFromSellingManagerTemplateCall(ApiContext apiContext) {
    super(apiContext);
    

  }

  /**
   * This is the base request type of the <b>AddItemFromSellingManagerTemplate</b> call, which is used to create listings based on settings contained in a Selling Manager template.
   * 
   * <br>
   * @throws ApiException
   * @throws SdkException
   * @throws Exception
   * @return The String object.
   */
  public String addItemFromSellingManagerTemplate()
      throws com.ebay.sdk.ApiException, com.ebay.sdk.SdkException, java.lang.Exception
  {
    AddItemFromSellingManagerTemplateRequestType req;
    req = new AddItemFromSellingManagerTemplateRequestType();
    if (this.saleTemplateID != null)
      req.setSaleTemplateID(this.saleTemplateID);
    if (this.scheduleTime != null)
      req.setScheduleTime(this.scheduleTime);
    if (this.item != null)
      req.setItem(this.item);

    AddItemFromSellingManagerTemplateResponseType resp = (AddItemFromSellingManagerTemplateResponseType) execute(req);

    this.returnedItemID = resp.getItemID();
    this.returnedStartTime = resp.getStartTime();
    this.returnedEndTime = resp.getEndTime();
    this.returnedFees = resp.getFees();
    this.returnedCategoryID = resp.getCategoryID();
    this.returnedCategory2ID = resp.getCategory2ID();
    return this.getReturnedItemID();
  }

  /**
   * Gets the AddItemFromSellingManagerTemplateRequestType.item.
   * @return ItemType
   */
  public ItemType getItem()
  {
    return this.item;
  }

  /**
   * Sets the AddItemFromSellingManagerTemplateRequestType.item.
   * @param item ItemType
   */
  public void setItem(ItemType item)
  {
    this.item = item;
  }

  /**
   * Gets the AddItemFromSellingManagerTemplateRequestType.saleTemplateID.
   * @return Long
   */
  public Long getSaleTemplateID()
  {
    return this.saleTemplateID;
  }

  /**
   * Sets the AddItemFromSellingManagerTemplateRequestType.saleTemplateID.
   * @param saleTemplateID Long
   */
  public void setSaleTemplateID(Long saleTemplateID)
  {
    this.saleTemplateID = saleTemplateID;
  }

  /**
   * Gets the AddItemFromSellingManagerTemplateRequestType.scheduleTime.
   * @return Calendar
   */
  public Calendar getScheduleTime()
  {
    return this.scheduleTime;
  }

  /**
   * Sets the AddItemFromSellingManagerTemplateRequestType.scheduleTime.
   * @param scheduleTime Calendar
   */
  public void setScheduleTime(Calendar scheduleTime)
  {
    this.scheduleTime = scheduleTime;
  }

  /**
   * Valid after executing the API.
   * Gets the returned AddItemFromSellingManagerTemplateResponseType.returnedCategory2ID.
   * 
   * @return String
   */
  public String getReturnedCategory2ID()
  {
    return this.returnedCategory2ID;
  }

  /**
   * Valid after executing the API.
   * Gets the returned AddItemFromSellingManagerTemplateResponseType.returnedCategoryID.
   * 
   * @return String
   */
  public String getReturnedCategoryID()
  {
    return this.returnedCategoryID;
  }

  /**
   * Valid after executing the API.
   * Gets the returned AddItemFromSellingManagerTemplateResponseType.returnedEndTime.
   * 
   * @return Calendar
   */
  public Calendar getReturnedEndTime()
  {
    return this.returnedEndTime;
  }

  /**
   * Valid after executing the API.
   * Gets the returned AddItemFromSellingManagerTemplateResponseType.returnedFees.
   * 
   * @return FeesType
   */
  public FeesType getReturnedFees()
  {
    return this.returnedFees;
  }

  /**
   * Valid after executing the API.
   * Gets the returned AddItemFromSellingManagerTemplateResponseType.returnedItemID.
   * 
   * @return String
   */
  public String getReturnedItemID()
  {
    return this.returnedItemID;
  }

  /**
   * Valid after executing the API.
   * Gets the returned AddItemFromSellingManagerTemplateResponseType.returnedStartTime.
   * 
   * @return Calendar
   */
  public Calendar getReturnedStartTime()
  {
    return this.returnedStartTime;
  }

}

