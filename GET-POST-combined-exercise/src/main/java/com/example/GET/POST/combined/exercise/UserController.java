package com.example.GET.POST.combined.exercise;



import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<UserResponseDTO>> getAllUser(){
        List<UserResponseDTO> responses = userService.getAllUser();

        return ResponseEntity.status(HttpStatus.FOUND).body(responses);
    }

    @PostMapping
    public ResponseEntity<UserResponseDTO> createUser(@RequestBody User user){

    }
}