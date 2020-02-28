/*
Copyright (c) 2013 eBay, Inc.
This program is licensed under the terms of the eBay Common Development and
Distribution License (CDDL) Version 1.0 (the "License") and any subsequent  version 
thereof released by eBay.  The then-current version of the License can be found 
at http://www.opensource.org/licenses/cddl1.php and in the eBaySDKLicense file that 
is under the eBay SDK ../docs directory.
*/

package com.ebay.sdk.helper.ui;

import java.awt.*;
import javax.swing.*;
import com.ebay.sdk.*;
import com.ebay.sdk.util.*;
import com.ebay.soap.eBLBaseComponents.*;

public class GuiUtil {
  public static void CenterComponent(Component frame)
   {
     //Center the window
     Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
     Dimension frameSize = frame.getSize();
     if (frameSize.height > screenSize.height) {
       frameSize.height = screenSize.height;
     }
     if (frameSize.width > screenSize.width) {
       frameSize.width = screenSize.width;
     }
     frame.setLocation( (screenSize.width - frameSize.width) / 2,
                       (screenSize.height - frameSize.height) / 2);
     //frame.setVisible(true);
   }

   public static void JListClearData(javax.swing.JList list) {
     list.setListData(new Object[0]);
   }

   public static void JListAddObject(javax.swing.JList list, Object item) {
     javax.swing.ListModel lm = list.getModel();
     Object[] newList = new Object[lm.getSize() + 1];
     for(int i = 0; i < lm.getSize(); i++) {
       newList[i] = lm.getElementAt(i);
     }
     newList[lm.getSize()] = item;
     list.setListData(newList);
   }

   public static void JListRemoveSelectedObject(javax.swing.JList list){
     Object sel = list.getSelectedValue();
     if( sel != null )
     {
       javax.swing.ListModel lm = list.getModel();
       Object[] newList = new Object[lm.getSize() - 1];
       int cur = 0;
       for(int i = 0; i < lm.getSize(); i++) {
         if( lm.getElementAt(i) != sel )
           newList[cur++] = lm.getElementAt(i);
       }
       list.setListData(newList);
     }
   }

   public static AmountType getMoneyField(JTextField tf)
   {
     Double dbl = new Double(tf.getText());
     AmountType at = new AmountType();
     at.setValue(dbl.doubleValue());
     at.setCurrencyID(CurrencyCodeType.USD);
     return at;
   }

   public static java.util.Calendar getCalendarFromField(JTextField txtField)
       throws java.text.ParseException
   {
     java.util.Calendar cal = null;
     if( txtField.getText().length() > 0 )
     {

       java.util.Date dt = eBayUtil.fromAPITimeString(
           txtField.getText());

       cal = java.util.Calendar.getInstance();
       cal.setTime(dt);
     }

     return cal;
   }

   public static TimeFilter getTimeFilterFromFields(JTextField txtFrom, JTextField txtTo)
       throws java.text.ParseException
   {

     TimeFilter tf = null;

     if( txtFrom.getText().length() > 0 &&
        txtTo.getText().length() > 0 )
    {
      java.util.Calendar calFrom = getCalendarFromField(txtFrom);
      java.util.Calendar calTo = getCalendarFromField(txtTo);

      tf = new TimeFilter(calFrom, calTo);
    }

    return tf;
   }

   public static void setTimeFilterFields(int backDays, JTextField txtFrom, JTextField txtTo)
   {
     java.util.Calendar calTo = java.util.Calendar.getInstance(java.util.TimeZone.getTimeZone("GMT"));
     java.util.Date to = calTo.getTime();

     java.util.Calendar calFrom = (java.util.Calendar)calTo.clone();
     calFrom.add(java.util.Calendar.DATE, -backDays);
     java.util.Date from = calFrom.getTime();

     String fromStr = eBayUtil.toAPITimeString(from);
     String toStr = eBayUtil.toAPITimeString(to);

     txtFrom.setText(fromStr);
     txtTo.setText(toStr);
   }

   public static boolean IsTextFieldEmpty(javax.swing.JTextField tf) {
     return (tf.getText().length() == 0);
   }

   public static boolean AreAllTextFieldsFilled(javax.swing.JTextField[] tfs) {
    for(int i = 0; i < tfs.length; i ++)
    {
      if( IsTextFieldEmpty(tfs[i]) )
        return false;
    }
    return true;
  }

  public static boolean isFilledString(String s)
  {
    return s != null && s.length() > 0;
  }

  public static boolean isApiAccountFilled(ApiAccount ac)
  {
    String dev = ac.getDeveloper();
    String app = ac.getApplication();
    String cert = ac.getCertificate();

    return (dev != null && dev.length() > 0 &&
        app != null && app.length() > 0 &&
        cert != null && cert.length() > 0
        );
  }

  public static boolean isApiContextFilled(ApiContext ctx, boolean checkEBayAccount)
  {
    ApiCredential ac = ctx.getApiCredential();
    if( ac == null )
      return false;

    if( !GuiUtil.isFilledString(ctx.getApiServerUrl()) )
      return false;

    boolean hasToken = GuiUtil.isFilledString(ac.geteBayToken());
    if( !hasToken && !GuiUtil.isApiAccountFilled(ac.getApiAccount()) )
      return false;

    if ( checkEBayAccount )
    {
      return hasToken;
    }
    return true;
  }

  /**
   * Checks if a text control is filled. If errorMessage is null an SdkException will
   * be thrown with the specified error message.
   * @param tc JTextComponent
   * @param errorMessage String
   * @throws SdkException
   * @return boolean
   */
  public static boolean isTextControlFilled(javax.swing.text.JTextComponent tc,
                                      String errorMessage)
      throws com.ebay.sdk.SdkException
  {
    boolean b = tc.getText().length() > 0;
    if( errorMessage != null && !b )
      throw new com.ebay.sdk.SdkException(errorMessage);
    return b;
  }
}
