package com.example.basebackend.service.impl;

import com.example.basebackend.entity.User;
import com.example.basebackend.exception.AppException;
import com.example.basebackend.exception.ErrorCode;
import com.example.basebackend.repository.IUserRepository;
import com.example.basebackend.service.IUserService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
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
        return username -> userRepository.findByUsername(username).orElseThrow(()-> new AppException(ErrorCode.USER_NOT_FOUND));
    }

    @Override
    @Transactional
    public boolean createUser(User user) {
        user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
        User _user = userRepository.save(user);
        return true;
    }
}
