/*
Copyright (c) 2013 eBay, Inc.
This program is licensed under the terms of the eBay Common Development and
Distribution License (CDDL) Version 1.0 (the "License") and any subsequent  version 
thereof released by eBay.  The then-current version of the License can be found 
at http://www.opensource.org/licenses/cddl1.php and in the eBaySDKLicense file that 
is under the eBay SDK ../docs directory.
*/

package com.ebay.sdk.call;

import java.lang.Integer;
import java.lang.String;

import com.ebay.sdk.*;
import com.ebay.soap.eBLBaseComponents.*;
/**
 * Wrapper class of the GetFeedback call of eBay SOAP API.
 * <br>
 * <p>Title: SOAP API wrapper library.</p>
 * <p>Description: Contains wrapper classes for eBay SOAP APIs.</p>
 * <p>Copyright: Copyright (c) 2009</p>
 * <p>Company: eBay Inc.</p>
 * <br> <B>Input property:</B> <code>UserID</code> - The user's eBay User ID is specified in this field. If this field is used, all retrieved Feedback data will be for this eBay user. Specifies the user whose feedback data is to be returned. If this field is omitted in the call request, all retrieved Feedback records will be for the eBay user making the call.
 * <br> <B>Input property:</B> <code>FeedbackID</code> - The unique identifier of a Feedback record. This field is used if the user wants to retrieve a specific Feedback record. If <b>FeedbackID</b> is specified in the call request, all other input fields are ignored.
 * <br> <B>Input property:</B> <code>ItemID</code> - Unique identifier for an eBay listing. A listing can have multiple order line items, but only one <b>ItemID</b>. If <b>ItemID</b> is specified in the <b>GetFeedback</b> request, the returned Feedback record(s) are restricted to the specified <b>ItemID</b>. The maximum number of Feedback records that can be returned is 100.
 * <br> <B>Input property:</B> <code>TransactionID</code> - Unique identifier for an eBay order line item. A
 * <b>TransactionID</b> can be paired up with its corresponding <b>ItemID</b> and used as
 * an input filter in the <b>GetFeedback</b> request. If an <b>ItemID</b>/<b>TransactionID</b>
 * pair or an <b>OrderLineItemID</b> value is used to retrieve a feedback record
 * on a specific order line item, the <b>FeedbackType</b> and <b>Pagination</b>
 * fields (if included) are ignored.
 * <br> <B>Input property:</B> <code>CommentType</code> - This field is used to retrieve Feedback records of a specific type (Positive, Negative, or Neutral) in <b>FeedbackDetailArray</b>. You can include one or two <b> CommentType</b> fields in the request. If no <b>CommentType</b> value is specified, Feedback records of all types are returned.
 * <br> <B>Input property:</B> <code>FeedbackType</code> - This field is used to restrict retrieved Feedback records to those that the user left for other buyers, Feedback records received as a seller, Feedback records received as a buyer, or Feedback records received as a buyer and seller. The default value is <b>FeedbackReceived</b>, so if the  <b>FeedbackType</b> field is omitted in the request, all Feedback records received by the user as a buyer and seller are returned in the response. "Feedback Left" data will not be returned in the call response.
 * <br> <B>Input property:</B> <code>Pagination</code> - Controls the pagination of the result set. Child elements, <b>EntriesPerPage</b> and
 * <b>PageNumber</b>, specify the maximum number of individual feedback records to return
 * per call and which page of data to return. Only applicable if <b>DetailLevel</b> is
 * set to <b>ReturnAll</b> and the call is returning feedback for a <b>UserID</b>. Feedback
 * summary data is not paginated, but when pagination is used, it is returned
 * after the last feedback detail entry.
 * <br><br>
 * Accepted values for <b>Pagination.EntriesPerPage</b> for GetFeedback is 25 (the
 * default), 50, 100, and 200. If you specify a value of zero, or a value
 * greater than 200, the call fails with an error. If you specify a value between
 * one and twenty-four, the value is rounded up to 25. Values between 26 and 199
 * that are not one of the accepted values are rounded down to the nearest
 * accepted value.
 * <br> <B>Input property:</B> <code>OrderLineItemID</code> - <b>OrderLineItemID</b> is a unique identifier for an eBay order line item. An <b>OrderLineItemID</b> can be used as an
 * input filter in the <b>GetFeedback</b> request. If an <b>OrderLineItemID</b> value is
 * used to retrieve a feedback record on a specific order line item, the
 * <b>FeedbackType</b> and <b>Pagination</b> fields (if included) are ignored.
 * <br> <B>Output property:</B> <code>ReturnedFeedbackDetails</code> - Contains the individual Feedback records for the user or order line item specified in the request. There is one <b>FeedbackDetail</b> container returned for each Feedback record. Only populated with data when a detail level of <code>ReturnAll</code> is specified in the request. Not returned if you specify a <b>FeedbackID</b> in the request.
 * <br> <B>Output property:</B> <code>GrandTotal</code> - Indicates the  total number of Feedback records returned in the the response. Only applicable if Feedback details are returned.
 * <br> <B>Output property:</B> <code>FeedbackSummary</code> - Summary Feedback data for the user. Contains counts of positive, neutral,
 * and negative Feedback for pre-defined time periods. Only applicable if Feedback details are returned.
 * <br> <B>Output property:</B> <code>FeedbackScore</code> - Indicates the total Feedback score for the user.
 * <br> <B>Output property:</B> <code>ReturnedPaginationResult</code> - Contains information regarding the pagination of data, including the total number of Feedback entries and the total number of pages required to show all of these Feedback entries. The total number of pages is dependent on the <b>Pagination.EntriesPerPage</b> value (if set). The <b>EntriesPerPage</b> value defaults to <code>25</code> if the <b>Pagination.EntriesPerPage</b> field is not used.
 * <br><br>
 * If the call request returns no Feedback entries because there are none, or because the <b>DetailLevel</b> field was not included and set to <code>ReturnAll</code>, the <b>PaginationResult.TotalNumberOfPages</b> and <b>PaginationResult.TotalNumberOfEntries</b> fields are still returned, but with values of <code>0</code>.
 * <br> <B>Output property:</B> <code>ReturnedEntriesPerPage</code> - Indicates the number of Feedback records that are set to be
 * returned per page of data (i.e., per call). The <b>EntriesPerPage</b> value defaults to <code>25</code> if the <b>Pagination.EntriesPerPage</b> field is not set in the request.
 * <br><br>
 * This field is always returned even if the response is not showing any Feedback entries.
 * <br> <B>Output property:</B> <code>ReturnedPageNumber</code> - Indicates the page of data that is currently displaying. The page number to display is set in the <b>Pagination.PageNumber</b> field in the request. If this field is omitted, the <b>PageNumber</b>  value defaults to <code>1</code> (first page of Feedback entries). If the integer value input into the  <b>Pagination.PageNumber</b> field in the request is higher than the total number of available pages, the call fails with an error.
 * <br><br>
 * This field is always returned even if the response is not showing any Feedback entries.
 * 
 * @author Ron Murphy
 * @version 1.0
 */

