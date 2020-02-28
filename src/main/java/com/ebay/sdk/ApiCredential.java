/*
Copyright (c) 2017 eBay, Inc.
This program is licensed under the terms of the eBay Common Development and 
Distribution License (CDDL) Version 1.0 (the "License") and any subsequent 
version thereof released by eBay.  The then-current version of the License 
can be found at https://www.codebase.ebay.com/Licenses.html and in the 
eBaySDKLicense file that is under the eBay SDK install directory.
*/

package com.ebay.sdk;

import javax.swing.event.*;

/**
 * Defines credentials to be used for making eBay API call. Set either
 * eBay token (seteBayToken()) or ApiAccount plus eBayAccount since
 * they are exclusive to each other.
 * <br>
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: eBay Inc.</p>
 * @author Weijun Li
 * @version 1.0
 */
public class ApiCredential {

  private ApiAccount apiAccount = new ApiAccount();
  private eBayAccount ebayAccount = new eBayAccount();
  private String eBayToken = "";
 //setting OAuthToken 02/17/2017 
  private String oAuthToken ="";

  protected EventListenerList listenerList = new EventListenerList();

  /**
   * Add listener for token renewal event.
   * @param l TokenEventListener
   */
  public void addTokenEventListener(TokenEventListener l) {
    if( l != null )
      listenerList.add(TokenEventListener.class, l);
  }

  /**
   * Remove listener for token renewal event.
   * @param l TokenEventListener
   */
  public void removeTokenEventListener(TokenEventListener l) {
    if( l != null )
      listenerList.remove(TokenEventListener.class, l);
  }

  /**
   * Called by ApiCall class when a new token is returned through the response
   * of API call.
   * @param newToken String
   */
  public void fireRenewTokenEvent(String newToken) {
    TokenEventListener[] ls = (TokenEventListener[])this.listenerList.getListeners(TokenEventListener.class);
    if( ls != null )
    {
      for (int i = ls.length - 1; i >= 0; i--) {
        ls[i].renewToken(newToken);
      }
    }
  }

  /**
   * Called by ApiCall class when a token-hard-expiration-warning was received.
   * @param expDate Date
   */
  public void fireWarnTokenHardExpiration(java.util.Date expDate) {
    TokenEventListener[] ls = (TokenEventListener[])this.listenerList.getListeners(TokenEventListener.class);
    if( ls != null )
    {
      for (int i = ls.length - 1; i >= 0; i--) {
        ls[i].warnHardExpiration(expDate);
      }
    }
  }

  /**
   * Constructor.
   */
  public ApiCredential() {
  }

  /**
   * Get the ApiAccount to use.
   * @return the ApiAccount instance.
   */
  public ApiAccount getApiAccount(){
    return this.apiAccount;
  }

  /**
   * Set the ApiAccount to use. If you set eBay token string, the ApiAccount
   * and eBayAccount properties will be ignored.
   * @param apiAccount the ApiAccount instance to be set to.
   */
  public void setApiAccount(ApiAccount apiAccount) {
    this.apiAccount = apiAccount;
  }

  /**
   * Get the eBay auction account to use.
   * @return the eBayAccount instance.
   */
  public eBayAccount geteBayAccount() {
    return this.ebayAccount;
  }

  /**
   * Set the eBay auction account to use. If you set eBay token string,
   * the ApiAccount and eBayAccount properties will be ignored.
   * @param ebayAccount the eBayAccount to be set to.
   */
  public void seteBayAccount(eBayAccount ebayAccount) {
    this.ebayAccount = ebayAccount;
  }

  /**
   * Get the eBay token string.
   * @return The eBay token string.
   */
  public String geteBayToken() {
    return this.eBayToken;
  }

  /**
   * Set the eBay token string.
   * If you set eBay token string, the OAuthToken, 
   * ApiAccount and eBayAccount properties will be ignored.
   * @param eBayToken The eBay token string to be set to.
   */
  public void seteBayToken(String eBayToken) {
    this.eBayToken = eBayToken;
  }
  
  /**
   * Get the eBay OAuthToken string.
   * @return The eBay OAuthToken string.
   */
  public String getOAuthToken() {
    return this.oAuthToken;
  }

  /**
   * Set the eBay OAuthToken string. 
   * If eBay OAuthToken string is set, the ApiAccount
   * and eBayAccount properties will be ignored.
   * @param oAuthToken The eBay token string to be set to.
   */
  public void setOAuthToken(String oAuthToken) {
        this.oAuthToken = oAuthToken;
	
  }
}
