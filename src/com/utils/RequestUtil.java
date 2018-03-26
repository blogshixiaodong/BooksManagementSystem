package com.utils;

import java.lang.reflect.Field;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;

/**
 *  date : 2018年3月27日	
 * author: jiangjiamin
 * 
 */
public class RequestUtil {
	
	public static <T> T getParamsInjectObj(HttpServletRequest request,Class<T> clazz) {
		//获取表单提交所有参数名
		Enumeration<String> paramNmaes = request.getParameterNames();
		T object = null;
		try {
			//创建泛型对象
			object = clazz.newInstance();
			
			//循环为每个字段赋值
			while(paramNmaes.hasMoreElements()) {
				String param = paramNmaes.nextElement();
				Field field = clazz.getDeclaredField(param);
				
				field.setAccessible(true);
				//将表单获取到的String类型参数值转化为 类中对应的类型
				setParam(field, object, request.getParameter(param));
			
			}
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		return object;
			
	}

	public static void  setParam(Field field,Object object,String value) throws Exception {
		String type = field.getType().toString();
		if(type.equals("class java.lang.String")){
			field.set(object, value.toString() );
		}else if(type.equals("class java.lang.Integer")){
			field.set(object, Integer.parseInt((String)value) );
		}else if(type.equals("class java.lang.Float")){
			field.set(object, Float.parseFloat((String)value ) );
		}else if(type.equals("class java.util.Date")) {
			
			field.set(object,stringToDate(value));
		}
	}
	
	private static Date stringToDate(String str) throws ParseException {
		//时间格式 --> String 转换为 Date
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		return sdf.parse(str);
	}


}
