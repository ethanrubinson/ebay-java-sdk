/*
Copyright (c) 2013 eBay, Inc.
This program is licensed under the terms of the eBay Common Development and
Distribution License (CDDL) Version 1.0 (the "License") and any subsequent  version 
thereof released by eBay.  The then-current version of the License can be found 
at http://www.opensource.org/licenses/cddl1.php and in the eBaySDKLicense file that 
is under the eBay SDK ../docs directory.
*/

package com.ebay.sdk;

import java.text.ParseException;
import java.util.Date;

import javax.swing.event.EventListenerList;

import com.ebay.sdk.logging.MetricsLogger;
import com.ebay.soap.eBLBaseComponents.AbstractRequestType;
import com.ebay.soap.eBLBaseComponents.AbstractResponseType;
import com.ebay.soap.eBLBaseComponents.BotBlockRequestType;
import com.ebay.soap.eBLBaseComponents.DetailLevelCodeType;
import com.ebay.soap.eBLBaseComponents.EBayAPIInterface;
import com.ebay.soap.eBLBaseComponents.ErrorHandlingCodeType;
import com.ebay.soap.eBLBaseComponents.ErrorType;
import com.ebay.soap.eBLBaseComponents.SiteCodeType;
import com.ebay.soap.eBLBaseComponents.WarningLevelCodeType;
import com.ebay.sdk.util.eBayUtil;

import javax.xml.ws.http.HTTPException;
import javax.xml.ws.soap.SOAPFaultException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The base class of all API call classes (AddItemCall, GetItemCall, etc).
 * Each ApiCall object requires an ApiContext object to control the
 * common context under which the API call will be made.
 * 
 * <br>
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: eBay Inc.</p>
 * @author Weijun Li & Bo Yang
 * @version 1.1
 */

public class ApiCall {

  private SiteCodeType site = null;
  private ApiContext apiContext;
  private DetailLevelCodeType[] detailLevel = new DetailLevelCodeType[0];  // By default no DetailLevels 
  private CallRetry callRetry;
  private AbstractResponseType response = null;
  private String[] outputSelector = new String[0];  // By default no OutputSelector
  protected EventListenerList sendReqListeners = new EventListenerList();
  private String messageID = null;
  private String endUserIP = null;
  private ErrorHandlingCodeType errorHandling;
  private String invocationID = null;
  private WarningLevelCodeType warningLevel = null;
  private BotBlockRequestType botBlock = null;
  
  
  private boolean enableHTTPCompression = true;
  //now only GetTokenStatus/RevokeToken calls need
  //full credentials 
  private String[] callsNeedFullCredentials = {"GetTokenStatus", "RevokeToken"};
  //now GetSessionID/FetchToken calls only need Api Account
  private String[] callsNeedApiAccountOnly = {"GetSessionID", "FetchToken"};
  //OAuth Support 02/02/2017 
  //OAuth is not supported API list:  GetSessionID/FetchToken/GetTokenStatus/RevokeToke  
  private String[] OAuthIsNotSupportedAPI = { "GetSessionID", "FetchToken", "GetTokenStatus", "RevokeToken" };
  
  //OAuth Support 02/02/2017 
  private boolean enableoAuthTokenHTTPHeader=false;
  
  public void setEnableoAuthTokenHTTPHeader(boolean enableoAuthTokenHTTPHeader) {
		this.enableoAuthTokenHTTPHeader = enableoAuthTokenHTTPHeader;
  }
  
  public boolean isEnableoAuthTokenHTTPHeader() {
		return enableoAuthTokenHTTPHeader;
 }

  private static final Logger log = LoggerFactory.getLogger(ApiCall.class);
  
  /**
   * Set the API exception object.
   */
  protected ApiException apiException;

  /**
   * Constructor.
   */
  public ApiCall() {

  }
  //OAuth Support 02/02/2017 
  private boolean isOauthDisabledAPI(String apiName) {
	 for (String name : OAuthIsNotSupportedAPI) {
		 if (name.equalsIgnoreCase(apiName)) {
			 return true;
		 }
	}
	return false;
  }
  private boolean isFullCredentials(String apiName) {
      for (String name : callsNeedFullCredentials) {
    	  if (name.equalsIgnoreCase(apiName)) {
    		  return true;
    	  }
      }
      return false;
  }
  
