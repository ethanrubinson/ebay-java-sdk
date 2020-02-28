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
import java.util.Calendar;

import com.ebay.sdk.*;
import com.ebay.soap.eBLBaseComponents.*;
/**
 * Wrapper class of the GetMemberMessages call of eBay SOAP API.
 * <br>
 * <p>Title: SOAP API wrapper library.</p>
 * <p>Description: Contains wrapper classes for eBay SOAP APIs.</p>
 * <p>Copyright: Copyright (c) 2009</p>
 * <p>Company: eBay Inc.</p>
 * <br> <B>Input property:</B> <code>ItemID</code> - The unique identifier of the eBay listing for which you wish to retrieve member messages.
 * <br><br>
 * For <em>Ask Seller Question</em> messages, the <b>ItemID</b> and/or a date range
 * (specified with <b>StartCreationTime</b> and <b>EndCreationTime</b> fields),
 * are required, or the call will fail.
 * <br> <B>Input property:</B> <code>MailMessageType</code> - This required field indicates the type of member message to retrieve. Only the following two enumeration values are allowed. The call will fail if this field is not included in the request.
 * <br> <B>Input property:</B> <code>MessageStatus</code> - This field allows you to retrieve only unanswered member messages or answered member messages. If this field is omitted, both answered and unanswered member messages are retrieved.
 * <br> <B>Input property:</B> <code>DisplayToPublic</code> - If included in the request and set to <code>true</code>, only public messages (viewable in the Item listing) are returned. If omitted or set to <code>false</code> in the request, all messages (that match other filters in the request) are returned in the response.
 * <br> <B>Input property:</B> <code>StartCreationTime</code> - Used as beginning of date range filter. If specified, filters the returned messages to only those with a creation date greater than or equal to the specified date and time.
 * <br><br>
 * For Contact eBay Member (CEM) messages, <b>StartCreationTime</b> and <b>EndCreationTime</b> must be provided.
 * <br><br>
 * For Ask Seller a Question (ASQ) messages, either the <b>ItemID</b>, or a date range (specified with <b>StartCreationTime</b> and <b>EndCreationTime</b>), or both must be included.
 * <br> <B>Input property:</B> <code>EndCreationTime</code> - Used as end of date range filter. If specified, filters
 * the returned messages to only those with a creation date
 * less than or equal to the specified date and time.
 * <br><br>
 * For Contact eBay Member (CEM) messages, <b>StartCreationTime</b> and <b>EndCreationTime</b>
 * must be provided.
 * <br><br>
 * For Ask Seller a Question (ASQ) messages, either the <b>ItemID</b>, or a date range
 * (specified with <b>StartCreationTime</b> and <b>EndCreationTime</b>),
 * or both must be included.
 * <br> <B>Input property:</B> <code>Pagination</code> - Standard pagination argument used to reduce response.
 * <br> <B>Input property:</B> <code>MemberMessageID</code> - An ID that uniquely identifies the message for a given user to be retrieved. Used for the <b>AskSellerQuestion</b> notification only.
 * <br> <B>Input property:</B> <code>SenderID</code> - An eBay ID that uniquely identifies a user. For <b>GetMemberMessages</b>, this is the sender of the message. If included in the request, returns only messages from the specified sender.
 * <br> <B>Output property:</B> <code>ReturnedMemberMessages</code> - The returned member messages. Returned if messages that meet the request criteria exist. Note that <b>GetMemberMessages</b> does not return messages when, in the request, the <b>MailMessageType</b> is <b>AskSellerQuestion</b>.
 * <br> <B>Output property:</B> <code>PaginationResult</code> - Shows the pagination of data returned by requests.
 * <br> <B>Output property:</B> <code>HasMoreItems</code> - Specifies whether the response has more items.
 * 
 * @author Ron Murphy
 * @version 1.0
 */

public class GetMemberMessagesCall extends com.ebay.sdk.ApiCall
{
  
  private String itemID = null;
  private MessageTypeCodeType mailMessageType = null;
  private MessageStatusTypeCodeType messageStatus = null;
  private Boolean displayToPublic = null;
  private Calendar startCreationTime = null;
  private Calendar endCreationTime = null;
  private PaginationType pagination = null;
  private String memberMessageID = null;
  private String senderID = null;
  private MemberMessageExchangeType[] returnedMemberMessages=null;
  private PaginationResultType paginationResult=null;
  private Boolean hasMoreItems=null;


  /**
   * Constructor.
   */
  public GetMemberMessagesCall() {
  }

  /**
   * Constructor.
   * @param apiContext The ApiContext object to be used to make the call.
   */
  public GetMemberMessagesCall(ApiContext apiContext) {
    super(apiContext);
    

  }

