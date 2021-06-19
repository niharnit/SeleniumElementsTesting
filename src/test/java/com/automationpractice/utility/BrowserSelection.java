package com.automationpractice.utility;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserSelection {

	public static WebDriver driver;
	
	static String ProjectPath = System.getProperty("user.dir");
	
	public static WebDriver BrowserSetUp(String browser) {
		
		if(browser.equalsIgnoreCase("chrome")) {
			
		//	System.setProperty("webdriver.chrome.silentOutput","true");
			System.setProperty("webdriver.chrome.driver", ProjectPath+"/Drivers/Chromedriver/chromedriver.exe");
			driver = new ChromeDriver();
			
		} 
		else if(browser.equalsIgnoreCase("Firefox"))
				{
			System.setProperty("webdriver.gecko.driver", ProjectPath+"/Drivers/Geckodriver/geckodriver.exe");
			driver = new ChromeDriver();
		}
		else
			System.out.println("Browser Selection is Invalid");
		
		driver.manage().deleteAllCookies();
		driver.manage().window().fullscreen();
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		return driver;
		
	}

		
}
