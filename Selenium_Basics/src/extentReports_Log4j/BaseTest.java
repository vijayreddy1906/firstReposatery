package extentReports_Log4j;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BaseTest {
	public static String propertypath = System.getProperty("user.dir");
	public static Properties prop;
	public static WebDriver driver;
	public static Logger log=Logger.getLogger(BaseTest.class.getName());

	public static void init() throws IOException {
		FileInputStream fis = new FileInputStream(
				new File(propertypath + "\\src\\extentReports_Log4j\\config.properties"));
		prop = new Properties();
		prop.load(fis);
		
		PropertyConfigurator.configure(propertypath+"\\src\\extentReports_Log4j\\log4jReports.properties");
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

	//using amazon webelements

	public static void main(String[] args) throws IOException {
		//init logger
		
		
		
		init();
		log.info("initilized propertiesfile");

		BrowserLaunch();
		log.info("launch browser");
		

		navigateurl(prop.getProperty("url"));
		log.info("url sent to browser+3");
	}

}
