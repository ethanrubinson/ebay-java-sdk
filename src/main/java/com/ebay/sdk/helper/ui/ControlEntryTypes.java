/*
Copyright (c) 2013 eBay, Inc.
This program is licensed under the terms of the eBay Common Development and
Distribution License (CDDL) Version 1.0 (the "License") and any subsequent  version 
thereof released by eBay.  The then-current version of the License can be found 
at http://www.opensource.org/licenses/cddl1.php and in the eBaySDKLicense file that 
is under the eBay SDK ../docs directory.
*/

package com.ebay.sdk.helper.ui;
import com.ebay.soap.eBLBaseComponents.*;

/**
 * Interface which defines the entries for a variety of ControlTagItems.
 */
public interface ControlEntryTypes
{
  public static ControlTagItem[] booleanFlags = new ControlTagItem[] {
      new ControlTagItem("No", Boolean.FALSE),
      new ControlTagItem("Yes", Boolean.TRUE)
  };

  public static ControlTagItem[] booleanFlagsRev = new ControlTagItem[] {
      new ControlTagItem("NoChange", "NoChange"),
      new ControlTagItem("No", Boolean.FALSE),
      new ControlTagItem("Yes", Boolean.TRUE)
  };

  static ControlTagItem[] countryCodes = new ControlTagItem[] {
      new ControlTagItem(CountryCodeType.US.value(), CountryCodeType.US),
      new ControlTagItem("Great Britain", CountryCodeType.GB),
      new ControlTagItem("Germany", CountryCodeType.DE),
      new ControlTagItem("Canada", CountryCodeType.CA)
  };

  static ControlTagItem[] enabledStatus = new ControlTagItem[] {
      new ControlTagItem(EnableCodeType.ENABLE.value(), EnableCodeType.ENABLE),
      new ControlTagItem(EnableCodeType.DISABLE.value(), EnableCodeType.DISABLE)
  };

  static ControlTagItem[] currencyIDs = new ControlTagItem[] {
      new ControlTagItem(CurrencyCodeType.USD.value(), CurrencyCodeType.USD),
      new ControlTagItem(CurrencyCodeType.GBP.value(), CurrencyCodeType.GBP),
      new ControlTagItem(CurrencyCodeType.EUR.value(), CurrencyCodeType.EUR),
      new ControlTagItem(CurrencyCodeType.CAD.value(), CurrencyCodeType.CAD)
  };

  static ControlTagItem[] sortOrderInt = new ControlTagItem[] {
      new ControlTagItem("No sorting", new Integer(0)),
      new ControlTagItem("Descending", new Integer(1)),
      new ControlTagItem("Ascending", new Integer(2))
  };

  static ControlTagItem[] listingTypes = new ControlTagItem[] {
      new ControlTagItem(ListingTypeCodeType.CHINESE.value(), ListingTypeCodeType.CHINESE),
      new ControlTagItem(ListingTypeCodeType.DUTCH.value(), ListingTypeCodeType.DUTCH),
      new ControlTagItem(ListingTypeCodeType.LIVE.value(), ListingTypeCodeType.LIVE),
      new ControlTagItem(ListingTypeCodeType.AD_TYPE.value(), ListingTypeCodeType.AD_TYPE),
      new ControlTagItem(ListingTypeCodeType.STORES_FIXED_PRICE.value(), ListingTypeCodeType.STORES_FIXED_PRICE),
      new ControlTagItem(ListingTypeCodeType.PERSONAL_OFFER.value(), ListingTypeCodeType.PERSONAL_OFFER),
      new ControlTagItem(ListingTypeCodeType.FIXED_PRICE_ITEM.value(), ListingTypeCodeType.FIXED_PRICE_ITEM)
  };

  static ControlTagItem[] messageStatuses = new ControlTagItem[] {
      new ControlTagItem(MessageStatusTypeCodeType.ANSWERED.value(), MessageStatusTypeCodeType.ANSWERED),
      new ControlTagItem(MessageStatusTypeCodeType.UNANSWERED.value(), MessageStatusTypeCodeType.UNANSWERED)
  };

  static ControlTagItem[] messageTypes = new ControlTagItem[] {
      new ControlTagItem(MessageTypeCodeType.ASK_SELLER_QUESTION.value(), MessageTypeCodeType.ASK_SELLER_QUESTION)
  };

