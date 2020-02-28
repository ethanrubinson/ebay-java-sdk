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

import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import com.ebay.sdk.helper.ui.ControlTagItem;
import com.ebay.sdk.helper.ui.JIDCheckBox;
import com.ebay.soap.eBLBaseComponents.AmountType;
import com.ebay.soap.eBLBaseComponents.BuyerPaymentMethodCodeType;
import com.ebay.soap.eBLBaseComponents.CurrencyCodeType;
import com.ebay.soap.eBLBaseComponents.InternationalShippingServiceOptionsType;
import com.ebay.soap.eBLBaseComponents.ShippingDetailsType;
import com.ebay.soap.eBLBaseComponents.ShippingServiceCodeType;
import com.ebay.soap.eBLBaseComponents.ShippingServiceOptionsType;
import com.ebay.soap.eBLBaseComponents.ShippingTypeCodeType;
import com.ebay.soap.eBLBaseComponents.SiteCodeType;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: eBay Inc.</p>
 * @author not attributable
 * @version 1.0
 */

public class ServiceControlManager {

  static ServiceControlManager _serviceControlManager = new ServiceControlManager();

  private ServiceControlManager() {
  }

  public static ServiceControlManager getInstance()
  {
    return _serviceControlManager;
  }

  public ControlTagItem[] createPaymentServiceControl(SiteCodeType siteId, boolean addDefaultOption)
  {
    Hashtable map = PaymentServiceHelper.getInstance().getPaymentServiceMap(siteId);

    int size = map.size();
    int addition = addDefaultOption ? 1 : 0;

    ControlTagItem[] ctrlServices = new ControlTagItem[size + addition];
    if (addDefaultOption) {
      ctrlServices[0] = new ControlTagItem("None", "None");
    }

    Enumeration keys = map.keys();
    int cnt = 0;
    while (keys.hasMoreElements()) {
      Object key = keys.nextElement();
      ctrlServices[addition + cnt++] = (ControlTagItem)map.get(key);
    }

    return ctrlServices;
  }

  public ControlTagItem[] createPaymentServiceControl(SiteCodeType site, JComboBox cbxControl, boolean addDefaultOption)
  {
    ControlTagItem[] ctrlServices = createPaymentServiceControl(site, addDefaultOption);
    ComboBoxModel dataModel = new DefaultComboBoxModel(ctrlServices);
    cbxControl.setModel(dataModel);
    cbxControl.setSelectedIndex(0);
    return ctrlServices;
  }

  public ControlTagItem[] createRegionServiceControl(SiteCodeType siteId, boolean addDefaultOption)
  {
    Hashtable map = RegionServiceHelper.getInstanace().getRegionsMap(siteId);

    int size = map.size();
    int addition = addDefaultOption ? 1 : 0;

    ControlTagItem[] ctrlServices = new ControlTagItem[size + addition];
    if (addDefaultOption) {
      ctrlServices[0] = new ControlTagItem("None", "None");
    }

    Enumeration keys = map.keys();
    int cnt = 0;
    while (keys.hasMoreElements()) {
      Object key = keys.nextElement();
      ctrlServices[addition + cnt++] = (ControlTagItem)map.get(key);
    }

    return ctrlServices;
  }

  public ControlTagItem[] createShippingServiceControl(SiteCodeType siteId, String shippingType, boolean addDefaultOption)
  {
    Hashtable map = null;
    if (ShippingServiceHelper.FLAT_SHIPPING_METHODS.equals(shippingType)) {
      map = ShippingServiceHelper.getInstance().getDomesticShippingServiceMap(siteId, ShippingTypeCodeType.FLAT);
    } else if(ShippingServiceHelper.CALCULATED_SHIPPING_METHODS.equals(shippingType)) {
      map = ShippingServiceHelper.getInstance().getDomesticShippingServiceMap(siteId, ShippingTypeCodeType.CALCULATED);
    }else if (ShippingServiceHelper.INTL_FLATRATE_SHIPPING_SERVICES.equals(shippingType)){
      map = ShippingServiceHelper.getInstance().getInternalShippingServiceMap(siteId, ShippingTypeCodeType.FLAT);
    } else {
      map = ShippingServiceHelper.getInstance().getInternalShippingServiceMap(siteId, ShippingTypeCodeType.CALCULATED);
    }

    int size = map.size();
    int addition = addDefaultOption ? 1 : 0;

    ControlTagItem[] ctrlServices = new ControlTagItem[size + addition];
    ctrlServices[0] = new ControlTagItem("None", "None");

    Enumeration keys = map.keys();
    int cnt = 0;
    while (keys.hasMoreElements()) {
      Object key = keys.nextElement();
      ctrlServices[addition + cnt++] = (ControlTagItem)map.get(key);
    }

    return ctrlServices;
  }

