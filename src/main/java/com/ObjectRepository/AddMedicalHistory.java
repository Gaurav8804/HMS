package com.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddMedicalHistory {
	@FindBy(name="bp")
	private WebElement Bloodpressure;
	
	@FindBy(name="bs")
	private WebElement Bloodsugr;
	
	@FindBy(name="weight")
	private WebElement Weight;
	
	@FindBy(name="temp")
	private WebElement Temp;
	
	@FindBy(xpath=" //button[@name='submit']")
	private WebElement Submit;
	
	@FindBy(name="pres")
	private WebElement prescription;
	
	
	public AddMedicalHistory(WebDriver driver) 
	{
		PageFactory.initElements(driver,this);
	}
	 public WebElement getbloodpressure() 
	 {
		 return Bloodpressure;
	 }
	 
	 
	 public void addMedicalHist(String bp,String Bloodsugar,String weight, String temp,String Pres) 
	 {
		 Bloodpressure.clear();
		 Bloodpressure.sendKeys(bp);
		 Bloodsugr.clear();
		 Bloodsugr.sendKeys(Bloodsugar);
		 Weight.clear();
		 Weight.sendKeys(weight);
		 Temp.clear();
		 Temp.sendKeys(temp);
		 prescription.click();
		 prescription.sendKeys(Pres);
		 Submit.click();
		 
		 
	 }

	 
}
