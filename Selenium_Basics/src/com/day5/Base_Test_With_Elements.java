package com.day5;

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

public class Base_Test_With_Elements {
	public static Properties prop,or;
	public static WebDriver driver;
	static String propertypath=System.getProperty("user.dir");
	
	public static void init() throws IOException{
		FileInputStream fis =new FileInputStream(new File("C:\\Users\\User\\git\\firstReposatery\\Selenium_Basics\\src\\com\\day5\\config.properties"));
		prop=new Properties();
		prop.load(fis);	
		
//		FileInputStream fis1=new FileInputStream(propertypath+"/or.properties");
		FileInputStream fis1=new FileInputStream(new File("C:\\Users\\User\\git\\firstReposatery\\Selenium_Basics\\src\\com\\day5\\or.properties"));
		or=new Properties();
		or.load(fis1);
	}
	public static void launch(String browser){
		if (prop.getProperty(browser).equalsIgnoreCase("chrome")) 
		{
			System.setProperty("webdriver.chrome.driver", prop.getProperty("chrome"));
			ChromeOptions opt=new ChromeOptions();
//			opt.addArguments("user-data-dir=C:\\Users\\User\\AppData\\Local\\Google\\Chrome\\User Data\\Profile 1");
			opt.addArguments("--disable-webnotifications");
			opt.addArguments("--disable-infobars");
			driver=new ChromeDriver(opt);			
		}
		else if (prop.getProperty(browser).equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", prop.getProperty("firefox"));
			System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "null");
			
			FirefoxOptions options=new FirefoxOptions();
			ProfilesIni p=new ProfilesIni();
			FirefoxProfile profile = p.getProfile("Vijay");
			profile.setPreference("dom.webnotifications.enabled", false);
			options.setProfile(profile);
			driver=new FirefoxDriver(options);
		}
		
		
	}
	public static void navigateURL(String URL){
		driver.get(prop.getProperty(URL));
	}
	
	public static void select_Options(String locaterKey,String option){
		getElement(locaterKey).sendKeys(or.getProperty(option));
	}
	public static void type_Text(String locaterKey,String value){
		getElement(locaterKey).sendKeys(or.getProperty(value));
	}
	public static void click_Element(String locaterKey){
		getElement(locaterKey).click();
	}
	public static WebElement getElement(String locaterKey){
		
		WebElement element=null;
		if(locaterKey.endsWith("_id")){
			element=driver.findElement(By.id(or.getProperty(locaterKey)));
		}else if (locaterKey.endsWith("_name")) {
			element=driver.findElement(By.name(or.getProperty(locaterKey)));
		}else if (locaterKey.endsWith("_className")) {
			element=driver.findElement(By.className(or.getProperty(locaterKey)));
		}else if (locaterKey.endsWith("_xpath")) {
			element=driver.findElement(By.xpath(or.getProperty(locaterKey)));
		}else if (locaterKey.endsWith("_cssSelector")) {
			element=driver.findElement(By.cssSelector(or.getProperty(locaterKey)));
		}else if (locaterKey.endsWith("_linkText")) {
			element=driver.findElement(By.linkText(or.getProperty(locaterKey)));
		}else if (locaterKey.endsWith("partialLinkText")) {
			element=driver.findElement(By.partialLinkText(or.getProperty(locaterKey)));
		}else if (locaterKey.endsWith("_tagName")) {
			element=driver.findElement(By.tagName(or.getProperty(locaterKey)));
		}
		/*driver.findElement(By.linkText("Google (@Google) · Twitter")).click();
		driver.findElement(By.partialLinkText("Google (@Google) · Twitter")).click();*/
		return element;
	}

}
