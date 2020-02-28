/*
Copyright (c) 2013 eBay, Inc.
This program is licensed under the terms of the eBay Common Development and
Distribution License (CDDL) Version 1.0 (the "License") and any subsequent  version 
thereof released by eBay.  The then-current version of the License can be found 
at http://www.opensource.org/licenses/cddl1.php and in the eBaySDKLicense file that 
is under the eBay SDK ../docs directory.
*/

package com.ebay.sdk.util;

import com.ebay.soap.eBLBaseComponents.*;

/**
 *
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: eBay Inc.</p>
 * @author Weijun Li
 * @version 1.0
 */
public abstract class AttributeHelper {

  /**
   * Find an attribute by ID.
   * @param ast AttributeSetType
   * @param attributeID int
   * @return AttributeType
   */
  public static AttributeType findAttribute(AttributeSetType ast, int attributeID)
  {
    AttributeType[] attrs = ast.getAttribute();
    if(attrs == null) {
    	return null;
    }
    for(int i = 0; i < attrs.length; i++ )
    {
      AttributeType attr = attrs[i];
      if( attr.getAttributeID() == attributeID )
        return attr;
    }
    return null;
  }

  private static AttributeType appendNewAttribute(AttributeSetType ast)
  {
	    AttributeType[] attrs = ast.getAttribute();

	    int oldLen = attrs == null ? 0 : attrs.length;
	    AttributeType[] newAttrs = new AttributeType[oldLen + 1];

	    if( oldLen > 0 )
	    {
	      for (int i = 0; i < attrs.length; i++)
	        newAttrs[i] = attrs[i];
	    }

	    AttributeType attrNew = new AttributeType();
	    newAttrs[oldLen] = attrNew;

	    ast.setAttribute(newAttrs);

	    return attrNew;
  }

  /**
   * Insert an attribute node to AttributeSetType or update the existing attribute node.
   * @param ast AttributeSetType
   * @param attributeID int
   * @param valueID int
   * @param valStr string
   */
  public static void insertToAttributeSet(AttributeSetType ast, int attributeID, int valueID, String valStr)
  {
      AttributeType attr = findAttribute(ast, attributeID);
      if( attr == null )
      {
        attr = appendNewAttribute(ast);
        attr.setAttributeID(attributeID);
      }

      ValType v = new ValType();
      if( valueID != 0 )
        v.setValueID(new Integer(valueID));
      v.setValueLiteral(valStr);

      ValType[] vals = new ValType[1];
      vals[0] = v;
      attr.setValue(vals);
  }

  /**
   * Get the first ValueLiteral of an attribute node.
   * @param ast AttributeSetType
   * @param attributeID int
   * @return String
   */
  public static String getValueLiteral(AttributeSetType ast, int attributeID)
  {
      AttributeType attr = findAttribute(ast, attributeID);
      if( attr == null )
        return null;

      ValType[] vals = attr.getValue();
      if( attr != null && vals != null && vals.length > 0 )
      {
        return vals[0].getValueLiteral();
      }
      return null;
  }
  
  /**
   * Get the first ValueID of an attribute node.
   * @param ast AttributeSetType
   * @param attributeID int
   * @return int
   */
  public static int getValueID(AttributeSetType ast, int attributeID)
  {
      AttributeType attr = findAttribute(ast, attributeID);
      if( attr == null )
        return 0;

      ValType[] vals = attr.getValue();
      if( attr != null && vals != null && vals.length > 0 )
      {
        Integer it = vals[0].getValueID();
        return it == null ? 0 : it.intValue();
      }
      return 0;
  }



  /**
   * Remove an attribute from the AttributeSetType object.
   * @param ast AttributeSetType
   * @param attributeID int
   * @return bool True means the attribute has been found and removed.
   */
  public static boolean removeAttribute(AttributeSetType ast, int attributeID)
  {
    AttributeType attr = findAttribute(ast, attributeID);
    if( attr == null )
      return false;

    AttributeType[] oldAttrs = ast.getAttribute();
    AttributeType[] newAttrs = new AttributeType[oldAttrs.length -1];

    int n = 0;
    for(int i = 0; i < oldAttrs.length; i++ )
    {
      if( oldAttrs[i].getAttributeID() != attributeID )
        newAttrs[n++] = oldAttrs[i];
    }

    ast.setAttribute(newAttrs);
    return true;
  }
  
}
