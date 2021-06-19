package com.automationpractice.testcases;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.automationpractice.pages.SeleniumAllTypeElementsPage;
import com.automationpractice.utility.BrowserSelection;
import com.automationpractice.utility.Helper;
import com.automationpractice.utility.ParentBaseClass;

public class SeleniumAllTypeElementsTestCase extends ParentBaseClass{
	
	SeleniumAllTypeElementsPage seleniumAllTypeElementsPage; 
	Helper helper;
	
	@BeforeMethod
	public void OpenElementsTestingUrl() {
		driver = BrowserSelection.BrowserSetUp(configreader.BrowserSelect());
		driver.get(configreader.ElementsTestingSite());
		seleniumAllTypeElementsPage = new SeleniumAllTypeElementsPage(driver);
	}
	
	@AfterMethod
	public void closeElementsTestingUrl(ITestResult result) {
		if(result.getStatus()==ITestResult.FAILURE) {
			helper.captureScreenshots(driver); 
		}
		driver.close();
		
	}
	
	@Test(priority=0, enabled=true)
	public void TextMessageTesting() {
	
		seleniumAllTypeElementsPage.CheckTextMessage();
		System.out.println("The text message pulled is the correct message as present in the website");
		//System.out.println("Text Message Comparison became - " + rightTextMessage);
	}
	
	@Test(priority=1, enabled=true)
	public void LinkTesting() {
	
		seleniumAllTypeElementsPage.ClickOnTheLink();
		System.out.println("Link is clicked successfully");
	}
	
	@Test(priority=2, enabled=true)
	public void TextBoxTesting() throws InterruptedException {
	
		seleniumAllTypeElementsPage.CheckTextBoxEntry("This is Nihar");
		System.out.println("The text box data entered successfully in the website");
	}
	
	@Test(priority=3, enabled=true)
	public void Buttontesting() {
		
		seleniumAllTypeElementsPage.CheckSubmitButton();
		System.out.println("Submit button is clicked successfully");
		Helper.delayInSeconds(2);
	}
	
	@Test(priority=4, enabled=true)
	public void RadioButtonTesting() {
		
		seleniumAllTypeElementsPage.CheckRadioButton("female");
		System.out.println("Radio buttons are selected successfully");
	}

	@Test(priority=5, enabled=true)
	public void CheckBoxTesting() {
		
		seleniumAllTypeElementsPage.CheckCheckBox("Performance Testing");
		System.out.println("Check Box is selected successfully");
	}
	
	@Test(priority=6, enabled=true)
	public void CheckDropBoxTesting() {
		
		seleniumAllTypeElementsPage.CheckDropDown("Database Testing");
		System.out.println("Drop Box is selected successfully");
	}
	
	@Test(priority=7, enabled=true)
	public void CheckAlertTestingDoubleClick() {
		seleniumAllTypeElementsPage.DoubleClickOnAlertBoxOpening();
		System.out.println("Double click to open and accept the alert window successfully");
	}
	
	@Test(priority=8, enabled=true)
	public void CheckAlertTestingSingleClick() {
		seleniumAllTypeElementsPage.clickToGenerateAlertBox();
		System.out.println("Single click to open and dismiss the alert window successfully");
	}
	
	@Test(priority=9, enabled=true)
	public void ChecksConfirmationAlertTeting() {
		seleniumAllTypeElementsPage.clickToGenerateConfirmationBox("CANCEL");
		System.out.println("confirmation alert box operation is successful");
	}
	
	@Test(priority=10, enabled=false)
	public void CheckDragAndDrop() {
		seleniumAllTypeElementsPage.CheckDragAndDropTesting();
		System.out.println("Drag and Drop functionality tested successfully");
	}
	
}
