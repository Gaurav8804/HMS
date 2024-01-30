package com.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DoctorSessionLogPage {

	@FindBy(xpath=" //td[@class='hidden-xs']")
	private WebElement DocSESSLOG;
	
	@FindBy(xpath="//h1[text()='Admin  | Doctor Session Logs']")
	private WebElement DSLverify;
	
	public DoctorSessionLogPage(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
		 
	}
	
	public WebElement getDSLverify() {
		return DSLverify;
	}


	public WebElement getdocSESSLOG()
	{
		return DocSESSLOG;
	}	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
