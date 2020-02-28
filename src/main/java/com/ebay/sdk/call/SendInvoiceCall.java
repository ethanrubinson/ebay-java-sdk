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
 * Wrapper class of the SendInvoice call of eBay SOAP API.
 * <br>
 * <p>Title: SOAP API wrapper library.</p>
 * <p>Description: Contains wrapper classes for eBay SOAP APIs.</p>
 * <p>Copyright: Copyright (c) 2009</p>
 * <p>Company: eBay Inc.</p>
 * <br> <B>Input property:</B> <code>ItemID</code> - Unique identifier for an eBay listing. Unless <b>OrderID</b> or
 * <b>OrderLineItemID</b> is provided in the request, the <b>ItemID</b> (or <b>SKU</b>) is
 * required and must be paired with the corresponding <b>TransactionID</b> to
 * identify a single line item order. For a multiple line item order, <b>OrderID</b> should be used.
 * <br> <B>Input property:</B> <code>TransactionID</code> - Unique identifier for an eBay sales transaction. This identifier is created once there is a commitment from a buyer to purchase an item. Since an auction listing can only have one sales transaction during the duration of the listing, the <b>TransactionID</b> value for auction listings is always <code>0</code>. Unless <b>OrderID</b> or <b>OrderLineItemID</b> is provided in the request, the <b>TransactionID</b> is required and must be paired with the corresponding <b>ItemID</b> to identify a single line item order. For a multiple line item order, <b>OrderID</b> should be used.
 * <br> <B>Input property:</B> <code>OrderID</code> - A unique identifier that identifies a single line item or multiple line
 * item order.
 * <br><br>
 * Unless the <b>ItemID</b> (or SKU) and corresponding <b>TransactionID</b>, or the <b>OrderLineItemID</b> is provided in the request to identify a single line item order, the <b>OrderID</b> must be specified. If <b>OrderID</b> is specified, <b>OrderLineItemID</b>, <b>ItemID</b>, <b>TransactionID</b>, and <b>SKU</b> are ignored if present in the same request.
 * <br><br>
 * <span class="tablenote"><b>Note: </b> As of June 2019, eBay has changed the format of order identifier values. The new format is a non-parsable string, globally unique across all eBay marketplaces, and consistent for both single line item and multiple line item orders. Unlike in the past, instead of just being known and exposed to the seller, these unique order identifiers will also be known and used/referenced by the buyer and eBay customer support.
 * <br><br>
 * For developers and sellers who are already integrated with the Trading API's order management calls, this change shouldn't impact your integration unless you parse the existing order identifiers (e.g., <b>OrderID</b> or <b>OrderLineItemID</b>), or otherwise infer meaning from the format (e.g., differentiating between a single line item order versus a multiple line item order). Because we realize that some integrations may have logic that is dependent upon the old identifier format, eBay is rolling out this Trading API change with version control to support a transition period of approximately 9 months before applications must switch to the new format completely.
 * <br><br>
 * During the transition period, for developers/sellers using a Trading WSDL older than Version 1113, they can use the <b>X-EBAY-API-COMPATIBILITY-LEVEL</b> HTTP header in API calls to control whether the new or old <b>OrderID</b> format is returned in call response payloads. To get the new <b>OrderID</b> format, the value of the <b>X-EBAY-API-COMPATIBILITY-LEVEL</b> HTTP header must be set to <code>1113</code>. During the transition period and even after, the new and old <b>OrderID</b> formats will still be supported/accepted in all Trading API call request payloads. After the transition period (which will be announced), only the new <b>OrderID</b> format will be returned in all Trading API call response payloads, regardless of the Trading WSDL version used or specified compatibility level.
 * </span>
 * <br>
 * <span class="tablenote"><b>Note: </b> For sellers integrated with the new order ID format, please note that the identifier for an order will change as it goes from unpaid to paid status. Sellers can check to see if an order has been paid by looking for a value of 'Complete' in the <b>CheckoutStatus.Status</b> field in the response of <b>GetOrders</b> or <b>GetOrderTransactions</b> call, or in the <b>Status.CompleteStatus</b> field in the response of <b>GetItemTransactions</b> or <b>GetSellerTransactions</b> call. When using a <b>SendInvoice</b> call, either of these order IDs (paid or unpaid status) can be used to update an order. Similarly, either of these order IDs (paid or unpaid status) can be used in <b>GetOrders</b> or <b>GetOrderTransactions</b> call to retrieve specific order(s).
 * </span>
 * <br> <B>Input property:</B> <code>InternationalShippingServiceOptions</code> - If the buyer has an International shipping address, use this container
 * to offer up to four International shipping services (or five if one of them is a Global Shipping Program service). If International
 * shipping services are offered, (domestic) <b>ShippingServiceOptions</b> should
 * not be included in the request.
 * <br>
 * <br> <B>Input property:</B> <code>ShippingServiceOptions</code> - If the buyer has a domestic shipping address, use this container
 * to offer up to four domestic shipping services. If domestic
 * shipping services are offered, <b>InternationalShippingServiceOptions</b> should
 * not be included in the request.
 * <br>
 * <br> <B>Input property:</B> <code>SalesTax</code> - This container is used if the seller wishes to apply sales tax to the order. The amount of sales tax applied to the order is dependent on the sales tax rate in the buyer's state and whether sales tax is being applied to the cost of the order only or the cost of the order plus shipping and handling.
 * <br><br>
 * <span class="tablenote"><b>Note: </b> As of January 1, 2019, buyers in some US states will automatically be charged sales tax for eBay purchases. eBay will collect and remit this sales tax to the proper taxing authority on the buyer's behalf. So, if the order's buyer is in a state that is subject to 'eBay Collect and Remit Tax', the seller should not send the buyer any sales tax information, since eBay will be handling the sales tax instead without buyer's assistance. For a list of the US states that will become subject to 'eBay Collect and Remit' (and effective dates), see the <a href="https://www.ebay.com/help/selling/fees-credits-invoices/taxes-import-charges?id=4121#section4">eBay sales tax collection</a> help topic.
 * </span>
 * <br> <B>Input property:</B> <code>InsuranceOption</code> - This field is no longer applicable as it is no longer possible for a seller to offer a buyer shipping insurance.
 * <br> <B>Input property:</B> <code>InsuranceFee</code> - This field is no longer applicable as it is no longer possible for a seller to offer a buyer shipping insurance.
 * <br> <B>Input property:</B> <code>PaymentMethods</code> - This optional field allows a US or German seller to add specific payment methods that were not in the original listing. The only valid values for this field are 'PayPal' for a US listing (or 'CreditCard' for sellers opted in to eBay Managed Payments), or 'MoneyXferAcceptedInCheckout' (CIP+) for a listing on the Germany site.
 * <br> <B>Input property:</B> <code>PayPalEmailAddress</code> - If the <b>PaymentMethods</b> field is used and set to <code>PayPal</code>, the seller provides his/her PayPal email address in this field.
 * <br> <B>Input property:</B> <code>CheckoutInstructions</code> - This field allows the seller to provide a message or instructions
 * regarding checkout/payment, or the return policy.
 * <br> <B>Input property:</B> <code>EmailCopyToSeller</code> - This field is included and set to <code>true</code> if the seller wishes to receive an email copy of the invoice sent to the buyer.
 * <br> <B>Input property:</B> <code>CODCost</code> - This dollar value indicates the money due from the buyer upon delivery of the item.
 * <br><br>
 * This field should only be specified in the <b>SendInvoice</b> request if 'COD'
 * (cash-on-delivery) was the payment method selected by the buyer and it is included
 * as the <b>PaymentMethods</b> value in the same request.
 * <br> <B>Input property:</B> <code>SKU</code> - The seller's unique identifier for an item that is being tracked by this
 * SKU. If <b>OrderID</b> or <b>OrderLineItemID</b> are not provided, both <b>SKU</b> (or
 * <b>ItemID</b>) and corresponding <b>TransactionID</b> must be provided to uniquely
 * identify a single line item order. For a multiple line item order, <b>OrderID</b> must be used.
 * <br>
 * <br>
 * This field can only be used if the <b>Item.InventoryTrackingMethod</b> field
 * (set with the <b>AddFixedPriceItem</b> or <b>RelistFixedPriceItem</b> calls) is set to
 * <code>SKU</code>.
 * <br> <B>Input property:</B> <code>OrderLineItemID</code> - A unique identifier for an eBay order line item. This identifier is created as soon as there is a commitment to buy (bidder wins the auction, buyer clicks buy button, or buyer purchases item through <b>PlaceOffer</b> call).
 * <br>
 * <br>
 * Unless the <b>ItemID</b> (or <b>SKU</b>) and corresponding <b>TransactionID</b> is used to
 * identify a single line item order, or the <b>OrderID</b> is used to identify a
 * single or multiple line item order, the
 * <b>OrderLineItemID</b> must be specified. For a multiple line item order, <b>OrderID</b> should be used. If <b>OrderLineItemID</b> is specified,
 * <b>ItemID</b>, <b>TransactionID</b>, and <b>SKU</b> are ignored if present in the same
 * request.
 * <br> <B>Input property:</B> <code>AdjustmentAmount</code> - This field allows the seller to adjust the total cost of the order to account for an extra charge or to pass down a discount to the buyer. <br><br>
 * The currency used in this field must be the same currency of the listing site. A positive value in this field indicates that the amount is an extra charge being paid to the seller by the buyer, and a negative value indicates that the amount is a discount given to the buyer by the seller.
 * 
 * @author Ron Murphy
 * @version 1.0
 */

