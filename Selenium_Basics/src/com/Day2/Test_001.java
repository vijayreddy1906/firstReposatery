package com.Day2;

import java.io.IOException;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;

public class Test_001 extends Base_Test {
	public static void main(String[] args) throws IOException, InterruptedException {
		init();
		launch_browser("firefox");
		
		driver.manage().window().maximize();
		
		navigateURL("hdfcurl");
		
		FirefoxProfile profile=new FirefoxProfile();
		
		String uRL = driver.getCurrentUrl();
		System.out.println(uRL);
		
		/*Set<String> winhan = driver.getWindowHandles();
		System.out.println(winhan);*/
		
		/*Set<Cookie> cks = driver.manage().getCookies();
		System.out.println(cks);*/
		
		/*Class<? extends WebDriver> cls = driver.getClass();
		System.out.println(cls);*/
		
		/*String title = driver.getTitle();
		System.out.println(title);
		
		driver.manage().deleteAllCookies();
		
		driver.navigate().back();
		
		String title1 = driver.getTitle();
		System.out.println(title1);
		
		driver.navigate().forward();
		
		driver.navigate().refresh();
		
		driver.navigate().to(uRL);
		driver.manage().window().fullscreen();
		driver.manage().window().fullscreen();
		
		driver.manage().window().maximize();*/
		
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"parentdiv\"]/img")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"custom-button\"]/button")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("/html/body/div[1]/div/div/div[12]/div[3]/div/div/div/div/div[2]/div[2]/div[2]/div[3]/a[1]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("/html/body/div[4]/div[2]/div[1]/a")).click();
		
		
		
		
		
		
//		driver.close();
		
//		driver.quit();
	}
}
