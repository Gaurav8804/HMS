package com.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ReadQueriesPage {
	
	@FindBy(xpath="//td[@class='hidden-xs']")
	private WebElement readQueries;
	
	public  ReadQueriesPage(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	} 
	
	public WebElement getReadQueries() 
	{
		return readQueries;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
