package com.example.api.services;

import com.example.api.dto.JsonResponse;
import com.example.api.dto.LoginRequest;
import com.example.api.dto.LoginResponse;
import com.example.api.dto.UserRegistration;
import com.example.api.entities.*;
import com.example.api.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.example.api.dto.enums.ResponseStatus.ERROR;
import static com.example.api.dto.enums.ResponseStatus.SUCCESS;

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

    public String loginUser(LoginRequest loginRequest) {

        List<User> users = this.getUsers();
        for (User user : users) {
            if ((user.getEmail().equals(loginRequest.getEmail())) &&
                    (user.getPassword().equals(loginRequest.getPassword()))) {
                String jwtToken = new JwtTokenService().generateToken(Long.toString(user.getId()), user.getEmail(), "user");

                return new LoginResponse(jwtToken).sendToken();
            }
        }
        return new LoginResponse().sendError();
    }

    public String registerUser(UserRegistration newUser) {

        if (newUser.getName().isEmpty() ||
                newUser.getName().isBlank() ||
                newUser.getName().equals("test")) {
            return new JsonResponse(ERROR, "name", "Invalid name format.").send();
        }

        if (newUser.getPassword().isEmpty() ||
                newUser.getPassword().isBlank() ||
                newUser.getPassword().length() < 5) {
            return new JsonResponse(ERROR, "password", "Your password needs to be at least 5 characters long.").send();
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
            return new JsonResponse(ERROR, "email", "Invalid email format; valid example: example@gmail.com.").send();
        }

        List<User> users = userRepository.findAll();
        for (User user : users) {

            if ((user.getEmail().equals(newUser.getEmail()))) {
                return new JsonResponse(ERROR, "email", "An account with this email already exists.").send();
            }
        }
        User validUser = new User(newUser.getName(), newUser.getEmail(), newUser.getPassword());
        userRepository.save(validUser);
        return new JsonResponse(SUCCESS).send();
    }
}