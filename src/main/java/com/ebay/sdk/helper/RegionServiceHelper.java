/*
Copyright (c) 2013 eBay, Inc.
This program is licensed under the terms of the eBay Common Development and
Distribution License (CDDL) Version 1.0 (the "License") and any subsequent  version 
thereof released by eBay.  The then-current version of the License can be found 
at http://www.opensource.org/licenses/cddl1.php and in the eBaySDKLicense file that 
is under the eBay SDK ../docs directory.
*/

package com.ebay.sdk.helper;

import java.util.*;
import com.ebay.soap.eBLBaseComponents.*;
import com.ebay.sdk.helper.ui.*;

/**
 * A helper class to retrieve the available search locations/regions for a given site.
 */
public class RegionServiceHelper {

  static Hashtable _regionServiceMap = new Hashtable();
  static RegionServiceHelper _regionServiceHelper = new RegionServiceHelper();

  /**
   * Return an instance of RegionServiceHelper.
   * @return RegionServiceHelper
   */
  public static RegionServiceHelper getInstanace()
  {
    return _regionServiceHelper;
  }

  private RegionServiceHelper() {
  }

  /**
   * Return a map of the available search locations/regions for a given site.
   * @param siteId SiteCodeType
   * @return Hashtable
   */
  public Hashtable getRegionsMap(SiteCodeType siteId)
  {
    Hashtable regionsMap = (Hashtable) _regionServiceMap.get(siteId);
    if (regionsMap == null) {
      Hashtable map = eBayDetailsHelper.getInstance().getDetailEntryMapWithIntValue(siteId, REGION);
      if (map != null) {
        _regionServiceMap.put(siteId, map);
        int size = map.size();
        if (size > 0) {
          regionsMap = new Hashtable();
          Enumeration keys = map.keys();
          while (keys.hasMoreElements()) {
            Object key = keys.nextElement();
            Object entry = map.get(key);
            regionsMap.put(key, new ControlTagItem(entry.toString(), key));
          }
        }
        _regionServiceMap.put(siteId, regionsMap);
      }
    }
    return regionsMap;
  }

  private static String REGION = "Region";
}
