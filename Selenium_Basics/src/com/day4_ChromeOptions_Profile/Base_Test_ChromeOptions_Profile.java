package com.day4_ChromeOptions_Profile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.ie.InternetExplorerOptions;

public class Base_Test_ChromeOptions_Profile {
	public static Properties prop;
	public static WebDriver driver;
	
	public static void init() throws IOException{
		FileInputStream fis=new FileInputStream(new File("C:\\Users\\User\\git\\firstReposatery\\Selenium_Basics\\src\\com\\sample\\config.properties"));
		prop=new Properties();
		prop.load(fis);
	}
	public static void laucher(String browser)
	{
		if (prop.getProperty(browser).equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", prop.getProperty("chrome"));
			
			ChromeOptions option=new ChromeOptions();
			
			////////TO LAUNCH USERDEFINED PROFILE/////////
			option.addArguments("user-data-dir=C:\\Users\\User\\AppData\\Local\\Google\\Chrome\\User Data\\Profile 1");
			
			////////TO HIDE NOTIFICATIONS/////////////////
			option.addArguments("--disable-notifications");
			option.addArguments("--disable-infobars");
			option.addArguments("--start-maximized");
			
			
			//////PROXEY AND IP ADDRESS//////port proxey address
			//option.addArguments("--proxey-server=http://192:168:90:84:1234");

			
			driver=new ChromeDriver(option);
			
		}
	}
	
	public static void navigateURL(String uRL){
		driver.get(prop.getProperty(uRL));
	}

}
