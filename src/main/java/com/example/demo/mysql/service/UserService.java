package com.example.demo.mysql.service;

import com.example.demo.mysql.model.Users;
import com.example.demo.mysql.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<Users> getAllUsers() {
        return userRepository.findAll();
    }

    public Users saveUser(Users users) {
        return userRepository.save(users);
    }
}
