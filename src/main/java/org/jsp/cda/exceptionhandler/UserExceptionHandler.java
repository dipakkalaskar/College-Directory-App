package org.jsp.cda.exceptionhandler;

import org.jsp.cda.exceptionclasses.UserNotFoundException;
import org.jsp.cda.responsestructure.ResponseStructure;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class UserExceptionHandler {
	
	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<?> handleUserNotFoundException(UserNotFoundException e){
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ResponseStructure.builder().status(HttpStatus.BAD_REQUEST.value()).message("User Not Found...").body(e.getMessage()).build());
	}
	
}
