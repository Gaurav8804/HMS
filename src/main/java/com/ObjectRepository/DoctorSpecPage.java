package com.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DoctorSpecPage {
	@FindBy(xpath=" //h1[text()='Admin | Add Doctor Specialization']")
	private WebElement ADSVerify;
	
	@FindBy(name="doctorspecilization")
	private WebElement DoctSpecDRopDown;
	
	@FindBy(name="submit")
	private WebElement DocSpecSubmitbtn;

	public DoctorSpecPage(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}
	
	
	
	
	public WebElement getADSVerify() {
		return ADSVerify;
	}

	public WebElement getDoctSpecDRopDown() {
		return DoctSpecDRopDown;
	}

	public WebElement getDocSpecSubmitbtn() {
		return DocSpecSubmitbtn;
	}
	
	
	

}
