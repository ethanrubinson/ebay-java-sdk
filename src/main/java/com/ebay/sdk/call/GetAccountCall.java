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
 * Wrapper class of the GetAccount call of eBay SOAP API.
 * <br>
 * <p>Title: SOAP API wrapper library.</p>
 * <p>Description: Contains wrapper classes for eBay SOAP APIs.</p>
 * <p>Copyright: Copyright (c) 2009</p>
 * <p>Company: eBay Inc.</p>
 * <br> <B>Input property:</B> <code>ViewType</code> - Specifies the report format in which to return account entries.
 * <br> <B>Input property:</B> <code>InvoiceDate</code> - This field is used to retrieve all account entries from a specific invoice, which is identified through this <b>InvoiceDate</b> field with the timestamp of the account invoice. This field is only applicable if the  <b>AccountHistorySelection</b> value is set to 'SpecifiedInvoice'; otherwise, this field will be ignored.
 * <br> <B>Input property:</B> <code>ViewPeriod</code> - Helper wrapper to set GetAccountRequestType BeginDate, EndDate:
 * TimeFrom sets GetAccountRequestType.BeginDate: 
 * This field is used to retrieve all account entries dating back to the timestamp passed into this <b>BeginDate</b> field up until the timestamp passed into the <b>EndDate</b> field. The <b>BeginDate</b> value can not be set back any further than four months into the past.
 * <br/><br/>
 * The allowed date formats are <em>YYYY-MM-DD</em> and <em>YYYY-MM-DD HH:mm:ss</em> The <b>BeginDate</b> value must be less than or equal to the <b>EndDate</b> value. The user might use the same values in both fields if that user wanted to retrieve all account entries from a specific day (if <em>YYYY-MM-DD</em> format used) or wanted to retrieve a specific account entry (if <em>YYYY-MM-DD HH:mm:ss</em> format used).
 * <br/><br/>
 * This field is only applicable if the  <b>AccountHistorySelection</b> value is set to 'BetweenSpecifiedDates'; otherwise, this field will be ignored. fiedDates' is used, both the <b>BeginDate</b> and <b>EndDate</b> must be included.
 * TimeTo sets GetAccountRequestType.EndDate: 
 * This field is used to retrieve all account entries dating up to the timestamp passed into this <b>EndDate</b> field dating back to the timestamp passed into the <b>BeginDate</b> field. The <b>EndDate</b> value can not be set for a future date.
 * <br/><br/>
 * The allowed date formats are <em>YYYY-MM-DD</em> and <em>YYYY-MM-DD HH:mm:ss</em> The <b>EndDate</b> value must be more than or equal to the <b>BeginDate</b> value. The user might use the same values in both fields if that user wanted to retrieve all account entries from a specific day (if <em>YYYY-MM-DD</em> format used) or wanted to retrieve a specific account entry (if <em>YYYY-MM-DD HH:mm:ss</em> format used).
 * <br/><br/>
 * This field is only applicable if the  <b>AccountHistorySelection</b> value is set to 'BetweenSpecifiedDates'; otherwise, this field will be ignored. If 'BetweenSpecifiedDates' is used, both the <b>BeginDate</b> and <b>EndDate</b> must be included.
 * <br> <B>Input property:</B> <code>Pagination</code> - This container is used to control how many account entries are returned on each page of data in the response. <b>PaginationType</b> is used by numerous Trading API calls, and the default and maximum values for the <b>EntriesPerPage</b> field differs with each call. For the <b>GetAccount</b> call, the default value is 500 (account entries) per page, and maximum allowed value is 2000 (account entries) per page.
 * <br> <B>Input property:</B> <code>ExcludeBalance</code> - By default, the current balance of the user's account will not be returned in the call response. To retrieve the current balance of their account, the user should include the <b>ExcludeBalance</b> flag in the request and set its value to 'false'. The current balance on the account will be shown in the <b>AccountSummary.CurrentBalance</b> field in the call response.
 * <br> <B>Input property:</B> <code>ExcludeSummary</code> - Specifies whether to return account summary information in an
 * AccountSummary node. Default is true, to return AccountSummary.
 * <br> <B>Input property:</B> <code>IncludeConversionRate</code> - Specifies whether to retrieve the rate used for the currency conversion for usage transactions.
 * <br> <B>Input property:</B> <code>AccountEntrySortType</code> - Specifies how account entries should be sorted in the response, by an
 * element and then in ascending or descending order.
 * <br> <B>Input property:</B> <code>Currency</code> - Specifies the currency used in the account report. Do not specify Currency
 * in the request unless the following conditions are met. First, the user has
 * or had multiple accounts under the same UserID. Second, the account
 * identified in the request uses the currency you specify in the request. An
 * error is returned if no account is found that uses the currency you specify
 * in the request.
 * <br> <B>Input property:</B> <code>ItemID</code> - Specifies the item ID for which to return account entries. If ItemID is
 * used, all other filters in the request are ignored. If the specified item
 * does not exist or if the requesting user is not the seller of the item, an
 * error is returned.
 * <br> <B>Input property:</B> <code>OrderID</code> - The unique identifier of an eBay order. This field must be included if the value of the <b>AccountHistorySelection</b> filter is set to <code>OrderId</code>. A user can filter by order ID to see if there specific account entries related to a specific eBay order.
 * <br><br>
 * It is possible that no account entries will be found directly related to the specified order ID, and if this is the case, no <b>AccountEntries</b> container will be returned, and the <b>ack</b> value will still be <code>Success</code>.
 * <br><br>
 * <span class="tablenote"><b>Note: </b> In June 2019, eBay introduced a new order ID format to both legacy (including Trading API) and REST-based APIs. At this time, both old and new format order IDs will be accepted in legacy API request payloads to identify orders. In legacy API response payloads, order IDs will appear in the new format if the user is using a Trading WSDL version of '1113' (or newer), or if the user sets the <code>X-EBAY-API-COMPATIBILITY-LEVEL</code> HTTP header to a value of '1113' (or newer). If the Trading WSDL version or compatibility level is less/older than '1113', old format order IDs will be returned in legacy API response payloads. Beginning as soon as March 2020, only new format order IDs will be returned regardless of version number.
 * </span>
 * <br> <B>Output property:</B> <code>AccountID</code> - Specifies the seller's unique account number.
 * <br> <B>Output property:</B> <code>AccountSummary</code> - Contains summary data for the seller's account, such as the overall
 * balance, bank account and credit card information, and amount and
 * date of any past due balances. Can also contain data for
 * one or more additional accounts, if the user has changed country
 * of residence.
 * <br> <B>Output property:</B> <code>ReturnedCurrency</code> - Indicates the currency used for monetary amounts in the report.
 * <br> <B>Output property:</B> <code>AccountEntries</code> - This container holds an array of account entries. The account entries that are returned are dependent on the selection that the user made in the <b>AccountHistorySelection</b> field in the call request. Each <b>AccountEntry</b> container consists of one credit, one debit, or one administrative action on the account. It is possible that no <b>AccountEntry</b> containers will be returned if no account entries exist since the last invoice (if 'LastInvoice' value is used), between the specified dates (if 'BetweenSpecifiedDates' value is used), or on a specified invoice (if 'SpecifiedInvoice' value is used).
 * <br> <B>Output property:</B> <code>PaginationResult</code> - This container shows the total number of account entries and the total number of  account entry pages that exist based on the filters used in the <b>GetAccount</b> call request. The total number of account entry pages is partly controlled by the <b>Pagination.EntriesPerPage</b> value that is set in the request.
 * <br> <B>Output property:</B> <code>HasMoreEntries</code> - If this boolean value is returned as 'true', there are more account entries to view on one or more pages of data. To view additional entries, the user would have to make additional <b>GetAccount</b> calls and increment the value of the <b>Pagination.PageNumber</b> field by '1' to view additional pages of account entries.
 * <br> <B>Output property:</B> <code>ReturnedEntriesPerPage</code> - This integer value indicates the number of account entries that are being returned per virtual page of data. This value will be the same value passed into the <b>Pagination.EntriesPerPage</b> field in the request.
 * <br> <B>Output property:</B> <code>ReturnedPageNumber</code> - This integer value indicates the current page number of account entries that is currently being shown. This value will be the same value passed into the <b>Pagination.PageNumber</b> field in the request.
 * 
 * @author Ron Murphy
 * @version 1.0
 */

