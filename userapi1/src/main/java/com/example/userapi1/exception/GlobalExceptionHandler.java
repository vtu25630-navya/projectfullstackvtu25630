package com.example.userapi1.exception;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

@ControllerAdvice
public class GlobalExceptionHandler {

    // VALIDATION ERROR
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String,Object>> handleValidationException(
            MethodArgumentNotValidException ex){

        Map<String,Object> error = new HashMap<>();

        error.put("timestamp", LocalDateTime.now());
        error.put("error", "Validation Failed");
        error.put("details",
                ex.getBindingResult().getFieldError().getDefaultMessage());

        return ResponseEntity.badRequest().body(error);
    }

    // RESOURCE NOT FOUND
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<Map<String,Object>> handleResourceNotFound(
            ResourceNotFoundException ex){

        Map<String,Object> error = new HashMap<>();

        error.put("timestamp", LocalDateTime.now());
        error.put("error", ex.getMessage());
        error.put("details", "Requested resource not found");

        return ResponseEntity.status(404).body(error);
    }
}