package com.krishna.stockmanagement.service;

import com.krishna.stockmanagement.entity.Product;
import com.krishna.stockmanagement.entity.dto.ProductResponseDto;

import java.util.List;

public interface ProductService {

    ProductResponseDto addProduct(Product product);

    ProductResponseDto updateProduct(Integer id, Product product);

    List<ProductResponseDto> searchProducts(
            String name,
            String category,
            String company);
}