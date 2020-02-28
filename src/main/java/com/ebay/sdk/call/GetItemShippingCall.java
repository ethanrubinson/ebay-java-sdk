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
import java.lang.String;

import com.ebay.sdk.*;
import com.ebay.soap.eBLBaseComponents.*;
/**
 * Wrapper class of the GetItemShipping call of eBay SOAP API.
 * <br>
 * <p>Title: SOAP API wrapper library.</p>
 * <p>Description: Contains wrapper classes for eBay SOAP APIs.</p>
 * <p>Copyright: Copyright (c) 2009</p>
 * <p>Company: eBay Inc.</p>
 * <br> <B>Input property:</B> <code>ItemID</code> - The unique identifier of the eBay listing for which to retrieve estimated shipping costs for all offered shipping service options. The <b>ItemID</b> value passed into this field should be for an listing that offers at least one calculated shipping service option, and for an item that has yet to be shipped.
 * <br> <B>Input property:</B> <code>QuantitySold</code> - This field is used to specify the quantity of the item. The <b>QuantitySold</b> value defaults to <code>1</code> if not specified. If a value greater than <code>1</code> is specified in this field, the shipping service costs returned in the response will reflect the expense to ship multiple quantity of an item.
 * <br>
 * <br> <B>Input property:</B> <code>DestinationPostalCode</code> - The destination postal code (or zip code for US) is supplied in this field. <b>GetItemShipping</b> requires the destination of the shipment. Some countries will require both the <b>DestinationPostalCode</b> and the lt;b>DestinationCountryCode</b>, and some countries will accept either one or the other.
 * <br> <B>Input property:</B> <code>DestinationCountryCode</code> - The destination country code is supplied in this field. <b>GetItemShipping</b> requires the destination of the shipment. Some countries will require both the <b>DestinationPostalCode</b> and the lt;b>DestinationCountryCode</b>, and some countries will accept either one or the other.
 * <br><br>
 * Two-digit country codes can be found in <a href="types/CountryCodeType.html">CountryCodeType</a>.
 * <br>
 * <br> <B>Output property:</B> <code>ReturnedShippingDetails</code> - This container will be returned if at least one domestic or international shipping service option is available for the item. A <b>ShippingServiceOptions</b> (for domestic shipping) and/or an <b>InternationalShippingServiceOptions</b> container (for international shipping) is returned for each available calculated shipping service option. These shipping service option containers consists of estimated shipping cost and estimated shipping times.
 * <br>
 * <br>
 * Any error about shipping services (returned by a vendor of eBay's who calculates shipping costs) is returned in <b>ShippingRateErrorMessage</b>. Errors from a shipping service are likely to be related to issues with shipping specifications, such as package size and the selected shipping method not supported by a particular shipping service.
 * <br> <B>Output property:</B> <code>ReturnedPickUpInStoreDetails</code> - This container is only returned in <b>GetItemShipping</b> if the In-Store Pickup feature is enabled for the listing. In-Store Pickup as a fulfillment method is only available to a limited number of large retail merchants in the US, Canada, UK, Germany, and Australia marketplaces. The In-Store Pickup feature can only be applied to multiple-quantity, fixed-price listings, and the merchant must have quantity of the item available in a store that is near the prospective buyer, in order for In-Store Pickup to be an available fulfillment option for that buyer.
 * 
 * @author Ron Murphy
 * @version 1.0
 */

public class GetItemShippingCall extends com.ebay.sdk.ApiCall
{
  
  private String itemID = null;
  private Integer quantitySold = null;
  private String destinationPostalCode = null;
  private CountryCodeType destinationCountryCode = null;
  private ShippingDetailsType returnedShippingDetails=null;
  private PickupInStoreDetailsType returnedPickUpInStoreDetails=null;


  /**
   * Constructor.
   */
  public GetItemShippingCall() {
  }

  /**
   * Constructor.
   * @param apiContext The ApiContext object to be used to make the call.
   */
  public GetItemShippingCall(ApiContext apiContext) {
    super(apiContext);
    

  }

