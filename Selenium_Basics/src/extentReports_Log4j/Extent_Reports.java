package extentReports_Log4j;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
/*
 * FOR EXTENT REPORTS DOWNLOAD EXTENT REPORTS JAR FILE IN MAVAN REPOSATERY  (ExtentReports For Selenium)
 * ADD JAR FILE IN LIABRARIES REFRESH PROJECT
 * WHERE YOU WANT TO SAVE THE OUTPUT PATH CREATE THERE .XML FOLLOWED BY FILENAME
 * 
 * GO TO GOOGLE AND SEARCH (http://extentreports.com/docs/versions/3/java/)
 * 
 * Extent-Config.xml Community --> COPY CODE
 * 
 * CREATE ONE FILE FILENAME + ENDS WITH .XML
 * PASTE OVER THERE THAT COPIED CODE
 * 
 * CREATE NEW CLASS EXTENDS BASE CLASS OR CREATE NEW METHOD IN BASE CLASS like getreport() returntype EXTENTREPORTS
 * CREATE CODE
 * APPLY OVER IN MAIN METHOD
 * DoWNLOAD EXTENT REPORT FRAMEWORK
 */
public class Extent_Reports {
	public static String propertypath = System.getProperty("user.dir");
	public static Properties prop;
	public static WebDriver driver;
	
	public static ExtentReports reportss=getreport();
	public static ExtentTest test;
	
	
	public static ExtentReports getreport(){
		ExtentReports report=null;
		if (report==null) {
			Date dt = new Date();
			String filepath = dt.toString().replace(":", "_").replace(" ", "_") + ".html";
			report = new ExtentReports(propertypath + "/Html_report/" + filepath);
			report.loadConfig(new File(
					"C:\\Users\\User\\git\\firstReposatery\\Selenium_Basics\\src\\extentReports_Log4j\\extentreports.xml"));
			
		}	
		return report;
	}

	public static void init() throws IOException {
		FileInputStream fis = new FileInputStream(
				new File(propertypath + "\\src\\extentReports_Log4j\\config.properties"));
		prop = new Properties();
		prop.load(fis);

	}

	public static void BrowserLaunch() {
		System.setProperty("webdriver.chrome.driver", prop.getProperty("chrome"));
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		options.addArguments("disable-infobars");
		driver = new ChromeDriver(options);
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

	public static void navigateurl(String url) {
		driver.get(url);
	}

	// using amazon webelements

	public static void main(String[] args) throws IOException {
		// init logger
		test=reportss.startTest("Extent_Report");
		

		init();
		test.log(LogStatus.INFO, "INITILIZED ALL PROPERTY FILES");
		BrowserLaunch();
		test.log(LogStatus.INFO, "launchd browser="+prop.getProperty("chrome"));

		navigateurl(prop.getProperty("url"));
		test.log(LogStatus.INFO, "url sent to browser"+prop.getProperty("url"));
		
		reportss.endTest(test);
		reportss.flush();
	}

}


