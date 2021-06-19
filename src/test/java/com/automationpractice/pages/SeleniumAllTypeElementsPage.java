package com.automationpractice.pages;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.automationpractice.utility.Helper;

public class SeleniumAllTypeElementsPage {
	
	WebDriver driver;

	public SeleniumAllTypeElementsPage(WebDriver driver) {
		this.driver = driver;
		
	}
	
	By textFieldCheck = By.xpath("//b[text()='This is sample text.']");
	By linkFieldCheck = By.linkText("This is a link");
	By textBoxCheck = By.id("fname");
	By buttonCheck = By.id("idOfButton");
	By radioButtonMaleCheck = By.xpath("//input[@value='male']");
	By radioButtonFemaleCheck = By.xpath("//input[@value='female']");
	By checkBoxAutomationTestingCheck = By.xpath("//input[@type='checkbox'][@class='Automation']");
	By checkBoxPerformanceTestingCheck = By.xpath("//input[@type='checkbox'][@class='Performance']");
	By dropDownCheck = By.id("testingDropdown");
	By generatingAlertBoxDoubleClickCheck = By.id("dblClkBtn");
	By generatingAlertBoxSingleClickCheck = By.xpath("//button[contains(text(),'Generate Alert Box')]");
	By generateConfirmBoxCheck = By.xpath("//button[text()='Generate Confirm Box']");
	By confirmationBoxChoice = By.xpath("//p[@id='demo']");
	By imageToDragCheck = By.xpath("//img[@id='sourceImage'][@alt='javatpoint']");
	By imageToDropCheck = By.xpath("//div[@id='targetDiv']");
	
	
	
	public void CheckTextMessage() 
	{
		
		String textCompare = driver.findElement(textFieldCheck).getText();
		Assert.assertEquals(textCompare, "This is sample text.", "Text message pulled is not the correct text present in website");
		
	}
	
	public void ClickOnTheLink() {
		
		driver.findElement(linkFieldCheck).click();
	}
	
	public void CheckTextBoxEntry(String textBoxEntry) throws InterruptedException 
	{
		
		driver.findElement(textBoxCheck).sendKeys(textBoxEntry);
		driver.findElement(textBoxCheck).sendKeys(Keys.ENTER);
				
		Thread.sleep(2000);
		
	
	}
	
	public void CheckSubmitButton () {
		
		driver.findElement(buttonCheck).click();
	}
	
	public void CheckRadioButton(String sex) {
		
		if (sex=="male") {
		driver.findElement(radioButtonMaleCheck).click();
		}
		else if (sex=="female") {
		driver.findElement(radioButtonFemaleCheck).click();
		}
		Helper.delayInSeconds(2);
	}
	
	
	public void CheckCheckBox (String clickCheckBox) {
		
		if (clickCheckBox.equalsIgnoreCase("Automation Testing")) {
			driver.findElement(checkBoxAutomationTestingCheck).click();
		}
		else if (clickCheckBox.equalsIgnoreCase("Performance Testing")) {
			driver.findElement(checkBoxPerformanceTestingCheck).click();
		}
		else {
			System.out.println("Given Check box is not present in the website");
		}
		Helper.delayInSeconds(2);
			
	}

	
	public void CheckDropDown (String selectDropDown) {
		
		try {
			Select dropdown = new Select(driver.findElement(dropDownCheck));
			dropdown.selectByVisibleText(selectDropDown);
			Helper.delayInSeconds(2);
		} catch (NoSuchElementException e) {
			throw new RuntimeException("DropDown Element locator is not correct");
		}
		
	}
	
	public void DoubleClickOnAlertBoxOpening() {
		
		try {
		Actions action = new Actions(driver);
		WebElement openAlertBox = driver.findElement(generatingAlertBoxDoubleClickCheck);
		action.doubleClick(openAlertBox).build().perform();
		Helper.delayInSeconds(2);
		driver.switchTo().alert().accept();
		}
		catch (NoSuchElementException e) {
			throw new RuntimeException("Double click locator is not found");
		}
		
	}
	
	public void clickToGenerateAlertBox() {
		try {
		Actions act = new Actions(driver);
		act.click(driver.findElement(generatingAlertBoxSingleClickCheck)).build().perform();
		Helper.delayInSeconds(2);
		driver.switchTo().alert().dismiss();
		}
		catch (NoSuchElementException e) {
			throw new RuntimeException("Single click locator is not found");
		}
	}
	
	public void clickToGenerateConfirmationBox(String choice) {
		
		Actions clickAction = new Actions(driver);
		clickAction.click(driver.findElement(generateConfirmBoxCheck)).build().perform();
		Helper.delayInSeconds(2);
		if (choice=="OK")
		{
			driver.switchTo().alert().accept();
			String acceptMessage = driver.findElement(confirmationBoxChoice).getText();
			Assert.assertEquals(acceptMessage, "You pressed OK!", "Expectation is not matching with actual under generate confirmation box"); 
			Helper.delayInSeconds(2);
			System.out.println("User accepted the confirmation box");
			
		}
		else if (choice=="CANCEL")
		{
			driver.switchTo().alert().dismiss();
			String acceptMessage = driver.findElement(confirmationBoxChoice).getText();
			Assert.assertEquals(acceptMessage, "You pressed Cancel!", "Expectation is not matching with actual under generate confirmation box"); 
			System.out.println("User cancelled the confirmation box");
			
		}
		else
			System.out.println("User didnt provide correct choice for confirmation box");
		
	}
	
	public void CheckDragAndDropTesting() {
		
		WebElement from = driver.findElement(imageToDragCheck);
		WebElement to = driver.findElement(imageToDropCheck);
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("scroll(0,250);");
	//	js.executeScript("window.sccrollBy(0,250);");
		
	//	Actions dragNDrop = new Actions(driver);
	//	dragNDrop.clickAndHold(from).pause(2000).moveToElement(to).release().build().perform();
	//	dragNDrop.dragAndDrop(from, to).build().perform();
	//	dragNDrop.clickAndHold(from).build().perform();
	//	dragNDrop.moveToElement(to).build().perform();
	//	dragNDrop.release(to).build().perform();
		
		Actions builder = new Actions(driver);
		int x2 =from.getLocation().getX();
		System.out.println("location of from -" +x2);
		int y2 = to.getLocation().getY();
		System.out.println("location of to -" +y2);
		builder.clickAndHold(from);
		builder.moveByOffset(x2,y2);
		builder.moveToElement(to);
		builder.release();
		builder.perform();
		
		// doing Right click on any element
		//builder.contextClick(WebElement).perform();
		
		Helper.delayInSeconds(2);
		System.out.println("Drag n Drop performed");
	}
	
}
