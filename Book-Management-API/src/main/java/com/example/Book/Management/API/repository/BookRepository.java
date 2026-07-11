package com.example.Book.Management.API.repository;

import com.example.Book.Management.API.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book,Long> {
}
