package com.example.First_POST_Request;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class POST_Controller {
    @PostMapping("/motivation")
    public String postEndpoint(){
        return "Create Motivation : Keep Learning Spring Boot";
    }
}
