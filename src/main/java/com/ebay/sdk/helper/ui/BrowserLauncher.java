/*
Copyright (c) 2013 eBay, Inc.
This program is licensed under the terms of the eBay Common Development and
Distribution License (CDDL) Version 1.0 (the "License") and any subsequent  version 
thereof released by eBay.  The then-current version of the License can be found 
at http://www.opensource.org/licenses/cddl1.php and in the eBaySDKLicense file that 
is under the eBay SDK ../docs directory.
*/

package com.ebay.sdk.helper.ui;

import java.io.IOException;

/**
 * http://bugs.sun.com/bugdatabase/view_bug.do?bug_id=4210168
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: </p>
 * @author gtorrence
 * @version 1.0
 */
public class BrowserLauncher
{
  /**
   * Launches the user's browser with the specified HTTP URL.
   *
   * This method is designed only to work under windows or unix.
   * For windows, the user must have url.dll set up properly.
   * For unix, the user must have firefox, netscape, or mozilla in their path.
   *
   * This has been tested under Win NT, 2000, and XP. It has also been tested
   * under Solaris 7, 8, 9 and Redhat 7, 8, 9, EL3, and Fedora core 2.
   *
   * @param url The web page to launch in the format "http://foo.bar.com"
   *
   * @throws IOException thrown if no browser is sucessfully launched.
   */
    public static void openURL(String url) throws IOException
    {
      int i, j;
      String[] parameters;

      // keep track of whether an exec call has succeeded
      boolean success = false;

      // get the list of browsers to try
      String[][] browsers = getBrowsers();

      for (i = 0; i < browsers.length; i++) {
        try {
          // Construct the parameter array for the exec call.
          // It will be the current browser array, plus the url.
          parameters = new String[browsers[i].length + 1];
          for (j = 0; j < browsers[i].length; j++)
            parameters[j] = browsers[i][j];
          parameters[browsers[i].length] = url;

          // Try to launch the browser
          Runtime.getRuntime().exec(parameters);

          // If the exec call fails, it throws IOException and we won't get to here.
          success = true;
          break;
        }
        catch (IOException e) {
        }
      }

      // If we did not launch anything, throw an IOException. Doing so preserves the legacy interface to this method.
      if (!success)
        throw new IOException("Failed to locate browser executable");
    }


    protected static String[][] getBrowsers()
    {
      String osName = System.getProperty("os.name").toLowerCase();

      if (osName.startsWith("win")) {
        return windowsBrowsers;
      }
      else {
        return unixBrowsers;
      }
    }

    // Windows always works with just one string to try. Rundll32 will do all the work for us.
    // We can't have a list to try, because the exec call will always create a process, even
    // if something went wrong. So unlink unix, we can't detect failutre.
    protected final static String[][] windowsBrowsers = new String[][] {
        new String[] {
        "rundll32.exe", "url.dll,FileProtocolHandler"}
    };


    // Here is a list of browsers to try. The exec call will fail to create a process if
    // for the items in this list that aren't in the user's path. In that case, we'll move
    // on and try the next one in the list.
    protected final static String[][] unixBrowsers = new String[][] {
        new String[] {
        "firefox"}
        ,
        new String[] {
        "mozilla"}
        ,
        new String[] {
        "netscape"}
    };
}
