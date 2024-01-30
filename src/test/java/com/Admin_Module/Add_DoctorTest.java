package com.Admin_Module;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.Random;

import org.apache.commons.collections4.map.HashedMap;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
 
import org.openqa.selenium.WebElement;
 
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.genericUtility.BaseClass;

 
@Listeners(com.genericUtility.ListenersImplementation.class)
public class Add_DoctorTest  extends BaseClass{
    @Test(retryAnalyzer =com.genericUtility.RetryImplementations.class)
	public void add_DoctorTest()  throws IOException, InterruptedException {
		FileInputStream fio = new FileInputStream(".\\src\\test\\resources\\LoginCredentials.properties");
		Properties prop = new Properties();
		prop.load(fio);
		String URL = prop.getProperty("url");
		String UN = prop.getProperty("username");
		String PWD = prop.getProperty("password");
		
		Random r=new Random();
		int num = r.nextInt();
		 
		 FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\HMS.xlsx");
		 Workbook wb1=WorkbookFactory.create(fis);
		 Sheet sh = wb1.getSheet("create doctor");
	     sh.getRow(4).getCell(1).setCellValue("doctor"+num+"@gmail.com");
	     FileOutputStream fos=new FileOutputStream(".\\src\\test\\resources\\HMS.xlsx");
         wb1.write(fos);
		
		FileInputStream fios=new FileInputStream(".\\src\\test\\resources\\HMS.xlsx");
		Workbook wb = WorkbookFactory.create(fios);
		int ROW = wb.getSheet("create doctor").getLastRowNum();
        
	
//		WebDriverManager.chromedriver().setup();
//		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(URL);
		driver.findElement(By.name("username")).sendKeys(UN);
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(PWD);
		driver.findElement(By.name("submit")).click();
		driver.findElement(By.xpath(" //span[text()=' Doctors ']")).click();
		driver.findElement(By.xpath(" //span[text()=' Add Doctor']")).click();
		String ADDDOCTOR = driver.findElement(By.xpath(" //h1[text()='Admin | Add Doctor']")).getText();
		if(ADDDOCTOR.contains("ADMIN | ADD DOCTOR")) 
		{
			System.out.println("Add doctor page is displayed ");
		}
		else 
		{
			System.out.println("Add doctor page is not displayed ");
		}
		WebElement spec_drop = driver.findElement(By.name("Doctorspecialization"));
		Select dropdown=new Select(spec_drop);
		dropdown.selectByValue("HOMEOPATHY");
		//creating a empty hashmap
		HashedMap<String, String> map = new HashedMap<String, String>();
		//fetching the value using map
		
		for(int i=0;i<=ROW;i++) 
		{
			String KEY = wb.getSheet("create doctor").getRow(i).getCell(0).getStringCellValue();
			String VALUE = wb.getSheet("create doctor").getRow(i).getCell(1).getStringCellValue();
			//storing the data into map in the form of key(KEY),value(VALUE) pair
			map.put(KEY, VALUE);
		}
		//using as for each loop, map.entryset() we use to create the set of key values
		
		for(Entry<String, String> data:map.entrySet()) 
		{
			 driver.findElement(By.name(data.getKey())).sendKeys(data.getValue());
             //entering key           entering value
		 
		}
		Thread.sleep(2000);
		driver.findElement(By.id("submit")).click();
		Thread.sleep(4000);
		String CONFIRMATION = driver.switchTo().alert().getText();
		driver.switchTo().alert().accept();
		System.out.println(CONFIRMATION);
		driver.quit();
		  

	}

}