  public ControlTagItem[] createShippingServiceControl(SiteCodeType site, String shippingType, JComboBox cbxControl,  boolean addDefaultOption)
  {
    ControlTagItem[] ctrlServices = createShippingServiceControl(site, shippingType, addDefaultOption);
    ComboBoxModel dataModel = new DefaultComboBoxModel(ctrlServices);
    cbxControl.setModel(dataModel);
    cbxControl.setSelectedIndex(0);
    return ctrlServices;
  }

  // Process service info
  public BuyerPaymentMethodCodeType[] processUserPaymentMethods(
      JCheckBox[] ckbPaymentServices, ControlTagItem[] ctrlPaymentServices)
  {
    BuyerPaymentMethodCodeType[] arrPaymentMethods = null;

    int cnt = ckbPaymentServices.length;
    if (cnt > 0) {
      ArrayList lstPayments = new ArrayList();
      for (int i = 0; i < cnt; i++) {
        if (ckbPaymentServices[i].isSelected()) {
          lstPayments.add(ctrlPaymentServices[i].Tag);
        }
      }
      cnt = lstPayments.size();
      if (cnt > 0) {
        arrPaymentMethods = new BuyerPaymentMethodCodeType[cnt];
        for (int i = 0; i < cnt; i++) {
          arrPaymentMethods[i] = (BuyerPaymentMethodCodeType) lstPayments.get(i);
        }
      }
    }

    return arrPaymentMethods;
  }

  public ShippingServiceOptionsType processUserSelectedShippingService(
      CurrencyCodeType currencyId,
      JComboBox cbxShippingServiceSelected,
      ControlTagItem[] ctrlShippingServices,
      JComboBox cbxIntlShippingServiceSelected,
      ControlTagItem[] ctrlIntlShippingServices,
      JTextField  txtShippingServiceSelectedCost)
  {
    ShippingServiceOptionsType shippingServiceOptionsType = null;

    ShippingServiceCodeType selectedShippingService = null;
    int idx = cbxShippingServiceSelected.getSelectedIndex();
    if (idx > 0) {
      selectedShippingService = (ShippingServiceCodeType)ctrlShippingServices[idx].Tag;
    }
    else {
      idx = cbxIntlShippingServiceSelected.getSelectedIndex();
      if (idx > 0) {
        selectedShippingService = (ShippingServiceCodeType)ctrlIntlShippingServices[idx].Tag;
      }
    }

    if (selectedShippingService != null) {
      shippingServiceOptionsType = new ShippingServiceOptionsType();
      shippingServiceOptionsType.setShippingService(selectedShippingService.value());
      String cost = txtShippingServiceSelectedCost.getText();
      if (cost != null && cost.length() > 0) {
        AmountType shippingServiceSelectedCost = new AmountType();
        shippingServiceSelectedCost.setValue(Double.parseDouble(cost));
        shippingServiceSelectedCost.setCurrencyID(currencyId);
        shippingServiceOptionsType.setShippingServiceCost(shippingServiceSelectedCost);
      }
    }

    return shippingServiceOptionsType;
  }

  public ShippingDetailsType processUserShippingDetails(
      ArrayList shippingServiceOptions, ArrayList intlShippingServiceOptions)
  {
    ShippingDetailsType shippingDetails = new ShippingDetailsType();
    int cnt = shippingServiceOptions.size();
    if (cnt > 0) {
      ShippingServiceOptionsType [] sso = new ShippingServiceOptionsType[cnt];
      for (int i = 0; i < cnt; i++) {
        sso[i] = ((ShippingServiceSelector)shippingServiceOptions.get(i)).getSelectedShippingServiceOption();
      }
      shippingDetails.setShippingServiceOptions(sso);
    }

    cnt = intlShippingServiceOptions.size();
    if (cnt > 0) {
      InternationalShippingServiceOptionsType [] sso = new InternationalShippingServiceOptionsType[cnt];
      for (int i = 0; i < cnt; i++) {
        sso[i] = ((InternationalShippingServiceSelector)intlShippingServiceOptions.get(i)).getSelectedShippingServiceOption();
      }
      shippingDetails.setInternationalShippingServiceOption(sso);
    }
    return shippingDetails;
  }

