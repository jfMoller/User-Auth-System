package com.example.api.exceptions;

public class InvalidProductException extends RuntimeException {
    private String message;
    public InvalidProductException(String message) {
        super(message);
    }
}