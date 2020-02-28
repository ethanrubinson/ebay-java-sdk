/*
Copyright (c) 2013 eBay, Inc.
This program is licensed under the terms of the eBay Common Development and
Distribution License (CDDL) Version 1.0 (the "License") and any subsequent  version 
thereof released by eBay.  The then-current version of the License can be found 
at http://www.opensource.org/licenses/cddl1.php and in the eBaySDKLicense file that 
is under the eBay SDK ../docs directory.
*/

package com.ebay.sdk.helper.ui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.net.URLEncoder;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;

import com.ebay.sdk.ApiAccount;
import com.ebay.sdk.ApiContext;
import com.ebay.sdk.SdkException;
import com.ebay.sdk.call.FetchTokenCall;
import com.ebay.sdk.call.GetSessionIDCall;
import com.ebay.sdk.helper.Utils;

public class DialogFetchToken extends JDialog {

  private ApiContext apiContext = null;
  private String generatedToken = null;
  private boolean closeOnToken = false;
  private boolean cancelled = true;


  JPanel panel1 = new JPanel();
  BorderLayout borderLayout1 = new BorderLayout();
  JPanel jPanel1 = new JPanel();
  JPanel jPanel2 = new JPanel();
  JPanel jPanel3 = new JPanel();
  BorderLayout borderLayout2 = new BorderLayout();
  JPanel jPanelSecret = new JPanel();
  JPanel jPanel5 = new JPanel();
  JTextField txtSessionID = new JTextField();
  JButton btnFetchToken = new JButton();
  JPanel jPanel6 = new JPanel();
  BorderLayout borderLayout3 = new BorderLayout();
  JScrollPane jScrollPane1 = new JScrollPane();
  JTextPane txtToken = new JTextPane();
  JPanel jPanel7 = new JPanel();
  JLabel jLabel2 = new JLabel();
  BorderLayout borderLayout4 = new BorderLayout();
  JPanel jPanelRuName = new JPanel();
  JPanel jPanel9 = new JPanel();
  BorderLayout borderLayout5 = new BorderLayout();
  JPanel jPanel4 = new JPanel();
  JPanel jPanel10 = new JPanel();
  BorderLayout borderLayout6 = new BorderLayout();
  JPanel jPanel11 = new JPanel();
  JLabel jLabel3 = new JLabel();
  JLabel jLabel1 = new JLabel();
  JButton btnGetSessionID = new JButton();
  JLabel jLabel4 = new JLabel();
  BorderLayout borderLayout7 = new BorderLayout();
  BorderLayout borderLayout8 = new BorderLayout();
  BorderLayout borderLayout9 = new BorderLayout();
  JPanel jPanel12 = new JPanel();
  JLabel jLabel10 = new JLabel();
  JTextField ruNameField = new JTextField();
  JPanel jPanel13 = new JPanel();
  BorderLayout borderLayout10 = new BorderLayout();
  JLabel jLabel5 = new JLabel();
  BorderLayout borderLayout11 = new BorderLayout();
  JPanel jPanel14 = new JPanel();
  JPanel jPanel15 = new JPanel();
  BorderLayout borderLayout12 = new BorderLayout();
  JLabel jLabel6 = new JLabel();
  JButton btnLaunchWebBrowser = new JButton();

  public void setCloseOnToken(boolean closeOnToken) {
    this.closeOnToken = closeOnToken;
  }
  
  public String getGeneratedToken() {
    return generatedToken;
  }

  public boolean isCloseOnToken() {
    return closeOnToken;
  }

  public boolean isCancelled() {
    return cancelled;
  }

