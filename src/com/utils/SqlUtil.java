package com.utils;

import java.lang.reflect.Field;
import java.util.Date;
/**
 *  date : 2018��3��27��	
 * author: jiangjiamin
 * 
 */
public class SqlUtil {
	
	public static String getSql(Object object) {
		StringBuilder str = new StringBuilder();
		//��ȡ�����
		Class clazz = (Class)object.getClass();
 		
		//��ȡ���Լ���
		Field[] fieldArray = clazz.getDeclaredFields();
		try {
			//�������Լ���
			for(Field field : fieldArray) {
				//����˽������Ҳ�������
				field.setAccessible(true);
				Object value = field.get(object);
				if(value != null) {
					
					//��ȡ���Ե�ֵ����
					Object valueObj = field.get(object);
					
					str.append( " and " +field.getName()+ " = " + getSqlByType(valueObj));
					
				}
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return str.toString();
		
	}
	
	//��������ƴ��sql���
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
