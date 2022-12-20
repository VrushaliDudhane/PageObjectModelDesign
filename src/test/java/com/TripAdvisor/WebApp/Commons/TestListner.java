/**
 * 
 */
package com.TripAdvisor.WebApp.Commons;

import org.apache.log4j.Logger;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.TripAdvisor.WebApp.Base.BaseTest;
import com.TripAdvisor.WebApp.Utilities.TakingScreenShots;


/**
 * This class implements ITestListner Interface
 * This class demonstrate how to catch screenshot of failed test cases and save to folder ScreenShots//FailedTestCases
 * @author Vrushali
 * 
 *
 */
public class TestListner implements ITestListener {
	
	Logger logger=Logger.getLogger(TestListner.class.getName());
	
	public void onTestFailure(ITestResult result) {
		logger.error(result.getMethod().toString().split(" ")[0] + "] Test case is failed");
		//TakingScreenShots objTakingScreenShots=new TakingScreenShots();
		//objTakingScreenShots.takingScreenshot();	 
	  }
	
	public void onTestSuccess(ITestResult result) {
		logger.info(result.getMethod().toString().split(" ")[0] + "] Test case is successful");
	  }
	
	public void onTestSkipped(ITestResult result) {
		logger.debug(result.getMethod().toString().split(" ")[0] + "] Test case is skipped");
	  }

	public void onTestStart(ITestResult result) {
		logger.info(result.getMethod().toString().split(" ")[0] + "] Test case is started");
		
	  }
}
