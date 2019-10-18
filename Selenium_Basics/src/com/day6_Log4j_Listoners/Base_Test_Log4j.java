package com.day6_Log4j_Listoners;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.ProfilesIni;
import org.openqa.selenium.support.FindBy;

public class Base_Test_Log4j {
	public static Properties prop,webprop;
	public static WebDriver driver;
	public static final Logger log=Logger.getLogger(Base_Test_Log4j.class.getName());
	

	public static void init() throws IOException {
		FileInputStream fis = new FileInputStream(new File("C:\\Users\\User\\git\\firstReposatery\\Selenium_Basics\\src\\com\\sample\\config.properties"));
		prop = new Properties();
		prop.load(fis);
		
		FileInputStream fis1=new FileInputStream(new File("C:\\Users\\User\\git\\firstReposatery\\Selenium_Basics\\src\\com\\day6_Log4j_Listoners\\amazonlink.properties"));
		webprop=new Properties();
		webprop.load(fis1);
		
		FileInputStream fis3=new FileInputStream(new File("C:\\Users\\User\\git\\firstReposatery\\Selenium_Basics\\src\\com\\day6_Log4j_Listoners\\log4j.properties"));
		PropertyConfigurator.configure("C:\\Users\\User\\git\\firstReposatery\\Selenium_Basics\\src\\com\\day6_Log4j_Listoners\\log4j.properties");
	}