  private boolean isApiAccountOnly(String apiName) {
	  for (String name : callsNeedApiAccountOnly) {
		  if (name.equalsIgnoreCase(apiName)) {
			  return true;
		  }
	  }
	  return false;
  }

  /**
   * Constructor.
   * @param apiContext The ApiContext object for the ApiCall object.
   */
  public ApiCall(ApiContext apiContext) {
    this.apiContext = apiContext;
    
  }

  /**
   * Get the ApiContext object to be used.
   * @return The ApiContext object to be used.
   */
  public ApiContext getApiContext() {
    return this.apiContext;
    }

  /**
   * Set the ApiContext object to be used.
   * @param apiContext The ApiContext object to be set to.
   */
  public void setApiContext(ApiContext apiContext) {
    this.apiContext = apiContext;
  }

  /**
   * Add listener to filter the AbstractRequestType object right before it is
   * sent to eBay server.
   * @param l SendApiRequestListener
   */
  public void addSendRequestListener(SendApiRequestListener l) {
    if( l != null )
      sendReqListeners.add(SendApiRequestListener.class, l);
  }

  /**
   * Remove a listener.
   * @param l SendApiRequestListener
   */
  public void removeSendRequestListener(SendApiRequestListener l) {
    if( l != null )
      sendReqListeners.remove(SendApiRequestListener.class, l);
  }

  /**
   * Get the DetailLevels of the API call. DetailLevel controls what
   * fields should be returned by the API call.
   * @return Array of DetailLevelCodeType.
   */
  public com.ebay.soap.eBLBaseComponents.DetailLevelCodeType[] getDetailLevel() {
        return detailLevel;
    }

  /**
   * Set the DetaiLevels of the API call.
   * @param detailLevel Array of DetailLevels to be set to.
   */
    public void setDetailLevel(com.ebay.soap.eBLBaseComponents.DetailLevelCodeType[] detailLevel) {
    	if (detailLevel == null) {
    		this.detailLevel = new DetailLevelCodeType[0];
    	}
    	else {
    		this.detailLevel = detailLevel;
    	}
  }

  /**
   * Add a detail level value to for call object.
   * @param detail DetailLevelCodeType
   */
  public void addDetailLevel(com.ebay.soap.eBLBaseComponents.DetailLevelCodeType detail)
  {
    int newLen = (this.detailLevel != null) ? this.detailLevel.length : 0;
    newLen++;

    DetailLevelCodeType ndl[] = new DetailLevelCodeType[newLen];
    if( this.detailLevel != null )
    {
      for(int i = 0; i < this.detailLevel.length; i++ )
        ndl[i] = this.detailLevel[i];
    }

    ndl[newLen - 1] = detail;

    this.detailLevel = ndl;
  }

  /**
   * Get the CallRetry object that is being used.
   * @return the CallRetry object.
   */
  public CallRetry getCallRetry() {
    return this.callRetry;
  }

  /**
   * Set the CallRetry object to be used. CallRetry controls the behavior
   * of failure-retry. If you set this property, the CallRetry proper of ApiContext
   * will be ignored.
   * @param callRetry The CallRetry object to use.
   */
  public void setCallRetry(CallRetry callRetry) {
    this.callRetry = callRetry;
  }

  /**
   * After making the API call, returns the ApiExceptin object of the call.
   * @return the ApiException object if there's failure. Information
   * contained in ApiException object is returned by eBay API server.
   */
  public ApiException getApiException() {
    return this.apiException;
  }

  /**
   * After calling Exceute(), gets if there are warnning returned from eBay
   * API server.
   * @return true means warnnings are returned.
   * Use getApiException().getErrors() to find all warnnings.
   */
  public boolean hasWarning() {
    return (this.apiException != null && this.apiException.getSeverityWarningCount() > 0);
  }

  /**
   * After calling Exceute(), gets if there are errors returned from eBay
   * API server.
   * @return true means errors are returned.
   * Use getApiException().getErrors() to find all errors.
   */
  public boolean hasError() {
    return (this.apiException != null && this.apiException.getSeverityErrorCount() > 0);
  }

