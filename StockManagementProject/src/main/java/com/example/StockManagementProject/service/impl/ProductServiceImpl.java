package com.example.StockManagementProject.service.impl;

import com.example.StockManagementProject.dto.ProductDto;
import com.example.StockManagementProject.entity.Product;
import com.example.StockManagementProject.repository.ProductRepo;
import com.example.StockManagementProject.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepo productRepo;

    @Override
    public Product addProduct(ProductDto dto) {

        Product product = new Product();
        product.setName(dto.getName());
        product.setCategory(dto.getCategory());
        product.setCompany(dto.getCompany());
        product.setQuantity(dto.getQuantity());
        product.setPrice(dto.getPrice());

        return productRepo.save(product);
    }

    @Override
    public Product updateProduct(Integer id, ProductDto dto) {

        Product product = productRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));

        product.setName(dto.getName());
        product.setCategory(dto.getCategory());
        product.setCompany(dto.getCompany());
        product.setQuantity(dto.getQuantity());
        product.setPrice(dto.getPrice());

        return productRepo.save(product);
    }

    @Override
    public List<Product> search(String name, String category, String company) {

        return productRepo.findAll().stream()
                .filter(p ->
                        (name == null || p.getName().contains(name)) &&
                                (category == null || p.getCategory().contains(category)) &&
                                (company == null || p.getCompany().contains(company))
                ).toList();
    }
}