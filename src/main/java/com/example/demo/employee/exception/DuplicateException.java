package com.example.demo.employee.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.BAD_REQUEST)
public class DuplicateException extends RuntimeException{
    public DuplicateException(String message){

        super(message);
    }
}
