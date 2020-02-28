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
 * Wrapper class of the SellerReverseDispute call of eBay SOAP API.
 * <br>
 * <p>Title: SOAP API wrapper library.</p>
 * <p>Description: Contains wrapper classes for eBay SOAP APIs.</p>
 * <p>Copyright: Copyright (c) 2009</p>
 * <p>Company: eBay Inc.</p>
 * <br> <B>Input property:</B> <code>DisputeID</code> - The unique identifier of the dispute that was returned when the dispute was created.
 * The dispute must be an Unpaid Item dispute that the seller opened.
 * <br> <B>Input property:</B> <code>DisputeResolutionReason</code> - The reason the dispute is being reversed.
 * 
 * @author Ron Murphy
 * @version 1.0
 */

public class SellerReverseDisputeCall extends com.ebay.sdk.ApiCall
{
  
  private String disputeID = null;
  private DisputeResolutionReasonCodeType disputeResolutionReason = null;


  /**
   * Constructor.
   */
  public SellerReverseDisputeCall() {
  }

  /**
   * Constructor.
   * @param apiContext The ApiContext object to be used to make the call.
   */
  public SellerReverseDisputeCall(ApiContext apiContext) {
    super(apiContext);
    

  }

  /**
   * Enables a seller to "reverse" an Unpaid Item dispute that has been closed in case the buyer and seller are able to reach a mutual agreement. If this action is successful, the seller receives a Final Value Fee
   * credit and the buyer's Unpaid Item strike are both reversed, if applicable.
   * The dispute might have resulted
   * in a strike to the buyer and a Final Value Fee credit to the seller. A buyer and
   * seller sometimes come to agreement after a dispute has been closed. In particular,
   * the seller might discover that the buyer actually paid, or the buyer might agree
   * to pay the seller's fees in exchange for having the strike removed.
   * <br><br>
   * A dispute can only be reversed if it was closed with <b>DisputeActivity</b> set to
   * <b>SellerEndCommunication</b>, <b>CameToAgreementNeedFVFCredit</b>, or
   * <b>MutualAgreementOrNoBuyerResponse</b>.
   * 
   * <br>
   * @throws ApiException
   * @throws SdkException
   * @throws Exception
   * @return The SellerReverseDisputeResponseType object.
   */
  public SellerReverseDisputeResponseType sellerReverseDispute()
      throws com.ebay.sdk.ApiException, com.ebay.sdk.SdkException, java.lang.Exception
  {
    SellerReverseDisputeRequestType req;
    req = new SellerReverseDisputeRequestType();
    if (this.disputeID != null)
      req.setDisputeID(this.disputeID);
    if (this.disputeResolutionReason != null)
      req.setDisputeResolutionReason(this.disputeResolutionReason);

    SellerReverseDisputeResponseType resp = (SellerReverseDisputeResponseType) execute(req);

    return resp;
  }

  /**
   * Gets the SellerReverseDisputeRequestType.disputeID.
   * @return String
   */
  public String getDisputeID()
  {
    return this.disputeID;
  }

  /**
   * Sets the SellerReverseDisputeRequestType.disputeID.
   * @param disputeID String
   */
  public void setDisputeID(String disputeID)
  {
    this.disputeID = disputeID;
  }

  /**
   * Gets the SellerReverseDisputeRequestType.disputeResolutionReason.
   * @return DisputeResolutionReasonCodeType
   */
  public DisputeResolutionReasonCodeType getDisputeResolutionReason()
  {
    return this.disputeResolutionReason;
  }

  /**
   * Sets the SellerReverseDisputeRequestType.disputeResolutionReason.
   * @param disputeResolutionReason DisputeResolutionReasonCodeType
   */
  public void setDisputeResolutionReason(DisputeResolutionReasonCodeType disputeResolutionReason)
  {
    this.disputeResolutionReason = disputeResolutionReason;
  }

}

