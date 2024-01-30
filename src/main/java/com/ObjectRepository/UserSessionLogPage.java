package com.ObjectRepository;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserSessionLogPage {
	
	@FindBy(xpath="//h1[text()='Admin  | User Session Logs']")
	private WebElement USLverify;
	
	@FindBy(xpath=" //th[@class='hidden-xs']")
	private List<WebElement> userSessionlog; 
	
	public UserSessionLogPage(WebDriver driver ) 
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getUSLverify() {
		return USLverify;
	}

	public List<WebElement> getUserSessionlog() {
		return userSessionlog;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
