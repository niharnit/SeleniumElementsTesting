package com.automationpractice.utility;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Helper {

	public void captureScreenshots(WebDriver driver) {
		
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		try {
			
			FileHandler.copy(src, new File("./Screenshots/" + getCurrentDateTime() + ".png"));
			System.out.println("Screenshots are captured");
		
		} catch (IOException e) {
			
			System.out.println("Unable to take Screenshot" + e.getMessage());
		}
	}

	public String getCurrentDateTime() {
		 
		DateFormat customFormat = new SimpleDateFormat("MM_dd_yyyy_HH_mm_ss");
		Date currentDate = new Date();
		return customFormat.format(currentDate);
	}	
	
	public static void delayInSeconds(int delayNumber) {
		
		try {
			Thread.sleep(delayNumber * 1000);
		} catch (InterruptedException e) {
				e.printStackTrace();
		}
	}
}
