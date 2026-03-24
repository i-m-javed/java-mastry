package com.krishna.stockmanagement.controller;

import com.krishna.stockmanagement.constant.ProductConstant;
import com.krishna.stockmanagement.entity.Product;
import com.krishna.stockmanagement.entity.dto.ProductResponseDto;
import com.krishna.stockmanagement.entity.dto.ResponseDto;
import com.krishna.stockmanagement.repository.ProductRepository;
import com.krishna.stockmanagement.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @PostMapping("/add")
    public ResponseEntity<ResponseDto> addProduct(
            @RequestBody Product product) {

        ProductResponseDto dto =
                productService.addProduct(product);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new ResponseDto(
                        ProductConstant.STATUS_201,
                        ProductConstant.MESSAGE_ADD,
                        dto
                ));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ResponseDto> updateProduct(
            @PathVariable Integer id,
            @RequestBody Product product) {

        ProductResponseDto dto =
                productService.updateProduct(id, product);

        return ResponseEntity.status(HttpStatus.OK)
                .body(new ResponseDto(
                        ProductConstant.STATUS_200,
                        ProductConstant.MESSAGE_UPDATE,
                        dto
                ));
    }

    @GetMapping("/search")
    public ResponseEntity<ResponseDto> searchProducts(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String category,
            @RequestParam(required = false) String company) {

        List<ProductResponseDto> list =
                productService.searchProducts(
                        name, category, company);

        return ResponseEntity.status(HttpStatus.OK)
                .body(new ResponseDto(
                        ProductConstant.STATUS_200,
                        ProductConstant.MESSAGE_GET,
                        list
                ));
    }
}