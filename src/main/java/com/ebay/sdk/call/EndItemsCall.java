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
 * Wrapper class of the EndItems call of eBay SOAP API.
 * <br>
 * <p>Title: SOAP API wrapper library.</p>
 * <p>Description: Contains wrapper classes for eBay SOAP APIs.</p>
 * <p>Copyright: Copyright (c) 2009</p>
 * <p>Company: eBay Inc.</p>
 * <br> <B>Input property:</B> <code>EndItemRequestContainer</code> - An <b>EndItemRequestContainer</b> container is required for each eBay listing that the seller plans to end through the <b>EndItems</b> call. Up to 10 eBay listings can be ended with one <b>EndItems</b> call.
 * <br> <B>Output property:</B> <code>ReturnedEndItemResponseContainer</code> - Returns a response for an individually ended item. Mutiple containers will be listed if multiple items are ended.
 * 
 * @author Ron Murphy
 * @version 1.0
 */

public class EndItemsCall extends com.ebay.sdk.ApiCall
{
  
  private EndItemRequestContainerType[] endItemRequestContainer = null;
  private EndItemResponseContainerType[] returnedEndItemResponseContainer=null;


  /**
   * Constructor.
   */
  public EndItemsCall() {
  }

  /**
   * Constructor.
   * @param apiContext The ApiContext object to be used to make the call.
   */
  public EndItemsCall(ApiContext apiContext) {
    super(apiContext);
    

  }

  /**
   * The <b>EndItems</b> call is used to end up to 10 specified eBay listings before the date and time at which those listings would normally end per the listing duration.
   * 
   * <br>
   * @throws ApiException
   * @throws SdkException
   * @throws Exception
   * @return The EndItemResponseContainerType[] object.
   */
  public EndItemResponseContainerType[] endItems()
      throws com.ebay.sdk.ApiException, com.ebay.sdk.SdkException, java.lang.Exception
  {
    EndItemsRequestType req;
    req = new EndItemsRequestType();
    if (this.endItemRequestContainer != null)
      req.setEndItemRequestContainer(this.endItemRequestContainer);

    EndItemsResponseType resp = (EndItemsResponseType) execute(req);

    this.returnedEndItemResponseContainer = resp.getEndItemResponseContainer();
    return this.getReturnedEndItemResponseContainer();
  }

  /**
   * Gets the EndItemsRequestType.endItemRequestContainer.
   * @return EndItemRequestContainerType[]
   */
  public EndItemRequestContainerType[] getEndItemRequestContainer()
  {
    return this.endItemRequestContainer;
  }

  /**
   * Sets the EndItemsRequestType.endItemRequestContainer.
   * @param endItemRequestContainer EndItemRequestContainerType[]
   */
  public void setEndItemRequestContainer(EndItemRequestContainerType[] endItemRequestContainer)
  {
    this.endItemRequestContainer = endItemRequestContainer;
  }

  /**
   * Valid after executing the API.
   * Gets the returned EndItemsResponseType.returnedEndItemResponseContainer.
   * 
   * @return EndItemResponseContainerType[]
   */
  public EndItemResponseContainerType[] getReturnedEndItemResponseContainer()
  {
    return this.returnedEndItemResponseContainer;
  }

}