  public DialogFetchToken(Frame frame, ApiContext apiContext, String title, boolean modal) {

    super(frame, title, modal);
    try {
      jbInit();
      pack();

      this.apiContext = apiContext;

      if( this.apiContext == null )
        throw new Exception("DialogFetchToken: ApiContext is not specified.");
      
      if(this.apiContext.getRuName() != null){
    	  this.ruNameField.setText(this.apiContext.getRuName());
      }
      
      String signInUrl = this.apiContext.getSignInUrl();
      if(signInUrl == null || signInUrl.length() == 0)
    	throw new Exception("SignIn Url must be specified to call FetchToken.");


    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }

  private void jbInit() throws Exception {
    panel1.setLayout(borderLayout1);
    jPanel1.setLayout(borderLayout2);
    txtSessionID.setPreferredSize(new Dimension(160, 21));
    txtSessionID.setEditable(false);
    txtSessionID.setText("");
    btnFetchToken.setText("FetchToken");
    btnFetchToken.addActionListener(new DialogFetchToken_btnFetchToken_actionAdapter(this));
    jPanelSecret.setLayout(borderLayout6);
    jPanel2.setLayout(borderLayout3);
    txtToken.setEditable(false);
    txtToken.setText("");
    jLabel2.setText("API Token");
    jScrollPane1.setPreferredSize(new Dimension(400, 100));
    jPanel3.setLayout(borderLayout4);
    jPanelRuName.setLayout(borderLayout5);
    jLabel3.setText("2) Retrieve a Session ID.");
    jLabel1.setText("Session ID:");
    btnGetSessionID.setText("GetSessionID");
    btnGetSessionID.addActionListener(new DialogFetchToken_btnGetSessionID_actionAdapter(this));
    jLabel4.setText("1) Please input your RuName here.");
    jPanel6.setLayout(borderLayout8);
    jPanel4.setLayout(borderLayout9);
    jPanel13.setLayout(borderLayout10);
    jLabel5.setText("4) Click FetchToken API to retrieve the generated token text.");
    jPanel3.setBorder(BorderFactory.createEtchedBorder());
    jPanel9.setLayout(borderLayout11);
    jPanel14.setLayout(borderLayout12);
    jLabel6.setText("3) Launch web browser with your secret and sign-in to generate the " +
    "token online.");
    btnLaunchWebBrowser.setText("Launch Web Browser");
    btnLaunchWebBrowser.addActionListener(new DialogFetchToken_btnLaunchWebBrowser_actionAdapter(this));
    jPanel11.add(jLabel1, null);
    jPanel11.add(txtSessionID, null);
    jPanel11.add(btnGetSessionID, null);
    getContentPane().add(panel1);
    panel1.add(jPanel1,  BorderLayout.NORTH);
    jPanel1.add(jPanelSecret,  BorderLayout.CENTER);
    jPanelSecret.add(jPanel6,  BorderLayout.NORTH);
    jPanel1.add(jPanelRuName,  BorderLayout.NORTH);
    jPanel1.add(jPanel9, BorderLayout.SOUTH);
    jPanel9.add(jPanel14,  BorderLayout.NORTH);
    jPanel14.add(jLabel6, BorderLayout.WEST);
    jPanel9.add(jPanel15, BorderLayout.CENTER);
    jPanel15.add(btnLaunchWebBrowser, null);
    panel1.add(jPanel2,  BorderLayout.CENTER);
    jPanel2.add(jPanel5, BorderLayout.CENTER);
    jPanel5.add(btnFetchToken, null);
    jPanel2.add(jPanel13, BorderLayout.NORTH);
    jPanel13.add(jLabel5, BorderLayout.WEST);
    panel1.add(jPanel3, BorderLayout.SOUTH);
    jPanel3.add(jScrollPane1,  BorderLayout.CENTER);
    jPanel3.add(jPanel7, BorderLayout.NORTH);
    jPanel7.add(jLabel2, null);
    jScrollPane1.getViewport().add(txtToken, null);
    jPanelRuName.add(jPanel4,  BorderLayout.NORTH);
    jPanelRuName.add(jPanel10, BorderLayout.SOUTH);
    jPanelRuName.add(jPanel12, BorderLayout.CENTER);
    jPanelSecret.add(jPanel11, BorderLayout.CENTER);
    jPanel6.add(jLabel3, BorderLayout.CENTER);
    jPanel4.add(jLabel4, BorderLayout.CENTER);
    jLabel10.setText("RuName :");
    jPanel12.add(jLabel10);
    jPanel12.add(ruNameField);
    ruNameField.setPreferredSize(new Dimension(160, 21));
  }

  
  private boolean validateApiAccount() {
	  ApiAccount acc = this.apiContext.getApiCredential().getApiAccount();
	  if (acc == null) return false;
	  if (acc.getDeveloper().length() == 0) return false;
	  if (acc.getApplication().length() == 0) return false;
	  if (acc.getCertificate().length() == 0) return false;
	  return true;
  }

  void btnFetchToken_actionPerformed(ActionEvent e) {
    try
    {    	
      FetchTokenCall api = new FetchTokenCall(this.apiContext);

      String s = this.txtSessionID.getText();
      if( s.length() == 0 )
        throw new SdkException("Please get SessionID first.");
      api.setSessionID(s);

      this.generatedToken = api.fetchToken();

      this.txtToken.setText(this.generatedToken);

      if( this.closeOnToken )
      {
        DialogAccount.showInfoMessage(this, "The API token has been generated successfully!");
        this.cancelled = false;
        this.dispose();
      }
    }
    catch(Exception ex)
    {
      String msg = ex.getClass().getName() + " : " + ex.getMessage();
      DialogAccount.showErrorMessage(this, msg);
    }
  }

  void getSessionID()
  {
      try {
    	  
      	if (!validateApiAccount()) {
    		throw new SdkException("Please fill in Api Account first.");
    	}
    	  
		  GetSessionIDCall api = new GetSessionIDCall(this.apiContext);
		  
		  String runame = this.getRuName();
	      if( runame == null || runame.length() == 0 )
	        throw new Exception("Please select a RuName.");
	      
	      api.setRuName(runame);
	      
	      String s = api.getSessionID();
	      
	      this.txtSessionID.setText(s);
      
	  }
	  catch(Exception ex)
	  {
		  ex.printStackTrace();
		  DialogAccount.showErrorMessage(this, ex.getMessage());
	  }      
  }

  private String getRuName() {
	String ruName = ruNameField.getText();
	if(ruName.length()==0){
		return null;
	}
	return ruName;
}

void btnGetSessionID_actionPerformed(ActionEvent e) {
    this.getSessionID();
}


  void btnLaunchWebBrowser_actionPerformed(ActionEvent e) {
    try
    {
      String sessionID = this.txtSessionID.getText();
      if( sessionID.length() == 0 )
        throw new Exception("Please get SessionID first.");
      sessionID = URLEncoder.encode(sessionID, "UTF-8");
      
      String runame = this.getRuName();
      if( runame == null || runame.length() == 0 )
        throw new Exception("Please select a RuName.");
      
      String signInUrl = this.apiContext.getSignInUrl();

      String url = java.text.MessageFormat.format("{0}&RuName={1}&SessID={2}",
                                        new Object[] {signInUrl, runame, sessionID});
      
      BrowserLauncher.openURL(url);
    }
    catch(Exception ex)
    {
      DialogAccount.showErrorMessage(this, ex.getMessage());
    }
  }
}

class DialogFetchToken_btnFetchToken_actionAdapter implements java.awt.event.ActionListener {
  DialogFetchToken adaptee;

  DialogFetchToken_btnFetchToken_actionAdapter(DialogFetchToken adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.btnFetchToken_actionPerformed(e);
  }
}

class DialogFetchToken_btnGetSessionID_actionAdapter implements java.awt.event.ActionListener {
  DialogFetchToken adaptee;

  DialogFetchToken_btnGetSessionID_actionAdapter(DialogFetchToken adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.btnGetSessionID_actionPerformed(e);
  }
}


class DialogFetchToken_btnLaunchWebBrowser_actionAdapter implements java.awt.event.ActionListener {
  DialogFetchToken adaptee;

  DialogFetchToken_btnLaunchWebBrowser_actionAdapter(DialogFetchToken adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.btnLaunchWebBrowser_actionPerformed(e);
  }
}
