package com.day8_screenshots;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.io.FileHandler;

public class ScreenShot3 {
	public static WebDriver driver;

	

	public static void laucher() {
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\User\\git\\firstReposatery\\Selenium_Basics\\drivers\\chromedriver.exe");

			ChromeOptions option = new ChromeOptions();

			//////// TO LAUNCH USERDEFINED PROFILE/////////
			// option.addArguments("user-data-dir=C:\\Users\\User\\AppData\\Local\\Google\\Chrome\\User
			// Data\\Profile 1");

			//////// TO HIDE NOTIFICATIONS/////////////////
			option.addArguments("--disable-notifications");
			option.addArguments("disable-infobars");
			option.addArguments("--start-maximized");

			////// PROXEY AND IP ADDRESS//////port proxey address
			// option.addArguments("--proxey-server=http://192:168:90:84:1234");

			driver = new ChromeDriver(option);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		}
	

	public static void navigateURL() throws IOException {
		driver.get("http://demoaut.com/");
		List<WebElement> list=driver.findElements(By.tagName("a"));
		
		
		
		for (int i = 0; i < list.size(); i++) {
			if (!list.get(i).getText().isEmpty()){
				String fname=list.get(i).getText().toString();
				list.get(i).click();
				File srcimg=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
				FileHandler.copy(srcimg, new File("C:\\Users\\User\\git\\firstReposatery\\Selenium_Basics\\ScreenShots\\"+fname+".jpeg"));
//				driver.navigate().back();
				list=driver.findElements(By.tagName("a"));
			}
		}
		
		/*if (list.size()==0) {
			File srcimg=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileHandler.copy(srcimg, new File("C:\\Users\\User\\git\\firstReposatery\\Selenium_Basics\\ScreenShots\\"+"image.Jpeg"));*/
		
		
	}
	public static void main(String[] args) throws IOException {
		laucher();
		navigateURL();
		
	
	}

}
