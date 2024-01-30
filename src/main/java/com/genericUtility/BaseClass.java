package com.genericUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.genericUtility.WebDriverUtility;
import com.genericUtility.JavaUtility;
import com.beust.jcommander.Parameter;
import com.genericUtility.ExcelFileUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	 
	public PropertiesUtility pu=new PropertiesUtility(); 
	public WebDriverUtility wu=new WebDriverUtility();
	public JavaUtility ju=new JavaUtility();
	public ExcelFileUtility efu=new ExcelFileUtility();
	public WebDriver driver;
    public static WebDriver sdriver;
    
	@BeforeSuite(alwaysRun = true)
	public void config_BS() 
	{
		System.out.println("----Data base connection established----");
	}
	
	//@Parameters("BROWSER")
	@BeforeClass(alwaysRun = true)
    public void Config_BC() //String BROWSER
	{
		WebDriverManager.chromedriver().setup();
		  driver=new ChromeDriver();
//		if(BROWSER.equalsIgnoreCase("chrome"))
//		{
//	  WebDriverManager.chromedriver().setup();
//	  driver=new ChromeDriver();
//	    } else if(BROWSER.equalsIgnoreCase("edge")) 
//		{
//	    WebDriverManager.edgedriver().setup();
//	    driver=new EdgeDriver();
//		}
	  wu.maximize(driver);
	  wu.implicitWait(driver, 10);
	  sdriver=driver;
	}
	@AfterClass(alwaysRun = true)
	public void Config_AC() 
	{
		driver.quit();
	}
	
	@AfterSuite(alwaysRun = true)
	public void Config_AS() 
	{
		System.out.println("----Database connection closed----");
	}
	

}
