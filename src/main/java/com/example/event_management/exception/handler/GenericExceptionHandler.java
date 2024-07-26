package com.example.event_management.exception.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.event_management.exception.EventException;
import com.example.event_management.response.CommonResponse;

@RestControllerAdvice
public class GenericExceptionHandler {

	@ExceptionHandler(value = {EventException.class})
	public ResponseEntity<CommonResponse<Integer>> employeeExceptionHandler(EventException e){
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(CommonResponse.<Integer>builder()
				.isError(true).data(null).message(e.getMessage()).build());
	}
}
