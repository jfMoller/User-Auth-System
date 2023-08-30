package com.example.api.components;

import com.example.api.entities.User;
import com.example.api.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import static com.example.api.dto.enums.UserRole.ADMIN;

@Component
public class DefaultUsersSetup implements CommandLineRunner {

    private final UserRepository userRepository;

    @Autowired
    public DefaultUsersSetup(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    //populates the users table with default users if empty on startup
    @Override
    public void run(String... args) {
        if (userRepository.count() == 0) {
            createDefaultUser(new User("admin", "admin@admin.com", "password"), true);
            createDefaultUser(new User("user", "user@user.com", "password"), false);
        }
    }

    private void createDefaultUser(User user, Boolean isAdmin) {
        if (isAdmin) user.setUserRole(ADMIN);
        userRepository.save(user);
    }
}