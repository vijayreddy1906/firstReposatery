package com.day5_1_Webelements;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.ProfilesIni;

public class Base_Test_Webelements {
	
	public static Properties prop,weprop;
	public static WebDriver driver;
	
	
	public static void init() throws IOException{
		//config properties file loading
		FileInputStream fis=new FileInputStream(new File("C:\\Users\\User\\git\\firstReposatery\\Selenium_Basics\\src\\com\\sample\\config.properties"));
		prop=new Properties();
		prop.load(fis);
		
		//Flipkart properties file loading
		FileInputStream fis1=new FileInputStream(new File("C:\\Users\\User\\git\\firstReposatery\\Selenium_Basics\\src\\com\\day5_1_Webelements\\fWE.properties"));
		weprop=new Properties();
		weprop.load(fis1);
		
	}
	
	//launching browser
	public static void launch(String browser){
		if (prop.getProperty(browser).equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", prop.getProperty("firefox"));
			System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "null");
			
			FirefoxOptions options=new FirefoxOptions();
			ProfilesIni p=new ProfilesIni();
			FirefoxProfile profile=p.getProfile("default");
			profile.setPreference("dom.webnotifications.enabled", false);
			options.setProfile(profile);
			driver=new FirefoxDriver();
			
		}else if (prop.getProperty(browser).equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", prop.getProperty("chrome"));
			ChromeOptions opt=new ChromeOptions();
			opt.addArguments("--start-maximized");
			opt.addArguments("--disable-webnotifications");
			opt.addArguments("--disable-infobars");
			driver=new ChromeDriver(opt);
		}
	}
	public static void url(String uRL){
		driver.get(prop.getProperty(uRL));
	}
	
	
	public static WebElement getElements(String locaterKey){
		WebElement element=null;
		if(locaterKey.endsWith("_id")){
			element=driver.findElement(By.id(prop.getProperty(locaterKey)));
		}else if(locaterKey.endsWith("_name")){
			element=driver.findElement(By.name(prop.getProperty(locaterKey)));
		}else if(locaterKey.endsWith("_className")){
			element=driver.findElement(By.className(prop.getProperty(locaterKey)));
		}else if(locaterKey.endsWith("_xpath")){
			element=driver.findElement(By.xpath(prop.getProperty(locaterKey)));
		}else if(locaterKey.endsWith("_cssSelector")){
			element=driver.findElement(By.cssSelector(prop.getProperty(locaterKey)));
		}else if(locaterKey.endsWith("_linkText")){
			element=driver.findElement(By.linkText(prop.getProperty(locaterKey)));
		}else if (locaterKey.endsWith("_partialLinkText")) {
			element=driver.findElement(By.partialLinkText(prop.getProperty(locaterKey)));
		}else if (locaterKey.endsWith("_tagName")) {
			element=driver.findElement(By.tagName(prop.getProperty(locaterKey)));
		}
		return element;
	}
	public static WebElement getElements1(String locaterKey){
		WebElement element=null;
		if(locaterKey.endsWith("_id")){
			element=driver.findElement(By.id(weprop.getProperty(locaterKey)));
		}else if(locaterKey.endsWith("_name")){
			element=driver.findElement(By.name(weprop.getProperty(locaterKey)));
		}else if(locaterKey.endsWith("_className")){
			element=driver.findElement(By.className(weprop.getProperty(locaterKey)));
		}else if(locaterKey.endsWith("_xpath")){
			element=driver.findElement(By.xpath(weprop.getProperty(locaterKey)));
		}else if(locaterKey.endsWith("_cssSelector")){
			element=driver.findElement(By.cssSelector(weprop.getProperty(locaterKey)));
		}else if(locaterKey.endsWith("_linkText")){
			element=driver.findElement(By.linkText(weprop.getProperty(locaterKey)));
		}else if (locaterKey.endsWith("_partialLinkText")) {
			element=driver.findElement(By.partialLinkText(weprop.getProperty(locaterKey)));
		}else if (locaterKey.endsWith("_tagName")) {
			element=driver.findElement(By.tagName(weprop.getProperty(locaterKey)));
		}
		return element;
	}
	
	/*public static void text_finding_username(String locaterKey){
		driver.findElement(By.xpath("//span[contains(text(),'Enter Email/Mobile number')]")).isDisplayed();
	}*/
	
	public static void logInID(String locaterKey,String username){
		getElements1(locaterKey).sendKeys(weprop.getProperty(username));
	}
	public static void logInPassword(String locaterKey,String Password) {
		getElements1(locaterKey).sendKeys(weprop.getProperty(Password));
	}
	public static void logInButton(String locaterKey){
		getElements1(locaterKey).click();
	}
	public static void flipkartSearch_text(String locaterKey,String search){
		getElements1(locaterKey).sendKeys(weprop.getProperty(search));
	}
	public static void searchButton(String locaterKey){
		getElements1(locaterKey).click();
	}

}
