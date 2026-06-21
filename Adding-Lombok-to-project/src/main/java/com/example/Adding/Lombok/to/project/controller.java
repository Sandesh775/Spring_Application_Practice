package com.example.Adding.Lombok.to.project;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class controller {
    @PostMapping("/student")
    public String endpoint(@RequestBody Student student){
        return "Student name : "+student.getName()+" Age : "+student.getAge();
    }
}
