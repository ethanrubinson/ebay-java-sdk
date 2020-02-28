/*
Copyright (c) 2013 eBay, Inc.
This program is licensed under the terms of the eBay Common Development and
Distribution License (CDDL) Version 1.0 (the "License") and any subsequent  version 
thereof released by eBay.  The then-current version of the License can be found 
at http://www.opensource.org/licenses/cddl1.php and in the eBaySDKLicense file that 
is under the eBay SDK ../docs directory.
*/

package com.ebay.sdk.call;

import java.util.Calendar;

import com.ebay.sdk.*;
import com.ebay.soap.eBLBaseComponents.*;
/**
 * Wrapper class of the GeteBayDetails call of eBay SOAP API.
 * <br>
 * <p>Title: SOAP API wrapper library.</p>
 * <p>Description: Contains wrapper classes for eBay SOAP APIs.</p>
 * <p>Copyright: Copyright (c) 2009</p>
 * <p>Company: eBay Inc.</p>
 * <br> <B>Input property:</B> <code>DetailName</code> - One or more <b>DetailName</b> fields may be used to control the the type of metadata that is returned in the response. If no <b>DetailName</b> fields are used, all metadata will be returned in the response. It is a good idea to familiarize yourself with the metadata that can be returned with <b>GeteBayDetails</b> by reading through the enumeration values in <a href="types/DetailNameCodeType.html">DetailNameCodeType</a>.
 * <br> <B>Output property:</B> <code>ReturnedCountryDetails</code> - Lists the country code and associated name of the countries supported by
 * the eBay system, regardless of the site specified in the request.
 * <br/><br/>
 * <span class="tablenote"><b>Note: </b>
 * This container is only returned if <b>CountryDetails</b> is included as a <b>DetailName</b> filter in the request, or if no <b>DetailName</b> filters are used in the request.
 * </span>
 * <br> <B>Output property:</B> <code>ReturnedCurrencyDetails</code> - Lists the currencies supported by the eBay system, regardless of the site
 * specified in the request.
 * <br/><br/>
 * <span class="tablenote"><b>Note: </b>
 * This container is only returned if <b>CurrencyDetails</b> is included as a
 * <b>DetailName</b> filter in the request, or if no <b>DetailName</b> filters are
 * used in the request.
 * </span>
 * <br> <B>Output property:</B> <code>ReturnedDispatchTimeMaxDetails</code> - A dispatch time specifies the maximum number of business days a seller commits to for shipping an item to domestic buyers after receiving a cleared payment. Returns all dispatch times in the system, regardless of the site specified in the request.
 * <br/><br/>
 * <span class="tablenote"><b>Note: </b>
 * This container is only returned if <b>DispatchTimeMaxDetails</b> is included as a
 * <b>DetailName</b> filter in the request, or if no <b>DetailName</b>
 * filters are used in the request.
 * </span>
 * <br> <B>Output property:</B> <code>ReturnedPaymentOptionDetails</code> - Although the supported payment methods for the specified eBay site are returned, it is recommended that the seller use <b>GetCategoryFeatures</b> instead, and pass in <b>PaymentMethods</b> as a <b>FeatureID</b> value in the request.
 * <br/><br/>
 * <span class="tablenote"><b>Note: </b> This container is only returned if <b>PaymentOptionDetails</b> is included as a <b>DetailName</b> filter in the request, or if no <b>DetailName</b> filters are used in the request.
 * </span>
 * <br> <B>Output property:</B> <code>ReturnedRegionDetails</code> - Lists the cities and other domestic regions for the specified site's country.
 * <br/><br/>
 * <span class="tablenote"><b>Note: </b>
 * This container is only returned if <b>RegionDetails</b> is included as a
 * <b>DetailName</b> filter in the request, or if no <b>DetailName</b> filters are
 * used in the request.
 * </span>
 * <br> <B>Output property:</B> <code>ReturnedShippingLocationDetails</code> - Lists the worldwide regions that can be set as shipping locations from the specified eBay site.
 * <br/><br/>
 * <span class="tablenote"><b>Note: </b>
 * This container is only returned if <b>ShippingLocationDetails</b> is included as a
 * <b>DetailName</b> filter in the request, or if no <b>DetailName</b>
 * filters are used in the request.
 * </span>
 * <br> <B>Output property:</B> <code>ReturnedShippingServiceDetails</code> - Lists the shipping services supported by the specified eBay site. Returns only the shipping services that are applicable to the site specified in the request.
 * <br/><br/>
 * <span class="tablenote"><b>Note: </b>
 * This container is only returned if <b>ShippingServiceDetails</b> is included as a
 * <b>DetailName</b> filter in the request, or if no <b>DetailName</b>
 * filters are used in the request.
 * </span>
 * <br> <B>Output property:</B> <code>ReturnedSiteDetails</code> - Lists all available eBay sites and their associated <b>SiteID</b> numbers.
 * <br/><br/>
 * <span class="tablenote"><b>Note: </b>
 * This container is only returned if <b>SiteDetails</b> is included as a
 * <b>DetailName</b> filter in the request, or if no <b>DetailName</b>
 * filters are used in the request.
 * </span>
 * <br> <B>Output property:</B> <code>ReturnedTaxJurisdiction</code> - Details the different tax jurisdictions or tax regions applicable to the
 * site specified in the request. Note that tax jurisdictions are only applicable to the following eBay sites: eBay US (Site ID 0), eBay Canada (Site ID 2), eBay Canada (French) (Site ID 210), and eBay India (Site ID 203). An empty response will be returned for any other Site ID that is passed in the HTTP header.
 * <br/><br/>
 * <span class="tablenote"><b>Note: </b>
 * This container is only returned if <b>TaxJurisdiction</b> is included as a
 * <b>DetailName</b> filter in the request, or if no <b>DetailName</b>
 * filters are used in the request.
 * </span>
 * <br> <B>Output property:</B> <code>ReturnedURLDetails</code> - Lists eBay URLs that are applicable to the site specified in the request.
 * <br/><br/>
 * <span class="tablenote"><b>Note: </b>
 * This container is only returned if <b>URLDetails</b> is included as a
 * <b>DetailName</b> filter in the request, or if no <b>DetailName</b>
 * filters are used in the request.
 * </span>
 * <br> <B>Output property:</B> <code>ReturnedTimeZoneDetails</code> - Lists the details of the time zones supported by the eBay system.
 * <br/><br/>
 * <span class="tablenote"><b>Note: </b>
 * This container is only returned if <b>TimeZoneDetails</b> is included as a
 * <b>DetailName</b> filter in the request, or if no <b>DetailName</b>
 * filters are used in the request.
 * </span>
 * <br> <B>Output property:</B> <code>ReturnedItemSpecificDetails</code> - Lists the site's maximum thresholds for specifying Item Specifics.
 * <br/><br/>
 * <span class="tablenote"><b>Note: </b>
 * This container is only returned if <b>ItemSpecificDetails</b> is included as a
 * <b>DetailName</b> filter in the request, or if no <b>DetailName</b>
 * filters are used in the request.
 * </span>
 * <br> <B>Output property:</B> <code>ReturnedUnitOfMeasurementDetails</code> - Units of measurement are no longer returned in GeteBayDetails, so this container is no longer applicable.
 * <br> <B>Output property:</B> <code>ReturnedRegionOfOriginDetails</code> - Lists the worldwide regions and individual countries that can be set as shipping locations from the specified eBay site.
 * <br/><br/>
 * <span class="tablenote"><b>Note: </b>
 * This container is only returned if <b>RegionOfOriginDetails</b> is included as a
 * <b>DetailName</b> filter in the request, or if no <b>DetailName</b>
 * filters are used in the request.
 * </span>
 * <br> <B>Output property:</B> <code>ReturnedShippingPackageDetails</code> - Lists the various shipping packages supported by the specified site.
 * <br/><br/>
 * <span class="tablenote"><b>Note: </b>
 * This container is only returned if <b>ShippingPackageDetails</b> is included as a
 * <b>DetailName</b> filter in the request, or if no <b>DetailName</b>
 * filters are used in the request.
 * </span>
 * <br> <B>Output property:</B> <code>ReturnedShippingCarrierDetails</code> - Lists the shipping carriers supported by the specified site.
 * <br/><br/>
 * <span class="tablenote"><b>Note: </b>
 * This container is only returned if <b>ShippingCarrierDetails</b> is included as a
 * <b>DetailName</b> filter in the request, or if no <b>DetailName</b>
 * filters are used in the request.
 * </span>
 * <br> <B>Output property:</B> <code>ReturnedReturnPolicyDetails</code> - Lists the supported values that may be used for return policies on the specified eBay site, such as the return period, supported restocking fees, and refund options.
 * <br/><br/>
 * <span class="tablenote"><b>Note: </b>
 * This container is only returned if <b>ReturnPolicyDetails</b> is included as a
 * <b>DetailName</b> filter in the request, or if no <b>DetailName</b>
 * filters are used in the request.
 * </span>
 * <span class="tablenote"><b>Note: </b>
 * This container has been staged for deprecation. Although domestic return policy metadata is still getting returned at the moment, it is recommended that users start making plans to use the <b>GetCategoryFeatures</b> call instead to retrieve category-level, domestic return policy metadata.
 * </span>
 * <br> <B>Output property:</B> <code>ReturnedInternationalReturnPolicyDetails</code> - <span class="tablenote"><b>Note: </b>
 * This container has been deprecated. The <b>GetCategoryFeatures</b> call must be used instead to retrieve category-level, international return policy metadata.
 * </span>
 * <br> <B>Output property:</B> <code>ReturnedListingStartPriceDetails</code> - Lists the minimum starting prices for the supported types of eBay listings.
 * <br/><br/>
 * <span class="tablenote"><b>Note: </b>
 * This container is only returned if <b>ListingStartPriceDetails</b> is included as a
 * <b>DetailName</b> filter in the request, or if no <b>DetailName</b>
 * filters are used in the request.
 * </span>
 * <br> <B>Output property:</B> <code>ReturnedBuyerRequirementDetails</code> - Lists the threshold values that can be passed in through the <b>BuyerRequirementDetails</b> container in the Add/Revise/Relist API calls. Buyer Requirements allow the seller to block buyers who have unpaid item defects, policy violations, low Feedback scores, and/or other undesirable qualities/statistics. Buyer Requirements are set at the seller's account level, but by using a  <b>BuyerRequirementDetails</b> container in an Add/Revise/Relist API call, the values in that container will override values set at the account level.
 * <br/><br/>
 * <span class="tablenote"><b>Note: </b>
 * This container is only returned if <b>BuyerRequirementDetails</b> is included as a
 * <b>DetailName</b> filter in the request, or if no <b>DetailName</b>
 * filters are used in the request.
 * </span>
 * <br> <B>Output property:</B> <code>ReturnedListingFeatureDetails</code> - Details the listing features available for the eBay site specified in the request.
 * <br/><br/>
 * <span class="tablenote"><b>Note: </b>
 * This container is only returned if <b>ListingFeatureDetails</b> is included as a
 * <b>DetailName</b> filter in the request, or if no <b>DetailName</b>
 * filters are used in the request.
 * </span>
 * <br> <B>Output property:</B> <code>ReturnedVariationDetails</code> - Site-level validation rules for multi-variation listings (for example, the
 * maximum number of variations per listing). Use <b>GetCategoryFeatures</b> to
 * determine which categories on a site support variations. Use
 * <b>GetCategorySpecifics</b> for rules related to recommended or required variation
 * specifics.
 * <br/><br/>
 * <span class="tablenote"><b>Note: </b>
 * This container is only returned if <b>VariationDetails</b> is included as a
 * <b>DetailName</b> filter in the request, or if no <b>DetailName</b>
 * filters are used in the request.
 * </span>
 * <br> <B>Output property:</B> <code>ReturnedExcludeShippingLocationDetails</code> - Lists the locations supported by the <b>ExcludeShipToLocation</b> feature. These are
 * locations that a seller can list as areas where they will not ship an item.
 * <br/><br/>
 * <span class="tablenote"><b>Note: </b>
 * This container is only returned if <b>ExcludeShippingLocationDetails</b> is included as a
 * <b>DetailName</b> filter in the request, or if no <b>DetailName</b>
 * filters are used in the request.
 * </span>
 * <br> <B>Output property:</B> <code>ReturnedUpdateTime</code> - The time of the most recent modification to any feature detail. If specific
 * feature details are passed in the request, gives the most recent modification time
 * of those feature details.
 * <br> <B>Output property:</B> <code>ReturnedRecoupmentPolicyDetails</code> - Details the recoupment policies for the site specified in the request.
 * <br/><br/>
 * <span class="tablenote"><b>Note: </b>
 * This container is only returned if <b>RecoupmentPolicyDetails</b> is included as a
 * <b>DetailName</b> filter in the request, or if no <b>DetailName</b>
 * filters are used in the request.
 * </span>
 * <br> <B>Output property:</B> <code>ReturnedShippingCategoryDetails</code> - A shipping service category supported for the site.
 * <br/><br/>
 * <span class="tablenote"><b>Note: </b>
 * This container is only returned if <b>ShippingCategoryDetails</b> is included as a
 * <b>DetailName</b> filter in the request, or if no <b>DetailName</b>
 * filters are used in the request.
 * </span>
 * Each shipping service supported for a site is automatically categorized by eBay into one of the
 * shipping categories available for that site depending on how the shipping service shipping time
 * aligns with the shipping times specified by eBay for each category.
 * <br><br>
 * Notice that you cannot specify a <b>ShippingCategory</b>
 * as an input to any API call - eBay does this categorizing automatically. <b>ShippingCategory</b> is read-only data
 * that is returned in the <b>ShippingServiceDetails</b> container. One possible use of this data is to segregate shipping
 * services by <b>ShippingCategory</b> in a pick list. (For an example of this, see the Services pulldown menu in the
 * Give buyers shipping details form in the eBay Sell Your Item flow.)
 * <br><br>
 * One way to populate the picklist would be to call <b>GeteBayDetails</b>
 * with <b>DetailName</b> set to <b>ShippingServiceDetails</b>.
 * Then sort these results by <b>ShippingCategory</b> and populate the picklist.
 * <br> <B>Output property:</B> <code>ReturnedProductDetails</code> - The <b>ProductDetails.ProductIdentifierUnavailableText</b>
 * field contains the actual text that should be passed into the relevant
 * product identification fields (EAN, ISBN, UPC, MPN/Brand) if eBay is
 * prompting/expecting one of these fields in the call request, but the identifiers do not exist/apply for the product. The text will vary based on the listing site. This text should only be used if no product ID exists for the product. If a product identifier value does actually exist for a product, but the seller passes in 'Does not apply' text, that listing may get penalized in search.
 * <br/><br/>
 * <span class="tablenote"><b>Note: </b>
 * This container is only returned if <b>ProductDetails</b> is included as a
 * <b>DetailName</b> filter in the request, or if no <b>DetailName</b>
 * filters are used in the request.
 * </span>
 * 
 * @author Ron Murphy
 * @version 1.0
 */

