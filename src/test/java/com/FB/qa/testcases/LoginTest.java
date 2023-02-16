package com.FB.qa.testcases;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.FB.qa.base.TestBase;
import com.FB.qa.pages.LoginPage;
import com.FB.qa.utility.DataDrivenclass;

//extends use to set relation between TestBase and all pages bcz TestBase is Parent class
public class LoginTest extends TestBase{
	public LoginPage loginpg;
	public DataDrivenclass utility;
	public String sheetname = "Sheet1";
//creating ctor and calling super keyWord bcz it will call properties from Parent class before initialization
	public LoginTest() {
		super();
	}
	
	@BeforeMethod
//in this anotation first we calling properties in parent class then we are doing initialization
	public void setUp() {
		init();
	 loginpg = new LoginPage();
	}

	@Test(priority=2)
	public void Logintest() {
		loginpg.login(prop.getProperty("email"),prop.getProperty("password"));
	}
	
	@DataProvider
	public Object[][]getLoginDetails() throws InvalidFormatException{
		Object data[][]=utility.getTestData(sheetname);
		return data;
	}
	@Test(dataProvider = "getLoginDetails",priority=3)
	public void MultiUserLogin(String un, String pw) {
		loginpg.multipleUserLogin(un,pw);
	}
	@Test(priority=1)
	public void URL() {
		String url = loginpg.getURL();
		Assert.assertEquals(url, "https://www.facebook.com/");
	}
	@AfterMethod
	public void tearDown() throws InterruptedException {
		Thread.sleep(4000);
		driver.quit();
	}
	

}