  /**
   * Retrieves a list of the messages buyers have posted about your
   * active item listings.
   * 
   * <br>
   * @throws ApiException
   * @throws SdkException
   * @throws Exception
   * @return The MemberMessageExchangeType[] object.
   */
  public MemberMessageExchangeType[] getMemberMessages()
      throws com.ebay.sdk.ApiException, com.ebay.sdk.SdkException, java.lang.Exception
  {
    GetMemberMessagesRequestType req;
    req = new GetMemberMessagesRequestType();
    if (this.itemID != null)
      req.setItemID(this.itemID);
    if (this.mailMessageType != null)
      req.setMailMessageType(this.mailMessageType);
    if (this.messageStatus != null)
      req.setMessageStatus(this.messageStatus);
    if (this.displayToPublic != null)
      req.setDisplayToPublic(this.displayToPublic);
    if (this.startCreationTime != null)
      req.setStartCreationTime(this.startCreationTime);
    if (this.endCreationTime != null)
      req.setEndCreationTime(this.endCreationTime);
    if (this.pagination != null)
      req.setPagination(this.pagination);
    if (this.memberMessageID != null)
      req.setMemberMessageID(this.memberMessageID);
    if (this.senderID != null)
      req.setSenderID(this.senderID);

    GetMemberMessagesResponseType resp = (GetMemberMessagesResponseType) execute(req);

    this.returnedMemberMessages = (resp.getMemberMessage() == null? null: resp.getMemberMessage().getMemberMessageExchange());
    this.paginationResult = resp.getPaginationResult();
    this.hasMoreItems = resp.isHasMoreItems();
    return this.getReturnedMemberMessages();
  }

  /**
   * Gets the GetMemberMessagesRequestType.displayToPublic.
   * @return Boolean
   */
  public Boolean getDisplayToPublic()
  {
    return this.displayToPublic;
  }

  /**
   * Sets the GetMemberMessagesRequestType.displayToPublic.
   * @param displayToPublic Boolean
   */
  public void setDisplayToPublic(Boolean displayToPublic)
  {
    this.displayToPublic = displayToPublic;
  }

  /**
   * Gets the GetMemberMessagesRequestType.endCreationTime.
   * @return Calendar
   */
  public Calendar getEndCreationTime()
  {
    return this.endCreationTime;
  }

  /**
   * Sets the GetMemberMessagesRequestType.endCreationTime.
   * @param endCreationTime Calendar
   */
  public void setEndCreationTime(Calendar endCreationTime)
  {
    this.endCreationTime = endCreationTime;
  }

  /**
   * Gets the GetMemberMessagesRequestType.itemID.
   * @return String
   */
  public String getItemID()
  {
    return this.itemID;
  }

  /**
   * Sets the GetMemberMessagesRequestType.itemID.
   * @param itemID String
   */
  public void setItemID(String itemID)
  {
    this.itemID = itemID;
  }

  /**
   * Gets the GetMemberMessagesRequestType.mailMessageType.
   * @return MessageTypeCodeType
   */
  public MessageTypeCodeType getMailMessageType()
  {
    return this.mailMessageType;
  }

  /**
   * Sets the GetMemberMessagesRequestType.mailMessageType.
   * @param mailMessageType MessageTypeCodeType
   */
  public void setMailMessageType(MessageTypeCodeType mailMessageType)
  {
    this.mailMessageType = mailMessageType;
  }

  /**
   * Gets the GetMemberMessagesRequestType.memberMessageID.
   * @return String
   */
  public String getMemberMessageID()
  {
    return this.memberMessageID;
  }

  /**
   * Sets the GetMemberMessagesRequestType.memberMessageID.
   * @param memberMessageID String
   */
  public void setMemberMessageID(String memberMessageID)
  {
    this.memberMessageID = memberMessageID;
  }

  /**
   * Gets the GetMemberMessagesRequestType.messageStatus.
   * @return MessageStatusTypeCodeType
   */
  public MessageStatusTypeCodeType getMessageStatus()
  {
    return this.messageStatus;
  }

  /**
   * Sets the GetMemberMessagesRequestType.messageStatus.
   * @param messageStatus MessageStatusTypeCodeType
   */
  public void setMessageStatus(MessageStatusTypeCodeType messageStatus)
  {
    this.messageStatus = messageStatus;
  }

  /**
   * Gets the GetMemberMessagesRequestType.pagination.
   * @return PaginationType
   */
  public PaginationType getPagination()
  {
    return this.pagination;
  }

  /**
   * Sets the GetMemberMessagesRequestType.pagination.
   * @param pagination PaginationType
   */
  public void setPagination(PaginationType pagination)
  {
    this.pagination = pagination;
  }

  /**
   * Gets the GetMemberMessagesRequestType.senderID.
   * @return String
   */
  public String getSenderID()
  {
    return this.senderID;
  }

  /**
   * Sets the GetMemberMessagesRequestType.senderID.
   * @param senderID String
   */
  public void setSenderID(String senderID)
  {
    this.senderID = senderID;
  }

  /**
   * Gets the GetMemberMessagesRequestType.startCreationTime.
   * @return Calendar
   */
  public Calendar getStartCreationTime()
  {
    return this.startCreationTime;
  }

  /**
   * Sets the GetMemberMessagesRequestType.startCreationTime.
   * @param startCreationTime Calendar
   */
  public void setStartCreationTime(Calendar startCreationTime)
  {
    this.startCreationTime = startCreationTime;
  }

  /**
   * Valid after executing the API.
   * Gets the returned GetMemberMessagesResponseType.hasMoreItems.
   * 
   * @return Boolean
   */
  public Boolean getHasMoreItems()
  {
    return this.hasMoreItems;
  }

  /**
   * Valid after executing the API.
   * Gets the returned GetMemberMessagesResponseType.paginationResult.
   * 
   * @return PaginationResultType
   */
  public PaginationResultType getPaginationResult()
  {
    return this.paginationResult;
  }

  /**
   * Valid after executing the API.
   * Gets the returned GetMemberMessagesResponseType.returnedMemberMessages.
   * 
   * @return MemberMessageExchangeType[]
   */
  public MemberMessageExchangeType[] getReturnedMemberMessages()
  {
    return this.returnedMemberMessages;
  }

}

