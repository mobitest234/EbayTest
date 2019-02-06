/**
 * This class defines the driver object based on the parameter
 * 
 * @author Sandeep Shetty
 * 
 */

package com.ebay.tests;

import java.net.MalformedURLException;
import org.testng.annotations.AfterSuite;
import com.ebay.helpers.GetDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class BaseTest {
	AndroidDriver<MobileElement> androidDriver;

	/**
	 * initTest() method instantiates the driver object based on the parameter
	 * passed from testng.xml
	 * 
	 */

	public void initTest(String testName) throws MalformedURLException {
		androidDriver = GetDriver.returnDriver(testName);
	}

	@AfterSuite
	public void quitApplication() {
		androidDriver.quit();
	}

}