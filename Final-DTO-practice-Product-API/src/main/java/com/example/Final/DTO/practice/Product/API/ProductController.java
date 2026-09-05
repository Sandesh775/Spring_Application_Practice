package com.example.Final.DTO.practice.Product.API;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public ResponseEntity<List<ProductResponseDTO>> getAllProduct(){
        List<ProductResponseDTO> responses = productService.getAllProduct();

        return  ResponseEntity.ok(responses);
    }

    @PostMapping
    public ResponseEntity<ProductResponseDTO> createUser(@RequestBody ProductRequestDTO dto){

        ProductResponseDTO responseDTO = productService.createProduct(dto);

        return ResponseEntity.status(HttpStatus.CREATED).body(responseDTO);
    }
}
