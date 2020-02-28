/*
Copyright (c) 2013 eBay, Inc.
This program is licensed under the terms of the eBay Common Development and
Distribution License (CDDL) Version 1.0 (the "License") and any subsequent  version 
thereof released by eBay.  The then-current version of the License can be found 
at http://www.opensource.org/licenses/cddl1.php and in the eBaySDKLicense file that 
is under the eBay SDK ../docs directory.
*/

package com.ebay.sdk.call;

import java.lang.String;

import com.ebay.sdk.*;
import com.ebay.soap.eBLBaseComponents.*;
/**
 * Wrapper class of the GetContextualKeywords call of eBay SOAP API.
 * <br>
 * <p>Title: SOAP API wrapper library.</p>
 * <p>Description: Contains wrapper classes for eBay SOAP APIs.</p>
 * <p>Copyright: Copyright (c) 2009</p>
 * <p>Company: eBay Inc.</p>
 * <br> <B>Input property:</B> <code>URL</code> - The URL of the web page from which eBay is to extract keywords.
 * <br> <B>Input property:</B> <code>Encoding</code> - Web page encoding by which the URL is to be handled, such as ISO-8859-1.
 * <br> <B>Input property:</B> <code>CategoryID</code> - The ID of the category to which keywords are to be limited.
 * Zero or more category IDs can be specified.
 * <br> <B>Output property:</B> <code>ReturnedContextSearchAsset</code> - An array of either keyword/category pairs or categories, with ranking and score.
 * 
 * @author Ron Murphy
 * @version 1.0
 */

public class GetContextualKeywordsCall extends com.ebay.sdk.ApiCall
{
  
  private String uRL = null;
  private String encoding = null;
  private String[] categoryID = null;
  private ContextSearchAssetType[] returnedContextSearchAsset=null;


  /**
   * Constructor.
   */
  public GetContextualKeywordsCall() {
  }

  /**
   * Constructor.
   * @param apiContext The ApiContext object to be used to make the call.
   */
  public GetContextualKeywordsCall(ApiContext apiContext) {
    super(apiContext);
    

  }

  /**
   * Retrieves top-ranked contextual eBay keywords and categories
   * for a specified web page.
   * 
   * <br>
   * @throws ApiException
   * @throws SdkException
   * @throws Exception
   * @return The ContextSearchAssetType[] object.
   */
  public ContextSearchAssetType[] getContextualKeywords()
      throws com.ebay.sdk.ApiException, com.ebay.sdk.SdkException, java.lang.Exception
  {
    GetContextualKeywordsRequestType req;
    req = new GetContextualKeywordsRequestType();
    if (this.uRL != null)
      req.setURL(this.uRL);
    if (this.encoding != null)
      req.setEncoding(this.encoding);
    if (this.categoryID != null)
      req.setCategoryID(this.categoryID);

    GetContextualKeywordsResponseType resp = (GetContextualKeywordsResponseType) execute(req);

    this.returnedContextSearchAsset = resp.getContextSearchAsset();
    return this.getReturnedContextSearchAsset();
  }

  /**
   * Gets the GetContextualKeywordsRequestType.categoryID.
   * @return String[]
   */
  public String[] getCategoryID()
  {
    return this.categoryID;
  }

  /**
   * Sets the GetContextualKeywordsRequestType.categoryID.
   * @param categoryID String[]
   */
  public void setCategoryID(String[] categoryID)
  {
    this.categoryID = categoryID;
  }

  /**
   * Gets the GetContextualKeywordsRequestType.encoding.
   * @return String
   */
  public String getEncoding()
  {
    return this.encoding;
  }

  /**
   * Sets the GetContextualKeywordsRequestType.encoding.
   * @param encoding String
   */
  public void setEncoding(String encoding)
  {
    this.encoding = encoding;
  }

  /**
   * Gets the GetContextualKeywordsRequestType.uRL.
   * @return String
   */
  public String getURL()
  {
    return this.uRL;
  }

  /**
   * Sets the GetContextualKeywordsRequestType.uRL.
   * @param uRL String
   */
  public void setURL(String uRL)
  {
    this.uRL = uRL;
  }

  /**
   * Valid after executing the API.
   * Gets the returned GetContextualKeywordsResponseType.returnedContextSearchAsset.
   * 
   * @return ContextSearchAssetType[]
   */
  public ContextSearchAssetType[] getReturnedContextSearchAsset()
  {
    return this.returnedContextSearchAsset;
  }

}

