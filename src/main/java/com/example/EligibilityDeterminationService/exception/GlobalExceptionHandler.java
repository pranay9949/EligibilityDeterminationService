package com.example.EligibilityDeterminationService.exception;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(CaseNumNotFoundException.class)
    public ResponseEntity<Map<String,String>> handleError(CaseNumNotFoundException ex){
        Map<String,String> mp = new HashMap<>();
        mp.put("Error Message",ex.getMessage());
        return new  ResponseEntity<>(mp,HttpStatus.BAD_REQUEST);
    }
}
