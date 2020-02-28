/*
Copyright (c) 2013 eBay, Inc.
This program is licensed under the terms of the eBay Common Development and
Distribution License (CDDL) Version 1.0 (the "License") and any subsequent  version 
thereof released by eBay.  The then-current version of the License can be found 
at http://www.opensource.org/licenses/cddl1.php and in the eBaySDKLicense file that 
is under the eBay SDK ../docs directory.
*/


package com.ebay.sdk.pictureservice;

import com.ebay.sdk.ErrorInfoImpl;
import com.ebay.soap.eBLBaseComponents.UploadSiteHostedPicturesResponseType;
/**
 *
 * <p>Title: </p>
 * <p>Description: Defines picture object for PictureService. It contains
 * local picture file path, URI of the uploaded file and uploading error.
 * and response object.
 * </p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: eBay Inc.</p>
 * @author Weijun Li
 * @version 1.0
 */
public class PictureInfo extends ErrorInfoImpl {

  private String picURL;
  private String filePath;
  private UploadSiteHostedPicturesResponseType reponse;

  /**
   * Get the response object.
   * @return UploadSiteHostedPicturesResponseType object.
   */
  public UploadSiteHostedPicturesResponseType getReponse() {
	return reponse;
  }

  /**
   * set the response object.
   * @param response object to be set.
   */
  public void setReponse(UploadSiteHostedPicturesResponseType reponse) {
	this.reponse = reponse;
  }

/**
   * Constructor.
   */
  public PictureInfo() {
  }

  /**
   * Get the URI of the uploaded picture.
   * @return URI of the uploaded picture.
   */
  public String getURL() {
    return this.picURL;
  }

  /**
   * Set the URI of the uploaded picture.
   * @param url URI of the uploaded picture.
   */
  public void setURL(String url) {
    this.picURL = url;
  }

  /**
   * Gets the path of the picture file to be uploaded.
   * @return Picture file path.
   */
  public String getPictureFilePath() {
    return this.filePath;
  }

  /**
   * Sets the path of the picture file to be uploaded.
   * @param filePath Picture file path.
   */
  public void setPictureFilePath(String filePath) {
    this.filePath = filePath;
  }
}
