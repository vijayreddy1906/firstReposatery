package com.day5;

import java.io.IOException;

import org.openqa.selenium.By;

public class TC_005 extends Base_Test_With_Elements{

	public static void main(String[] args) throws IOException {
		init();
		
		launch("chromebrowser");
		navigateURL("amazonurl");
		select_Options("amazonsearchdopdown_id", "amazondropdownvalue");
		type_Text("amazontextbox_xpath", "amazontext");
		click_Element("amazonsearchbutton_xpath");
		driver.findElement(By.xpath("//span[contains(text(),'Harry Potter Paperback Box Set (Books 1-7)')]")).click();
	}

}
