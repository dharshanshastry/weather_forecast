package com.org.exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class WeatherServiceExceptionHandler {

	@ExceptionHandler(value = { WeatherServiceException.class })
	protected ResponseEntity<Error> handleConflict(WeatherServiceException ex, WebRequest request) {
		return ResponseEntity.status(HttpStatus.BAD_REQUEST)
        .body(new Error(ex.getMessage(), ex.getErrorCode(), HttpStatus.BAD_REQUEST.toString()));
		
	}
}
