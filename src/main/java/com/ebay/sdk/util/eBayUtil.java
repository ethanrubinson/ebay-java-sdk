/*
Copyright (c) 2013 eBay, Inc.
This program is licensed under the terms of the eBay Common Development and
Distribution License (CDDL) Version 1.0 (the "License") and any subsequent  version 
thereof released by eBay.  The then-current version of the License can be found 
at http://www.opensource.org/licenses/cddl1.php and in the eBaySDKLicense file that 
is under the eBay SDK ../docs directory.
*/

package com.ebay.sdk.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import com.ebay.sdk.SdkException;
import com.ebay.soap.eBLBaseComponents.CategoryType;
import com.ebay.soap.eBLBaseComponents.CharacteristicsSetType;
import com.ebay.soap.eBLBaseComponents.FeeType;

/**
 * Contains utilities for eBay API.
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: eBay Inc.</p>
 * @author not attributable
 * @version 1.0
 */
public class eBayUtil {

  static final String DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";
  static final String TIME_ZONE = "GMT";

  /**
   *
   * @param date Date
   * @param format String
   * @param timeZone String
   * @return String
   */
  public static String toAPITimeString(Date date, String format, String timeZone)
  {
    SimpleDateFormat dateFormatterAPI = null;
    dateFormatterAPI = new SimpleDateFormat(format);
    if( timeZone != null )
      dateFormatterAPI.setTimeZone(TimeZone.getTimeZone(timeZone));
    return dateFormatterAPI.format(date);
  }

  /**
   * Converts date to eBay API date string.
   * @param date Date
   * @return String
   */
  public static String toAPITimeString(Date date)
  {
    return toAPITimeString(date, DATE_FORMAT, TIME_ZONE);
  }

  /**
   *
   * @param strDate String
   * @param format String
   * @param timeZone String
   * @throws ParseException
   * @return Date
   */
  public static Date fromAPITimeString(String strDate, String format, String timeZone)
      throws ParseException
  {
    SimpleDateFormat dateFormatterAPI = null;
    dateFormatterAPI = new SimpleDateFormat(format);
    if( timeZone != null )
      dateFormatterAPI.setTimeZone(TimeZone.getTimeZone(timeZone));
    return dateFormatterAPI.parse(strDate);
  }

  /**
   * Parse date from eBay API date string.
   * @param strDate String
   * @throws ParseException
   * @return Date
   */
  public static Date fromAPITimeString(String strDate)
      throws ParseException
  {
    return fromAPITimeString(strDate, DATE_FORMAT, TIME_ZONE);
  }

  /**
   * Find fees from FeeType array.
   * @param fees FeeType[]
   * @param feeName String
   * @return FeeType
   */
  public static FeeType findFeeByName(
     FeeType[] fees, String feeName)
  {
    FeeType ft = null;
    for(int i = 0; i < fees.length; i ++)
    {
      if( fees[i].getName().equals(feeName) )
      {
        ft = fees[i];
        break;
      }
    }
    return ft;
  }

  /**
   *
   * @param inStrm InputStream
   * @throws IOException
   * @return String
   */
  public static String convertInputStreamToString(InputStream inStrm)
      throws IOException
  {
    BufferedReader reader = new BufferedReader(new InputStreamReader(inStrm));
    StringBuffer response = new StringBuffer();
    String line;

    while ( (line = reader.readLine()) != null) {
      response.append(line + "\n");
    }

    return response.toString();
   }

   /**
    * Determines if a string length >= 1.
    * @param s String
    * @return boolean
    */
   public static boolean isNonZeroString(String s) {
     return s != null && s.length() > 0;
   }

   /**
    * Converts integer to string.
    * @param i int
    * @return String
    * @deprecated use String.valueOf(i)
    */
   public static String intToString(int i)
   {
     return new Integer(i).toString();
   }

   /**
    * Sorts a category array.
    * @param cats CategoryType[]
    * @param sortBy int
    * @param ascending boolean Sorts in ascending order.
    * @throws Exception
    */
   public static void sortCategoryArray(CategoryType[] cats, int sortBy, boolean ascending)
       throws Exception
   {
     int i;
     java.util.Map catsMap = new java.util.Hashtable();
     for(i = 0; i < cats.length; i++ )
     {
       Integer t = null;

       if( sortBy == 1 )
       {
         CharacteristicsSetType sets[];

          sets = cats[i].getCharacteristicsSets();
          if( sets != null && sets.length > 0 )
            t = sets[0].getAttributeSetID();
          else
            throw new SdkException("No CharacteristicsSet cat be found for the category.");
       }
       else
           t = new Integer(cats[i].getCategoryID());

       catsMap.put(t, cats[i]);
     }

     Object[] cms = catsMap.entrySet().toArray();
     for(i = 0; i < cms.length - 1; i++)
     {
       int ival = ((Integer)((java.util.Map.Entry)cms[i]).getKey()).intValue();

       for(int j = i + 1; j < cms.length; j++ )
       {
         java.util.Map.Entry e2 = (java.util.Map.Entry)cms[j];

         boolean larger = ival > ((Integer)e2.getKey()).intValue();
         if( (ascending && larger) || (!ascending && !larger) )
         {
           Object c = cms[i];
           cms[i] = cms[j];
           cms[j] = c;

           ival = ((Integer)e2.getKey()).intValue();
         }
       }
     }

     // Copy results back.
     for(i = 0; i < cms.length; i++ )
       cats[i] = (CategoryType)((java.util.Map.Entry)cms[i]).getValue();
   }

   public static String getFullPathOfClass(Class cls)
   {
     URL url = cls.getProtectionDomain().getCodeSource().getLocation();
     String path = url.getPath();

     String[] dirs = cls.getName().split("\\.");

     for(int i = 0; i < dirs.length - 1; i++ )
       path += dirs[i] + "/";

     return path;
   }

 
}
