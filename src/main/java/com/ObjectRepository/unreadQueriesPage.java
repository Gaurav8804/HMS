package com.ObjectRepository;

 
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class unreadQueriesPage {

	@FindBy(xpath=" //span[text()=' Unread Query ']")
	private WebElement unreadQueries;
	
	@FindBy(xpath=" //h1[text()='Admin | Manage Unread Queries']")
	private WebElement unreadQueriestext;
	
	@FindBy(xpath="//i[@class='fa fa-file']")
	private WebElement unreadQuerieslist;
	
	
	public WebElement getUnreadQuerieslist() {
		return unreadQuerieslist;
	}

	public WebElement getUnreadQueriestext() {
		return unreadQueriestext;
	}

	public unreadQueriesPage(WebDriver driver) 
	{
		PageFactory.initElements(driver,this);
	}
	
	public WebElement getUnreadQueries() 
	{
		return unreadQueries;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
