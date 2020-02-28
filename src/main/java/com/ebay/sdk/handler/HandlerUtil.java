/*
Copyright (c) 2013 eBay, Inc.
This program is licensed under the terms of the eBay Common Development and
Distribution License (CDDL) Version 1.0 (the "License") and any subsequent  version 
thereof released by eBay.  The then-current version of the License can be found 
at http://www.opensource.org/licenses/cddl1.php and in the eBaySDKLicense file that 
is under the eBay SDK ../docs directory.
*/
package com.ebay.sdk.handler;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import javax.xml.namespace.QName;

/**
 * Util for handlers
 * @author boyang
 * @version 1.0
 *
 */
public class HandlerUtil {

	/**
	 * convert a map (key, value) into a string
	 * @param map
	 * @return String
	 */
    public static String outputMap(Map map){
    	StringBuffer output = new StringBuffer(" ");
    	Set entries = map.entrySet();
    	Iterator it = entries.iterator();
    	while (it.hasNext()){
    		Entry entry = (Entry) it.next();
    		Object key = entry.getKey();
    		Object value = entry.getValue();
    		output.append(((key==null)?"null":key.toString()) + " : " + ((value==null)?"null":value.toString()) + "\n");
    	}
    	return output.toString();    	
    }

    /**
     * convert a QName into a string
     * @param name
     * @return String
     */
    public static String outputQName(QName name){
    	StringBuffer output = new StringBuffer(" ");
    	output.append("{" + name.getNamespaceURI()+ "} ");
    	if (name.getPrefix()!= null) output.append(name.getPrefix() + ":");
    	output.append(name.getLocalPart()); 
    	return output.toString();    	
    }
}
