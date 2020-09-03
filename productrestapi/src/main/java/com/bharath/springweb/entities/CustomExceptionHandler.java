package com.bharath.springweb.entities;

import java.util.stream.Collectors;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.bharath.springweb.exception.ErrorResponse;

@RestControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {
	
	 private static final Logger LOG = LoggerFactory.getLogger(CustomExceptionHandler.class);
	 
	 @Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		 
		 String errorMessage= ex.getBindingResult().getAllErrors().stream().
				 map(ObjectError::getDefaultMessage).collect(Collectors.joining(","));
		 ErrorResponse error = new ErrorResponse(HttpStatus.BAD_REQUEST, errorMessage);
		//return super.handleMethodArgumentNotValid(ex, headers, status, request);
		 return handleExceptionInternal(ex, error, headers, status, request);
	}

}
