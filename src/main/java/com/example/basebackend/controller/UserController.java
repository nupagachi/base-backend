package com.example.basebackend.controller;

import com.example.basebackend.entity.User;
import com.example.basebackend.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/users")
public class UserController {
    @Autowired
    private IUserService userService;
    @GetMapping
    public List<User> getUsers() {
        return userService.getUsers();
    }
}
