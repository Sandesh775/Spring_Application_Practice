package com.example.Registration.Login;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    private final UserService userServices;

    public UserController(UserService userService) {
        this.userServices = userService;
    }

    @GetMapping("/public")
    public String publicAccess() {
        return "Public Access Area !";
    }

    @GetMapping("/user")
    public String userAccess() {
        return "User Access Area !";
    }

    @GetMapping("/admin")
    public String adminAccess() {
        return "Admin Access Area !";
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(
            @RequestBody RegisterRequestDTO dto) {

        userServices.register(dto);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body("User registered successfully!");
    }
}
