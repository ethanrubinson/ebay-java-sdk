/*
Copyright (c) 2013 eBay, Inc.
This program is licensed under the terms of the eBay Common Development and
Distribution License (CDDL) Version 1.0 (the "License") and any subsequent  version 
thereof released by eBay.  The then-current version of the License can be found 
at http://www.opensource.org/licenses/cddl1.php and in the eBaySDKLicense file that 
is under the eBay SDK ../docs directory.
*/

package com.ebay.sdk.helper.ui;

public class ControlTagItem
{
  public ControlTagItem(String text, Object tag) {
    this.Text = text;
    this.Tag = tag;
  }

  public String Text;
  public Object Tag;

  public String toString() {
    return this.Text;
  }
}
