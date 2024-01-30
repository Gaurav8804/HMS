package com.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AppiontmentHistoryPage {
	
	@FindBy(xpath="//h1[text()='Doctor  | Appointment History']")
	private WebElement AppintHisverify;

	public AppiontmentHistoryPage(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}
	
	public WebElement getAppintHisverify() 
	{
		return AppintHisverify;
	}
	
	
	
}
