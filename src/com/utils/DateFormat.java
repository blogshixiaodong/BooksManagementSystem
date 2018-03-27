package com.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *  date : 2018年3月27日	
 * author: jiangjiamin
 * 
 */
public class DateFormat {

	public static Date stringToDate(String str){
		//时间格式 --> String 转换为 Date
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			return sdf.parse(str);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	
	public static String dateToString(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			return sdf.format(date);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
}
