package com.example.api.util;

public record TokenRole(String role) {
    @Override
    public String role() {
        return role;
    }
}