/*
Copyright (c) 2013 eBay, Inc.
This program is licensed under the terms of the eBay Common Development and
Distribution License (CDDL) Version 1.0 (the "License") and any subsequent  version 
thereof released by eBay.  The then-current version of the License can be found 
at http://www.opensource.org/licenses/cddl1.php and in the eBaySDKLicense file that 
is under the eBay SDK ../docs directory.
*/

package com.ebay.sdk.helper;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;

import com.ebay.sdk.helper.ui.ControlTagItem;
import com.ebay.soap.eBLBaseComponents.ShippingServiceCodeType;
import com.ebay.soap.eBLBaseComponents.ShippingTypeCodeType;
import com.ebay.soap.eBLBaseComponents.SiteCodeType;

/**
 * A helper class to retrieve the available ShippingServices for a given site.
 */
public class ShippingServiceHelper
{
  static Hashtable<Integer, ControlTagItem> _shippingServiceMap = new Hashtable<Integer, ControlTagItem>();
  static ShippingServiceHelper _shippingServiceHelper = new ShippingServiceHelper();

  // Service caches
  static Hashtable _domesShippingServices = new Hashtable();
  static Hashtable _intlShippingServices = new Hashtable();
  static Hashtable _shipToLocations = new Hashtable();

  static {
    // US
    _shippingServiceMap.put(new Integer(1), new ControlTagItem("Standard Flat Rate Shipping Service", ShippingServiceCodeType.SHIPPING_METHOD_STANDARD));
    _shippingServiceMap.put(new Integer(2), new ControlTagItem("Expedited shipping service", ShippingServiceCodeType.SHIPPING_METHOD_EXPRESS));
    _shippingServiceMap.put(new Integer(3), new ControlTagItem("UPS Ground", ShippingServiceCodeType.UPS_GROUND));
    _shippingServiceMap.put(new Integer(4), new ControlTagItem("UPS 3 Day Select", ShippingServiceCodeType.UPS_3_RD_DAY));
    _shippingServiceMap.put(new Integer(5), new ControlTagItem("UPS 2nd Day Air", ShippingServiceCodeType.UPS_2_ND_DAY));
    _shippingServiceMap.put(new Integer(6), new ControlTagItem("UPS Next Day Air Saver", ShippingServiceCodeType.UPS_NEXT_DAY));
    _shippingServiceMap.put(new Integer(7), new ControlTagItem("US Postal Service Priority Mail", ShippingServiceCodeType.USPS_PRIORITY));
    _shippingServiceMap.put(new Integer(8), new ControlTagItem("US Postal Service Parcel Post", ShippingServiceCodeType.USPS_PARCEL));
    _shippingServiceMap.put(new Integer(9), new ControlTagItem("US Postal Service Media Mail", ShippingServiceCodeType.USPS_MEDIA));
    _shippingServiceMap.put(new Integer(10), new ControlTagItem("US Postal Service First Class Mail", ShippingServiceCodeType.USPS_FIRST_CLASS));
    _shippingServiceMap.put(new Integer(11), new ControlTagItem("US Postal Service Express Mail", ShippingServiceCodeType.USPS_EXPRESS_MAIL));

    _shippingServiceMap.put(new Integer(50001), new ControlTagItem("Standard Int'l Flat Rate Shipping", ShippingServiceCodeType.STANDARD_INTERNATIONAL));
    _shippingServiceMap.put(new Integer(50002), new ControlTagItem("Expedited Int'l Flat Rate Shipping", ShippingServiceCodeType.EXPEDITED_INTERNATIONAL));
    _shippingServiceMap.put(new Integer(50003), new ControlTagItem("USPS Global Express Mail", ShippingServiceCodeType.USPS_GLOBAL_EXPRESS));
    _shippingServiceMap.put(new Integer(50004), new ControlTagItem("USPS Global Express Guaranteed", ShippingServiceCodeType.USPS_GLOBAL_EXPRESS_GUARANTEED));
    _shippingServiceMap.put(new Integer(50005), new ControlTagItem("USPS Global Priority Mail", ShippingServiceCodeType.USPS_GLOBAL_PRIORITY));
    _shippingServiceMap.put(new Integer(50006), new ControlTagItem("USPS Economy Parcel Post", ShippingServiceCodeType.USPS_ECONOMY_PARCEL));
    _shippingServiceMap.put(new Integer(50007), new ControlTagItem("USPS Economy Letter Post", ShippingServiceCodeType.USPS_ECONOMY_LETTER));
    _shippingServiceMap.put(new Integer(50008), new ControlTagItem("USPS Airmail Letter Post", ShippingServiceCodeType.USPS_AIRMAIL_LETTER));
    _shippingServiceMap.put(new Integer(50009), new ControlTagItem("USPS Airmail Parcel Post", ShippingServiceCodeType.USPS_AIRMAIL_PARCEL));
    _shippingServiceMap.put(new Integer(50010), new ControlTagItem("UPS Worldwide Express Plus", ShippingServiceCodeType.UPS_WORLD_WIDE_EXPRESS_PLUS));
    _shippingServiceMap.put(new Integer(50011), new ControlTagItem("UPS Worldwide Express", ShippingServiceCodeType.UPS_WORLD_WIDE_EXPRESS));
    _shippingServiceMap.put(new Integer(50012), new ControlTagItem("UPS Worldwide Expedited", ShippingServiceCodeType.UPS_WORLD_WIDE_EXPEDITED));
    _shippingServiceMap.put(new Integer(50013), new ControlTagItem("UPS Standard To Canada", ShippingServiceCodeType.UPS_STANDARD_TO_CANADA));
    _shippingServiceMap.put(new Integer(50014), new ControlTagItem("Other Int'l Shipping (see description)", ShippingServiceCodeType.OTHER_INTERNATIONAL));

    // CA
    _shippingServiceMap.put(new Integer(201), new ControlTagItem("Standard Delivery", ShippingServiceCodeType.CA_STANDARD_DELIVERY));
    _shippingServiceMap.put(new Integer(202), new ControlTagItem("Expedited Delivery", ShippingServiceCodeType.CA_EXPEDITED_DELIVERY));
    _shippingServiceMap.put(new Integer(203), new ControlTagItem("Canada Post Lettermail", ShippingServiceCodeType.CA_POST_LETTERMAIL));
    _shippingServiceMap.put(new Integer(204), new ControlTagItem("Canada Post Regular Parcel", ShippingServiceCodeType.CA_POST_REGULAR_PARCEL));
    _shippingServiceMap.put(new Integer(205), new ControlTagItem("Canada Post Expedited Parcel", ShippingServiceCodeType.CA_POST_EXPEDITED_PARCEL));
    _shippingServiceMap.put(new Integer(206), new ControlTagItem("Canada Post Xpresspost", ShippingServiceCodeType.CA_POST_XPRESSPOST));
    _shippingServiceMap.put(new Integer(207), new ControlTagItem("Canada Post Priority Courier", ShippingServiceCodeType.CA_POST_PRIORITY_COURIER));

    _shippingServiceMap.put(new Integer(50204), new ControlTagItem("Canada Post Expedited Parcel - USA", ShippingServiceCodeType.CA_POST_EXPEDITED_PARCEL));
    _shippingServiceMap.put(new Integer(50205), new ControlTagItem("Canada Post Small Packets - USA", ShippingServiceCodeType.CA_POST_SMALL_PACKETS_USA));
    _shippingServiceMap.put(new Integer(50206), new ControlTagItem("Canada Post Xpresspost - USA", ShippingServiceCodeType.CA_POST_XPRESSPOST_USA));
    _shippingServiceMap.put(new Integer(50207), new ControlTagItem("Canada Post Xpresspost - International", ShippingServiceCodeType.CA_POST_XPRESSPOST_INTERNATIONAL));
    _shippingServiceMap.put(new Integer(50208), new ControlTagItem("Canada Post International Parcel - Surface", ShippingServiceCodeType.CA_POST_INTERNATIONAL_PARCEL_SURFACE));
    _shippingServiceMap.put(new Integer(50209), new ControlTagItem("Canada Post International Parcel - Air", ShippingServiceCodeType.CA_POST_INTERNATIONAL_PARCEL_AIR));
    _shippingServiceMap.put(new Integer(50210), new ControlTagItem("Small Packets - International", ShippingServiceCodeType.CA_SMALL_PACKETS_INTERNATIONAL));
    _shippingServiceMap.put(new Integer(50211), new ControlTagItem("Purolator International", ShippingServiceCodeType.CA_PUROLATOR_INTERNATIONAL));

    // UK
    _shippingServiceMap.put(new Integer(301), new ControlTagItem("Royal Mail 1st Class Standard", ShippingServiceCodeType.UK_ROYAL_MAIL_FIRST_CLASS_STANDARD));
    _shippingServiceMap.put(new Integer(302), new ControlTagItem("Royal Mail 2nd Class Standard", ShippingServiceCodeType.UK_ROYAL_MAIL_SECOND_CLASS_STANDARD));

    _shippingServiceMap.put(new Integer(50301), new ControlTagItem("Sellers Standard International Rate", ShippingServiceCodeType.UK_SELLERS_STANDARD_INTERNATIONAL_RATE));
    _shippingServiceMap.put(new Integer(50302), new ControlTagItem("Royal Mail Airmail", ShippingServiceCodeType.UK_ROYAL_MAIL_AIRSURE_INTERNATIONAL));

    // Germany
    _shippingServiceMap.put(new Integer(7701), new ControlTagItem("Unversicherter Versand", ShippingServiceCodeType.DE_STANDARD_DISPATCH));
    _shippingServiceMap.put(new Integer(7702), new ControlTagItem("Versicherter Versand", ShippingServiceCodeType.DE_INSURED_DISPATCH));

    _shippingServiceMap.put(new Integer(57702), new ControlTagItem("Unversicherter Versand", ShippingServiceCodeType.DE_UNVERSICHERTER_VERSAND_INTERNATIONAL));
    _shippingServiceMap.put(new Integer(57703), new ControlTagItem("Versicherter Versand", ShippingServiceCodeType.DE_VERSICHERTER_VERSAND_INTERNATIONAL));
  }

