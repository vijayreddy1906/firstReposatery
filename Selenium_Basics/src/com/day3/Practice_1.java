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

// Creating Firefox profile

public class Practice_1 {

	// properties class reference
	public static Properties prop;

	// WebDriver class reference
	public static WebDriver driver;

	public static void init() throws IOException {
		// to find the file in particular path
		FileInputStream fis = new FileInputStream(new File("C:\\Users\\User\\git\\firstReposatery\\Selenium_Basics\\src\\com\\sample\\config.properties"));

		// Creates an empty property list with no default values
		prop = new Properties();

		// to load property file
		prop.load(fis);
	}

	public static void launch(String browser) {
		if (prop.getProperty(browser).equalsIgnoreCase("firefox")) {
			// to asign the gecko driver to firefox browser
			System.setProperty("webdriver.gecko.driver", prop.getProperty("firefox"));
			
			// to avoid unnecessery log files
			//System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "null");
			//to store logfiles into specific file
			System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "C:\\Users\\User\\Desktop\\selenium videos\\logfil.txt");
			// to asign firefox user defined profile to firefox driver
			FirefoxOptions option = new FirefoxOptions();

			// to use userdefined profile empty profile object created
			ProfilesIni p = new ProfilesIni();

			// to read firefox userdefined profile
			FirefoxProfile profile = p.getProfile("Vijay");
			
			/////////////////////////////////////////////////TO HANDLE BROWSER NOTIFICATION///////////////////////////
			profile.setPreference("dom.webnotifications.enabled", false);

			// to set profile to firefox options
			option.setProfile(profile);

			// to launch browser
			driver = new FirefoxDriver(option);

		}
	}
	public static void navigateURL(String uRL){
		driver.get(prop.getProperty(uRL));
	}

}
