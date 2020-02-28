/*
Copyright (c) 2013 eBay, Inc.
This program is licensed under the terms of the eBay Common Development and
Distribution License (CDDL) Version 1.0 (the "License") and any subsequent  version 
thereof released by eBay.  The then-current version of the License can be found 
at http://www.opensource.org/licenses/cddl1.php and in the eBaySDKLicense file that 
is under the eBay SDK ../docs directory.
*/


package com.ebay.sdk.pictureservice.eps;

import com.ebay.sdk.ApiContext;
import com.ebay.sdk.pictureservice.PictureService;

/**
 * @author cli
 *
 * This is the factory class for picture service. It hinds the implementation
 * class eBayPictureService from the client, and gives the flexibility to change
 * the class without affect the client.
 *
 */
public class eBayPictureServiceFactory {

  /**
   * This function could return null, if the "init" function is not called
   * before using this function. An exception could be throw in that case,
   * but to force the user of this function to catch the exception every time
   * use it could be less friedly than let the client make sure the init is
   * always called at the beginning of his/her application.
   * @param apiContext The ApiContext object for which you want to create PictureService for.
   * @return picture service implemenation object. NULL if the initialization
   * 		function is not called by the client application.
   */
  static public PictureService getPictureService(ApiContext apiContext) {
    return new eBayPictureServiceXMLCall(apiContext);
  }
}
