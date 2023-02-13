package com.FB.qa.testcases;

import java.awt.AWTException;
import java.io.IOException;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.FB.qa.base.TestBase;
import com.FB.qa.pages.FB_Add_Story;
import com.FB.qa.pages.HomePage;


public class Test_Fb_Add_Story extends TestBase{
	public FB_Add_Story FbPg;

	public Test_Fb_Add_Story() {
		super();
	}
	
	@BeforeMethod
	//in this anotation first we calling properties in parent class then we are doing initialization
		public void setUp() {
			init();
			FbPg = new FB_Add_Story();
		}
	@Test
	public void FB_Addtest() throws InterruptedException, AWTException, IOException {
		FbPg.FB_Add_story(prop.getProperty("email"),prop.getProperty("password"));
	}
	
	public void tearDown() throws InterruptedException {
		Thread.sleep(4000);
		driver.quit();
	}
}
