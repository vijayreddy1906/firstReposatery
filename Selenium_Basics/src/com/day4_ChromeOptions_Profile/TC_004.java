package com.day4_ChromeOptions_Profile;

import java.io.IOException;

public class TC_004 extends Base_Test_ChromeOptions_Profile {

	public static void main(String[] args) throws IOException {

		init();
		laucher("chromebrowser");
		
		navigateURL("axisbankurl");
		driver.manage().window().maximize();
		
		
		
		
	}

}
