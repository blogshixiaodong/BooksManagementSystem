package com.utils;

import java.lang.reflect.Field;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;

/**
 *  date : 2018��3��27��	
 * author: jiangjiamin
 * 
 */
public class RequestUtil {
	
	public static <T> T getParamsInjectObj(HttpServletRequest request,Class<T> clazz) {
		//��ȡ���ύ���в�����
		Enumeration<String> paramNmaes = request.getParameterNames();
		T object = null;
		try {
			//�������Ͷ���
			object = clazz.newInstance();
			
			//ѭ��Ϊÿ���ֶθ�ֵ
			while(paramNmaes.hasMoreElements()) {
				String param = paramNmaes.nextElement();
				Field field = clazz.getDeclaredField(param);
				
				field.setAccessible(true);
				//������ȡ����String���Ͳ���ֵת��Ϊ ���ж�Ӧ������
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
		//ʱ���ʽ --> String ת��Ϊ Date
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		return sdf.parse(str);
	}


}
