package com.rememory.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler(CustomException.class)
    public ResponseEntity<ErrorResponse> customExceptionHandler(CustomException customException) {
        log.error(customException.getErrorCode().getErrorMessage() + " occurred!");
        return ResponseEntity.badRequest()
                             .body(ErrorResponse.of(customException, HttpStatus.BAD_REQUEST));
    }
}
