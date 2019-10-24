package Base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class BaseClass {
	public static String projectDir=System.getProperty("user.dir");
	public static Properties prop;
	
	public static WebDriver driver;
	
	public static ExtentReports report=ExtantManager.getReport();
	public static ExtentTest test;

	
	public void launchBrowser(){
		System.setProperty("webdriver.chrome.driver", projectDir+"\\target\\drivers\\chromedriver.exe");
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--disable-notifications");
		options.addArguments("disable-infobars");
		options.addArguments("--start-maximized");
		driver=new ChromeDriver(options);		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	public BaseClass() {
		try {
			FileInputStream fis=new FileInputStream(new File(projectDir+"\\src\\main\\java\\Config\\config.properties"));
			prop=new Properties();
			try {
				prop.load(fis);
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}	
	}

	
	
	
	
	

}
