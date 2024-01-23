package com.example.demo.config;

import jakarta.persistence.PersistenceException;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(DataAccessException.class)
    public ResponseEntity<String> handleDatabaseException(DataAccessException ex) {
        return new ResponseEntity<>(
            "An error occurred with the database operation."
                + ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(PersistenceException.class)
    public ResponseEntity<String> handlePersistenceException(PersistenceException ex) {
        return new ResponseEntity<>(
            "An error occurred while persisting. Check your request and try again."
                + ex.getMessage(), HttpStatus.BAD_REQUEST);
    }
}