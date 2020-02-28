/*
Copyright (c) 2013 eBay, Inc.
This program is licensed under the terms of the eBay Common Development and
Distribution License (CDDL) Version 1.0 (the "License") and any subsequent  version 
thereof released by eBay.  The then-current version of the License can be found 
at http://www.opensource.org/licenses/cddl1.php and in the eBaySDKLicense file that 
is under the eBay SDK ../docs directory.
*/

package com.ebay.sdk.call;

import java.lang.String;

import com.ebay.sdk.*;
import com.ebay.soap.eBLBaseComponents.*;
/**
 * Wrapper class of the SetUserNotes call of eBay SOAP API.
 * <br>
 * <p>Title: SOAP API wrapper library.</p>
 * <p>Description: Contains wrapper classes for eBay SOAP APIs.</p>
 * <p>Copyright: Copyright (c) 2009</p>
 * <p>Company: eBay Inc.</p>
 * <br> <B>Input property:</B> <code>ItemID</code> - Unique identifier of the listing to which the My eBay note will be
 * attached. Notes can only be added to items that are
 * currently being tracked in My eBay.
 * <br> <B>Input property:</B> <code>Action</code> - The seller must include this field and set it to 'AddOrUpdate' to add a new user note or update an existing user note, or set it to 'Delete' to delete an existing user note.
 * <br> <B>Input property:</B> <code>NoteText</code> - This field is needed if the <b>Action</b> is <code>AddOrUpdate</code>. The text supplied in this field will
 * completely replace any existing My eBay note for the
 * specified item.
 * <br> <B>Input property:</B> <code>TransactionID</code> - Unique identifier for the order line item to which the My
 * eBay note will be attached. Notes can only be added to order line items
 * that are currently being tracked in My eBay. Buyers can
 * view user notes made on order line items in the
 * <b>PrivateNotes</b> field of the <b>WonList</b> container in <b>GetMyeBayBuying</b>, and
 * sellers can view user notes made on order line items in
 * the <b>PrivateNotes</b> field of the <b>SoldList</b> and <b>DeletedFromSoldList</b>
 * containers in <b>GetMyeBaySellinging</b>.
 * <br> <B>Input property:</B> <code>VariationSpecifics</code> - Container consisting of name-value pairs that identify (match) one
 * variation within a fixed-price, multiple-variation listing. The specified
 * name-value pair(s) must exist in the listing specified by either the
 * <b>ItemID</b> or <b>SKU</b> values specified in the request. If a specific order line
 * item is targeted in the request with an
 * <b>ItemID</b>/<b>TransactionID</b> pair or an <b>OrderLineItemID</b> value, any specified
 * <b>VariationSpecifics</b> container is ignored by the call.
 * <br> <B>Input property:</B> <code>SKU</code> - SKU value of the item variation to which the My eBay note will be
 * attached. Notes can only be added to items that are currently being
 * tracked in My eBay. A SKU (stock keeping unit) value is defined by and
 * used by the seller to identify a variation within a fixed-price, multiple-
 * variation listing. The SKU value is assigned to a variation of an item
 * through the <b>Variations.Variation.SKU</b> element.
 * <br>
 * <br>
 * This field can only be used if the <b>Item.InventoryTrackingMethod</b> field
 * (set with the <b>AddFixedPriceItem</b> or <b>RelistFixedPriceItem</b> calls) is set to
 * SKU.
 * <br>
 * <br>
 * If a specific order line item is targeted in the request
 * with an <b>ItemID</b>/<b>TransactionID</b> pair or an <b>OrderLineItemID</b> value, any
 * specified <b>SKU</b> is ignored by the call.
 * <br> <B>Input property:</B> <code>OrderLineItemID</code> - A unique identifier for an eBay order line item. This field is created as
 * soon as there is a commitment to buy from the seller. <b>OrderLineItemID</b> can be used in the input instead of
 * an <b>ItemID</b>/<b>TransactionID</b> pair to identify an order line item.
 * <br>
 * <br>
 * Notes can only be added to order line items that are currently being
 * tracked in My eBay. Buyers can view user notes made on order line items in
 * the <b>PrivateNotes</b> field of the <b>WonList</b> container in <b>GetMyeBayBuying</b>, and
 * sellers can view user notes made on order line items in the <b>PrivateNotes</b>
 * field of the <b>SoldList</b> and <b>DeletedFromSoldList</b> containers in
 * <b>GetMyeBaySellinging</b>.
 * 
 * @author Ron Murphy
 * @version 1.0
 */

