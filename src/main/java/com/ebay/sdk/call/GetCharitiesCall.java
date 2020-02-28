/*
Copyright (c) 2013 eBay, Inc.
This program is licensed under the terms of the eBay Common Development and
Distribution License (CDDL) Version 1.0 (the "License") and any subsequent  version 
thereof released by eBay.  The then-current version of the License can be found 
at http://www.opensource.org/licenses/cddl1.php and in the eBaySDKLicense file that 
is under the eBay SDK ../docs directory.
*/

package com.ebay.sdk.call;

import java.lang.Boolean;
import java.lang.Integer;
import java.lang.Long;
import java.lang.String;

import com.ebay.sdk.*;
import com.ebay.soap.eBLBaseComponents.*;
/**
 * Wrapper class of the GetCharities call of eBay SOAP API.
 * <br>
 * <p>Title: SOAP API wrapper library.</p>
 * <p>Description: Contains wrapper classes for eBay SOAP APIs.</p>
 * <p>Copyright: Copyright (c) 2009</p>
 * <p>Company: eBay Inc.</p>
 * <br> <B>Input property:</B> <code>CharityID</code> - A unique identification number assigned to a nonprofit
 * organization when that organization registers with the PayPal Giving Fund. If a <b>CharityID</b> value is used in the request, all other search filters set in the call request will be ignored, as the call will only search for the specified nonprofit organization.
 * <br> <B>Input property:</B> <code>CharityName</code> - This field will accept the full or partial name of a registered nonprofit organization. For example, if you pass in a value of <b>heart</b>, all registered nonprofit organizations with "heart" in their name may be returned in the response. If the <b>MatchType</b> field is used and set to <code>StartsWith</code> (default value), or is not used at all, the phrase "heart" must come at the beginning of the nonprofit organization's name to be returned. However, if the <b>MatchType</b> field is used and set to <code>Contains</code>, all registered nonprofit organizations with "heart" in their name should be returned in the response. The string passed in this field is not case-sensitive.
 * <br/><br/>
 * <br> <B>Input property:</B> <code>Query</code> - This field accept any string up to 350 characters in length. The functionality of this field is similar to the <b>CharityName</b> field, except that the call will also search for the supplied query string within the charity's mission statement (which is returned under the <b>Charity.Mission</b> field in the response). If you pass in a value of <b>heart</b>, all registered nonprofit organizations with "heart" in their name or in their mission statement may be returned in the response.
 * <br/><br/>
 * The string passed in this field is not case-sensitive. The <b>MatchType</b> field will have no effect if the <b>Query</b> field is used, as the <b>MatchType</b> field will only have an effect if a <b>CharityName</b> string field is included.
 * <br/><br/>
 * <br> <B>Input property:</B> <code>CharityRegion</code> - This field can be used to search for registered nonprofit organizations within a specified geographical region. Each geographical region will have an integer value associated with it. This integer value is what is passed in to this field.
 * <br> <B>Input property:</B> <code>CharityDomain</code> - This field can be used to search for registered nonprofit organizations within a specified charitable domain. Each charitable domain will have an integer value associated with it. This integer value is what is passed in to this field. Nonprofit organizations can be associated with multiple charitable domains.
 * <br> <B>Input property:</B> <code>IncludeDescription</code> - This field should be included and set to <code>true</code> if a user wants the charity's description to appear in the response. Note that not all charitable organizations will have defined descriptions.
 * <br> <B>Input property:</B> <code>MatchType</code> - This filter is used if the user wants to specify where to look for the string specified in the <b>CharityName</b> field. The enumeration value input into this field controls the type of string matching to use when a value is submitted in the
 * <b>CharityName</b> field. If this field is omitted, and a <b>CharityName</b> string is used, this parameter value defaults to <code>StartsWith</code>.
 * <br/><br/>
 * This field is not applicable when a <b>Query</b> value is used.
 * <br/>
 * <br> <B>Input property:</B> <code>Featured</code> - This boolean field is used and set to <code>true</code> if the user wants to search for nonprofit organizations currently featured on the eBay for Charity site.
 * <br> <B>Input property:</B> <code>CampaignID</code> - Reserved for future use.
 * <br> <B>Output property:</B> <code>ReturnedCharities</code> - Each <b>Charity</b> container consists of information about a specific nonprofit organization. Each nonprofit organization is identified by the <b>id</b> attribute of the container. If no nonprofit organization are found that match the input criteria, no <b>Charity</b> containers are returned.
 * 
 * @author Ron Murphy
 * @version 1.0
 */

public class GetCharitiesCall extends com.ebay.sdk.ApiCall
{
  
  private String charityID = null;
  private String charityName = null;
  private String query = null;
  private Integer charityRegion = null;
  private Integer charityDomain = null;
  private Boolean includeDescription = null;
  private StringMatchCodeType matchType = null;
  private Boolean featured = null;
  private Long campaignID = null;
  private GetCharitiesRequestType overrideRequest=null;
  private CharityInfoType[] returnedCharities=null;


  /**
   * Constructor.
   */
  public GetCharitiesCall() {
  }

  /**
   * Constructor.
   * @param apiContext The ApiContext object to be used to make the call.
   */
  public GetCharitiesCall(ApiContext apiContext) {
    super(apiContext);
    

  }

