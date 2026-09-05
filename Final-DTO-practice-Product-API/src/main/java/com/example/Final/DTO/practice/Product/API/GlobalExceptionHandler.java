package com.example.Final.DTO.practice.Product.API;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

//    @ExceptionHandler(MethodArgumentNotValidException.class)
//    public ResponseEntity<String> handleValidationException(
//            MethodArgumentNotValidException ex) {
//
//        return ResponseEntity.badRequest().body("Invalid product data");
//        //return ResponseEntity.badRequest().body(ex.getBindingResult().getFieldErrors());
//    }
@ExceptionHandler(MethodArgumentNotValidException.class)
public ResponseEntity<String> handleValidationException(
        MethodArgumentNotValidException ex) {

    String message = "";

    for (FieldError error : ex.getBindingResult().getFieldErrors()) {
        message += error.getField()
                + ": "
                + error.getDefaultMessage()
                + "\n";
    }

    return ResponseEntity.badRequest().body(message);
}

@ExceptionHandler(ProductLimitException.class)
    public ResponseEntity<String> handleLimitException(ProductLimitException ex){

    return ResponseEntity.badRequest().body(ex.getMessage());
}
}