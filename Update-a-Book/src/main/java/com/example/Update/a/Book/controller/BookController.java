package com.example.Update.a.Book.controller;

import com.example.Update.a.Book.entity.Book;
import com.example.Update.a.Book.repository.BookRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {
    private final BookRepository bookRepository;

    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }
    // for GET
    @GetMapping
    public List<Book> getAllBooks(){
        return bookRepository.findAll();
    }
    // PUT http method endpoint
    @PutMapping
    public String updateBook(@RequestBody Book book){
        bookRepository.save(book);
        return "Book Updated Successfully";
    }
}
