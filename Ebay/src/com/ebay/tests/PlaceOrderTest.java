/**
 * This class contains test cases for placing an order. Extends BaseTest class to get the browser instance
 * 
 * @author Sandeep Shetty
 * 
 */

package com.ebay.tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import java.net.MalformedURLException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Properties;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.ebay.helpers.Utility;
import com.ebay.pages.PlaceOrderPage;

public class PlaceOrderTest extends BaseTest {
	PlaceOrderPage landingPage;
	Properties prop;
	Map<String, String> map;

	@Parameters("testItem")
	@BeforeClass
	public void startTest(@Optional("Test On Android Device") String param) throws MalformedURLException {
		initTest(param);
		landingPage = new PlaceOrderPage(androidDriver);
		prop = Utility.getProperties();
	}

	@Test(priority = 1, description = "Change location to Australia and search for a product")
	public void searchProduct() {
		landingPage.changeLocation();
		landingPage.findAndroidElement(landingPage.searchField).click();
		landingPage.findAndroidElement(landingPage.searchFieldInDetail).sendKeys(prop.getProperty("searchparam"));
		Utility.androidElements(landingPage.searchSuggestion, androidDriver).get(0).click();
		assertTrue(landingPage.isAndroidElementDisplayed(landingPage.searchResult));
	}

	@Test(priority = 2, description = "Tap on a search result")
	public void clickSearchResult() {
		Utility.androidElements(landingPage.searchResult, androidDriver).get(0).click();
		assertTrue(landingPage.isAndroidElementDisplayed(landingPage.itemName));
	}

	@DataProvider(name = "productDetailElements")
	public Object[][] landingPageElements() {
		Object[][] input = { { landingPage.itemName, "Item name not found" },
				{ landingPage.itemPrice, "Price not found" }, { landingPage.buyItNow, "Buy Now button not found" } };
		return input;

	}

	@Test(priority = 3, dataProvider = "productDetailElements", description = "Check elements in product detail page")
	public void checkElementsInProductDetail(By element, String error) {
		assertTrue(landingPage.isAndroidElementDisplayed(element));
	}

	@Test(priority = 4, description = "Save item name and price and tap on Buy Now button in product detail")
	public void tapBuyNowButton() {
		map = new LinkedHashMap<String, String>();
		map.put("itemName", landingPage.findAndroidElement(landingPage.itemName).getText());
		map.put("itemPrice", landingPage.findAndroidElement(landingPage.itemPrice).getText().substring(5));
		landingPage.findAndroidElement(landingPage.buyItNow).click();
		assertTrue(landingPage.isAndroidElementDisplayed(landingPage.userName));
	}

	@Test(priority = 5, description = "Login and verify the price and item name in cart")
	public void loginToEbay() {
		landingPage.findAndroidElement(landingPage.userName).sendKeys(prop.getProperty("username"));
		landingPage.findAndroidElement(landingPage.password).sendKeys(prop.getProperty("password"));
		landingPage.findAndroidElement(landingPage.SignInButton).click();
		landingPage.findAndroidElement(landingPage.noThanks).click();
		assertEquals(map.get("itemName"), landingPage.findAndroidElement(landingPage.itemTitleInCart).getText());
		assertTrue(landingPage.findAndroidElement(landingPage.itemPrice).getText().contains(map.get("itemPrice")));
	}

	@Test(priority = 6, description = "Review the order in checkout page")
	public void reviewOrder() {
		map.put("shippingCharge", landingPage.findAndroidElement(landingPage.shippingPriceInCart).getText());
		landingPage.findAndroidElement(landingPage.reviewButton).click();
		assertEquals(map.get("itemName"), landingPage.findAndroidElement(landingPage.itemTitleInCart).getText());
		assertTrue(
				landingPage.findAndroidElement(landingPage.itemPriceInCart).getText().contains(map.get("itemPrice")));
	}

	@Test(priority = 7, description = "Check pricing details in checkout page")
	public void scrollDownToCheckFinalPrice() {
		Utility.scroll(androidDriver, landingPage.payWithLabel, landingPage.messageToSellerLabel);
		assertTrue(Utility.androidElements(landingPage.subTotal, androidDriver).get(0).getText()
				.contains(map.get("itemPrice")));
		if (map.get("shippingCharge").equals("Free")) {
			assertTrue(Utility.androidElements(landingPage.subTotal, androidDriver).get(1).getText()
					.contains(map.get("shippingCharge")));
			assertTrue(
					landingPage.findAndroidElement(landingPage.checkOutTotal).getText().contains(map.get("itemPrice")));
		} else {
			assertTrue(Utility.androidElements(landingPage.subTotal, androidDriver).get(1).getText()
					.contains(map.get("shippingCharge").substring(7)));
			assertFalse(
					landingPage.findAndroidElement(landingPage.checkOutTotal).getText().contains(map.get("itemPrice")));
		}

	}

}
