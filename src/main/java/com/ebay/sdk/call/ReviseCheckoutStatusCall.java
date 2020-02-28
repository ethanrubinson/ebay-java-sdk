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
 * Wrapper class of the ReviseCheckoutStatus call of eBay SOAP API.
 * <br>
 * <p>Title: SOAP API wrapper library.</p>
 * <p>Description: Contains wrapper classes for eBay SOAP APIs.</p>
 * <p>Copyright: Copyright (c) 2009</p>
 * <p>Company: eBay Inc.</p>
 * <br> <B>Input property:</B> <code>ItemID</code> - Unique identifier for an eBay listing. A listing can have multiple order line items, but only one <b>ItemID</b> value. An <b>ItemID</b> value can be paired up with a corresponding <b>TransactionID</b> value to identify and order line item in a <b>ReviseCheckoutStatus</b> call.
 * <br><br>
 * Unless an <b>OrderLineItemID</b> value is used to identify a an order line item, or an <b>OrderID</b> value is used to identify an order, the <b>ItemID</b>/<b>TransactionID</b> pair must be specified.
 * <br><br>
 * If an <b>OrderID</b> or an <b>OrderLineItemID</b> value is specified, the <b>ItemID</b>/<b>TransactionID</b> pair is ignored if present in the same request.
 * <br/>
 * <br/>
 * It is also possible to identify an order line item with a
 * <b>ItemID</b>/<b>BuyerID</b> combination, but this is not the most ideal approach since an error is returned if there are multiple order line items for that combination.
 * <br/>
 * <br> <B>Input property:</B> <code>TransactionID</code> - Unique identifier for a sales transaction. This identifier is created as soon as there is a commitment to buy (bidder wins the auction, buyer clicks buy button, or buyer purchases item through <b>PlaceOffer</b> call). Since an auction listing can only have one sale/winning bidder during the duration of the listing, the <b>TransactionID</b> value for auction listings is always <code>0</code>. An  <b>ItemID</b>/<b>TransactionID</b> pair can be  used to identify an order line item in a <b>ReviseCheckoutStatus</b> call.
 * <br><br>
 * Unless an <b>OrderLineItemID</b> is used to identify an order line item,
 * or an <b>OrderID</b> value is used to identify an order, the <b>ItemID</b>/<b>TransactionID</b> pair must be
 * specified. For a multiple line item order, <b>OrderID</b>
 * should be used. If <b>OrderID</b> or <b>OrderLineItemID</b> are specified, the
 * <b>ItemID</b>/<b>TransactionID</b> pair is ignored if present in the same request.
 * <br>
 * <br> <B>Input property:</B> <code>OrderId</code> - A unique identifier that identifies a single line item or multiple line item order.
 * <br><br>
 * If an <b>OrderID</b> is used in the request, the <b>OrderLineItemID</b> and
 * <b>ItemID</b>/<b>TransactionID</b> pair are ignored if they are specified in the same request.
 * <br><br>
 * <span class="tablenote"><b>Note: </b> As of June 2019, eBay has changed the format of order identifier values. The new format is a non-parsable string, globally unique across all eBay marketplaces, and consistent for both single line item and multiple line item orders. Unlike in the past, instead of just being known and exposed to the seller, these unique order identifiers will also be known and used/referenced by the buyer and eBay customer support.
 * <br><br>
 * For developers and sellers who are already integrated with the Trading API's order management calls, this change shouldn't impact your integration unless you parse the existing order identifiers (e.g., <b>OrderID</b> or <b>OrderLineItemID</b>), or otherwise infer meaning from the format (e.g., differentiating between a single line item order versus a multiple line item order). Because we realize that some integrations may have logic that is dependent upon the old identifier format, eBay is rolling out this Trading API change with version control to support a transition period of approximately 9 months before applications must switch to the new format completely.
 * <br><br>
 * During the transition period, for developers/sellers using a Trading WSDL older than Version 1113, they can use the <b>X-EBAY-API-COMPATIBILITY-LEVEL</b> HTTP header in API calls to control whether the new or old <b>OrderID</b> format is returned in call response payloads. To get the new <b>OrderID</b> format, the value of the <b>X-EBAY-API-COMPATIBILITY-LEVEL</b> HTTP header must be set to <code>1113</code>. During the transition period and even after, the new and old <b>OrderID</b> formats will still be supported/accepted in all Trading API call request payloads. After the transition period (which will be announced), only the new <b>OrderID</b> format will be returned in all Trading API call response payloads, regardless of the Trading WSDL version used or specified compatibility level.
 * </span>
 * <br>
 * <span class="tablenote"><b>Note: </b> For sellers integrated with the new order ID format, please note that the identifier for an order will change as it goes from unpaid to paid status. Sellers can check to see if an order has been paid by looking for a value of 'Complete' in the <b>CheckoutStatus.Status</b> field in the response of <b>GetOrders</b> or <b>GetOrderTransactions</b> call, or in the <b>Status.CompleteStatus</b> field in the response of <b>GetItemTransactions</b> or <b>GetSellerTransactions</b> call. Sellers should  not fulfill orders until buyer has made payment. When using a <b>ReviseCheckoutStatus</b> call, either of these order IDs (paid or unpaid status) can be used to update an order. Similarly, either of these order IDs (paid or unpaid status) can be used in <b>GetOrders</b> or <b>GetOrderTransactions</b> call to retrieve specific order(s).
 * </span>
 * <br> <B>Input property:</B> <code>AmountPaid</code> - The total amount paid by the buyer. For a motor vehicle listing that requires a deposit, the <b>AmountPaid</b> value is the total amount paid by the buyer for the deposit. <b>AmountPaid</b> is optional if <b>CheckoutStatus</b> is <code>Incomplete</code> and required if it is <code>Complete</code>.
 * <br> <B>Input property:</B> <code>PaymentMethodUsed</code> - Payment method used by the buyer. This field may be needed if the order payment between the buyer and seller happens off of eBay's platform. If the payment happens on eBay's platform, this field will not be necessary.
 * <br><br>
 * See eBay's
 * <a href="https://www.ebay.com/help/policies/payment-policies/accepted-payments-policy?id=4269" target="_blank">Accepted Payments Policy</a> for more information about safe offline payment methods. Accepted payment methods will vary by category and by country.
 * <br> <B>Input property:</B> <code>CheckoutStatus</code> - This field is included and its value is set to <code>Complete</code> if the seller is using the <b>ReviseCheckoutStatus</b> call to mark the order as 'Paid' by including the <b>PaymentStatus</b> field and setting its value to <code>Paid</code>.
 * <br> <B>Input property:</B> <code>ShippingService</code> - The shipping service selected by the buyer from among the shipping services offered by the seller (such as UPS Ground). For a list of valid values, call <b>GeteBayDetails</b> with the <b>DetailName</b> field set to <code>ShippingServiceDetails</code>. The <b>ShippingServiceDetails.ValidForSellingFlow</b> flag must also be present in the response. Otherwise, that particular shipping service option is no longer valid and cannot be offered to buyers through a listing.
 * <br/><br/>
 * <span class="tablenote"> <strong>Note:</strong> This field should not be used for orders being shipping through the  Global Shipping program; specifying <code>InternationalPriorityShipping</code> as a value for this field will produce an error. </span>
 * <br> <B>Input property:</B> <code>ShippingIncludedInTax</code> - This field is included and set to <code>true</code> if sales tax for the order is applied against shipping costs (in addition to the item cost).
 * <br> <B>Input property:</B> <code>CheckoutMethod</code> - This field is deprecated.
 * <br> <B>Input property:</B> <code>InsuranceType</code> - This field is no longer applicable as it is not longer possible for a seller to offer a buyer shipping insurance.
 * <br> <B>Input property:</B> <code>PaymentStatus</code> - This field is used to mark the order as paid or awaiting payment in eBay's system. This field may be needed if the order payment between the buyer and seller happens off of eBay's platform. If the payment happens on eBay's platform, this field will not be necessary. A user specifies <code>Pending</code> to indicate that the order is awaiting payment or if the the buyer has initiated payment, but the funds have not yet been sent to the seller's financial institution.
 * <br> <B>Input property:</B> <code>AdjustmentAmount</code> - This field may be used if the buyer and seller have agreed on making an adjustment to the order total. A positive value indicates that the amount is an extra charge being paid to the seller by the buyer. A negative value indicates that the amount is a discount given to the buyer by the seller.
 * <br> <B>Input property:</B> <code>ShippingAddress</code> - For internal use only. Do not use.
 * <br> <B>Input property:</B> <code>BuyerID</code> - The eBay user ID for the order's buyer. A single line item order can actually be identified by a <b>BuyerID</b>/<b>ItemID</b> pair, but this approach is not recommended since an error may occur if there are multiple order line items between the buyer and seller. <b>BuyerID</b> is ignored if any other valid filter or filter combination is used in the same request.
 * <br> <B>Input property:</B> <code>ShippingInsuranceCost</code> - This field is no longer applicable as it is not longer possible for a seller to offer a buyer shipping insurance.
 * <br> <B>Input property:</B> <code>SalesTax</code> - This field is used if sales tax is being applied to the order. If the  sales tax amount is also being applied to the shipping charges (in addition to the item cost), the <b>ShippingIncludedInTax</b> boolean field should be included in the call request and set to <code>true</code>.
 * <br> <B>Input property:</B> <code>ShippingCost</code> - This field is used to show the cost of shipping being applied to the order.
 * <br> <B>Input property:</B> <code>EncryptedID</code> - Not supported.
 * <br> <B>Input property:</B> <code>ExternalTransaction</code> - This container is used if payment for the order occurred off of eBay, and the seller wants to pass in the external payment reference ID.
 * <br> <B>Input property:</B> <code>MultipleSellerPaymentID</code> - Not supported.
 * <br> <B>Input property:</B> <code>CODCost</code> - This dollar value indicates the money due from the buyer upon delivery of the item.
 * <br><br>
 * This field should only be specified in the <b>ReviseCheckoutStatus</b> request if 'COD' (cash-on-delivery) was the payment method selected by the buyer and it is included as the <b>PaymentMethodUsed</b> value in the same request.
 * <br> <B>Input property:</B> <code>OrderLineItemID</code> - A unique identifier for an eBay order line item. This identifier is created once there is a commitment to buy (bidder wins the auction, buyer clicks buy button, or buyer purchases item through <b>PlaceOffer</b> call).
 * <br><br>
 * Unless an <b>ItemID</b>/<b>TransactionID</b> pair is used to identify an order line item, or the <b>OrderID</b> is used to identify an order, the <b>OrderLineItemID</b> must be specified. For a multiple line item order, <b>OrderID</b> should be used. If <b>OrderLineItemID</b> is specified, the <b>ItemID</b>/<b>TransactionID</b> pair are ignored if present in the same request.
 * 
 * @author Ron Murphy
 * @version 1.0
 */

