package com.example.Final.DTO.practice.Product.API;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    public ProductService(ProductRepository productRepository, ProductMapper productMapper) {
        this.productRepository = productRepository;
        this.productMapper = productMapper;
    }

    public List<ProductResponseDTO> getAllProduct(){
        List<Product> products = productRepository.findAll();

        List<ProductResponseDTO>  responses = new ArrayList<>();

        for(Product p : products){

            ProductResponseDTO response = productMapper.toResponse(p);

            responses.add(response);
        }

        return responses;
    }

    public ProductResponseDTO createProduct(ProductRequestDTO dto){


        Product product = productMapper.toEntity(dto);

        if(product.getStock() > 1000){
            throw new ProductLimitException("Product stock limit exceeded.");
        }

        Product savedProduct = productRepository.save(product);

        return productMapper.toResponse(savedProduct);
    }
}