public class GeteBayDetailsCall extends com.ebay.sdk.ApiCall
{
  
  private DetailNameCodeType[] detailName = null;
  private CountryDetailsType[] returnedCountryDetails=null;
  private CurrencyDetailsType[] returnedCurrencyDetails=null;
  private DispatchTimeMaxDetailsType[] returnedDispatchTimeMaxDetails=null;
  private PaymentOptionDetailsType[] returnedPaymentOptionDetails=null;
  private RegionDetailsType[] returnedRegionDetails=null;
  private ShippingLocationDetailsType[] returnedShippingLocationDetails=null;
  private ShippingServiceDetailsType[] returnedShippingServiceDetails=null;
  private SiteDetailsType[] returnedSiteDetails=null;
  private TaxJurisdictionType[] returnedTaxJurisdiction=null;
  private URLDetailsType[] returnedURLDetails=null;
  private TimeZoneDetailsType[] returnedTimeZoneDetails=null;
  private ItemSpecificDetailsType[] returnedItemSpecificDetails=null;
  private UnitOfMeasurementDetailsType[] returnedUnitOfMeasurementDetails=null;
  private RegionOfOriginDetailsType[] returnedRegionOfOriginDetails=null;
  private ShippingPackageDetailsType[] returnedShippingPackageDetails=null;
  private ShippingCarrierDetailsType[] returnedShippingCarrierDetails=null;
  private ReturnPolicyDetailsType returnedReturnPolicyDetails=null;
  private ReturnPolicyDetailsType returnedInternationalReturnPolicyDetails=null;
  private ListingStartPriceDetailsType[] returnedListingStartPriceDetails=null;
  private SiteBuyerRequirementDetailsType[] returnedBuyerRequirementDetails=null;
  private ListingFeatureDetailsType[] returnedListingFeatureDetails=null;
  private VariationDetailsType returnedVariationDetails=null;
  private ExcludeShippingLocationDetailsType[] returnedExcludeShippingLocationDetails=null;
  private Calendar returnedUpdateTime=null;
  private RecoupmentPolicyDetailsType[] returnedRecoupmentPolicyDetails=null;
  private ShippingCategoryDetailsType[] returnedShippingCategoryDetails=null;
  private ProductDetailsType returnedProductDetails=null;


