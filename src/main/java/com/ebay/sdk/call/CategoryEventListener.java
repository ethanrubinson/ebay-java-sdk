/*
Copyright (c) 2007 eBay, Inc.

This program is licensed under the terms of the eBay Common Development and
Distribution License (CDDL) Version 1.0 (the "License") and any subsequent
version thereof released by eBay.  The then-current version of the License
can be found at https://www.codebase.ebay.com/Licenses.html and in the
eBaySDKLicense file that is under the eBay SDK install directory.
*/

package com.ebay.sdk.call;

import com.ebay.soap.eBLBaseComponents.*;

/**
 * Listner interface to handle category related events.
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: eBay Inc.</p>
 * @author Weijun Li
 * @version 1.0
 */
public interface CategoryEventListener extends java.util.EventListener {

  /**
   * Handler to receive downloaded (e.g., through eBay API) or
   * loaded (e.g., from database) categories.
   * @param siteID SiteCodeType The eBay site associated with the categories.
   * @param categories CategoryType[] The received categories.
   * @param categoryVersion String Version of the received categories.
   * @throws Exception
   */
  void receivedCategories(SiteCodeType siteID, CategoryType[] categories, String categoryVersion)
      throws Exception;
}
