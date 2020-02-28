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
 * Defines eBay auction account.
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: </p>
 * @author Weijun Li
 * @version 1.0
 */

public class eBayAccount {
  private String username;
  private String password;

  /**
   * Constructor.
   */
  public eBayAccount() {
  }

  public eBayAccount(String userName, String password) {
  	this.username = userName;
  	this.password = password;
  }

  /**
   * Get eBay user Id.
   * @return eBay User Id string.
   */
  public String getUsername() {
    return this.username;
  }

  /**
   * Set eBay user Id.
   * @param username String
   */
  public void setUsername(String username) {
    this.username = username;
  }

  /**
   * Get the password of the eBay account.
   * @return the password string.
   */
  public String getPassword() {
    return this.password;
  }

  /**
   * Set the password of the eBay account.
   * @param password the password string.
   */
  public void setPassword(String password) {
    this.password = password;
  }
}
