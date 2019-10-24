package Base;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.relevantcodes.extentreports.ExtentReports;

public class ExtantManager extends BaseClass {
	public static ExtentReports report;
	
	public static ExtentReports getReport(){
		
		if (report==null) {
			Date dt=new Date();
			SimpleDateFormat date=new SimpleDateFormat("YYYY-MM-dd_HH-mm-ss");
			String fileName=date.format(dt).toString()+".html";
			report=new ExtentReports(projectDir+"./target/extenr_report/"+fileName);
			report.loadConfig(new File(projectDir+"\\src\\main\\java\\Config\\extentreport.xml"));
		}
		return report;
	}

}