public class GetAccountCall extends com.ebay.sdk.ApiCall
{
  
  private AccountHistorySelectionCodeType viewType = AccountHistorySelectionCodeType.LAST_INVOICE;
  private Calendar invoiceDate = null;
  private TimeFilter viewPeriod = null;
  private PaginationType pagination = null;
  private Boolean excludeBalance = null;
  private Boolean excludeSummary = null;
  private Boolean includeConversionRate = null;
  private AccountEntrySortTypeCodeType accountEntrySortType = null;
  private CurrencyCodeType currency = null;
  private String itemID = null;
  private String orderID = null;
  private String accountID=null;
  private AccountSummaryType accountSummary=null;
  private CurrencyCodeType returnedCurrency=null;
  private AccountEntryType[] accountEntries=null;
  private PaginationResultType paginationResult=null;
  private boolean hasMoreEntries=false;
  private Integer returnedEntriesPerPage=null;
  private Integer returnedPageNumber=null;


  /**
   * Constructor.
   */
  public GetAccountCall() {
  }

  /**
   * Constructor.
   * @param apiContext The ApiContext object to be used to make the call.
   */
  public GetAccountCall(ApiContext apiContext) {
    super(apiContext);
    

  }

  /**
   * Returns a seller's invoice data for their eBay account, including the account's
   * summary data.
   * 
   * <br>
   * @throws ApiException
   * @throws SdkException
   * @throws Exception
   * @return The AccountEntryType[] object.
   */
  public AccountEntryType[] getAccount()
      throws com.ebay.sdk.ApiException, com.ebay.sdk.SdkException, java.lang.Exception
  {
    GetAccountRequestType req;
    req = new GetAccountRequestType();

    if( this.viewType == null )
      throw new SdkException("ViewType property is not set.");

    if( this.viewType.equals(AccountHistorySelectionCodeType.BETWEEN_SPECIFIED_DATES) )
    {
      if( this.viewPeriod == null )
        throw new SdkException("GetAccountCall.ViewPeriod is not set.");
    }
    else if( this.viewType.equals(AccountHistorySelectionCodeType.SPECIFIED_INVOICE) )
    {
      if( this.invoiceDate == null )
        throw new SdkException("GetAccountCall.InvoiceDate is not set.");
    }

    req.setDetailLevel(this.getDetailLevel());
    if (this.viewType != null)
      req.setAccountHistorySelection(this.viewType);
    if (this.invoiceDate != null)
      req.setInvoiceDate(this.invoiceDate);
    if (this.viewPeriod != null)
    {
      req.setBeginDate(this.viewPeriod.getTimeFrom());
      req.setEndDate(this.viewPeriod.getTimeTo());
    }
    if (this.pagination != null)
      req.setPagination(this.pagination);
    if (this.excludeBalance != null)
      req.setExcludeBalance(this.excludeBalance);
    if (this.excludeSummary != null)
      req.setExcludeSummary(this.excludeSummary);
    if (this.includeConversionRate != null)
      req.setIncludeConversionRate(this.includeConversionRate);
    if (this.accountEntrySortType != null)
      req.setAccountEntrySortType(this.accountEntrySortType);
    if (this.currency != null)
      req.setCurrency(this.currency);
    if (this.itemID != null)
      req.setItemID(this.itemID);
    if (this.orderID != null)
      req.setOrderID(this.orderID);

    GetAccountResponseType resp = (GetAccountResponseType) execute(req);

    this.accountID = resp.getAccountID();
    this.accountSummary = resp.getAccountSummary();
    this.returnedCurrency = resp.getCurrency();
    this.accountEntries = (resp.getAccountEntries() == null? null: resp.getAccountEntries().getAccountEntry());
    this.paginationResult = resp.getPaginationResult();
    this.hasMoreEntries = (resp.isHasMoreEntries() == null? false: resp.isHasMoreEntries().booleanValue());
    this.returnedEntriesPerPage = resp.getEntriesPerPage();
    this.returnedPageNumber = resp.getPageNumber();
    return this.getAccountEntries();
  }

