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
import java.lang.String;

import com.ebay.sdk.*;
import com.ebay.soap.eBLBaseComponents.*;
/**
 * Wrapper class of the GetUser call of eBay SOAP API.
 * <br>
 * <p>Title: SOAP API wrapper library.</p>
 * <p>Description: Contains wrapper classes for eBay SOAP APIs.</p>
 * <p>Copyright: Copyright (c) 2009</p>
 * <p>Company: eBay Inc.</p>
 * <br> <B>Input property:</B> <code>ItemID</code> - Specify the <strong>ItemID</strong> value for a successfully concluded listing in which the
 * requestor and target user were participants (one as seller and the other
 * as buyer). Necessary to return certain data (like an email address). Not
 * necessary if the requestor is retrieving their own data.
 * <br> <B>Input property:</B> <code>UserID</code> - Specify the user whose data you want returned by the call. If not specified, eBay returns data pertaining to the
 * requesting user (as specified with the <strong>eBayAuthToken</strong> value).
 * <br> <B>Input property:</B> <code>IncludeExpressRequirements</code> - This field is deprecated.
 * <br> <B>Input property:</B> <code>IncludeFeatureEligibility</code> - If the <b>IncludeFeatureEligibility</b> flag is included and set to 'true', the call response will include a <b>QualifiesForSelling</b> flag which indicates if the eBay user is eligible to sell on eBay, and a <b>IncludeFeatureEligibility</b> container which indicates which selling features are available to the user.
 * <br> <B>Output property:</B> <code>ReturnedUser</code> - This container consists of detailed information about the user specified in the call request (through the <b>UserID</b> field) or the eBay user account that is tied to the <strong>eBayAuthToken</strong> value that is passed in the call request.
 * <br><br>
 * Some sensitive data will be masked/omitted if the returned eBay user is not the person making the <b>GetUser</b> call. More information on another eBay user will be revealed to the person making the call if that person has an order relationship for an eBay listing specified in the <strong>ItemID</strong> field of the call request.
 * 
 * @author Ron Murphy
 * @version 1.0
 */

public class GetUserCall extends com.ebay.sdk.ApiCall
{
  
  private String itemID = null;
  private String userID = null;
  private Boolean includeExpressRequirements = null;
  private Boolean includeFeatureEligibility = null;
  private UserType returnedUser=null;


  /**
   * Constructor.
   */
  public GetUserCall() {
  }

  /**
   * Constructor.
   * @param apiContext The ApiContext object to be used to make the call.
   */
  public GetUserCall(ApiContext apiContext) {
    super(apiContext);
    

  }

  /**
   * Retrieves data pertaining to a single eBay user. Callers can use this call to return their own user data or the data of another eBay user. Unless the caller passes in an <strong>ItemID</strong> value that identifies a current or past common order, not all data (like email addresses) will be returned in the response.
   * 
   * <br>
   * @throws ApiException
   * @throws SdkException
   * @throws Exception
   * @return The UserType object.
   */
  public UserType getUser()
      throws com.ebay.sdk.ApiException, com.ebay.sdk.SdkException, java.lang.Exception
  {
    GetUserRequestType req;
    req = new GetUserRequestType();
    req.setDetailLevel(this.getDetailLevel());
    if (this.itemID != null)
      req.setItemID(this.itemID);
    if (this.userID != null)
      req.setUserID(this.userID);
    if (this.includeExpressRequirements != null)
      req.setIncludeExpressRequirements(this.includeExpressRequirements);
    if (this.includeFeatureEligibility != null)
      req.setIncludeFeatureEligibility(this.includeFeatureEligibility);

    GetUserResponseType resp = (GetUserResponseType) execute(req);

    this.returnedUser = resp.getUser();
    return this.getReturnedUser();
  }

  /**
   * Gets the GetUserRequestType.includeExpressRequirements.
   * @return Boolean
   */
  public Boolean getIncludeExpressRequirements()
  {
    return this.includeExpressRequirements;
  }

  /**
   * Sets the GetUserRequestType.includeExpressRequirements.
   * @param includeExpressRequirements Boolean
   */
  public void setIncludeExpressRequirements(Boolean includeExpressRequirements)
  {
    this.includeExpressRequirements = includeExpressRequirements;
  }

  /**
   * Gets the GetUserRequestType.includeFeatureEligibility.
   * @return Boolean
   */
  public Boolean getIncludeFeatureEligibility()
  {
    return this.includeFeatureEligibility;
  }

  /**
   * Sets the GetUserRequestType.includeFeatureEligibility.
   * @param includeFeatureEligibility Boolean
   */
  public void setIncludeFeatureEligibility(Boolean includeFeatureEligibility)
  {
    this.includeFeatureEligibility = includeFeatureEligibility;
  }

  /**
   * Gets the GetUserRequestType.itemID.
   * @return String
   */
  public String getItemID()
  {
    return this.itemID;
  }

  /**
   * Sets the GetUserRequestType.itemID.
   * @param itemID String
   */
  public void setItemID(String itemID)
  {
    this.itemID = itemID;
  }

  /**
   * Gets the GetUserRequestType.userID.
   * @return String
   */
  public String getUserID()
  {
    return this.userID;
  }

  /**
   * Sets the GetUserRequestType.userID.
   * @param userID String
   */
  public void setUserID(String userID)
  {
    this.userID = userID;
  }

  /**
   * Valid after executing the API.
   * Gets the returned GetUserResponseType.returnedUser.
   * 
   * @return UserType
   */
  public UserType getReturnedUser()
  {
    return this.returnedUser;
  }

}

