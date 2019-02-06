/**
 * This class contains the methods which are commonly used across the framework
 * 
 * @author Sandeep Shetty
 * 
 */

package com.ebay.helpers;

import java.io.File;
import java.io.FileInputStream;
import java.time.Duration;
import java.util.List;
import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidTouchAction;
import static io.appium.java_client.touch.WaitOptions.waitOptions;
import static io.appium.java_client.touch.offset.PointOption.point;

public class Utility {
	public static AndroidTouchAction action;
	public static JavascriptExecutor js;

	/**
	 * waitForAndroidElement() method enables us to wait until the element is clickable
	 * 
	 */

	public static void waitForAndroidElement(int timeUnits, By elementName,
			AndroidDriver<MobileElement> androidDriver) {
		WebDriverWait wait = new WebDriverWait(androidDriver, timeUnits);
		wait.until(ExpectedConditions.elementToBeClickable(elementName));
	}

	/**
	 * androidElements() method returns list of elements when multiple
	 * elements are found with same locator
	 * 
	 */

	public static List<MobileElement> androidElements(By locator, AndroidDriver<MobileElement> androidDriver) {
		waitForAndroidElement(10, locator, androidDriver);
		return androidDriver.findElements(locator);
	}

	/**
	 * getProperties() method loads and returns the properties in
	 * resources.properties file
	 * 
	 */

	public static Properties getProperties() {
		Properties prop = new Properties();
		File file = new File("./resources/resources.properties");
		try {
			FileInputStream fileInput = new FileInputStream(file);
			prop.load(fileInput);
		} catch (Exception e) {
			System.out.println("Failed to load resources.properties" + e.getMessage());
		}
		return prop;
	}

	/**
	 * scroll() method scrolls to the element using AndroidTouchAction
	 * 
	 */

	public static void scroll(AndroidDriver<MobileElement> driver, By locator1, By locator2) {
		if (action == null) {
			action = new AndroidTouchAction(driver);
		}
		action.press(point(driver.findElement(locator1).getLocation())).waitAction(waitOptions(Duration.ofMillis(300)))
				.moveTo(point(driver.findElement(locator2).getLocation())).release().perform();
	}

}
