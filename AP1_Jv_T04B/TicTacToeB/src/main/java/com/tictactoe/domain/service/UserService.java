package com.tictactoe.domain.service;

import com.tictactoe.domain.model.User;
import com.tictactoe.datasource.repository.UserRepository;
import org.springframework.stereotype.Service;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User createUser(String login, String password) {
        if (userRepository.existsByLogin(login)) {
            throw new IllegalArgumentException("User already exists");
        }

        User user = new User(login, password);
        return userRepository.save(user);
    }

    public Optional<User> findByLogin(String login) {
        return userRepository.findByLogin(login);
    }

    public Optional<User> findById(UUID id) {
        return userRepository.findById(id);
    }

    public boolean validateCredentials(String login, String password) {
        return userRepository.findByLogin(login)
                .map(user -> user.getPassword().equals(password))
                .orElse(false);
    }
}