  /**
   * After making the API call, returns the SOAP request Xml text.
   * @return the request SOAP Xml text.
   */
  	public String getRequestXml() {
  		return apiContext.getRequestXml();
  	}

  /**
   * After making the API call, returns the SOAP response Xml text. 
   * Note : This field is only set if the server returned response SOAP xml.
   * @return the response SOAP xml text.
   */
  	public String getResponseXml() {
   		return apiContext.getResponseXml();
  	}

  /**
   * Gets the eBay site that is the call is associated with.
   * @return SiteCodeType
   */
  public SiteCodeType getSite() {
    return site;
  }

  /**
   * Determine if GZIP or DEFLATE compression is enabled for this ApiCall object.
   * @return boolean
   */
  public boolean getEnableCompression() {
    return this.enableHTTPCompression;
  }

  /**
   * Sets the eBay site that is the call is associated with. Setting this property
   * will overrides the Site property in ApiCall.ApiContext.
   * @param site SiteCodeType
   */
  public void setSite(SiteCodeType site) {
    this.site = site;
  }

  /**
   * Sets to true to enable GZIP or DEFLATE compression for this ApiCall object.
   * @param enableCompression boolean
   */
  public void setEnableCompression(boolean enableCompression) {
    this.enableHTTPCompression = enableCompression;
  }

  /**
   * After calling Execute(), returns the AbstractResponseType object.
   * All eBay SOAP API call return types that are derived from AbstractResponseType.
   * You can cast it back to the concrete response type
   * (e.g., AddItemResponseType, GetItemResponseType).
   * @return The returned AbstractResponseType object.
   */
  public AbstractResponseType getResponseObject() {
    return this.response;
  }

  private AbstractResponseType callSOAP(
		  EBayAPIInterface api, String apiName, AbstractRequestType request)
  throws java.lang.Exception
  {
    Object objRet = null;
    java.lang.reflect.Method method;

    try {
      // Method name has the first char to be lower case.
      StringBuffer sb = new StringBuffer(apiName);
      sb.setCharAt(0, java.lang.Character.toLowerCase(sb.charAt(0)));

      method = api.getClass().getMethod(sb.toString(),
                                           new Class[] {request.getClass()});
    } catch (Exception e) {
      throw new SdkException("ApiCall - call method not found: " +
                               e.getMessage(), e);
    }
    
    //TODO, do we need to synchronize first call?
    objRet = method.invoke(api, new Object[] {request});
    
    return (AbstractResponseType)objRet;
  }

  /**
   * Executing the API call. This method assumes that the request type name
   * contains the api name. E.g., AddItemRequestType contains "addItem".
   * @param request The request object.
   * @throws ApiException
   * @throws SdkSoapException
   * @throws SdkException
   * @return The response type that you can cast back to its concrete type.
   */
  public AbstractResponseType execute(AbstractRequestType request)
      throws com.ebay.sdk.ApiException, com.ebay.sdk.SdkSoapException, com.ebay.sdk.SdkException
  {  	
	//Get apiName from name of request type.
	String s = request.getClass().getName();
	int start = s.lastIndexOf('.');
	int end = s.indexOf("RequestType");
	if( start == -1 || end == -1 ) {
	  throw new SdkException("Invalid AbstractRequestType parameter.");
	}
	start++;

	String apiName = s.substring(start, end);
	return executeByApiName(apiName, request);
  }

