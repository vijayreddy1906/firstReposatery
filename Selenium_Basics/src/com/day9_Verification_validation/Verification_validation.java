package com.day9_Verification_validation;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Verification_validation {
	public static WebDriver driver;
	
	
	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\User\\git\\firstReposatery\\Selenium_Basics\\drivers\\chromedriver.exe");
		ChromeOptions options =new ChromeOptions();
		options.addArguments("--disable-notifications");
		options.addArguments("diasable-infobars");
		options.addArguments("--start-maximized");
		
		driver=new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.get("https://www.amazon.in");
		
		//if both are equal   //USING GET TEXT FOR GETTING VISIBLE PROPERTIES
		/*String Actualvalue = driver.findElement(By.linkText("AmazonBasics")).getText();
		String ExpectedValue="AmazonBasics";
		System.out.println(Actualvalue);
		System.out.println(ExpectedValue);
		
		if(Actualvalue.equals(ExpectedValue))
			System.out.println("Both are Equal......");
		else
			System.out.println("Both are not equal.....");*/
		
		//if expected value is Different
		/*String Actualvalue = driver.findElement(By.linkText("AmazonBasics")).getText();
		String ExpectedValue="AmazonBasic";
		
		System.out.println(Actualvalue);
		System.out.println(ExpectedValue);
		
		if(Actualvalue.equals(ExpectedValue))
			System.out.println("Both are Equal......");
		else
			System.out.println("Both are not equal.....");*/
		
		
		//if case is different
		/*String Actualvalue = driver.findElement(By.linkText("AmazonBasics")).getText();
		String ExpectedValue="amazonBasics";
		System.out.println(Actualvalue);
		System.out.println(ExpectedValue);
		
		if(Actualvalue.equals(ExpectedValue))
			System.out.println("Both are Equal......");
		else
			System.out.println("Both are not equal.....");//will execuite*/
		
		//comparing with equals ignorecase with different cases
		/*String Actualvalue = driver.findElement(By.linkText("AmazonBasics")).getText();
		String ExpectedValue="amazonBasics";
		System.out.println(Actualvalue);
		System.out.println(ExpectedValue);
		
		if(Actualvalue.equalsIgnoreCase(ExpectedValue))
			System.out.println("Both are Equal......");//it will get output because it will ignore cases
		else
			System.out.println("Both are not equal.....");*/
		
		//using contans keyword comparing 
		/*String Actualvalue = driver.findElement(By.linkText("AmazonBasics")).getText();
		String ExpectedValue="amazonBasics";
		System.out.println(Actualvalue);
		System.out.println(ExpectedValue);
		
		if(Actualvalue.contains(ExpectedValue))
			System.out.println("Both are Equal......");
		else
			System.out.println("Both are not equal.....");//this will come output because actual and expected case is different*/		
		
		//different ways using containsof
		/*String Actualvalue = driver.findElement(By.linkText("AmazonBasics")).getText();
		String ExpectedValue="Amazon";
		System.out.println(Actualvalue);
		System.out.println(ExpectedValue);
		
		if(Actualvalue.equalsIgnoreCase(ExpectedValue))
			System.out.println("Both are Equal......");//actual output contains expected output hence both are equal true
		else
			System.out.println("Both are not equal.....");*/
		
		//using contains equals
		/*String Actualvalue = driver.findElement(By.linkText("AmazonBasics")).getText();
		String ExpectedValue="AmazonBasics";
		System.out.println(Actualvalue);
		System.out.println(ExpectedValue);
		
		if(Actualvalue.contentEquals(ExpectedValue))
			System.out.println("Both are Equal......"); //both are equal 
		else
			System.out.println("Both are not equal.....");*/
		
		String Actualvalue = driver.findElement(By.linkText("AmazonBasics")).getText();
		String ExpectedValue="AmazonBasic";
		System.out.println(Actualvalue);
		System.out.println(ExpectedValue);
		
		if(Actualvalue.equalsIgnoreCase(ExpectedValue))
			System.out.println("Both are Equal......");//it will get output because it will ignore cases
		else
			System.out.println("Both are not equal.....");
		
		
		
		
		
		
		
		
		
		
		
		Thread.sleep(8000);
		driver.quit();
		
	}

}
