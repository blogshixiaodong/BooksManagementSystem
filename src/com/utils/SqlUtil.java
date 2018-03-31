package com.utils;

import java.lang.reflect.Field;
import java.util.Date;

/**
 *  date : 2018年3月27日	
 * author: jiangjiamin
 * 
 */
public class SqlUtil {
	
	public static String getSql(Object object) {
		StringBuilder str = new StringBuilder();
		
		Class<?> clazz = (Class<?>)object.getClass();
 		
		//获取所有属性
		Field[] fieldArray = clazz.getDeclaredFields();
		try {
			
			for(Field field : fieldArray) {
				//设置私有属性允许访问
				field.setAccessible(true);
				Object value = field.get(object);
				if(value != null) {
					
					//获取对象属性值
					Object valueObj = field.get(object);
					
					str.append( " and " +field.getName()+ " = " + getSqlByType(valueObj));
					
				}
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return str.toString();
		
	}
	
	//根据类型拼接字符串
	private static String getSqlByType(Object object) {
		String sql = "";
		if(object instanceof String) {
			sql = " '" + object.toString() + "' ";
		}else if(object instanceof Integer) {
			sql = sql+object;
		}else if(object instanceof Date) {
			sql = " '" + DateFormat.dateToString((Date)object) + "' ";
		}
		
		return sql;
	}
	
	
}
