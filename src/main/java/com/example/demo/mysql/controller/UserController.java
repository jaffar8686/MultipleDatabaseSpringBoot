package com.example.demo.mysql.controller;

import com.example.demo.mysql.model.Users;
import com.example.demo.mysql.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/get/all")
    public List<Users> getAllUsers(){
        return userService.getAllUsers();
    }

    @PostMapping("/saveAll")
    public Users saveUser(@RequestBody Users  users){
        return userService.saveUser(users);
    }
}
