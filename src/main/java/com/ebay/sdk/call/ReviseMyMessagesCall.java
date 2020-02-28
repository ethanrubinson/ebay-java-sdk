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
import java.lang.Long;

import com.ebay.sdk.*;
import com.ebay.soap.eBLBaseComponents.*;
/**
 * Wrapper class of the ReviseMyMessages call of eBay SOAP API.
 * <br>
 * <p>Title: SOAP API wrapper library.</p>
 * <p>Description: Contains wrapper classes for eBay SOAP APIs.</p>
 * <p>Copyright: Copyright (c) 2009</p>
 * <p>Company: eBay Inc.</p>
 * <br> <B>Input property:</B> <code>MessageIDs</code> - This container is used to specify up to 10 messages (specified with their  <b>MessageID</b> values) on which to perform on or more actions. At least one <b>MessageID</b> value must be included in the request. <b>MessageID</b> values can be retrieved with the <b>GetMyMessages</b> call with the <b>DetailLevel</b> value set to <code>ReturnHeaders</code>.
 * <br>
 * <br>
 * <span class="tablenote"><b>Note:</b> Messages in the Sent folder of My Messages cannot be moved, marked as read, or flagged. </span>
 * <br> <B>Input property:</B> <code>AlertIDs</code> - This field is deprecated.
 * <br> <B>Input property:</B> <code>Read</code> - This boolean field is used to change the 'Read' status of the message(s) in the <b>MessageIDs</b> container. Including this field and setting its value to <code>true</code> will mark all messages in the <b>MessageIDs</b> container as 'Read'. Conversely, including this field and setting its value to <code>false</code> will mark all messages in the <b>MessageIDs</b> container as 'Unread'. The 'Read' status of a message can be retrieved by looking at the <b>Message.Read</b> boolean field of the <b>GetMyMessages</b> call response.
 * <br>
 * <br>
 * In each <b>ReviseMyMessages</b> call, at least one of the following fields must be specified in the request: <b>Read</b>, <b>Flagged</b>, and <b>FolderID</b>.
 * <br>
 * <br>
 * <span class="tablenote"><b>Note:</b> Messages in the Sent folder of My Messages cannot be moved, marked as read, or flagged. </span>
 * <br> <B>Input property:</B> <code>Flagged</code> - This boolean field is used to change the 'Flagged' status of the message(s) in the <b>MessageIDs</b> container. Including this field and setting its value to <code>true</code> will flag all messages in the <b>MessageIDs</b> container. Conversely, including this field and setting its value to <code>false</code> will unflag all messages in the <b>MessageIDs</b> container. The 'Flagged' status of a message can be retrieved by looking at the <b>Message.Flagged</b> boolean field of the <b>GetMyMessages</b> call response.
 * <br>
 * <br>
 * In each <b>ReviseMyMessages</b> call, at least one of the following fields must be specified in the request: <b>Read</b>, <b>Flagged</b>, and <b>FolderID</b>.
 * <br>
 * <br>
 * <span class="tablenote"><b>Note:</b> Messages in the Sent folder of My Messages cannot be moved, marked as read, or flagged. </span>
 * <br> <B>Input property:</B> <code>FolderID</code> - A unique identifier of My Messages folder. A <b>FolderID</b> value is supplied if the user want to move the message(s) in the <b>MessageIDs</b> container to a different folder. <b>FolderID</b> values can be retrieved with the <b>GetMyMessages</b> call with the <b>DetailLevel</b> value set to <code>ReturnSummary</code>. <br>
 * <br>
 * In each <b>ReviseMyMessages</b> call, at least one of the following fields must be specified in the request: <b>Read</b>, <b>Flagged</b>, and <b>FolderID</b>.
 * <br>
 * <br>
 * <span class="tablenote"><b>Note:</b> Messages in the Sent folder of My Messages cannot be moved, marked as read, or flagged. </span>
 * 
 * @author Ron Murphy
 * @version 1.0
 */

public class ReviseMyMessagesCall extends com.ebay.sdk.ApiCall
{
  
  private String[] messageIDs = null;
  private String[] alertIDs = null;
  private Boolean read = null;
  private Boolean flagged = null;
  private Long folderID = null;


  /**
   * Constructor.
   */
  public ReviseMyMessagesCall() {
  }

  /**
   * Constructor.
   * @param apiContext The ApiContext object to be used to make the call.
   */
  public ReviseMyMessagesCall(ApiContext apiContext) {
    super(apiContext);
    

  }

  /**
   * This call can be used to mark one or more messages as 'Read', to flag one or more messages, and/or to move one or more messages to another My Messages folder. Any of these actions can be applied on up to 10 messages with one call.
   * 
   * <br>
   * @throws ApiException
   * @throws SdkException
   * @throws Exception
   * @return The void object.
   */
  public void reviseMyMessages()
      throws com.ebay.sdk.ApiException, com.ebay.sdk.SdkException, java.lang.Exception
  {
    ReviseMyMessagesRequestType req;
    req = new ReviseMyMessagesRequestType();
    if (this.messageIDs != null)
    {
      MyMessagesMessageIDArrayType ary = new MyMessagesMessageIDArrayType();
      ary.setMessageID(this.messageIDs);
      req.setMessageIDs(ary);
    }
    if (this.alertIDs != null)
    {
      MyMessagesAlertIDArrayType ary = new MyMessagesAlertIDArrayType();
      ary.setAlertID(this.alertIDs);
      req.setAlertIDs(ary);
    }
    if (this.read != null)
      req.setRead(this.read);
    if (this.flagged != null)
      req.setFlagged(this.flagged);
    if (this.folderID != null)
      req.setFolderID(this.folderID);

    ReviseMyMessagesResponseType resp = (ReviseMyMessagesResponseType) execute(req);


  }

  /**
   * Gets the ReviseMyMessagesRequestType.alertIDs.
   * @return String[]
   */
  public String[] getAlertIDs()
  {
    return this.alertIDs;
  }

  /**
   * Sets the ReviseMyMessagesRequestType.alertIDs.
   * @param alertIDs String[]
   */
  public void setAlertIDs(String[] alertIDs)
  {
    this.alertIDs = alertIDs;
  }

  /**
   * Gets the ReviseMyMessagesRequestType.flagged.
   * @return Boolean
   */
  public Boolean getFlagged()
  {
    return this.flagged;
  }

  /**
   * Sets the ReviseMyMessagesRequestType.flagged.
   * @param flagged Boolean
   */
  public void setFlagged(Boolean flagged)
  {
    this.flagged = flagged;
  }

  /**
   * Gets the ReviseMyMessagesRequestType.folderID.
   * @return Long
   */
  public Long getFolderID()
  {
    return this.folderID;
  }

  /**
   * Sets the ReviseMyMessagesRequestType.folderID.
   * @param folderID Long
   */
  public void setFolderID(Long folderID)
  {
    this.folderID = folderID;
  }

  /**
   * Gets the ReviseMyMessagesRequestType.messageIDs.
   * @return String[]
   */
  public String[] getMessageIDs()
  {
    return this.messageIDs;
  }

  /**
   * Sets the ReviseMyMessagesRequestType.messageIDs.
   * @param messageIDs String[]
   */
  public void setMessageIDs(String[] messageIDs)
  {
    this.messageIDs = messageIDs;
  }

  /**
   * Gets the ReviseMyMessagesRequestType.read.
   * @return Boolean
   */
  public Boolean getRead()
  {
    return this.read;
  }

  /**
   * Sets the ReviseMyMessagesRequestType.read.
   * @param read Boolean
   */
  public void setRead(Boolean read)
  {
    this.read = read;
  }

}

