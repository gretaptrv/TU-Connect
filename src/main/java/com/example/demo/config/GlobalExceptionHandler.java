package com.example.demo.config;

import io.jsonwebtoken.ClaimJwtException;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.io.DecodingException;
import io.jsonwebtoken.security.SignatureException;
import jakarta.persistence.PersistenceException;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(DataAccessException.class)
    public ResponseEntity<String> handleDatabaseException(DataAccessException ex) {
        return new ResponseEntity<>(
            "An error occurred with the database operation.", HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(PersistenceException.class)
    public ResponseEntity<String> handlePersistenceException(PersistenceException ex) {
        return new ResponseEntity<>(
            "An error occurred while persisting. Check your request and try again.", HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<String> handleQueryViolation(DataIntegrityViolationException ex) {
        return new ResponseEntity<>(
            "An error found in your db query operation. Check your request and try again.", HttpStatus.BAD_REQUEST);
    }

//    @ExceptionHandler(ExpiredJwtException.class)
//    public ResponseEntity<String> handleEverythingElse(ExpiredJwtException ex) {
//        return new ResponseEntity<>(
//            "Something went wrong! Check your request and try again.", HttpStatus.INTERNAL_SERVER_ERROR);
//    }

    @ExceptionHandler({SignatureException.class, ClaimJwtException.class, JwtException.class, DecodingException.class, AuthenticationException.class})
    public ResponseEntity<String> handle(Exception e) {
        return new ResponseEntity<>("An authorization error occurred, check your request and try again.", HttpStatus.UNAUTHORIZED);
    }

}