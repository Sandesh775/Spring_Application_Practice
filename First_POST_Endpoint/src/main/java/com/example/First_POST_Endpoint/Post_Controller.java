package com.example.First_POST_Endpoint;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Post_Controller {
    // controller for POST request
    @PostMapping("/motivation")
    public String postEndpoint() {
        return "Keep Learning Spring Boot";
    }
    // controller for GET request
    @GetMapping("/motivation")
    public String getEndpoint(){
        return "Keep Learning Spring Boot";
    }
}
