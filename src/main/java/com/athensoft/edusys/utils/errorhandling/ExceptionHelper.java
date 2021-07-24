package com.athensoft.edusys.utils.errorhandling;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.athensoft.edusys.error.exceptions.AlreadyExistsException;
import com.athensoft.edusys.error.exceptions.NotFoundException;
import com.athensoft.edusys.error.exceptions.StudentNotFoundException;


@ControllerAdvice
//@ControllerAdvice(annotations=RestController.class)
//@ControllerAdvice(basePackages = "com.prototype.error.controller")
//@ControllerAdvice(assignableTypes = {ErrorController.class})
public class ExceptionHelper {
	private static final Logger LOGGER = LoggerFactory.getLogger(ExceptionHelper.class);
	
	@ExceptionHandler(NotFoundException.class)
	public ResponseEntity<String> handleNotFoundException(NotFoundException exception) {
		LOGGER.error(exception.getMessage());
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(exception.getMessage());
	}
	
	@ExceptionHandler(AlreadyExistsException.class)
	public ResponseEntity<String> handlePersonNotFoundException(AlreadyExistsException exception) {
		LOGGER.error(exception.getMessage());
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(exception.getMessage());
	}
	
	
}
