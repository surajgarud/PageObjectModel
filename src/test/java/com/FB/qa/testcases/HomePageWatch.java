package com.FB.qa.testcases;

import java.awt.AWTException;
import java.io.IOException;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.FB.qa.base.TestBase;
import com.FB.qa.pages.HomePage;

public class HomePageWatch extends TestBase{
	
	public HomePage homePg;
	
	public HomePageWatch() {
		super();
	}
	
@BeforeMethod
//in this anotation first we calling properties in parent class then we are doing initialization
	public void setUp() {
		init();
		homePg = new HomePage();
	}
@Test
  public void HomePagetest() throws InterruptedException, AWTException, IOException {
	  homePg.Homepage(prop.getProperty("email"),prop.getProperty("password"));
}
  public void tearDown() throws InterruptedException {
		Thread.sleep(4000);
		driver.quit();
	}

}
