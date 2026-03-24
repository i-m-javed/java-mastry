package com.krishna.stockmanagement.service.serviceImpl;

import com.krishna.stockmanagement.entity.Product;
import com.krishna.stockmanagement.entity.dto.ProductResponseDto;
import com.krishna.stockmanagement.repository.ProductRepository;
import com.krishna.stockmanagement.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository repo;

    @Override
    public ProductResponseDto addProduct(Product product) {

        Product saved = repo.save(product);
        return mapToDto(saved);
    }

    @Override
    public ProductResponseDto updateProduct(Integer id, Product product) {

        Product existing = repo.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Product not found"));

        existing.setName(product.getName());
        existing.setCategory(product.getCategory());
        existing.setCompany(product.getCompany());
        existing.setQuantity(product.getQuantity());
        existing.setPrice(product.getPrice());

        return mapToDto(repo.save(existing));
    }

    @Override
    public List<ProductResponseDto> searchProducts(
            String name,
            String category,
            String company) {

        List<Product> list;

        if (name != null)
            list = repo.findByNameContainingIgnoreCase(name);
        else if (category != null)
            list = repo.findByCategoryIgnoreCase(category);
        else if (company != null)
            list = repo.findByCompanyIgnoreCase(company);
        else
            list = repo.findAll();

        return list.stream()
                .map(this::mapToDto)
                .toList();
    }

    private ProductResponseDto mapToDto(Product p) {

        return new ProductResponseDto(
                p.getId(),
                p.getName(),
                p.getCategory(),
                p.getCompany(),
                p.getQuantity(),
                p.getPrice()
        );
    }
}