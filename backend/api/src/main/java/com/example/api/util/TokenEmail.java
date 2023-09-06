package com.example.api.util;

public record TokenEmail(String email) {
    @Override
    public String email() {
        return email;
    }
}