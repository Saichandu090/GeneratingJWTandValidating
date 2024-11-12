package com.chandu.security.jwt.exceptions;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler
{
    @ExceptionHandler(UserNotFoundException.class)
    public String userNotFoundException(UserNotFoundException e)
    {
        return e.getMessage();
    }
}
