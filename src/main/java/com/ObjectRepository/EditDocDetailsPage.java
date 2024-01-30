package com.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EditDocDetailsPage {

	@FindBy(name = "Doctorspecialization")
	private WebElement DocSpec;

	@FindBy(name = "docname")
	private WebElement Dname;

	@FindBy(name = "clinicaddress")
	private WebElement DocCliAdd;

	@FindBy(name = "docfees")
	private WebElement DocFees;

	@FindBy(name = "docfees")
	private WebElement DocFee;

	@FindBy(name = "submit")
	private WebElement SubmitBtn;
	
	@FindBy(xpath=" //h1[text()='Admin | Edit Doctor Details']")
	private WebElement editdocverify;

	public EditDocDetailsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getdocSpec() {
		return DocSpec;
	}

	public WebElement getDname() {
		return Dname;
	}

	public WebElement getDocCliAdd() {
		return DocCliAdd;
	}
	
	public WebElement geteditdocverify() 
	{
		return editdocverify;
	}
	
	
	

	public WebElement DocFees() {
		return DocFees;
	}

	public WebElement SubmitBtn() {
		return SubmitBtn;
	}

}