package com.example.api.entities;

public class UnauthorizedException extends RuntimeException {
    private String message;
    public UnauthorizedException(String message) {
        super(message);
    }
}