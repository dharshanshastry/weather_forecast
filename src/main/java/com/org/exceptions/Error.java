package com.org.exceptions;

import java.util.Date;

public class Error {
	
	private String errorCode;
	
	private String message;
	
	private String status;
	
	private Date date = new Date();

	public Error(String message, String errorCode, String status) {
		this.message = message;
		this.errorCode = errorCode;
		this.status = status;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
	

}