  static ControlTagItem[] notificationEvents = new ControlTagItem[] {
      new ControlTagItem(NotificationEventTypeCodeType.ASK_SELLER_QUESTION.value(), NotificationEventTypeCodeType.ASK_SELLER_QUESTION),
      new ControlTagItem(NotificationEventTypeCodeType.AUCTION_CHECKOUT_COMPLETE.value(), NotificationEventTypeCodeType.AUCTION_CHECKOUT_COMPLETE),
      new ControlTagItem(NotificationEventTypeCodeType.BEST_OFFER.value(), NotificationEventTypeCodeType.BEST_OFFER),
      new ControlTagItem(NotificationEventTypeCodeType.BUYER_RESPONSE_DISPUTE.value(), NotificationEventTypeCodeType.BUYER_RESPONSE_DISPUTE),
      new ControlTagItem(NotificationEventTypeCodeType.CHECKOUT_BUYER_REQUESTS_TOTAL.value(), NotificationEventTypeCodeType.CHECKOUT_BUYER_REQUESTS_TOTAL),
      new ControlTagItem(NotificationEventTypeCodeType.END_OF_AUCTION.value(), NotificationEventTypeCodeType.END_OF_AUCTION),
      new ControlTagItem(NotificationEventTypeCodeType.FEEDBACK.value(), NotificationEventTypeCodeType.FEEDBACK),
      new ControlTagItem(NotificationEventTypeCodeType.FEEDBACK_FOR_SELLER.value(), NotificationEventTypeCodeType.FEEDBACK_FOR_SELLER),
      new ControlTagItem(NotificationEventTypeCodeType.FIXED_PRICE_TRANSACTION.value(), NotificationEventTypeCodeType.FIXED_PRICE_TRANSACTION),
      new ControlTagItem(NotificationEventTypeCodeType.ITEM_LISTED.value(), NotificationEventTypeCodeType.ITEM_LISTED),
      new ControlTagItem(NotificationEventTypeCodeType.ITEM_REVISED.value(), NotificationEventTypeCodeType.ITEM_REVISED),
      new ControlTagItem(NotificationEventTypeCodeType.OUT_BID.value(), NotificationEventTypeCodeType.OUT_BID),
      new ControlTagItem(NotificationEventTypeCodeType.SECOND_CHANCE_OFFER.value(), NotificationEventTypeCodeType.SECOND_CHANCE_OFFER),
      new ControlTagItem(NotificationEventTypeCodeType.SELLER_CLOSED_DISPUTE.value(), NotificationEventTypeCodeType.SELLER_CLOSED_DISPUTE),
      new ControlTagItem(NotificationEventTypeCodeType.SELLER_OPENED_DISPUTE.value(), NotificationEventTypeCodeType.SELLER_OPENED_DISPUTE),
      new ControlTagItem(NotificationEventTypeCodeType.SELLER_RESPONDED_TO_DISPUTE.value(), NotificationEventTypeCodeType.SELLER_RESPONDED_TO_DISPUTE),
      new ControlTagItem(NotificationEventTypeCodeType.NONE.value(), NotificationEventTypeCodeType.NONE),
  };

  static ControlTagItem[] notificationRoles = new ControlTagItem[] {
      new ControlTagItem(NotificationRoleCodeType.APPLICATION.value(), NotificationRoleCodeType.APPLICATION),
      new ControlTagItem(NotificationRoleCodeType.USER.value(), NotificationRoleCodeType.USER)
  };

  static ControlTagItem[] orderStatuses = new ControlTagItem[] {
      new ControlTagItem(OrderStatusCodeType.ACTIVE.value(), OrderStatusCodeType.ACTIVE),
      new ControlTagItem(OrderStatusCodeType.INACTIVE.value(), OrderStatusCodeType.INACTIVE),
      new ControlTagItem(OrderStatusCodeType.COMPLETED.value(), OrderStatusCodeType.COMPLETED),
      new ControlTagItem(OrderStatusCodeType.CANCELLED.value(), OrderStatusCodeType.CANCELLED)
  };

  static ControlTagItem[] orderRoles = new ControlTagItem[] {
      new ControlTagItem(TradingRoleCodeType.BUYER.value(), TradingRoleCodeType.BUYER),
      new ControlTagItem(TradingRoleCodeType.SELLER.value(), TradingRoleCodeType.SELLER)
  };

  static ControlTagItem[] shippingTypes = new ControlTagItem[] {
      new ControlTagItem(" " + ShippingTypeCodeType.FLAT.value() + " ", ShippingTypeCodeType.FLAT)
  };

  static ControlTagItem[] sites = new ControlTagItem[] {
      new ControlTagItem(SiteCodeType.US.value(), SiteCodeType.US),
      new ControlTagItem(SiteCodeType.UK.value(), SiteCodeType.UK),
      new ControlTagItem(SiteCodeType.GERMANY.value(), SiteCodeType.GERMANY),
      new ControlTagItem(SiteCodeType.CANADA.value(), SiteCodeType.CANADA)
  };
}
