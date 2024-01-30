package com.Doctor_module;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
  
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.genericUtility.ExcelFileUtility;
import com.genericUtility.JavaUtility;
import com.genericUtility.PropertiesUtility;
import com.genericUtility.WebDriverUtility;

import io.github.bonigarcia.wdm.WebDriverManager;
@Listeners(com.genericUtility.ListenersImplementation.class)
public class System_TestingTest{

//	public static void main(String[] args) throws IOException {
	@Test(retryAnalyzer =com.genericUtility.RetryImplementations.class)
	public void Systest() throws IOException{
		JavaUtility ju=new JavaUtility();
		ExcelFileUtility euf=new ExcelFileUtility();
		WebDriverUtility wu=new WebDriverUtility();
		PropertiesUtility pu=new PropertiesUtility();
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\LoginCredentials.properties");
		Properties prop = new Properties();
		prop.load(fis);
		String URL = prop.getProperty("url1");
		String PATUSERNAME = prop.getProperty("patusername");
		String PATPASSWORD = prop.getProperty("patpassword");
		
		FileInputStream fis1 = new FileInputStream(".\\src\\test\\resources\\HMS.xlsx");
		Workbook wb = WorkbookFactory.create(fis1);
		Sheet page = wb.getSheet("EDIT PROFILE");

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(URL);
		driver.findElement(By.xpath("//h3[text()='Patients']/parent::div//a")).click();
		driver.findElement(By.name("username")).sendKeys(PATUSERNAME);
		driver.findElement(By.name("password")).sendKeys(PATPASSWORD);
		driver.findElement(By.name("submit")).click();
		String Dtext = driver.findElement(By.xpath("//h1[text()='User | Dashboard']")).getText();
		 
		if(Dtext.equals("USER | DASHBOARD")) 
		{
			System.out.println("Patients Dashboard is displayed");
		}
		else 
		{
			System.out.println("Patients Dashboard is not displayed");
		}
		driver.findElement(By.xpath("//p[@class='links cl-effect-1']/a[contains(text(),'Update Profile')]")).click();
		String EPText = driver.findElement(By.xpath("// h1[text()='User | Edit Profile']")).getText();
		if(EPText.equals("USER | EDIT PROFILE")) 
		{
			System.out.println("Editprofile page is displayed");
		}
		else 
		{
			System.out.println("Editprofile page is not displayed");
		}
		String Address = page.getRow(0).getCell(0).getStringCellValue();
		int num = ju.randomNum(100);
		driver.findElement(By.xpath(" //div[@class='form-group']/child::textarea[@name='address']")).sendKeys(Address+num);
		
		String city = page.getRow(0).getCell(1).getStringCellValue();
		driver.findElement(By.xpath(" //div[@class='form-group']/child::input[@name='city']")).sendKeys(city+num);
		driver.findElement(By.name("submit")).click();
		String ctext = driver.findElement(By.xpath(" //h5[contains(text(),'You')]")).getText();
		System.out.println(ctext);
		driver.findElement(By.xpath(" //span[@class='username']")).click();
		driver.findElement(By.partialLinkText("Log Out")).click();
		driver.findElement(By.xpath(" //h3[text()='Doctors Login']/parent::div//a[text()='Click Here']")).click();
		String UNNAME = euf.readDatafromExcel("create doctor",7,0);
		String  PWDD= euf.readDatafromExcel("create doctor",7,1);
		driver.findElement(By.name("username")).sendKeys(UNNAME);
		driver.findElement(By.name("password")).sendKeys(PWDD);
		driver.findElement(By.name("submit")).click();
		String DDash = driver.findElement(By.xpath(" //h1[text()='Doctor | Dashboard']")).getText();
		System.out.println(DDash);
		if(DDash.contains("DOCTOR | DASHBOARD"))
		{
			System.out.println("Doctor dash board page is displayed");
		} else 
		{
			System.out.println("Doctor dash board page is not displayed");
		}
		driver.findElement(By.xpath("//a[contains(text(),'Update Profile')]")).click();
		String fees = euf.readDatafromExcel("create doctor",8,1);
		driver.findElement(By.name("docfees")).sendKeys(fees);
		driver.findElement(By.name("submit")).click();
		String alrttext = driver.switchTo().alert().getText();
		System.out.println(alrttext);
		wu.toHandleAlertPopup(driver);
		driver.findElement(By.xpath(" //span[@class='username']")).click();
		driver.findElement(By.xpath("//a[contains(text(),'Log Out')]")).click();
		System.out.println("Main  page is displayed");
	}

}
