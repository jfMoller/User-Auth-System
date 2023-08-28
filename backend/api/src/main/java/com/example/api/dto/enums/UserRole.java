package com.example.api.dto.enums;

public enum UserRole {
    USER,
    ADMIN;

    @Override
    public String toString() {
        switch (this) {
            case USER:
                return "USER";
            case ADMIN:
                return "ADMIN";
            default:
                return "INVALID_ROLE";
        }
    }
}