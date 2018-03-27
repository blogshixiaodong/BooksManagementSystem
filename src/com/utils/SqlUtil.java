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
		//获取类对象
		Class clazz = (Class)object.getClass();
 		
		//获取属性集合
		Field[] fieldArray = clazz.getDeclaredFields();
		try {
			//遍历属性集合
			for(Field field : fieldArray) {
				//设置私有属性也允许访问
				field.setAccessible(true);
				Object value = field.get(object);
				if(value != null) {
					
					//获取属性的值对象
					Object valueObj = field.get(object);
					
					str.append( " and " +field.getName()+ " = " + getSqlByType(valueObj));
					
				}
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return str.toString();
		
	}
	
	//根据类型拼接sql语句
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
