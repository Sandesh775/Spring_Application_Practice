package com.example.Connect.Spring.Boot.to.MySQL.repository;
import com.example.Connect.Spring.Boot.to.MySQL.entity.Student;

import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {

}