  /**
   * Constructor.
   */
  public GeteBayDetailsCall() {
  }

  /**
   * Constructor.
   * @param apiContext The ApiContext object to be used to make the call.
   */
  public GeteBayDetailsCall(ApiContext apiContext) {
    super(apiContext);
    

  }

  /**
   * This is the base request type for the <b>GeteBayDetails</b> call. This call retrieves the latest eBay feature-related metadata values that are supported when listing items. This metadata includes country codes, currency codes, Item Specifics thresholds, supported Return Policy values, available shipping carriers and shipping service options, and more. This call may be used to keep metadata up-to-date in your applications.
   * <br><br>
   * In some cases, the data returned in the response will vary according to the eBay site that you use for the request.
   * 
   * <br>
   * @throws ApiException
   * @throws SdkException
   * @throws Exception
   * @return The void object.
   */
  public void geteBayDetails()
      throws com.ebay.sdk.ApiException, com.ebay.sdk.SdkException, java.lang.Exception
  {
    GeteBayDetailsRequestType req;
    req = new GeteBayDetailsRequestType();
    req.setDetailLevel(this.getDetailLevel());
    if (this.detailName != null)
      req.setDetailName(this.detailName);

    GeteBayDetailsResponseType resp = (GeteBayDetailsResponseType) execute(req);

    this.returnedCountryDetails = resp.getCountryDetails();
    this.returnedCurrencyDetails = resp.getCurrencyDetails();
    this.returnedDispatchTimeMaxDetails = resp.getDispatchTimeMaxDetails();
    this.returnedPaymentOptionDetails = resp.getPaymentOptionDetails();
    this.returnedRegionDetails = resp.getRegionDetails();
    this.returnedShippingLocationDetails = resp.getShippingLocationDetails();
    this.returnedShippingServiceDetails = resp.getShippingServiceDetails();
    this.returnedSiteDetails = resp.getSiteDetails();
    this.returnedTaxJurisdiction = resp.getTaxJurisdiction();
    this.returnedURLDetails = resp.getURLDetails();
    this.returnedTimeZoneDetails = resp.getTimeZoneDetails();
    this.returnedItemSpecificDetails = resp.getItemSpecificDetails();
    this.returnedUnitOfMeasurementDetails = resp.getUnitOfMeasurementDetails();
    this.returnedRegionOfOriginDetails = resp.getRegionOfOriginDetails();
    this.returnedShippingPackageDetails = resp.getShippingPackageDetails();
    this.returnedShippingCarrierDetails = resp.getShippingCarrierDetails();
    this.returnedReturnPolicyDetails = resp.getReturnPolicyDetails();
    this.returnedInternationalReturnPolicyDetails = resp.getInternationalReturnPolicyDetails();
    this.returnedListingStartPriceDetails = resp.getListingStartPriceDetails();
    this.returnedBuyerRequirementDetails = resp.getBuyerRequirementDetails();
    this.returnedListingFeatureDetails = resp.getListingFeatureDetails();
    this.returnedVariationDetails = resp.getVariationDetails();
    this.returnedExcludeShippingLocationDetails = resp.getExcludeShippingLocationDetails();
    this.returnedUpdateTime = resp.getUpdateTime();
    this.returnedRecoupmentPolicyDetails = resp.getRecoupmentPolicyDetails();
    this.returnedShippingCategoryDetails = resp.getShippingCategoryDetails();
    this.returnedProductDetails = resp.getProductDetails();

  }

