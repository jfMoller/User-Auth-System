package com.example.api.entities;

import static com.example.api.entities.ResponseStatus.ERROR;

public class LoginResponse {
    private String token;

    public LoginResponse(String token) {
        this.token = token;
    }

    public LoginResponse() {
    }

    public String sendToken() {
        return String.format("{\"SUCCESS\": true, \"token\": \"%s\"}", token);
    }

    public String sendError() {
        return new JsonResponse(ERROR, "Login failed; check your email and/or password").send();
    }
}