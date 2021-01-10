package com.org.exceptions;

public class WeatherServiceException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String message;
	
	private String errorCode;
	
	public WeatherServiceException(String message, String errorCode) {
		this.message = message;
		this.setErrorCode(errorCode);
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	
	

}
