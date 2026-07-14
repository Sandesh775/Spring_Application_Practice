package com.example.Student.Management.API.controller;

import com.example.Student.Management.API.entity.Student;
import com.example.Student.Management.API.repository.StudentRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Students")
public class StudentController {
    private final StudentRepository studentRepository;

    public StudentController(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    // POST
    @PostMapping
    public Student addStudent(@RequestBody Student student){
        studentRepository.save(student);
        //return "Student added successfully !";
        return studentRepository.save(student);
    }

    // GET
    @GetMapping
    public List<Student> getallStudent(){
        return studentRepository.findAll();
    }

    // GET by id
    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable Long id){
        return studentRepository.findById(id).orElse(null);
    }

    // PUT
    @PutMapping
    public String modifyStudent(@RequestBody Student student){
        studentRepository.save(student);
        return "Student info change successfully !";
    }

    // DELETE by id
    @DeleteMapping("/{id}")
    public String deleteStudent(@PathVariable Long id){
        studentRepository.deleteById(id);
        return "Student deleted successfully !";
    }
}
