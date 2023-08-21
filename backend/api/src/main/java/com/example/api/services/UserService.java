package com.example.api.services;

import com.example.api.entities.*;
import com.example.api.repositories.UserRepository;
import com.example.api.token.JwtTokenService;
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

                String jwtToken = new JwtTokenService().generateToken(Long.toString(user.getId()), user.getEmail(), "user");

                String response = new SuccessLoginResponse(jwtToken).toString();
                return response;
            }
        }
        String errorMessage = "Login failed.";
        String response = new ErrorResponse(errorMessage).toString();
        return response;
    }

    public String registerUser(UserRegistration newUser) {

        List<User> users = userRepository.findAll();
        for (User user : users) {
            if (newUser.getName().isEmpty() ||
                    newUser.getName().isBlank()) {
                return new ErrorResponse("Invalid name format.").toString();
            }
            if (newUser.getEmail().isEmpty() ||
                    newUser.getEmail().isBlank() ||
                    // This regex pattern checks for a valid email format with "@" before a dot, ensuring
                    // there's content before and after the "@" and dot, and no trailing dots.
                    // Detailed explanation:
                    // ^        - Start of the string
                    // .*       - Any sequence of characters
                    // @        - The "@" character
                    // .*       - Any sequence of characters
                    // \.       - A literal dot (.)
                    // .+       - One or more of any characters (ensures something after the dot)
                    // [^\\.]   - Any character that is not a dot
                    // *        - Zero or more of the preceding characters
                    // $        - End of the string
                    !newUser.getEmail().matches("^.*@.*\\..+[^\\.]*$")) {
                return new ErrorResponse("Invalid email format.").toString();
            }

            if ((user.getEmail().equals(newUser.getEmail()))) {
                return new ErrorResponse("An account with this email already exists.").toString();
            }

            if (newUser.getPassword().isEmpty() ||
                    newUser.getPassword().isBlank() ||
                    newUser.getPassword().length() < 5) {
                return new ErrorResponse("Your password needs to be atleast 5 characters long.").toString();
            }

        }
        User validUser = new User(newUser.getName(), newUser.getEmail(), newUser.getPassword());
        userRepository.save(validUser);
        return new SuccessResponse("Successfully registered").toString();
    }
}