/*
Copyright (c) 2013 eBay, Inc.
This program is licensed under the terms of the eBay Common Development and
Distribution License (CDDL) Version 1.0 (the "License") and any subsequent  version 
thereof released by eBay.  The then-current version of the License can be found 
at http://www.opensource.org/licenses/cddl1.php and in the eBaySDKLicense file that 
is under the eBay SDK ../docs directory.
*/

package com.ebay.sdk.util;

import java.io.IOException;
import java.net.*;
import java.util.List;
import java.util.ArrayList;

/**
*
* <p>Title: SdkProxySelector</p>
* <p>Description: utility class for http proxy setting</p>
* <p>Copyright: Copyright (c) 2009</p>
* <p>Company: eBay Inc.</p>
* @author boyang
* @version 1.0
*/
public class SdkProxySelector extends ProxySelector {
	
	private ArrayList<Proxy> proxies = new ArrayList<Proxy>();

	/**
	 * constructor, create a basic ProxySelector.
	 */
	public SdkProxySelector(String proxyHost, int proxyPort) {
		SocketAddress sa = new InetSocketAddress(proxyHost, proxyPort);
		Proxy p = new Proxy(Proxy.Type.HTTP, sa);
		proxies.add(p);
	}
	
	/**
	 * constructor, create a ProxySelector with username/password authentication.
	 */
	public SdkProxySelector(String proxyHost, int proxyPort, String username, String password) {
		this(proxyHost, proxyPort);
		
		final String _username = username;
		final String _password = password;
		
	    Authenticator.setDefault(new Authenticator() {
	        protected PasswordAuthentication getPasswordAuthentication() {
	          return new
	             PasswordAuthentication(_username, _password.toCharArray());
	      }});
	}
	
	/**
	 * Method called by the handlers when it failed to connect
	 * to one of the proxies returned by select().
	 */
	@Override
	public void connectFailed(URI uri, SocketAddress sa, IOException ioe) {
		throw new RuntimeException("fail to connect to the proxy server: " + sa.toString(), ioe);
	}

	/**
	 * This is the method that the handlers will call.
	 * Returns a List of proxy.
	 */
	@Override
	public List<Proxy> select(URI uri) {
		return proxies;
	}
	
	/**
	 * register this ProxySelector, let the proxy setting take effect.
	 */
	public void register() {
		ProxySelector.setDefault(this);
	}

}
