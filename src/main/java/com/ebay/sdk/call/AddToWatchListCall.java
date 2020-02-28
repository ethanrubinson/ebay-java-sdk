/*
Copyright (c) 2013 eBay, Inc.
This program is licensed under the terms of the eBay Common Development and
Distribution License (CDDL) Version 1.0 (the "License") and any subsequent  version 
thereof released by eBay.  The then-current version of the License can be found 
at http://www.opensource.org/licenses/cddl1.php and in the eBaySDKLicense file that 
is under the eBay SDK ../docs directory.
*/

package com.ebay.sdk.call;

import java.lang.Integer;

import com.ebay.sdk.*;
import com.ebay.soap.eBLBaseComponents.*;
/**
 * Wrapper class of the AddToWatchList call of eBay SOAP API.
 * <br>
 * <p>Title: SOAP API wrapper library.</p>
 * <p>Description: Contains wrapper classes for eBay SOAP APIs.</p>
 * <p>Copyright: Copyright (c) 2009</p>
 * <p>Company: eBay Inc.</p>
 * <br> <B>Input property:</B> <code>ItemIDs</code> - The unique identifier of the single-variation listing that is to be added to the eBay user's Watch List. The item must be a currently active item, and the total number of items in the user's Watch List (after the items in the request have been added) cannot exceed the maximum allowed number of Watch List items. One or more <b>ItemID</b> fields can be specified. A separate error node will be returned for each item that was not successfully added to the Watch List.<br> <br> The user must use either one or more <b>ItemID</b> values or one or more <b>VariationKey</b> containers, but the user may not use both of these entities in the same call.
 * <br> <B>Input property:</B> <code>VariationKey</code> - This container is used to specify one or more item variations in a multi-variation, fixed-price listing that you want to add to the Watch List.
 * The listing is identified through the <b>ItemID</b> value and each item variation existing within that listing is identified through a <b>VariationSpecifics.NameValueList</b> container.
 * <br>
 * <br>
 * The user must use either one or more <b>ItemID</b> values or one or more <b>VariationKey</b> containers, but the user may not use both of these entities in the same call.
 * <br> <B>Output property:</B> <code>ReturnedWatchListCount</code> - This integer value indicates the total number of items in the user's Watch List (after those specified in the call request have been successfully added).
 * <br> <B>Output property:</B> <code>ReturnedWatchListMaximum</code> - This integer value indicates the maximum number of items allowed in a user's Watch List. This value can vary by site and is subject to change. Currently on the US site, up to 200 items can be on the user's Watch List at any given time.
 * 
 * @author Ron Murphy
 * @version 1.0
 */

public class AddToWatchListCall extends com.ebay.sdk.ApiCall
{
  
  private String[] itemIDs = null;
  private VariationKeyType[] variationKey = null;
  private int returnedWatchListCount=0;
  private int returnedWatchListMaximum=0;


  /**
   * Constructor.
   */
  public AddToWatchListCall() {
  }

  /**
   * Constructor.
   * @param apiContext The ApiContext object to be used to make the call.
   */
  public AddToWatchListCall(ApiContext apiContext) {
    super(apiContext);
    

  }

  /**
   * Adds one or more order line items to the eBay user's Watch List. An auction item or a single-variation, fixed-price listing is identified with an <b>ItemID</b> value. To add a specific item variation to the Watch List from within a multi-variation, fixed-price listing, the user will use the  <b>VariationKey</b> container instead.
   * 
   * <br>
   * @throws ApiException
   * @throws SdkException
   * @throws Exception
   * @return The void object.
   */
  public void addToWatchList()
      throws com.ebay.sdk.ApiException, com.ebay.sdk.SdkException, java.lang.Exception
  {
    AddToWatchListRequestType req;
    req = new AddToWatchListRequestType();

    if( this.itemIDs == null || this.itemIDs.length == 0 )
      throw new SdkException("Please specify one or more item IDs in ItemIDs property.");

    if (this.itemIDs != null)
      req.setItemID(this.itemIDs);
    if (this.variationKey != null)
      req.setVariationKey(this.variationKey);

    AddToWatchListResponseType resp = (AddToWatchListResponseType) execute(req);

    this.returnedWatchListCount = (resp.getWatchListCount() == null? 0: resp.getWatchListCount().intValue());
    this.returnedWatchListMaximum = (resp.getWatchListMaximum() == null? 0: resp.getWatchListMaximum().intValue());

  }

  /**
   * Gets the AddToWatchListRequestType.itemIDs.
   * @return String[]
   */
  public String[] getItemIDs()
  {
    return this.itemIDs;
  }

  /**
   * Sets the AddToWatchListRequestType.itemIDs.
   * @param itemIDs String[]
   */
  public void setItemIDs(String[] itemIDs)
  {
    this.itemIDs = itemIDs;
  }

  /**
   * Gets the AddToWatchListRequestType.variationKey.
   * @return VariationKeyType[]
   */
  public VariationKeyType[] getVariationKey()
  {
    return this.variationKey;
  }

  /**
   * Sets the AddToWatchListRequestType.variationKey.
   * @param variationKey VariationKeyType[]
   */
  public void setVariationKey(VariationKeyType[] variationKey)
  {
    this.variationKey = variationKey;
  }

  /**
   * Valid after executing the API.
   * Gets the returned AddToWatchListResponseType.returnedWatchListCount.
   * 
   * @return int
   */
  public int getReturnedWatchListCount()
  {
    return this.returnedWatchListCount;
  }

  /**
   * Valid after executing the API.
   * Gets the returned AddToWatchListResponseType.returnedWatchListMaximum.
   * 
   * @return int
   */
  public int getReturnedWatchListMaximum()
  {
    return this.returnedWatchListMaximum;
  }

}

