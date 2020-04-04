package com.rav.springbootdemo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javassist.NotFoundException;

@RestControllerAdvice
public class GlobalExceptionAdvisor {

	@ExceptionHandler(Exception.class)
    public final ResponseEntity<String> handleAllExceptions() {
		return new ResponseEntity<>("Error", HttpStatus.INTERNAL_SERVER_ERROR);
    }

	@ExceptionHandler(NotFoundException.class)
    public final ResponseEntity<String> handleNotFoundException() {
		return new ResponseEntity<>("Not found", HttpStatus.NOT_FOUND);	
    }
}
