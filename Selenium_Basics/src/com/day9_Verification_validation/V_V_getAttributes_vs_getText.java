package com.day9_Verification_validation;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class V_V_getAttributes_vs_getText {
////////////////////////////////////////////////////USING GETtEXT AND GET ATTRIBUITE
	public static WebDriver driver;
	
	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\User\\git\\firstReposatery\\Selenium_Basics\\drivers\\chromedriver.exe");
		ChromeOptions options =new ChromeOptions();
		options.addArguments("--disable-notifications");
		options.addArguments("diasable-infobars");
		options.addArguments("--start-maximized");
		
		driver=new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.get("https://www.amazon.in/gp/help/customer/display.html?nodeId=508510&ref_=nav_em_T1_0_1_0_3_cs_help");
		
		//Ex--1
		/*WebElement loc = driver.findElement(By.id("twotabsearchtextbox"));
		loc.sendKeys("WoodLand");
		String ActualValue=loc.getText();///////////////////////////hear get text we will not get innervalues
		String Actualval=loc.getAttribute("value");
		System.out.println("ActualValueis=   "+ActualValue);
		System.out.println("Actual getAttribute result is= "+Actualval);*/
		
		//if i want to get class nameof perticulat element
		
		String web = driver.findElement(By.xpath("//a[@class='nav-sprite nav-logo-tagline nav-prime-try']")).getText();
		
		System.out.println("weblogo nae is="+web);
		
		WebElement log = driver.findElement(By.id("twotabsearchtextbox"));
		log.sendKeys("Vijay");
		String string=log.getText();
		System.out.println("gettext="+string);
		
		String str1=log.getAttribute("innerHTML");
		System.out.println("getattribute="+str1);
		
		String str2=log.getAttribute("value");
		System.out.println("get attribute2= "+str2);
		
		log=driver.findElement(By.xpath("//input[@id='helpsearch']"));
		log.sendKeys("Vijay simha");
		String soap=log.getAttribute("value");
		System.out.println("placeholder="+soap);
		
		driver.findElement(By.xpath("//input[@aria-labelledby='helpSearchSubmit-announce']")).click();
		
		log=driver.findElement(By.className("a-input-text a-span12"));
		log.sendKeys("books");
		String sas=log.getAttribute("value");
		System.out.println(sas);
		
		
		
		
		Thread.sleep(8000);
		driver.quit();
		
	}

}
