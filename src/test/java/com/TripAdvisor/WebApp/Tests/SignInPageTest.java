/**
 * 
 */
package com.TripAdvisor.WebApp.Tests;

import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.Row;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.TripAdvisor.WebApp.Base.BaseTest;
import com.TripAdvisor.WebApp.Commons.DataProviderSignIn;
import com.TripAdvisor.WebApp.Pages.HomePage;
import com.TripAdvisor.WebApp.Pages.SignInPage;
import com.TripAdvisor.WebApp.Pages.UserHomePage;
import com.TripAdvisor.WebApp.Utilities.PropertyFileReader;
import com.TripAdvisor.WebApp.Utilities.ReadingXlsxSheet;

/**
 * This class demonstrate the unit and functional test cases on Sign in frame  
 * @author Vrushali
 *
 */
public class SignInPageTest extends BaseTest {
	private HomePage objHomePage;
	private SignInPage objSignInPage;
	private UserHomePage objUserSignInPage;
	
	Logger logger=Logger.getLogger(HomePageTest.class.getName());
	
	/**
	 * The objective of this test case is "To assert the Header of the frame"
	 * This test method uses hard assert concept from TestNG
	 */
	@Test
	public void TC_TripAdvisor_SignInPage_001()
	{
		objHomePage=new HomePage(driver);
		Assert.assertEquals(objHomePage.isLogoDisplayed(), true);
		objSignInPage=objHomePage.clickOnSignIn();
		String expected="Sign in to unlock the best of Tripadvisor.";
		Assert.assertEquals(objSignInPage.getSignInPageHeader(),expected);
		logger.info(expected+ "header displayed on login Frame");
	}
	
	/**
	 * The objective of this test case is "To verify Continue With Google option has been displayed"
	 */
	@Test
	public void TC_TripAdvisor_SignInPage_002()
	{
		objHomePage=new HomePage(driver);
		Assert.assertEquals(objHomePage.isLogoDisplayed(), true);
		objSignInPage=objHomePage.clickOnSignIn();
		String expected="Continue with Google";
		Assert.assertEquals(objSignInPage.textOnContinueWithGoogle(),expected);
		logger.info(expected+ " Option displayed on login Frame");
	}
	
	/**
	 * The objective of this test case is "To verify Continue With Facebook option has been displayed"
	 */
	@Test
	public void TC_TripAdvisor_SignInPage_003()
	{
		objHomePage=new HomePage(driver);
		Assert.assertEquals(objHomePage.isLogoDisplayed(), true);
		objSignInPage=objHomePage.clickOnSignIn();
		String expected="Continue with Facebook";
		Assert.assertEquals(objSignInPage.textOnContinueWithFacebook(),expected);
		logger.info(expected+ " Option displayed on login Frame");
	}
	
	
	/**
	 * The objective of this test case is "To verify Continue With email option has been displayed"
	 */
	@Test
	public void TC_TripAdvisor_SignInPage_004()
	{
		objHomePage=new HomePage(driver);
		Assert.assertEquals(objHomePage.isLogoDisplayed(), true);
		objSignInPage=objHomePage.clickOnSignIn();
		String expected="Continue with email";
		Assert.assertEquals(objSignInPage.textOnContinueWithEmail(),expected);
		logger.info(expected+ " Option displayed on login Frame");
	}
	
	/**
	 * The objective of this test case is "To verify after clicking "Continue With email" indented pop up frame gets open"
	 */
	@Test
	public void TC_TripAdvisor_SignInPage_005()
	{
		objHomePage=new HomePage(driver);
		Assert.assertEquals(objHomePage.isLogoDisplayed(), true);
		objSignInPage=objHomePage.clickOnSignIn();
		objSignInPage.clickOnContinueWithEmail();
		String expected="Welcome back.";
		Assert.assertEquals(objSignInPage.getEmailHeader(),expected);
		logger.info(expected+ "header displayed on login Frame");
	}
	

