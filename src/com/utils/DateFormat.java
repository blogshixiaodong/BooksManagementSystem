package com.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.bms.exception.BookException;
import com.bms.exception.ErrorList;

/**
 *  date : 2018年3月27日	
 * author: jiangjiamin
 * 
 */
public class DateFormat {

	//时间格式转换 String --> Date
	public static Date stringToDate(String str) throws BookException{
		if(str == null) {
			return null;
		}
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			return sdf.parse(str);
		} catch (ParseException e) {
			throw new BookException(ErrorList.DATE_FORMAT_ERROR);
		}
	}
	
	//date 类型转  string
	public static String dateToString(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		return sdf.format(date);

	}
	
}
