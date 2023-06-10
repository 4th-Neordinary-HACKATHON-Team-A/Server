package com.rememory.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Getter
public class ErrorResponse {
    private final int code;
    private final String errorMessage;
    private final LocalDateTime timestamp;

    public ErrorResponse(CustomException exception, HttpStatus httpStatus) {
        this.code = httpStatus.value();
        this.errorMessage = exception.getErrorCode().getErrorMessage();
        this.timestamp = LocalDateTime.now();
    }

    public static ErrorResponse of(CustomException exception, HttpStatus httpStatus) {
        return new ErrorResponse(exception, httpStatus);
    }
}
