package com.example.tanveer.onetoonemapping.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class InstructorDetailsNotFoundException extends RuntimeException{

    public InstructorDetailsNotFoundException(String message) {
        super(message);
    }

    public InstructorDetailsNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public InstructorDetailsNotFoundException(Throwable cause) {
        super(cause);
    }
}
