package com.example.api.entities;

public class LoginErrorResponse {
    private String json;
    private String errorMessage;

    public LoginErrorResponse(String errorMessage) {
        this.json = String.format("{\"error\": true, \"message\": \"%s\"}", errorMessage);;
    }

    @Override
    public String toString() {
        return json;
    }
}