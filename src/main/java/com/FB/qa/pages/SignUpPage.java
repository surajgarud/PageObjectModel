package com.FB.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.FB.qa.base.TestBase;

public class SignUpPage extends TestBase{
	
	@FindBy(partialLinkText="Create new account")
	WebElement createnew;
	
	@FindBy(xpath="//input[@class='inputtext _58mg _5dba _2ph-']")
	WebElement FirstName;
	
	@FindBy(name="lastname")
	WebElement LastName;

	@FindBy(name="reg_email__")
	WebElement email;
	
	@FindBy(name="reg_email_confirmation__")
	WebElement ReEnter;
	
	@FindBy(name="reg_passwd__")
	WebElement newPass;
	
	@FindBy(id="day")
	WebElement days;
	
	@FindBy(id="month")
	WebElement months;
	
	@FindBy(id="year")
	WebElement years;
	
	@FindBy(xpath="(//span[@class='_5k_2 _5dba'])[1]")
	WebElement female;
	
	@FindBy(xpath="(//span[@class='_5k_2 _5dba'])[2]")
	WebElement male;
	
	@FindBy(xpath="(//span[@class='_5k_2 _5dba'])[3]")
	WebElement custom;
	
	@FindBy(name="websubmit")
	WebElement SignUpBtn;
	
	
	public SignUpPage() {
		PageFactory.initElements(driver,this);
	}
	
	public void Signup(String FN,String SN,String No,String reenter,String Pwd,String day,String month,String year) throws InterruptedException {
		createnew.click();
		FirstName.sendKeys(FN);
		LastName.sendKeys(SN);
		email.sendKeys(No);
		ReEnter.sendKeys(reenter);
		newPass.sendKeys(Pwd);
		days.sendKeys(day);
		months.sendKeys(month);
		years.sendKeys(year);
		female.click();
		Thread.sleep(2000);
		male.click();
		Thread.sleep(2000);
//		custom.click();
//		Thread.sleep(2000);
		SignUpBtn.click();
	}
}
