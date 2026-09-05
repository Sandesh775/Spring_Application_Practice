package com.example.Final.DTO.practice.Product.API;

public class ProductLimitException extends RuntimeException {
    public ProductLimitException(String message) {
        super(message);
    }
}
