package com.day10_VV_Frameworklevel;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Test {
	public static void main(String[] args) {
		Date dat=new Date();
		SimpleDateFormat sdate=new SimpleDateFormat("YY-MM-dd_HH-mm-ss");
		System.out.println(sdate.format(dat).toString());
	}

}
