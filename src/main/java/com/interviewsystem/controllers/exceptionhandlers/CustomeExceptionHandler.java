package com.interviewsystem.controllers.exceptionhandlers;

import com.interviewsystem.models.exceptions.InvalidDataException;
import com.interviewsystem.models.response.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.Instant;

@RestControllerAdvice
public class CustomeExceptionHandler {

    @ExceptionHandler(InvalidDataException.class)
    public ResponseEntity<ErrorResponse> handleException(InvalidDataException e){
        ErrorResponse errorResponse = new ErrorResponse(Instant.now(), e.getMessage(),e.getCode());

        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }
}
