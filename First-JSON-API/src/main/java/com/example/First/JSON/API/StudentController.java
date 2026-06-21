package com.example.First.JSON.API;

import com.example.First.JSON.API.requestbody.Student;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {
    @PostMapping("/student")
    public String student(@RequestBody Student obj){
        return "Received student : "+obj.getName()+"    age : "+obj.getAge()+" years old ";
    }
}