  private ShippingServiceHelper() {
  }

  /**
   * Return an instance of ShippingServiceHelper.
   * @return ShippingServiceHelper
   */
  public static ShippingServiceHelper getInstance() {
    return _shippingServiceHelper;
  }

  /**
   * Return a map of the available domestic ShippingServices for a given site.
   * @param siteId SiteCodeType
   * @param shippingType ShippingTypeCodeType
   * @return Hashtable
   */
  public Hashtable getDomesticShippingServiceMap(SiteCodeType siteId, ShippingTypeCodeType shippingType)
  {
    Hashtable shippingServices = (Hashtable) _domesShippingServices.get(siteId);
    if (shippingServices == null) {
      Hashtable map = eBayDetailsHelper.getInstance().getDetailEntryMapWithIntValue(siteId, SHIPPING_SERVICE);
      shippingServices = new Hashtable();
      Enumeration keys = map.keys();
      while (keys.hasMoreElements()) {
        Object key = keys.nextElement();
        if (Integer.parseInt(key.toString()) < INTL_SHIPPING_SERVICE_MIN_ID) {
          Object entry = _shippingServiceMap.get(key);
          if (entry != null) {
            shippingServices.put(key, entry);
          }
        }
      }
      _domesShippingServices.put(siteId, shippingServices);
    }

    return shippingServices;
  }

