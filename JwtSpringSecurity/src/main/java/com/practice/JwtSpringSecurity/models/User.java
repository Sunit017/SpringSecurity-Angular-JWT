package com.practice.JwtSpringSecurity.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "users")
@Data
public class User {

    private Long id;

    private String name;

    private String email;

    private String passwords;



}
