/*
Copyright (c) 2013 eBay, Inc.
This program is licensed under the terms of the eBay Common Development and
Distribution License (CDDL) Version 1.0 (the "License") and any subsequent  version 
thereof released by eBay.  The then-current version of the License can be found 
at http://www.opensource.org/licenses/cddl1.php and in the eBaySDKLicense file that 
is under the eBay SDK ../docs directory.
*/

package com.ebay.sdk.model;

import com.ebay.soap.eBLBaseComponents.CategoryType;
import com.ebay.soap.eBLBaseComponents.CharacteristicsSetType;

/**
 * Objects that combines CategoryType and CharacteristicSetType.
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */
public class Category extends CategoryType {

  private Category[] subCategories = null;

  /**
   * Constructor.
   */
  public Category() {
  }

  /**
   * Construct from an existing CategoryType object. It will make shallow
   * copy of the existing object.
   * @param fromCat CategoryType
   */
  public Category(CategoryType fromCat)
  {
    this.setAutoPayEnabled(fromCat.isAutoPayEnabled());
    this.setB2BVATEnabled(fromCat.isB2BVATEnabled());
    this.setCatalogEnabled(fromCat.isCatalogEnabled());
    this.setCategoryID(fromCat.getCategoryID());
    this.setCategoryLevel(fromCat.getCategoryLevel());
    this.setCategoryName(fromCat.getCategoryName());
    this.setCategoryParentID(fromCat.getCategoryParentID());
    this.setCategoryParentName(fromCat.getCategoryParentName());
    this.setCharacteristicsSets(fromCat.getCharacteristicsSets());
    this.setExpired(fromCat.isExpired());
    this.setIntlAutosFixedCat(fromCat.isIntlAutosFixedCat());
    this.setLeafCategory(fromCat.isLeafCategory());
    this.setNumOfItems(fromCat.getNumOfItems());
    this.setProductSearchPageAvailable(fromCat.isProductSearchPageAvailable());
    this.setVirtual(fromCat.isVirtual());
  }

  /**
   * Gets sub categories of the category. This field is not always filled in
   * all cases.
   * @param subCategories Category[]
   */
  public void setSubCategories(Category[] subCategories) {
    this.subCategories = subCategories;
  }

  /**
   * Sets sub categories of the category.
   * @return Category[]
   */
  public Category[] getSubCategories() {
    return subCategories;
  }

  /**
   * Append a sub category. It automatically creates or expands the sub category array.
   * @param subCategory Category
   * @return int
   */
  public int addSubCategory(Category subCategory)
  {
    int i;
    Category[] css = this.subCategories;
    int oldLen = css == null ? 0 : css.length;
    Category[] newCss = new Category[oldLen + 1];
    for(i = 0; i < oldLen; i++)
    {
      newCss[i] = css[i];
    }
    newCss[i] = subCategory;

    this.subCategories  = newCss;

    return this.subCategories.length;
  }

  /**
   * Adds a CharacteristicsSetType for the category.
   * @param cs CharacteristicsSetType
   */
  public void addCharacteristicsSet(CharacteristicsSetType cs)
  {
    int i;
    CharacteristicsSetType[] css = this.getCharacteristicsSets();
    int oldLen = css == null ? 0 : css.length;
    CharacteristicsSetType[] newCss = new CharacteristicsSetType[oldLen + 1];
    for(i = 0; i < oldLen; i++)
    {
      newCss[i] = css[i];
    }
    newCss[i] = cs;

    this.setCharacteristicsSets(newCss);
  }

  /**
   * Adds a new CharacteristicsSetType node.
   * @return CharacteristicsSetType
   */
  public CharacteristicsSetType addNewCharacteristicsSet()
  {
    CharacteristicsSetType cs = new CharacteristicsSetType();
    this.addCharacteristicsSet(cs);
    return cs;
  }

  /**
   *  Sets integer category ID. It actually calls CategoryType.setCategoryID().
   * @param categoryID int
   */
  public void setID(int categoryID)
  {
    this.setCategoryID(String.valueOf(categoryID));
  }

  /**
   * Sets integer category ID. It actually calls CategoryType.getCategoryID().
   * @return int
   */
  public int getID()
  {
    return Integer.parseInt(this.getCategoryID());
  }
}
