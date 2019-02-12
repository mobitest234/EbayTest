/**
 * This class contains the locators in PlaceOrderPage and any action methods for the page 
 * 
 * @author Sandeep Shetty
 * 
 */

package com.ebay.pages;

import org.openqa.selenium.By;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class PlaceOrderPage extends BasePage {

	AndroidDriver<MobileElement> androidDriver;

	public By menuButton = By.id("com.ebay.mobile:id/home");
	public By homeButtonInMenu = By.id("com.ebay.mobile:id/menuitem_home");
	public By notificationsButtonInMenu = By.id("com.ebay.mobile:id/menuitem_notifications");
	public By messagesButtonInMenu = By.id("com.ebay.mobile:id/menuitem_messages");
	public By settingsButton = By.id("com.ebay.mobile:id/menuitem_settings");
	public By settingsPageHeader = By.xpath("//android.widget.TextView[@text='Settings']");
	public By notificationsHeader = By.xpath("//android.widget.TextView[@content-desc='Notifications button']");
	public By watchingButton = By.id("com.ebay.mobile:id/menuitem_watching");
	public By categoriesButton = By.id("com.ebay.mobile:id/menuitem_categories");
	public By toggleButton = By.id("android:id/switch_widget");
	public By regionButton = By.xpath("//android.widget.TextView[@content-desc='Country/region button']");
	public By autoDetectLabel = By.xpath("//android.widget.TextView[@text='Auto-Detect']");
	public By chooseCountryDescription = By.xpath(
			"//android.widget.TextView[contains(@text,'Choose my country/region based on my primary shipping address')]");
	public By regionSelectorePageHeader = By.xpath("//android.widget.TextView[@text='Country/region']");
	public By regionDropDown = By
			.xpath("//android.widget.TextView[@text='Country/region' and @resource-id='android:id/title']");
	public By selectedCountry = By.xpath("//android.widget.TextView[@text='Australia']");
	public By searchFieldInSettings = By.id("com.ebay.mobile:id/filter");
	public By countryName = By.id("com.ebay.mobile:id/check_country");
	public By backButton = By.xpath("//android.widget.ImageButton[@content-desc='Navigate up']");
	public By searchButton = By.id("com.ebay.mobile:id/menu_search");
	public By searchField = By.id("com.ebay.mobile:id/search_box");
	public By searchFieldInDetail = By.id("com.ebay.mobile:id/search_src_text");
	public By searchSuggestion = By.id("com.ebay.mobile:id/text");
	public By searchResult = By.id("com.ebay.mobile:id/image");
	public By itemPrice = By.id("com.ebay.mobile:id/textview_item_price");
	public By itemName = By.id("com.ebay.mobile:id/textview_item_name");
	public By buyItNow = By.id("com.ebay.mobile:id/button_bin");
	public By signInLabel = By.id("com.ebay.mobile:id/textview_sign_out_status");
	public By userName = By.id("com.ebay.mobile:id/edit_text_username");
	public By password = By.id("com.ebay.mobile:id/edit_text_password");
	public By SignInButton = By.id("com.ebay.mobile:id/button_sign_in");
	public By noThanks = By.id("com.ebay.mobile:id/button_google_deny");
	public By itemTitleInCart = By.id("com.ebay.mobile:id/item_title");
	public By itemPriceInCart = By.id("com.ebay.mobile:id/item_price");
	public By shippingPriceInCart = By.id("com.ebay.mobile:id/shipping_textview");
	public By reviewButton = By.id("com.ebay.mobile:id/take_action");
	public By payWithLabel = By.id("com.ebay.mobile:id/payment_label");
	public By messageToSellerLabel = By.id("com.ebay.mobile:id/message_title");
	public By subTotal = By.id("com.ebay.mobile:id/checkout_summary_value");
	public By checkOutTotal = By.id("com.ebay.mobile:id/checkout_total_value");

	public PlaceOrderPage(AndroidDriver<MobileElement> androidDriver) {
		super(androidDriver);
		this.androidDriver = androidDriver;
	}

}