package com.day9_Verification_validation;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class SoftAserts_HardAsserts {
	
	public static WebDriver driver;
	
	public static String title="Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in";

	public static void main(String[] args) throws InterruptedException {
		
		SoftAssert soft=new SoftAssert();

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\User\\git\\firstReposatery\\Selenium_Basics\\drivers\\chromedriver.exe");
		ChromeOptions options =new ChromeOptions();
		options.addArguments("--disable-notifications");
		options.addArguments("diasable-infobars");
		options.addArguments("--start-maximized");
		
		driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.get("https://www.amazon.in/");
		
		
		//using asset class to compare the actulresult & expected result///////USING STRING ,STRING
		Assert.assertEquals(driver.getTitle().toString(), title);
		
		Assert.assertFalse(driver.getTitle().equals("vijay"));//if statement will satisfy once condition fails
		WebElement dr = driver.findElement(By.id("twotabsearchtextbox"));
		dr.sendKeys("Vijay simha Reddy");
		
		soft.assertTrue(dr.getAttribute("value").equals("Vijay simha Reddy"));
		soft.assertTrue(dr.getAttribute("value").equals("Vijay simha Reddy"), "Actual & expected values not matching.........");
		soft.assertAll();
		
		
		
		
		Thread.sleep(5000);
		driver.quit();
		
		
	}

}
