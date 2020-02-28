/*
Copyright (c) 2013 eBay, Inc.
This program is licensed under the terms of the eBay Common Development and
Distribution License (CDDL) Version 1.0 (the "License") and any subsequent  version 
thereof released by eBay.  The then-current version of the License can be found 
at http://www.opensource.org/licenses/cddl1.php and in the eBaySDKLicense file that 
is under the eBay SDK ../docs directory.
*/
package com.ebay.sdk.logging;

import java.io.PrintStream;
import java.util.Date;
import com.ebay.sdk.util.eBayUtil;

/**
 * A class to keep metrics for a single API call.
 * 
 * @author wdeng
 *
 */
public class SingleCallMetrics  
{
	private String callname;
	private long apiCallStarted;
	private long getSocketConnectionStarted;
	private long getSocketConnectionEnded;
	private long socketReadStarted;
	private long apiCallEnded;
	private long serverProcessingTime;
	private long sdkJAXBCallInvokeStarted;
	private long sdkJAXBCallInvokeEnded;
	
	/**
	 * @return sdkJAXBCallInvokeStarted long
	 */
	public long getSdkJAXBCallInvokeStarted(){
		return sdkJAXBCallInvokeStarted;
	}
	
	/**
	 * @return sdkJAXBCallInvokeEnded long
	 */
	public long getSdkJAXBCallInvokeEnded(){
		return sdkJAXBCallInvokeEnded;
	}
	
	/**
	 * @return apiCallEnded long
	 */
	public long getApiCallEnded() {
		return apiCallEnded;
	}

	/**
	 * @return apiCallStarted long
	 */
	public long getApiCallStarted() {
		return apiCallStarted;
	}

	/**
	 * @return getSocketConnectionEnded long
	 */
	public long getSocketEnded() {
		return getSocketConnectionEnded;
	}

	/**
	 * @return getSocketConnectionStarted long
	 */
	public long getSocketStarted() {
		return getSocketConnectionStarted;
	}


	/**
	 * @return socketReadStarted long
	 */
	public long getSocketReadStarted() {
		return socketReadStarted;
	}
	
	/**
	 * @param l long
	 */
	public void setSdkJAXBCallInvokeStarted(long l){
		sdkJAXBCallInvokeStarted = l;
	}

	/**
	 * @param l long
	 */
	public void setSdkJAXBCallInvokeEnded(long l){
		sdkJAXBCallInvokeEnded = l;
	}
	
	/**
	 * @param l long
	 */
	public void setApiCallEnded(long l) {
		apiCallEnded = l;
	}

	/**
	 * @param l long
	 */
	public void setApiCallStarted(long l) {
		apiCallStarted = l;
	}

	/**
	 * @param l long
	 */
	public void setGetSocketEnded(long l) {
		getSocketConnectionEnded = l;
	}

	/**
	 * @param l long
	 */
	public void setGetSocketStarted(long l) {
		getSocketConnectionStarted = l;
	}


	public void setServerProcessingTime(long l) {
		serverProcessingTime = l;
	}

	/**
	 * @param l long
	 */
	public void setSocketReadStarted(long l) {
		socketReadStarted = l;
	}

	public long getTurnaroundTime()
	{
		return getTimeInterval(getApiCallStarted(), getApiCallEnded());
	}
	
	public long getPreJAXBInvokeTime(){
		return getTimeInterval(getApiCallStarted(), getSdkJAXBCallInvokeStarted());
	}
	
	public long getPostJAXBInvokeTime(){
		return getTimeInterval(getSdkJAXBCallInvokeEnded(), getApiCallEnded());
	}


	public long getSocketConnectionTime()
	{
		return getTimeInterval(getSocketStarted(), getSocketEnded());
	}

	/*public long getNetworkAndServerTime()
	{
		return getTimeInterval(getSocketEnded(), getSocketReadStarted());
	}*/

	public long getNetworkAndServerTime()
	{
		return getTimeInterval(this.getSdkJAXBCallInvokeStarted(), this.getSdkJAXBCallInvokeEnded());
	}
	
	public long getServerProcessingTime()
	{
		return serverProcessingTime;
	}

	public long getNetworkTime()
	{
		return getTimeInterval(getServerProcessingTime(), getNetworkAndServerTime());
	}

	private long getTimeInterval(long start, long end)
	{
		if (start == 0 || end == 0)
		{
			// one of the time is not recorded, returns -1.
			return -1;
		}
		return end - start;
	}
	
	public void generateReport(PrintStream ps)
	{
		CallMetrics.printOneNumber(ps, getTurnaroundTime());
		CallMetrics.printOneNumber(ps, getPreJAXBInvokeTime());
		CallMetrics.printOneNumber(ps, getPostJAXBInvokeTime());
		
		//CallMetrics.printOneNumber(ps, getPreAxisInvokeTime());
		//CallMetrics.printOneNumber(ps, getSocketConnectionTime());
		CallMetrics.printOneNumber(ps, getNetworkTime());
		CallMetrics.printOneNumber(ps, getServerProcessingTime());
		//CallMetrics.printOneNumber(ps, getResponseReceivingTime());
		//CallMetrics.printOneNumber(ps, getPostAxisInvokeTime());
		
		Date date = new Date(this.getApiCallStarted());
		CallMetrics.printOneString(ps, eBayUtil.toAPITimeString(date), 20);
		ps.println();		
	}
	
	void updateTotals(long[] totals)
	{
		totals[0] += getTurnaroundTime();
		totals[1] += getPreJAXBInvokeTime();
		totals[2] += getPostJAXBInvokeTime();
		
		//totals[1] += getPreAxisInvokeTime();
		//totals[2] += getSocketConnectionTime();
		totals[3] += getNetworkTime();
		totals[4] += getServerProcessingTime();
		//totals[5] += getResponseReceivingTime();
		//totals[6] += getPostAxisInvokeTime();
		
	}
	/**
	 * @return callname String
	 */
	public String getCallname() {
		return callname;
	}

	/**
	 * @param string
	 */
	public void setCallname(String string) {
		callname = string;
	}

}
