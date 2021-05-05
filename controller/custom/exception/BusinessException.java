package com.example.demo.controller.custom.exception;

import org.springframework.stereotype.Component;

@Component
public class BusinessException extends RuntimeException{
	
	private static final long serialVersionUID = 1L;
	private String errorCode;
	private String errorMessage;
	
	public BusinessException() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public BusinessException(String errorCode, String errorMessage) {
		super();
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
	}

	public String getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
