package com.example.demo.controlAdvice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandlers {
	
	 @ExceptionHandler(value = NoDataException.class)
	   public ResponseEntity<Object> exception(NoDataException exception) {
	      return new ResponseEntity<>("No Data Exception", HttpStatus.NOT_FOUND);
	   }

}
