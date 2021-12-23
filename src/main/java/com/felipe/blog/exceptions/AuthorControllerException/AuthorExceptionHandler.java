package com.felipe.blog.exceptions.AuthorControllerException;

import com.felipe.blog.exceptions.APIException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.ZoneId;
import java.time.ZonedDateTime;

@ControllerAdvice
public class AuthorExceptionHandler {

    @ExceptionHandler(value = {AuthorNotFoundException.class})
    public ResponseEntity<Object> handleAuthorNotFoundException(AuthorNotFoundException a){
        HttpStatus badRequest = HttpStatus.NOT_FOUND;
        APIException apiException = new APIException(a.getMessage(), badRequest, ZonedDateTime.now(ZoneId.of("Z")));
        return new ResponseEntity<>(apiException,badRequest);
    }
}
