package com.automationpractice.utility;

import java.io.File;
import java.io.FileInputStream;

import java.util.Properties;

public class ConfigurationFileReader {
	
	public Properties prop;
	
	public ConfigurationFileReader()  
	{
	
			
			File src = new File("./Config/config.properties");
		try {
			FileInputStream fis = new FileInputStream(src);
			prop=new Properties();
			prop.load(fis);
		
		} catch (Exception e) {
			System.out.println("Unable to read config file" + e.getMessage());			
		}
		
	}
	
	public String BrowserSelect() {
		String browserchoice = prop.getProperty("browser");
		if(browserchoice !=null) 
			return browserchoice ;
		else
			throw new RuntimeException("browser is not defined in configuration file");
		
	}
	
	
	public String AutomationURL() {
		String url = prop.getProperty("AutomationPracticeURL"); 
		if(url != null)
			return url;
		else
			throw new RuntimeException("url path is not specified in configuration file");
		
	}
	
	public String ElementsTestingSite() {
		return prop.getProperty("seleniumElementTestingSite");
		
	}
	
	public String usermailid() {
		return prop.getProperty("username");
		
	}
	
	public String userpasswrod() {
		return prop.getProperty("password");
		
	}

}
