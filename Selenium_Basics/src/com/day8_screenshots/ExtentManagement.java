package com.day8_screenshots;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.relevantcodes.extentreports.ExtentReports;

public class ExtentManagement  {
	
	public static ExtentReports repor;
	
	public static ExtentReports getReport(){

		if (repor==null) {
			Date dt=new Date();
			SimpleDateFormat date=new SimpleDateFormat("YY_MM_dd_HH_mm_ss");
			String filepath=date.format(dt).toString()+"_ExtentReport.html";
			repor=new ExtentReports("C:\\Users\\User\\git\\firstReposatery\\Selenium_Basics\\ScreenShots\\com.day8_screenshots\\"+filepath);
			repor.loadConfig(new File("\\Users\\User\\git\\firstReposatery\\Selenium_Basics\\src\\com\\day8_screenshots\\extentreport.xml"));
		}
		return repor;
		
	}

}
