package com.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DoctorLoginPage {
	@FindBy(name="username")
	private WebElement Username;
	
	@FindBy(name="password")
	private WebElement Password;
	
	@FindBy(name="submit")
	private WebElement LoginBtn;
	
	public DoctorLoginPage(WebDriver driver ) 
	{
		PageFactory.initElements(driver, this);
	}

	public void DoctorLogin(String un,String pwd) 
	{
		Username.sendKeys(un);
		Password.sendKeys(pwd);
		LoginBtn.click();
	}

}