  void checkProperties(String apiName) throws SdkException
  {
    // Validate parameter and properties.
    if (this.apiContext == null)
      throw new SdkException("Please set valid ApiContext property");

    ApiCredential cred = this.apiContext.getApiCredential();

    if (cred == null)
      throw new SdkException(
          "Please set valid ApiContext.ApiCredential property");
   
    // OAuth Support 02/02/2017 
	// only if oAuthToken http header is not needed for the given apiName 
	if (!oAuthTokenCredentialHTTPHeader(cred, apiName)) {
        if(isFullCredentials(apiName)) {
    	    if (!isValidFullCredentials(cred)) {
    		    throw new SdkException(
    				"This api call needs full credentials, both eBay token and ApiAccount are needed");
    	    }
        } else {
            String token = cred.geteBayToken();
    	
	        if ( token == null || token.length() == 0 )
	        {
	           ApiAccount ac = cred.getApiAccount();
	           if( ac == null ) {
	              throw new SdkException(
	                 "Please either eBay token or ApiAccount plus eBayAccount as credential.");
	           }
	           if( ac.getDeveloper() == null )
	              throw new SdkException("Please set the API developer (ApiAccount.setDeveloper()).");
	           if( ac.getApplication() == null )
	              throw new SdkException("Please set the API application (ApiAccount.setApplication()).");
	           if( ac.getCertificate() == null )
	             throw new SdkException("Please set the API certificate (ApiAccount.setCertificate()).");
	
	       }
       }
	}
  }
  
  
	//OAuth Support 02/02/2017 
	//check if the given apiName use OAuth Token Http header 
	private boolean oAuthTokenCredentialHTTPHeader(ApiCredential cred, String apiName) {
		String oauthToken = cred.getOAuthToken();
		String ebaytoken = cred.geteBayToken();

		if (isOauthDisabledAPI(apiName)) {
			this.setEnableoAuthTokenHTTPHeader(false);
		} else if ((oauthToken != null && oauthToken.length() > 0)) {
			if (ebaytoken != null && ebaytoken.length() > 0) {
				this.setEnableoAuthTokenHTTPHeader(false);
			} else {
				this.setEnableoAuthTokenHTTPHeader(true);
			}

		} else if (ebaytoken != null && ebaytoken.length() > 0) {
			this.setEnableoAuthTokenHTTPHeader(false);

		}
		return this.isEnableoAuthTokenHTTPHeader();
	}//OAuth Support 02/02/2017 

	
  private boolean isValidFullCredentials(ApiCredential cred) {
	    String token = cred.geteBayToken();
	    if (token == null || token.length() == 0) return false;
	    
	    ApiAccount ac = cred.getApiAccount();
	    if( ac == null) return false;
	    
	    if (ac.getDeveloper() == null) return false;
	    if (ac.getApplication() == null) return false;
	    if (ac.getCertificate() == null) return false;
	    
	    return true;
  }
  
  private String getDstUrl(String apiName) {
      
	  SiteCodeType siteID = this.site != null ? this.site : apiContext.getSite();
      String rtStr = this.apiContext.getRouting() == null ? "" : ("&routing=" + this.apiContext.getRouting());
      String dstUrl = java.text.MessageFormat.format("{0}?siteid={1}{2}&callname={3}&client=java",
        new Object[] {this.apiContext.getApiServerUrl(), new Integer(SiteIDUtil.toNumericalID(siteID)),
        rtStr, apiName});

      // Append appID to the url, if any.
      String appID = "";
      ApiAccount ac = this.apiContext.getApiCredential().getApiAccount();
      if( ac != null )
        appID = ac.getApplication();
      if( appID != null && appID.length() > 0 )
        dstUrl += "&appid=" + appID;
      
      return dstUrl;
  }
  
  private RequestContext getRequestContext(String apiName, String dstUrl) {

      RequestContext reqContext = new RequestContext();
      reqContext.setEndPointAddress(dstUrl);
      reqContext.setHttpCompressionEnabled(this.enableHTTPCompression);

	  //OAuth Support 02/02/2017 
	  //if the given apiName uses OAuth Token Http header, set oAuthTokenCredentialHTTPHeader flag to ture for the RequestContext object 
	  if (oAuthTokenCredentialHTTPHeader(apiContext.getApiCredential(), apiName)) {
			this.setEnableoAuthTokenHTTPHeader(true);
			reqContext.setoAuthTokenCredentialHTTPHeader(this.enableoAuthTokenHTTPHeader);//OAuth Support 02/02/2017 
	  }else {
           if (isFullCredentials(apiName)) {
		      reqContext.setFullCredentialsEnabled(true);
           }
           if (this.isApiAccountOnly(apiName)) {
    	      reqContext.setApiAccountOnly(true);
           }
      }   
      return reqContext;
  }

