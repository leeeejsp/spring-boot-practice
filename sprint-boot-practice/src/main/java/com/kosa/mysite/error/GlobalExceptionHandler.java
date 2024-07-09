package com.kosa.mysite.error;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(CustomException.class)
	protected ResponseEntity<ErrorResponse> handle(CustomException e){
		return createErrorResponse(e.getHttpStatus(), e.getMessage());
	}
	
    private ResponseEntity<ErrorResponse> createErrorResponse(HttpStatus httpStatus, String message){
        return new ResponseEntity<>(
                ErrorResponse.of(httpStatus, message),
                httpStatus);
    }
}
