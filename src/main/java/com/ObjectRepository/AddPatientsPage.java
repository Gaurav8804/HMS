package com.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddPatientsPage {
	@FindBy(name="patname")
	private WebElement Patientname;
	
	@FindBy(name="patcontact")
	private WebElement PatientContNo;

	@FindBy(id="patemail")
	private WebElement PatientEmailId;
	
	@FindBy(name="pataddress")
	private WebElement PatientAddres;
	
	@FindBy(name="patage")
	private WebElement PatientAge;
	
	@FindBy(name="medhis")
	private WebElement PatientMedHist;
	
	@FindBy(xpath=" //label[@for='rg-female']")
	private WebElement FemaleRadioBtn;
	
	@FindBy(xpath=" //label[@for='rg-male']")
	private WebElement MaleRadioBtn;
	
	@FindBy(name="submit")
	private WebElement  AddBtn;
	
	public WebElement getAddBtn() {
		return AddBtn;
	}

	public AddPatientsPage(WebDriver driver) 
	{
		PageFactory.initElements(driver,this);
	}

	public WebElement getPatientname() {
		return Patientname;
	}

	public WebElement getPatientContNo() {
		return PatientContNo;
	}

	public WebElement getPatientEmailId() {
		return PatientEmailId;
	}

	public WebElement getPatientAddres() {
		return PatientAddres;
	}

	public WebElement getPatientAge() {
		return PatientAge;
	}

	public WebElement getPatientMedHist() {
		return PatientMedHist;
	}

	public WebElement getFemaleRadioBtn() {
		return FemaleRadioBtn;
	}

	public WebElement getMaleRadioBtn() {
		return MaleRadioBtn;
	}
	
	public void addPatients(String name,String contNo, String MailId,String PatAdd, String PAtAge, String medhist, String Gender) 
	{
		Patientname.clear();
		Patientname.sendKeys(name);
		PatientContNo.clear();
		PatientContNo.sendKeys(contNo);
		PatientEmailId.sendKeys(MailId);
		if(Gender.equalsIgnoreCase("male")) 
		{
			MaleRadioBtn.click();	
		}else if(Gender.equalsIgnoreCase("female")) 
		{
			FemaleRadioBtn.click();
		}else 
		{
			System.out.println("please specify gender");
		}
		PatientAddres.clear();
		PatientAddres.sendKeys(PatAdd);
		PatientAge.clear();
		PatientAge.sendKeys(PAtAge);
		PatientMedHist.sendKeys(medhist);
		AddBtn.click();
		
	}    
	
	
	
	
	
	
	
}
