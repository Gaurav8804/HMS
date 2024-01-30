package com.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageDoctorPage {

  @FindBy(xpath="//h1[text()='Admin | Manage Doctors']")
  private WebElement ManageDocVerify;
  
  public ManageDoctorPage(WebDriver driver) 
  {
	  PageFactory.initElements(driver, this);
  }

 public WebElement getManageDocVerify() {
	return ManageDocVerify;
}
	
	
	
	
}
