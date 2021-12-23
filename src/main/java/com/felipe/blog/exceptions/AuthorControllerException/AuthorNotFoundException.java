package com.felipe.blog.exceptions.AuthorControllerException;

public class AuthorNotFoundException extends RuntimeException{
    public AuthorNotFoundException(String message){
        super(message);
    }

    public AuthorNotFoundException(String message, Throwable cause){
        super(message,cause);
    }
}
