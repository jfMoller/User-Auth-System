package com.example.api.dto.enums;

public enum ResponseStatus {
    SUCCESS,
    ERROR;

    @Override
    public String toString() {
        switch (this) {
            case SUCCESS:
                return "SUCCESS";
            case ERROR:
                return "ERROR";
            default:
                return "INVALID_VALUE";
        }
    }
}