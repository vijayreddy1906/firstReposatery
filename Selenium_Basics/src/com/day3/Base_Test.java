package com.day3;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.ProfilesIni;

public class Base_Test {
	public static Properties prop;
	public static WebDriver driver;

	public static void init() throws IOException {

		FileInputStream fis = new FileInputStream(new File("C:\\Users\\User\\git\\firstReposatery\\Selenium_Basics\\src\\com\\sample\\config.properties"));
		prop = new Properties();
		prop.load(fis);
	}

	public static void launch(String browser) {
		if (prop.getProperty(browser).equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", prop.getProperty("firefox"));

			// to hide unnecessery logs in console window
			System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "null");

			// if i want to open userdefined profile we have to use
			// firefoxoptions class
			FirefoxOptions options = new FirefoxOptions();

			// initiate firefox profile to get userdefined profile
			ProfilesIni p = new ProfilesIni();

			FirefoxProfile profile = p.getProfile("Vijay");

			// using firefox profile reference notifications disabled
			profile.setPreference("dom.webnotifications.enabled", false);

			options.setProfile(profile);

			driver = new FirefoxDriver(options);

			driver.get(prop.getProperty("axisbankurl"));

		}
	}

	public static void main(String[] args) throws IOException {
		init();
		launch("firefoxbrowser");
	}

}
