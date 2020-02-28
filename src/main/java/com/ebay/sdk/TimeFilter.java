/*
Copyright (c) 2013 eBay, Inc.
This program is licensed under the terms of the eBay Common Development and
Distribution License (CDDL) Version 1.0 (the "License") and any subsequent  version 
thereof released by eBay.  The then-current version of the License can be found 
at http://www.opensource.org/licenses/cddl1.php and in the eBaySDKLicense file that 
is under the eBay SDK ../docs directory.
*/

package com.ebay.sdk;

/**
 *
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: eBay Inc.</p>
 * @author Weijun Li
 * @version 1.0
 */
public class TimeFilter {

  private java.util.Calendar timeFrom;
  private java.util.Calendar timeTo;

  /**
   *
   * @param timeFrom Calendar
   * @param timeTo Calendar
   */
  public TimeFilter(java.util.Calendar timeFrom, java.util.Calendar timeTo) {
    this.timeFrom = timeFrom;
    this.timeTo = timeTo;
  }

  /**
   *
   * @param timeTo Calendar
   */
  public void setTimeTo(java.util.Calendar timeTo) {
    this.timeTo = timeTo;
  }

  /**
   *
   * @return Calendar
   */
  public java.util.Calendar getTimeTo() {
    return timeTo;
  }

  /**
   *
   * @param timeFrom Calendar
   */
  public void setTimeFrom(java.util.Calendar timeFrom) {
    this.timeFrom = timeFrom;
  }

  /**
   *
   * @return Calendar
   */
  public java.util.Calendar getTimeFrom() {
    return timeFrom;
  }
}
