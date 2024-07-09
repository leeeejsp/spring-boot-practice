package com.kosa.mysite.error;

import org.springframework.http.HttpStatus;

import lombok.Getter;

@Getter
public class CustomException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	private final HttpStatus httpStatus;
	
    public CustomException(String message, HttpStatus httpStatus) {
        super(message);
        this.httpStatus = httpStatus;
    }

    public CustomException(HttpStatus httpStatus) {
        super();
        this.httpStatus = httpStatus;
    }

}
