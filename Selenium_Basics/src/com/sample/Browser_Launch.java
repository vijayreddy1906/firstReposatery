package com.sample;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Browser_Launch {
	
	public static WebDriver driver;
	public static Properties prop;
	
	public static void file_Reader() throws IOException{
		FileInputStream fis=new FileInputStream(new File("C:\\Users\\User\\git\\firstReposatery\\Selenium_Basics\\src\\com\\sample\\config.properties"));
		prop=new Properties();
		prop.load(fis);
	}
	
	public static void launch(String browser){
		if (prop.get(browser).equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", prop.getProperty("chrome"));
			driver = new ChromeDriver();
			driver.get(prop.getProperty("amazonurl"));
			driver.manage().window().maximize();
			driver.getTitle();
			System.out.println(driver.getCurrentUrl());
			driver.manage().deleteAllCookies();
			
			
			driver.manage().deleteAllCookies();
			
			
		}
		
	}
	

	public static void main(String[] args) throws IOException {
		file_Reader();
		launch("chromebrowser");
		
		
		driver.quit();
		

	}

}
