package com.example.api.entities;

public class LoginSuccessResponse {
    private String json;
    private String token;

    public LoginSuccessResponse(String token) {
        this.json = String.format("{\"success\": true, \"token\": \"%s\"}", token);;
    }

    @Override
    public String toString() {
        return json;
    }
}