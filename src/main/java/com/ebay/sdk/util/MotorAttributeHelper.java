/*
Copyright (c) 2013 eBay, Inc.
This program is licensed under the terms of the eBay Common Development and
Distribution License (CDDL) Version 1.0 (the "License") and any subsequent  version 
thereof released by eBay.  The then-current version of the License can be found 
at http://www.opensource.org/licenses/cddl1.php and in the eBaySDKLicense file that 
is under the eBay SDK ../docs directory.
*/

package com.ebay.sdk.util;

import com.ebay.soap.eBLBaseComponents.AttributeSetType;

/**
 * Helper class to work on motor attributes.
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: eBay Inc.</p>
 * @author Weijun Li
 * @version 1.0
 */
public class MotorAttributeHelper {
	
  public MotorAttributeHelper() {
  }

  private AttributeSetType mSet;

  /**
   * ID of Subtitle attribute.
   */
  public final int ID_SUBTITLE = 10246;

  /**
   * ID of DepositAmount attribute.
   */
  public final int ID_DEPOSITAMOUNT = 10733;

  /**
   * ID of DepositType attribute.
   */
  public final int ID_DEPOSITTYPE = 10734;

  /**
   * Constructor.
   * @param ast AttributeSetType The object that contains the motor attributes that you want to access.
   */
  public MotorAttributeHelper(AttributeSetType ast) {
    mSet = ast;
  }

  public AttributeSetType getAttributeSet() {
	  return mSet;
  }
  
  /**
   * Gets motor subtitle.
   * @return String
   */
  public String getSubtitle() {
    return AttributeHelper.getValueLiteral(mSet, ID_SUBTITLE);
  }

  /**
   * Sets motor subtitle. Setting null string will remove Subtitle from the attribute list.
   * @param subTitle String
   */
  public void setSubtitle(String subTitle) {
    if( subTitle == null || subTitle.length() == 0 ) {
      AttributeHelper.removeAttribute(mSet, ID_SUBTITLE);
	} else {
      AttributeHelper.insertToAttributeSet(mSet, ID_SUBTITLE, 0, subTitle);
	}
  }

  /**
   * Gets the DepositAmount.
   * @return double
   */
  public double getDepositAmount() {
      String t = AttributeHelper.getValueLiteral(mSet, ID_DEPOSITAMOUNT);
      if( t != null && t.length() > 0 ) {
        return Double.parseDouble(t);
      } else {
        return 0.0;
      }
  }

  /**
   * Sets the DepositAmount. Setting 0.0 will remove DepositType and DepositAmount from the attribute list.
   * @param depositAmount double
   */
  public void setDepositAmount(double depositAmount)
  {
    if( depositAmount == 0.0 )  {
      AttributeHelper.removeAttribute(mSet, ID_DEPOSITTYPE);
      AttributeHelper.removeAttribute(mSet, ID_DEPOSITAMOUNT);
    } else {
      AttributeHelper.insertToAttributeSet(mSet, ID_DEPOSITAMOUNT, 0, new Double(depositAmount).toString());
      AttributeHelper.insertToAttributeSet(mSet, ID_DEPOSITTYPE, 0, "1");
    }
  }

}
