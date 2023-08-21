package com.example.api.entities;

public class SuccessLoginResponse {
    private String json;
    private String token;

    public SuccessLoginResponse(String token) {
        this.json = String.format("{\"success\": true, \"token\": \"%s\"}", token);;
    }

    @Override
    public String toString() {
        return json;
    }
}