public class ReviseCheckoutStatusCall extends com.ebay.sdk.ApiCall
{
  
  private String itemID = null;
  private String transactionID = null;
  private String orderId = null;
  private AmountType amountPaid = null;
  private BuyerPaymentMethodCodeType paymentMethodUsed = null;
  private CompleteStatusCodeType checkoutStatus = null;
  private String shippingService = null;
  private Boolean shippingIncludedInTax = null;
  private CheckoutMethodCodeType checkoutMethod = null;
  private InsuranceSelectedCodeType insuranceType = null;
  private RCSPaymentStatusCodeType paymentStatus = null;
  private AmountType adjustmentAmount = null;
  private AddressType shippingAddress = null;
  private String buyerID = null;
  private AmountType shippingInsuranceCost = null;
  private AmountType salesTax = null;
  private AmountType shippingCost = null;
  private String encryptedID = null;
  private ExternalTransactionType externalTransaction = null;
  private String multipleSellerPaymentID = null;
  private AmountType cODCost = null;
  private String orderLineItemID = null;


  /**
   * Constructor.
   */
  public ReviseCheckoutStatusCall() {
  }

  /**
   * Constructor.
   * @param apiContext The ApiContext object to be used to make the call.
   */
  public ReviseCheckoutStatusCall(ApiContext apiContext) {
    super(apiContext);
    

  }

