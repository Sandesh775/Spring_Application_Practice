package com.example.SpringSecurityWithUsersDatabase;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class UserController {
    @GetMapping
    public String getUserInfo(HttpServletRequest request){
        return "Welcome , "+request.getSession().getId();
    }
}
