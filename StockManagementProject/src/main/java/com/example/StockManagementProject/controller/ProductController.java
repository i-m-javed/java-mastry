package com.example.StockManagementProject.controller;

import com.example.StockManagementProject.dto.ProductDto;
import com.example.StockManagementProject.dto.ResponseDto;
import com.example.StockManagementProject.entity.Product;
import com.example.StockManagementProject.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @PostMapping
    public ResponseEntity<ResponseDto> addProduct(@RequestBody ProductDto dto) {

        Product product = productService.addProduct(dto);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new ResponseDto("201", "Product added", product));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResponseDto> update(@PathVariable Integer id,
                                              @RequestBody ProductDto dto) {

        Product product = productService.updateProduct(id, dto);

        return ResponseEntity.ok(
                new ResponseDto("200", "Product updated", product)
        );
    }
}