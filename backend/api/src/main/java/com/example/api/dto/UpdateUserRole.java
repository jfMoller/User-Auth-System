package com.example.api.dto;

public class UpdateUserRole {
    private String newUserRole;

    private String userEmail;

    private Long userID;

    public String getNewUserRole() {
        return newUserRole;
    }

    public Long getUserID() {
        return userID;
    }

    public String getUserEmail() {
        return userEmail;
    }
}