	public static void launch(String browser) {
		if (prop.getProperty(browser).equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", prop.getProperty("chrome"));
			ChromeOptions options = new ChromeOptions();

			//to maximize window
			options.addArguments("--start-maximized");
			
			//to open customized profile
			options.addArguments("user-data-dir=C:\\Users\\User\\AppData\\Local\\Google\\Chrome\\User Data\\Profile 2");

			// to disable notifications
			options.addArguments("--disable-notifications");

			// to launch incogntto mode
			//options.addArguments("--incognito");
			
			//to launch browser
			driver = new ChromeDriver(options);
		
		}else if (prop.getProperty(browser).equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", prop.getProperty("firefox"));
			
			//in console window i dont want to print execution logfiles
			System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "null");
			
			//created object for ffoptions to call userdefined profile
			FirefoxOptions options=new FirefoxOptions();
			
			//profile object created to get the profile
			ProfilesIni p = new ProfilesIni();
			
			//created ffprofile reference to call userdefined profile
			FirefoxProfile profile=p.getProfile("Vijay");
			
			//to disabled notifications
			profile.setPreference("dom.webnotifications.enabled", false);
			
			//to set profile in options
			options.setProfile(profile);
			
			//to launch browser with customized profile
			driver=new FirefoxDriver(options);
		}
	}
	
	//to search url
	public static void navigateurl(String url){
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(prop.getProperty(url));
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	public static WebElement getElement(String locaterKey){
		WebElement element=null;
		if(locaterKey.endsWith("_id")){
			element=driver.findElement(By.id(webprop.getProperty(locaterKey)));
		}else if (locaterKey.endsWith("_name")){
			element=driver.findElement(By.name(webprop.getProperty(locaterKey)));
		}else if (locaterKey.endsWith("_className")){
			element=driver.findElement(By.className(webprop.getProperty(locaterKey)));
		}else if (locaterKey.endsWith("_xpath")){
			element=driver.findElement(By.xpath(webprop.getProperty(locaterKey)));
		}else if (locaterKey.endsWith("_cssSelector")){
			element=driver.findElement(By.cssSelector(webprop.getProperty(locaterKey)));
		}else if (locaterKey.endsWith("_linkText")){
			element=driver.findElement(By.linkText(webprop.getProperty(locaterKey)));
		}else if (locaterKey.endsWith("_partialLinkText")){
			element=driver.findElement(By.partialLinkText(webprop.getProperty(locaterKey)));
		}else if (locaterKey.endsWith("_tagName")){
			element=driver.findElement(By.tagName(webprop.getProperty(locaterKey)));
		}
		
		return element;
	}
	
	//new customer text is displayedor not 
	public static void newCustomer_text(String locaterKey){
		boolean b=getElement(locaterKey).isDisplayed();
		System.out.println(b);
	}
	public static void signin_Button(String locaterKey){
		getElement(locaterKey).click();
	}
	public static void createAccount_text_isDisplayed(String locaterKey){
		boolean b= getElement(locaterKey).isDisplayed();
		System.out.println(b);
	}
	
	public static void enterTex_yourName(String locaterKey,String yourname){
		getElement(locaterKey).sendKeys(webprop.getProperty(yourname));
	}
	public static void mobileNumber_textField_isDisplayed(String locaterKey){
		getElement(locaterKey).isDisplayed();
	}
	public static void select_country_code_dropdown(String locaterKey){
		getElement(locaterKey).click();
	}
	
	public static void country_code_selector(String locaterKey){
		getElement(locaterKey).click();
	}
	
	public static void mobileNumber_text_in_TextBox(String locaterKey){
		getElement(locaterKey).isDisplayed();
	}
	public static void enterMobileNumber_field(String locaterKey,String mobileNumber){
		getElement(locaterKey).sendKeys(webprop.getProperty(mobileNumber));
	}
	public static void emailoptional_text_isDisplayed(String locaterKey){
		getElement(locaterKey).isDisplayed();
	}
	public static void enter_Email_textbox(String locaterKey,String email){
		getElement(locaterKey).sendKeys(webprop.getProperty(email));
	}
	
	public static void password_textfiels_isDisplayed(String locaterKey){
		getElement(locaterKey).isDisplayed();
	}
	public static void password_textBoxText_isDisplayed(String locaterKey){
		getElement(locaterKey).isDisplayed();
	}
	public static void Enter_Password(String locaterKey,String password){
		getElement(locaterKey).sendKeys(webprop.getProperty(password));
	}
	public static void pwdAlertIcon_isDisplayed(String locaterKey){
		getElement(locaterKey).isDisplayed();
	}
	public static void pwdAlertText_isDisplayed(String locaterKey) {
		getElement(locaterKey).isDisplayed();
	}
	public static void verification_text_textfiled_isDisplayed(String locaterKey){
		getElement(locaterKey).isDisplayed();
	}
	
	public static void chargesInfo_textfield_isDislayed(String locaterKey){
		getElement(locaterKey).isDisplayed();
	}
	
	public static void continue_Button(String locaterKey){
		getElement(locaterKey).click();
	}
	
	public static void amazonLogo2(String locaterKey){
		getElement(locaterKey).isDisplayed();
	}
	
	public static void enterOTP_textfield_isDisplayed(String locaterKey){
		getElement(locaterKey).isDisplayed();
	}
	public static void resend_otp(String locaterKey){
		boolean otp=getElement(locaterKey).isEnabled();
		System.out.println("link is present "+otp);
	}
	
	public static Scanner scr;
	public static String otpValue=null;

	public static void oTP() {
		System.out.println("enterText");
		scr = new Scanner(System.in);
		otpValue = scr.next();

	}	
	
	public static void enterOTP(String locaterKey){
		getElement(locaterKey).sendKeys(otpValue);
	}
	
	public static void create_Account_Button(String locaterKey){
		getElement(locaterKey).click();
	}
	
	
	
	
	
	
	
	
	//wait to load method
	public static void iwait(){
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	}
	//to quit the browser
	public static void quit(){
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.close();
	}
	
	

	
	
	
	public static void main(String[] args) throws IOException, InterruptedException {
		init();
		launch("chromebrowser");
		log.info("Browser Launch");
		navigateurl("amazonurl");
		log.info("Searched amazon url");
		iwait();
		
		newCustomer_text("new_customer_text_xpath");
		signin_Button("start_hear_new_customer_xpath");
		log.info("entered signup window");
		iwait();
		
		createAccount_text_isDisplayed("creataccount_text_xpath");
		enterTex_yourName("enterYourName_textBox_id","enterYourName_text");
		iwait();
		log.info("Text entered");
		mobileNumber_textField_isDisplayed("mobile_number_textfield_xpath");
		
		
		select_country_code_dropdown("country_code_selecter_id");
		iwait();
		
		country_code_selector("country_Link_id");
		iwait();
		
		mobileNumber_text_in_TextBox("mobilenumber_in_textBox_xpath");
		
		enterMobileNumber_field("enterMobileNumber_textbox_id", "mobileNumber_int");
		iwait();
		
		emailoptional_text_isDisplayed("email(optional)_textfield_xpath");
		
		enter_Email_textbox("enterEmail_textBox_id", "email_string");
		iwait();
		
		
		password_textfiels_isDisplayed("password_textfield_xpath");
		
		password_textBoxText_isDisplayed("password_textBox_xpath");
		
		Enter_Password("password_TextBox_id", "Password_string");
		iwait();
		
		pwdAlertIcon_isDisplayed("password_allert_icon_isDisplayed_xpath");
		
		pwdAlertText_isDisplayed("password_allert_icon_isDisplayed_xpath");
		
		verification_text_textfiled_isDisplayed("text_Verification_isDisplayed_xpath");
		
		chargesInfo_textfield_isDislayed("text_chargesInfo_isDisplayed_xpath");
		
		continue_Button("Continue_signup_button_id");
		iwait();
		
		amazonLogo2("amazon_log_isDisplayed_xpath");
		
		enterOTP_textfield_isDisplayed("enterOTP_textField_isDisplayed_xpath");
		
		resend_otp("resend_otp_textField_isEnabled_id");
		oTP();
		
		Thread.sleep(20000);
		enterOTP("enterOTP_int_id");
		
		create_Account_Button("createYourAmazonAccount_Button_id");
		iwait();
		
		
		
		
		
		
		
		
		
		
		
//		quit();
	}

	

}
