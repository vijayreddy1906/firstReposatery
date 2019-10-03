package com.Day2;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Base_Test {
	public static Properties prop;
	public static WebDriver driver;

	// loading properties file
	public static void init() throws IOException {
		FileInputStream fis = new FileInputStream(new File("C:\\Users\\User\\git\\firstReposatery\\Selenium_Basics\\src\\com\\sample\\config.properties"));
		prop = new Properties();
		prop.load(fis);
	}

	// Launching browser
	public static void launch_browser(String str) {

		if (str.equalsIgnoreCase(prop.getProperty("firefoxbrowser"))) {
			System.setProperty("webdriver.gecko.driver", prop.getProperty("firefox"));
			driver = new FirefoxDriver();

		} else if (str.equalsIgnoreCase(prop.getProperty("chromebrowser"))) {
			System.setProperty("webdriver.chrome.driver", prop.getProperty("chrome"));
			driver = new ChromeDriver();

		} else if (str.equalsIgnoreCase("edgebrowser")) {
			System.setProperty("webdriver.edge.driver", prop.getProperty("edge"));
			driver = new EdgeDriver();

		} else if (str.equalsIgnoreCase("iebrowser")) {
			System.setProperty("webdriver.ie.driver", prop.getProperty("ie"));
			driver = new InternetExplorerDriver();
		}
	}

	public static void navigateURL(String URL) throws InterruptedException {
		driver.get(prop.getProperty(URL));
		// Thread.sleep(5000);
		// driver.navigate().to(prop.getProperty("flipkarturl"));
	}

}
