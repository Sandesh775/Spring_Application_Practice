package com.example.Login_Auth_DB;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @GetMapping("/login")
    public String greet(){
        return "Welcome to Spring Security";
    }

}
