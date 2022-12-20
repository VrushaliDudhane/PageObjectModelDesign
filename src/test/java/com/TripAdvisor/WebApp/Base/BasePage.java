
package com.TripAdvisor.WebApp.Base;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;



/**
 * This BaePage class extends the Page class and implements all the methods present
 * @author Vrushali
 *
 */
public class BasePage extends Page {

	public Logger logger=Logger.getLogger( BasePage.class.getName());
	public BasePage(WebDriver driver) {
		super(driver);
	}

	/**
	 * This method gets the Title of the page
	 */
	@Override
	public String getPageTitle() {
		return driver.getTitle();
	}

	/**
	 * this method Gets the header of the page 
	 * @param locator of the Header
	 * @return String header
	 */
	@Override
	public String getPageHeader(By locator) {
		return getElement(locator).getText();
	}

	/**
	 * This method finds the WebElement on DOM
	 * this method Handels the probable exception using try catch block and sets error message on logger with locator value
	 * @param locator of the WebElement
	 * @return WebElemnt found on DOM
	 * 
	 */
	@Override
	public WebElement getElement(By locator) {
		WebElement element=null;
		try
		{
		return driver.findElement(locator);
		}catch (Exception e)
		{
			logger.error(locator+"  Element could Not Be found on DOM");
			e.printStackTrace();
		}
		return element;
	}

	/**
	 * This method waits for element to be present on DOM
	 * this method Handels the probable exception using try catch block and sets error message on logger with locator value
	 * @param locator of the WebElement
	 */
	@Override
	public void waitForElementToBePresent(By locator) {
		try
		{
			wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		}catch (Exception e)
		{
			logger.error(locator+"  Element could Not Be found on DOM Within given wait time");
			e.printStackTrace();
		}
	}

	/**
	 * This method waits for page title to be get loaded
	 * @param String title of the page
	 */
	@Override
	public void waitForPageTitle(String title) {
		wait.until(ExpectedConditions.titleContains(title));
		
	}
	
	/**
	 * This method waits for Frame to be get loaded
	 * @param WebElement locator 
	 */
	@Override
	public void waitForFrame(By locator) {
		try
		{
		 wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(locator));
		}catch (Exception e)
		{
			logger.error(locator+"  Frame is not available");
			e.printStackTrace();
		}
	}
	
	/**
	 * This method waits for element to be clickable
	 * this method Handels the probable exception using try catch block and sets error message on logger with locator value
	 * @param locator of the WebElement
	 */
	public void waitForElementToBeClickable(By locator) {
		try
		{
			wait.until(ExpectedConditions.elementToBeClickable(locator));
		}catch (Exception e)
		{
			logger.error(locator+"  Element Is not clickable");
			e.printStackTrace();
		}
	}

//	public WebElement getElementByJavaScript(By locator)
//	{
// //needs to change 
//		JavascriptExecutor js=(JavascriptExecutor)driver;
//		WebElement element=(WebElement)js.executeScript("return document.querySelector(\"button[class='ui_button w100p regEmailContinue newRegFormButtonStyles roundedRegFormButton emailButtonMargin']>span[class='textContainer']\")");
//		return element;
//	}
	

}
