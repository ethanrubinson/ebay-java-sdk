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
 * Listener to handle token events such as soft-expiration-renew and hard-expiration-warning.
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: eBay Inc.</p>
 * @author Weijun Li
 * @version 1.0
 */
public interface TokenEventListener extends java.util.EventListener {

  /**
   * Called when a new token is returned from eBay to replace the current one.
   * @param newToken String The new token returned from eBay server.
   */
  void renewToken(String newToken);

  /**
   * Called when a hard expiration warning was received for the token that
  *  you are using.
   * @param expirationDate Date
   */
  void warnHardExpiration(java.util.Date expirationDate);
}
