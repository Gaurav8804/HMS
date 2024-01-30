package com.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DoctorDashboardPage {

	@FindBy(xpath=" //h2[text()='My Profile']/parent::div//a")
	private WebElement UpdateProfile;
	
	@FindBy(xpath=" //h2[text()='My Appointments']/parent::div//a")
    private WebElement viewAppointmentHistory;
	
	@FindBy(xpath=" //span[text()=' Appointment History ']")
    private WebElement AppointmentHistoryOption;
	
	@FindBy(xpath="//span[@class='username']")
	private WebElement ProfileBtn;
	
	@FindBy(xpath=" //span[text()=' Dashboard ']")
	private WebElement  dashboardoption;
	
	public WebElement getDashboardoption() {
		return dashboardoption;
	}


	public WebElement getProfileBtn() {
		return ProfileBtn;
	}


	public WebElement getLogoutBtn() {
		return LogoutBtn;
	}


	@FindBy(xpath=" //a[contains(text(),'Log Out')]")
	private WebElement LogoutBtn;

	
	public WebElement getAppointmentHistoryOption()
	{
		return AppointmentHistoryOption;
	}


	@FindBy(xpath="//span[text()=' Patients ']")
	private WebElement patientsoption;
	
	@FindBy(xpath="//span[text()=' Add Patient']")
	private WebElement addPatients;
	
	@FindBy(xpath="//span[text()=' Manage Patient ']")
	private WebElement managePAtientsOption;
	
	
	public DoctorDashboardPage(WebDriver driver) 
	{
		PageFactory.initElements(driver,this);
	}


	public WebElement getUpdateProfile() {
		return UpdateProfile;
	}


	public WebElement getViewAppointmentHistory() {
		return viewAppointmentHistory;
	}


	public WebElement getPatientsoption() {
		return patientsoption;
	}


	public WebElement getAddPatients() {
		return addPatients;
	}


	public WebElement getManagePAtientsOption() {
		return managePAtientsOption;
	}  
	
	public void logout() 
	{
		ProfileBtn.click();
		LogoutBtn.click();
	}
	
	
	
	
}
