package com.example.Connect.Spring.Boot.to.MySQL.controller;

import com.example.Connect.Spring.Boot.to.MySQL.entity.Student;
import com.example.Connect.Spring.Boot.to.MySQL.repository.StudentRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    private final StudentRepository studentRepository;

    public StudentController(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    // endpoints will go here
    @PostMapping
    public String addStudent(@RequestBody Student student) {

        studentRepository.save(student);

        return "Student saved successfully!";
    }


    @GetMapping
    public List<Student> getAllStudents(){

        return studentRepository.findAll();
    }
}