  /**
   * Return a map of the available InternaltionalShippingServices for a given site.
   * @param siteId SiteCodeType
   * @param shippingType ShippingTypeCodeType
   * @return Hashtable
   */
  public Hashtable getInternalShippingServiceMap(SiteCodeType siteId, ShippingTypeCodeType shippingType)
  {
    Hashtable shippingServices = (Hashtable) _intlShippingServices.get(siteId);
    if (shippingServices == null) {
      Hashtable map = eBayDetailsHelper.getInstance().
          getDetailEntryMapWithIntValue(siteId, SHIPPING_SERVICE);
      shippingServices = new Hashtable();

      Enumeration keys = map.keys();
      while (keys.hasMoreElements()) {
        Object key = keys.nextElement();
        if (Integer.parseInt(key.toString()) >= INTL_SHIPPING_SERVICE_MIN_ID) {
          Object entry = _shippingServiceMap.get(key);
          if (entry != null) {
            shippingServices.put(key, entry);
          }
        }
      }
      _intlShippingServices.put(siteId, shippingServices);
    }

    return shippingServices;
  }

  /**
   * Return a map of all ShippingServices for a given site.
   * @param siteId SiteCodeType
   * @return Hashtable
   */
  public Hashtable getShippingServiceMap(SiteCodeType siteId)
  {
    return eBayDetailsHelper.getInstance().getDetailEntryMapWithIntValue(siteId, SHIPPING_SERVICE);
  }

  /**
   * Return a list of ShipToLocatios for a given site.
   * @param siteId SiteCodeType
   * @return ArrayList
   */
  private ArrayList getShipToLocationList(SiteCodeType siteId)
  {
    ArrayList list = (ArrayList) _shipToLocations.get(siteId);

    if (list == null) {
      list = new ArrayList();
      Hashtable map = getShipToLocationMap(siteId);
      if (map.size() > 0) {
        Enumeration keys = map.keys();
        while (keys.hasMoreElements()) {
          Object key = keys.nextElement();
          list.add(key);
        }
      }
      _shipToLocations.put(siteId, list);
    }
    return list;
  }

  /**
   * Reurn a map of the ShipToLocations for a given site.
   * @param siteId SiteCodeType
   * @return Hashtable
   */
  public Hashtable getShipToLocationMap(SiteCodeType siteId)
  {
    return eBayDetailsHelper.getInstance().getDetailEntryMapWithStringValue(siteId, SHIP_TO_LOCATION);
  }

  public static String CALCULATED_SHIPPING_METHODS = "CALCULATED_SHIPPING_METHODS";
  public static String FLAT_SHIPPING_METHODS = "FLAT_SHIPPING_METHODS";
  public static String INTL_CALCULATED_SHIPPING_SERVICES = "INTL_CALCULATED_SHIPPING_SERVICES";
  public static String INTL_FLATRATE_SHIPPING_SERVICES = "INTL_FLATRATE_SHIPPING_SERVICES";

  public static String SHIPPING_SERVICE = "ShippingService";
  public static String SHIP_TO_LOCATION = "ShipToLocation";

  // ID to distinguish an internal shipping service from a domestic one.
  private static int INTL_SHIPPING_SERVICE_MIN_ID = 50000;
}
