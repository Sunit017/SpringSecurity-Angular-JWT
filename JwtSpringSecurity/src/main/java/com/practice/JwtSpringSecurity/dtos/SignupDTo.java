package com.practice.JwtSpringSecurity.dtos;

import lombok.Data;

@Data
public class SignupDTo {

    private String name;

    private String email;

    private String password;
}
