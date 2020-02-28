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
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;

import com.ebay.sdk.ApiAccount;
import com.ebay.sdk.ApiContext;


/**
* This code was edited or generated using CloudGarden's Jigloo
* SWT/Swing GUI Builder, which is free for non-commercial
* use. If Jigloo is being used commercially (ie, by a corporation,
* company or business for any purpose whatever) then you
* should purchase a license for each developer using Jigloo.
* Please visit www.cloudgarden.com for details.
* Use of Jigloo implies acceptance of these licensing terms.
* A COMMERCIAL LICENSE HAS NOT BEEN PURCHASED FOR
* THIS MACHINE, SO JIGLOO OR THIS CODE CANNOT BE USED
* LEGALLY FOR ANY CORPORATE OR COMMERCIAL PURPOSE.
*/
/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: eBay Inc.</p>
 * @author Weijun Li
 * @version 1.0
 */

public class DialogAccount extends JDialog {

  public static final String TITLE = "eBay SDK for Java";

  private ApiContext _apiContext;
  private boolean cancelled = true;
  private boolean enableApiCredentials = true;

  BorderLayout borderLayout1 = new BorderLayout();
  JButton btnOK = new JButton();
  JPanel jPanelBottom = new JPanel();
  JPanel jPanelUNCredential = new JPanel();
  JPanel jPanelTokenCredential = new JPanel();
  BorderLayout borderLayout2 = new BorderLayout();
  BorderLayout borderLayout3 = new BorderLayout();
  JPanel jPanel1 = new JPanel();
  BorderLayout borderLayout5 = new BorderLayout();
  JPanel jPanelAPIAccount = new JPanel();
  JPanel jPanelUNCHolder = new JPanel();
  JPanel jPanelTCHolder = new JPanel();
  BorderLayout borderLayout6 = new BorderLayout();
  BorderLayout borderLayout7 = new BorderLayout();
  GridLayout gridLayout1 = new GridLayout();
  JPanel jPanelDevId = new JPanel();
  JPanel jPanelCertificate = new JPanel();
  JTextField txtDeveloperID = new JTextField();
  JLabel jLabel1 = new JLabel();
  JTextField txtCertificate = new JTextField();
  JLabel jLabel3 = new JLabel();
  GridLayout gridLayout2 = new GridLayout();
  JPanel jPanel10 = new JPanel();
  JPanel jPanel11 = new JPanel();
  JLabel jLabel6 = new JLabel();
  BorderLayout borderLayout4 = new BorderLayout();
  JLabel jLabel7 = new JLabel();
  JLabel jLabel8 = new JLabel();
  BorderLayout borderLayout8 = new BorderLayout();
  JPanel jPanel12 = new JPanel();
  JPanel jPanel13 = new JPanel();
  GridLayout gridLayout3 = new GridLayout();
  JPanel jPanelApiServer = new JPanel();
  JPanel jPanelEpsServer = new JPanel();
  JTextField txtApiServerUrl = new JTextField();
  JLabel jLabel9 = new JLabel();
  JTextField txtEpsServerUrl = new JTextField();
  JLabel jLabel10 = new JLabel();
  ButtonGroup CredentialType = new ButtonGroup();
  JScrollPane jScrollPane1 = new JScrollPane();
  JTextPane txtTokenData = new JTextPane();
  JPanel jPanel16 = new JPanel();
  BorderLayout borderLayout9 = new BorderLayout();
  JPanel jPanelApiCredentials = new JPanel();
  JLabel jLabel2 = new JLabel();
  JTextField txtApplicationID = new JTextField();
  JPanel jPanelAppId = new JPanel();
  JPanel jPanelSignInUrl = new JPanel();
  JTextField txtSigninUrl = new JTextField();
  JLabel jLabel11 = new JLabel();
  JButton btnCancel = new JButton();
  JPanel jPanelChoices = new JPanel();
  BorderLayout borderLayout10 = new BorderLayout();
  JButton btnFetchToken = new JButton();

  public String getSignInUrl() {
    return this.txtSigninUrl.getText();
  }