  String stringArrayToString(String[] strArray, String separator)
  {
    String ret = null;
    int cnt = strArray != null ? strArray.length : 0;
    if (cnt > 0) {
      ret = strArray[0];
      for (int j = 1; j < cnt; j++) {
        ret += separator + strArray[j];
      }
    }
    return ret;
  }

  public ArrayList getSelectedCheckBoxList(JCheckBox[] checkBoxes) {
    ArrayList list = new ArrayList();
    int cnt = checkBoxes != null ? checkBoxes.length : 0;
    for (int i = 0; i < cnt; i++) {
      JCheckBox chkBox = checkBoxes[i];
      if (chkBox.isSelected()) {
        if (chkBox instanceof JIDCheckBox) {
          list.add(((JIDCheckBox)chkBox).getId());
        }
        else {
          list.add(chkBox.getText());
        }
      }
    }
    return list;
  }

  public void updateShippingServiceSelections(
      ArrayList shippingServiceOptions,
      JScrollPane spShippingServiceOptions,
      JButton btnRemoveShippingService,
      JButton btnAddShippingService)
  {
    String[] columnNames = {"Priority", "ShippingService", "Cost", "AdditionalCost"};
    int size = shippingServiceOptions.size();
    Object[] [] dataTable = new Object [size][4];
    for (int i = 0; i < size; i++) {
      ShippingServiceSelector selector = (ShippingServiceSelector)shippingServiceOptions.get(i);
      ShippingServiceOptionsType ssot = selector.getSelectedShippingServiceOption();
      dataTable[i][0] = new Integer(i+1).toString();
      dataTable[i][1] = ssot.getShippingService().toString();
      AmountType cost = ssot.getShippingServiceCost();
      String sCost = " ";
      if (cost != null) {
        sCost = cost.getValue() + "";
      }
      dataTable[i][2] = sCost;
      cost = ssot.getShippingServiceAdditionalCost();
      if (cost != null) {
        sCost = cost.getValue() + "";
      }
      else {
        sCost = " ";
      }
      dataTable[i][3] = sCost;
    }
    JTable jTable = new JTable(dataTable, columnNames);
    jTable.setEnabled(false);
    spShippingServiceOptions.getViewport().add(jTable, null);

    if (btnRemoveShippingService != null) {
      btnRemoveShippingService.setEnabled(size > 0);
    }
    if (btnAddShippingService != null) {
      btnAddShippingService.setEnabled(size < 3);
    }
  }

  public void updateIntlShippingServiceSelections(
      ArrayList intlShippingServiceOptions,
      JScrollPane spIntlShippingServiceOptions,
      JButton btnRemoveIntlShippingService,
      JButton btnAddIntlShippingService)
  {
    String[] columnNames = {"Priority", "ShippingService", "Cost", "AdditionalCost", "ShipToLocations"};
    int size = intlShippingServiceOptions.size();
    Object[] [] dataTable = dataTable = new Object[size][5];
    for (int i = 0; i < size; i++) {
      InternationalShippingServiceSelector selector = (InternationalShippingServiceSelector)intlShippingServiceOptions.get(i);
      InternationalShippingServiceOptionsType sso = selector.getSelectedShippingServiceOption();
      dataTable[i][0] = new Integer(i+1).toString();
      dataTable[i][1] = sso.getShippingService().toString();
      AmountType cost = sso.getShippingServiceCost();
      String sCost = " ";
      if (cost != null) {
        sCost = cost.getValue() + "";
      }
      dataTable[i][2] = sCost;
      cost = sso.getShippingServiceAdditionalCost();
      if (cost != null) {
        sCost = cost.getValue() + "";
      }
      else {
        sCost = " ";
      }
      dataTable[i][3] = sCost;

      String sShipToLocations = "";
      String[] arrShipToLocations = sso.getShipToLocation();
      int cnt = arrShipToLocations != null ? arrShipToLocations.length : 0;
      if (cnt > 0) {
        sShipToLocations = arrShipToLocations[0];
        for (int j = 1; j < cnt; j++) {
          sShipToLocations += ";" + arrShipToLocations[j];
        }
      }
      dataTable[i][4] = sShipToLocations;
    }

    JTable jTable = new JTable(dataTable, columnNames);
    jTable.setEnabled(false);
    spIntlShippingServiceOptions.getViewport().add(jTable, null);

    if (btnRemoveIntlShippingService != null) {
      btnRemoveIntlShippingService.setEnabled(size > 0);
    }
    if (btnAddIntlShippingService != null) {
      btnAddIntlShippingService.setEnabled(size < 3);
    }
  }
}
