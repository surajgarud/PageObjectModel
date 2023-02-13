package com.FB.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.FB.qa.base.TestBase;

//extends use to set relation between TestBase and all pages bcz TestBase is Parent class
public class LoginPage extends TestBase{
	
//find by method is supports all the elements to find works same as findElement method
	@FindBy(id="email")
	WebElement email;   			//creating variable to use later in class
	
	@FindBy(id="pass")
	WebElement passContainer;

	@FindBy(name="login")
	WebElement login;
	
	
//creating ctor to init all methoads
	 public LoginPage() {
		 
	//"this" is use to init all method in this class
		 PageFactory.initElements(driver, this);
	 }
	 
//Actions	
	 
	 public String getURL() {
		return driver.getCurrentUrl();
	 }
	 
//Using HomePage instead of void bcz we are returning Homepage from pages pkg
	 public HomePage login(String un,String pw) {
		 email.sendKeys(un);
		 passContainer.sendKeys(pw);
		 login.click();
		 
		 // after clicking login btn it will land on Homepage so giving return type is HomePage in pages folder
		 return new HomePage();
	 }
}
