package com.day8_screenshots;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.io.FileHandler;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class ScreenShot5_withfailure {
	public static WebDriver driver;
	public static Properties prop;
	
	public static final Logger log=Logger.getLogger(ScreenShot5_withfailure.class.getName());
	
	
	public static ExtentReports log1=ExtentManagement.getReport();
	public static ExtentTest test;
	
	public static void init() throws IOException{
		FileInputStream fis=new FileInputStream(new File("C:\\Users\\User\\git\\firstReposatery\\Selenium_Basics\\src\\com\\day8_screenshots\\config.properties"));
		prop=new Properties();
		prop.load(fis);
		
		PropertyConfigurator.configure("C:\\Users\\User\\git\\firstReposatery\\Selenium_Basics\\src\\com\\day6_Log4j_Listoners\\log4j.properties");
	}
	
	public static void browser_launch(){
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\User\\git\\firstReposatery\\Selenium_Basics\\drivers\\chromedriver.exe");
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--disable-notifications");
		options.addArguments("disable-infobars");
		options.addArguments("--start-maximized");
		driver=new ChromeDriver(options);
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		}
	
	public static void navigate_url() throws IOException, InterruptedException{
		driver.get(prop.getProperty("url"));
		Thread.sleep(8000);
		if ((driver.getTitle().toString().equalsIgnoreCase("CRMPRO - CRM software for customer relationship management, sales, and support."))) {
			String name = driver.getTitle().toString();
			Date dt=new Date();
			SimpleDateFormat crmimgname=new SimpleDateFormat("YY_MM_dd_HH_mm_ss");
			File filetype = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileHandler.copy(filetype, new File("C:\\Users\\User\\git\\firstReposatery\\Selenium_Basics\\ScreenShots\\crm\\"+crmimgname.format(dt)+"_"+name+".jpeg"));
		}
	}
	
	public static void Login() throws IOException{
		
		
		driver.findElement(By.name("username")).sendKeys(prop.getProperty("userName"));
		driver.findElement(By.name("password")).sendKeys(prop.getProperty("Password"));
		driver.findElement(By.cssSelector("div.navbar.navbar-default.navbar-fixed-top.skrollable.skrollable-between:nth-child(2) div.container div.col-sm-4.col-md-4.pull-right form.navbar-form div.input-group div.input-group-btn:nth-child(3) > input.btn.btn-small")).click();
	}
	
	
	
	public static void main(String[] args) throws IOException, InterruptedException {
		test=log1.startTest("ScreenShot5_withfailure");
		init();
		test.log(LogStatus.INFO, "initilized Properties file");
		 log.info("initilized Properties file");
		 browser_launch();
		 log.info("lauch Browser");
		 test.log(LogStatus.INFO, "lauch Browser");
		 navigate_url();
		 log.info("url send to browse");
		 test.log(LogStatus.INFO, "url send to browse");
		 Login();
		 log.info("loged in into crm application");
		 test.log(LogStatus.INFO, "loged in into crm application");
		 
		 log1.endTest(test);
		 log1.flush();
		 
		 
		 
		 
	}
	
	
	
}
