/*
Copyright (c) 2013 eBay, Inc.
This program is licensed under the terms of the eBay Common Development and
Distribution License (CDDL) Version 1.0 (the "License") and any subsequent  version 
thereof released by eBay.  The then-current version of the License can be found 
at http://www.opensource.org/licenses/cddl1.php and in the eBaySDKLicense file that 
is under the eBay SDK ../docs directory.
*/

package com.ebay.sdk.call;


import com.ebay.sdk.*;
import com.ebay.soap.eBLBaseComponents.*;
/**
 * Wrapper class of the SetTaxTable call of eBay SOAP API.
 * <br>
 * <p>Title: SOAP API wrapper library.</p>
 * <p>Description: Contains wrapper classes for eBay SOAP APIs.</p>
 * <p>Copyright: Copyright (c) 2009</p>
 * <p>Company: eBay Inc.</p>
 * <br> <B>Input property:</B> <code>TaxTable</code> - This table is used to set or modify sales tax rates for one or more tax jurisdictions within that country. A <b>TaxJurisdiction</b> container is required for each tax jurisdiction that is being added/updated.
 * 
 * @author Ron Murphy
 * @version 1.0
 */

public class SetTaxTableCall extends com.ebay.sdk.ApiCall
{
  
  private TaxTableType taxTable = null;


  /**
   * Constructor.
   */
  public SetTaxTableCall() {
  }

  /**
   * Constructor.
   * @param apiContext The ApiContext object to be used to make the call.
   */
  public SetTaxTableCall(ApiContext apiContext) {
    super(apiContext);
    

  }

  /**
   * This call allows you to add or modify sales tax rates for one or more tax jurisdictions within the specified site. Any additions or modifications made with this call is saved in the seller's Sales Tax Table in My eBay.
   * <br/><br/>
   * Sales Tax Tables are only supported on the US and Canada (English and French versions) sites, so this call is only applicable to those sites. To view their current Sales Tax Table, a seller may go to the Sales Tax Table in My eBay, or they can make a <b>GetTaxTable</b> call.
   * 
   * <br>
   * @throws ApiException
   * @throws SdkException
   * @throws Exception
   * @return The void object.
   */
  public void setTaxTable()
      throws com.ebay.sdk.ApiException, com.ebay.sdk.SdkException, java.lang.Exception
  {
    SetTaxTableRequestType req;
    req = new SetTaxTableRequestType();

    if( this.taxTable == null )
      throw new SdkException("TaxTable property is not set.");

    if (this.taxTable != null)
      req.setTaxTable(this.taxTable);

    SetTaxTableResponseType resp = (SetTaxTableResponseType) execute(req);


  }

  /**
   * Gets the SetTaxTableRequestType.taxTable.
   * @return TaxTableType
   */
  public TaxTableType getTaxTable()
  {
    return this.taxTable;
  }

  /**
   * Sets the SetTaxTableRequestType.taxTable.
   * @param taxTable TaxTableType
   */
  public void setTaxTable(TaxTableType taxTable)
  {
    this.taxTable = taxTable;
  }

}

