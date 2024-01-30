package com.Admin_Module;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
 
import org.openqa.selenium.WebElement;
 
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.ObjectRepository.AddDoctorPage;
import com.ObjectRepository.AdminDashBoardPage;
import com.ObjectRepository.AdminLoginPage;
import com.ObjectRepository.AppointmentHistoryPage;
import com.ObjectRepository.DoctorSessionLogPage;
import com.ObjectRepository.DoctorSpecPage;
import com.ObjectRepository.EditDocDetailsPage;
import com.ObjectRepository.ManageDoctorPage;
import com.ObjectRepository.ManagePatientsPage;
import com.ObjectRepository.ManageUsersPage;
import com.ObjectRepository.QuerydetailsPage;
import com.ObjectRepository.ReadQueriesPage;
import com.ObjectRepository.ReportsPage;
import com.ObjectRepository.UserSessionLogPage;
import com.ObjectRepository.unreadQueriesPage;
import com.genericUtility.BaseClass;
 

 
@Listeners(com.genericUtility.ListenersImplementation.class) 
public class ADMIN_END_TO_ENDTest extends BaseClass {
	
	 @Test(retryAnalyzer =com.genericUtility.RetryImplementations.class)  
	public void aDMIN_END_TO_ENDTest() throws EncryptedDocumentException, IOException, InterruptedException {
//       public static void main(String[] args)  throws EncryptedDocumentException, IOException, InterruptedException {
		
	 
//		PropertiesUtility pu = new PropertiesUtility();
//		WebDriverUtility wu = new WebDriverUtility();
//		JavaUtility ju = new JavaUtility();
//		ExcelFileUtility efu = new ExcelFileUtility(++);

		int num = ju.randomNum(10000);
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
		System.out.println(value);
//		WebDriverManager.chromedriver().setup();
//		WebDriver driver =new ChromeDriver();
//		driver = new ChromeDriver();
//		wu.maximize(driver);
//		wu.implicitWait(driver, 10);
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
		Thread.sleep(2000);		
		String Confirmation = driver.findElement(By.xpath("//p[text()='Doctor Specialization added successfully !!								']						")).getText();
				 
				
		if (Confirmation.contains("Doctor Specialization added ")) {
//			System.out.println("Specialization Created");
			Reporter.log("Specialization Created", true);// true is used to print in console along with html report
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

		// Moving to manage doctor page
		ManageDoctorPage mdp = new ManageDoctorPage(driver);
		String MDV = mdp.getManageDocVerify().getText();
//		System.out.println(MDV);
		if (MDV.equalsIgnoreCase("ADMIN | MANAGE DOCTORS")) {
			System.out.println("Manage doctor page is displayed");
		} else {
			System.out.println("Manage doctor page not is displayed");
		}
		 driver.findElement(By.xpath(" //tbody/tr/td[text()='" + value +"']/following-sibling::td/descendant::i[@class='fa fa-pencil']")).click();
		 
		 
		 
		// Edit doctor page
		EditDocDetailsPage eddp = new EditDocDetailsPage(driver);
		String edv = eddp.geteditdocverify().getText();
		if (edv.contentEquals("ADMIN | EDIT DOCTOR DETAILS")) {
			System.out.println("Edit doctor page is displayed");
		} else {
			System.out.println("Edit doctor page is not displayed");
		}
		WebElement dspec = eddp.getdocSpec();
		wu.selectByOPtions(value, dspec);
		String cadd1 = efu.readDatafromExcel("EDIT PROFILE", 0, 0);
		eddp.getDocCliAdd().sendKeys(cadd1);
		eddp.DocFees().sendKeys(num + "");
		eddp.SubmitBtn().click();
		String INfO = driver.findElement(By.xpath("//h5[contains(text(),'Doctor Details updated Successfully')]"))
				.getText();
		if (INfO.equalsIgnoreCase("Doctor Details updated Successfully")) {
			System.out.println("Doctor Details updated Successfully");
		} else {
			System.out.println("Not updated");
		}
		adbp.getUsers().click();
		adbp.getManageUsers().click();

		// clicking to manage users and verify
		ManageUsersPage mu = new ManageUsersPage(driver);
		String musers = mu.getManageUserverif().getText();
		if (musers.equalsIgnoreCase("Admin | Manage Users")) {
			System.out.println("Manage user page is displayed");
		} else {
			System.out.println("Manage user page is not  displayed");
		}

		adbp.getPatients().click();
		adbp.getManagePat().click();
		ManagePatientsPage mp = new ManagePatientsPage(driver);
		String MPtext = mp.getviewpatVerify().getText();
		if (MPtext.equalsIgnoreCase("ADMIN | VIEW PATIENTS")) {
			System.out.println("View Patients page is displayed");
		} else {
			System.out.println("View Patients page is  not displayed");
		}
		driver.findElement(By.xpath("//tbody/tr/td[text()='4558968789']/following-sibling::td/a")).click();

		adbp.getAppointmentHistory().click();
		AppointmentHistoryPage ah = new AppointmentHistoryPage(driver);
		String Ahtext = ah.getAppHistory().getText();
		if (Ahtext.contains("PATIENTS | APPOINTMENT HISTORY")) {
			System.out.println("Admin can able to see the appointment history");
		} else {
			System.out.println("Admin can't able to see the appointment history");
		}

		// clicking cotact queries
		adbp.getContactQueries().click();
		unreadQueriesPage uqp = new unreadQueriesPage(driver);
		// clicking unreadqueries
		uqp.getUnreadQueries().click();
		String MUQtext = uqp.getUnreadQueriestext().getText();
		if (MUQtext.contains("ADMIN | MANAGE UNREAD QUERIES")) {
			System.out.println("Manage unread Queries page is dsplayed");
		} else {
			System.out.println("Manage unread Queries page is not dsplayed");
		}

		try {
			WebElement query = uqp.getUnreadQuerieslist();
			wu.ExplicitWait(driver, 10).until(ExpectedConditions.elementToBeClickable(query));
			query.click();
			System.out.println("Query Details is displayed");
		} catch (Exception e) {
			System.out.println("NO query is present");
		}
		// clicking cotact queries
		adbp.getContactQueries().click();

		// clicking read queries
		ReadQueriesPage rq = new ReadQueriesPage(driver);
		adbp.getReadQuery().click();
		driver.findElement(By.xpath(" //tbody/tr/td[text()='1.']/following-sibling::td//i[@class='fa fa-file']"))
				.click();
		// Query details page
		QuerydetailsPage qdp = new QuerydetailsPage(driver);
		String AQD = qdp.getQuerydetails().getText();
		if (AQD.contains("ADMIN | QUERY DETAILS")) {
			System.out.println("Query details is displayed and admin can read the queries");
		} else {
			System.out.println("Read Queries page is not displayed");
		}

		// clicking doctor session log
		DoctorSessionLogPage dslp = new DoctorSessionLogPage(driver);
		adbp.getDoctSessLog().click();
		String ADSL = dslp.getDSLverify().getText();
		if (ADSL.contains("ADMIN | DOCTOR SESSION LOGS")) {
			System.out.println("Doctor session log page is displayed");
		} else {
			System.out.println("Doctor session log is not displayed");
		}

		// clicking user session log
		adbp.getUserSessLog().click();
		UserSessionLogPage uslp = new UserSessionLogPage(driver);
		String AUSL = uslp.getUSLverify().getText();
		if (AUSL.contains("ADMIN | USER SESSION LOGS")) {
			System.out.println("User Session list page is displayed");
		} else {
			System.out.println("User Session list page is not displayed");
		}
		// clicking to reports
		adbp.getReports().click();
		adbp.getReportsDates().click();
		ReportsPage rs = new ReportsPage(driver);
		rs.getFromdate().sendKeys("01/18/2024");
		rs.getTodate().sendKeys("01/20/2024");
		rs.getSubmit().click();
		adbp.adminLogout();

	}

}