  /**
   * Enables a seller to update the payment details, the shipping details,
   * and the status of an order.
   * 
   * <br>
   * @throws ApiException
   * @throws SdkException
   * @throws Exception
   * @return The ReviseCheckoutStatusResponseType object.
   */
  public ReviseCheckoutStatusResponseType reviseCheckoutStatus()
      throws com.ebay.sdk.ApiException, com.ebay.sdk.SdkException, java.lang.Exception
  {
    ReviseCheckoutStatusRequestType req;
    req = new ReviseCheckoutStatusRequestType();
    if (this.itemID != null)
      req.setItemID(this.itemID);
    if (this.transactionID != null)
      req.setTransactionID(this.transactionID);
    if (this.orderId != null)
      req.setOrderID(this.orderId);
    if (this.amountPaid != null)
      req.setAmountPaid(this.amountPaid);
    if (this.paymentMethodUsed != null)
      req.setPaymentMethodUsed(this.paymentMethodUsed);
    if (this.checkoutStatus != null)
      req.setCheckoutStatus(this.checkoutStatus);
    if (this.shippingService != null)
      req.setShippingService(this.shippingService);
    if (this.shippingIncludedInTax != null)
      req.setShippingIncludedInTax(this.shippingIncludedInTax);
    if (this.checkoutMethod != null)
      req.setCheckoutMethod(this.checkoutMethod);
    if (this.insuranceType != null)
      req.setInsuranceType(this.insuranceType);
    if (this.paymentStatus != null)
      req.setPaymentStatus(this.paymentStatus);
    if (this.adjustmentAmount != null)
      req.setAdjustmentAmount(this.adjustmentAmount);
    if (this.shippingAddress != null)
      req.setShippingAddress(this.shippingAddress);
    if (this.buyerID != null)
      req.setBuyerID(this.buyerID);
    if (this.shippingInsuranceCost != null)
      req.setShippingInsuranceCost(this.shippingInsuranceCost);
    if (this.salesTax != null)
      req.setSalesTax(this.salesTax);
    if (this.shippingCost != null)
      req.setShippingCost(this.shippingCost);
    if (this.encryptedID != null)
      req.setEncryptedID(this.encryptedID);
    if (this.externalTransaction != null)
      req.setExternalTransaction(this.externalTransaction);
    if (this.multipleSellerPaymentID != null)
      req.setMultipleSellerPaymentID(this.multipleSellerPaymentID);
    if (this.cODCost != null)
      req.setCODCost(this.cODCost);
    if (this.orderLineItemID != null)
      req.setOrderLineItemID(this.orderLineItemID);

    ReviseCheckoutStatusResponseType resp = (ReviseCheckoutStatusResponseType) execute(req);

    return resp;
  }

