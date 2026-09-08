package com.example.Registration.Login;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepo extends JpaRepository<Users, Long> {

    Optional<Users> findByUsername(String username);

    boolean existsByUsername(String username);
}