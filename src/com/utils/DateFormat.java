package com.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.bms.exception.BookException;
import com.bms.exception.ErrorList;

/**
 *  date : 2018��3��27��	
 * author: jiangjiamin
 * 
 */
public class DateFormat {

	public static Date stringToDate(String str) throws BookException{
		
		if(str == null) {
			return null;
		}
		
		//ʱ���ʽ --> String ת��Ϊ Date
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
