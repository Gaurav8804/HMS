package com.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class QuerydetailsPage {
	@FindBy(xpath="//h1[text()='Admin | Query Details']")
	private WebElement querydetails;
	
	public  QuerydetailsPage(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getQuerydetails() {
		return querydetails;
	} 

}
