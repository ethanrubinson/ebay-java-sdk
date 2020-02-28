/*
Copyright (c) 2013 eBay, Inc.
This program is licensed under the terms of the eBay Common Development and
Distribution License (CDDL) Version 1.0 (the "License") and any subsequent  version 
thereof released by eBay.  The then-current version of the License can be found 
at http://www.opensource.org/licenses/cddl1.php and in the eBaySDKLicense file that 
is under the eBay SDK ../docs directory.
*/

package com.ebay.sdk;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

import com.ebay.sdk.util.XmlUtil;
import com.ebay.sdk.util.eBayUtil;

/**
 * Making Schema-based API (non-SOAP) call by posting Schema-based Xml request
 * string to the traditional eBay API server. 
 *
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: eBay Inc.</p>
 * @author Weian Deng
 * @version 1.0
 */

public class ApiSchemaBasedXmlPoster {

  private ApiContext apiContext;

/**
   * Gets the ApiContext object for the API call.
   * @return the ApiContext object.
   */
  public ApiContext getApiContext() {
        return this.apiContext;
  }

  /**
   * Sets the ApiContext object for the API call.
   * @param apiContext ApiContext
   */
  public void setApiContext(ApiContext apiContext) {
        this.apiContext = apiContext;
  }

  /**
   * Posts the schema-based xml request to eBay API server. The request Xml should follow
   * the eBay API schema-based Xml standard and contains node <Version>.
   * 
   * @param sideId int
   * @param requestXml String
   * @throws SAXException
   * @throws IOException
   * @throws ParserConfigurationException
   * @throws TransformerException
   * @throws SdkException
   * @return String
   */
  public String postXmlText(int sideId, String requestXml) throws SAXException, IOException,
	  ParserConfigurationException, TransformerException, SdkException
  {
	Document reqDom = XmlUtil.createDom(requestXml);

	//
	Node request = reqDom.getFirstChild();
	String requestName = request.getNodeName();
	String verb = requestName.substring(0, requestName.length() - 7);
	if( verb.length() == 0 )
	  throw new SdkException("No <Verb> found in request Xml.");
	String version = XmlUtil.getChildStringByName(request, "Version", "");
	if( version.length() == 0 )
	  throw new SdkException("No <Version> found in request Xml.");

	//
	HttpURLConnection conn = openConnection();

	conn.setRequestProperty("X-EBAY-API-COMPATIBILITY-LEVEL", version);

	conn.setRequestProperty("X-EBAY-API-CALL-NAME", verb);
	conn.setRequestProperty("X-EBAY-API-SITEID",
			String.valueOf(SiteIDUtil.toNumericalID(this.apiContext.getSite())));


	//org.apache.axis.utils.XMLUtils.

	OutputStreamWriter osw = new OutputStreamWriter(conn.getOutputStream());
	osw.write(requestXml);
	osw.flush();
	osw.close();

	return eBayUtil.convertInputStreamToString(conn.getInputStream());
  }

  private HttpURLConnection openConnection()
      throws MalformedURLException, IOException
  {
    ApiCredential ac = this.apiContext.getApiCredential();

    URL url = new URL(this.apiContext.getApiServerUrl());
    HttpURLConnection conn = (HttpURLConnection)url.openConnection();

//    String dev, app, cert;
//
//    dev = ac.getApiAccount().getDeveloper().trim();
//    app = ac.getApiAccount().getApplication().trim();
//    cert = ac.getApiAccount().getCertificate().trim();

    conn.setDoInput(true);
    conn.setUseCaches(false);

    conn.setRequestProperty ("Content-Type", "text/xml");

//    conn.setRequestProperty("X-EBAY-API-SESSION-CERTIFICATE", dev + ";" + app + ";" + cert);
//    conn.setRequestProperty("X-EBAY-API-DEV-NAME", dev);
//    conn.setRequestProperty("X-EBAY-API-APP-NAME", app);
//    conn.setRequestProperty("X-EBAY-API-CERT-NAME", cert);
    conn.setRequestProperty("X-EBAY-API-COMPATIBILITY-LEVEL",this.apiContext.getWSDLVersion());

    conn.setDoOutput(true);
    conn.setRequestMethod("POST");

    return conn;
  }
}
