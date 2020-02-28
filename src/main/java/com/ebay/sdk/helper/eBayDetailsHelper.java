/*
Copyright (c) 2013 eBay, Inc.
This program is licensed under the terms of the eBay Common Development and
Distribution License (CDDL) Version 1.0 (the "License") and any subsequent  version 
thereof released by eBay.  The then-current version of the License can be found 
at http://www.opensource.org/licenses/cddl1.php and in the eBaySDKLicense file that 
is under the eBay SDK ../docs directory.
*/

package com.ebay.sdk.helper;

import java.io.InputStream;
import java.util.Hashtable;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.ebay.sdk.util.XPathUtil;
import com.ebay.sdk.util.XmlUtil;
import com.ebay.soap.eBLBaseComponents.SiteCodeType;

/**
 * A helper class to retrieve the available service information of eBayDetails. The eBayDetails
 * are stored in XML resource files which can be retrieved by using API GeteBayDetails.
 */
public class eBayDetailsHelper
{
  static eBayDetailsHelper _helper = new eBayDetailsHelper();
  static Hashtable<SiteCodeType, Document> _eBayDetails = new Hashtable<SiteCodeType, Document>();

  /**
   * Return an instance of eBayDetailsHelper.
   * @return eBayDetailsHelper
   */
  public static eBayDetailsHelper getInstance(){
	return _helper;
  }

  private eBayDetailsHelper() {
  }

  /**
   * Method to get the XML resource of eBayDetails for a given site.
   * @param sideId SiteCodeType
   * @return Document
   */
  private Document getResource(SiteCodeType sideId)
  {
    Document doc = null;
    try {
      String source = EBAY_DETAILS + "_" + sideId.value().toLowerCase() + ".xml";
      ClassLoader loader = Thread.currentThread().getContextClassLoader();
      InputStream is = loader.getResourceAsStream(source);
      doc = XmlUtil.createDom(is);
      is.close();
    }
    catch(Exception e) {

    }
    return doc;
  }

  /**
   * Method to get the XML resource of eBayDetails for a given site.
   * @param siteId SiteCodeType
   * @return Document
   */
  public Document geteBayDetailsDocument(SiteCodeType siteId)
  {
    Document doc = (Document) _eBayDetails.get(siteId);
    if (doc == null) {
      doc = getResource(siteId);
      if (doc != null) {
        _eBayDetails.put(siteId, doc);
      }
    }

    return doc;
  }

  /**
   * Method to retrieve the entry map for a given name of eBay Detail. Each entry in the map
   * has a Value of integer.
   * @param siteId SiteCodeType
   * @param detailName String
   * @return Hashtable
   */
  public Hashtable getDetailEntryMapWithIntValue(SiteCodeType siteId, String detailName)
  {
    Hashtable ht = new Hashtable();
    try {
      NodeList list = getDetailNodeList(siteId, detailName);
      if (list != null) {
        NodeList childList = list.item(0).getChildNodes();
        int len = childList.getLength();
        for (int i = 0; i < len; i++) {
          Node node = childList.item(i);
          if (node.getNodeType() == Node.ELEMENT_NODE) {
            Node valNode = XPathUtil.selectSingleNode(VALUE, node);
            Node desNode = XPathUtil.selectSingleNode(DESCRIPTION, node);
            if (valNode != null && desNode != null) {
              Integer value = new Integer(valNode.getFirstChild().getNodeValue());
              String des = desNode.getFirstChild().getNodeValue();
              ht.put(value, des);
            }
          }
        }
      }
    }
    catch(Exception e) {
    }

    return ht;
  }

  /**
   * Method to retrieve the entry map for a given name of eBay Detail. Each entry in the map
   * has a Value of String.
   * @param siteId SiteCodeType
   * @param detailName String
   * @return Hashtable
   */
  public Hashtable getDetailEntryMapWithStringValue(SiteCodeType siteId, String detailName)
  {
    Hashtable ht = new Hashtable();
    try {
      NodeList list = getDetailNodeList(siteId, detailName);
      if (list != null) {
        NodeList childList = list.item(0).getChildNodes();
        int len = childList.getLength();
        for (int i = 0; i < len; i++) {
          Node node = childList.item(i);
          if (node.getNodeType() == Node.ELEMENT_NODE) {
            Node valNode = XPathUtil.selectSingleNode(VALUE, node);
            Node desNode = XPathUtil.selectSingleNode(DESCRIPTION, node);
            if (valNode != null && desNode != null) {
              String value = valNode.getFirstChild().getNodeValue();
              String des = desNode.getFirstChild().getNodeValue();
              ht.put(value, des);
            }
          }
        }
      }
    }
    catch(Exception e) {
    }

    return ht;
  }

  private NodeList getDetailNodeList(SiteCodeType siteId, String detailName)
  {
    Node ctxNode = geteBayDetailsDocument(siteId);

    NodeList list = null;
    String xpath = DETAIL_PATH + "[" + NAME_TEXT + "='" +  detailName + "']";
    try {
      list = XPathUtil.selectNodes(xpath, ctxNode);
    }
    catch(Exception e) {
    }

    return list;
  }

  private static String NAME_TEXT = "Name/text()";
  private static String EBAY_DETAILS = "com/ebay/sdk/helper/policy/ebaydetails";
  //private static String DETAILS_PATH = "//eBay/Details/*";
  private static String DETAIL_PATH = "//eBay/Details/Detail";
  private static String DESCRIPTION = "Description";
  private static String VALUE = "Value";
}