public class SendInvoiceCall extends com.ebay.sdk.ApiCall
{
  
  private String itemID = null;
  private String transactionID = null;
  private String orderID = null;
  private InternationalShippingServiceOptionsType[] internationalShippingServiceOptions = null;
  private ShippingServiceOptionsType[] shippingServiceOptions = null;
  private SalesTaxType salesTax = null;
  private InsuranceOptionCodeType insuranceOption = null;
  private AmountType insuranceFee = null;
  private BuyerPaymentMethodCodeType[] paymentMethods = null;
  private String payPalEmailAddress = null;
  private String checkoutInstructions = null;
  private Boolean emailCopyToSeller = null;
  private AmountType cODCost = null;
  private String sKU = null;
  private String orderLineItemID = null;
  private AmountType adjustmentAmount = null;
  private SendInvoiceRequestType sendInvoiceRequest=null;


  /**
   * Constructor.
   */
  public SendInvoiceCall() {
  }

  /**
   * Constructor.
   * @param apiContext The ApiContext object to be used to make the call.
   */
  public SendInvoiceCall(ApiContext apiContext) {
    super(apiContext);
    

  }

  /**
   * Enables a seller to send an order invoice to a buyer. Where applicable, updates
   * to shipping, payment methods, and sales tax made in this request are applied to
   * the specified order as a whole and to the individual order line items whose data
   * are stored in individual <b>Transaction</b> objects.
   * 
   * <br>
   * @throws ApiException
   * @throws SdkException
   * @throws Exception
   * @return The void object.
   */
  public void sendInvoice()
      throws com.ebay.sdk.ApiException, com.ebay.sdk.SdkException, java.lang.Exception
  {
    SendInvoiceRequestType req;
    if (this.sendInvoiceRequest != null)
    {
      req = this.sendInvoiceRequest;
    } else {
      req = new SendInvoiceRequestType();
  
      if( this.sendInvoiceRequest == null )
        throw new SdkException("SendInvoiceRequest property is not set.");
  
      if (this.itemID != null)
        req.setItemID(this.itemID);
      if (this.transactionID != null)
        req.setTransactionID(this.transactionID);
      if (this.orderID != null)
        req.setOrderID(this.orderID);
      if (this.internationalShippingServiceOptions != null)
        req.setInternationalShippingServiceOptions(this.internationalShippingServiceOptions);
      if (this.shippingServiceOptions != null)
        req.setShippingServiceOptions(this.shippingServiceOptions);
      if (this.salesTax != null)
        req.setSalesTax(this.salesTax);
      if (this.insuranceOption != null)
        req.setInsuranceOption(this.insuranceOption);
      if (this.insuranceFee != null)
        req.setInsuranceFee(this.insuranceFee);
      if (this.paymentMethods != null)
        req.setPaymentMethods(this.paymentMethods);
      if (this.payPalEmailAddress != null)
        req.setPayPalEmailAddress(this.payPalEmailAddress);
      if (this.checkoutInstructions != null)
        req.setCheckoutInstructions(this.checkoutInstructions);
      if (this.emailCopyToSeller != null)
        req.setEmailCopyToSeller(this.emailCopyToSeller);
      if (this.cODCost != null)
        req.setCODCost(this.cODCost);
      if (this.sKU != null)
        req.setSKU(this.sKU);
      if (this.orderLineItemID != null)
        req.setOrderLineItemID(this.orderLineItemID);
      if (this.adjustmentAmount != null)
        req.setAdjustmentAmount(this.adjustmentAmount);
  
    }

    SendInvoiceResponseType resp = (SendInvoiceResponseType) execute(req);


  }

