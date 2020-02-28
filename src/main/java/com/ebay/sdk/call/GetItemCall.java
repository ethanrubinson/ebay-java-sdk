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
import java.lang.String;

import com.ebay.sdk.*;
import com.ebay.soap.eBLBaseComponents.*;
/**
 * Wrapper class of the GetItem call of eBay SOAP API.
 * <br>
 * <p>Title: SOAP API wrapper library.</p>
 * <p>Description: Contains wrapper classes for eBay SOAP APIs.</p>
 * <p>Copyright: Copyright (c) 2009</p>
 * <p>Company: eBay Inc.</p>
 * <br> <B>Input property:</B> <code>ItemID</code> - This field is used to identify the eBay listing by Item ID value.
 * <br><br>
 * <b>ItemID</b> is a required input in most cases. <b>SKU</b> can be used instead in certain
 * cases (see the description of SKU). If both <b>ItemID</b> and <b>SKU</b> are specified for
 * items where the inventory tracking method is <b>ItemID</b>, <b>ItemID</b> takes precedence.
 * <br> <B>Input property:</B> <code>IncludeWatchCount</code> - The seller can include this field and set its value to <code>true</code> if that seller wants to see how many prospective bidders/buyers currently have the item added to their Watch Lists. The Watch count is returned in the <b>WatchCount</b> field in the response.
 * <br>
 * <br>
 * This field will only be returnd to the seller of the item.
 * <br> <B>Input property:</B> <code>IncludeCrossPromotion</code> - This field is deprecated.
 * <br> <B>Input property:</B> <code>IncludeItemSpecifics</code> - If this field is included and set to <code>true</code>, the call response includes the <b>ItemSpecifics</b> container
 * if Item Specifics are defined for the listing.<br>
 * <br>
 * An Item Specific is any aspect that helps define/classify the item. Many eBay categories mandate including specific Item Specifics, so it is always a good idea to make a call to <b>GetCategorySpecifics</b> to see what Item Specifics are required and which ones are recommended.<br>
 * <br>
 * Including this field and setting it to <code>true</code> will also return the <strong>UnitInfo</strong> container if applicable. The <strong>UnitInfo</strong> container will provide information about the weight, volume or other quantity measurement of a listed item. The European Union requires listings for certain types of products to include the price per unit so buyers can accurately compare prices. eBay uses the <strong>UnitType</strong> and <strong>UnitQuantity</strong> values and the item's listed price to calculate and display the per-unit price on eBay EU sites.
 * <br> <B>Input property:</B> <code>IncludeTaxTable</code> - The seller will include this field and set its value to <code>true</code> if the seller wishes to view the defined sales tax rates for the various jurisdictions in the country (generally, states and provinces). Information for each defined sales tax rate will be returned in the <b>TaxTable</b> container in the response.
 * <br/><br/>
 * Even if this field is included and set to <code>true</code>, no <b>TaxTable</b> container will be returned If no sales tax rates are defined for any tax jurisdiction in the seller's sales tax table.
 * <br/><br/>
 * Sales tax tables are only available for eBay US and Canada marketplaces. Sales tax rates can be added/modified in My eBay, through the <b>SetTaxTable</b> and <b>GetTaxTable</b> calls of the Trading API, or through the Sales Tax calls of the Account API.
 * <br> <B>Input property:</B> <code>SKU</code> - Retrieves an item that was listed by the user identified
 * in AuthToken and that is being tracked by this SKU.<br>
 * <br>
 * A SKU (stock keeping unit) is an identifier defined by a seller.
 * Some sellers use SKUs to track complex flows of products
 * and information on the client side.
 * eBay preserves the SKU on the item, enabling you
 * to obtain it before and after an order line item is created.
 * (SKU is recommended as an alternative to
 * ApplicationData.)<br>
 * <br>
 * In <b>GetItem</b>, <b>SKU</b> can only be used to retrieve one of your
 * own items, where you listed the item by using <b>AddFixedPriceItem</b>
 * or <b>RelistFixedPriceItem</b>,
 * and you set <b>Item.InventoryTrackingMethod</b> to <b>SKU</b> at
 * the time the item was listed. (These criteria are necessary to
 * uniquely identify the listing by a SKU.)<br>
 * <br>
 * Either <b>ItemID</b> or <b>SKU</b> is required in the request.
 * If both are passed, they must refer to the same item,
 * and that item must have <b>InventoryTrackingMethod</b> set to <b>SKU</b>.
 * <br> <B>Input property:</B> <code>VariationSKU</code> - Variation-level SKU that uniquely identifes a Variation within
 * the listing identified by <b>ItemID</b>. Only applicable when the
 * seller listed the item with Variation-level SKU (<b>Variation.SKU</b>)
 * values. Retrieves all the usual <b>Item</b> fields, but limits the
 * <b>Variations</b> content to the specified Variation.
 * If not specified, the response includes all Variations.
 * <br> <B>Input property:</B> <code>VariationSpecifics</code> - Name-value pairs that identify one or more Variations within the
 * listing identified by <b>ItemID</b>. Only applicable when the seller
 * listed the item with Variations. Retrieves all the usual <b>Item</b>
 * fields, but limits the Variations content to the specified
 * Variation(s). If the specified pairs do not match any Variation,
 * eBay returns all Variations.<br>
 * <br>
 * To retrieve only one variation, specify the full set of
 * name/value pairs that match all the name-value pairs of one
 * Variation. <br>
 * <br>
 * To retrieve multiple variations (using a wildcard),
 * specify one or more name/value pairs that partially match the
 * desired variations. For example, if the listing contains
 * Variations for shirts in different colors and sizes, specify
 * Color as Red (and no other name/value pairs) to retrieve
 * all the red shirts in all sizes (but no other colors).
 * <br> <B>Input property:</B> <code>TransactionID</code> - A unique identifier for an order line item. An order line item is created
 * when a buyer commits to purchasing an item.
 * <br><br>
 * Since you can change active multiple-quantity fixed-price listings even
 * after one of the items has been purchased, the <b>TransactionID</b> is
 * associated with a snapshot of the item data at the time of the purchase.
 * <br><br>
 * After one item in a multi-quantity listing has been sold, sellers can not
 * change the values in the Title, Primary Category, Secondary Category,
 * Listing Duration, and Listing Type fields. However, all other fields are
 * editable.
 * <br><br>
 * Specifying a <b>TransactionID</b> in the <b>GetItem</b> request allows you to retrieve
 * a snapshot of the listing as it was when the order line item was created.
 * <br> <B>Input property:</B> <code>IncludeItemCompatibilityList</code> - This field is used to specify whether or not to retrieve Parts
 * Compatiblity information for a motor part or accessory listing. If this field is included and set to <code>true</code>, the <b>Item.ItemCompatibilityList</b> container will be returned if a Parts Compatibility list exists for the listing. A Parts Compatibility list is a list of motor vehicles that are compatible with the listed motor part or accesory item. If a Parts Compatibility list does not exist for the listing, this field will have no effect if it is included, regardless of its value (<code>true</code> or <code>false</code>).
 * <br><br>
 * If this field is included and set to <code>false</code> or omitted, but a Parts Compatibility list does exist for the listing, the  <b>Item.ItemCompatibilityList</b> container will not be returned, but the <b>Item.ItemCompatibilityCount</b> field will be returned, and this field will simply indicate the quantity of motor vehicles that are compatible with the the listed motor part or accesory item.
 * <br><br>
 * Parts Compatibility lists are only applicable to motor parts and accessory categories on the sites that support eBay Motors - US, CA, UK, and DE.
 * <br> <B>Output property:</B> <code>ReturnedItem</code> - This container consists of detailed information about the retrieved listing. The amount of information that is returned is partially controlled by the filters that are set in the call request.
 * 
 * @author Ron Murphy
 * @version 1.0
 */

