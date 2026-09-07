package com.example.Spring.Security.Authorization.with.Database.Users;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

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
}
