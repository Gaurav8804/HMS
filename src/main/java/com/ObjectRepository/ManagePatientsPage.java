package com.ObjectRepository;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManagePatientsPage {
	@FindBy(xpath=" //h1[text()='Admin | View Patients']")
	private WebElement ViewpatVerify;
	
	@FindBy(xpath=" ////h1[text()='Doctor | Manage Patients']")
	private WebElement ManagepatVerify;
	
	@FindBy(xpath=" //h1[text()='Doctor | Manage Patients']")
	private WebElement ManagePatVerify;
	
	
	public WebElement getViewpatVerify() {
		return ViewpatVerify;
	}

	public WebElement getManagePatVerify() {
		return ManagePatVerify;
	}

	public WebElement getManagepatVerify() {
		return ManagepatVerify;
	}

	@FindBy(xpath=" //td[@class='hidden-xs']")
	private List<WebElement> ViewPatTable;
	
	@FindBy(xpath=" //button[text()='Add Medical History']")
	private WebElement AddMedicalHistBtn;
	
	public WebElement getAddMedicalHistBtn() {
		return AddMedicalHistBtn;
	}

	public ManagePatientsPage(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}
	
	public WebElement getviewpatVerify() 
	{
	    return	ViewpatVerify ;	
	}
	
	public List<WebElement> getViewPatTable()
	{
		return ViewPatTable;
	}
	
	
	
	
	
	
}
