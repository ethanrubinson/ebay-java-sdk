/*
Copyright (c) 2013 eBay, Inc.
This program is licensed under the terms of the eBay Common Development and
Distribution License (CDDL) Version 1.0 (the "License") and any subsequent  version 
thereof released by eBay.  The then-current version of the License can be found 
at http://www.opensource.org/licenses/cddl1.php and in the eBaySDKLicense file that 
is under the eBay SDK ../docs directory.
*/

package com.ebay.sdk;

import com.ebay.soap.eBLBaseComponents.*;

/**
 * Utility class the converts between SiteCodeType and eBay numerical Site ID.
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: eBay Inc.</p>
 * @author Weijun Li
 * @version 1.0
 */
public class SiteIDUtil {

  static final java.util.HashMap<SiteCodeType, Integer> siteMap;

  static {
    siteMap = new java.util.HashMap<SiteCodeType, Integer>();

    siteMap.put(SiteCodeType.US, new Integer(0));
    siteMap.put(SiteCodeType.AUSTRALIA, new Integer(15));
    siteMap.put(SiteCodeType.AUSTRIA, new Integer(16));
    siteMap.put(SiteCodeType.BELGIUM_DUTCH, new Integer(123));
    siteMap.put(SiteCodeType.BELGIUM_FRENCH, new Integer(23));

    siteMap.put(SiteCodeType.CANADA, new Integer(2));
    siteMap.put(SiteCodeType.CHINA, new Integer(223));
    siteMap.put(SiteCodeType.E_BAY_MOTORS, new Integer(100));
    siteMap.put(SiteCodeType.FRANCE, new Integer(71));
    siteMap.put(SiteCodeType.GERMANY, new Integer(77));

    siteMap.put(SiteCodeType.HONG_KONG, new Integer(201));  
    siteMap.put(SiteCodeType.INDIA, new Integer(203));
    siteMap.put(SiteCodeType.ITALY, new Integer(101));
    siteMap.put(SiteCodeType.MALAYSIA, new Integer(207));
    siteMap.put(SiteCodeType.NETHERLANDS, new Integer(146));
    siteMap.put(SiteCodeType.SINGAPORE, new Integer(216));  
    siteMap.put(SiteCodeType.SPAIN, new Integer(186));

    siteMap.put(SiteCodeType.SWITZERLAND, new Integer(193));

    siteMap.put(SiteCodeType.TAIWAN, new Integer(196));

    siteMap.put(SiteCodeType.UK, new Integer(3));
    siteMap.put(SiteCodeType.CUSTOM_CODE, new Integer(-1));



    siteMap.put(SiteCodeType.PHILIPPINES, new Integer(211));
    siteMap.put(SiteCodeType.POLAND, new Integer(212));
    siteMap.put(SiteCodeType.SWEDEN, new Integer(218));
    siteMap.put(SiteCodeType.IRELAND, new Integer(205));
    siteMap.put(SiteCodeType.CANADA_FRENCH, new Integer(210));
  }

  /**
   * Converts eBay site ID to SiteCodeType.
   * @param siteID int
   * @return SiteCodeType
   */
  public static SiteCodeType fromNumericalID(int siteID)
  {
    Object[] maps = siteMap.entrySet().toArray();
    for( int i = 0; i < maps.length; i ++ )
    {
      java.util.Map.Entry<SiteCodeType, Integer> entry = (java.util.Map.Entry<SiteCodeType, Integer>)maps[i];
      if( ((Integer)entry.getValue()).intValue() == siteID )
        return (SiteCodeType)entry.getKey();
    }
    return SiteCodeType.CUSTOM_CODE;
  }

  /**
   * Convers SiteCodeType to eBay numerical site ID.
   * @param siteID SiteCodeType
   * @return int
   */
  public static int toNumericalID(SiteCodeType siteID)
  {
    return ((Integer)siteMap.get(siteID)).intValue();
  }
}
