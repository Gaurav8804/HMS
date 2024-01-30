package com.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BookAppointmentPage {
	
	
	@FindBy(name="Doctorspecialization")
	private WebElement docSpec;
	
	@FindBy(id="doctor")
	private WebElement SelectDoc;
	
	@FindBy(name="appdate")
	private WebElement SelectDate;
	
	@FindBy(name="apptime")
	private WebElement time;
	
	@FindBy(name="submit")
	private WebElement SubmitBtn;

	public WebElement getSubmitBtn() {
		return SubmitBtn;
	}

	public BookAppointmentPage(WebDriver driver) 
	{
		PageFactory.initElements(driver,this);
	}

	public WebElement getDocSpec() {
		return docSpec;
	}

	public WebElement getSelectDoc() {
		return SelectDoc;
	}

	public WebElement getSelectDate() {
		return SelectDate;
	}

	public WebElement getTime() {
		return time;
	}
	
	
}