public class GetItemCall extends com.ebay.sdk.ApiCall
{
  
  private String itemID = null;
  private Boolean includeWatchCount = null;
  private Boolean includeCrossPromotion = null;
  private Boolean includeItemSpecifics = null;
  private Boolean includeTaxTable = null;
  private String sKU = null;
  private String variationSKU = null;
  private NameValueListArrayType variationSpecifics = null;
  private String transactionID = null;
  private Boolean includeItemCompatibilityList = null;
  private ItemType returnedItem=null;


  /**
   * Constructor.
   */
  public GetItemCall() {
  }

  /**
   * Constructor.
   * @param apiContext The ApiContext object to be used to make the call.
   */
  public GetItemCall(ApiContext apiContext) {
    super(apiContext);
    

  }

  /**
   * Returns item data (title, description, price information, seller information, and so on)
   * for the specified item ID.
   * 
   * <br>
   * @throws ApiException
   * @throws SdkException
   * @throws Exception
   * @return The ItemType object.
   */
  public ItemType getItem()
      throws com.ebay.sdk.ApiException, com.ebay.sdk.SdkException, java.lang.Exception
  {
    GetItemRequestType req;
    req = new GetItemRequestType();
    req.setDetailLevel(this.getDetailLevel());
    if (this.itemID != null)
      req.setItemID(this.itemID);
    if (this.includeWatchCount != null)
      req.setIncludeWatchCount(this.includeWatchCount);
    if (this.includeCrossPromotion != null)
      req.setIncludeCrossPromotion(this.includeCrossPromotion);
    if (this.includeItemSpecifics != null)
      req.setIncludeItemSpecifics(this.includeItemSpecifics);
    if (this.includeTaxTable != null)
      req.setIncludeTaxTable(this.includeTaxTable);
    if (this.sKU != null)
      req.setSKU(this.sKU);
    if (this.variationSKU != null)
      req.setVariationSKU(this.variationSKU);
    if (this.variationSpecifics != null)
      req.setVariationSpecifics(this.variationSpecifics);
    if (this.transactionID != null)
      req.setTransactionID(this.transactionID);
    if (this.includeItemCompatibilityList != null)
      req.setIncludeItemCompatibilityList(this.includeItemCompatibilityList);

    GetItemResponseType resp = (GetItemResponseType) execute(req);

    this.returnedItem = resp.getItem();
    
    return this.getReturnedItem();
  }

