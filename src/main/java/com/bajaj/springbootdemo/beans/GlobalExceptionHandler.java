package com.bajaj.springbootdemo.beans;

import com.bajaj.springbootdemo.exceptions.EntityAlreadyExistException;
import com.bajaj.springbootdemo.exceptions.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler({EntityNotFoundException.class})
    public ResponseEntity<Object> handleCustomerNotFound(EntityNotFoundException entityNotFoundException) {
        Map<String,Object> response = new HashMap<>();
        response.put("message", entityNotFoundException.getMessage());
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler({EntityAlreadyExistException.class})
    public ResponseEntity<Object> handleEntityAlreadyExistException(EntityAlreadyExistException entityAlreadyExistException) {
        Map<String,Object> response = new HashMap<>();
        response.put("message", entityAlreadyExistException.getMessage());
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @ExceptionHandler({RuntimeException.class})
    public ResponseEntity<Object> handleRuntimeException(RuntimeException runtimeException) {
        Map<String,Object> response = new HashMap<>();
        response.put("message", runtimeException.getMessage());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
}
