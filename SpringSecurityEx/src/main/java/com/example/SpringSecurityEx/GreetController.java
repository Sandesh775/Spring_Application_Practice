package com.example.SpringSecurityEx;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetController {
    @GetMapping("/")
    public String greet(HttpServletRequest request) {
        return "Welcome To Sandesh's Made Application, session id : " + request.getSession().getId();
    }
}