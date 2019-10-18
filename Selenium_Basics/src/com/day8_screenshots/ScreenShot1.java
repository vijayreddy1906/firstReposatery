package com.day8_screenshots;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.io.FileHandler;

public class ScreenShot1 {
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

		}
	

	public static void navigateURL() {
		driver.get("https://www.google.in");
	}
	public static void main(String[] args) throws IOException {
		laucher();
		navigateURL();
		
		File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileHandler.copy(file, new File("C:\\Users\\User\\git\\firstReposatery\\Selenium_Basics\\ScreenShots\\"+"image.Jpeg"));
		
	}

}
