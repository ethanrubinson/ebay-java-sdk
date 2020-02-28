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
 * Wrapper class of the AddItems call of eBay SOAP API.
 * <br>
 * <p>Title: SOAP API wrapper library.</p>
 * <p>Description: Contains wrapper classes for eBay SOAP APIs.</p>
 * <p>Copyright: Copyright (c) 2009</p>
 * <p>Company: eBay Inc.</p>
 * <br> <B>Input property:</B> <code>AddItemRequestContainer</code> - Defines a single item to be listed on eBay. This container is similar to an <b>AddItem</b> request. Up to five of these containers can be included in one <b>AddItems</b> request.
 * <br> <B>Output property:</B> <code>ReturnedAddItemResponseContainer</code> - One <b>AddItemResponseContainer</b> container is returned for each listing that is being created with the <b>AddItems</b> call. Each container includes the <b>ItemID</b> of each newly created listings, the eBay category each item is listed under, the seller-defined SKUs of the items (if any), the listing recommendations for each item (if applicable), the start and end time of each listing, and the estimated fees that each listing will incur.
 * 
 * @author Ron Murphy
 * @version 1.0
 */

public class AddItemsCall extends com.ebay.sdk.ApiCall
{
  
  private AddItemRequestContainerType[] addItemRequestContainer = null;
  private AddItemResponseContainerType[] returnedAddItemResponseContainer=null;


  /**
   * Constructor.
   */
  public AddItemsCall() {
  }

  /**
   * Constructor.
   * @param apiContext The ApiContext object to be used to make the call.
   */
  public AddItemsCall(ApiContext apiContext) {
    super(apiContext);
    

  }

  /**
   * Defines from one to five items and lists them on a specified eBay site.
   * 
   * <br>
   * @throws ApiException
   * @throws SdkException
   * @throws Exception
   * @return The AddItemResponseContainerType[] object.
   */
  public AddItemResponseContainerType[] addItems()
      throws com.ebay.sdk.ApiException, com.ebay.sdk.SdkException, java.lang.Exception
  {
    AddItemsRequestType req;
    req = new AddItemsRequestType();
    if (this.addItemRequestContainer != null)
      req.setAddItemRequestContainer(this.addItemRequestContainer);

    AddItemsResponseType resp = (AddItemsResponseType) execute(req);

    this.returnedAddItemResponseContainer = resp.getAddItemResponseContainer();
    return this.getReturnedAddItemResponseContainer();
  }

  /**
   * Gets the AddItemsRequestType.addItemRequestContainer.
   * @return AddItemRequestContainerType[]
   */
  public AddItemRequestContainerType[] getAddItemRequestContainer()
  {
    return this.addItemRequestContainer;
  }

  /**
   * Sets the AddItemsRequestType.addItemRequestContainer.
   * @param addItemRequestContainer AddItemRequestContainerType[]
   */
  public void setAddItemRequestContainer(AddItemRequestContainerType[] addItemRequestContainer)
  {
    this.addItemRequestContainer = addItemRequestContainer;
  }

  /**
   * Valid after executing the API.
   * Gets the returned AddItemsResponseType.returnedAddItemResponseContainer.
   * 
   * @return AddItemResponseContainerType[]
   */
  public AddItemResponseContainerType[] getReturnedAddItemResponseContainer()
  {
    return this.returnedAddItemResponseContainer;
  }

}

