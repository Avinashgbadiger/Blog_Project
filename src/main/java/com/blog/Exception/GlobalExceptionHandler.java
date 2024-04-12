package com.blog.Exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.blog.utils.ApiResponse;

import jakarta.el.MethodNotFoundException;

@RestControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ApiResponse> resourceNotFoundException(ResourceNotFoundException ex) {
		String message = ex.getMessage();
		ApiResponse apiResponse = new ApiResponse(message, false);
		return new ResponseEntity<ApiResponse>(apiResponse, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(value = MethodNotFoundException.class)
	public ResponseEntity<ApiResponse> notValidException(ResourceNotFoundException ex) {
		String message = ex.getMessage();
		ApiResponse apiResponse = new ApiResponse(message, false);
		return new ResponseEntity<ApiResponse>(apiResponse, HttpStatus.NOT_FOUND);

	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	 public ResponseEntity<Map<String,String>> handleValidException(MethodArgumentNotValidException ex)
	 {
		Map<String,String> map=new HashMap<>();
		 ex.getAllErrors().forEach((e)->{
			 String field = ((FieldError)e).getField();
			 String defaultMessage = e.getDefaultMessage();
			 map.put(field, defaultMessage);
		 });
		 return new ResponseEntity<Map<String,String>>(map,HttpStatus.NOT_ACCEPTABLE);
	 }
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ApiResponse> allException(Exception ex)
	{
		String message = ex.getMessage();
		ApiResponse apiResponse = new ApiResponse(message, false);
		return new ResponseEntity<ApiResponse>(apiResponse,HttpStatus.NOT_ACCEPTABLE);
	}

}