  /**
   * Executing the API call by providing API name string (e.g., AddItem, GetItem).
   * @param apiName The name of the API call. e.g., addItem, getItem, etc.
   * @param request The AbstractRequestType object.
   * @throws ApiException
   * @throws SdkSoapException
   * @throws SdkException
   * @return The AbstractResponseType object.
   */
  public AbstractResponseType executeByApiName(String apiName, AbstractRequestType request)
      throws com.ebay.sdk.ApiException, com.ebay.sdk.SdkSoapException, com.ebay.sdk.SdkException
  {
	try
	{
		//for performance monitoring
		MetricsLogger.startRecordingSingleCallMetrics(apiName);
	
	    checkProperties(apiName);
	
	    AbstractResponseType resp = null;
	    request.setVersion(this.apiContext.getWSDLVersion());
	    
	    ApiLogging apiLogging = this.apiContext.getApiLogging();
	    
	    EBayAPIInterface api = null;

	    try {
	    	
          String dstUrl = this.getDstUrl(apiName);
	     
          RequestContext reqContext = this.getRequestContext(apiName, dstUrl);
	
	      //get eBay API instance
	      api = SdkAPIInterfaceServiceLocator.getEBayAPI(this.apiContext, reqContext);
	
	      int retries = 0, maxRetries = 0;
	
	      // Get CallRetry object in order.
	      CallRetry cr = this.getCallRetry();
	      if( cr == null )
	        cr = this.apiContext.getCallRetry();
	      if (cr != null)
	        maxRetries = cr.getMaximumRetries();
	
	      request.setDetailLevel(this.getDetailLevel());
	      request.setErrorLanguage(this.getApiContext().getErrorLanguage());
	      request.setOutputSelector(this.getOutputSelector());
	      request.setMessageID(this.getMessageID());
	      request.setEndUserIP(this.getEndUserIP());
	      request.setErrorHandling(this.getErrorHandling());
	      request.setInvocationID(this.getInvocationID());
	      request.setWarningLevel(this.getWarningLevel());
	      request.setBotBlock(this.getBotBlock());
	
	      this.fireSendRequestEvent(request);
	
	      Exception callException;
	      // Execute the call.
	      do
	      {
	        resp = null;
	        callException = null;
	        try
	        {
	          log.info("Sending SOAP request to: " + dstUrl);
	
	          resp = callSOAP(api, apiName, request);
	          
	          this.response = resp;
	          this.apiContext.incrementTotalCalls();
	          this.apiException = this.getApiException(resp); 
	          
	          checkHardExpirationWarning(resp);
	        }
	        catch(Exception e)
	        {	
		          if( e instanceof java.lang.reflect.InvocationTargetException )
		          {
		            java.lang.Throwable trb = ( (java.lang.reflect.InvocationTargetException) e).
		                getTargetException();
	                    // 7/16/2006 JMW
	                    //trb.printStackTrace();
		            if( trb instanceof java.lang.Exception )
		              e = (Exception)trb;
		            else
		              e = new SdkException(trb);
		          }
		
			      if (e instanceof HTTPException) {
			       	  callException = SdkHTTPException.fromHTTPException((HTTPException)e);
			      } else if (e instanceof SOAPFaultException) {
			       	  callException = SdkSoapException.fromSOAPFaultException((SOAPFaultException)e);
			      } else {
			    	  callException = e;
		          }
		    }
	        
	        if( callException == null )
	        {
	        	  ApiException apiExp = this.getApiException(resp);
	              if (apiExp != null && apiExp.getSeverityErrorCount() > 0) {
	            	  callException = apiExp;
	              }
	        }
	
	        if (callException != null)
	        {
		          if( cr == null || retries >= maxRetries || !cr.shouldRetry(callException) )
		            throw callException;
		
		          Thread.sleep(cr.getDelayTime());
		
		          retries++;
		
		          if( apiLogging != null && apiLogging.isLogExceptions())
		          {
		            log.error(callException.toString());
		            log.info("Retry " + apiName + " #" + retries + " ...");
		          }
	        }
	      } while (callException != null && retries <= maxRetries);
	    }
	    catch (java.lang.Exception e)
	    {
	      if( e instanceof java.lang.reflect.InvocationTargetException )
	      {
	        java.lang.reflect.InvocationTargetException ite = (java.lang.reflect.InvocationTargetException)e;
	        e = (Exception)ite.getTargetException();
	      }
	
	      if( apiLogging != null && apiLogging.isLogExceptions()) {
	        
	        //exception based logging
	        ExceptionFilter filter = apiLogging.getMessageLoggingFilter();
	    	if( filter != null && filter.matches(e)) {
	    		log.info("Exception based logging enabled.");
	    		this.logMessage("Request", apiContext.getRequestXml());
	    		this.logMessage("Response", apiContext.getResponseXml());
	    	}
	    	
	        log.error(e.toString());
	      }
	
	      if( e instanceof ApiException )
	        throw (ApiException)e;
	      if( e instanceof SdkSoapException )
	        throw (SdkSoapException)e;
	      if( e instanceof SdkException )
	        throw (SdkException)e;
	
	      throw new SdkException("ApiCall.execute() - " + e.getMessage(), e);
	    } finally {
	    	//return the api instance to the pool
	    	SdkAPIInterfaceServiceLocator.releaseEBayAPI(api);
	    }
	
	    return resp;
	}
	finally
	{
		MetricsLogger.endRecordingSingleCallMetrics();
	}
  }
  
