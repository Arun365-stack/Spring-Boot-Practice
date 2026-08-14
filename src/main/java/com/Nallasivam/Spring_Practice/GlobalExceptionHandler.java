package com.Nallasivam.Spring_Practice;

import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(InvalidArgumentException.class)
	public ResponseEntity<String> handleInvalidArgumentexception(InvalidArgumentException ex){
		
		return ResponseEntity.badRequest().body(ex.getMessage());
	}
	
	@ExceptionHandler(AccountNotFoundException.class)
	public ResponseEntity<String> handleInvalidAccountnumberException(AccountNotFoundException ex){
		
		return ResponseEntity.badRequest().body(ex.getMessage());
	}
}
