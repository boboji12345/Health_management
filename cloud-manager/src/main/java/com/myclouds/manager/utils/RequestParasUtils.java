package com.myclouds.manager.utils;

import java.math.BigDecimal;
import java.net.URLDecoder;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

public class RequestParasUtils {

	public static int getIntFromStr(String str) {
		int endi=0;
		if(str.equals(""))
			endi = Integer.parseInt(endi+"");
		else
			endi = Integer.parseInt(str);

		return endi;
	}

	public static BigDecimal getDecimalFromStr(String str) {
		float aa = 0;
		BigDecimal decimal;
		if(str.equals(""))
			decimal = BigDecimal.valueOf(Float.parseFloat("0"));
		else
			decimal = BigDecimal.valueOf(Float.parseFloat(str));

		return decimal;
	}

	public static String getJspStringParameters(String parameter,HttpServletRequest request) throws Exception {
		String str = request.getParameter(parameter).trim();
		str = URLDecoder.decode(str,"UTF-8");
		return str;
	}

	public static int getJspIntegerParameters(String parameter,HttpServletRequest request) {
		int id =0;
		if(!request.getParameter(parameter).trim().equals(""))
			id = Integer.parseInt(request.getParameter(parameter).trim());
		return id;
	}

	public static int getJspIntegerParameters1(String parameter,HttpServletRequest request) {
		int id =1;
		if(!request.getParameter(parameter).trim().equals(""))
			id = Integer.parseInt(request.getParameter(parameter).trim());
		return id;
	}

	public static Timestamp timestampDate(){
		return strFormatTimetamp(returnDateTimeStr());
	}

	public static String shijianchuo(){
		return System.currentTimeMillis()+"";
	}

	public static String returnDateTimeStr(){
		DateFormat df2 = DateFormat.getDateTimeInstance();
       return df2.format(new Date());
	}

	private static Timestamp strFormatTimetamp(String str){
	    DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
	    format.setLenient(false);
	    try {
		    Timestamp ts = new Timestamp(format.parse(str).getTime());
		    return ts;
	    } catch (Exception e) {
	     e.printStackTrace();
	     return null;
	    }
	}


}
