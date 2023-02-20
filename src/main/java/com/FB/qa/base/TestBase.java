package com.FB.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;



public class TestBase {
	public static Logger Log = Logger.getLogger(TestBase.class);
	public static WebDriver driver;		
	public static Properties prop;
	
	public ExtentReports extent = new ExtentReports();
	public ExtentSparkReporter spark = new ExtentSparkReporter("test-output/ExtentReport.html");
	//Creating constructor with same name as class
	public  TestBase() {
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream("C:\\Users\\suraj\\eclipse-workspace\\PageObjModel\\src\\main"
					+ "\\java\\com\\FB\\qa\\config\\config.properties");
			prop.load(ip);
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}
	
	public static void init() {
		Log.info("Browser Name :"+ prop.getProperty("browser"));
		//Getting browser name from properties file and store in String variable
		String Browser = prop.getProperty("browser");
		if(Browser.equals("chrome"));
		System.setProperty("webdriver.chrome.driver","C:\\Users\\suraj\\Downloads\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		Log.info("app url:"+ prop.getProperty("url"));
		//Launch url
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		
	}
}
