package com.utils;

import java.lang.reflect.Field;
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
					str.append(field.getName()+" = ?,");
					
				}
			}
			if(str.toString() == "") {
				
			}
			
			//�ж�ƴ�ӵ��ַ������һ���ַ��Ƿ�Ϊ ����
			if(',' == str.charAt(str.length() - 1 )) {
				str.deleteCharAt(str.length() - 1);
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		
		return null;
		
	}
}
