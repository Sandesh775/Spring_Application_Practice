package com.example.BookDTO_Mapper;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BookMapper {

    BookDTO toDTO(Book book);

    Book toEntity(BookDTO dto);
}