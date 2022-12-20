/**
 * 
 */
package com.TripAdvisor.WebApp.Tests;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.TripAdvisor.WebApp.Base.BaseTest;
import com.TripAdvisor.WebApp.Pages.HomePage;



/**
 * This class demonstrate the unit and functional test cases on Home page 
 * @author Vrushali
 *
 */
public class HomePageTest extends BaseTest{
	
	private HomePage objHomePage;
	
	Logger logger=Logger.getLogger(HomePageTest.class.getName());
	/**
	 * The objective of this test case is "To assert the title of apllication's home page"
	 * This test method uses hard assert concept from TestNG
	 */
	@Test
	public void TC_TripAdvisor_HomePage_001()
	{
		objHomePage=new HomePage(driver);
		String expectedTitle= "Tripadvisor: Over a billion reviews & contributions for Hotels, Attractions, Restaurants, and more";
		String actualTitle=objHomePage.getTheHomePageTitle();
		Assert.assertEquals(actualTitle, expectedTitle, "Wrong Page Opened");
		logger.info("TripAdvisor HomePage opened");	
	}
	
	/**
	 * The objective of this case is "To verify the apllication's logo has been displayed"
	 * this method used Soft assert or verify concept from TestNG
	 */
	@Test
	void TC_TripAdvisor_HomePage_002()
	{
		objHomePage=new HomePage(driver);
		SoftAssert sa=new SoftAssert();
		sa.assertEquals(objHomePage.isLogoDisplayed(), true);
		sa.assertAll();
		if(objHomePage.isLogoDisplayed())
		{
			logger.info("TripAdvisor logo has been displayed");
		}
		else
		{
			logger.error("TripAdvisor logo haven't been displayed");
		}
	}
	
	/**
	 * The objective of this case is "To assert the apllication's Sign In Link Displayed"
	 * This method assert that login link has been displayed
	 */
	@Test
	void TC_TripAdvisor_HomePage_003()
	{
		objHomePage=new HomePage(driver);
		Assert.assertEquals(objHomePage.isSignInDisplayed(), true);
		logger.info("Sign In Link has been displayed and clickable");
	}
	
}
