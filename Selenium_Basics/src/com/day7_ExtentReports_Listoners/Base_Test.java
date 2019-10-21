package com.day7_ExtentReports_Listoners;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Base_Test {
	public static Properties prop;
	public static Logger logger = Logger.getLogger(Base_Test.class.getName());
	public static WebDriver driver;
	public static String projectPath=System.getProperty("user.dir");
	public static ExtentReports reports1= Example.getreports();
	public static ExtentTest test;

	public static void init() throws IOException {
		FileInputStream fis = new FileInputStream(new File(
				"C:\\Users\\User\\git\\firstReposatery\\Selenium_Basics\\src\\com\\day7_ExtentReports_Listoners\\config.properties"));
		prop = new Properties();
		prop.load(fis);

		PropertyConfigurator.configure(
				"C:\\Users\\User\\git\\firstReposatery\\Selenium_Basics\\src\\com\\day7_ExtentReports_Listoners\\log4j.properties");
		
	}

	public static void browser() {
		System.setProperty("webdriver.chrome.driver", prop.getProperty("chrome"));
		ChromeOptions options = new ChromeOptions();
		// options.addArguments("user-data-dir=C:\\Users\\User\\AppData\\Local\\Google\\Chrome\\User
		// Data\\Default");
		options.addArguments("--start-maximized");
		options.addArguments("--disable-notifications");
		options.addArguments("--disable-popup-blocking");
		options.addArguments("disable-infobars");

		driver = new ChromeDriver(options);
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		

	}

	public static void purchase() throws InterruptedException {
		driver.get("https://www.amazon.in");
		driver.findElement(By.xpath("//a[@id='nav-link-accountList']/span[2]")).click();
		driver.findElement(By.xpath("//div[@id='nav-flyout-ya-signin']//a/span[contains(text(),'Sign in')]")).click();
		driver.findElement(By.id("ap_email")).sendKeys("kvreddy1906@gmail.com");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		driver.findElement(By.id("ap_password")).sendKeys(prop.getProperty("password"));
		driver.findElement(By.id("signInSubmit")).click();
		driver.findElement(By.xpath("//select[@id='searchDropdownBox']")).sendKeys("Electronics");
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("mi band 3 black watch");
		driver.findElement(By.xpath("//input[@type='submit'][@class='nav-input']")).click();
//		driver.findElement(By.linkText("Mi Band 3 (Black)")).click();
		// driver.close();
		// driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[2]/div[4]/div[5]/div[1]/div[5]/div[1]/div[1]/div[1]/form[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[21]")).click();
//		driver.findElement(By.cssSelector("#buy-now-button")).sendKeys("500081");
		
		

		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[@id='nav-logo']//a[@class='nav-logo-link']")).click();
		driver.findElement(By.id("nav-link-accountList")).click();
		driver.findElement(By.xpath("//a[@id='nav-item-signout']//span[contains(text(),'Sign Out')]")).click();

	}

	public static void main(String[] args) throws IOException, InterruptedException {

		// for (int i = 0; i <=0; i++) {
		test=reports1.startTest("Base_Test");
		init();
		logger.info("properties files initilized");
		test.log(LogStatus.INFO, "initilized property files");
		
		browser();
		logger.info("browser opened and url sent");
		test.log(LogStatus.INFO, "launched browser"+prop.getProperty("browser opened and url sent")+"url initilized");
		purchase();
		test.log(LogStatus.INFO, "entered into puchase dept");
		Thread.sleep(8000);
		driver.quit();
		logger.info("browser quit");
		
		reports1.endTest(test);
		reports1.flush();

		// }

	}

}