package com.utils;

import java.lang.reflect.Field;
import java.util.Date;

/**
 *  date : 2018年3月27日	
 * author: jiangjiamin
 * 
 */
public class SqlUtil {
	
	private static String[] nameArray = {"bname"};
	
	public static String getSql(Object object) {
		StringBuilder str = new StringBuilder();	
		Class<?> clazz = (Class<?>)object.getClass();		
		//获取所有属性
		Field[] fieldArray = clazz.getDeclaredFields();
		try {
			for(Field field : fieldArray) {
				//设置私有属性允许访问
				field.setAccessible(true);
				//获取对象的属性的值
				Object value = field.get(object);
				if(value != null) {
					str.append( " and " +field.getName()+ getSqlByType(value,field.getName()));
				}
			}	
		}catch (Exception e) {
			e.printStackTrace();
		}
		return str.toString();
	}
	
	//根据类型拼接字符串
	private static String getSqlByType(Object object,String name) {
		String sql = "";
		if(object instanceof String) {
			//匹配查看是否是需要模糊查询的字段
			if(isLikeRetrieve(name)) {
				sql = " LIKE '%"+object.toString()+"%' ";
			}else {
				sql = " = '" + object.toString() + "' ";
			}
		}else if(object instanceof Integer) {
			sql = sql + " = "+object;
		}else if(object instanceof Date) {
			sql = " = '" + DateFormat.dateToString((Date)object) + "' ";
		}
		return sql;
	}
	
	//该字段是否需要模糊查询
	private static boolean isLikeRetrieve(String name) {
		for(String temp : nameArray) {
			if(temp.equals(name)) {
				return true;
			}
		}
		return false;
	}
	
	//设置需要模糊的字段的数组
	public static void setNameArray(String[] nameArray) {
		SqlUtil.nameArray = nameArray;
	}

}