  /**
   * Gets the GeteBayDetailsRequestType.detailName.
   * @return DetailNameCodeType[]
   */
  public DetailNameCodeType[] getDetailName()
  {
    return this.detailName;
  }

  /**
   * Sets the GeteBayDetailsRequestType.detailName.
   * @param detailName DetailNameCodeType[]
   */
  public void setDetailName(DetailNameCodeType[] detailName)
  {
    this.detailName = detailName;
  }

  /**
   * Valid after executing the API.
   * Gets the returned GeteBayDetailsResponseType.
   * 
   * @return GeteBayDetailsResponseType
   */
  public GeteBayDetailsResponseType getReturnedeBayDetails()
  {
    return (GeteBayDetailsResponseType) this.getResponseObject();
  }

  /**
   * Valid after executing the API.
   * Gets the returned GeteBayDetailsResponseType.returnedBuyerRequirementDetails.
   * 
   * @return SiteBuyerRequirementDetailsType[]
   */
  public SiteBuyerRequirementDetailsType[] getReturnedBuyerRequirementDetails()
  {
    return this.returnedBuyerRequirementDetails;
  }

  /**
   * Valid after executing the API.
   * Gets the returned GeteBayDetailsResponseType.returnedCountryDetails.
   * 
   * @return CountryDetailsType[]
   */
  public CountryDetailsType[] getReturnedCountryDetails()
  {
    return this.returnedCountryDetails;
  }

