package com.eTrymasters.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalHandlerException 

{
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<?> resourceNotFoundException(ResourceNotFoundException ex ,WebRequest request)
	{
		ErrorDetails erdetails= new ErrorDetails(new Date(), ex.getMessage(), request.getDescription(false));
		return new ResponseEntity<>(erdetails, HttpStatus.NOT_FOUND);
	}
     
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<?> globalHandlerException(Exception ex ,WebRequest request)
	{
		ErrorDetails erdetails= new ErrorDetails(new Date(), ex.getMessage(), request.getDescription(false));
		return new ResponseEntity<>(erdetails, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	

}
