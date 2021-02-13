package com.test.apiemployee.config;

import java.util.HashMap;
import java.util.Map;

import org.hibernate.TypeMismatchException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.support.WebExchangeBindException;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.test.apiemployee.exception.ResourceNotFoundException;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

	@Override
	protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		String error = "Malformed JSON request";
	    return buildResponseEntity((new ResponseError(HttpStatus.BAD_REQUEST, error, ex)));
	}   

    private ResponseEntity<Object> buildResponseEntity(ResponseError responseError) {
       return new ResponseEntity<>(responseError, responseError.getStatus());
    }
   
   @ExceptionHandler(ResourceNotFoundException.class)
   protected ResponseEntity<Object> handleResourceNotFoundException(
		   ResourceNotFoundException ex) {
	   HttpStatus httpStatus = HttpStatus.NOT_FOUND;
	   ResponseError responseError = new ResponseError(httpStatus, ex);
       responseError.setMessage(httpStatus.getReasonPhrase());
       return buildResponseEntity(responseError);
   } 
   
   
   @Override
   protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
       Map<String, String> errors = new HashMap<>();
       ex.getBindingResult().getAllErrors().forEach(error -> {
           String fieldName = ((FieldError) error).getField();
           String errorMessage = error.getDefaultMessage();
           errors.put(fieldName, errorMessage);
       });
       
       ResponseError responseError = new ResponseError(HttpStatus.BAD_REQUEST, ex);
       responseError.setMessage(HttpStatus.BAD_REQUEST.getReasonPhrase());
       responseError.setErrors(errors);
       return buildResponseEntity(responseError);
   }
   
   @ExceptionHandler(TypeMismatchException.class)
   protected ResponseEntity<Object> handleTypeMismatchException(
		   TypeMismatchException e) {
	   return buildResponseEntity(new ResponseError(HttpStatus.BAD_REQUEST, "Invalid value '${e.value}'", e));
   }

   @ExceptionHandler(WebExchangeBindException.class)
   protected ResponseEntity<Object> handleWebExchangeBindException(WebExchangeBindException e) {
	   return buildResponseEntity(new ResponseError(HttpStatus.BAD_REQUEST, "${fieldError?.field} has invalid value '${fieldError?.rejectedValue}'", e));
   }
}

