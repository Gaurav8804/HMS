package com.Admin_Module;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.ObjectRepository.AddDoctorPage;
import com.ObjectRepository.AdminDashBoardPage;
import com.ObjectRepository.AdminLoginPage;
import com.ObjectRepository.DoctorSpecPage;
@Listeners(com.genericUtility.ListenersImplementation.class)
public class DEpendsOn extends CreatreSpecializationTest{
	@Test(dependsOnMethods = "creatreSpecializationTest")
	public void creating_SpecAND_Adding_DoctorTest()
			throws EncryptedDocumentException, IOException, InterruptedException {

		// this class extends to CreatreSpecializationTest and creating_SpecAND_Adding_DoctorTestmethod
//		depends on creatreSpecializationTest. creatreSpecializationTest extends to base class.
		
		
		
		int num = ju.randomNum(1000);
		String Dname = efu.readDatafromExcel("create doctor", 0, 1);
		String Cadd = efu.readDatafromExcel("create doctor", 1, 1);
		String docfee = efu.readDatafromExcel("create doctor", 2, 1);
		String Dcontact = efu.readDatafromExcel("create doctor", 3, 1);
		efu.writeDataIntoExcel("create doctor", 4, 1, "doctor" + num + "@gmail.com");
		String DEmail = efu.readDatafromExcel("create doctor", 4, 1);
		String Npass = efu.readDatafromExcel("create doctor", 5, 1);
		String cfpass = efu.readDatafromExcel("create doctor", 6, 1);

		String URL = pu.getLoginDetails("url");
		String UN = pu.getLoginDetails("username");
		String PWD = pu.getLoginDetails("password");

		String Spec = efu.readDatafromExcel("specialization", 0, 1);
		String value = Spec + num;
		efu.writeDataIntoExcel("BookApp", 0, 0, value);
		efu.writeDataIntoExcel("BookApp", 0, 1, Dname);
		

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
			System.out.println("Specialization Created");
		} else {
			System.out.println("Not created");
		}

		// Adding the doctor
		adbp.getDoctors().click();
		adbp.getAddDoc().click();
		AddDoctorPage adp = new AddDoctorPage(driver);
		adp.addDoctor(value, Dname, Cadd, docfee, Dcontact, DEmail, Npass, cfpass);
		System.out.println(wu.toHandleAlertPopupwithtext(driver));
		wu.toHandleAlertPopup(driver);

		adbp.adminLogout();
	}
}
