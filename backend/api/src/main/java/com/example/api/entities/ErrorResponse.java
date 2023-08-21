package com.example.api.entities;

public class ErrorResponse {
    private String json;
    private String errorMessage;

    public ErrorResponse(String errorMessage) {
        this.json = String.format("{\"error\": true, \"message\": \"%s\"}", errorMessage);;
    }

    @Override
    public String toString() {
        return json;
    }
}