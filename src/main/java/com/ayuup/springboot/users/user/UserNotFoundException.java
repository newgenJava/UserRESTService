package com.ayuup.springboot.users.user;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class UserNotFoundException extends RuntimeException {


	/**
	 * 
	 */
	private static final long serialVersionUID = -4981224309141950282L;

	public UserNotFoundException(String message) {
		super(message);
	}
}
