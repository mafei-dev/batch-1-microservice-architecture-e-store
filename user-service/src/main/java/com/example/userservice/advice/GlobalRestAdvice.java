//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.example.userservice.advice;

import com.example.userservice.exception.UserAlreadyExistException;
import com.example.userservice.exception.UserNotFoundException;
import com.example.userservice.util.ErrorResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalRestAdvice {
    private static final Logger log = LoggerFactory.getLogger(GlobalRestAdvice.class);

    public GlobalRestAdvice() {
    }

    @ExceptionHandler({Exception.class, RuntimeException.class})
    public ResponseEntity<ErrorResponse> handleException(Exception exception) {
        log.error("exception : {}", exception.getMessage());
        return ResponseEntity.internalServerError().body(ErrorResponse.builder().errorMsg(exception.getMessage()).errorCode(HttpStatus.INTERNAL_SERVER_ERROR.toString()).build());
    }

    @ExceptionHandler({UserNotFoundException.class})
    public ResponseEntity<ErrorResponse> handleUserNotFoundException(UserNotFoundException exception) {
        log.error("exception : {}", exception.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ErrorResponse.builder().errorMsg(exception.getMessage()).errorCode(HttpStatus.NOT_FOUND.toString()).build());
    }

    @ExceptionHandler({UserAlreadyExistException.class})
    public ResponseEntity<ErrorResponse> handleUserAlreadyExistException(UserAlreadyExistException exception) {
        log.error("exception : {}", exception.getMessage());
        return ResponseEntity.status(HttpStatus.ALREADY_REPORTED).body(ErrorResponse.builder().errorMsg(exception.getMessage()).errorCode(HttpStatus.ALREADY_REPORTED.toString()).build());
    }
}
