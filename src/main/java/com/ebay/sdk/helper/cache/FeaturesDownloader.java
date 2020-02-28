/*
Copyright (c) 2013 eBay, Inc.
This program is licensed under the terms of the eBay Common Development and
Distribution License (CDDL) Version 1.0 (the "License") and any subsequent  version 
thereof released by eBay.  The then-current version of the License can be found 
at http://www.opensource.org/licenses/cddl1.php and in the eBaySDKLicense file that 
is under the eBay SDK ../docs directory.
*/

package com.ebay.sdk.helper.cache;

import com.ebay.sdk.ApiContext;
import com.ebay.sdk.call.GetCategoryFeaturesCall;
import com.ebay.soap.eBLBaseComponents.DetailLevelCodeType;
import com.ebay.soap.eBLBaseComponents.FeatureIDCodeType;
import com.ebay.soap.eBLBaseComponents.GetCategoryFeaturesRequestType;
import com.ebay.soap.eBLBaseComponents.GetCategoryFeaturesResponseType;


/**
 * Helper class with cache function for GetCategoryFeatures call
 * @author Conan and William
 *
 */
public class FeaturesDownloader extends BaseDownloader {

	public FeaturesDownloader(ApiContext apiContext){
		super(apiContext);
		this.FILE_EXTENSION = "cfs";
		this.FILE_PREFIX = "AllCatFeatures";
	}
	
	@Override
	protected String getLastUpdateTime() throws Exception {
		GetCategoryFeaturesCall api = new GetCategoryFeaturesCall(apiContext);
		GetCategoryFeaturesRequestType req = new GetCategoryFeaturesRequestType();
		//we only need 'UpdateTime' field
		//req.setOutputSelector(new String[]{"UpdateTime"});
		//workaround, use CategoryVersion instead of UpdateTime here
		req.setOutputSelector(new String[]{"CategoryVersion"});
		api.execute(req);
		GetCategoryFeaturesResponseType resp = (GetCategoryFeaturesResponseType) api.execute(req);
//		Date date = resp.getUpdateTime().getTime();
//		SimpleDateFormat df = new SimpleDateFormat("yyyy_MM_dd_hh_mm_ss");
//		String time = df.format(date);
		return resp.getCategoryVersion();
	}

	@Override
	protected Object individualCall() throws Exception {
		//get all category features for a given site
		  GetCategoryFeaturesCall apiCall = new GetCategoryFeaturesCall(apiContext);
		  FeatureIDCodeType[] featureIds = new FeatureIDCodeType[]{
  				FeatureIDCodeType.LISTING_DURATIONS,
  				FeatureIDCodeType.ITEM_SPECIFICS_ENABLED,
  				FeatureIDCodeType.RETURN_POLICY_ENABLED,
  				FeatureIDCodeType.PAYMENT_METHODS,
  				FeatureIDCodeType.CONDITION_ENABLED,
  				FeatureIDCodeType.CONDITION_VALUES
		  };
		  apiCall.setFeatureIDs(featureIds);

		  // Set detail level.
		  DetailLevelCodeType[] detailLevels = new DetailLevelCodeType[] {DetailLevelCodeType.RETURN_ALL};
		  apiCall.setDetailLevel(detailLevels);
		  apiCall.setViewAllNodes(true);
		  //execute call
		  apiCall.getCategoryFeatures();
		  return apiCall.getResponseObject();
	}

	//get category features for a given site
	public GetCategoryFeaturesResponseType getAllCategoryFeatures() throws Exception{
		Object obj = getObject();
		GetCategoryFeaturesResponseType cfrt = (GetCategoryFeaturesResponseType)obj;
		return cfrt;
	}
}
