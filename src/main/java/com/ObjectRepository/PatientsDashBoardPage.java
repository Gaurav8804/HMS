package com.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PatientsDashBoardPage {
	
	@FindBy(xpath=" //div[@class='panel-body']//a[contains(text(),'Update Profile')]")
	private WebElement UpdateProfile;
	
	@FindBy(xpath=" //div[@class='panel-body']//h2[contains(text(),'My Appointments')]")
	private WebElement myAppointments;
	
	@FindBy(xpath=" //span[text()=' Book Appointment ']")
	private WebElement bookAppointment;
	
	@FindBy(xpath=" //span[text()=' Appointment History ']")
	private WebElement appointmentHistory;
	
	@FindBy(xpath=" //span[text()=' Medical History ']")
	private WebElement medHistory;
	
	public PatientsDashBoardPage(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getUpdateProfile() {
		return UpdateProfile;
	}

	public WebElement getAppointments() {
		return myAppointments;
	}

	public WebElement getBookAppointment() {
		return bookAppointment;
	}

	public WebElement getAppointmentHistory() {
		return appointmentHistory;
	}

	public WebElement getMedHistory() {
		return medHistory;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
