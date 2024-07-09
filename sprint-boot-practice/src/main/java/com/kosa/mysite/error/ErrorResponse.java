package com.kosa.mysite.error;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ErrorResponse {
	private LocalDateTime localDateTime;
    private String status;
    private String message;
    private int errorCode;

    // 기본 생성자와 getter/setter 생략

    public static ErrorResponse of(HttpStatus status, String message) {
    	
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setLocalDateTime(LocalDateTime.now());
        errorResponse.setStatus(status.getReasonPhrase());
        if(message == null || message.equals("")) {
        	errorResponse.setMessage(status.getReasonPhrase());
        }else {
        	errorResponse.setMessage(message);
        }
        errorResponse.setErrorCode(status.value());
        // errorCode는 필요에 따라 추가적으로 설정할 수 있음
        return errorResponse;
    }
}