  /**
   * Gets the SendInvoiceRequestType.sendInvoiceRequest.
   * @return SendInvoiceRequestType
   */
  public SendInvoiceRequestType getSendInvoiceRequest()
  {
    return this.sendInvoiceRequest;
  }


  /**
   * Sets the SendInvoiceRequestType.sendInvoiceRequest.
   * @param sendInvoiceRequest SendInvoiceRequestType
   */
  public void setSendInvoiceRequest(SendInvoiceRequestType sendInvoiceRequest)
  {
    this.sendInvoiceRequest = sendInvoiceRequest;
  }

  /**
   * Gets the SendInvoiceRequestType.adjustmentAmount.
   * @return AmountType
   */
  public AmountType getAdjustmentAmount()
  {
    return this.adjustmentAmount;
  }

  /**
   * Sets the SendInvoiceRequestType.adjustmentAmount.
   * @param adjustmentAmount AmountType
   */
  public void setAdjustmentAmount(AmountType adjustmentAmount)
  {
    this.adjustmentAmount = adjustmentAmount;
  }

  /**
   * Gets the SendInvoiceRequestType.cODCost.
   * @return AmountType
   */
  public AmountType getCODCost()
  {
    return this.cODCost;
  }

  /**
   * Sets the SendInvoiceRequestType.cODCost.
   * @param cODCost AmountType
   */
  public void setCODCost(AmountType cODCost)
  {
    this.cODCost = cODCost;
  }