  /**
   * Gets the GetAccountRequestType.accountEntrySortType.
   * @return AccountEntrySortTypeCodeType
   */
  public AccountEntrySortTypeCodeType getAccountEntrySortType()
  {
    return this.accountEntrySortType;
  }

  /**
   * Sets the GetAccountRequestType.accountEntrySortType.
   * @param accountEntrySortType AccountEntrySortTypeCodeType
   */
  public void setAccountEntrySortType(AccountEntrySortTypeCodeType accountEntrySortType)
  {
    this.accountEntrySortType = accountEntrySortType;
  }

  /**
   * Gets the GetAccountRequestType.currency.
   * @return CurrencyCodeType
   */
  public CurrencyCodeType getCurrency()
  {
    return this.currency;
  }

  /**
   * Sets the GetAccountRequestType.currency.
   * @param currency CurrencyCodeType
   */
  public void setCurrency(CurrencyCodeType currency)
  {
    this.currency = currency;
  }

  /**
   * Gets the GetAccountRequestType.excludeBalance.
   * @return Boolean
   */
  public Boolean getExcludeBalance()
  {
    return this.excludeBalance;
  }

  /**
   * Sets the GetAccountRequestType.excludeBalance.
   * @param excludeBalance Boolean
   */
  public void setExcludeBalance(Boolean excludeBalance)
  {
    this.excludeBalance = excludeBalance;
  }

  /**
   * Gets the GetAccountRequestType.excludeSummary.
   * @return Boolean
   */
  public Boolean getExcludeSummary()
  {
    return this.excludeSummary;
  }

  /**
   * Sets the GetAccountRequestType.excludeSummary.
   * @param excludeSummary Boolean
   */
  public void setExcludeSummary(Boolean excludeSummary)
  {
    this.excludeSummary = excludeSummary;
  }