  /**
   * Gets the GetItemRequestType.includeCrossPromotion.
   * @return Boolean
   */
  public Boolean getIncludeCrossPromotion()
  {
    return this.includeCrossPromotion;
  }

  /**
   * Sets the GetItemRequestType.includeCrossPromotion.
   * @param includeCrossPromotion Boolean
   */
  public void setIncludeCrossPromotion(Boolean includeCrossPromotion)
  {
    this.includeCrossPromotion = includeCrossPromotion;
  }

  /**
   * Gets the GetItemRequestType.includeItemCompatibilityList.
   * @return Boolean
   */
  public Boolean getIncludeItemCompatibilityList()
  {
    return this.includeItemCompatibilityList;
  }

  /**
   * Sets the GetItemRequestType.includeItemCompatibilityList.
   * @param includeItemCompatibilityList Boolean
   */
  public void setIncludeItemCompatibilityList(Boolean includeItemCompatibilityList)
  {
    this.includeItemCompatibilityList = includeItemCompatibilityList;
  }

  /**
   * Gets the GetItemRequestType.includeItemSpecifics.
   * @return Boolean
   */
  public Boolean getIncludeItemSpecifics()
  {
    return this.includeItemSpecifics;
  }

  /**
   * Sets the GetItemRequestType.includeItemSpecifics.
   * @param includeItemSpecifics Boolean
   */
  public void setIncludeItemSpecifics(Boolean includeItemSpecifics)
  {
    this.includeItemSpecifics = includeItemSpecifics;
  }

  /**
   * Gets the GetItemRequestType.includeTaxTable.
   * @return Boolean
   */
  public Boolean getIncludeTaxTable()
  {
    return this.includeTaxTable;
  }

  /**
   * Sets the GetItemRequestType.includeTaxTable.
   * @param includeTaxTable Boolean
   */
  public void setIncludeTaxTable(Boolean includeTaxTable)
  {
    this.includeTaxTable = includeTaxTable;
  }

