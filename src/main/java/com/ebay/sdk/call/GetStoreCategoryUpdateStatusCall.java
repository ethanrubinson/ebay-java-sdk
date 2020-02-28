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

import com.ebay.sdk.*;
import com.ebay.soap.eBLBaseComponents.*;
/**
 * Wrapper class of the GetStoreCategoryUpdateStatus call of eBay SOAP API.
 * <br>
 * <p>Title: SOAP API wrapper library.</p>
 * <p>Description: Contains wrapper classes for eBay SOAP APIs.</p>
 * <p>Copyright: Copyright (c) 2009</p>
 * <p>Company: eBay Inc.</p>
 * <br> <B>Input property:</B> <code>TaskID</code> - The unique identifier of an eBay Store Category hierarchy change task. A <b>TaskID</b> value is returned in the response of a successful <b>SetStoreCategories</b> call.
 * <br/><br/>
 * <span class="tablenote"><b>Note: </b> Depending on the breadth of changes being made to an eBay Store Category hierarchy, it is is possible that the <b>SetStoreCategories</b> call will complete the task simultaneously with the call response. A seller will know if an eBay Store Category hierarchy task was completed simultaneously if the <b>TaskID</b> value is returned as <code>0</code>, and the <b>Status</b> field is returned with a value of <code>Complete</code>. If the task was not completely simultaneously, the <b>TaskID</b> value will be a positive integer, and the <b>Status</b> field will show a value of <code>InProgress</code> or <code>Pending</code>.
 * </span>
 * <br> <B>Output property:</B> <code>ReturnedStatus</code> - The enumeration value indicates the status of an update to the
 * eBay Store Category hierarchy.
 * 
 * @author Ron Murphy
 * @version 1.0
 */

public class GetStoreCategoryUpdateStatusCall extends com.ebay.sdk.ApiCall
{
  
  private long taskID = 0;
  private TaskStatusCodeType returnedStatus=null;


  /**
   * Constructor.
   */
  public GetStoreCategoryUpdateStatusCall() {
  }

  /**
   * Constructor.
   * @param apiContext The ApiContext object to be used to make the call.
   */
  public GetStoreCategoryUpdateStatusCall(ApiContext apiContext) {
    super(apiContext);
    

  }

  /**
   * This call is used to retrieve the status of an eBay Store Category hierarchy change that was made with a <b>SetStoreCategories</b> call.
   * 
   * <br>
   * @throws ApiException
   * @throws SdkException
   * @throws Exception
   * @return The TaskStatusCodeType object.
   */
  public TaskStatusCodeType getStoreCategoryUpdateStatus()
      throws com.ebay.sdk.ApiException, com.ebay.sdk.SdkException, java.lang.Exception
  {
    GetStoreCategoryUpdateStatusRequestType req;
    req = new GetStoreCategoryUpdateStatusRequestType();
    if (this.taskID != 0)
      req.setTaskID(new Long(this.taskID));

    GetStoreCategoryUpdateStatusResponseType resp = (GetStoreCategoryUpdateStatusResponseType) execute(req);

    this.returnedStatus = resp.getStatus();
    return this.getReturnedStatus();
  }

  /**
   * Gets the GetStoreCategoryUpdateStatusRequestType.taskID.
   * @return long
   */
  public long getTaskID()
  {
    return this.taskID;
  }

  /**
   * Sets the GetStoreCategoryUpdateStatusRequestType.taskID.
   * @param taskID long
   */
  public void setTaskID(long taskID)
  {
    this.taskID = taskID;
  }

  /**
   * Valid after executing the API.
   * Gets the returned GetStoreCategoryUpdateStatusResponseType.returnedStatus.
   * 
   * @return TaskStatusCodeType
   */
  public TaskStatusCodeType getReturnedStatus()
  {
    return this.returnedStatus;
  }

}

