package com.dayA1_VV_Frameworklevel;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Class10_Verification_Validation_Framework_Level {
	
	public static WebDriver driver;
	
	public static ExtentReports report=ExtentManager.getReport();
	public static ExtentTest test;
	
	public static void browserlaunch(){
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\User\\Documents\\GitHub\\firstReposatery\\Selenium_Basics\\drivers\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://www.amazon.com");
		
		
/*		WebDriverWait weight =new WebDriverWait(driver, 20);
		WebElement Button=null;
		weight.until(ExpectedConditions.elementToBeClickable(Button));
*/	}
	
	

	public static boolean verifyTitle(String element,String Name){
		if (element.equals(Name)) {
			return true;
		}else {
			return false;
		}

	}
	
	public static void main(String[] args) {
		test=report.startTest("Class10_Verification_Validation_Framework_Level");
	
		browserlaunch();
		test.log(LogStatus.PASS, "Launched Browser.....");
		String ActualTitle=driver.getTitle();
		String ExpectedTitle="Vijay simha reddy";
		if (!verifyTitle(ActualTitle, ExpectedTitle)) {
			failedTitle("Page Title Not matched........");
		}else{
			PassedTitle("");
		}
		report.endTest(test);
		report.flush();

	}

	public static void PassedTitle(String Message) {
		test.log(LogStatus.PASS, Message);
	}

	public static void failedTitle(String Message) {
		test.log(LogStatus.PASS, Message);
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		TSS();
	}
	
	public static void TSS(){
		Date dat=new Date();
		SimpleDateFormat sdate=new SimpleDateFormat("YY-MM-dd_HH-mm-ss");
		File srcFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(srcFile, new File("./target/failedScreenshots/"+sdate.format(dat).toString()+".png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		test.log(LogStatus.INFO, "Screenshot--->"+test.addScreenCapture("C:\\Users\\User\\Documents\\GitHub\\firstReposatery\\Selenium_Basics\\target\\failedScreenshots\\"+sdate.format(dat).toString()+".png"));
	}
	

}
