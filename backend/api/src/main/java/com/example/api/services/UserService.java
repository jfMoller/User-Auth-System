package com.example.api.services;

import com.example.api.entities.Login;
import com.example.api.entities.User;
import com.example.api.repositories.UserRepository;
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
        var users = userRepository.findAll();
        System.out.println("Users" + users);
        return userRepository.findAll();
    }

    public boolean loginUser(Login loginAttempt) {
        List<User> users = userRepository.findAll();

        for (User user : users) {
            System.out.println(user.toString() + " " + loginAttempt.toString());
            if ((user.getEmail() == loginAttempt.getEmail()) &&
                    (user.getPassword() == loginAttempt.getPassword())) {
                return true;
            }
        }

        return false;
    }
}