package com.utils;

import java.lang.reflect.Field;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;

import com.bms.exception.BookException;
import com.bms.exception.ErrorList;


/**
 *  date : 2018年3月27日	
 * author: jiangjiamin
 * 
 */
public class RequestUtil {
	
	public static <T> T getParamsInjectObj(HttpServletRequest request,Class<T> clazz)   {
		//获取所有的表单变量名
		Enumeration<String> paramNmaes = request.getParameterNames();
		T object = null;
		try {
			//实例化对象
			object = clazz.newInstance();
			
			//ֵ
			while(paramNmaes.hasMoreElements()) {
 				String param = paramNmaes.nextElement();
				Field field = clazz.getDeclaredField(param);
				
				field.setAccessible(true);
				//根据类型为对象属性赋值
				setParam(field, object, request.getParameter(param));
			}
		}catch (BookException e) {
			request.getSession().setAttribute("excep", e);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return object;	
	}

	public static void  setParam(Field field,Object object,String value) throws BookException {
		String type = field.getType().toString();
		
		try {
			//if value = null  return;
			if("".equals(value)) {
				field.set(object,null);
				return;
			}
			
			if(type.equals("class java.lang.String")){
				field.set(object, value);
			}else if(type.equals("class java.lang.Integer") ){
				field.set(object, Integer.parseInt(value) );
			}else if(type.equals("class java.lang.Float")){
				field.set(object, Float.parseFloat(value ) );
			}else if(type.equals("class java.util.Date")) {
				
				field.set(object,DateFormat.stringToDate(value));
			}
		}catch (IllegalArgumentException | IllegalAccessException e) {
			e.printStackTrace();
		}
	}
	
	


}
