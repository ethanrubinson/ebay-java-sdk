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
 * Defines an eBay API account object.
 * 
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: eBay Inc.</p>
 * @author Weijun Li
 * @version 1.0
 */

public class ApiAccount {
  private String developer;
  private String application;
  private String certificate;

  /**
   * Constructor.
   */
  public ApiAccount() {
  }

  /**
   * Get the Developer ID (DevID).
   * @return	The Developer ID.
   */
  public String getDeveloper() {
    return this.developer;
  }

  /**
   * Set the Developer ID (DevID).
   * @param developer	The Developer ID to set.
   */
  public void setDeveloper(String developer) {
    this.developer = developer;
  }

  /**
   * Get the Application ID (AppID).
   * @return 	The Application ID.
   */
  public String getApplication() {
    return this.application;
  }

  /**
   * Set the Application ID (AppID).
   * @param application 	The Application ID.
   */
  public void setApplication(String application) {
    this.application = application;
  }

  /**
   * Get the Certificate ID (CertID).
   * @return 	The Certificate ID.
   */
  public String getCertificate() {
    return this.certificate;
  }

  /**
   * Set the Certificate ID (CertID)
   * @param certificate	The Certificate ID.
   */
  public void setCertificate(String certificate) {
    this.certificate = certificate;
  }

}
