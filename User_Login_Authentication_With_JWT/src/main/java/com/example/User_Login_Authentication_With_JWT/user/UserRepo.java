package com.example.User_Login_Authentication_With_JWT.user;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepo extends JpaRepository<Users, Long> {

    Optional<Users> findByUsername(String username);
}