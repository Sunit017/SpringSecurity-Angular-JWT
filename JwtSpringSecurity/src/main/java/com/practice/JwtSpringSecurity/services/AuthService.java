package com.practice.JwtSpringSecurity.services;

import com.practice.JwtSpringSecurity.Repository.UserRepository;
import com.practice.JwtSpringSecurity.dtos.SignupDTo;
import com.practice.JwtSpringSecurity.dtos.UserDto;

import com.practice.JwtSpringSecurity.models.Users;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ModelMapper modelMapper;
    public UserDto createUser(SignupDTo signupDTo) {

        Users user= modelMapper.map(signupDTo,Users.class);
        user.setPasswords(new BCryptPasswordEncoder().encode(signupDTo.getPassword()));
        Users createdUser = userRepository.save(user);
        return modelMapper.map(createdUser,UserDto.class);

    }
}