  public void setSignInUrl(String url) {
    this.txtSigninUrl.setText(url);
  }

  public boolean isCancelled() {
    return cancelled;
  }

  public ApiContext getApiContext() {
	  return _apiContext;
  }

  public DialogAccount(Frame frame, ApiContext apiContext, String title, boolean modal, boolean enableApiCredentials) {
	    super(frame, title, modal);
	    this.enableApiCredentials = enableApiCredentials;
	    try {
	      jbInit();
	      pack();

	      _apiContext = apiContext;
	      populateUI();

	      //
	    }
	    catch(Exception ex) {
	      ex.printStackTrace();
	    }
  }
  
  private void populateUI() {
      this.txtTokenData.setText(_apiContext.getApiCredential().geteBayToken());

      ApiAccount ac = _apiContext.getApiCredential().getApiAccount();

      if (this.enableApiCredentials) {
	      this.txtDeveloperID.setText(ac.getDeveloper());
	      this.txtApplicationID.setText(ac.getApplication());
	      this.txtCertificate.setText(ac.getCertificate());
      } else {
    	  this.txtDeveloperID.setEnabled(false);
    	  this.txtApplicationID.setEnabled(false);
    	  this.txtCertificate.setEnabled(false);
      }

      this.txtApiServerUrl.setText(_apiContext.getApiServerUrl());
      this.txtEpsServerUrl.setText(_apiContext.getEpsServerUrl());
      this.txtSigninUrl.setText(_apiContext.getSignInUrl());
  }
  
