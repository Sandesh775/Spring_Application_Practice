package com.example.Movie_API_Business_Logic_DEMO.exception;

public class InvalidMovieException extends RuntimeException{
    public InvalidMovieException(String message) {
        super(message);
    }
}
