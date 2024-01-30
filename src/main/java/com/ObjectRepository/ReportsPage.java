package com.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ReportsPage {
	
	@FindBy(id="fromdate")
	private WebElement fromdate;
	 
	@FindBy(id="todate")
	private WebElement todate;
	
	@FindBy(id="submit")
	private WebElement submit;
	
	public WebElement getSubmit() {
		return submit;
	}

	public ReportsPage(WebDriver driver)  
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getFromdate() {
		return fromdate;
	}

	public WebElement getTodate() {
		return todate;
	}
	
	
	
	
	
	
	
	
	
	
	
	

}
