package com.FB.qa.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.FB.qa.base.TestBase;

public class FB_Add_Story extends TestBase{
	@FindBy(id="email")
	WebElement email;   			//creating variable to use later in class
	
	@FindBy(id="pass")
	WebElement passContainer;

	@FindBy(name="login")
	WebElement login;

	@FindBy(xpath="//div[@class='x1c4vz4f x2lah0s xeuugli x1bhewko x1emribx xnqqybz']")
	WebElement Story;
	
	@FindBy(xpath="//div[contains(@class,'x1qjc9v5 x1q0q8m5 x1qhh985 xu3j5b3')]")
	WebElement post;
	
	@FindBy(xpath="(//div[@class='x1iyjqo2 x1vqgdyp xsgj6o6 xw3qccf'])[2]")
	WebElement ShareToStory;
	
	public FB_Add_Story() {
		PageFactory.initElements(driver,this);
	}
	
	 public void FB_Add_story(String un,String pw) throws InterruptedException, IOException {
		 email.sendKeys(un);
		 passContainer.sendKeys(pw);
		 login.click();		
		 Thread.sleep(10000);
		 Story.click();
		 Thread.sleep(2000);
		 post.click();
		 Runtime.getRuntime().exec("C:\\Users\\suraj\\Documents\\FB_Upload.exe");
		 Thread.sleep(2000);
		 ShareToStory.click();
	 }

}