  /**
   * Gets the SendInvoiceRequestType.checkoutInstructions.
   * @return String
   */
  public String getCheckoutInstructions()
  {
    return this.checkoutInstructions;
  }

  /**
   * Sets the SendInvoiceRequestType.checkoutInstructions.
   * @param checkoutInstructions String
   */
  public void setCheckoutInstructions(String checkoutInstructions)
  {
    this.checkoutInstructions = checkoutInstructions;
  }

  /**
   * Gets the SendInvoiceRequestType.emailCopyToSeller.
   * @return Boolean
   */
  public Boolean getEmailCopyToSeller()
  {
    return this.emailCopyToSeller;
  }

  /**
   * Sets the SendInvoiceRequestType.emailCopyToSeller.
   * @param emailCopyToSeller Boolean
   */
  public void setEmailCopyToSeller(Boolean emailCopyToSeller)
  {
    this.emailCopyToSeller = emailCopyToSeller;
  }

  /**
   * Gets the SendInvoiceRequestType.insuranceFee.
   * @return AmountType
   */
  public AmountType getInsuranceFee()
  {
    return this.insuranceFee;
  }

  /**
   * Sets the SendInvoiceRequestType.insuranceFee.
   * @param insuranceFee AmountType
   */
  public void setInsuranceFee(AmountType insuranceFee)
  {
    this.insuranceFee = insuranceFee;
  }

  /**
   * Gets the SendInvoiceRequestType.insuranceOption.
   * @return InsuranceOptionCodeType
   */
  public InsuranceOptionCodeType getInsuranceOption()
  {
    return this.insuranceOption;
  }

  /**
   * Sets the SendInvoiceRequestType.insuranceOption.
   * @param insuranceOption InsuranceOptionCodeType
   */
  public void setInsuranceOption(InsuranceOptionCodeType insuranceOption)
  {
    this.insuranceOption = insuranceOption;
  }

  /**
   * Gets the SendInvoiceRequestType.internationalShippingServiceOptions.
   * @return InternationalShippingServiceOptionsType[]
   */
  public InternationalShippingServiceOptionsType[] getInternationalShippingServiceOptions()
  {
    return this.internationalShippingServiceOptions;
  }

