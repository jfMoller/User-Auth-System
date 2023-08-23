package com.example.api.dto;

import static com.example.api.dto.enums.ResponseStatus.ERROR;
import static com.example.api.dto.enums.ResponseStatus.SUCCESS;

public class LoginResponse {
    private String token;

    public LoginResponse(String token) {
        this.token = token;
    }

    public LoginResponse() {
    }

    public String sendToken() {
        return String.format("{\"%s\": true, \"token\": \"%s\"}", SUCCESS, token);
    }

    public String sendError() {
        return new JsonResponse(ERROR, "Login failed; check your email and/or password").send();
    }
}