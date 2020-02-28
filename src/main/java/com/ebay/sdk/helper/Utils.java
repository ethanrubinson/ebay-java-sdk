/*
Copyright (c) 2013 eBay, Inc.
This program is licensed under the terms of the eBay Common Development and
Distribution License (CDDL) Version 1.0 (the "License") and any subsequent  version 
thereof released by eBay.  The then-current version of the License can be found 
at http://www.opensource.org/licenses/cddl1.php and in the eBaySDKLicense file that 
is under the eBay SDK ../docs directory.
*/

package com.ebay.sdk.helper;

import com.ebay.soap.eBLBaseComponents.AmountType;

public class Utils {

  /**
   *
   * @param b Boolean
   * @return String
   */
  public static String booleanToYesNo(Boolean b)
  {
    if (b == null)
      return "";
    return b.booleanValue() ? "Yes" : "No";
  }

  /**
   *
   * @param s String
   * @return String
   */
  public static String getDispString(String s) {
    return s == null ? "" : s;
  }

  /**
   *
   * @param amt AmountType
   * @return String
   */
  public static String amountToString(AmountType amt) {
    if (amt == null) {
    	return "N/A";
    }
    return new Double(amt.getValue()).toString();
  }
  
  public static String stripCDATA(String cdataString) {
	  final String CDATA_START = "<![CDATA[";
	  final String CDATA_END = "]]>";
	  
	  if(cdataString == null || cdataString.length() == 0) {
		  return "";
	  }
	  int index1 = cdataString.indexOf(CDATA_START);
	  if(index1 == -1) {
		  return cdataString;
	  }
	  int index2 = cdataString.indexOf(CDATA_END);
	  if(index2 == -1) {
		  return cdataString.substring(CDATA_START.length());
	  } else {
		  return cdataString.substring(CDATA_START.length(), index2);
	  }
  }
}
