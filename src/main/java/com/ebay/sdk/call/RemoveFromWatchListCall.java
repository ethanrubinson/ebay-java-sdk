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
import java.lang.Integer;

import com.ebay.sdk.*;
import com.ebay.soap.eBLBaseComponents.*;
/**
 * Wrapper class of the RemoveFromWatchList call of eBay SOAP API.
 * <br>
 * <p>Title: SOAP API wrapper library.</p>
 * <p>Description: Contains wrapper classes for eBay SOAP APIs.</p>
 * <p>Copyright: Copyright (c) 2009</p>
 * <p>Company: eBay Inc.</p>
 * <br> <B>Input property:</B> <code>ItemIDs</code> - The unique identifier of the item to be removed from the
 * user's Watch List. Multiple <b>ItemID</b> fields can be specified in the same request, but note that the <b>RemoveAllItems</b> field or <b>VariationKey</b> container cannot be specified if one or more <b>ItemID</b> fields are used.
 * <br/><br/>
 * <br> <B>Input property:</B> <code>RemoveAllItems</code> - If this field is included and set to <code>true</code>, then all the items in the user's
 * Watch List are removed. Note that if the <b>RemoveAllItems</b> field is specified, one or more <b>ItemID</b> fields or the <b>VariationKey</b> cannot be used.
 * <br> <B>Input property:</B> <code>VariationKey</code> - This container is used if the user want to remove one or more product variations (within a multiple-variation listing) from the Watch List. Note that if the <b>VariationKey</b> container is used, one or more <b>ItemID</b> fields or the <b>RemoveAllItems</b> field cannot be used.
 * <br> <B>Output property:</B> <code>ReturnedWatchListCount</code> - The current number of items in the user's Watch List (considering that the items specified in the call request were successfully removed).
 * <br> <B>Output property:</B> <code>ReturnedWatchListMaximum</code> - The maximum number of items allowed in the user's Watch List. Currently this value is 300, and is the same for all sites and all users.
 * 
 * @author Ron Murphy
 * @version 1.0
 */

public class RemoveFromWatchListCall extends com.ebay.sdk.ApiCall
{
  
  private String[] itemIDs = null;
  private Boolean removeAllItems = null;
  private VariationKeyType[] variationKey = null;
  private int returnedWatchListCount=0;
  private int returnedWatchListMaximum=0;


  /**
   * Constructor.
   */
  public RemoveFromWatchListCall() {
  }

  /**
   * Constructor.
   * @param apiContext The ApiContext object to be used to make the call.
   */
  public RemoveFromWatchListCall(ApiContext apiContext) {
    super(apiContext);
    

  }

  /**
   * The call enables a user to remove one or more items from their Watch List. A user can view the items that they are currently watching by calling <b>GetMyeBayBuying</b>.
   * <br/><br/>
   * The user has the option of removing one or more single-variation listings, one or more product variations within a multiple-variation listing, or removing all items from the Watch List.
   * 
   * <br>
   * @throws ApiException
   * @throws SdkException
   * @throws Exception
   * @return The void object.
   */
  public void removeFromWatchList()
      throws com.ebay.sdk.ApiException, com.ebay.sdk.SdkException, java.lang.Exception
  {
    RemoveFromWatchListRequestType req;
    req = new RemoveFromWatchListRequestType();
    if (this.itemIDs != null)
      req.setItemID(this.itemIDs);
    if (this.removeAllItems != null)
      req.setRemoveAllItems(this.removeAllItems);
    if (this.variationKey != null)
      req.setVariationKey(this.variationKey);

    RemoveFromWatchListResponseType resp = (RemoveFromWatchListResponseType) execute(req);

    this.returnedWatchListCount = (resp.getWatchListCount() == null? 0: resp.getWatchListCount().intValue());
    this.returnedWatchListMaximum = (resp.getWatchListMaximum() == null? 0: resp.getWatchListMaximum().intValue());

  }

  /**
   * Gets the RemoveFromWatchListRequestType.itemIDs.
   * @return String[]
   */
  public String[] getItemIDs()
  {
    return this.itemIDs;
  }

  /**
   * Sets the RemoveFromWatchListRequestType.itemIDs.
   * @param itemIDs String[]
   */
  public void setItemIDs(String[] itemIDs)
  {
    this.itemIDs = itemIDs;
  }

  /**
   * Gets the RemoveFromWatchListRequestType.removeAllItems.
   * @return Boolean
   */
  public Boolean getRemoveAllItems()
  {
    return this.removeAllItems;
  }

  /**
   * Sets the RemoveFromWatchListRequestType.removeAllItems.
   * @param removeAllItems Boolean
   */
  public void setRemoveAllItems(Boolean removeAllItems)
  {
    this.removeAllItems = removeAllItems;
  }

  /**
   * Gets the RemoveFromWatchListRequestType.variationKey.
   * @return VariationKeyType[]
   */
  public VariationKeyType[] getVariationKey()
  {
    return this.variationKey;
  }

  /**
   * Sets the RemoveFromWatchListRequestType.variationKey.
   * @param variationKey VariationKeyType[]
   */
  public void setVariationKey(VariationKeyType[] variationKey)
  {
    this.variationKey = variationKey;
  }

  /**
   * Valid after executing the API.
   * Gets the returned RemoveFromWatchListResponseType.returnedWatchListCount.
   * 
   * @return int
   */
  public int getReturnedWatchListCount()
  {
    return this.returnedWatchListCount;
  }

  /**
   * Valid after executing the API.
   * Gets the returned RemoveFromWatchListResponseType.returnedWatchListMaximum.
   * 
   * @return int
   */
  public int getReturnedWatchListMaximum()
  {
    return this.returnedWatchListMaximum;
  }

}

