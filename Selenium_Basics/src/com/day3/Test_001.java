package com.day3;

import java.io.IOException;

import org.openqa.selenium.By;

public class Test_001 extends com.day3.Practice_1 {

	public static void main(String[] args) throws IOException, InterruptedException {
		init();
		
		
		launch("firefoxbrowser");
		
		
		navigateURL("hdfcurl");
		
		
		Thread.sleep(3000);
		driver.findElement(By.xpath("//img[@class='popupCloseButton']")).click();;
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@class='hero-carousel-container slick-initialized slick-slider slick-dotted']//button[@class='slick-next slick-arrow'][contains(text(),'Next')]")).click();
		Thread.sleep(500);
		driver.findElement(By.xpath("//div[@class='hero-carousel-container slick-initialized slick-slider slick-dotted']//button[@class='slick-next slick-arrow'][contains(text(),'Next')]")).click();
		Thread.sleep(500);
		driver.findElement(By.xpath("//div[@class='hero-carousel-container slick-initialized slick-slider slick-dotted']//button[@class='slick-next slick-arrow'][contains(text(),'Next')]")).click();
		Thread.sleep(500);
		driver.findElement(By.xpath("//div[@class='hero-carousel-container slick-initialized slick-slider slick-dotted']//button[@class='slick-next slick-arrow'][contains(text(),'Next')]")).click();
		
		
		
		
		
		
	}

}
