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
 * Wrapper class of the GetMyeBayReminders call of eBay SOAP API.
 * <br>
 * <p>Title: SOAP API wrapper library.</p>
 * <p>Description: Contains wrapper classes for eBay SOAP APIs.</p>
 * <p>Copyright: Copyright (c) 2009</p>
 * <p>Company: eBay Inc.</p>
 * <br> <B>Input property:</B> <code>BuyingReminders</code> - This container should be included if the user wishes to retrieve the counts of My eBay Buying Reminders. Counts will only be retrieved for My eBay Buying Reminders that the user received.
 * <br> <B>Input property:</B> <code>SellingReminders</code> - This container should be included if the user wishes to retrieve the counts of My eBay Selling Reminders. Counts will only be retrieved for My eBay Selling Reminders that the user received.
 * <br> <B>Output property:</B> <code>ReturnedBuyingReminders</code> - This container is returned if the user included the <b>BuyingReminders</b> container in the call request and set the <b>BuyingReminders.Include</b> value to <code>true</code>. Counts will only be retrieved for My eBay Buying Reminders that the user received during the number of days specified in the <b>BuyingReminders.DurationInDays</b> field in the call request.
 * <br> <B>Output property:</B> <code>ReturnedSellingReminders</code> - This container is returned if the user included the <b>SellingReminders</b> container in the call request and set the <b>SellingReminders.Include</b> value to <code>true</code>. Counts will only be retrieved for My eBay Selling Reminders that the user received during the number of days specified in the <b>SellingReminders.DurationInDays</b> field in the call request.
 * 
 * @author Ron Murphy
 * @version 1.0
 */

public class GetMyeBayRemindersCall extends com.ebay.sdk.ApiCall
{
  
  private ReminderCustomizationType buyingReminders = null;
  private ReminderCustomizationType sellingReminders = null;
  private RemindersType returnedBuyingReminders=null;
  private RemindersType returnedSellingReminders=null;


  /**
   * Constructor.
   */
  public GetMyeBayRemindersCall() {
  }

  /**
   * Constructor.
   * @param apiContext The ApiContext object to be used to make the call.
   */
  public GetMyeBayRemindersCall(ApiContext apiContext) {
    super(apiContext);
    

  }

  /**
   * This is the base request type of the <b>GetMyeBayReminders</b> call. This call returns the total counts for My eBay Buying and/or My eBay Selling Reminders for a user.
   * 
   * <br>
   * @throws ApiException
   * @throws SdkException
   * @throws Exception
   * @return The void object.
   */
  public void getMyeBayReminders()
      throws com.ebay.sdk.ApiException, com.ebay.sdk.SdkException, java.lang.Exception
  {
    GetMyeBayRemindersRequestType req;
    req = new GetMyeBayRemindersRequestType();
    if (this.buyingReminders != null)
      req.setBuyingReminders(this.buyingReminders);
    if (this.sellingReminders != null)
      req.setSellingReminders(this.sellingReminders);

    GetMyeBayRemindersResponseType resp = (GetMyeBayRemindersResponseType) execute(req);

    this.returnedBuyingReminders = resp.getBuyingReminders();
    this.returnedSellingReminders = resp.getSellingReminders();

  }

  /**
   * Gets the GetMyeBayRemindersRequestType.buyingReminders.
   * @return ReminderCustomizationType
   */
  public ReminderCustomizationType getBuyingReminders()
  {
    return this.buyingReminders;
  }

  /**
   * Sets the GetMyeBayRemindersRequestType.buyingReminders.
   * @param buyingReminders ReminderCustomizationType
   */
  public void setBuyingReminders(ReminderCustomizationType buyingReminders)
  {
    this.buyingReminders = buyingReminders;
  }

  /**
   * Gets the GetMyeBayRemindersRequestType.sellingReminders.
   * @return ReminderCustomizationType
   */
  public ReminderCustomizationType getSellingReminders()
  {
    return this.sellingReminders;
  }

  /**
   * Sets the GetMyeBayRemindersRequestType.sellingReminders.
   * @param sellingReminders ReminderCustomizationType
   */
  public void setSellingReminders(ReminderCustomizationType sellingReminders)
  {
    this.sellingReminders = sellingReminders;
  }

  /**
   * Valid after executing the API.
   * Gets the returned GetMyeBayRemindersResponseType.returnedBuyingReminders.
   * 
   * @return RemindersType
   */
  public RemindersType getReturnedBuyingReminders()
  {
    return this.returnedBuyingReminders;
  }

  /**
   * Valid after executing the API.
   * Gets the returned GetMyeBayRemindersResponseType.returnedSellingReminders.
   * 
   * @return RemindersType
   */
  public RemindersType getReturnedSellingReminders()
  {
    return this.returnedSellingReminders;
  }

}