  /**
   * Sets the SendInvoiceRequestType.internationalShippingServiceOptions.
   * @param internationalShippingServiceOptions InternationalShippingServiceOptionsType[]
   */
  public void setInternationalShippingServiceOptions(InternationalShippingServiceOptionsType[] internationalShippingServiceOptions)
  {
    this.internationalShippingServiceOptions = internationalShippingServiceOptions;
  }

  /**
   * Gets the SendInvoiceRequestType.itemID.
   * @return String
   */
  public String getItemID()
  {
    return this.itemID;
  }

  /**
   * Sets the SendInvoiceRequestType.itemID.
   * @param itemID String
   */
  public void setItemID(String itemID)
  {
    this.itemID = itemID;
  }

  /**
   * Gets the SendInvoiceRequestType.orderID.
   * @return String
   */
  public String getOrderID()
  {
    return this.orderID;
  }

  /**
   * Sets the SendInvoiceRequestType.orderID.
   * @param orderID String
   */
  public void setOrderID(String orderID)
  {
    this.orderID = orderID;
  }

  /**
   * Gets the SendInvoiceRequestType.orderLineItemID.
   * @return String
   */
  public String getOrderLineItemID()
  {
    return this.orderLineItemID;
  }

  /**
   * Sets the SendInvoiceRequestType.orderLineItemID.
   * @param orderLineItemID String
   */
  public void setOrderLineItemID(String orderLineItemID)
  {
    this.orderLineItemID = orderLineItemID;
  }

  /**
   * Gets the SendInvoiceRequestType.payPalEmailAddress.
   * @return String
   */
  public String getPayPalEmailAddress()
  {
    return this.payPalEmailAddress;
  }

  /**
   * Sets the SendInvoiceRequestType.payPalEmailAddress.
   * @param payPalEmailAddress String
   */
  public void setPayPalEmailAddress(String payPalEmailAddress)
  {
    this.payPalEmailAddress = payPalEmailAddress;
  }

  /**
   * Gets the SendInvoiceRequestType.paymentMethods.
   * @return BuyerPaymentMethodCodeType[]
   */
  public BuyerPaymentMethodCodeType[] getPaymentMethods()
  {
    return this.paymentMethods;
  }

  /**
   * Sets the SendInvoiceRequestType.paymentMethods.
   * @param paymentMethods BuyerPaymentMethodCodeType[]
   */
  public void setPaymentMethods(BuyerPaymentMethodCodeType[] paymentMethods)
  {
    this.paymentMethods = paymentMethods;
  }

  /**
   * Gets the SendInvoiceRequestType.sKU.
   * @return String
   */
  public String getSKU()
  {
    return this.sKU;
  }

  /**
   * Sets the SendInvoiceRequestType.sKU.
   * @param sKU String
   */
  public void setSKU(String sKU)
  {
    this.sKU = sKU;
  }

  /**
   * Gets the SendInvoiceRequestType.salesTax.
   * @return SalesTaxType
   */
  public SalesTaxType getSalesTax()
  {
    return this.salesTax;
  }

  /**
   * Sets the SendInvoiceRequestType.salesTax.
   * @param salesTax SalesTaxType
   */
  public void setSalesTax(SalesTaxType salesTax)
  {
    this.salesTax = salesTax;
  }

  /**
   * Gets the SendInvoiceRequestType.shippingServiceOptions.
   * @return ShippingServiceOptionsType[]
   */
  public ShippingServiceOptionsType[] getShippingServiceOptions()
  {
    return this.shippingServiceOptions;
  }

  /**
   * Sets the SendInvoiceRequestType.shippingServiceOptions.
   * @param shippingServiceOptions ShippingServiceOptionsType[]
   */
  public void setShippingServiceOptions(ShippingServiceOptionsType[] shippingServiceOptions)
  {
    this.shippingServiceOptions = shippingServiceOptions;
  }

  /**
   * Gets the SendInvoiceRequestType.transactionID.
   * @return String
   */
  public String getTransactionID()
  {
    return this.transactionID;
  }

  /**
   * Sets the SendInvoiceRequestType.transactionID.
   * @param transactionID String
   */
  public void setTransactionID(String transactionID)
  {
    this.transactionID = transactionID;
  }

}

