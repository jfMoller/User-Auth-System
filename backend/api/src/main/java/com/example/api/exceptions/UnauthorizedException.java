package com.example.api.exceptions;

public class UnauthorizedException extends RuntimeException {
    private String message;
    public UnauthorizedException(String message) {
        super(message);
    }
}