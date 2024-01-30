package com.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PatientLoginPage {
	
	@FindBy(name="username")
	private WebElement Username;
	
	
	@FindBy(name="password")
	private WebElement Password;
	
	@FindBy(name="submit")
	private WebElement loginBtn;
	
	@FindBy(xpath=" //span[@class='username']")
    private WebElement profileBtn;
	
	@FindBy(xpath=" //a[contains(text(),'Log Out')]")
	private WebElement logoutBtn;
	
	public PatientLoginPage(WebDriver driver) 
	{
		PageFactory.initElements(driver,this);
	}

	public void PatLogin(String UN,String PWD) 
	{
		Username.sendKeys(UN);
		Password.sendKeys(PWD);
		loginBtn.click();
	}
	
	public void PatLogout() 
	{
		profileBtn.click();
		logoutBtn.click();
	}
	
}
