package com.day8_screenshots;

import java.io.File;
import java.io.IOException;
import java.util.Date;
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

public class ScreenShot4_withData {
	public static WebDriver driver;
	public static String userdir=System.getProperty("user.dir");

	public static void laucher() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\User\\git\\firstReposatery\\Selenium_Basics\\drivers\\chromedriver.exe");

		ChromeOptions option = new ChromeOptions();
		option.addArguments("--disable-notifications");
		option.addArguments("disable-infobars");
		option.addArguments("--start-maximized");

		driver = new ChromeDriver(option);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	public static void navigateURL() throws IOException {
		driver.get("https://www.google.com");
		
		List<WebElement> list=driver.findElements(By.tagName("a"));
		


		for (int i = 0; i < list.size(); i++) {
			if (!list.get(i).getText().isEmpty()) {
				String filesname=list.get(i).getText();
				list.get(i).click();
				
				Date date=new Date();
				String dt=date.toString().replace(' ', '_').replace(':', '_');
				File srcname = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
				FileHandler.copy(srcname, new File(userdir+"\\ScreenShots\\"+dt+"_"+filesname+".jpeg"));
				driver.navigate().back();
				list=driver.findElements(By.tagName("a"));
			}
			
		}
		
		
	}

	public static void main(String[] args) throws IOException {
		laucher();
		navigateURL();

	}

}
