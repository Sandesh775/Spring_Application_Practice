package com.example.BookDTO_Mapper;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/books")
public class BookController {

    private final BookRepository repository;
    private final BookMapper mapper;

    public BookController(BookRepository repository, BookMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @GetMapping("/{id}")
    public BookDTO getBook(@PathVariable Long id) {
        Book book = repository.findById(id).orElseThrow();
        return mapper.toDTO(book);
    }

    @PostMapping
    public BookDTO createBook(@RequestBody BookDTO dto) {
        Book book = mapper.toEntity(dto);
        Book savedBook = repository.save(book);
        return mapper.toDTO(savedBook);
    }
}