package com.practice.JwtSpringSecurity.Repository;


import com.practice.JwtSpringSecurity.models.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Users,Long> {

    Users findFirstByEmail(String email);
}
