/*
Copyright (c) 2013 eBay, Inc.
This program is licensed under the terms of the eBay Common Development and
Distribution License (CDDL) Version 1.0 (the "License") and any subsequent  version 
thereof released by eBay.  The then-current version of the License can be found 
at http://www.opensource.org/licenses/cddl1.php and in the eBaySDKLicense file that 
is under the eBay SDK ../docs directory.
*/

package com.ebay.sdk.helper;

import com.ebay.soap.eBLBaseComponents.AttributeRecommendationsType;
import com.ebay.soap.eBLBaseComponents.AttributeSetType;
import com.ebay.soap.eBLBaseComponents.AttributeType;
import com.ebay.soap.eBLBaseComponents.GetRecommendationsResponseContainerType;
import com.ebay.soap.eBLBaseComponents.ListingAnalyzerRecommendationsType;
import com.ebay.soap.eBLBaseComponents.ListingTipType;
import com.ebay.soap.eBLBaseComponents.PricingRecommendationsType;
import com.ebay.soap.eBLBaseComponents.ProductInfoType;
import com.ebay.soap.eBLBaseComponents.ProductRecommendationsType;

public class GetRecommendationsResponseHelper {
	
	public static String toString(GetRecommendationsResponseContainerType response) {
		StringBuffer sb = new StringBuffer();
		
		ListingAnalyzerRecommendationsType listingAnalyzerRecoms = getListinAnalyzerRecommendations(response);
		PricingRecommendationsType pricingRecoms = getPricingRecommendations(response);
		ProductRecommendationsType productRecoms = getProductRecommendations(response);
		AttributeRecommendationsType attribRecoms = getAttributeRecommendations(response);
		
		if(listingAnalyzerRecoms != null) {
			sb.append("Listing Analyzer Recommendation Engine:\n");
			ListingTipType[] listingTips = listingAnalyzerRecoms.getListingTipArray().getListingTip();
			sb.append("\tListing Tips:\n");
			for(int i = 0; i < listingTips.length; i++) {
				sb.append("\t\tTip ID: ").append(listingTips[i].getListingTipID()).append(" Priority: ").append(listingTips[i].getPriority());
				sb.append(" *** Help URL: ").append(listingTips[i].getMessage().getHelpURLPath()).append("\n\t\t\t");
				sb.append(listingTips[i].getMessage().getLongMessage()).append("\n");
			}
		} if(pricingRecoms != null) {
			sb.append("\nProduct Pricing Engine Recommendations:\n");
			ProductInfoType productInfo = pricingRecoms.getProductInfo();
			sb.append("\tTitle: ").append(productInfo.getTitle());
			sb.append("\n\tProduct ID: ").append(productInfo.getProductInfoID());
			sb.append("\n\tAvg Start Price:").append(productInfo.getAverageStartPrice().getValue());
			sb.append("\n\tAvg Sold Price:").append(productInfo.getAverageSoldPrice().getValue());			
		} if(productRecoms != null) {
			sb.append("\nProduct Recommendations:\n");
			ProductInfoType[] productInfos = productRecoms.getProduct();
			for(int i = 0; i < productInfos.length; i++) {
				sb.append("\tTitle: ").append(productInfos[i].getTitle());
				sb.append("\n\tProduct ID: ").append(productInfos[i].getProductInfoID());
				sb.append("\n\tAvg Start Price:").append(productInfos[i].getAverageStartPrice().getValue());
				sb.append("\n\tAvg Sold Price:").append(productInfos[i].getAverageSoldPrice().getValue());	
				sb.append("\n");
			}
		} 
		if(attribRecoms != null) {
			sb.append("\nSuggested Attributes Engine Recommendations:\n");
			AttributeSetType[] attribs = attribRecoms.getAttributeSetArray().getAttributeSet();
			if(attribs != null) {
				for(int i = 0; i < attribs.length; i++) {
					sb.append("\n\tATTR Set ID: ").append(attribs[i].getAttributeSetID());
					AttributeType[] attrTypes = attribs[i].getAttribute();
					if(attrTypes != null) {
						for(int j = 0; j < attrTypes.length; j++) {
							sb.append("\n\t\tATTR ID: ").append(attrTypes[j].getAttributeID()).append(" ATTR Label: ").append(attrTypes[j].getAttributeLabel());
							sb.append(" ATTR Value: ").append(attrTypes[j].getValue());
						}				
					}
				}
			}
		} else {
			sb.append("No recommendations");
		}
		
		return sb.toString();
	}
	
	public static ListingAnalyzerRecommendationsType getListinAnalyzerRecommendations(GetRecommendationsResponseContainerType response) {
		return response.getListingAnalyzerRecommendations();
	}
	
	public static PricingRecommendationsType getPricingRecommendations(GetRecommendationsResponseContainerType response) {
		return response.getPricingRecommendations();
	}
	
	public static ProductRecommendationsType getProductRecommendations(GetRecommendationsResponseContainerType response) {
		return response.getProductRecommendations();
	}
	
	public static AttributeRecommendationsType getAttributeRecommendations(GetRecommendationsResponseContainerType response) {
		return response.getAttributeRecommendations();
	}
}
