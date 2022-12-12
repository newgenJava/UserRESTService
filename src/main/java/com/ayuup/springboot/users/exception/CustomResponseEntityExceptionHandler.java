package com.ayuup.springboot.users.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.ayuup.springboot.users.user.UserAlreadyExistException;
import com.ayuup.springboot.users.user.UserNotFoundException;


@RestController
@ControllerAdvice
public class CustomResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler
	public final ResponseEntity<Object> handleExceptions( Exception ex, WebRequest request) {
		
		
		ErrorDetails errorDetail = new ErrorDetails(
				new Date(), ex.getMessage(), request.getDescription(false));
		
		return new ResponseEntity<Object>(errorDetail, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(UserNotFoundException.class)
	public final ResponseEntity<Object> handleUserNotFoundException( Exception ex, WebRequest request) {
		
		ErrorDetails errorDetail = new ErrorDetails(
				new Date(), ex.getMessage(), request.getDescription(false));
		
		return new ResponseEntity<Object>(errorDetail, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(UserAlreadyExistException.class)
	public final ResponseEntity<Object> handleUserAlreadyExistException( UserAlreadyExistException ex, WebRequest request) {
		
		ErrorDetails errorDetail = new ErrorDetails(
				new Date(), ex.getMessage(), request.getDescription(false) + "/" + ex.getId());
		
		return new ResponseEntity<Object>(errorDetail, HttpStatus.BAD_REQUEST);
	}

}
