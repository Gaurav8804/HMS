package com.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminDashBoardPage {
	@FindBy(xpath="//span[text()=' Doctors ']")
    private WebElement Doctors;
	
	@FindBy(xpath="//span[text()=' Users ']")
	private WebElement Users;
	
	@FindBy(xpath="//span[text()=' Patients ']")
	private WebElement Patients;
	
	@FindBy(xpath="//span[text()=' Appointment History ']")
	private WebElement AppointmentHistory;
	
	@FindBy(xpath="//span[text()=' Conatctus Queries ']")
	private WebElement ContactQueries;
	
	@FindBy(xpath="//span[text()=' Doctor Session Logs ']")
	private WebElement DoctSessLog;
	
	@FindBy(xpath="//span[text()=' User Session Logs ']")
	private WebElement userSessLog;
	
	@FindBy(xpath="//span[text()=' Reports ']")
	private WebElement Reports;
	
	@FindBy(xpath="//span[text()=' Patient Search ']")
	private WebElement PatSearch;
	
	@FindBy(xpath="//a[@class='dropdown-toggle']/span[contains(text(),'Admin')]")
	private WebElement Profilebtn;
	
	@FindBy(xpath="//a[contains(text(),'Log Out')]")
	private WebElement LogoutBtn;
	
	@FindBy(xpath=" //span[text()=' Doctor Specialization ']")
	private WebElement DoctSpec;
	
	@FindBy(xpath=" //span[text()=' Add Doctor']")
	private WebElement AddDoc;
	
	@FindBy(xpath=" //span[text()=' Manage Doctors ']")
	private WebElement ManageDoc;
	
	@FindBy(xpath=" //span[text()=' Manage Users ']")
	private WebElement ManageUsers;
	
	@FindBy(xpath=" //span[text()=' Manage Patients ']")
	private WebElement ManagePat;
	
	@FindBy(xpath=" //span[text()=' Unread Query ']")
	private WebElement UnreadQuery;
	
	@FindBy(xpath=" //span[text()=' Read Query ']")
	private WebElement ReadQuery;
	
	@FindBy(xpath=" //span[text()='B/w dates reports ']")
	private WebElement ReportsDates;
	
	
	public AdminDashBoardPage(WebDriver driver) 
	{
		PageFactory.initElements( driver, this);
	}
	
	
	public WebElement getDoctors() {
		return Doctors;
	}



	public WebElement getUsers() {
		return Users;
	}



	public WebElement getPatients() {
		return Patients;
	}



	public WebElement getAppointmentHistory() {
		return AppointmentHistory;
	}



	public WebElement getContactQueries() {
		return ContactQueries;
	}



	public WebElement getDoctSessLog() {
		return DoctSessLog;
	}



	public WebElement getUserSessLog() {
		return userSessLog;
	}



	public WebElement getReports() {
		return Reports;
	}



	public WebElement getPatSearch() {
		return PatSearch;
	}



	public WebElement getProfilebtn() {
		return Profilebtn;
	}



	public WebElement getLogoutBtn() {
		return LogoutBtn;
	}



	public WebElement getDoctSpec() {
		return DoctSpec;
	}



	public WebElement getAddDoc() {
		return AddDoc;
	}



	public WebElement getManageDoc() {
		return ManageDoc;
	}



	public WebElement getManageUsers() {
		return ManageUsers;
	}



	public WebElement getManagePat() {
		return ManagePat;
	}



	public WebElement getUnreadQuery() {
		return UnreadQuery;
	}



	public WebElement getReadQuery() {
		return ReadQuery;
	}



	public WebElement getReportsDates() {
		return ReportsDates;
	}



	public void adminLogout() 
	{
		Profilebtn.click();
		LogoutBtn.click();
	}
	
	
	
	
	
	
	
	
}
