/*
Copyright (c) 2013 eBay, Inc.
This program is licensed under the terms of the eBay Common Development and
Distribution License (CDDL) Version 1.0 (the "License") and any subsequent  version 
thereof released by eBay.  The then-current version of the License can be found 
at http://www.opensource.org/licenses/cddl1.php and in the eBaySDKLicense file that 
is under the eBay SDK ../docs directory.
*/

package com.ebay.sdk.helper;

import com.ebay.sdk.helper.ui.ControlTagItem;
import com.ebay.soap.eBLBaseComponents.ShippingServiceOptionsType;
import com.ebay.soap.eBLBaseComponents.ShippingTypeCodeType;

/**
 * A helper class for domestic ShippingServiceOption selection.
 */
public class ShippingServiceSelector {
  boolean hasSelection;

  ShippingTypeCodeType shippingType;
  ShippingServiceOptionsType shippingServiceOption;
  ShippingServiceOptionsType selectedShippingServiceOption;
  ControlTagItem[] ctrlShippingServices;

  /**
   * Constructor
   * @param shippingType ShippingTypeCodeType
   * @param shippingServiceOption ShippingServiceOptionsType
   * @param ctrlShippingServices ControlTagItem[]
   */
  public ShippingServiceSelector(ShippingTypeCodeType shippingType,
  ShippingServiceOptionsType shippingServiceOption,
  ControlTagItem[] ctrlShippingServices)
  {
    this.shippingType = shippingType;
    this.shippingServiceOption = shippingServiceOption;
    this.ctrlShippingServices = ctrlShippingServices;
  }

  /**
   * Return a list of ShippingServiceOptions available in the ShippingServiceSelector.
   * @return ControlTagItem[]
   */
  public ControlTagItem[] getCtrlShippingServices()
  {
    return this.ctrlShippingServices;
  }

  /**
   * Return the ShippingServiceOption in the ShippingServiceSelector.
   * @return ShippingServiceOptionsType
   */
  public ShippingServiceOptionsType getShippingServiceOption()
  {
    return this.shippingServiceOption;
  }

  /**
   * Return the selected ShippingService in the ShipppingServiceSelector.
   * @return ShippingServiceOptionsType
   */
  public ShippingServiceOptionsType getSelectedShippingServiceOption()
  {
    return this.selectedShippingServiceOption;
  }

  /**
   * Return the ShippingType of the ShippingServiceSelector.
   * @return ShippingTypeCodeType
   */
  public ShippingTypeCodeType getShippingType()
  {
    return this.shippingType;
  }

  /**
   * Set the ControlTagItems of available ShippingServiceOptions.
   * @param ctrlShippingServices ControlTagItem[]
   */
  public void setCtrlShippingServices(ControlTagItem[] ctrlShippingServices)
  {
    this.ctrlShippingServices = ctrlShippingServices;
  }

  /**
   * Set the selected ShippingServiceOption
   * @param option ShippingServiceOptionsType
   */
  public void setSelectedShippingServiceOption(ShippingServiceOptionsType option)
  {
    this.selectedShippingServiceOption = option;
  }

  /**
   * Set the ShippingServiceOption
   * @param shippingServiceOption ShippingServiceOptionsType
   */
  public void setShippingServiceOption(ShippingServiceOptionsType shippingServiceOption)
  {
    this.shippingServiceOption = shippingServiceOption;
  }

  /**
   * Set the ShippingType
   * @param shippingType ShippingTypeCodeType
   */
  public void setShippingType(ShippingTypeCodeType shippingType)
  {
    this.shippingType = shippingType;
  }
}
