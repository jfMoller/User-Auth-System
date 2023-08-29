package com.example.api.services;

import com.example.api.dto.JsonResponse;
import com.example.api.dto.LoginRequest;
import com.example.api.dto.LoginResponse;
import com.example.api.dto.UserRegistration;
import com.example.api.dto.enums.UserRole;
import com.example.api.entities.*;
import com.example.api.repositories.UserRepository;
import com.example.api.util.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public void updateUserRole(Long userID, String userEmail, String newUserRole) {
        Optional<User> selectedUser = userRepository.findById(userID);
        if (selectedUser.isPresent()) {
            User user = selectedUser.get();

            if (user.getEmail().equals(userEmail)) {
                switch (newUserRole) {
                    case "ADMIN" -> user.setUserRole(UserRole.ADMIN);
                    case "USER" -> user.setUserRole(UserRole.USER);
                    default -> throw new IllegalArgumentException("Invalid user role; update failed.");
                }
                userRepository.save(user);
            } else {
                throw new IllegalArgumentException("User email does not match the selected user's email; update failed.");
            }
        }
    }

    public void deleteUserByID(Long userID) {
        Optional<User> selectedUser = userRepository.findById(userID);
        if (selectedUser.isPresent()) {
                userRepository.deleteById(userID);
            } else {
                throw new IllegalArgumentException("Uknown userID; delete failed.");
            }
    }

    public String loginUser(LoginRequest loginRequest) {

        List<User> users = this.getUsers();
        for (User user : users) {
            if (isValidLoginCredentials(user, loginRequest)) {
                return new LoginResponse(user.getUserRole(), JwtTokenUtil.generateToken(
                        Long.toString(user.getId()),
                        user.getEmail(), user.getUserRole().toString())).sendToken();
            }
        }
        return new LoginResponse().sendError();
    }

    public String registerUser(UserRegistration newUser) {
        validateUserRegistrationFormat(newUser);

        List<User> users = userRepository.findAll();
        for (User user : users) {
            if (isAlreadyExistingAccount(user.getEmail(), newUser.getEmail())) {
                return new JsonResponse(ERROR, "email", "An account with this email already exists.").send();
            }
        }
        userRepository.save(new User(newUser.getName(), newUser.getEmail(), newUser.getPassword()));
        return new JsonResponse(SUCCESS).send();
    }

    public String validateUserRegistrationFormat(UserRegistration newUser) {
        if (!isValidNameFormat(newUser.getName())) {
            return new JsonResponse(ERROR, "name", "Invalid name format.").send();
        }

        if (!isValidPasswordFormat(newUser.getPassword())) {
            return new JsonResponse(ERROR, "password", "Your password needs to be at least 5 characters long.").send();
        }

        if (!isValidEmailFormat(newUser.getEmail())) {
            return new JsonResponse(ERROR, "email", "Invalid email format; valid example: example@gmail.com.").send();
        }

        return new JsonResponse(SUCCESS).send();
    }

    public boolean isValidLoginCredentials(User user, LoginRequest loginRequest) {
        return (user.getEmail().equals(loginRequest.getEmail())) && (user.getPassword().equals(loginRequest.getPassword()));
    }

    public boolean isValidNameFormat(String name) {
        return name.isEmpty() ||
                name.isBlank() ||
                name == "";
    }

    public boolean isValidPasswordFormat(String password) {
        return password.isEmpty() ||
                password.isBlank() ||
                password.length() < 5;
    }

    public boolean isValidEmailFormat(String email) {
        return email.isEmpty() ||
                email.isBlank() ||
                email.matches("^.*@.*\\..+[^\\.]*$");
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
    }

    public boolean isAlreadyExistingAccount(String existingEmail, String requestedEmail) {
        return existingEmail.equals(requestedEmail);
    }
}