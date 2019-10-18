package com.day7_ExtentReports_Listoners;

import java.io.File;
import java.util.Date;

import com.relevantcodes.extentreports.ExtentReports;

public class Example extends Base_Test {
	
	public static ExtentReports report;
	
	public static ExtentReports getreports(){
		if (report==null) {
			Date date = new Date();
			String filepath = date.toString().replace(" ", "_").replace(" ", "_") + ".html";
			System.out.println(filepath);
			report = new ExtentReports(projectPath + "//Html report//" + filepath);
			report.loadConfig(new File(
					"C:\\Users\\User\\git\\firstReposatery\\Selenium_Basics\\src\\com\\day7_ExtentReports_Listoners\\configer.xml"));
		}
		return report;
		
		
	}

	public static void main(String[] args) {
		
	}
}
