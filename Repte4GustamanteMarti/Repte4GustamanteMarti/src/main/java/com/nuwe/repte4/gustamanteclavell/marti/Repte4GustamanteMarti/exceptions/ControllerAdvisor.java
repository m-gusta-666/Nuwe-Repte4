package com.nuwe.repte4.gustamanteclavell.marti.Repte4GustamanteMarti.exceptions;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class ControllerAdvisor {

	
	
	@ExceptionHandler(MissingEntityException.class)
	public ResponseEntity<Object> missingEntityExceptionHandler(MissingEntityException e, WebRequest request) {
		Map<String,Object> body = new LinkedHashMap<>();
		
		body.put("timestamp",LocalDateTime.now());
		body.put("message",e.getMessage());
		return new ResponseEntity<>(body,HttpStatus.NOT_FOUND);
	}
	
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Object> handleValidationExceptions(
	  MethodArgumentNotValidException ex) {
	    Map<String, Object> body = new LinkedHashMap<>();
	    
	    body.put("timestamp",LocalDateTime.now());
	    body.put("message", "No s'ha introduït un cos vàlid a la petició");
	    
	    ex.getBindingResult().getAllErrors().forEach((error) -> {
	        String fieldName = ((FieldError) error).getField();
	        String errorMessage = error.getDefaultMessage();
	        body.put(fieldName, errorMessage);
	    });
	    return new ResponseEntity<>(body,HttpStatus.BAD_REQUEST);
	}
}
