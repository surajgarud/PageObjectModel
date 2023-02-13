package com.FB.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.FB.qa.base.TestBase;
import com.FB.qa.pages.SignUpPage;

public class SignUpTest extends TestBase{
	public SignUpPage signup;

	public SignUpTest() {
		super();
	}
	
	@BeforeMethod
	//in this anotation first we calling properties in parent class then we are doing initialization
		public void setUp() {
			init();
			signup = new SignUpPage();
		}
	@Test
	public void SignUptest() throws InterruptedException {
		signup.Signup(prop.getProperty("FirstName"),
				prop.getProperty("LastName"),
				prop.getProperty("Email"),
				prop.getProperty("ReEnterEmail"),
				prop.getProperty("newPass"),
				prop.getProperty("days"),
				prop.getProperty("months"),
				prop.getProperty("years"));
	}
	
	@AfterMethod
	public void tearDown() throws InterruptedException {
		Thread.sleep(4000);
		driver.quit();
	}
}
