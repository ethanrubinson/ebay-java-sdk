/*
Copyright (c) 2013 eBay, Inc.
This program is licensed under the terms of the eBay Common Development and
Distribution License (CDDL) Version 1.0 (the "License") and any subsequent  version 
thereof released by eBay.  The then-current version of the License can be found 
at http://www.opensource.org/licenses/cddl1.php and in the eBaySDKLicense file that 
is under the eBay SDK ../docs directory.
*/

package com.ebay.sdk.helper;

import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;

/**
* An easy interface to read numbers and strings from
* standard input
* @version 1.01 15 Feb 1996
* @author Cay Horstmann. Modified by Weijun Li of eBay to make it to work on Linux
*/

public class ConsoleUtil
{  /**
    * print a prompt on the console
    * @param prompt the prompt string to display
    */

   public static void printPrompt(String prompt)
   {
     System.out.println(prompt + " ");
     System.out.flush();
   }

   /**
    * read a string from the console. The string is
    * terminated by a newline
    * @return the input string (without the newline)
    */

   public static String readString()  throws IOException
   {
     InputStreamReader input = new InputStreamReader(System.in);
     BufferedReader reader = new BufferedReader(input);

     String rs = reader.readLine();
     if( rs == null )
       rs = "";
     return rs.trim();
   }

   /**
    * read a string from the console. The string is
    * terminated by a newline
    * @param prompt the prompt string to display
    * @return the input string (without the newline)
    */

   public static String readString(String prompt)  throws IOException
   {
     printPrompt(prompt);
     return readString();
   }

   /**
    * read an integer from the console. The input is
    * terminated by a newline
    * @param prompt the prompt string to display
    * @return the input value as an int
    * @exception NumberFormatException if bad input
    */

   public static int readInt(String prompt) throws IOException
   {  while(true)
      {  printPrompt(prompt);
         try
         {  return Integer.valueOf
               (readString().trim()).intValue();
         } catch(NumberFormatException e)
         {  System.out.println
               ("Not an integer. Please try again!");
         }
      }
   }

   /**
    * read a floating point number from the console.
    * The input is terminated by a newline
    * @param prompt the prompt string to display
    * @return the input value as a double
    * @exception NumberFormatException if bad input
    */

   public static double readDouble(String prompt) throws IOException
   {  while(true)
      {  printPrompt(prompt);
         try
         {  return Double.valueOf
               (readString().trim()).doubleValue();
         } catch(NumberFormatException e)
         {  System.out.println
         ("Not a floating point number. Please try again!");
         }
      }
   }
}
