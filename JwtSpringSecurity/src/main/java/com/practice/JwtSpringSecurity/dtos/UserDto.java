package com.practice.JwtSpringSecurity.dtos;

import lombok.Data;

@Data
public class UserDto {

    private Long id;

    private String name;

    private String email;
}
