package com.ayuup.springboot.users.exception;

import java.util.Date;

public class ErrorDetails {

	private Date timestamp;
	private String errorMessage;
	private String requestDescription;
	private int id;

	public ErrorDetails(Date timestamp, String errorMessage, String requestDescription) {
		super();
		this.timestamp = timestamp;
		this.errorMessage = errorMessage;
		this.requestDescription = requestDescription;
	}

	public ErrorDetails(Date timestamp, String errorMessage, String requestDescription, int id) {
		super();
		this.timestamp = timestamp;
		this.errorMessage = errorMessage;
		this.requestDescription = requestDescription;
		this.id = id;
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

	public int getId() {
		return id;
	}

}