	/**
	 * The objective of this test case is "To verify that user can login with valid credentials"
	 * This takes test data i.e valid credentials to sign in from config.properties file
	 */
	@Test
	public void TC_TripAdvisor_SignInPage_006()
	{
		objHomePage=new HomePage(driver);
		Assert.assertEquals(objHomePage.isLogoDisplayed(), true);
		objSignInPage=objHomePage.clickOnSignIn();
		objSignInPage.clickOnContinueWithEmail();
		objUserSignInPage=objSignInPage.signInWithCredentials(PropertyFileReader.readConfigFile().getProperty("emailAddress"),PropertyFileReader.readConfigFile().getProperty("password"));
		String expectedTitle= "Tripadvisor: Over a billion reviews & contributions for Hotels, Attractions, Restaurants, and more";
		String actualTitle=objUserSignInPage.getTheUserHomePageTitle();
		Assert.assertEquals(actualTitle, expectedTitle, "Wrong Page Opened");
		logger.info("User logged in with valid credentials");	
	}
	
	/*
	 *  The objective of this test case is "To verify that user can not login with invalid credentials"
	 *  this test method demonstrate data driven testing 
	 *  this is negative test case
	 *  the data provider reads test data from Excel file and run the test cases
	 */
	@Test(dataProvider="dataProviderForSignIn",dataProviderClass=DataProviderSignIn.class)
	public void TC_TripAdvisor_SignInPage_Negative_007(Row rows)
	{
		objHomePage=new HomePage(driver);
		Assert.assertEquals(objHomePage.isLogoDisplayed(), true);
		objSignInPage=objHomePage.clickOnSignIn();
		objSignInPage.clickOnContinueWithEmail();
		String testData[]=ReadingXlsxSheet.readingXlsSheetRowWise(rows);
		objSignInPage.signInWithCredentials(testData[0],testData[1]);
		String expectedMessage= "Either your email or password was incorrect. Please try again or click the \"Forgot password?\" link below.";
		String actualMessage=objSignInPage.getTheErrorMessageOnInvalidCredetials();
		Assert.assertEquals(actualMessage, expectedMessage, "Some error in login page");
		logger.info("User cannot logged in with invalidvalid credentials");	
	}
	
	/*
	 * The objective of this test case is "To verify that user can not login with Blank Email address"
	 * This is negative test case
	 */
	@Test
	public void TC_TripAdvisor_SignInPage_Negative_008()
	{
		objHomePage=new HomePage(driver);
		Assert.assertEquals(objHomePage.isLogoDisplayed(), true);
		objSignInPage=objHomePage.clickOnSignIn();
		objSignInPage.clickOnContinueWithEmail();
		objSignInPage.signInWithCredentials("TripAdvisorLogin",'P');
		String expectedMessage= "E-mail address is required";
		String actualMessage=objSignInPage.getTheErrorMessageOnBlankEmailAddress();
		Assert.assertEquals(actualMessage, expectedMessage, "Some error in login page");
		logger.info("User cannot logged in with blank Email address");	
	}
	
	
	/*
	 * The objective of this test case is "To verify that user can not login with Blank Password"
	 *  This is negative test case
	 */
	@Test
	public void TC_TripAdvisor_SignInPage_Negative_009()
	{
		objHomePage=new HomePage(driver);
		Assert.assertEquals(objHomePage.isLogoDisplayed(), true);
		objSignInPage=objHomePage.clickOnSignIn();
		objSignInPage.clickOnContinueWithEmail();
		objSignInPage.signInWithCredentials("testingpurposesel@gmail.com",'E');
		String expectedMessage= "Your password should be at least 6 characters long.";
		String actualMessage=objSignInPage.getTheErrorMessageOnBlankPassword();
		Assert.assertEquals(actualMessage, expectedMessage, "Some error in login page");
		logger.info("User cannot logged in with blank Password");	
	}

}
