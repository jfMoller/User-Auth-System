package com.example.api.services;

import com.example.api.entities.Login;
import com.example.api.entities.User;
import com.example.api.repositories.UserRepository;
import com.example.api.token.JwtToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getUsers() {
        return userRepository.findAll();
    }

    public String loginUser(Login loginRequest) {
        List<User> users = userRepository.findAll();
        for (User user : users) {
            if ((user.getEmail().equals(loginRequest.getEmail())) &&
                    (user.getPassword().equals(loginRequest.getPassword()))) {
                JwtToken token = new JwtToken();
                return token.generateToken(Long.toString(user.getId()), user.getEmail(), "user");
            }
        }

        return null;
    }
}