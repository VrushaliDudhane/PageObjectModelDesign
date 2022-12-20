/**
 * 
 */
package com.TripAdvisor.WebApp.Utilities;




import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.TripAdvisor.WebApp.Base.BaseTest;

/**
 * @author Vrushali
 *
 */
public class TakingScreenShots extends BaseTest{
	public void takingScreenshot() {
		Date today=new Date();
		String todayDate=today.toString().replace(" ", "_").replace(":", "_");
		
//		TakesScreenshot sc = (TakesScreenshot) driver;
//		File source = sc.getScreenshotAs(OutputType.FILE);
//		File dest = new File(PropertyFileReader.readConfigFile().getProperty("screenShotFolderPath"));
//		try {
//			FileUtils.copyFileToDirectory(source, dest);
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String currentDir = System.getProperty("user.dir");
		try {
			FileUtils.copyFile(scrFile, new File(currentDir + "/screenshots/" + todayDate+"_"+System.currentTimeMillis()+ ".png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
