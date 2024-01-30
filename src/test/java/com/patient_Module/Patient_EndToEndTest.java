package com.patient_Module;

import java.io.IOException;

import org.openqa.selenium.By;

import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.ObjectRepository.BookAppointmentPage;
import com.ObjectRepository.PatEditProfilePage;
import com.ObjectRepository.PatientLoginPage;
import com.ObjectRepository.PatientsDashBoardPage;
import com.genericUtility.BaseClass;
@Listeners(com.genericUtility.ListenersImplementation.class)
public class Patient_EndToEndTest extends BaseClass {
	@Test(retryAnalyzer =com.genericUtility.RetryImplementations.class)
	public void patientModule() throws IOException, InterruptedException {

		int num = ju.randomNum(100);

		String Pname = efu.readDatafromExcel("PatientProfile", 0, 0) + num;
		String address = efu.readDatafromExcel("PatientProfile", 1, 0) + num;
		String cty = efu.readDatafromExcel("PatientProfile", 2, 0) + num;
		String URl = pu.getLoginDetails("Purl");
		String UN = pu.getLoginDetails("patusername");
		String PWd = pu.getLoginDetails("patpassword");
		String Dspec = efu.readDatafromExcel("BookApp", 0, 0);
		String Dname = efu.readDatafromExcel("BookApp", 0, 1);
        
		// Login to the patient module
		driver.get(URl);
		PatientLoginPage plp = new PatientLoginPage(driver);
		plp.PatLogin(UN, PWd);

		PatientsDashBoardPage pdbp = new PatientsDashBoardPage(driver);
		pdbp.getUpdateProfile().click();
		 

		PatEditProfilePage pepp = new PatEditProfilePage(driver);
		pepp.UpdatePatProfile(Pname, address, cty, "female");
		String confMsg = driver.findElement(By.xpath("//h5[contains(text(),'Your Profile updated Successfully ')]"))
				.getText();
		Reporter.log(confMsg, true);
//		pdbp.getAppointmentHistory().click();
		
        pdbp.getBookAppointment().click();
		BookAppointmentPage bp = new BookAppointmentPage(driver);
		wu.selectByOPtions(bp.getDocSpec(),Dspec);
		wu.selectByOPtions(Dname,bp.getSelectDoc());
		bp.getSelectDate().sendKeys("2023-12-29");
		Thread.sleep(5000);
		bp.getTime().sendKeys("4:45 PM");
		bp.getSubmitBtn().click();
		Thread.sleep(3000);
//		String text = wu.toHandleAlertPopupwithtext(driver);
//		Reporter.log(text, true);
//		wu.toHandleAlertPopup(driver);
		
		pdbp.getAppointmentHistory().click();
		wu.elementToBeVisible(driver, 10,pdbp.getMedHistory());
		pdbp.getMedHistory().click();
		 plp.PatLogout();
		
		

	}

}
