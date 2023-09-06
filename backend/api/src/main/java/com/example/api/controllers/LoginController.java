package com.example.api.controllers;

import com.example.api.dto.records.LoginRequest;
import com.example.api.services.UserService;
import com.example.api.util.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class LoginController {

    private final UserService userService;

    @Autowired
    public LoginController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/login")
    public String loginUser(@RequestBody LoginRequest loginRequest) {
        return userService.loginUser(loginRequest);
    }

    @PostMapping("/authenticate")
    public String isAuthenticatedUser(@RequestHeader("Token") String token, @RequestBody LoginRequest loginRequest) {
        return JwtTokenUtil.handleReturnMethodAccess(token, () -> userService.isAuthenticatedUser(token, loginRequest));
    }
}