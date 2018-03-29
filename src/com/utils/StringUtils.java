package com.utils;
/*
 * date:   2018年3月25日 下午10:33:07
 * author: Shixiaodong
 */
public class StringUtils {

	public static boolean isNullOrEmpty(String str) {
		return str == null || str.length() == 0;
	}
	
	public static boolean isNumber(String str) {
		try {
			Integer.parseInt(str);
		} catch(NumberFormatException e) {
			return false;
		}
		return true;
	}
	
	public static boolean isNull(Object obj) {
		return obj == null;
	}
}
