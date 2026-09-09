package com.example.JWT.Mini.Exercise;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {
    private final JwtUtil jwtservice;

    public AuthController(JwtUtil jwtservice) {
        this.jwtservice = jwtservice;
    }

    @GetMapping("/protected")
    public ResponseEntity<String> getRequest(){
        return ResponseEntity.ok("Your JWT is verified and valid so Welcome !");
    }

    @PostMapping("/login")
    public ResponseEntity<String> postRequest(@RequestBody Entity entity){
        String token = jwtservice.generateToken(entity.getUsername());
        return ResponseEntity.status(HttpStatus.CREATED).body("Login Successful ! Token : "+token);
    }
}
