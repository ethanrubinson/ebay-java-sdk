/*
Copyright (c) 2013 eBay, Inc.
This program is licensed under the terms of the eBay Common Development and
Distribution License (CDDL) Version 1.0 (the "License") and any subsequent  version 
thereof released by eBay.  The then-current version of the License can be found 
at http://www.opensource.org/licenses/cddl1.php and in the eBaySDKLicense file that 
is under the eBay SDK ../docs directory.
*/

package com.ebay.sdk.helper.ui;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;

import javax.swing.JCheckBox;
import javax.swing.JPanel;

/**
 * A helper class to build an array of JCheckBoxes/JIDCheckBoxes in a given JPanel with a GridBagLayout.
 */
public class ControlBuilder {

  static ControlBuilder _builder = new ControlBuilder();

  /**
   * Method to return an instance of ControlBuilder
   *
   * @return ControlBuilder
   */
  public static ControlBuilder getInstance()
  {
    return _builder;
  }

  private ControlBuilder() {
  }

  /**
   * Method to build an array of checkboxes in a JPanel with a GridBagLayout.
   *
   * @param panel Parent panel for the JCheckBoxes.
   * @param list List of labels for the JCheckBoxes.
   * @param colSize Column size for the JCheckBoxes array.
   *
   * @return An array of JCheckBoxes.
   */
  public JCheckBox[] buildCheckBoxControls(JPanel panel, ArrayList list, int colSize)
  {
    JCheckBox[] arrCheckBox = null;
    int size = list != null ? list.size() : 0;

    if (size > 0) {
      arrCheckBox = new JCheckBox[size];
      for (int i = 0; i < size; i++) {
          JCheckBox chkBox = new JCheckBox();
          chkBox.setText(list.get(i).toString() + CHECKBOX_SPACE);
          arrCheckBox[i] = chkBox;
          int row = i / colSize;
          int col = i % colSize;
          panel.add(chkBox, new GridBagConstraints(col, row, 1, 1, 0.0, 0.0,
            GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
      }
    }

    return arrCheckBox;
  }

  /**
   * Method to build an array of checkboxes in a JPanel with a GridBagLayout.
   *
   * @param panel Parent panel for the JIDCheckBoxes.
   * @param map Hashmap of ids and labels for the JIDCheckBoxes.
   * @param colSize Column size for the JIDCheckBoxes array.
   *
   * @return An array of JIDCheckBoxes.
   */
  public JCheckBox[] buildIDCheckBoxControls(JPanel panel, Hashtable map, int colSize)
  {
    JCheckBox[] arrCheckBox = null;
    int size = map.size();
    if (size > 0) {
      arrCheckBox = new JCheckBox[size];
      Enumeration keys = map.keys();
      int cnt = 0;
      while (keys.hasMoreElements()) {
        Object key = keys.nextElement();
        JCheckBox chkBox = new JIDCheckBox(key.toString(), map.get(key).toString() + CHECKBOX_SPACE);
        arrCheckBox[cnt] = chkBox;
        int row = cnt / colSize;
        int col = cnt % colSize;
        panel.add(chkBox, new GridBagConstraints(col, row, 1, 1, 0.0, 0.0,
          GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
        cnt++;
      }
    }

    return arrCheckBox;
  }


  private static String CHECKBOX_SPACE = "      ";
}
