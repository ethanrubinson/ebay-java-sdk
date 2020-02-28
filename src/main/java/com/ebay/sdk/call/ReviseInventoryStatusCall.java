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
 * Wrapper class of the ReviseInventoryStatus call of eBay SOAP API.
 * <br>
 * <p>Title: SOAP API wrapper library.</p>
 * <p>Description: Contains wrapper classes for eBay SOAP APIs.</p>
 * <p>Copyright: Copyright (c) 2009</p>
 * <p>Company: eBay Inc.</p>
 * <br> <B>Input property:</B> <code>InventoryStatus</code> - One <b>InventoryStatus</b> container is required for each item or item variation that is being revised. Whether updating the price and/or quantity of a single-variation listing or a specific variation within a multiple-variation listing, the limit of items or item variations that can be modified with one call is four.
 * <br> <B>Output property:</B> <code>ReturnedInventoryStatus</code> - One <b>InventoryStatus</b> container is returned for each item or item variation that was revised. Whether updating the price and/or quantity of a single-variation listing or a specific variation within a multiple-variation listing, the limit of items or item variations that can be modified with one call is four.
 * <br>
 * <br>
 * Note that all four elements of this container are returned even if these fields would not supplied in the call request. The <b>SKU</b> field is returned as an empty tag if it is not defined for a single-variation listing.
 * <br> <B>Output property:</B> <code>ReturnedFees</code> - A <b>Fees</b> container is returned for each fixed-price listing that was modified with the <b>ReviseInventoryStatus</b> call. This container consists of the estimated listing fees for the revised listing, and the listing is identified in the <b>ItemID</b> field. Each type of fee is returned even if it is not appplicable (has a value of <code>0.0</code>. The Final Value Fee (FVF) is not in this container, as this value cannot be determined until a sale is made. Note that these fees are at the listing level, so if multiple variations within a multiple-variation listing were modified, the fees in this container would be cumulative totals, and would not single out the fees associated with each modified item variation.
 * <br>
 * <br>
 * Please note that since fees are returned at the listing level, it is possible that the response will include one <b>Fees</b> container and four <b>InventoryStatus</b> containers if you made revisions to four different item variations within the same multiple-variation listing.
 * 
 * @author Ron Murphy
 * @version 1.0
 */

public class ReviseInventoryStatusCall extends com.ebay.sdk.ApiCall
{
  
  private InventoryStatusType[] inventoryStatus = null;
  private InventoryStatusType[] returnedInventoryStatus=null;
  private InventoryFeesType[] returnedFees=null;


  /**
   * Constructor.
   */
  public ReviseInventoryStatusCall() {
  }

  /**
   * Constructor.
   * @param apiContext The ApiContext object to be used to make the call.
   */
  public ReviseInventoryStatusCall(ApiContext apiContext) {
    super(apiContext);
    

  }

  /**
   * Enables a seller to change the price and/or quantity of one to four
   * active, fixed-price listings. The fixed-price listing to modify is identified with the <b>ItemID</b> of the listing and/or the <b>SKU</b> value of the item (if a seller-defined SKU value exists for the listing). If the seller is modifying one or more variations within a multiple-variation listing, the <b>ItemID</b> and <b>SKU</b> fields in the <b>InventoryStatus</b> container become required, with the <b>ItemID</b> value identifying the listing, and the <b>SKU</b> value identifying the specific product variation within that multiple-variation listing. Each variation within a multiple-variation listing requires a seller-defined SKU value.
   * <br/><br/>
   * Whether updating the price and/or quantity of a single-variation listing or a specific variation within a multiple-variation listing, the limit of items or item variations that can be modified with one call is four.
   * 
   * <br>
   * @throws ApiException
   * @throws SdkException
   * @throws Exception
   * @return The InventoryStatusType[] object.
   */
  public InventoryStatusType[] reviseInventoryStatus()
      throws com.ebay.sdk.ApiException, com.ebay.sdk.SdkException, java.lang.Exception
  {
    ReviseInventoryStatusRequestType req;
    req = new ReviseInventoryStatusRequestType();
    if (this.inventoryStatus != null)
      req.setInventoryStatus(this.inventoryStatus);

    ReviseInventoryStatusResponseType resp = (ReviseInventoryStatusResponseType) execute(req);

    this.returnedInventoryStatus = resp.getInventoryStatus();
    this.returnedFees = resp.getFees();
    return this.getReturnedInventoryStatus();
  }

  /**
   * Gets the ReviseInventoryStatusRequestType.inventoryStatus.
   * @return InventoryStatusType[]
   */
  public InventoryStatusType[] getInventoryStatus()
  {
    return this.inventoryStatus;
  }

  /**
   * Sets the ReviseInventoryStatusRequestType.inventoryStatus.
   * @param inventoryStatus InventoryStatusType[]
   */
  public void setInventoryStatus(InventoryStatusType[] inventoryStatus)
  {
    this.inventoryStatus = inventoryStatus;
  }

  /**
   * Valid after executing the API.
   * Gets the returned ReviseInventoryStatusResponseType.returnedFees.
   * 
   * @return InventoryFeesType[]
   */
  public InventoryFeesType[] getReturnedFees()
  {
    return this.returnedFees;
  }

  /**
   * Valid after executing the API.
   * Gets the returned ReviseInventoryStatusResponseType.returnedInventoryStatus.
   * 
   * @return InventoryStatusType[]
   */
  public InventoryStatusType[] getReturnedInventoryStatus()
  {
    return this.returnedInventoryStatus;
  }

}

