package com.ayuup.springboot.users.exception;

import java.util.Date;

public class ErrorDetails {
	
	private Date timestamp;
	private String errorMessage;
	private String requestDescription;
	
	
	public ErrorDetails(Date timestamp, String errorMessage, String requestDescription) {
		super();
		this.timestamp = timestamp;
		this.errorMessage = errorMessage;
		this.requestDescription = requestDescription;
	}
	
	
	public Date getTimestamp() {
		return timestamp;
	}
	public String getErrorMessage() {
		return errorMessage;
	}
	public String getRequestDescription() {
		return requestDescription;
	}
	
	
}
