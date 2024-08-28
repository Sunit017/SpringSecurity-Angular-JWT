package com.practice.JwtSpringSecurity.controllers;

import com.practice.JwtSpringSecurity.dtos.SignupDTo;
import com.practice.JwtSpringSecurity.dtos.UserDto;
import com.practice.JwtSpringSecurity.services.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RestController;

@RestController

public class SignUpController {

    @Autowired
    private AuthService authService;

    @PostMapping("/sign-up")
    public ResponseEntity<?> signupUser(@RequestBody SignupDTo signupDTo)
    {
        UserDto createdUser= authService.createUser(signupDTo);
        if(createdUser==null)
            return new ResponseEntity<>("User not created come up again", HttpStatus.BAD_REQUEST);
        else
            return new ResponseEntity<>(createdUser,HttpStatus.CREATED);
    }
}
