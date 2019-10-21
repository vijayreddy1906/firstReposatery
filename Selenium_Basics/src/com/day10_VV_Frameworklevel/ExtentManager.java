package com.day10_VV_Frameworklevel;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.relevantcodes.extentreports.ExtentReports;

public class ExtentManager extends Class10_Verification_Validation_Framework_Level{

	public static ExtentReports report;
	public static ExtentReports getReport(){
		
		if (report==null) {
			Date dt=new Date();
			SimpleDateFormat date=new SimpleDateFormat("YYYY-MM-dd_HH-mm-ss");
			String srcFile=date.format(dt).toString()+".html";
			report=new ExtentReports("C:\\Users\\User\\Documents\\GitHub\\firstReposatery\\Selenium_Basics\\EXTENTREPORTS\\day10\\"+srcFile);
			report.loadConfig(new File("C:\\Users\\User\\Documents\\GitHub\\firstReposatery\\Selenium_Basics\\src\\com\\day10_VV_Frameworklevel\\ExtentReport.xml"));
		}
		return report;
	}
}