  /**
   * Valid after executing the API.
   * Gets the returned GeteBayDetailsResponseType.returnedCurrencyDetails.
   * 
   * @return CurrencyDetailsType[]
   */
  public CurrencyDetailsType[] getReturnedCurrencyDetails()
  {
    return this.returnedCurrencyDetails;
  }

  /**
   * Valid after executing the API.
   * Gets the returned GeteBayDetailsResponseType.returnedDispatchTimeMaxDetails.
   * 
   * @return DispatchTimeMaxDetailsType[]
   */
  public DispatchTimeMaxDetailsType[] getReturnedDispatchTimeMaxDetails()
  {
    return this.returnedDispatchTimeMaxDetails;
  }

  /**
   * Valid after executing the API.
   * Gets the returned GeteBayDetailsResponseType.returnedExcludeShippingLocationDetails.
   * 
   * @return ExcludeShippingLocationDetailsType[]
   */
  public ExcludeShippingLocationDetailsType[] getReturnedExcludeShippingLocationDetails()
  {
    return this.returnedExcludeShippingLocationDetails;
  }

  /**
   * Valid after executing the API.
   * Gets the returned GeteBayDetailsResponseType.returnedInternationalReturnPolicyDetails.
   * 
   * @return ReturnPolicyDetailsType
   */
  public ReturnPolicyDetailsType getReturnedInternationalReturnPolicyDetails()
  {
    return this.returnedInternationalReturnPolicyDetails;
  }

