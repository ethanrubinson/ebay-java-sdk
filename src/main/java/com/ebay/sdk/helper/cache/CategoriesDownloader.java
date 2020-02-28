/*
Copyright (c) 2013 eBay, Inc.
This program is licensed under the terms of the eBay Common Development and
Distribution License (CDDL) Version 1.0 (the "License") and any subsequent  version 
thereof released by eBay.  The then-current version of the License can be found 
at http://www.opensource.org/licenses/cddl1.php and in the eBaySDKLicense file that 
is under the eBay SDK ../docs directory.
*/
package com.ebay.sdk.helper.cache;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.ebay.sdk.ApiContext;
import com.ebay.sdk.call.GetCategoriesCall;
import com.ebay.soap.eBLBaseComponents.CategoryType;
import com.ebay.soap.eBLBaseComponents.DetailLevelCodeType;
import com.ebay.soap.eBLBaseComponents.GetCategoriesRequestType;
import com.ebay.soap.eBLBaseComponents.GetCategoriesResponseType;

/**
 * Helper class with cache function for GetCategories call
 * @author Conan and William
 *
 */
public class CategoriesDownloader extends BaseDownloader {
	
	public CategoriesDownloader(ApiContext apiContext){
		super(apiContext);
		this.FILE_EXTENSION = "cats";
		this.FILE_PREFIX = "AllCategories";
	}
	
	@Override
	protected String getLastUpdateTime() throws Exception{
		GetCategoriesCall api = new GetCategoriesCall(apiContext);
		GetCategoriesRequestType req = new GetCategoriesRequestType();
		//we only need 'UpdateTime' field
		req.setOutputSelector(new String[]{"UpdateTime"});
		api.execute(req);
		GetCategoriesResponseType resp = (GetCategoriesResponseType) api.execute(req);
		Date date = resp.getUpdateTime().getTime();
		SimpleDateFormat df = new SimpleDateFormat("yyyy_MM_dd_hh_mm_ss");
		String time = df.format(date);
		return time;
	}
	
	@Override
	protected Object individualCall() throws Exception{
		//get all categories for this site
		GetCategoriesCall apiCall = new GetCategoriesCall(apiContext);
		apiCall.setViewAllNodes(true);
		// Set detail level.
		DetailLevelCodeType[] detailLevels = new DetailLevelCodeType[] {DetailLevelCodeType.RETURN_ALL};
		apiCall.setDetailLevel(detailLevels);
		apiCall.setCategorySiteID(apiContext.getSite());
		//execute call
		apiCall.getCategories();
		return apiCall.getResponse();
	}

	public CategoryType[] getAllCategories() throws Exception{
		Object obj = getObject();
		GetCategoriesResponseType crt = (GetCategoriesResponseType)obj;
		return crt.getCategoryArray().getCategory();
	}
	
}
