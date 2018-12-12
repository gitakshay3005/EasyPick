package com.rsi.easypick.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR, reason = "Error occurred while calling database")
public class DatabaseException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String errorMessage;
	
	public DatabaseException(String message) {
		errorMessage =  message;
	}
	
	public DatabaseException() {
	}
	
	
	public String getErrorMessage() {
		return errorMessage;
	}
	

}