  /**
   * Valid after executing the API.
   * Gets the returned GeteBayDetailsResponseType.returnedItemSpecificDetails.
   * 
   * @return ItemSpecificDetailsType[]
   */
  public ItemSpecificDetailsType[] getReturnedItemSpecificDetails()
  {
    return this.returnedItemSpecificDetails;
  }

  /**
   * Valid after executing the API.
   * Gets the returned GeteBayDetailsResponseType.returnedListingFeatureDetails.
   * 
   * @return ListingFeatureDetailsType[]
   */
  public ListingFeatureDetailsType[] getReturnedListingFeatureDetails()
  {
    return this.returnedListingFeatureDetails;
  }

  /**
   * Valid after executing the API.
   * Gets the returned GeteBayDetailsResponseType.returnedListingStartPriceDetails.
   * 
   * @return ListingStartPriceDetailsType[]
   */
  public ListingStartPriceDetailsType[] getReturnedListingStartPriceDetails()
  {
    return this.returnedListingStartPriceDetails;
  }

  /**
   * Valid after executing the API.
   * Gets the returned GeteBayDetailsResponseType.returnedPaymentOptionDetails.
   * 
   * @return PaymentOptionDetailsType[]
   */
  public PaymentOptionDetailsType[] getReturnedPaymentOptionDetails()
  {
    return this.returnedPaymentOptionDetails;
  }

  /**
   * Valid after executing the API.
   * Gets the returned GeteBayDetailsResponseType.returnedProductDetails.
   * 
   * @return ProductDetailsType
   */
  public ProductDetailsType getReturnedProductDetails()
  {
    return this.returnedProductDetails;
  }

  /**
   * Valid after executing the API.
   * Gets the returned GeteBayDetailsResponseType.returnedRecoupmentPolicyDetails.
   * 
   * @return RecoupmentPolicyDetailsType[]
   */
  public RecoupmentPolicyDetailsType[] getReturnedRecoupmentPolicyDetails()
  {
    return this.returnedRecoupmentPolicyDetails;
  }

  /**
   * Valid after executing the API.
   * Gets the returned GeteBayDetailsResponseType.returnedRegionDetails.
   * 
   * @return RegionDetailsType[]
   */
  public RegionDetailsType[] getReturnedRegionDetails()
  {
    return this.returnedRegionDetails;
  }

