package com.example.api.controllers;

import com.example.api.dto.UpdateUserRole;
import com.example.api.dto.UserRegistration;
import com.example.api.entities.User;
import com.example.api.services.UserService;
import com.example.api.util.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public List<User> getUsers() {
        return userService.getUsers();
    }

    @PutMapping("/users")
    public void updateUserRole(@RequestHeader("Token") String token, @RequestBody UpdateUserRole request) {
        JwtTokenUtil.handleVoidAdminMethodAccess(token,
                () -> userService.updateUserRole(request.getUserID(), request.getUserEmail(), request.getNewUserRole()));
    }

    @DeleteMapping("/users/{userID}")
    public void deleteProduct(@RequestHeader("Token") String token, @PathVariable Long userID) {
        JwtTokenUtil.handleVoidAdminMethodAccess(token,
                () -> userService.deleteUserByID(userID));
    }

    @PostMapping("/register")
    public String registerUser(@RequestBody UserRegistration user) {
        return userService.registerUser(user);
    }
}