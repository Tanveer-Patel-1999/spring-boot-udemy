package com.example.tanveer.onetoonemapping.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class InstructorNotFoundException extends RuntimeException{

    public InstructorNotFoundException(String message) {
        super(message);
    }

    public InstructorNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public InstructorNotFoundException(Throwable cause) {
        super(cause);
    }
}