  /**
   * Gets the GetItemRequestType.includeWatchCount.
   * @return Boolean
   */
  public Boolean getIncludeWatchCount()
  {
    return this.includeWatchCount;
  }

  /**
   * Sets the GetItemRequestType.includeWatchCount.
   * @param includeWatchCount Boolean
   */
  public void setIncludeWatchCount(Boolean includeWatchCount)
  {
    this.includeWatchCount = includeWatchCount;
  }

  /**
   * Gets the GetItemRequestType.itemID.
   * @return String
   */
  public String getItemID()
  {
    return this.itemID;
  }

  /**
   * Sets the GetItemRequestType.itemID.
   * @param itemID String
   */
  public void setItemID(String itemID)
  {
    this.itemID = itemID;
  }

  /**
   * Gets the GetItemRequestType.sKU.
   * @return String
   */
  public String getSKU()
  {
    return this.sKU;
  }

  /**
   * Sets the GetItemRequestType.sKU.
   * @param sKU String
   */
  public void setSKU(String sKU)
  {
    this.sKU = sKU;
  }

  /**
   * Gets the GetItemRequestType.transactionID.
   * @return String
   */
  public String getTransactionID()
  {
    return this.transactionID;
  }

  /**
   * Sets the GetItemRequestType.transactionID.
   * @param transactionID String
   */
  public void setTransactionID(String transactionID)
  {
    this.transactionID = transactionID;
  }

  /**
   * Gets the GetItemRequestType.variationSKU.
   * @return String
   */
  public String getVariationSKU()
  {
    return this.variationSKU;
  }

  /**
   * Sets the GetItemRequestType.variationSKU.
   * @param variationSKU String
   */
  public void setVariationSKU(String variationSKU)
  {
    this.variationSKU = variationSKU;
  }

  /**
   * Gets the GetItemRequestType.variationSpecifics.
   * @return NameValueListArrayType
   */
  public NameValueListArrayType getVariationSpecifics()
  {
    return this.variationSpecifics;
  }

  /**
   * Sets the GetItemRequestType.variationSpecifics.
   * @param variationSpecifics NameValueListArrayType
   */
  public void setVariationSpecifics(NameValueListArrayType variationSpecifics)
  {
    this.variationSpecifics = variationSpecifics;
  }
/**
   * Executing the API call.
   * @param itemID eBay itemID that uniquely identifies the item.
   * @throws ApiException
   * @return The ItemType object if the call succeeded.
   */
  public ItemType getItem(String itemID)
      throws com.ebay.sdk.ApiException, com.ebay.sdk.SdkException, java.lang.Exception
  {

    GetItemRequestType req = new GetItemRequestType();
    req.setItemID(itemID);
    req.setDetailLevel(this.getDetailLevel());
    if (this.includeWatchCount != null)
      req.setIncludeWatchCount(this.includeWatchCount);
    if (this.includeCrossPromotion != null)
      req.setIncludeCrossPromotion(this.includeCrossPromotion);
    if (this.includeItemSpecifics != null)
      req.setIncludeItemSpecifics(this.includeItemSpecifics);
    if (this.includeTaxTable != null)
      req.setIncludeTaxTable(this.includeTaxTable);
    if (this.sKU != null)
      req.setSKU(this.sKU);
    if (this.variationSKU != null)
      req.setVariationSKU(this.variationSKU);
    if (this.variationSpecifics != null)
      req.setVariationSpecifics(this.variationSpecifics);
    if (this.transactionID != null)
      req.setTransactionID(this.transactionID);
    if (this.includeItemCompatibilityList != null)
      req.setIncludeItemCompatibilityList(this.includeItemCompatibilityList);

    GetItemResponseType resp = (GetItemResponseType) execute(req);

    this.returnedItem = resp.getItem();
    
    return this.getReturnedItem();
  }

  /**
   * Valid after executing the API.
   * Gets the returned GetItemResponseType.returnedItem.
   * 
   * @return ItemType
   */
  public ItemType getReturnedItem()
  {
    return this.returnedItem;
  }

}

