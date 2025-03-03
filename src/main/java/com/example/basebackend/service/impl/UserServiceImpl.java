package com.example.basebackend.service.impl;

import com.example.basebackend.entity.User;
import com.example.basebackend.repository.IUserRepository;
import com.example.basebackend.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements IUserService {
    @Autowired
    private IUserRepository userRepository;

    @Override
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @Override
    public UserDetailsService userDetailsService() {
        return username -> userRepository.findByUsername(username);
    }
}