public class GetFeedbackCall extends com.ebay.sdk.ApiCall
{
  
  private String userID = null;
  private String feedbackID = null;
  private String itemID = null;
  private String transactionID = null;
  private CommentTypeCodeType[] commentType = null;
  private FeedbackTypeCodeType feedbackType = null;
  private PaginationType pagination = null;
  private String orderLineItemID = null;
  private FeedbackDetailType[] returnedFeedbackDetails=null;
  private int grandTotal=0;
  private FeedbackSummaryType feedbackSummary=null;
  private int feedbackScore=0;
  private PaginationResultType returnedPaginationResult=null;
  private Integer returnedEntriesPerPage=null;
  private Integer returnedPageNumber=null;


  /**
   * Constructor.
   */
  public GetFeedbackCall() {
  }

  /**
   * Constructor.
   * @param apiContext The ApiContext object to be used to make the call.
   */
  public GetFeedbackCall(ApiContext apiContext) {
    super(apiContext);
    

  }

  /**
   * Retrieves one, many, or all Feedback records for a specific eBay user. There is a filter option in the call request to limit Feedback records to those that are received, or to those that are left for other buyers, as well as a filter option to limit Feedback records to those that are received as a buyer or seller.
   * 
   * <br>
   * @throws ApiException
   * @throws SdkException
   * @throws Exception
   * @return The FeedbackDetailType[] object.
   */
  public FeedbackDetailType[] getFeedback()
      throws com.ebay.sdk.ApiException, com.ebay.sdk.SdkException, java.lang.Exception
  {
    GetFeedbackRequestType req;
    req = new GetFeedbackRequestType();

    if( this.userID == null )
      throw new SdkException("UserID property is not set.");

    req.setDetailLevel(this.getDetailLevel());
    if (this.userID != null)
      req.setUserID(this.userID);
    if (this.feedbackID != null)
      req.setFeedbackID(this.feedbackID);
    if (this.itemID != null)
      req.setItemID(this.itemID);
    if (this.transactionID != null)
      req.setTransactionID(this.transactionID);
    if (this.commentType != null)
      req.setCommentType(this.commentType);
    if (this.feedbackType != null)
      req.setFeedbackType(this.feedbackType);
    if (this.pagination != null)
      req.setPagination(this.pagination);
    if (this.orderLineItemID != null)
      req.setOrderLineItemID(this.orderLineItemID);

    GetFeedbackResponseType resp = (GetFeedbackResponseType) execute(req);

    this.returnedFeedbackDetails = (resp.getFeedbackDetailArray() == null? null: resp.getFeedbackDetailArray().getFeedbackDetail());
    this.grandTotal = (resp.getFeedbackDetailItemTotal() == null? 0: resp.getFeedbackDetailItemTotal().intValue());
    this.feedbackSummary = resp.getFeedbackSummary();
    this.feedbackScore = (resp.getFeedbackScore() == null? 0: resp.getFeedbackScore().intValue());
    this.returnedPaginationResult = resp.getPaginationResult();
    this.returnedEntriesPerPage = resp.getEntriesPerPage();
    this.returnedPageNumber = resp.getPageNumber();
    return this.getReturnedFeedbackDetails();
  }

