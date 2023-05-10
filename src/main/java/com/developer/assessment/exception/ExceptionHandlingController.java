package com.developer.assessment.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.developer.assessment.dto.ErrorDto;

@ControllerAdvice
public class ExceptionHandlingController extends ResponseEntityExceptionHandler {

	@ExceptionHandler(MyInternalErrorException.class)
	public ResponseEntity<ErrorDto> handleException(MyInternalErrorException e) {
		return new ResponseEntity<>(ErrorDto.builder().code(e.getCode()).message(e.getMessage()).build(),
				e.getStatus());
	}
}
