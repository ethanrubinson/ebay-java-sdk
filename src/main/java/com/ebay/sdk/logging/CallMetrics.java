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
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

/**
 * This class contains list of metrics data for all the api calls during a test section.
 * It also contains the logic to output metrics report.
 * 
 * @author wdeng
 *
 */
public class CallMetrics 
{
	public static final int NUMBER_OF_COLUMNS = 5;
	
	// A map of vector, each vector contains metrics for api calls w/ the same callname.
	private HashMap callMetricsTable = new HashMap();
	
	private static final String SPACES = "                                 ";
	static void printOneNumber(PrintStream ps, long time)
	{
		String timeString = String.valueOf(time);
		ps.print(timeString + SPACES.substring(0, 10 - timeString.length()));
	}
	
	static void printOneString(PrintStream ps, String str, int columnWidth)
	{
		ps.print(str + SPACES.substring(0, columnWidth - str.length()));
	}
	
	public synchronized void addCallMetrics(SingleCallMetrics metrics)
	{
		String callname = metrics.getCallname();
		Vector metricsList = (Vector)callMetricsTable.get(callname);
		if (null == metricsList)
		{
			metricsList = new Vector();
			callMetricsTable.put(callname, metricsList);
		}
		metricsList.add(metrics);
	}
	
	public void generateReport(PrintStream ps)
	{
		if (callMetricsTable.size() == 0)
		{
			ps.println("No metrics data found");
			return;
		}
		Iterator iter = callMetricsTable.keySet().iterator();
		while (iter.hasNext())
		{
			String callName = (String)iter.next();
			List callMetricsList = (List)callMetricsTable.get(callName);
			ps.println("== " + callName + " ==");
			generateReportForSingleCallname(ps, callMetricsList);
			ps.println("\n");
		}
	}
	
	public void generateReportForSingleCallname(PrintStream ps, List callMetricsList)
	{
		ps.println("Number of calls recorded: " + callMetricsList.size());
		Collection goodSamples = normalize(callMetricsList);
		ps.println("Number of calls for statistics: " + goodSamples.size());
		ps.print("Total" + SPACES.substring(0, 10 - "Total".length()));
		ps.print("PreJAXB" + SPACES.substring(0, 10 - "PreJAXB".length()));
		ps.print("PostJAXB" + SPACES.substring(0, 10 - "PostJAXB".length()));
		ps.print("Network" + SPACES.substring(0, 10 - "Network".length()));
		ps.print("Server" + SPACES.substring(0, 10 - "Server".length()));
		ps.print("Start Time" + SPACES.substring(0, 10 - "Start Time".length()));
		ps.println();
		ps.println("=========================================================================");
		Iterator iter = callMetricsList.iterator();
		while (iter.hasNext())
		{
			SingleCallMetrics metrics = (SingleCallMetrics)	iter.next();
			metrics.generateReport(ps);
		}
		ps.println("=========================================================================");
		if (goodSamples.size() != 0)
		{
			long[] averages = generateAverage(goodSamples);
			for (int i = 0; i<averages.length; i++)
			{
				printOneNumber(ps, averages[i]);
			}
		}
		ps.println();
	}
	
	private long[] generateAverage(Collection goodSamples)
	{
		long [] averages = new long[NUMBER_OF_COLUMNS];
		
		for (int i=0; i<averages.length; i++)
		{
			averages[i] = 0;
		}
		Iterator iter = goodSamples.iterator();
		while (iter.hasNext())
		{
			SingleCallMetrics metrics = (SingleCallMetrics)	iter.next();
			metrics.updateTotals(averages);
		}
		for (int i=0; i<averages.length; i++)
		{
			averages[i] /= goodSamples.size();
		}
		return averages;
	}
	
	private static class SortByTurnAroundTime implements Comparator
	{
		public int compare(Object o1, Object o2)
		{
			if (!(o1 instanceof SingleCallMetrics))
			{
				return 0;
			}
			SingleCallMetrics metrics1 = (SingleCallMetrics)o1;
			long turnAroundTime1 = metrics1.getTurnaroundTime();
			
			if (!(o2 instanceof SingleCallMetrics))
			{
				return 0;
			}
			SingleCallMetrics metrics2 = (SingleCallMetrics)o2;
			long turnAroundTime2 = metrics2.getTurnaroundTime();
			if (turnAroundTime1 > turnAroundTime2)
			{
				return -1;
			}
			if (turnAroundTime1 < turnAroundTime2)
			{
				return 1;
			}
			return 0;
		}
	}
	
	private Collection normalize(List metricsList)
	{
		Collections.sort(metricsList, new SortByTurnAroundTime());		
		int totalNumberSamples =metricsList.size(); 
		int numSampleToTrim = (int)((5.0 * totalNumberSamples / 100.0) + 0.5) ;
		if (numSampleToTrim <= 0)
		{
			numSampleToTrim = 1;
		}
		
		ArrayList returnList = new ArrayList();
		Iterator iter = metricsList.iterator();
		int count = 0;
		while (iter.hasNext())
		{
			Object value = iter.next();
			if (count >= numSampleToTrim && count < totalNumberSamples - numSampleToTrim)
				returnList.add(value);
			count++;
		}
		return returnList;
	}
}