  /**
   * Gets the ReviseCheckoutStatusRequestType.adjustmentAmount.
   * @return AmountType
   */
  public AmountType getAdjustmentAmount()
  {
    return this.adjustmentAmount;
  }

  /**
   * Sets the ReviseCheckoutStatusRequestType.adjustmentAmount.
   * @param adjustmentAmount AmountType
   */
  public void setAdjustmentAmount(AmountType adjustmentAmount)
  {
    this.adjustmentAmount = adjustmentAmount;
  }

  /**
   * Gets the ReviseCheckoutStatusRequestType.amountPaid.
   * @return AmountType
   */
  public AmountType getAmountPaid()
  {
    return this.amountPaid;
  }

  /**
   * Sets the ReviseCheckoutStatusRequestType.amountPaid.
   * @param amountPaid AmountType
   */
  public void setAmountPaid(AmountType amountPaid)
  {
    this.amountPaid = amountPaid;
  }

  /**
   * Gets the ReviseCheckoutStatusRequestType.buyerID.
   * @return String
   */
  public String getBuyerID()
  {
    return this.buyerID;
  }

  /**
   * Sets the ReviseCheckoutStatusRequestType.buyerID.
   * @param buyerID String
   */
  public void setBuyerID(String buyerID)
  {
    this.buyerID = buyerID;
  }

  /**
   * Gets the ReviseCheckoutStatusRequestType.cODCost.
   * @return AmountType
   */
  public AmountType getCODCost()
  {
    return this.cODCost;
  }

  /**
   * Sets the ReviseCheckoutStatusRequestType.cODCost.
   * @param cODCost AmountType
   */
  public void setCODCost(AmountType cODCost)
  {
    this.cODCost = cODCost;
  }

  /**
   * Gets the ReviseCheckoutStatusRequestType.checkoutMethod.
   * @return CheckoutMethodCodeType
   */
  public CheckoutMethodCodeType getCheckoutMethod()
  {
    return this.checkoutMethod;
  }

