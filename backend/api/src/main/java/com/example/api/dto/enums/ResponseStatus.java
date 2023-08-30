package com.example.api.dto.enums;

public enum ResponseStatus {
    SUCCESS,
    ERROR;

    @Override
    public String toString() {
        return switch (this) {
            case SUCCESS -> "SUCCESS";
            case ERROR -> "ERROR";
            default -> "INVALID_VALUE";
        };
    }
}