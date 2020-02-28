/*
Copyright (c) 2013 eBay, Inc.
This program is licensed under the terms of the eBay Common Development and
Distribution License (CDDL) Version 1.0 (the "License") and any subsequent  version 
thereof released by eBay.  The then-current version of the License can be found 
at http://www.opensource.org/licenses/cddl1.php and in the eBaySDKLicense file that 
is under the eBay SDK ../docs directory.
*/

package com.ebay.sdk.pictureservice;

import com.ebay.soap.eBLBaseComponents.*;

/**
 * Defines object that uploads pictures to EPS server and get
 * the uploaded URLs back.
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2008</p>
 * <p>Company: eBay Inc.</p>
 * @author Weijun Li, changed by William Yang
 * @version 1.1
 */
public interface PictureService {
	
	
	
	
	 UploadSiteHostedPicturesResponseType uploadSiteHostedPictures(UploadSiteHostedPicturesRequestType request);


      /**
	   * Upload one picture file to EPS server, this interface is for those
	   * who want to operate on UploadSiteHostedPicturesRequestType directly.
       * @param picInfo Contains the local picture file path, uploading error,
       * response object and URL if the uploading succeeded.
	   * @param request the UploadSiteHostedPicturesRequestType object.
	   * @return true means the uploading succeeded. Otherwise check picInfo
	   * for detailed error information.
	   */
	  boolean UpLoadSiteHostedPicture(PictureInfo picInfo, UploadSiteHostedPicturesRequestType request);
	
	
	  /**
	   * Upload one picture file to EPS server.
	   * @param option The PhotoDisplayCodeType option.
       * @param picInfo Contains the local picture file path, uploading error,
       * response object and URL if the uploading succeeded.
	   * @param firstImage If this is the first image for the particular item,
	   * 		the picture generated will be different based on if this is the
	   * 		first image for the item or not.
	   * @return true means the uploading succeeded. Otherwise check picInfo
	   * for detailed error information.
	   */
	  boolean uploadPicture(PhotoDisplayCodeType option,
	  		PictureInfo picInfo);

	  /**
	   * Upload list of picture files to EPS server.
	   * @param option The PhotoDisplayCodeType option.
	   * @param picInfoList List of PictureInfo objects. Each object contains
	   * the local picture file path, uploading error, response object and URI if the uploading
	   * succeeded.
	   * @return Number of pictures that have been successfully uploaded. Loop
	   * through picInfoList for individual uploading error.
	   */
	  int uploadPictures(PhotoDisplayCodeType option, PictureInfo[] picInfoList);
	

}
