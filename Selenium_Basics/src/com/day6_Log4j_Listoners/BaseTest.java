package com.day6_Log4j_Listoners;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseTest {
	public static WebDriver driver;
	public static Properties prop;
	
	public static final Logger log=Logger.getLogger(BaseTest.class.getName());
	public static void init() throws IOException{
		FileInputStream fis=new FileInputStream(new File("C:\\Users\\User\\git\\firstReposatery\\Selenium_Basics\\src\\com\\day6_Log4j_Listoners\\config.properties"));
		prop=new Properties();
		prop.load(fis);
		
		PropertyConfigurator.configure("C:\\Users\\User\\git\\firstReposatery\\Selenium_Basics\\src\\com\\day6_Log4j_Listoners\\log4j.properties");
	}
	public static void initbrowser(){
		System.setProperty("webdriver.chrome.driver", prop.getProperty("chrome"));
		driver=new ChromeDriver();
	}
	public static void navigateurl(){
		driver.get("https://www.amazon.com");
	}
	
	
	
	
	public static void main(String[] args) throws IOException {
		init();
		log.info("loaded properties files");
		initbrowser();
		log.info("browser initilized");
		
		navigateurl();
		log.info("url sent to browser");

	}

}
