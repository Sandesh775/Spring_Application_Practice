package com.example.Dynamic.Endpoint.Using.Request.Parameter;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    @GetMapping("/student")
    public String studentInfo(@RequestParam String name,@RequestParam int age){
        return "Student name : "+name+" age : "+age+" years old";
    }
}
