package com.example.First_POST_Request;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GET_Controller {
    @GetMapping("/motivation")
    public String getEndpoint(){
        return "Read Motivation";
    }
}