  /**
   * Sets the ReviseCheckoutStatusRequestType.checkoutMethod.
   * @param checkoutMethod CheckoutMethodCodeType
   */
  public void setCheckoutMethod(CheckoutMethodCodeType checkoutMethod)
  {
    this.checkoutMethod = checkoutMethod;
  }

  /**
   * Gets the ReviseCheckoutStatusRequestType.checkoutStatus.
   * @return CompleteStatusCodeType
   */
  public CompleteStatusCodeType getCheckoutStatus()
  {
    return this.checkoutStatus;
  }

  /**
   * Sets the ReviseCheckoutStatusRequestType.checkoutStatus.
   * @param checkoutStatus CompleteStatusCodeType
   */
  public void setCheckoutStatus(CompleteStatusCodeType checkoutStatus)
  {
    this.checkoutStatus = checkoutStatus;
  }

  /**
   * Gets the ReviseCheckoutStatusRequestType.encryptedID.
   * @return String
   */
  public String getEncryptedID()
  {
    return this.encryptedID;
  }

  /**
   * Sets the ReviseCheckoutStatusRequestType.encryptedID.
   * @param encryptedID String
   */
  public void setEncryptedID(String encryptedID)
  {
    this.encryptedID = encryptedID;
  }

  /**
   * Gets the ReviseCheckoutStatusRequestType.externalTransaction.
   * @return ExternalTransactionType
   */
  public ExternalTransactionType getExternalTransaction()
  {
    return this.externalTransaction;
  }

  /**
   * Sets the ReviseCheckoutStatusRequestType.externalTransaction.
   * @param externalTransaction ExternalTransactionType
   */
  public void setExternalTransaction(ExternalTransactionType externalTransaction)
  {
    this.externalTransaction = externalTransaction;
  }

  /**
   * Gets the ReviseCheckoutStatusRequestType.insuranceType.
   * @return InsuranceSelectedCodeType
   */
  public InsuranceSelectedCodeType getInsuranceType()
  {
    return this.insuranceType;
  }

  /**
   * Sets the ReviseCheckoutStatusRequestType.insuranceType.
   * @param insuranceType InsuranceSelectedCodeType
   */
  public void setInsuranceType(InsuranceSelectedCodeType insuranceType)
  {
    this.insuranceType = insuranceType;
  }

  /**
   * Gets the ReviseCheckoutStatusRequestType.itemID.
   * @return String
   */
  public String getItemID()
  {
    return this.itemID;
  }

  /**
   * Sets the ReviseCheckoutStatusRequestType.itemID.
   * @param itemID String
   */
  public void setItemID(String itemID)
  {
    this.itemID = itemID;
  }

  /**
   * Gets the ReviseCheckoutStatusRequestType.multipleSellerPaymentID.
   * @return String
   */
  public String getMultipleSellerPaymentID()
  {
    return this.multipleSellerPaymentID;
  }

  /**
   * Sets the ReviseCheckoutStatusRequestType.multipleSellerPaymentID.
   * @param multipleSellerPaymentID String
   */
  public void setMultipleSellerPaymentID(String multipleSellerPaymentID)
  {
    this.multipleSellerPaymentID = multipleSellerPaymentID;
  }

  /**
   * Gets the ReviseCheckoutStatusRequestType.orderId.
   * @return String
   */
  public String getOrderId()
  {
    return this.orderId;
  }

  /**
   * Sets the ReviseCheckoutStatusRequestType.orderId.
   * @param orderId String
   */
  public void setOrderId(String orderId)
  {
    this.orderId = orderId;
  }

  /**
   * Gets the ReviseCheckoutStatusRequestType.orderLineItemID.
   * @return String
   */
  public String getOrderLineItemID()
  {
    return this.orderLineItemID;
  }

  /**
   * Sets the ReviseCheckoutStatusRequestType.orderLineItemID.
   * @param orderLineItemID String
   */
  public void setOrderLineItemID(String orderLineItemID)
  {
    this.orderLineItemID = orderLineItemID;
  }

  /**
   * Gets the ReviseCheckoutStatusRequestType.paymentMethodUsed.
   * @return BuyerPaymentMethodCodeType
   */
  public BuyerPaymentMethodCodeType getPaymentMethodUsed()
  {
    return this.paymentMethodUsed;
  }

