package com.TripAdvisor.WebApp.Tests;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class tests {
	public static void main(String[] args) throws InterruptedException
	{
	WebDriverManager.chromedriver().setup();
	ChromeDriver driver;
	driver = new ChromeDriver();
	driver.manage().deleteAllCookies();
	driver.manage().window().maximize();
	driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	driver.get("https://www.tripadvisor.in/");
	System.out.println(driver.getTitle());
	driver.findElement(By.cssSelector("a[class=\"rmyCe _G B- z _S c Wc wSSLS w jWkoZ sOtnj\"]")).click();
//	Thread.sleep(3000);
//	System.out.println(driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/div[2]/div/div[1]/div/ul/li[1]/div/span")).getAccessibleName());
	driver.switchTo().frame(driver.findElement(By.cssSelector("iframe[class='bFOrV _R B- o']")));
	driver.findElement(By.cssSelector("button[class=\"ui_button w100p regEmailContinue newRegFormButtonStyles roundedRegFormButton emailButtonMargin\"]")).click();
	driver.findElement(By.cssSelector("input[id=\"regSignIn.email\"]")).sendKeys("testingpurposesel@gmail.com");
	driver.findElement(By.cssSelector("input[id=\"regSignIn.password\"]")).sendKeys("TripAdvisorLogin");
	driver.findElement(By.cssSelector("button[class=\"ui_button primary coreRegPrimaryButton  regSubmitBtnEvent\"]")).click();
	}

}
