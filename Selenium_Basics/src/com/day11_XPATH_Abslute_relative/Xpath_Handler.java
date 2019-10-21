package com.day11_XPATH_Abslute_relative;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Xpath_Handler {
	public static WebDriver driver;
	
	public static void browser_Launch(){
		try {
			Xpath_Handler xh=new Xpath_Handler();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.setProperty("webdriver.chrome.driver","C:\\Users\\User\\Documents\\GitHub\\firstReposatery\\Selenium_Basics\\drivers\\chromedriver.exe" );
		
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--disable-notifications");
		options.addArguments("disable-infobars");
		driver=new ChromeDriver(options);
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
	}
	
//	RELEVENT XPATHS
	public static void Login(){
		driver.get("https://www.amazon.in");
		driver.findElement(By.xpath("//a[@id='nav-link-accountList' or @data-nav-ref='nav_ya_signin' ]")).click();
		driver.findElement(By.xpath("//div[@id='nav-flyout-ya-signin' ]//span[text()='Sign in']")).click();
		driver.findElement(By.xpath("//input[contains(@id,'ap_email')]")).sendKeys("kvreddy1906@gmail.com");
		driver.findElement(By.xpath("//span[@class='a-button-inner']//input[@id='continue'][1]")).click();
		driver.findElement(By.xpath("//input[@class='a-input-text a-span12 auth-autofocus auth-required-field' and @id='ap_password']")).sendKeys("9550333582");
		driver.findElement(By.xpath("//span[@id='auth-signin-button' or @id='signInSubmit']")).click();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public Xpath_Handler() throws IOException {

		FileInputStream fis=new FileInputStream(new File("C:\\Users\\User\\Documents\\GitHub\\firstReposatery\\Selenium_Basics\\src\\extentReports_Log4j\\config.properties"));
		Properties prop=new Properties();
		prop.load(fis);
	}

	public static void main(String[] args) {
		browser_Launch();
		Login();
	}

}
