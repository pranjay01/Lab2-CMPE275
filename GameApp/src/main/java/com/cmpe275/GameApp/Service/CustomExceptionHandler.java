package com.cmpe275.GameApp.Service;

import javax.persistence.EntityNotFoundException;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(DataIntegrityViolationException.class)
	public final ResponseEntity<ErrorDetails> handleDataIntegrityViolation(DataIntegrityViolationException ex, WebRequest request) {
		ErrorDetails errorDetails = new ErrorDetails("Data Integrity Violation, duplicate or invalid field");
		return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(EntityNotFoundException.class)
	public ResponseEntity<ErrorDetails> handleNotFound(EntityNotFoundException ex) {
		ErrorDetails errorDetails = new ErrorDetails("Resource not found");
		return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(EmptyResultDataAccessException.class)
	public ResponseEntity<ErrorDetails> handleNotFound(EmptyResultDataAccessException ex) {
		ErrorDetails errorDetails = new ErrorDetails("Resource not found");
		return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
	}

}
