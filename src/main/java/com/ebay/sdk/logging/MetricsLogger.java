/*
Copyright (c) 2013 eBay, Inc.
This program is licensed under the terms of the eBay Common Development and
Distribution License (CDDL) Version 1.0 (the "License") and any subsequent  version 
thereof released by eBay.  The then-current version of the License can be found 
at http://www.opensource.org/licenses/cddl1.php and in the eBaySDKLicense file that 
is under the eBay SDK ../docs directory.
*/
package com.ebay.sdk.logging;

/**
 * This is the interface class for this logging package. It contains methods for 
 * enabled logging, prepare to log for a single call, etc.
 * 
 * @author wdeng
 *
 */
public class MetricsLogger 
{

	public static final String KEY_METRICS_LOGGING_ENABLED = "com.ebay.sdk.MetricsLogging";
	
	public static void enableMetricsLogging()
	{
	  System.setProperty(KEY_METRICS_LOGGING_ENABLED, "true");
	}
	
	public static boolean metricsLoggingEnabled()
	{
		String property = System.getProperty(KEY_METRICS_LOGGING_ENABLED);
		return property != null && "true".equalsIgnoreCase(property);
	}
	
	public static void 	startRecordingSingleCallMetrics(String apiName)
	{
		if (!metricsLoggingEnabled())
		{
			return;
		}
		ThreadLocalSingleCallMetrics.resetSingleCallMetrics();
		SingleCallMetrics metrics = ThreadLocalSingleCallMetrics.getSingleCallMetrics();
		metrics.setCallname(apiName);
		metrics.setApiCallStarted(System.currentTimeMillis());
	}
	
	
	public static SingleCallMetrics endRecordingSingleCallMetrics()
	{
		if (!metricsLoggingEnabled())
		{
			return null;
		}
		SingleCallMetrics metrics = ThreadLocalSingleCallMetrics.getSingleCallMetrics();
		metrics.setApiCallEnded(System.currentTimeMillis());
		return metrics;
	}
	
	public static SingleCallMetrics getSingleCallMetrics()
	{
		if (!metricsLoggingEnabled())
		{
			return null;
		}
		return ThreadLocalSingleCallMetrics.getSingleCallMetrics();
	}
	
	public static void collectMetrics(CallMetrics metrics)
	{
		if (!metricsLoggingEnabled())
		{
			return;
		}
		SingleCallMetrics singleMetrics = ThreadLocalSingleCallMetrics.getSingleCallMetrics();
		if (null == singleMetrics)
		{
			return;
		}
		metrics.addCallMetrics(singleMetrics);
	}
	
	public static void startSdkJAXBCallInvoke(){
		if (!metricsLoggingEnabled())
		{
			return;
		}
		SingleCallMetrics metrics = ThreadLocalSingleCallMetrics.getSingleCallMetrics();
		metrics.setSdkJAXBCallInvokeStarted(System.currentTimeMillis());
	}
	
	public static void recordServerProcessingTime(long l){
		if (!metricsLoggingEnabled())
		{
			return;
		}
		SingleCallMetrics metrics = ThreadLocalSingleCallMetrics.getSingleCallMetrics();
		metrics.setServerProcessingTime(l);
	}
	
	public static void endSdkJAXBCallInvoke(){
		if (!metricsLoggingEnabled())
		{
			return;
		}
		SingleCallMetrics metrics = ThreadLocalSingleCallMetrics.getSingleCallMetrics();
		metrics.setSdkJAXBCallInvokeEnded(System.currentTimeMillis());
	}
}
