package com.day5_1_Webelements;

import java.io.IOException;

import org.openqa.selenium.By;

public class TC_005_1 extends Base_Test_Webelements {

	public static void main(String[] args) throws IOException, InterruptedException {
		init();
		launch("chromebrowser");
		url("flipkarturl");
		// text_finding_username("login_username_textdisplayed_xpath");
		logInID("username_xpath", "username_text");
		logInPassword("userpassword_xpath","userpassword_text");
		logInButton("Login_Button_xpath");
		Thread.sleep(3000);
		flipkartSearch_text("flipkartsearchBox_xpath", "flipkart_text");
		searchButton("flipkart_search_button_xpath");
		
		Thread.sleep(3000);
		driver.findElement(By.xpath("//span[contains(text(),'TVs & Appliances')]")).click();
		Thread.sleep(2000);
		driver.findElement(By.linkText("Water Purifiers")).click();
		String ureal = driver.getCurrentUrl();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[contains(text(),'Kent Ace Plus 8 L RO + UV + UF + TDS Water Purifier')]")).click();
		
		/*Thread.sleep(2000);
		driver.switchTo().window("0");*/
		
		

	}

	

}