public class SetUserNotesCall extends com.ebay.sdk.ApiCall
{
  
  private String itemID = null;
  private SetUserNotesActionCodeType action = null;
  private String noteText = null;
  private String transactionID = null;
  private NameValueListArrayType variationSpecifics = null;
  private String sKU = null;
  private String orderLineItemID = null;


  /**
   * Constructor.
   */
  public SetUserNotesCall() {
  }

  /**
   * Constructor.
   * @param apiContext The ApiContext object to be used to make the call.
   */
  public SetUserNotesCall(ApiContext apiContext) {
    super(apiContext);
    

  }

  /**
   * Enables users to add, modify, or delete a pinned note for any item that is being tracked in the My eBay All Selling and All Buying areas.
   * 
   * <br>
   * @throws ApiException
   * @throws SdkException
   * @throws Exception
   * @return The void object.
   */
  public void setUserNotes()
      throws com.ebay.sdk.ApiException, com.ebay.sdk.SdkException, java.lang.Exception
  {
    SetUserNotesRequestType req;
    req = new SetUserNotesRequestType();

    if( this.itemID == null )
      throw new SdkException("ItemID property is not set.");
    if( this.action == null )
      throw new SdkException("Action property is not set.");

    if (this.itemID != null)
      req.setItemID(this.itemID);
    if (this.action != null)
      req.setAction(this.action);
    if (this.noteText != null)
      req.setNoteText(this.noteText);
    if (this.transactionID != null)
      req.setTransactionID(this.transactionID);
    if (this.variationSpecifics != null)
      req.setVariationSpecifics(this.variationSpecifics);
    if (this.sKU != null)
      req.setSKU(this.sKU);
    if (this.orderLineItemID != null)
      req.setOrderLineItemID(this.orderLineItemID);

    SetUserNotesResponseType resp = (SetUserNotesResponseType) execute(req);


  }

  /**
   * Gets the SetUserNotesRequestType.action.
   * @return SetUserNotesActionCodeType
   */
  public SetUserNotesActionCodeType getAction()
  {
    return this.action;
  }

  /**
   * Sets the SetUserNotesRequestType.action.
   * @param action SetUserNotesActionCodeType
   */
  public void setAction(SetUserNotesActionCodeType action)
  {
    this.action = action;
  }

  /**
   * Gets the SetUserNotesRequestType.itemID.
   * @return String
   */
  public String getItemID()
  {
    return this.itemID;
  }

  /**
   * Sets the SetUserNotesRequestType.itemID.
   * @param itemID String
   */
  public void setItemID(String itemID)
  {
    this.itemID = itemID;
  }

  /**
   * Gets the SetUserNotesRequestType.noteText.
   * @return String
   */
  public String getNoteText()
  {
    return this.noteText;
  }

  /**
   * Sets the SetUserNotesRequestType.noteText.
   * @param noteText String
   */
  public void setNoteText(String noteText)
  {
    this.noteText = noteText;
  }

  /**
   * Gets the SetUserNotesRequestType.orderLineItemID.
   * @return String
   */
  public String getOrderLineItemID()
  {
    return this.orderLineItemID;
  }

  /**
   * Sets the SetUserNotesRequestType.orderLineItemID.
   * @param orderLineItemID String
   */
  public void setOrderLineItemID(String orderLineItemID)
  {
    this.orderLineItemID = orderLineItemID;
  }

  /**
   * Gets the SetUserNotesRequestType.sKU.
   * @return String
   */
  public String getSKU()
  {
    return this.sKU;
  }

  /**
   * Sets the SetUserNotesRequestType.sKU.
   * @param sKU String
   */
  public void setSKU(String sKU)
  {
    this.sKU = sKU;
  }

  /**
   * Gets the SetUserNotesRequestType.transactionID.
   * @return String
   */
  public String getTransactionID()
  {
    return this.transactionID;
  }

  /**
   * Sets the SetUserNotesRequestType.transactionID.
   * @param transactionID String
   */
  public void setTransactionID(String transactionID)
  {
    this.transactionID = transactionID;
  }

  /**
   * Gets the SetUserNotesRequestType.variationSpecifics.
   * @return NameValueListArrayType
   */
  public NameValueListArrayType getVariationSpecifics()
  {
    return this.variationSpecifics;
  }

  /**
   * Sets the SetUserNotesRequestType.variationSpecifics.
   * @param variationSpecifics NameValueListArrayType
   */
  public void setVariationSpecifics(NameValueListArrayType variationSpecifics)
  {
    this.variationSpecifics = variationSpecifics;
  }

}