  /**
   * The <b>GetCharities</b> call is used to search for nonprofit organizations that are registered with the eBay for Charity program. This call allows users to search for a specific nonprofit organization, or to search for multiple nonprofit organizations from a particular charitable domain, and/or geographical region, or by using a search string.
   * 
   * <br>
   * @throws ApiException
   * @throws SdkException
   * @throws Exception
   * @return The void object.
   */
  public void getCharities()
      throws com.ebay.sdk.ApiException, com.ebay.sdk.SdkException, java.lang.Exception
  {
    GetCharitiesRequestType req;
    if (this.overrideRequest != null)
    {
      req = this.overrideRequest;
    } else {
      req = new GetCharitiesRequestType();
      if (this.charityID != null)
        req.setCharityID(this.charityID);
      if (this.charityName != null)
        req.setCharityName(this.charityName);
      if (this.query != null)
        req.setQuery(this.query);
      if (this.charityRegion != null)
        req.setCharityRegion(this.charityRegion);
      if (this.charityDomain != null)
        req.setCharityDomain(this.charityDomain);
      if (this.includeDescription != null)
        req.setIncludeDescription(this.includeDescription);
      if (this.matchType != null)
        req.setMatchType(this.matchType);
      if (this.featured != null)
        req.setFeatured(this.featured);
      if (this.campaignID != null)
        req.setCampaignID(this.campaignID);
  
    }

    GetCharitiesResponseType resp = (GetCharitiesResponseType) execute(req);

    this.returnedCharities = resp.getCharity();

  }

  /**
   * Gets the GetCharitiesRequestType.overrideRequest.
   * @return GetCharitiesRequestType
   */
  public GetCharitiesRequestType getOverrideRequest()
  {
    return this.overrideRequest;
  }


  /**
   * Sets the GetCharitiesRequestType.overrideRequest.
   * @param overrideRequest GetCharitiesRequestType
   */
  public void setOverrideRequest(GetCharitiesRequestType overrideRequest)
  {
    this.overrideRequest = overrideRequest;
  }

  /**
   * Gets the GetCharitiesRequestType.campaignID.
   * @return Long
   */
  public Long getCampaignID()
  {
    return this.campaignID;
  }

  /**
   * Sets the GetCharitiesRequestType.campaignID.
   * @param campaignID Long
   */
  public void setCampaignID(Long campaignID)
  {
    this.campaignID = campaignID;
  }

  /**
   * Gets the GetCharitiesRequestType.charityDomain.
   * @return Integer
   */
  public Integer getCharityDomain()
  {
    return this.charityDomain;
  }

  /**
   * Sets the GetCharitiesRequestType.charityDomain.
   * @param charityDomain Integer
   */
  public void setCharityDomain(Integer charityDomain)
  {
    this.charityDomain = charityDomain;
  }

  /**
   * Gets the GetCharitiesRequestType.charityID.
   * @return String
   */
  public String getCharityID()
  {
    return this.charityID;
  }

  /**
   * Sets the GetCharitiesRequestType.charityID.
   * @param charityID String
   */
  public void setCharityID(String charityID)
  {
    this.charityID = charityID;
  }

  /**
   * Gets the GetCharitiesRequestType.charityName.
   * @return String
   */
  public String getCharityName()
  {
    return this.charityName;
  }

  /**
   * Sets the GetCharitiesRequestType.charityName.
   * @param charityName String
   */
  public void setCharityName(String charityName)
  {
    this.charityName = charityName;
  }

  /**
   * Gets the GetCharitiesRequestType.charityRegion.
   * @return Integer
   */
  public Integer getCharityRegion()
  {
    return this.charityRegion;
  }

  /**
   * Sets the GetCharitiesRequestType.charityRegion.
   * @param charityRegion Integer
   */
  public void setCharityRegion(Integer charityRegion)
  {
    this.charityRegion = charityRegion;
  }

  /**
   * Gets the GetCharitiesRequestType.featured.
   * @return Boolean
   */
  public Boolean getFeatured()
  {
    return this.featured;
  }

  /**
   * Sets the GetCharitiesRequestType.featured.
   * @param featured Boolean
   */
  public void setFeatured(Boolean featured)
  {
    this.featured = featured;
  }

  /**
   * Gets the GetCharitiesRequestType.includeDescription.
   * @return Boolean
   */
  public Boolean getIncludeDescription()
  {
    return this.includeDescription;
  }

  /**
   * Sets the GetCharitiesRequestType.includeDescription.
   * @param includeDescription Boolean
   */
  public void setIncludeDescription(Boolean includeDescription)
  {
    this.includeDescription = includeDescription;
  }

  /**
   * Gets the GetCharitiesRequestType.matchType.
   * @return StringMatchCodeType
   */
  public StringMatchCodeType getMatchType()
  {
    return this.matchType;
  }

  /**
   * Sets the GetCharitiesRequestType.matchType.
   * @param matchType StringMatchCodeType
   */
  public void setMatchType(StringMatchCodeType matchType)
  {
    this.matchType = matchType;
  }

  /**
   * Gets the GetCharitiesRequestType.query.
   * @return String
   */
  public String getQuery()
  {
    return this.query;
  }

  /**
   * Sets the GetCharitiesRequestType.query.
   * @param query String
   */
  public void setQuery(String query)
  {
    this.query = query;
  }

  /**
   * Valid after executing the API.
   * Gets the returned GetCharitiesResponseType.returnedCharities.
   * 
   * @return CharityInfoType[]
   */
  public CharityInfoType[] getReturnedCharities()
  {
    return this.returnedCharities;
  }

}

