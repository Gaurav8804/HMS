package com.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageUsersPage {
	@FindBy(xpath="//h1[text()='Admin | Manage Users']")
	private WebElement manageUserverif;
	
	public ManageUsersPage(WebDriver driver) 
	{
		PageFactory.initElements(driver,  this);
	}

	public WebElement getManageUserverif() 
	{
		return manageUserverif;
	}
	
	
	
}
