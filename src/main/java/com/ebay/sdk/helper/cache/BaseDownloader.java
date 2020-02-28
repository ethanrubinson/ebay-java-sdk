/*
Copyright (c) 2013 eBay, Inc.
This program is licensed under the terms of the eBay Common Development and
Distribution License (CDDL) Version 1.0 (the "License") and any subsequent  version 
thereof released by eBay.  The then-current version of the License can be found 
at http://www.opensource.org/licenses/cddl1.php and in the eBaySDKLicense file that 
is under the eBay SDK ../docs directory.
*/

package com.ebay.sdk.helper.cache;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import com.ebay.sdk.ApiContext;

/**
 * Base class for meta-data cache
 * @author Conan & William
 *
 */
public abstract class BaseDownloader {
	
	protected ApiContext apiContext;
	protected String FILE_NAME_PATTERN = "{0}_{1}"; // pattern: site_lastUpdateTime
	protected String FILE_EXTENSION = "null"; // specified by subclass
	protected String FILE_PREFIX = ""; // specified by subclass
	protected String ROOT_DIR; //root directory for meta-data cache
	protected String lastUpdateTime; //the latest update time of the meta-data
	
	public BaseDownloader(ApiContext apiContext){
		this.apiContext = apiContext;
	}
	
	//initialize ROOT_DIR and lastUpdateTime
	private void init() throws Exception{
		ROOT_DIR = new File (".").getCanonicalPath();
		this.lastUpdateTime = getLastUpdateTime();
	}
	
	//search latest file in the root directory
	private String searchFile() throws Exception{
		File dir = new File(ROOT_DIR);
		String[] dataFiles = getDataFiles(dir);
		return foundLatest(dataFiles);
	}
	
	//find the latest cached file
	private String foundLatest(String[] dataFiles) {
		String name = java.text.MessageFormat.format(FILE_PREFIX+ "_"+FILE_NAME_PATTERN,
				new Object[]{apiContext.getSite().toString(),lastUpdateTime});
		for(int i = 0;i<dataFiles.length; i++){
			if(dataFiles[i].startsWith(name)){
				return dataFiles[i];
			}
		}
		return null;
	}
	
	//find all data files with specified prefix and extension in the root directory
	private String[] getDataFiles(File dir) {
		FilenameFilter filter = new FilenameFilter() {
	        public boolean accept(File dir, String name) {
	  		  	String site = apiContext.getSite().toString();
	            return name.startsWith(FILE_PREFIX+ "_" + site) &&
	                   name.endsWith(FILE_EXTENSION);
	        }
	    };
	    String [] files = dir.list(filter);
	    return files;
	}
	
	//get object from xml data
	protected Object getObject() throws Exception{
		init();
		String fileName = searchFile();
		Object obj;
		//if the file is not cached, get live data from ebay site
		if(fileName == null){
			obj = getFromSite();
		}else{ 
			//if the file is cached, get cached data
			obj = getFromFile(fileName);
		}
		return obj;
	}
	
	//get object from cached data file
	private Object getFromFile(String fileName) throws Exception{
		String path = ROOT_DIR+"/"+fileName;
		FileInputStream f_in = new FileInputStream (path);
		ObjectInputStream obj_in = new ObjectInputStream (f_in);
		return obj_in.readObject();
		
	}
	
	//get object from ebay site
	private Object getFromSite() throws Exception{
		//call eBay API to get corresponding object
		Object obj = individualCall();
		//cache the object
		saveToDisk(obj);
		return obj;
	}
	
	//cache object as disk file
	private void saveToDisk(Object obj) throws Exception{
		String name = java.text.MessageFormat.format(FILE_PREFIX+ "_"+FILE_NAME_PATTERN,
				new Object[]{apiContext.getSite().toString(),lastUpdateTime});
		String path = ROOT_DIR + "/" + name + "."+FILE_EXTENSION;
		FileOutputStream f_out = new FileOutputStream (path);
		ObjectOutputStream obj_out = new ObjectOutputStream (f_out);
		obj_out.writeObject (obj);	
	}

	//subclass should implement specific API call
	protected abstract Object individualCall()throws Exception;
	//subclass should implement specific API call to get last update time
	protected abstract String getLastUpdateTime() throws Exception;
}