  private ApiException getApiException(AbstractResponseType resp) {
	  if (resp == null) return null;
      
	  ApiException apiExp = null;
	  ErrorType[] errors = resp.getErrors();
      if (errors != null && errors.length > 0) {
          apiExp = new com.ebay.sdk.ApiException(errors);
      }
      
      return apiExp;
  }

  private void checkHardExpirationWarning(AbstractResponseType resp) throws ParseException {
	  if (resp == null) return;
	  
	  String hardExpirationWarning = resp.getHardExpirationWarning();
	  if (hardExpirationWarning != null && hardExpirationWarning.length() > 0) {
          
		  log.info("eBay token hard expiration warning received.");
          
		  Date expDate = eBayUtil.fromAPITimeString(hardExpirationWarning);
		  
		  ApiCredential ac = this.apiContext.getApiCredential();
		  
          // Fire event.
          ac.fireWarnTokenHardExpiration(expDate);
	  }
	
  }
  
	private void logMessage(String msgName, String msgStr) {
		if(msgStr == null) return;
    	String hs = java.text.MessageFormat.format("{0} Message: Length={1}",
                                 new Object[] {msgName, new Integer(msgStr.length())}
                                 );
    	log.info(hs);
    	log.info(msgStr);
	} 
 

  /**
   * Called by ApiCall subclasses (e.g., AddItemCall, GetItemCall, etc) to
   * notify the event that an AbastractRequestType object is about
   * to be sent to eBay.
   * @param request AbstractRequestType
   * @throws SdkException
   */
  void fireSendRequestEvent(AbstractRequestType request)
      throws com.ebay.sdk.SdkException
  {
    SendApiRequestListener[] ls = (SendApiRequestListener[])
        this.sendReqListeners.getListeners(SendApiRequestListener.class);
    if( ls != null )
    {
      for (int i = ls.length - 1; i >= 0; i--) {
        ls[i].FilterApiRequest(request);
      }
    }
  }

public String[] getOutputSelector() {
	return outputSelector;
}

public void setOutputSelector(String[] outputSelector) {
	this.outputSelector = outputSelector;
}

public String getMessageID() {
	return messageID;
}

public void setMessageID(String messageID) {
	this.messageID = messageID;
}


public String getEndUserIP() {
	return endUserIP;
}

public void setEndUserIP(String endUserIP) {
	this.endUserIP = endUserIP;
}

public String getInvocationID() {
	return invocationID;
}

public void setInvocationID(String invocationID) {
	this.invocationID = invocationID;
}

public WarningLevelCodeType getWarningLevel() {
	return warningLevel;
}

public void setWarningLevel(WarningLevelCodeType warningLevel) {
	this.warningLevel = warningLevel;
}

public BotBlockRequestType getBotBlock() {
	return botBlock;
}

public void setBotBlock(BotBlockRequestType botBlock) {
	this.botBlock = botBlock;
}

public ErrorHandlingCodeType getErrorHandling() {
	return errorHandling;
}

public void setErrorHandling(ErrorHandlingCodeType errorHandling) {
	this.errorHandling = errorHandling;
}
}
