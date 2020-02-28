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
 * This class provides a thread local SingleCallMetrics, so that during the execution
 * of the thread, different classes can access the metrics object to log information.
 * 
 * @author wdeng
 *
 */
public class ThreadLocalSingleCallMetrics
{
	private static final ThreadLocal<SingleCallMetrics> THREAD_LOCAL = new ThreadLocal<SingleCallMetrics>();

	public static SingleCallMetrics getSingleCallMetrics()
	{
		return THREAD_LOCAL.get();
	}

	public static void resetSingleCallMetrics()
	{
		THREAD_LOCAL.set(new SingleCallMetrics());
	}
}
