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
import com.ebay.sdk.call.GeteBayDetailsCall;
import com.ebay.soap.eBLBaseComponents.*;


/**
 * Helper class with cache function for GeteBayDetails call
 * @author William
 *
 */
public class DetailsDownloader extends BaseDownloader {

	public DetailsDownloader(ApiContext apiContext){
		super(apiContext);
		this.FILE_EXTENSION = "eds";
		this.FILE_PREFIX = "EBayDetails";
	}
	
	@Override
	protected String getLastUpdateTime() throws Exception {
		GeteBayDetailsCall api = new GeteBayDetailsCall(apiContext);
		//we only need 'UpdateTime' field
		api.setOutputSelector(new String[]{"UpdateTime"});
		api.setDetailName(this.getDetailNames());
		
		//call the API
		api.geteBayDetails();
		
		GeteBayDetailsResponseType resp = api.getReturnedeBayDetails();
		Date date = resp.getUpdateTime().getTime();
		SimpleDateFormat df = new SimpleDateFormat("yyyy_MM_dd_hh_mm_ss");
		String timeStr = df.format(date);
		return timeStr;
	}
	
	private DetailNameCodeType[] getDetailNames()  {
	    DetailNameCodeType[] detailNames = new DetailNameCodeType[] {
	    		DetailNameCodeType.SHIPPING_SERVICE_DETAILS,
	    		DetailNameCodeType.SHIPPING_LOCATION_DETAILS,
	    		DetailNameCodeType.RETURN_POLICY_DETAILS,
	    		};
	    return detailNames;
	}

	@Override
	protected Object individualCall() throws Exception {
		//get eBay details for a given site
		GeteBayDetailsCall api = new GeteBayDetailsCall(apiContext);
		api.setDetailName(this.getDetailNames());
		
		//call the API
		api.geteBayDetails();
		
		return api.getResponseObject();
	}

	//get eBay details for a given site
	public GeteBayDetailsResponseType geteBayDetails() throws Exception {
		Object obj = getObject();
		GeteBayDetailsResponseType resp = (GeteBayDetailsResponseType)obj;
		return resp;
	}
}