  /**
   * Gets the GetAccountRequestType.includeConversionRate.
   * @return Boolean
   */
  public Boolean getIncludeConversionRate()
  {
    return this.includeConversionRate;
  }

  /**
   * Sets the GetAccountRequestType.includeConversionRate.
   * @param includeConversionRate Boolean
   */
  public void setIncludeConversionRate(Boolean includeConversionRate)
  {
    this.includeConversionRate = includeConversionRate;
  }

  /**
   * Gets the GetAccountRequestType.invoiceDate.
   * @return Calendar
   */
  public Calendar getInvoiceDate()
  {
    return this.invoiceDate;
  }

  /**
   * Sets the GetAccountRequestType.invoiceDate.
   * @param invoiceDate Calendar
   */
  public void setInvoiceDate(Calendar invoiceDate)
  {
    this.invoiceDate = invoiceDate;
  }

  /**
   * Gets the GetAccountRequestType.itemID.
   * @return String
   */
  public String getItemID()
  {
    return this.itemID;
  }

  /**
   * Sets the GetAccountRequestType.itemID.
   * @param itemID String
   */
  public void setItemID(String itemID)
  {
    this.itemID = itemID;
  }

  /**
   * Gets the GetAccountRequestType.orderID.
   * @return String
   */
  public String getOrderID()
  {
    return this.orderID;
  }

  /**
   * Sets the GetAccountRequestType.orderID.
   * @param orderID String
   */
  public void setOrderID(String orderID)
  {
    this.orderID = orderID;
  }

  /**
   * Gets the GetAccountRequestType.pagination.
   * @return PaginationType
   */
  public PaginationType getPagination()
  {
    return this.pagination;
  }

  /**
   * Sets the GetAccountRequestType.pagination.
   * @param pagination PaginationType
   */
  public void setPagination(PaginationType pagination)
  {
    this.pagination = pagination;
  }

  /**
   * Gets the GetAccountRequestType.viewPeriod.
   * @return TimeFilter
   */
  public TimeFilter getViewPeriod()
  {
    return this.viewPeriod;
  }

  /**
   * Sets the GetAccountRequestType.viewPeriod.
   * @param viewPeriod TimeFilter
   */
  public void setViewPeriod(TimeFilter viewPeriod)
  {
    this.viewPeriod = viewPeriod;
  }

  /**
   * Gets the GetAccountRequestType.viewType.
   * @return AccountHistorySelectionCodeType
   */
  public AccountHistorySelectionCodeType getViewType()
  {
    return this.viewType;
  }

  /**
   * Sets the GetAccountRequestType.viewType.
   * @param viewType AccountHistorySelectionCodeType
   */
  public void setViewType(AccountHistorySelectionCodeType viewType)
  {
    this.viewType = viewType;
  }

  /**
   * Valid after executing the API.
   * Gets the returned GetAccountResponseType.accountEntries.
   * 
   * @return AccountEntryType[]
   */
  public AccountEntryType[] getAccountEntries()
  {
    return this.accountEntries;
  }

  /**
   * Valid after executing the API.
   * Gets the returned GetAccountResponseType.accountID.
   * 
   * @return String
   */
  public String getAccountID()
  {
    return this.accountID;
  }

  /**
   * Valid after executing the API.
   * Gets the returned GetAccountResponseType.accountSummary.
   * 
   * @return AccountSummaryType
   */
  public AccountSummaryType getAccountSummary()
  {
    return this.accountSummary;
  }

  /**
   * Valid after executing the API.
   * Gets the returned GetAccountResponseType.hasMoreEntries.
   * 
   * @return boolean
   */
  public boolean getHasMoreEntries()
  {
    return this.hasMoreEntries;
  }

  /**
   * Valid after executing the API.
   * Gets the returned GetAccountResponseType.paginationResult.
   * 
   * @return PaginationResultType
   */
  public PaginationResultType getPaginationResult()
  {
    return this.paginationResult;
  }

  /**
   * Valid after executing the API.
   * Gets the returned GetAccountResponseType.returnedCurrency.
   * 
   * @return CurrencyCodeType
   */
  public CurrencyCodeType getReturnedCurrency()
  {
    return this.returnedCurrency;
  }

  /**
   * Valid after executing the API.
   * Gets the returned GetAccountResponseType.returnedEntriesPerPage.
   * 
   * @return Integer
   */
  public Integer getReturnedEntriesPerPage()
  {
    return this.returnedEntriesPerPage;
  }

  /**
   * Valid after executing the API.
   * Gets the returned GetAccountResponseType.returnedPageNumber.
   * 
   * @return Integer
   */
  public Integer getReturnedPageNumber()
  {
    return this.returnedPageNumber;
  }

}

