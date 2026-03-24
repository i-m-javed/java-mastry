package com.example.StockManagementProject.service.impl;

import com.example.StockManagementProject.dto.OrderRequestDto;
import com.example.StockManagementProject.entity.Order;
import com.example.StockManagementProject.entity.Product;
import com.example.StockManagementProject.repository.OrderRepo;
import com.example.StockManagementProject.repository.ProductRepo;
import com.example.StockManagementProject.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final ProductRepo productRepo;
    private final OrderRepo orderRepo;

    @Override
    @Transactional
    public Order createOrder(OrderRequestDto dto) {

        List<Product> products = productRepo.findAllById(dto.getProductIds());

        double total = 0;

        for (Product p : products) {

            if (p.getQuantity() <= 0) {
                throw new RuntimeException("Product out of stock: " + p.getName());
            }

            total += p.getPrice();
            p.setQuantity(p.getQuantity() - 1);
        }

        Order order = new Order();
        order.setTotalPrice(total);
        order.setTotalPriceWithGst(total * 1.18); // 18% GST

        return orderRepo.save(order);
    }
}