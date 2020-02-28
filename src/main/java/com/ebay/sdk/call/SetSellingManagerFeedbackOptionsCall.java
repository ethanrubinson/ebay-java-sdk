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
 * Wrapper class of the SetSellingManagerFeedbackOptions call of eBay SOAP API.
 * <br>
 * <p>Title: SOAP API wrapper library.</p>
 * <p>Description: Contains wrapper classes for eBay SOAP APIs.</p>
 * <p>Copyright: Copyright (c) 2009</p>
 * <p>Company: eBay Inc.</p>
 * <br> <B>Input property:</B> <code>AutomatedLeaveFeedbackEvent</code> - Specifies the event that will trigger automated feedback to the buyer.
 * <br> <B>Input property:</B> <code>StoredComments</code> - Contains a set of comments from which one can be selected to leave
 * feedback for a buyer. If automated feedback is used, a comment is
 * selected from the set randomly. Stored comments cannot be replaced or
 * edited individually. Submitting a stored comments array replaces all
 * existing stored comments.
 * <br>
 * 
 * @author Ron Murphy
 * @version 1.0
 */

public class SetSellingManagerFeedbackOptionsCall extends com.ebay.sdk.ApiCall
{
  
  private AutomatedLeaveFeedbackEventCodeType automatedLeaveFeedbackEvent = null;
  private FeedbackCommentArrayType storedComments = null;


  /**
   * Constructor.
   */
  public SetSellingManagerFeedbackOptionsCall() {
  }

  /**
   * Constructor.
   * @param apiContext The ApiContext object to be used to make the call.
   */
  public SetSellingManagerFeedbackOptionsCall(ApiContext apiContext) {
    super(apiContext);
    

  }

  /**
   * Enables Selling Manager Pro subscribers to store standard feedback comments that can
   * be left for their buyers. Selling Manager Pro subscribers can also specify what
   * events, if any, will trigger an automated feedback response to buyers.
   * 
   * <br>
   * @throws ApiException
   * @throws SdkException
   * @throws Exception
   * @return The void object.
   */
  public void setSellingManagerFeedbackOptions()
      throws com.ebay.sdk.ApiException, com.ebay.sdk.SdkException, java.lang.Exception
  {
    SetSellingManagerFeedbackOptionsRequestType req;
    req = new SetSellingManagerFeedbackOptionsRequestType();
    if (this.automatedLeaveFeedbackEvent != null)
      req.setAutomatedLeaveFeedbackEvent(this.automatedLeaveFeedbackEvent);
    if (this.storedComments != null)
      req.setStoredComments(this.storedComments);

    SetSellingManagerFeedbackOptionsResponseType resp = (SetSellingManagerFeedbackOptionsResponseType) execute(req);


  }

  /**
   * Gets the SetSellingManagerFeedbackOptionsRequestType.automatedLeaveFeedbackEvent.
   * @return AutomatedLeaveFeedbackEventCodeType
   */
  public AutomatedLeaveFeedbackEventCodeType getAutomatedLeaveFeedbackEvent()
  {
    return this.automatedLeaveFeedbackEvent;
  }

  /**
   * Sets the SetSellingManagerFeedbackOptionsRequestType.automatedLeaveFeedbackEvent.
   * @param automatedLeaveFeedbackEvent AutomatedLeaveFeedbackEventCodeType
   */
  public void setAutomatedLeaveFeedbackEvent(AutomatedLeaveFeedbackEventCodeType automatedLeaveFeedbackEvent)
  {
    this.automatedLeaveFeedbackEvent = automatedLeaveFeedbackEvent;
  }

  /**
   * Gets the SetSellingManagerFeedbackOptionsRequestType.storedComments.
   * @return FeedbackCommentArrayType
   */
  public FeedbackCommentArrayType getStoredComments()
  {
    return this.storedComments;
  }

  /**
   * Sets the SetSellingManagerFeedbackOptionsRequestType.storedComments.
   * @param storedComments FeedbackCommentArrayType
   */
  public void setStoredComments(FeedbackCommentArrayType storedComments)
  {
    this.storedComments = storedComments;
  }

}

