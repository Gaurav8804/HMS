package com.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.genericUtility.WebDriverUtility;

public class PatEditProfilePage extends WebDriverUtility {

	@FindBy(name="fname")
	private WebElement Name;
	
	@FindBy(name="address")
	private WebElement Address;
	
	@FindBy(name="city")
	private WebElement City;
	
	@FindBy(name="gender")
	private WebElement Gender;
	
	@FindBy(name="submit")
	private WebElement UpdateBtn;
	
	
	public PatEditProfilePage(WebDriver driver) 
	{
		PageFactory.initElements(driver,this);
	}
	
	public void UpdatePatProfile(String name,String address, String city, String gender) 
	{
		Name.clear();
		Name.sendKeys(name);
		Address.clear();
		Address.sendKeys(address);
		City.clear();
		City.sendKeys(city);
		selectByOPtions(Gender, gender);
		UpdateBtn.click();
	}
	
	
	
}
