package com.example.api.dto;

import com.example.api.dto.enums.UserRole;

import static com.example.api.dto.enums.ResponseStatus.ERROR;
import static com.example.api.dto.enums.ResponseStatus.SUCCESS;

public class JsonLoginResponse {
    private UserRole userRole;
    private String token;

    public JsonLoginResponse(UserRole userRole, String token) {
        this.userRole = userRole;
        this.token = token;
    }

    public JsonLoginResponse() {
    }

    public String sendToken() {
        String userRoleString = userRole.toString();
        return String.format("{\"%s\": true, \"userRole\": \"%s\", \"token\": \"%s\"}", SUCCESS, userRoleString, token);
    }

    public String sendError() {
        return new JsonResponse(ERROR, "Login failed; check your email and/or password").send();
    }

}