  /**
   * Sets the ReviseCheckoutStatusRequestType.paymentMethodUsed.
   * @param paymentMethodUsed BuyerPaymentMethodCodeType
   */
  public void setPaymentMethodUsed(BuyerPaymentMethodCodeType paymentMethodUsed)
  {
    this.paymentMethodUsed = paymentMethodUsed;
  }

  /**
   * Gets the ReviseCheckoutStatusRequestType.paymentStatus.
   * @return RCSPaymentStatusCodeType
   */
  public RCSPaymentStatusCodeType getPaymentStatus()
  {
    return this.paymentStatus;
  }

  /**
   * Sets the ReviseCheckoutStatusRequestType.paymentStatus.
   * @param paymentStatus RCSPaymentStatusCodeType
   */
  public void setPaymentStatus(RCSPaymentStatusCodeType paymentStatus)
  {
    this.paymentStatus = paymentStatus;
  }

  /**
   * Gets the ReviseCheckoutStatusRequestType.salesTax.
   * @return AmountType
   */
  public AmountType getSalesTax()
  {
    return this.salesTax;
  }

  /**
   * Sets the ReviseCheckoutStatusRequestType.salesTax.
   * @param salesTax AmountType
   */
  public void setSalesTax(AmountType salesTax)
  {
    this.salesTax = salesTax;
  }

  /**
   * Gets the ReviseCheckoutStatusRequestType.shippingAddress.
   * @return AddressType
   */
  public AddressType getShippingAddress()
  {
    return this.shippingAddress;
  }

  /**
   * Sets the ReviseCheckoutStatusRequestType.shippingAddress.
   * @param shippingAddress AddressType
   */
  public void setShippingAddress(AddressType shippingAddress)
  {
    this.shippingAddress = shippingAddress;
  }

  /**
   * Gets the ReviseCheckoutStatusRequestType.shippingCost.
   * @return AmountType
   */
  public AmountType getShippingCost()
  {
    return this.shippingCost;
  }

  /**
   * Sets the ReviseCheckoutStatusRequestType.shippingCost.
   * @param shippingCost AmountType
   */
  public void setShippingCost(AmountType shippingCost)
  {
    this.shippingCost = shippingCost;
  }

  /**
   * Gets the ReviseCheckoutStatusRequestType.shippingIncludedInTax.
   * @return Boolean
   */
  public Boolean getShippingIncludedInTax()
  {
    return this.shippingIncludedInTax;
  }

  /**
   * Sets the ReviseCheckoutStatusRequestType.shippingIncludedInTax.
   * @param shippingIncludedInTax Boolean
   */
  public void setShippingIncludedInTax(Boolean shippingIncludedInTax)
  {
    this.shippingIncludedInTax = shippingIncludedInTax;
  }

  /**
   * Gets the ReviseCheckoutStatusRequestType.shippingInsuranceCost.
   * @return AmountType
   */
  public AmountType getShippingInsuranceCost()
  {
    return this.shippingInsuranceCost;
  }

  /**
   * Sets the ReviseCheckoutStatusRequestType.shippingInsuranceCost.
   * @param shippingInsuranceCost AmountType
   */
  public void setShippingInsuranceCost(AmountType shippingInsuranceCost)
  {
    this.shippingInsuranceCost = shippingInsuranceCost;
  }

  /**
   * Gets the ReviseCheckoutStatusRequestType.shippingService.
   * @return String
   */
  public String getShippingService()
  {
    return this.shippingService;
  }

  /**
   * Sets the ReviseCheckoutStatusRequestType.shippingService.
   * @param shippingService String
   */
  public void setShippingService(String shippingService)
  {
    this.shippingService = shippingService;
  }

  /**
   * Gets the ReviseCheckoutStatusRequestType.transactionID.
   * @return String
   */
  public String getTransactionID()
  {
    return this.transactionID;
  }

  /**
   * Sets the ReviseCheckoutStatusRequestType.transactionID.
   * @param transactionID String
   */
  public void setTransactionID(String transactionID)
  {
    this.transactionID = transactionID;
  }
/**
   * Backward compatible function - sets shipping service using a shipping service code type value.
   * @param shippingService ShippingServiceCodeType
   */
  public void setShippingService(com.ebay.soap.eBLBaseComponents.ShippingServiceCodeType shippingService) {
      this.shippingService = (shippingService == null? null: shippingService.value());
  }

}

