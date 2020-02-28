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

import com.ebay.sdk.*;
import com.ebay.soap.eBLBaseComponents.*;
/**
 * Wrapper class of the ReviseMyMessagesFolders call of eBay SOAP API.
 * <br>
 * <p>Title: SOAP API wrapper library.</p>
 * <p>Description: Contains wrapper classes for eBay SOAP APIs.</p>
 * <p>Copyright: Copyright (c) 2009</p>
 * <p>Company: eBay Inc.</p>
 * <br> <B>Input property:</B> <code>Operation</code> - This required field is used to indicate the type of operation to perform (add, remove, or rename a folder). See the enumeration descriptions below for more information on the usage, requirements, and limitations on each operation.
 * <br> <B>Input property:</B> <code>FolderID</code> - The eBay-generated unique identifier for a custom folder in <b>My eBay Messages</b>. The <b>FolderID</b> value is required for the 'Rename' and 'Remove' operations, but not for the 'Display' (add) operation. <b>FolderID</b> values can be retrieved by calling <b>GetMyMessages</b> with a <b>DetailLevel</b> value set to <code>ReturnSummary</code>, or the <b>FolderID</b> value for a <b>My eBay Messages</b> folder can be seen at the end of the browser's URL field when you navigate to that folder in <b>My eBay Messages</b>.
 * <br/><br/>
 * <span class="tablenote"><b>Note: </b> If multiple folders will be renamed with one call, the user must pay close attention to the order of the <b>FolderID</b> and <b>FolderName</b> fields, as eBay will process these requests in order according to the placement of the the <b>FolderID</b> and <b>FolderName</b> fields. So, the existing folder identified by the first <b>FolderID</b> field in the request payload will get renamed to the folder name passed into the first <b>FolderName</b> field in the request payload, and so on.
 * </span>
 * <br> <B>Input property:</B> <code>FolderName</code> - The user-specified name of the <b>My eBay Messages</b> folder. The <b>FolderName</b> value is required for the 'Display' (add) and 'Rename' operations, but not for the 'Remove' operation. In a 'Display' (add) operation, the name passed into the <b>FolderName</b> field is the name of the new folder. In a 'Rename' operation, the name passed into the <b>FolderName</b> field will be the new name of the existing folder that is specified through the corresponding <b>FolderID</b> field.
 * <br/><br/>
 * <b>FolderName</b> values can be retrieved by calling <b>GetMyMessages</b> with a <b>DetailLevel</b> value set to <code>ReturnSummary</code>, or the <b>FolderName</b> value for a <b>My eBay Messages</b> folder can be seen when you navigate to <b>My eBay Messages</b>.
 * <br/><br/>
 * <span class="tablenote"><b>Note: </b> If multiple folders will be renamed with one call, the user must pay close attention to the order of the <b>FolderID</b> and <b>FolderName</b> fields, as eBay will process these requests in order according to the placement of the the <b>FolderID</b> and <b>FolderName</b> fields. So, the existing folder identified by the first <b>FolderID</b> field in the request payload will get renamed to the folder name passed into the first <b>FolderName</b> field in the request payload, and so on.
 * </span>
 * 
 * @author Ron Murphy
 * @version 1.0
 */

public class ReviseMyMessagesFoldersCall extends com.ebay.sdk.ApiCall
{
  
  private MyMessagesFolderOperationCodeType operation = null;
  private long[] folderID = null;
  private String[] folderName = null;


  /**
   * Constructor.
   */
  public ReviseMyMessagesFoldersCall() {
  }

  /**
   * Constructor.
   * @param apiContext The ApiContext object to be used to make the call.
   */
  public ReviseMyMessagesFoldersCall(ApiContext apiContext) {
    super(apiContext);
    

  }

  /**
   * This call can be used to add, remove, or rename a custom folder in <b>My eBay Messages</b>. Note that the Inbox and Sent folders cannot be removed or renamed in <b>My eBay Messages</b>.
   * <br/><br/>
   * A user can have up to 10 custom folders in <b>My eBay Messages</b>, and it is possible to add, remove, or rename up to 10 custom folders with one <b>ReviseMyMessagesFolders</b> call
   * 
   * <br>
   * @throws ApiException
   * @throws SdkException
   * @throws Exception
   * @return The void object.
   */
  public void reviseMyMessagesFolders()
      throws com.ebay.sdk.ApiException, com.ebay.sdk.SdkException, java.lang.Exception
  {
    ReviseMyMessagesFoldersRequestType req;
    req = new ReviseMyMessagesFoldersRequestType();

    if( this.folderID == null )
      throw new SdkException("FolderID property is not set.");
    if( this.operation == null )
      throw new SdkException("Operation property is not set.");

    if (this.operation != null)
      req.setOperation(this.operation);
    if (this.folderID != null)
      req.setFolderID(this.folderID);
    if (this.folderName != null)
      req.setFolderName(this.folderName);

    ReviseMyMessagesFoldersResponseType resp = (ReviseMyMessagesFoldersResponseType) execute(req);


  }

  /**
   * Gets the ReviseMyMessagesFoldersRequestType.folderID.
   * @return long[]
   */
  public long[] getFolderID()
  {
    return this.folderID;
  }

  /**
   * Sets the ReviseMyMessagesFoldersRequestType.folderID.
   * @param folderID long[]
   */
  public void setFolderID(long[] folderID)
  {
    this.folderID = folderID;
  }

  /**
   * Gets the ReviseMyMessagesFoldersRequestType.folderName.
   * @return String[]
   */
  public String[] getFolderName()
  {
    return this.folderName;
  }

  /**
   * Sets the ReviseMyMessagesFoldersRequestType.folderName.
   * @param folderName String[]
   */
  public void setFolderName(String[] folderName)
  {
    this.folderName = folderName;
  }

  /**
   * Gets the ReviseMyMessagesFoldersRequestType.operation.
   * @return MyMessagesFolderOperationCodeType
   */
  public MyMessagesFolderOperationCodeType getOperation()
  {
    return this.operation;
  }

  /**
   * Sets the ReviseMyMessagesFoldersRequestType.operation.
   * @param operation MyMessagesFolderOperationCodeType
   */
  public void setOperation(MyMessagesFolderOperationCodeType operation)
  {
    this.operation = operation;
  }

}

