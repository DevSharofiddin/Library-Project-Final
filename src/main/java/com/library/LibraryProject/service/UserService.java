package com.library.LibraryProject.service;

import com.library.LibraryProject.model.User;
import com.library.LibraryProject.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(PasswordEncoder passwordEncoder, UserRepository userRepository) {
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
    }

    public User userSave(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    public List<User> userFindAll() {
        return userRepository.findAll();
    }

    public User userFindById(Long id) {
        return userRepository.findById(id).get();
    }

    public void userDeleteOne(Long id) {
        userRepository.deleteById(id);
    }
}
