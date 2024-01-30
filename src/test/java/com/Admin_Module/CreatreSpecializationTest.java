package com.Admin_Module;
import java.io.IOException;
import org.openqa.selenium.By;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.ObjectRepository.AdminDashBoardPage;
import com.ObjectRepository.AdminLoginPage;
import com.ObjectRepository.DoctorSpecPage;
import com.genericUtility.BaseClass;

@Listeners(com.genericUtility.ListenersImplementation.class)
public class CreatreSpecializationTest extends BaseClass {
	
     @Test(groups="Smoke",retryAnalyzer =com.genericUtility.RetryImplementations.class)
	public void creatreSpecializationTest() throws IOException {
		
		 
        int num = ju.randomNum(1000);
		efu.writeDataIntoExcel("create doctor", 4, 1, "doctor" + num + "@gmail.com");
		 

		String URL = pu.getLoginDetails("url");
		String UN = pu.getLoginDetails("username");
		String PWD = pu.getLoginDetails("password");

		String Spec = efu.readDatafromExcel("specialization", 0, 1);
		String value = Spec + num;

	    driver.get(URL);

		// login as a admin
		AdminLoginPage alp = new AdminLoginPage(driver);
		alp.loginAsAdmin(UN, PWD);

		// clicking on the doctor option
		AdminDashBoardPage adbp = new AdminDashBoardPage(driver);
		adbp.getDoctors().click();

		// creating doctor specialization
		adbp.getDoctSpec().click();
		DoctorSpecPage dsp = new DoctorSpecPage(driver);
		dsp.getDoctSpecDRopDown().sendKeys(value);
		dsp.getDocSpecSubmitbtn().click();
		String Confirmation = driver.findElement(By.xpath(
				"//p[text()='Doctor Specialization added successfully !!								']						"))
				.getText();
		if (Confirmation.contains("Doctor Specialization added ")) {
			System.out.println("Specialization Created"+"---->"+value);
		} else {
			System.out.println("Not created");
		}
		
		adbp.adminLogout();

	}

}
