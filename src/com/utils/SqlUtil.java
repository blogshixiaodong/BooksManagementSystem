package com.utils;

import java.lang.reflect.Field;
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
					str.append(field.getName()+" = ?,");
					
				}
			}
			if(str.toString() == "") {
				
			}
			
			//判断拼接的字符串最后一个字符是否为 逗号
			if(',' == str.charAt(str.length() - 1 )) {
				str.deleteCharAt(str.length() - 1);
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		
		return null;
		
	}
}
