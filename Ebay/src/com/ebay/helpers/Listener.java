package com.ebay.helpers;

import org.apache.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

public class Listener extends TestListenerAdapter {

	Logger log = Logger.getLogger("devpinoyLogger");

	@Override
	public void onTestStart(ITestResult result) {
		log.info("Test started: "+result.getMethod().toString());
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		log.info("Test Succeeded: "+result.getMethod().toString());

	}

	@Override
	public void onTestFailure(ITestResult result) {
		 log.info("Test failed: "+result.getMethod().toString());

	}

	@Override
	public void onTestSkipped(ITestResult result) {
		 log.info("Test Skipped: "+result.getMethod().toString());

	}

	@Override
	public void onStart(ITestContext context) {
		log.info("Suite started: "+context.getName());

	}

	@Override
	public void onFinish(ITestContext context) {
		log.info("Suite finished: "+context.getName());

	}

}
