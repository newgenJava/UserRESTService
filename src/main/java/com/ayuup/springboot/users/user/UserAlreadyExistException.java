package com.ayuup.springboot.users.user;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class UserAlreadyExistException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4811977906416465556L;

	public UserAlreadyExistException(String message) {
		super(message);
	}
	
}
