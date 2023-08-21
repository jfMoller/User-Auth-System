package com.example.api.entities;

public class SuccessResponse {
    private String json;
    private String token;

    public SuccessResponse(String token) {
        this.json = String.format("{\"success\": true, \"message\": \"%s\"}", token);;
    }

    @Override
    public String toString() {
        return json;
    }
}