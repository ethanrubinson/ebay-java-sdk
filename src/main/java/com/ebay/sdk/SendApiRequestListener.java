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
 * Listner for sending API SOAP request event.
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: eBay Inc.</p>
 * @author Weijun Li
 * @version 1.0
 */
public interface SendApiRequestListener extends java.util.EventListener {

  /**
   * Filter the request object that will be sent to eBay server. The method
   * may make changes to the request object.import com.ebay.soap.eBLBaseComponents.*;
   * @param request AbstractRequestType The request object to be sent.
   * @throws SdkException
   */
  void FilterApiRequest(AbstractRequestType request) throws com.ebay.sdk.SdkException;
}
