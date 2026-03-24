package com.example.StockManagementProject.service;

import com.example.StockManagementProject.dto.ProductDto;
import com.example.StockManagementProject.entity.Product;

import java.util.List;

public interface ProductService {

    Product addProduct(ProductDto dto);

    Product updateProduct(Integer id, ProductDto dto);

    List<Product> search(String name, String category, String company);
}