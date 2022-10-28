package com.marsh.iStore.exceptions;

import com.marsh.iStore.model.dto.Success;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionHandlerAdvice {

    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<Success> productNotFoundException(){
        return new ResponseEntity<>(new Success(404, "Product not found"), HttpStatus.NOT_FOUND);
    }
}
