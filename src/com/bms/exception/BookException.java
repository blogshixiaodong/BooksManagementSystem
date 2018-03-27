package com.bms.exception;

import java.sql.SQLException;



public class BookException extends SQLException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String content;

	public BookException(){}
	
	public BookException(String message) {
		content = message;
	}
	
	/*private String handlerMessages(String message) {
		if(message.contains("cannot be null")) {
			message = message.substring(6, message.length());
		}
		
		return message;
	}*/
	
	public void setContent(String message) {
		content = message;
	}
	
	public String getContent() {
		return content;
	}
	
	
	
}
