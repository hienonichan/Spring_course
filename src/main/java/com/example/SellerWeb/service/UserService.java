package com.example.SellerWeb.service;

import org.springframework.stereotype.Service;
import java.util.List;
import com.example.SellerWeb.domain.User;
import com.example.SellerWeb.repository.UserRepository;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public String createUser() {
        return "hello from create User service";
    }

    public User handleSaveUser(User user) {
        return this.userRepository.save(user);
    }

    public List<User> getAllUser() {
        return this.userRepository.findAll();
    }

    public List<User> findByEmail(String email) {
        return this.userRepository.findByEmail(email);
    }

    public User getUserById(long id) {
        return this.userRepository.findById(id);
    }

    public void deleteUserById(long id) {
        this.userRepository.deleteById(id);
    }
}
