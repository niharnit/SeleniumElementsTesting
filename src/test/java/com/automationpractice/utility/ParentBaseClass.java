package com.automationpractice.utility;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class ParentBaseClass {
	
	public ConfigurationFileReader configreader;
	public WebDriver driver;
	public ExcelDataProvider logInDataProvider;
	public Helper helper;
	
	public ParentBaseClass() {
		
		configreader = new ConfigurationFileReader();
		logInDataProvider = new ExcelDataProvider("LogInDetails.xlsx");
		helper = new Helper();
		
	}

	//@BeforeSuite
	//public void browsersetup() {
		
	//	driver = BrowserSelection.BrowserSetUp(configreader.BrowserSelect());
		
	//}
	
	
	
	@AfterSuite
	public void tearDown() {
		
		driver.quit();
		
	}
	
	//@AfterMethod
	//public void tearDownMethod(ITestResult result) {
	//	if (result.getStatus()==ITestResult.FAILURE) {
	//		helper.captureScreenshots(driver); 
	//		}
	//	}
	
}
