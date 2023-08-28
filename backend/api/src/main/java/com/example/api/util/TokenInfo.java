package com.example.api.util;

public class TokenInfo {
    private final String role;

    public TokenInfo(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }
}