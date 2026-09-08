package com.example.Registration.Login;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepo userRepo;
    private final PasswordEncoder passwordEncoder;

    public UserService(
            UserRepo userRepo,
            PasswordEncoder passwordEncoder) {

        this.userRepo = userRepo;
        this.passwordEncoder = passwordEncoder;
    }

    public void register(RegisterRequestDTO dto) {

        if (userRepo.existsByUsername(dto.getUsername())) {
            throw new RuntimeException("Username already exists");
        }

        Users user = new Users();

        user.setUsername(dto.getUsername());

        user.setPassword(
                passwordEncoder.encode(dto.getPassword())
        );

        user.setRole("USER");

        userRepo.save(user);
    }
}