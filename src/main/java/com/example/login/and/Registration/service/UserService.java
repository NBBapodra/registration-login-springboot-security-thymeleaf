package com.example.login.and.Registration.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.example.login.and.Registration.controller.dto.UserRegistrationDto;
import com.example.login.and.Registration.model.User;

public interface UserService extends UserDetailsService{
    
    User findByEmail(String email);

    User save(UserRegistrationDto registration);
}