  /**
   * Valid after executing the API.
   * Gets the returned GeteBayDetailsResponseType.returnedRegionOfOriginDetails.
   * 
   * @return RegionOfOriginDetailsType[]
   */
  public RegionOfOriginDetailsType[] getReturnedRegionOfOriginDetails()
  {
    return this.returnedRegionOfOriginDetails;
  }

  /**
   * Valid after executing the API.
   * Gets the returned GeteBayDetailsResponseType.returnedReturnPolicyDetails.
   * 
   * @return ReturnPolicyDetailsType
   */
  public ReturnPolicyDetailsType getReturnedReturnPolicyDetails()
  {
    return this.returnedReturnPolicyDetails;
  }

  /**
   * Valid after executing the API.
   * Gets the returned GeteBayDetailsResponseType.returnedShippingCarrierDetails.
   * 
   * @return ShippingCarrierDetailsType[]
   */
  public ShippingCarrierDetailsType[] getReturnedShippingCarrierDetails()
  {
    return this.returnedShippingCarrierDetails;
  }

  /**
   * Valid after executing the API.
   * Gets the returned GeteBayDetailsResponseType.returnedShippingCategoryDetails.
   * 
   * @return ShippingCategoryDetailsType[]
   */
  public ShippingCategoryDetailsType[] getReturnedShippingCategoryDetails()
  {
    return this.returnedShippingCategoryDetails;
  }

  /**
   * Valid after executing the API.
   * Gets the returned GeteBayDetailsResponseType.returnedShippingLocationDetails.
   * 
   * @return ShippingLocationDetailsType[]
   */
  public ShippingLocationDetailsType[] getReturnedShippingLocationDetails()
  {
    return this.returnedShippingLocationDetails;
  }

  /**
   * Valid after executing the API.
   * Gets the returned GeteBayDetailsResponseType.returnedShippingPackageDetails.
   * 
   * @return ShippingPackageDetailsType[]
   */
  public ShippingPackageDetailsType[] getReturnedShippingPackageDetails()
  {
    return this.returnedShippingPackageDetails;
  }

  /**
   * Valid after executing the API.
   * Gets the returned GeteBayDetailsResponseType.returnedShippingServiceDetails.
   * 
   * @return ShippingServiceDetailsType[]
   */
  public ShippingServiceDetailsType[] getReturnedShippingServiceDetails()
  {
    return this.returnedShippingServiceDetails;
  }

  /**
   * Valid after executing the API.
   * Gets the returned GeteBayDetailsResponseType.returnedSiteDetails.
   * 
   * @return SiteDetailsType[]
   */
  public SiteDetailsType[] getReturnedSiteDetails()
  {
    return this.returnedSiteDetails;
  }

  /**
   * Valid after executing the API.
   * Gets the returned GeteBayDetailsResponseType.returnedTaxJurisdiction.
   * 
   * @return TaxJurisdictionType[]
   */
  public TaxJurisdictionType[] getReturnedTaxJurisdiction()
  {
    return this.returnedTaxJurisdiction;
  }

  /**
   * Valid after executing the API.
   * Gets the returned GeteBayDetailsResponseType.returnedTimeZoneDetails.
   * 
   * @return TimeZoneDetailsType[]
   */
  public TimeZoneDetailsType[] getReturnedTimeZoneDetails()
  {
    return this.returnedTimeZoneDetails;
  }

  /**
   * Valid after executing the API.
   * Gets the returned GeteBayDetailsResponseType.returnedURLDetails.
   * 
   * @return URLDetailsType[]
   */
  public URLDetailsType[] getReturnedURLDetails()
  {
    return this.returnedURLDetails;
  }

  /**
   * Valid after executing the API.
   * Gets the returned GeteBayDetailsResponseType.returnedUnitOfMeasurementDetails.
   * 
   * @return UnitOfMeasurementDetailsType[]
   */
  public UnitOfMeasurementDetailsType[] getReturnedUnitOfMeasurementDetails()
  {
    return this.returnedUnitOfMeasurementDetails;
  }

  /**
   * Valid after executing the API.
   * Gets the returned GeteBayDetailsResponseType.returnedUpdateTime.
   * 
   * @return Calendar
   */
  public Calendar getReturnedUpdateTime()
  {
    return this.returnedUpdateTime;
  }

  /**
   * Valid after executing the API.
   * Gets the returned GeteBayDetailsResponseType.returnedVariationDetails.
   * 
   * @return VariationDetailsType
   */
  public VariationDetailsType getReturnedVariationDetails()
  {
    return this.returnedVariationDetails;
  }

}

