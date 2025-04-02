package ru.vsu.cake_service.exception.cake_exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class CakeNotFoundException extends RuntimeException {
    public CakeNotFoundException(String message) {
        super(message);
    }
}
