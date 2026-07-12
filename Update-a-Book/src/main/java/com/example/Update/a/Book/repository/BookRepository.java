package com.example.Update.a.Book.repository;

import com.example.Update.a.Book.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
