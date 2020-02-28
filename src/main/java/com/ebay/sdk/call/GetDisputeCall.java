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
 * Wrapper class of the GetDispute call of eBay SOAP API.
 * <br>
 * <p>Title: SOAP API wrapper library.</p>
 * <p>Description: Contains wrapper classes for eBay SOAP APIs.</p>
 * <p>Copyright: Copyright (c) 2009</p>
 * <p>Company: eBay Inc.</p>
 * <br> <B>Input property:</B> <code>DisputeID</code> - The unique identifier of an seller-initiated dispute. The caller passes in this value to retrieve detailed information on a specific dispute.
 * <br/><br/>
 * <span class="tablenote"><strong>Note:</strong>
 * Buyer-initiated Money Back Guarantee cases are not supported with this call. To retrieve and manage eBay Money Back Guarantee cases, the Case Management calls of the <a href="https://developer.ebay.com/Devzone/post-order/index.html" target="_blank">Post-Order API</a> can be used instead.
 * </span>
 * <br> <B>Output property:</B> <code>ReturnedDispute</code> - If the dispute that is specified in the call request is found, this <b>Dispute</b> container is returned in the response. This container includes detailed information about the dispute, the buyer and seller user IDs, and information on the listing that is associated with the dispute.
 * 
 * @author Ron Murphy
 * @version 1.0
 */

public class GetDisputeCall extends com.ebay.sdk.ApiCall
{
  
  private String disputeID = null;
  private DisputeType returnedDispute=null;


  /**
   * Constructor.
   */
  public GetDisputeCall() {
  }

  /**
   * Constructor.
   * @param apiContext The ApiContext object to be used to make the call.
   */
  public GetDisputeCall(ApiContext apiContext) {
    super(apiContext);
    

  }

  /**
   * This is the base request type for the <b>GetDispute</b> call. This call retrieves the details of a seller-initiated dispute. Seller-initiated disputes include mutually-cancelled transactions and unpaid items.
   * <br/><br/>
   * <span class="tablenote"><strong>Note:</strong>
   * This call does not support buyer-initiated cases created through eBay's Resolution Center. Buyer-initiated cases include Item Not Received (INR) and escalated Return cases. To retrieve and manage eBay Money Back Guarantee cases, the Case Management calls of the <a href="http://developer.ebay.com/Devzone/post-order/index.html" target="_blank">Post-Order API</a> can be used instead.
   * </span>
   * 
   * <br>
   * @throws ApiException
   * @throws SdkException
   * @throws Exception
   * @return The DisputeType object.
   */
  public DisputeType getDispute()
      throws com.ebay.sdk.ApiException, com.ebay.sdk.SdkException, java.lang.Exception
  {
    GetDisputeRequestType req;
    req = new GetDisputeRequestType();
    req.setDetailLevel(this.getDetailLevel());
    if (this.disputeID != null)
      req.setDisputeID(this.disputeID);

    GetDisputeResponseType resp = (GetDisputeResponseType) execute(req);

    this.returnedDispute = resp.getDispute();
    return this.getReturnedDispute();
  }

  /**
   * Gets the GetDisputeRequestType.disputeID.
   * @return String
   */
  public String getDisputeID()
  {
    return this.disputeID;
  }

  /**
   * Sets the GetDisputeRequestType.disputeID.
   * @param disputeID String
   */
  public void setDisputeID(String disputeID)
  {
    this.disputeID = disputeID;
  }

  /**
   * Valid after executing the API.
   * Gets the returned GetDisputeResponseType.returnedDispute.
   * 
   * @return DisputeType
   */
  public DisputeType getReturnedDispute()
  {
    return this.returnedDispute;
  }

}

