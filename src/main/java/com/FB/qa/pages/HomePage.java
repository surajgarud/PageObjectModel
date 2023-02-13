package com.FB.qa.pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.FB.qa.base.TestBase;

//extends use to set relation between TestBase and all pages bcz TestBase is Parent class
public class HomePage extends TestBase{
	@FindBy(id="email")
	WebElement email;   			//creating variable to use later in class
	
	@FindBy(id="pass")
	WebElement passContainer;

	@FindBy(name="login")
	WebElement login;
	
	@FindBy(xpath="//input[@placeholder='Search Facebook']")
	WebElement Search;
	
	@FindBy(partialLinkText="Er Vikas Thate (vIcky)")
	WebElement hover;
	public HomePage() {
		PageFactory.initElements(driver,this);
	}
	
	 public void Homepage(String un,String pw) throws InterruptedException, AWTException, IOException {
		 email.sendKeys(un);
		 passContainer.sendKeys(pw);
		 login.click();		
		 Thread.sleep(10000);
		 Search.sendKeys("vikas");
		 Search.sendKeys(Keys.ENTER);
		 Robot robot = new Robot();
//		 robot.mouseWheel(2);
//		robot.keyPress(KeyEvent.VK_ENTER);
//		robot.keyRelease(KeyEvent.VK_ENTER);
		 Thread.sleep(2000);
		 Actions act = new Actions(driver);
		 act.moveToElement(hover).perform();
	 }
}
