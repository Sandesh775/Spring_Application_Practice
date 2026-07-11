package com.example.Book.Management.API.controller;

import com.example.Book.Management.API.entity.Book;
import com.example.Book.Management.API.repository.BookRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {
    private final BookRepository bookRepository;

    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    // POST request endpoint
    @PostMapping
    public String addBook(@RequestBody Book book){
        bookRepository.save(book);

        return "Book Saved Successfully";
    }

    // GET request endpoint
    @GetMapping
    public List<Book> getallBooks(){
        return bookRepository.findAll();
    }
}