  /**
   * This is the base request type of the <b>GetItemShipping</b> call. This call takes an <b>ItemID</b> value for an item that has yet to be shipped, and then returns estimated shipping costs for every shipping service that the seller has offered with the listing. This call will also return <b>PickUpInStoreDetails.EligibleForPickupDropOff</b> and <b>PickUpInStoreDetails.EligibleForPickupInStore</b> flags if the item is available for buyer pick-up through the In-Store Pickup or Click and Collect features.
   * 
   * <br>
   * @throws ApiException
   * @throws SdkException
   * @throws Exception
   * @return The ShippingDetailsType object.
   */
  public ShippingDetailsType getItemShipping()
      throws com.ebay.sdk.ApiException, com.ebay.sdk.SdkException, java.lang.Exception
  {
    GetItemShippingRequestType req;
    req = new GetItemShippingRequestType();
    req.setDetailLevel(this.getDetailLevel());
    if (this.itemID != null)
      req.setItemID(this.itemID);
    if (this.quantitySold != null)
      req.setQuantitySold(this.quantitySold);
    if (this.destinationPostalCode != null)
      req.setDestinationPostalCode(this.destinationPostalCode);
    if (this.destinationCountryCode != null)
      req.setDestinationCountryCode(this.destinationCountryCode);

    GetItemShippingResponseType resp = (GetItemShippingResponseType) execute(req);

    this.returnedShippingDetails = resp.getShippingDetails();
    this.returnedPickUpInStoreDetails = resp.getPickUpInStoreDetails();
    return this.getReturnedShippingDetails();
  }

  /**
   * Gets the GetItemShippingRequestType.destinationCountryCode.
   * @return CountryCodeType
   */
  public CountryCodeType getDestinationCountryCode()
  {
    return this.destinationCountryCode;
  }

  /**
   * Sets the GetItemShippingRequestType.destinationCountryCode.
   * @param destinationCountryCode CountryCodeType
   */
  public void setDestinationCountryCode(CountryCodeType destinationCountryCode)
  {
    this.destinationCountryCode = destinationCountryCode;
  }

  /**
   * Gets the GetItemShippingRequestType.destinationPostalCode.
   * @return String
   */
  public String getDestinationPostalCode()
  {
    return this.destinationPostalCode;
  }

  /**
   * Sets the GetItemShippingRequestType.destinationPostalCode.
   * @param destinationPostalCode String
   */
  public void setDestinationPostalCode(String destinationPostalCode)
  {
    this.destinationPostalCode = destinationPostalCode;
  }

  /**
   * Gets the GetItemShippingRequestType.itemID.
   * @return String
   */
  public String getItemID()
  {
    return this.itemID;
  }

  /**
   * Sets the GetItemShippingRequestType.itemID.
   * @param itemID String
   */
  public void setItemID(String itemID)
  {
    this.itemID = itemID;
  }

  /**
   * Gets the GetItemShippingRequestType.quantitySold.
   * @return Integer
   */
  public Integer getQuantitySold()
  {
    return this.quantitySold;
  }

  /**
   * Sets the GetItemShippingRequestType.quantitySold.
   * @param quantitySold Integer
   */
  public void setQuantitySold(Integer quantitySold)
  {
    this.quantitySold = quantitySold;
  }

  /**
   * Valid after executing the API.
   * Gets the returned GetItemShippingResponseType.returnedPickUpInStoreDetails.
   * 
   * @return PickupInStoreDetailsType
   */
  public PickupInStoreDetailsType getReturnedPickUpInStoreDetails()
  {
    return this.returnedPickUpInStoreDetails;
  }

  /**
   * Valid after executing the API.
   * Gets the returned GetItemShippingResponseType.returnedShippingDetails.
   * 
   * @return ShippingDetailsType
   */
  public ShippingDetailsType getReturnedShippingDetails()
  {
    return this.returnedShippingDetails;
  }

}

