package com.example.Final.DTO.practice.Product.API;

import java.time.LocalDate;

public class ProductMapper {

    public ProductResponseDTO toResponse(Product p){
        ProductResponseDTO responseDTO = new ProductResponseDTO();

        responseDTO.setId(p.getId());
        responseDTO.setName(p.getName());
        responseDTO.setPrice(p.getPrice());
        responseDTO.setStock(p.getStock());
        responseDTO.setAvailable(p.isAvailable());
        responseDTO.setCreatedAt(p.getCreatedAt());

        return  responseDTO;
    }

    public Product toEntity(ProductRequestDTO dto){
        Product p = new Product();

        p.setName(dto.getName());
        p.setPrice(dto.getPrice());
        p.setStock(dto.getStock());

        p.setAvailable(p.getStock() > 0);
        p.setCreatedAt(new LocalDate());

        return p;
    }
}