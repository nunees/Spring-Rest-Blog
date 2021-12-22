package com.felipe.blog.exceptions;

// This is function will be called by the controller
public class UserException extends RuntimeException {
    public UserException(String message){
        super(message);
    }

    public UserException(String message, Throwable cause){
        super(message, cause);
    }
}
