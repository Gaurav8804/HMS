package com.Doctor_module;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.ObjectRepository.AddMedicalHistory;
import com.ObjectRepository.AddPatientsPage;
import com.ObjectRepository.AppiontmentHistoryPage;
import com.ObjectRepository.DoctorDashboardPage;
import com.ObjectRepository.DoctorLoginPage;
import com.ObjectRepository.EditDocDetailsPage;
import com.ObjectRepository.ManagePatientsPage;
import com.genericUtility.BaseClass;
@Listeners(com.genericUtility.ListenersImplementation.class)
public class DoctorEndToEndTest extends BaseClass {
	@Test(retryAnalyzer =com.genericUtility.RetryImplementations.class)
	public void Doctor() throws EncryptedDocumentException, IOException, InterruptedException {

		String URL = pu.getLoginDetails("Durl");
		String UN = pu.getLoginDetails("docusername");
		String PWD = pu.getLoginDetails("docpassword");

		String num3 = ju.randomNum(100) + "";
		int num = ju.randomNum(1000);
		int num1 = ju.randomNum(1000);
		int num2 = ju.randomNum(1000);
		String Dname = efu.readDatafromExcel("create doctor", 0, 1);
		String Cadd = efu.readDatafromExcel("create doctor", 1, 1);
		String Pname = efu.readDatafromExcel("AddPat", 0, 0) + num1;
		String ContNO = efu.readDatafromExcel("AddPat", 1, 0) + num1;
		efu.writeDataIntoExcel("AddPat", 2, 0, "patient" + num2 + "@gmail.com");
		String PMailId = efu.readDatafromExcel("AddPat", 2, 0);
		String Paddress = efu.readDatafromExcel("AddPat", 3, 0);
		String PAge = "" + num2;
		String MedHis = efu.readDatafromExcel("AddPat", 5, 0) + num1;

		String docfee = "" + num;

		driver.get(URL);
		DoctorLoginPage dlp = new DoctorLoginPage(driver);
		dlp.DoctorLogin(UN, PWD);

		DoctorDashboardPage ddp = new DoctorDashboardPage(driver);
		ddp.getUpdateProfile().click();

		// Editing doctors profile
		EditDocDetailsPage eddp = new EditDocDetailsPage(driver);
		eddp.getDname().clear();
		eddp.getDname().sendKeys(Dname);
		eddp.getDocCliAdd().click();
		eddp.getDocCliAdd().sendKeys(Cadd);
		eddp.DocFees().clear();
		eddp.DocFees().sendKeys(docfee);
		eddp.SubmitBtn().click();
		String confmsg = driver.switchTo().alert().getText();
		System.out.println(confmsg);
		driver.switchTo().alert().accept();

		// Checking appointment history
		ddp.getAppointmentHistoryOption().click();
		// ddp.getViewAppointmentHistory().click();
		AppiontmentHistoryPage ahp = new AppiontmentHistoryPage(driver);
		String appinttext = ahp.getAppintHisverify().getText();
		System.out.println(appinttext);
		if (appinttext.equalsIgnoreCase("DOCTOR | APPOINTMENT HISTORY")) {
			System.out.println("Appointment history page is displayed");
		} else {
			System.out.println("Appointment history page is not displayed");
		}

		// adding patients
		ddp.getPatientsoption().click();
		ddp.getAddPatients().click();
		AddPatientsPage app = new AddPatientsPage(driver);
		app.addPatients(Pname, ContNO, PMailId, Paddress, PAge, MedHis, "male");
         Assert.assertEquals(false,true);
		ddp.getPatientsoption().click();
		ddp.getManagePAtientsOption().click();
		driver.findElement(
				By.xpath("//tbody/tr/td[text()='" + Pname + "']/following-sibling::td//i[@class='fa fa-eye']")).click();
		ManagePatientsPage mpp = new ManagePatientsPage(driver);
		mpp.getAddMedicalHistBtn().click();
		AddMedicalHistory amh = new AddMedicalHistory(driver);
		amh.addMedicalHist(num2 + "", num1 + "", num2 + "", num3, "hgvcvJV");
		wu.toHandleAlertPopup(driver);

		wu.doubleClick(driver);

		ddp.getDashboardoption().click();
		ddp.logout();
		Thread.sleep(2000);
		driver.quit();

	}

}