  public DialogAccount(Frame frame, ApiContext apiContext, String title, boolean modal) {
    super(frame, title, modal);
    try {
      jbInit();
      pack();

      _apiContext = apiContext;
      populateUI();

      //
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }

  private void jbInit() throws Exception {
    this.getContentPane().setLayout(borderLayout1);
    this.setModal(true);
    this.setResizable(true);
    this.setTitle("API Account Settings");
    btnOK.setText("OK");
    btnOK.addActionListener(new DialogAccount_btnOK_actionAdapter(this));

    jPanelUNCredential.setDebugGraphicsOptions(0);
    jPanelUNCredential.setLayout(borderLayout2);
    jPanelTokenCredential.setLayout(borderLayout3);
    jPanel1.setLayout(borderLayout5);
    jPanelUNCHolder.setLayout(borderLayout6);
    jPanelTCHolder.setLayout(borderLayout7);
    jPanelAPIAccount.setLayout(gridLayout1);
    gridLayout1.setColumns(1);
    gridLayout1.setRows(3);
    jLabel1.setPreferredSize(new Dimension(80, 15));
    jLabel1.setText("DeveloperID:");
    jLabel3.setPreferredSize(new Dimension(80, 15));
    jLabel3.setText("Certificate:");
    gridLayout2.setColumns(1);
    gridLayout2.setRows(2);
    jLabel6.setText("Paste your token text or ");
    jPanel10.setLayout(borderLayout4);
    jLabel7.setText("        ");
    jLabel8.setToolTipText("");
    jLabel8.setText("        ");
    txtDeveloperID.setPreferredSize(new Dimension(120, 21));
    txtDeveloperID.setSelectionStart(10);
    txtDeveloperID.setText("");
    txtDeveloperID.addActionListener(new DialogAccount_txtDeveloperID_actionAdapter(this));
    txtCertificate.setPreferredSize(new Dimension(120, 21));
    txtCertificate.setText("");
    jPanelBottom.setLayout(borderLayout8);
    jPanel13.setLayout(gridLayout3);
    gridLayout3.setColumns(1);
    gridLayout3.setRows(3);
    jLabel9.setPreferredSize(new Dimension(90, 15));
    jLabel9.setText("API Server URL:");
    jLabel10.setPreferredSize(new Dimension(90, 15));
    jLabel10.setText("EPS Server URL:");
    txtApiServerUrl.setPreferredSize(new Dimension(280, 21));
    txtApiServerUrl.setText("");
    txtEpsServerUrl.setPreferredSize(new Dimension(280, 21));
    txtEpsServerUrl.setText("http://msa-e1.ebay.com/ws/eBayISAPI.dll?EpsBasicApp");
    txtEpsServerUrl.setColumns(0);
    jPanel16.setLayout(borderLayout9);
    jLabel2.setPreferredSize(new Dimension(80, 15));
    jLabel2.setText("ApplicationID:");
    txtApplicationID.setPreferredSize(new Dimension(120, 21));
    txtApplicationID.setRequestFocusEnabled(true);
    txtApplicationID.setText("");
    txtTokenData.setPreferredSize(new Dimension(50, 200));
    txtSigninUrl.setPreferredSize(new Dimension(280, 21));
    txtSigninUrl.setText("http://my.sandbox.ebay.com/ws/eBayISAPI.dll?SignIn");
    jLabel11.setPreferredSize(new Dimension(90, 15));
    jLabel11.setText("Sign-In URL:");
    jPanel13.setBorder(BorderFactory.createEtchedBorder());
    jScrollPane1.setPreferredSize(new Dimension(54, 40));
    btnCancel.setToolTipText("");
    btnCancel.setText("Cancel");
    btnCancel.addActionListener(new DialogAccount_btnCancel_actionAdapter(this));
    jPanelChoices.setLayout(borderLayout10);
    btnFetchToken.setText("Generate a New Token");
    btnFetchToken.addActionListener(new DialogAccount_btnFetchToken_actionAdapter(this));
    jPanel10.setPreferredSize(new Dimension(102, 40));
    jPanel16.setPreferredSize(new Dimension(400, 480));
    jPanelTokenCredential.setBorder(BorderFactory.createEtchedBorder());
    jPanelApiCredentials.setBorder(BorderFactory.createEtchedBorder());
    jPanelAppId.add(jLabel2, null);
    jPanelAppId.add(txtApplicationID, null);
    this.getContentPane().add(jPanelBottom, BorderLayout.SOUTH);
    jPanel10.add(jLabel7,  BorderLayout.WEST);
    jPanel10.add(jLabel8,  BorderLayout.EAST);
    jPanel10.add(jScrollPane1,  BorderLayout.CENTER);
    jPanel16.add(jPanel13,  BorderLayout.SOUTH);
    jScrollPane1.getViewport().add(txtTokenData, null);
    jPanelTokenCredential.add(jPanel11, BorderLayout.NORTH);
    jPanel11.add(jLabel6, null);
    jPanel11.add(btnFetchToken, null);
    jPanelTokenCredential.add(jPanel10, BorderLayout.CENTER);
    jPanelTCHolder.add(jPanelTokenCredential, BorderLayout.CENTER);
    this.getContentPane().add(jPanel16,  BorderLayout.CENTER);
    jPanelDevId.add(jLabel1, null);
    jPanelDevId.add(txtDeveloperID, null);
    jPanelAPIAccount.add(jPanelDevId, null);
    jPanelCertificate.add(jLabel3, null);
    jPanelCertificate.add(txtCertificate, null);
    jPanel16.add(jPanelChoices, BorderLayout.CENTER);
    jPanelChoices.add(jPanelUNCHolder,  BorderLayout.NORTH);
    jPanelAPIAccount.add(jPanelAppId, null);
    jPanelAPIAccount.add(jPanelCertificate, null);
    jPanelUNCHolder.add(jPanelUNCredential, BorderLayout.CENTER);
    jPanel16.add(jPanelApiCredentials, BorderLayout.NORTH);
    jPanelApiCredentials.add(jPanelAPIAccount, null);
    jPanelUNCredential.add(jPanel1, BorderLayout.SOUTH);
    jPanelChoices.add(jPanelTCHolder, BorderLayout.CENTER);
    jPanelBottom.add(jPanel12, BorderLayout.SOUTH);
    jPanel12.add(btnOK, null);
    jPanel12.add(btnCancel, null);
    jPanelApiServer.add(jLabel9, null);
    jPanelApiServer.add(txtApiServerUrl, null);
    jPanel13.add(jPanelEpsServer, null);
    jPanel13.add(jPanelApiServer, null);
    jPanelEpsServer.add(jLabel10, null);
    jPanelEpsServer.add(txtEpsServerUrl, null);
    jPanel13.add(jPanelSignInUrl, null);
    jPanelSignInUrl.add(jLabel11, null);
    jPanelSignInUrl.add(txtSigninUrl, null);

  }

  public static void showErrorMessage(Component parent, String error) {
    JOptionPane.showMessageDialog(parent, error, TITLE, JOptionPane.ERROR_MESSAGE);
  }

  public static void showInfoMessage(Component parent, String error) {
    JOptionPane.showMessageDialog(parent, error, TITLE,
                                  JOptionPane.INFORMATION_MESSAGE);
  }

  void parseApiContextFromGUI(boolean needToken) throws Exception
  {
    String s;

    if (this.enableApiCredentials) {
//	    if (this.txtDeveloperID.getText().length() == 0 ||
//	        this.txtApplicationID.getText().length() == 0 ||
//	        this.txtCertificate.getText().length() == 0) {
//	      throw new Exception(
//	          "Please enter the application ID, developer ID and certificate ID.");
//	    }

	    ApiAccount ac = _apiContext.getApiCredential().getApiAccount();
	
	    ac.setApplication(this.txtApplicationID.getText());
	    ac.setDeveloper(this.txtDeveloperID.getText());
	    ac.setCertificate(this.txtCertificate.getText());
    }

    s = this.txtTokenData.getText();
    if( s.length() == 0 && needToken)
        throw new Exception("Please enter the API token.");
    _apiContext.getApiCredential().seteBayToken(s);
    

    _apiContext.setApiServerUrl(this.txtApiServerUrl.getText());
    _apiContext.setEpsServerUrl(this.txtEpsServerUrl.getText());
    _apiContext.setSignInUrl(this.txtSigninUrl.getText());
  }

  void btnOK_actionPerformed(ActionEvent e)
  {
    try
    {
      this.parseApiContextFromGUI(true);

      this.cancelled = false;

      this.dispose();
    }
    catch (Exception ex) {
      showErrorMessage(this, ex.getMessage());
    }
  }


  void txtDeveloperID_actionPerformed(ActionEvent e) {

  }

  void btnCancel_actionPerformed(ActionEvent e) {
    this.dispose();
  }

  void btnFetchToken_actionPerformed(ActionEvent e) {

    try
    {
      this.parseApiContextFromGUI(false);

      DialogFetchToken dlg = new DialogFetchToken(null, _apiContext,
          "Acquire eBay API Token - Java FetchToken", true);
      dlg.setCloseOnToken(true);
      GuiUtil.CenterComponent(dlg);
      dlg.setVisible(true);

      if( !dlg.isCancelled() )
        this.txtTokenData.setText(dlg.getGeneratedToken());
    }
    catch (Exception ex) {
      showErrorMessage(this, ex.getMessage());
    }
  }
}

class DialogAccount_btnOK_actionAdapter implements java.awt.event.ActionListener {
  DialogAccount adaptee;

  DialogAccount_btnOK_actionAdapter(DialogAccount adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.btnOK_actionPerformed(e);
  }
}

class DialogAccount_txtDeveloperID_actionAdapter implements java.awt.event.ActionListener {
  DialogAccount adaptee;

  DialogAccount_txtDeveloperID_actionAdapter(DialogAccount adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.txtDeveloperID_actionPerformed(e);
  }
}

class DialogAccount_btnCancel_actionAdapter implements java.awt.event.ActionListener {
  DialogAccount adaptee;

  DialogAccount_btnCancel_actionAdapter(DialogAccount adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.btnCancel_actionPerformed(e);
  }
}

class DialogAccount_btnFetchToken_actionAdapter implements java.awt.event.ActionListener {
  DialogAccount adaptee;

  DialogAccount_btnFetchToken_actionAdapter(DialogAccount adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.btnFetchToken_actionPerformed(e);
  }
}
