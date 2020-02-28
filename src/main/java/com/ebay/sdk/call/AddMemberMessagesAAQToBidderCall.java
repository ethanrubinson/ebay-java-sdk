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
 * Wrapper class of the AddMemberMessagesAAQToBidder call of eBay SOAP API.
 * <br>
 * <p>Title: SOAP API wrapper library.</p>
 * <p>Description: Contains wrapper classes for eBay SOAP APIs.</p>
 * <p>Copyright: Copyright (c) 2009</p>
 * <p>Company: eBay Inc.</p>
 * <br> <B>Input property:</B> <code>AddMemberMessagesAAQToBidderRequestContainer</code> - An <b>AddMemberMessagesAAQToBidderRequestContainer</b> container is required for each message being sent to unique bidders/potential buyers.  A seller can send up to 10 messages to unique bidders/potential buyers in one <b>AddMemberMessagesAAQToBidder</b> call.
 * <br> <B>Output property:</B> <code>ReturnedAddMemberMessagesAAQToBidderResponseContainer</code> - Container consisting of the <b>Ack</b> field (indicating the result of the send message operation) and the <b>CorrelationID</b> field (used to track multiple send message operations performed in one call).
 * 
 * @author Ron Murphy
 * @version 1.0
 */

public class AddMemberMessagesAAQToBidderCall extends com.ebay.sdk.ApiCall
{
  
  private AddMemberMessagesAAQToBidderRequestContainerType[] addMemberMessagesAAQToBidderRequestContainer = null;
  private AddMemberMessagesAAQToBidderResponseContainerType[] returnedAddMemberMessagesAAQToBidderResponseContainer=null;


  /**
   * Constructor.
   */
  public AddMemberMessagesAAQToBidderCall() {
  }

  /**
   * Constructor.
   * @param apiContext The ApiContext object to be used to make the call.
   */
  public AddMemberMessagesAAQToBidderCall(ApiContext apiContext) {
    super(apiContext);
    

  }

  /**
   * The base request of the <b>AddMemberMessagesAAQToBidder</b> call, which allows a seller to send up to 10 messages to bidders/potential buyers regarding an active listing. These potential buyers may include those who have made a Best Offer on a listing.
   * 
   * <br>
   * @throws ApiException
   * @throws SdkException
   * @throws Exception
   * @return The AddMemberMessagesAAQToBidderResponseContainerType[] object.
   */
  public AddMemberMessagesAAQToBidderResponseContainerType[] addMemberMessagesAAQToBidder()
      throws com.ebay.sdk.ApiException, com.ebay.sdk.SdkException, java.lang.Exception
  {
    AddMemberMessagesAAQToBidderRequestType req;
    req = new AddMemberMessagesAAQToBidderRequestType();
    if (this.addMemberMessagesAAQToBidderRequestContainer != null)
      req.setAddMemberMessagesAAQToBidderRequestContainer(this.addMemberMessagesAAQToBidderRequestContainer);

    AddMemberMessagesAAQToBidderResponseType resp = (AddMemberMessagesAAQToBidderResponseType) execute(req);

    this.returnedAddMemberMessagesAAQToBidderResponseContainer = resp.getAddMemberMessagesAAQToBidderResponseContainer();
    return this.getReturnedAddMemberMessagesAAQToBidderResponseContainer();
  }

  /**
   * Gets the AddMemberMessagesAAQToBidderRequestType.addMemberMessagesAAQToBidderRequestContainer.
   * @return AddMemberMessagesAAQToBidderRequestContainerType[]
   */
  public AddMemberMessagesAAQToBidderRequestContainerType[] getAddMemberMessagesAAQToBidderRequestContainer()
  {
    return this.addMemberMessagesAAQToBidderRequestContainer;
  }

  /**
   * Sets the AddMemberMessagesAAQToBidderRequestType.addMemberMessagesAAQToBidderRequestContainer.
   * @param addMemberMessagesAAQToBidderRequestContainer AddMemberMessagesAAQToBidderRequestContainerType[]
   */
  public void setAddMemberMessagesAAQToBidderRequestContainer(AddMemberMessagesAAQToBidderRequestContainerType[] addMemberMessagesAAQToBidderRequestContainer)
  {
    this.addMemberMessagesAAQToBidderRequestContainer = addMemberMessagesAAQToBidderRequestContainer;
  }

  /**
   * Valid after executing the API.
   * Gets the returned AddMemberMessagesAAQToBidderResponseType.returnedAddMemberMessagesAAQToBidderResponseContainer.
   * 
   * @return AddMemberMessagesAAQToBidderResponseContainerType[]
   */
  public AddMemberMessagesAAQToBidderResponseContainerType[] getReturnedAddMemberMessagesAAQToBidderResponseContainer()
  {
    return this.returnedAddMemberMessagesAAQToBidderResponseContainer;
  }

}

