/**
 * This class contains the methods which can be used in all the page classes
 * 
 * @author Sandeep Shetty
 * 
 */

package com.ebay.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;

import com.ebay.helpers.Utility;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class BasePage {

	AndroidDriver<MobileElement> androidDriver;

	public BasePage(AndroidDriver<MobileElement> androidDriver) {
		this.androidDriver = androidDriver;
	}

	/**
	 * findAndroidElement() method waits until the element is loaded and returns the
	 * mobile element
	 * 
	 */
	public MobileElement findAndroidElement(By elementToBeFound) {
		Utility.waitForAndroidElement(20, elementToBeFound, androidDriver);
		return androidDriver.findElement(elementToBeFound);
	}

	/**
	 * isAndroidElementDisplayed() method waits until the element is loaded and
	 * returns "true" if the element is displayed. "false" if the element is not
	 * displayed
	 * 
	 */

	public boolean isAndroidElementDisplayed(By elementToBeFound) {
		try {
			MobileElement elementFound = findAndroidElement(elementToBeFound);
			return elementFound.isDisplayed();
		} catch (TimeoutException e) {
			return false;
		}
	}

}