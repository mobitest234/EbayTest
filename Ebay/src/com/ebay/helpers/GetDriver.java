/**
 * This class is for creating driver instance and launching the application
 * 
 * @author Sandeep Shetty
 * 
 */

package com.ebay.helpers;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class GetDriver {

	public static AndroidDriver<MobileElement> androidDriver;
	public static DesiredCapabilities caps;

	/**
	 * returnDriver() method returns the driver object based on the parameter
	 * 
	 */
	
	public static AndroidDriver<MobileElement> returnDriver(String testName) {
		if (androidDriver == null) {
			getDriver(testName);
			return androidDriver;
		} else {
			return androidDriver;
		}
	}
	
	/**
	 * getDriver() method creates the driver instance based on the parameter
	 * 
	 */

	public static void getDriver(String testName) {

		File appPath = new File("./ebay.apk");

		switch (testName) {
		case "Test On iOS Device":

		case "Test On Android Device":
			caps = new DesiredCapabilities();
			caps.setCapability("platformName", "Android");
			caps.setCapability("deviceName", "d748cc2f");
			caps.setCapability("platformVersion", "7.0");
			caps.setCapability("app", appPath.getAbsolutePath());
			caps.setCapability("appPackage", "com.ebay.mobile");
			caps.setCapability("appActivity", "com.ebay.mobile.activities.MainActivity");
			caps.setCapability("automationName", "uiautomator2");
			try {
				androidDriver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), caps);
			} catch (MalformedURLException e) {
				e.printStackTrace();
			}
			break;

		default:
			System.out.println("No Platform selected");
			break;
		}

	}

}