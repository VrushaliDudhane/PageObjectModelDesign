/**
 * 
 */
package com.TripAdvisor.WebApp.Commons;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

import com.TripAdvisor.WebApp.Utilities.PropertyFileReader;

/** 
 * This is the data provider class
 * @author Vrushali
 *
 */
public class DataProviderSignIn {
	/**
	 * This is the Data provider method based on lazy data provider
	 * This method reads the Excel file data and runs the test script on each row of the ERxcel sheet, which consider as separate data set
	 * the path of excel sheet has benn specified in config.properties file
	 * @return Iterator<Row> 
	 */
	@DataProvider(name="dataProviderForSignIn")
	public Iterator<Row> loginDataProvider()
	{
		FileInputStream fip;
		 XSSFSheet sheet=null;
		  XSSFWorkbook workbook = null;
		  
		  try {
			fip=new FileInputStream(PropertyFileReader.readConfigFile().getProperty("testDataForLogInXlsxPath"));
			workbook=new XSSFWorkbook(fip);
		  } catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  sheet=workbook.getSheet("InvalidCredentials");
		  Iterator<Row> rows= sheet.rowIterator();
			 return rows;
	}

}
