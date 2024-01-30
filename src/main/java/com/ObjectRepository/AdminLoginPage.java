package com.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminLoginPage {
	//Decelaration
	@FindBy(name="username")
	private WebElement Username;
	
    @FindBy(xpath="//input[@name='password']")
    private WebElement Password;
    
    @FindBy(name="submit")
    private WebElement LoginBtn;
    
    //Initialization
    public AdminLoginPage(WebDriver driver) 
    {
    PageFactory.initElements(driver, this);	
    }
    
    //Utilization
    public void loginAsAdmin(String UN,String PWD) 
    {
    	Username.sendKeys(UN);
    	Password.sendKeys(PWD);
    	LoginBtn.click();
    	
    }
    
    
    
    
    
    
    
    }
