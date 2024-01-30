package com.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AppointmentHistoryPage {
	@FindBy(xpath=" //h1[text()='Patients  | Appointment History']")
	private WebElement appHistory;
	
	public AppointmentHistoryPage(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getAppHistory() {
		return appHistory;
	}
    
	
	
	
	
	
	
	
	
	
}
