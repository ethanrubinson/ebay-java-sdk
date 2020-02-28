/*
Copyright (c) 2013 eBay, Inc.
This program is licensed under the terms of the eBay Common Development and
Distribution License (CDDL) Version 1.0 (the "License") and any subsequent  version 
thereof released by eBay.  The then-current version of the License can be found 
at http://www.opensource.org/licenses/cddl1.php and in the eBaySDKLicense file that 
is under the eBay SDK ../docs directory.
*/

package com.ebay.sdk.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;
import java.io.StringWriter;
import java.text.ParseException;
import java.util.Date;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.apache.xpath.XPath;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

/**
 * Xml related helper functions.
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: eBay Inc.</p>
 * @author Changyi Zhu, Weijun Li
 * @version 1.0
 */
public abstract class XmlUtil {

	/**
     * Method to get formatted Xml string from Xml source
     *
     * @param payload Source
     * @return a formatted Xml string
     */
	public static String getXmlStringFromSource(Source payload) {
    	String result = null;
        StreamResult strResult = new StreamResult(new StringWriter());
        
        if(payload != null) {
	        try {
	            TransformerFactory factory = TransformerFactory.newInstance();
	            //factory.setAttribute("indent-number", new Integer(2));
	            Transformer transformer = factory.newTransformer();
	            transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
	            transformer.setOutputProperty(OutputKeys.METHOD, "xml");
	            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
	            transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "1");
	            transformer.transform(payload, strResult);
	        } catch (TransformerException e) {
	            e.printStackTrace();
	        }
	    	result = strResult.getWriter().toString();
        }
        return result;
	}
	
	/**
     * Method to get formatted Xml string from Xml document
     *
     * @param doc
     * @return a formatted Xml string
     */	
	public static String getXmlStringFromDom(Document doc) {
		Source payload = new DOMSource(doc.getDocumentElement());
		return getXmlStringFromSource(payload);
	}
	
  /**
     * Method to create a DOM document tree from a valid XML string
     *
     * @param xml String
     * @throws SAXException
     * @throws IOException
     * @throws ParserConfigurationException
     * @return An org.w3c.dom.Document object
     */
    public static Document createDom(String xml) throws SAXException, IOException,
      ParserConfigurationException
  {
    StringReader sr = new StringReader(xml);
    DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
    dbf.setNamespaceAware(true);
    DocumentBuilder db = dbf.newDocumentBuilder();

    Document doc = db.parse(new InputSource(sr));
    return doc;
  }

  /**
   *
   * @throws SAXException
   * @throws IOException
   * @throws ParserConfigurationException
   * @return Document
   */
  public static Document createDom() throws SAXException, IOException,
      ParserConfigurationException
  {
    DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
    dbf.setNamespaceAware(true);
    DocumentBuilder db = dbf.newDocumentBuilder();
    Document doc = db.newDocument();
    return doc;
  }

  /**
   * Method to create a DOM document tree from a file
   *
   * @param file Source file for the DOM
   * @throws SAXException
   * @throws IOException
   * @throws ParserConfigurationException
   * @return An org.w3c.dom.Document object
   */
  public static Document createDom(File file) throws SAXException, IOException,
      ParserConfigurationException {
    FileInputStream is = new FileInputStream(file);

    //DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
    //dbf.setNamespaceAware(true);
    //DocumentBuilder db = dbf.newDocumentBuilder();

    //Document doc = db.parse(is);
    //return doc;

    return createDom(is);
  }

  /**
   * Method to create a DOM document tree from a InputStream
   *
   * @param is InputStream
   * @throws SAXException
   * @throws IOException
   * @throws ParserConfigurationException
   * @return An org.w3c.dom.Document object
   */
  public static Document createDom(InputStream is) throws SAXException, IOException,
      ParserConfigurationException {
    DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
    dbf.setNamespaceAware(true);
    DocumentBuilder db = dbf.newDocumentBuilder();

    Document doc = db.parse(is);
    return doc;
  }

  /**
   * Method to create a DOM document tree from a fuke
   *
   * @param pathname Source file for the DOM
   * @throws SAXException
   * @throws IOException
   * @throws ParserConfigurationException
   * @return An org.w3c.dom.Document object
   */
  public static Document createDomByPathname(String pathname) throws SAXException, IOException,
      ParserConfigurationException {
    File file = new File(pathname);
    return createDom(file);
  }

  /**
   *
   * @param doc Document
   * @param parent Node
   * @param name String
   * @return Element
   */
  public static Element appendChildNode(Document doc, Node parent, String name)
  {
    Element child = doc.createElement(name);
    parent.appendChild(child);
    return child;
  }

  /**
   *
   * @param doc Document
   * @param namespace String
   * @param parent Node
   * @param name String
   * @return Element
   */
  public static Element appendChildNode(Document doc, String namespace, Node parent, String name)
  {
    Element child = doc.createElementNS(namespace, name);
    parent.appendChild(child);
    return child;
  }

  /**
   *
   * @param doc Document
   * @param parent Node
   * @param name String
   * @param value int
   * @return Element
   */
  public static Element appendChildNode(Document doc, Node parent, String name, int value)
  {
    Element child = doc.createElement(name);
    child.appendChild(doc.createTextNode(new Integer(value).toString()));
    parent.appendChild(child);
    return child;
  }

  /**
   *
   * @param doc Document
   * @param parent Node
   * @param name String
   * @param value String
   * @return Element
   */
  public static Element appendChildNode(Document doc, Node parent, String name, String value)
  {
    Element child = doc.createElement(name);
    child.appendChild(doc.createTextNode(value));
    parent.appendChild(child);
    return child;
  }

  /**
   *
   * @param doc Document
   * @param namespace String
   * @param parent Node
   * @param name String
   * @param value String
   * @return Element
   */
  public static Element appendChildNode(Document doc, String namespace, org.w3c.dom.Node parent, String name, String value)
  {
    Element child = doc.createElementNS(namespace, name);
    child.appendChild(doc.createTextNode(value));
    parent.appendChild(child);
    return child;
  }

  /**
   *
   * @param parent Element
   * @param name String
   * @param value String
   */
  public static void appendAttributeNode(Element parent, String name, String value)
  {
    parent.setAttribute(name, value);
  }

  /**
   *
   * @param namespace String
   * @param parent Element
   * @param name String
   * @param value String
   */
  public static void appendAttributeNode(String namespace, Element parent, String name, String value)
  {
    parent.setAttributeNS(namespace, name, value);
  }

  /**
   *
   * @param parent Element
   * @param name String
   * @param value int
   */
  public static void appendAttributeNode(Element parent, String name, int value)
  {
    parent.setAttribute(name, new Integer(value).toString());
  }

  /**
   *
   * @param namespace String
   * @param parent Element
   * @param name String
   * @param value int
   */
  public static void appendAttributeNode(String namespace, Element parent, String name, int value)
  {
    parent.setAttributeNS(namespace, name, new Integer(value).toString());
  }

  /**
   *
   * @param doc Document
   * @param parent Node
   * @param name String
   * @param value int
   * @return Element
   */
  public static Element appendChildNodeCDATA(Document doc, Node parent, String name, int value)
  {
    Element child = doc.createElement(name);
    child.appendChild(doc.createCDATASection(new Integer(value).toString()));
    parent.appendChild(child);
    return child;
  }

  /**
   *
   * @param doc Document
   * @param parent Node
   * @param name String
   * @param value String
   * @return Element
   */
  public static Element appendChildNodeCDATA(Document doc, Node parent, String name, String value)
  {
    Element child = doc.createElement(name);
    child.appendChild(doc.createCDATASection(value));
    parent.appendChild(child);
    return child;
  }

  /**
   *
   * @param node Node
   * @param xpath String
   * @throws TransformerException
   * @return String
   */
  public static String getChildString(Node node, String xpath) throws TransformerException
  {
    XPath xp = XPathUtil.createXPath(xpath);
    NodeList nodes = XPathUtil.execute(xp, node);
    if( nodes != null && nodes.getLength() > 0 )
    {
      Node fnd = nodes.item(0).getFirstChild();
      if( fnd != null )
        return fnd.getNodeValue();
    }
    return "";
  }

  /**
   *
   * @param element Element
   * @param namespace String
   * @param childName String
   * @return String
   */
  public static String getChildStringNS(Element element, String namespace, String childName)
  {
    NodeList nodes = element.getElementsByTagNameNS(namespace, childName);
    if( nodes.getLength() > 0 )
    {
      Node fnd = nodes.item(0).getFirstChild();
      if( fnd != null )
        return fnd.getNodeValue();
    }
    return "";
  }

  /**
   *
   * @param node Node
   * @param xpath String
   * @throws TransformerException
   * @return int
   */
  public static int getChildInteger(Node node, String xpath) throws TransformerException
  {
    int n = -1;
    String s = getChildString(node, xpath).trim();
    if( s.length() > 0 )
    {
      n = Integer.parseInt(s);
    }

    return n;
  }

  /**
   *
   * @param node Node
   * @param xpath String
   * @throws TransformerException
   * @return boolean
   */
  public static boolean getChildBoolean(Node node, String xpath) throws TransformerException
  {
    boolean b = false;
    String s = getChildString(node, xpath).trim();
    if( s.equals("1") )
      b = true;
    return b;
  }

  /**
   *
   * @param node Node
   * @param xpath String
   * @throws TransformerException
   * @return double
   */
  public static double getChildDouble(Node node, String xpath) throws TransformerException
  {
    double d = 0.0;
    String s = getChildString(node, xpath).trim();
    if (s.length() > 0) {
      d = Double.parseDouble(s);
    }

    return d;
  }

  /**
   *
   * @param node Node
   * @param xpath String
   * @throws TransformerException
   * @throws ParseException
   * @return Date
   */
  public static Date getChildDate(Node node, String xpath) throws TransformerException,
    ParseException
  {
    Date d = new Date(0);
    String s = getChildString(node, xpath).trim();
    if (s.length() > 0) {
      java.text.DateFormat inst = java.text.DateFormat.getInstance();
      d = inst.parse(s);
    }
    return d;
  }

  /**
   * Find node by name recursively.
   * @param node Node
   * @param nodeName String
   * @return Node
   */
  public static Node findNode(Node node, String nodeName)
  {
      if(nodeName.equals(node.getNodeName()))
          return node;
      org.w3c.dom.NodeList children = node.getChildNodes();
      for(int i=0;i<children.getLength();i++){
          Node ret = findNode(children.item(i), nodeName);
          if(ret != null)
              return ret;
      }
      return null;
  }

  /**
   * Find node by name.
   * @param node Node
   * @param nodeName String
   * @return Node
   */
  public static Node getChildByName(Node node, String nodeName)
  {
    org.w3c.dom.NodeList children = node.getChildNodes();
    for(int i=0; i < children.getLength();i++)
    {
      Node c = children.item(i);
      if( c.getNodeName().equals(nodeName) )
        return c;
    }
    return null;
  }

  /**
   *
   * @param node Node
   * @param nodeName String
   * @param errValue String
   * @return String
   */
  public static String getChildStringByName(Node node, String nodeName, String errValue)
  {
    Node nd = getChildByName(node, nodeName);
    if( nd != null )
    {
      Node fnd = nd.getFirstChild();
      if( fnd != null )
        return fnd.getNodeValue();
    }
    return errValue;
  }

  /**
   *
   * @param node Node
   * @param nodeName String
   * @param errValue int
   * @return int
   */
  public static int getChildIntegerByName(Node node, String nodeName, int errValue)
  {
    String s = getChildStringByName(node, nodeName, "");
    if( s.length() > 0 )
      return Integer.parseInt(s);
    return errValue;
  }

  /**
   * "1" means true. Otherwise false.
   * @param node Node
   * @param nodeName String
   * @return boolean
   */
  public static boolean getChildBooleanByName(Node node, String nodeName)
  {
    String s = getChildStringByName(node, nodeName, "");
    return s.equals("1");
  }

  /**
   *
   * @param node Node
   * @param nodeName String
   * @param errValue double
   * @return double
   */
  public static double getChildDoubleByName(Node node, String nodeName, double errValue)
  {
    String s = getChildStringByName(node, nodeName, "");
    if( s.length() > 0 )
      return Double.parseDouble(s);
    return errValue;
  }

  /**
   * Performs XSL transformation.
   * @param xmlDoc Document
   * @param xslDoc Document
   * @throws TransformerConfigurationException
   * @throws TransformerException
   * @return String The output text.
   */
  public static String xslTransform(Document xmlDoc, Document xslDoc)
      throws TransformerConfigurationException, TransformerException
  {
    DOMSource source = new DOMSource(xmlDoc);
    DOMSource xslSrc = new DOMSource(xslDoc);

    TransformerFactory xformFactory = TransformerFactory.newInstance();
    Transformer transformer = xformFactory.newTransformer(xslSrc);

    java.io.StringWriter sw = new java.io.StringWriter();
    StreamResult outXml = new StreamResult(sw);

    transformer.transform(source, outXml);

    return sw.toString();
  }

  /**
   * Finds attribute of node by name.
   * @param node Node The context node.
   * @param name String
   * @return Node
   */
  public static Node findAttribute(Node node, String name)
  {
    Node found = null;
    NamedNodeMap nm = node.getAttributes();
    if( nm != null )
    {
      for(int i = 0; i < nm.getLength(); i++ )
      {
        Node attr = nm.item(i);
        if( attr.getNodeName().compareToIgnoreCase(name) == 0 )
        {
          found = attr;
          break;
        }
      }
    }
    return found;
  }

  /**
   * Gets the value of a named attribute of a node.
   * @param node Node The context node.
   * @param name String
   * @return String null means node is not found.
   */
  public static String getAttributeString(Node node, String name)
  {
    Node nd = findAttribute(node, name);
    if( nd != null )
      return nd.getNodeValue();
    return null;
  }

  /**
   * Gets the integer value of a named attribute of a node.
   * @param node Node The context node.
   * @param name String
   * @param errValue int
   * @return int
   */
  public static int getAttributeInteger(Node node, String name, int errValue)
  {
    String s = getAttributeString(node, name);
    if( s != null && s.length() > 0 )
      return Integer.parseInt(s);
    else
      return errValue;
  }

  /**
   * Gets the double value of a named attribute of a node.
   * @param node Node The context node.
   * @param name String
   * @param errValue double
   * @return double
   */
  public static double getAttributeDouble(Node node, String name, double errValue)
  {
    String s = getAttributeString(node, name);
    if( s != null && s.length() > 0 )
      return Double.parseDouble(s);
    else
      return errValue;
  }

  /**
   * Gets the boolean value of a named attribute of a node.
   * @param node Node
   * @param name String
   * @return boolean
   */
  public static boolean getAttributeBoolean(Node node, String name)
  {
    String s = getAttributeString(node, name);
    if( s != null && s.length() > 0 )
    {
      return ( s.compareToIgnoreCase("1") == 0 );
    }
    else
      return false;
  }

  /**
   *
   * @param doc Document
   * @param parent Node
   * @param childName String
   * @param value String
   */
  public static void setChildValue(Document doc, Node parent, String childName, String value)
  {
    Node node = XmlUtil.getChildByName(parent, childName);
    if( node == null )
      node = XmlUtil.appendChildNode(doc, parent, childName);

    if( node.getFirstChild() == null )
      node.appendChild(doc.createTextNode(value));
    else
      node.getFirstChild().setNodeValue(value);
  }

  /**
   *
   * @param doc Document
   * @param parent Node
   * @param childName String
   * @param value int
   */
  public static void setChildValue(Document doc, Node parent, String childName, int value)
  {
    setChildValue(doc, parent, childName, new Integer(value).toString());
  }

  /**
   * Save content of DOM to a file.
   * @param doc Document
   * @param filePath String
   * @throws Exception
   */
  public static void saveDomToFile(Document doc, String filePath) throws Exception
  {
    // Write the DOM to file.
    Source source = new DOMSource(doc);

    // Prepare the output file
    File file = new File(filePath);
    Result result = new StreamResult(file);

    // Write the DOM document to the file
    Transformer xformer = TransformerFactory.newInstance().newTransformer();
    xformer.transform(source, result);
  }
}
