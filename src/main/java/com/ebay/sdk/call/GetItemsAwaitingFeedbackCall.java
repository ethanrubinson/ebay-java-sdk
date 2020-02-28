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
 * Wrapper class of the GetItemsAwaitingFeedback call of eBay SOAP API.
 * <br>
 * <p>Title: SOAP API wrapper library.</p>
 * <p>Description: Contains wrapper classes for eBay SOAP APIs.</p>
 * <p>Copyright: Copyright (c) 2009</p>
 * <p>Company: eBay Inc.</p>
 * <br> <B>Input property:</B> <code>Sort</code> - This field allows the user to control how the order line items are returned in the response. If this field is not used, order line items are returned based on end time (from most recent to oldest).
 * Valid values for this field are:
 * <ul>
 * <li><code>EndTime</code></li>
 * <li><code>EndTimeDescending</code> (default value)</li>
 * <li><code>FeedbackLeft</code></li>
 * <li><code>FeedbackLeftDescending</code></li>
 * <li><code>FeedbackReceived</code></li>
 * <li><code>FeedbackReceivedDescending</code></li>
 * <li><code>Title</code></li>
 * <li><code>TitleDescending</code></li>
 * <li><code>UserID</code></li>
 * <li><code>UserIDDescending</code></li>
 * </ul>
 * Reference the <a href="types/ItemSortTypeCodeType.html">ItemSortTypeCodeType</a> definition for more information on these sort values.
 * <br/>
 * <br> <B>Input property:</B> <code>Pagination</code> - This container can be used if the user only wants to see a subset of order line item results. In this container, the user will specify the number of order line items to return per page of data, and will specify the specific page of data they want to view with each call.
 * <br/><br/>
 * With the <b>GetItemsAwaitingFeedback</b> call, the maximum allowed value for <b>EntriesPerPage</b> is 200.
 * <br> <B>Output property:</B> <code>ReturnedItemsAwaitingFeedback</code> - This container consists of one or more order line items that are awaiting Feedback from the user that made the call. Each order line item is returned in its own <b>TransactionArray.Transaction</b> container.
 * <br><br>
 * This container will not be returned if no order line items are awaiting Feedback from the user who made the call.
 * 
 * @author Ron Murphy
 * @version 1.0
 */

public class GetItemsAwaitingFeedbackCall extends com.ebay.sdk.ApiCall
{
  
  private ItemSortTypeCodeType sort = null;
  private PaginationType pagination = null;
  private PaginatedTransactionArrayType returnedItemsAwaitingFeedback=null;


  /**
   * Constructor.
   */
  public GetItemsAwaitingFeedbackCall() {
  }

  /**
   * Constructor.
   * @param apiContext The ApiContext object to be used to make the call.
   */
  public GetItemsAwaitingFeedbackCall(ApiContext apiContext) {
    super(apiContext);
    

  }

  /**
   * This is the base request type of the <b>GetItemsAwaitingFeedback</b> call. This call retrieves all completed order line items for which the user (buyer or seller) still needs to leave Feedback for their order partner.
   * 
   * <br>
   * @throws ApiException
   * @throws SdkException
   * @throws Exception
   * @return The void object.
   */
  public void getItemsAwaitingFeedback()
      throws com.ebay.sdk.ApiException, com.ebay.sdk.SdkException, java.lang.Exception
  {
    GetItemsAwaitingFeedbackRequestType req;
    req = new GetItemsAwaitingFeedbackRequestType();
    if (this.sort != null)
      req.setSort(this.sort);
    if (this.pagination != null)
      req.setPagination(this.pagination);

    GetItemsAwaitingFeedbackResponseType resp = (GetItemsAwaitingFeedbackResponseType) execute(req);

    this.returnedItemsAwaitingFeedback = resp.getItemsAwaitingFeedback();

  }

  /**
   * Gets the GetItemsAwaitingFeedbackRequestType.pagination.
   * @return PaginationType
   */
  public PaginationType getPagination()
  {
    return this.pagination;
  }

  /**
   * Sets the GetItemsAwaitingFeedbackRequestType.pagination.
   * @param pagination PaginationType
   */
  public void setPagination(PaginationType pagination)
  {
    this.pagination = pagination;
  }

  /**
   * Gets the GetItemsAwaitingFeedbackRequestType.sort.
   * @return ItemSortTypeCodeType
   */
  public ItemSortTypeCodeType getSort()
  {
    return this.sort;
  }

  /**
   * Sets the GetItemsAwaitingFeedbackRequestType.sort.
   * @param sort ItemSortTypeCodeType
   */
  public void setSort(ItemSortTypeCodeType sort)
  {
    this.sort = sort;
  }
/**
   * Gets the returned pagination result within the PaginatedTransactionArrayType.
   * @return PaginationResultType
   */
  public PaginationResultType getReturnedPaginationResult() {
    PaginatedTransactionArrayType ary = this.returnedItemsAwaitingFeedback;
    return (ary == null? null: ary.getPaginationResult());
  }
/**
   * Gets the returned transaction array within the PaginatedTransactionArrayType.
   * @return TransactionType[]
   */
  public TransactionType[] getReturnedTransaction() {
    PaginatedTransactionArrayType ary = this.returnedItemsAwaitingFeedback;
    return (ary == null || ary.getTransactionArray() == null) ? null : ary.getTransactionArray().getTransaction();
  }

  /**
   * Valid after executing the API.
   * Gets the returned GetItemsAwaitingFeedbackResponseType.returnedItemsAwaitingFeedback.
   * 
   * @return PaginatedTransactionArrayType
   */
  public PaginatedTransactionArrayType getReturnedItemsAwaitingFeedback()
  {
    return this.returnedItemsAwaitingFeedback;
  }

}

