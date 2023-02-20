package com.FB.qa.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;

import com.FB.qa.base.TestBase;

public class DataDrivenclass extends TestBase{
	
	public void screenshot(String testName) throws IOException {
		TakesScreenshot ts = (TakesScreenshot)driver;      
		File file = ts.getScreenshotAs(OutputType.FILE);
		File Afile = new File("C:\\Users\\suraj\\eclipse-workspace\\PageObjModel\\FailTest_Screenshot\\"+testName+".png");
		FileHandler.copy(file,Afile);
	}
	public static String ExcelPath = "C:\\Users\\suraj\\eclipse-workspace\\PageObjModel\\src\\main\\java\\com\\FB\\qa\\TestData\\Book1.xlsx";
	static Workbook book;
	static org.apache.poi.ss.usermodel.Sheet sheet;
	
	public static Object[][] getTestData(String sheetname) throws InvalidFormatException{
		FileInputStream file = null;
		try {
			file = new FileInputStream(ExcelPath);
		}catch (FileNotFoundException e) {
		 e.printStackTrace();
	    }
		try {
			book = WorkbookFactory.create(file);
		}catch (EncryptedDocumentException | IOException e) {
			e.printStackTrace();
		}
		sheet = book.getSheet(sheetname);
		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		for(int i=0; i<sheet.getLastRowNum(); i++) {
			for(int k=0; k<sheet.getRow(0).getLastCellNum(); k++) {
				data[i][k] = sheet.getRow(i+1).getCell(k).toString();
			}
		}
		return data;
  }
}
