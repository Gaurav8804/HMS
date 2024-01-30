package com.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import com.genericUtility.WebDriverUtility;

public class AddDoctorPage extends WebDriverUtility {
	@FindBy(name="Doctorspecialization")
	private WebElement SelectDocSpec;
	
	

	@FindBy(name="docname")
	private WebElement Doctname;
	
	@FindBy(name="clinicaddress")
	private WebElement ClinicAdd;
	
	@FindBy(name="docfees")
	private WebElement Doctfees;
	
	@FindBy(name="doccontact")
	private WebElement DoctContact;
	
	@FindBy(id="docemail")
	private WebElement DocMail;
	
	@FindBy(name="npass")
	private WebElement NewPass;
	
	@FindBy(name="cfpass")
	private WebElement confPass;
	
	@FindBy(id="submit")
	private WebElement SubmitBtn;
	
	@FindBy(xpath=" //h1[text()='Admin | Add Doctor']")
	private WebElement ADpageVerfi;
	
	public AddDoctorPage(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}


	public WebElement getSelectDocSpec() {
		return SelectDocSpec;
	}

	public WebElement getDoctname() {
		return Doctname;
	}

	public WebElement getClinicAdd() {
		return ClinicAdd;
	}

	public WebElement getDoctfees() {
		return Doctfees;
	}

	public WebElement getDoctContact() {
		return DoctContact;
	}

	public WebElement getDocMail() {
		return DocMail;
	}

	public WebElement getNewPass() {
		return NewPass;
	}

	public WebElement getConfPass() {
		return confPass;
	}

	public WebElement getSubmitBtn() {
		return SubmitBtn;
	}

	public WebElement getADpageVerfi() {
		return ADpageVerfi;
	}
	
	public void addDoctor(String Spec,String Dname,String Cadd, String dFee, String DcontNO, String Dmail,String Newpas,String ConfPass) 
	{
		selectByOPtions(Spec, SelectDocSpec);
		Doctname.sendKeys(Dname);
		ClinicAdd.sendKeys(Cadd);
		Doctfees.sendKeys(dFee);
		DoctContact.sendKeys(DcontNO);
		DocMail.sendKeys(Dmail);
		NewPass.sendKeys(Newpas);
		confPass.sendKeys(ConfPass);
		SubmitBtn.click();
		
	}
	
}
