package com.testdvdrental.dvdrental.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(value = {APIException.class})
    public ResponseEntity<Object> handleAPIException(APIException e){
        ErrorDetails errorDetails = new ErrorDetails(
                new Date(),
                e.getMessage(),
                String.valueOf(HttpStatus.BAD_REQUEST.value())
        );
        return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = {ResourceNotFoundException.class})
    public ResponseEntity<Object> handleResourceNotFoundException(ResourceNotFoundException e){
        ErrorDetails errorDetails = new ErrorDetails(
                new Date(),
                e.getMessage(),
                String.valueOf(HttpStatus.NOT_FOUND.value())
        );
        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
    }
}
