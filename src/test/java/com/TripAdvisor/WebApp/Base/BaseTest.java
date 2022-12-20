/**
 * 
 */
package com.TripAdvisor.WebApp.Base;

import java.time.Duration;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;


import com.TripAdvisor.WebApp.Utilities.PropertyFileReader;
import com.TripAdvisor.WebApp.Utilities.TimeOutsProvider;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * @author Vrushali
 *
 */
public class BaseTest {
 
	protected WebDriver driver;
	Logger logger=Logger.getLogger(BaseTest.class.getName());
	/**
	 * This Before method opens the home page before every test 
	 * @param browser this browser parameter is given by testng.xml
	 */
	@Parameters("Browser")
	@BeforeMethod
	public void init(String browser)
	{
		if (browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			
		}

		else if (browser.equalsIgnoreCase("microsoftEdge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
		logger.info("opened browser: "+browser);
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(TimeOutsProvider.PAGETIMEOUT));
		
		driver.get(PropertyFileReader.readConfigFile().getProperty("url"));
		logger.info("opened the URL :"+driver.getCurrentUrl());
	}
	/**
	 * this method annotated with AfterMethod 
	 * which gets executed after every test
	 */
	@AfterMethod
	public void tearDown()
	{
		//driver.close();
		driver.quit();
		System.out.println("browser closed");
	}
	
}
