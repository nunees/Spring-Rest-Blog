package com.felipe.blog.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.ZoneId;
import java.time.ZonedDateTime;

@ControllerAdvice
public class UserExceptionHandler {

    @ExceptionHandler(value = {UserException.class})
    public ResponseEntity<Object> handleCannotAddUser(UserException e){
        //1. Create payload containing exception and details
        HttpStatus badRequest = HttpStatus.BAD_REQUEST;
        APIException apiException = new APIException(e.getMessage(),
                badRequest,
                ZonedDateTime.now(ZoneId.of("Z")));
        //2. Return response entity
        return new ResponseEntity<>(apiException,badRequest);
    }
}
