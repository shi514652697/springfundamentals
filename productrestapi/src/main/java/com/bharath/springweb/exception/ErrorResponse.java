package com.bharath.springweb.exception;

import org.springframework.http.HttpStatus;

import lombok.Getter;
import lombok.Setter;


public class ErrorResponse {

	private HttpStatus status;

	 public HttpStatus getStatus() {
		return status;
	}

	public void setStatus(HttpStatus status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	private String message;

	public ErrorResponse(HttpStatus status, String message) {
		
		this.status = status;
		this.message = message;
	}
	
	
	

}
