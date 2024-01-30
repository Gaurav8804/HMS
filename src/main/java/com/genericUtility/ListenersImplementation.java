package com.genericUtility;

import java.io.IOException;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListenersImplementation implements ITestListener{

	ExtentReports report;
	ExtentTest test;
	@Override
	public void onTestStart(ITestResult result) {
	//testscript execution starts from here 
		String MethodName = result.getMethod().getMethodName();
		test=report.createTest(MethodName);
		Reporter.log(MethodName, true);
		
		 
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		String MethodName = result.getMethod().getMethodName();
		test.log(Status.PASS, MethodName+"Passed");
		Reporter.log(MethodName,true);
		
		 
	}

	@Override
	public void onTestFailure(ITestResult result) {
	WebDriverUtility wu=new WebDriverUtility(); 
	JavaUtility ju=new JavaUtility();
	try {
		String MethodName = result.getMethod().getMethodName();
		String SD = ju.getSystemDate();
		String path = wu.getScreenShot(BaseClass.sdriver,result.getMethod().getMethodName()+SD);
		test.addScreenCaptureFromPath(path);
		test.log(Status.FAIL,MethodName);
		test.log(Status.FAIL, result.getThrowable());
		Reporter.log(MethodName);
	} catch (IOException e) {
		 
		e.printStackTrace();
	}
	
	
	
	
	
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		String MethodName = result.getMethod().getMethodName();
		test.log(Status.SKIP,MethodName);
		test.log(Status.SKIP,result.getThrowable());
		}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		 
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		 
	}

	@Override
	public void onStart(ITestContext context) {
		Date d = new Date();
		String extDate = d.toString().replace(":", "-");
	  ExtentSparkReporter esp=new ExtentSparkReporter("./ExtentReport/report"+extDate);
		esp.config().setDocumentTitle("Reports");
		esp.config().setTheme(Theme.DARK);
		report=new ExtentReports();
      report.attachReporter(esp);
      report.setSystemInfo("Base Browser", "Chrome");
      report.setSystemInfo("BasePlatform", "Window");
	  report.setSystemInfo("BaseEnvironment", "Testing");	
	  report.setSystemInfo("URl", "http://rmgtestingserver/domain/Hospital_Management_System/hms/admin/");
	}

	@Override
	public void onFinish(ITestContext context) {
	 report.flush();
	}

	
	
	
	
	
	
	
}
