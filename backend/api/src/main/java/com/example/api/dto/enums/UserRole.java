package com.example.api.dto.enums;

public enum UserRole {
    USER,
    ADMIN;

    @Override
    public String toString() {
        return switch (this) {
            case USER -> "USER";
            case ADMIN -> "ADMIN";
            default -> "INVALID_ROLE";
        };
    }
}