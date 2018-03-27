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

	public static Date stringToDate(String str) throws BookException{
		
		if(str == null) {
			return null;
		}
		
		//时间格式 --> String 转换为 Date
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			return sdf.parse(str);
		} catch (ParseException e) {
			//e.printStackTrace();
			throw new BookException(ErrorList.DATE_FORMAT_ERROR);
		}
		//return null;
	}
	
	
	public static String dateToString(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		return sdf.format(date);

	}
	
}