  /**
   * Gets the GetFeedbackRequestType.commentType.
   * @return CommentTypeCodeType[]
   */
  public CommentTypeCodeType[] getCommentType()
  {
    return this.commentType;
  }

  /**
   * Sets the GetFeedbackRequestType.commentType.
   * @param commentType CommentTypeCodeType[]
   */
  public void setCommentType(CommentTypeCodeType[] commentType)
  {
    this.commentType = commentType;
  }

  /**
   * Gets the GetFeedbackRequestType.feedbackID.
   * @return String
   */
  public String getFeedbackID()
  {
    return this.feedbackID;
  }

  /**
   * Sets the GetFeedbackRequestType.feedbackID.
   * @param feedbackID String
   */
  public void setFeedbackID(String feedbackID)
  {
    this.feedbackID = feedbackID;
  }

  /**
   * Gets the GetFeedbackRequestType.feedbackType.
   * @return FeedbackTypeCodeType
   */
  public FeedbackTypeCodeType getFeedbackType()
  {
    return this.feedbackType;
  }

  /**
   * Sets the GetFeedbackRequestType.feedbackType.
   * @param feedbackType FeedbackTypeCodeType
   */
  public void setFeedbackType(FeedbackTypeCodeType feedbackType)
  {
    this.feedbackType = feedbackType;
  }

  /**
   * Gets the GetFeedbackRequestType.itemID.
   * @return String
   */
  public String getItemID()
  {
    return this.itemID;
  }

  /**
   * Sets the GetFeedbackRequestType.itemID.
   * @param itemID String
   */
  public void setItemID(String itemID)
  {
    this.itemID = itemID;
  }

  /**
   * Gets the GetFeedbackRequestType.orderLineItemID.
   * @return String
   */
  public String getOrderLineItemID()
  {
    return this.orderLineItemID;
  }

  /**
   * Sets the GetFeedbackRequestType.orderLineItemID.
   * @param orderLineItemID String
   */
  public void setOrderLineItemID(String orderLineItemID)
  {
    this.orderLineItemID = orderLineItemID;
  }

  /**
   * Gets the GetFeedbackRequestType.pagination.
   * @return PaginationType
   */
  public PaginationType getPagination()
  {
    return this.pagination;
  }

  /**
   * Sets the GetFeedbackRequestType.pagination.
   * @param pagination PaginationType
   */
  public void setPagination(PaginationType pagination)
  {
    this.pagination = pagination;
  }

  /**
   * Gets the GetFeedbackRequestType.transactionID.
   * @return String
   */
  public String getTransactionID()
  {
    return this.transactionID;
  }

  /**
   * Sets the GetFeedbackRequestType.transactionID.
   * @param transactionID String
   */
  public void setTransactionID(String transactionID)
  {
    this.transactionID = transactionID;
  }

  /**
   * Gets the GetFeedbackRequestType.userID.
   * @return String
   */
  public String getUserID()
  {
    return this.userID;
  }

  /**
   * Sets the GetFeedbackRequestType.userID.
   * @param userID String
   */
  public void setUserID(String userID)
  {
    this.userID = userID;
  }

  /**
   * Valid after executing the API.
   * Gets the returned GetFeedbackResponseType.feedbackScore.
   * 
   * @return int
   */
  public int getFeedbackScore()
  {
    return this.feedbackScore;
  }

  /**
   * Valid after executing the API.
   * Gets the returned GetFeedbackResponseType.feedbackSummary.
   * 
   * @return FeedbackSummaryType
   */
  public FeedbackSummaryType getFeedbackSummary()
  {
    return this.feedbackSummary;
  }

  /**
   * Valid after executing the API.
   * Gets the returned GetFeedbackResponseType.grandTotal.
   * 
   * @return int
   */
  public int getGrandTotal()
  {
    return this.grandTotal;
  }

  /**
   * Valid after executing the API.
   * Gets the returned GetFeedbackResponseType.returnedEntriesPerPage.
   * 
   * @return Integer
   */
  public Integer getReturnedEntriesPerPage()
  {
    return this.returnedEntriesPerPage;
  }

  /**
   * Valid after executing the API.
   * Gets the returned GetFeedbackResponseType.returnedFeedbackDetails.
   * 
   * @return FeedbackDetailType[]
   */
  public FeedbackDetailType[] getReturnedFeedbackDetails()
  {
    return this.returnedFeedbackDetails;
  }

  /**
   * Valid after executing the API.
   * Gets the returned GetFeedbackResponseType.returnedPageNumber.
   * 
   * @return Integer
   */
  public Integer getReturnedPageNumber()
  {
    return this.returnedPageNumber;
  }

  /**
   * Valid after executing the API.
   * Gets the returned GetFeedbackResponseType.returnedPaginationResult.
   * 
   * @return PaginationResultType
   */
  public PaginationResultType getReturnedPaginationResult()
  {
    return this.returnedPaginationResult;
  }

}

