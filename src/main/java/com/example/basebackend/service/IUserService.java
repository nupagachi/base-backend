package com.example.basebackend.service;

import com.example.basebackend.entity.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface IUserService {
    List<User> getUsers();
    UserDetailsService userDetailsService();
    boolean createUser(User user);
}
