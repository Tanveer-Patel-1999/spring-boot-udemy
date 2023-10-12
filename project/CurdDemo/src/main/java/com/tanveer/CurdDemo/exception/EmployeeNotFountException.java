package com.tanveer.CurdDemo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class EmployeeNotFountException extends RuntimeException{
    public EmployeeNotFountException(String message) {
        super(message);
    }

    public EmployeeNotFountException(String message, Throwable cause) {
        super(message, cause);
    }

    public EmployeeNotFountException(Throwable cause) {
        super(cause);
    }
}
