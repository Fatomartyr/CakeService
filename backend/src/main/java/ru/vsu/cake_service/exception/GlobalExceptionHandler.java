package ru.vsu.cake_service.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import ru.vsu.cake_service.exception.cake_exceptions.CakeNotFoundException;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(CakeNotFoundException.class)
    public ResponseEntity<String> handleCakeNotFound(CakeNotFoundException ex) {
        return ResponseEntity.ok(ex.getMessage());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleValidationException(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getFieldErrors().forEach(fieldError ->
        {errors.put(fieldError.getField(), fieldError.getDefaultMessage());});
        return ResponseEntity.badRequest().body(errors);
    }

}
