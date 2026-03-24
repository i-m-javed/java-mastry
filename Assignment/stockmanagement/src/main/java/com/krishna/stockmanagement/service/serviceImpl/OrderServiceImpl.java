package com.krishna.stockmanagement.service.serviceImpl;


import com.krishna.stockmanagement.entity.Order;
import com.krishna.stockmanagement.entity.OrderHistory;
import com.krishna.stockmanagement.entity.Product;
import com.krishna.stockmanagement.entity.dto.CartItemDto;
import com.krishna.stockmanagement.entity.dto.OrderResponseDto;
import com.krishna.stockmanagement.repository.OrderRepository;
import com.krishna.stockmanagement.repository.ProductRepository;
import com.krishna.stockmanagement.service.OrderService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final ProductRepository productRepo;
    private final OrderRepository orderRepo;

    @Override
    @Transactional
    public OrderResponseDto createOrder(List<CartItemDto> cart) {

        Order order = new Order();
        List<OrderHistory> items = new ArrayList<>();

        double total = 0;

        for (CartItemDto dto : cart) {

            Product product = productRepo.findById(dto.getProductId())
                    .orElseThrow(() ->
                            new RuntimeException("Product not found"));

            if (product.getQuantity() < dto.getQuantity()) {
                throw new RuntimeException(
                        "Insufficient stock for " + product.getName());
            }

            // Reduce stock
            product.setQuantity(
                    product.getQuantity() - dto.getQuantity());

            double itemPrice =
                    product.getPrice() * dto.getQuantity();

            total += itemPrice;

            OrderHistory history = new OrderHistory();
            history.setOrder(order);
            history.setProduct(product);
            history.setQuantity(dto.getQuantity());

            items.add(history);
        }

        order.setTotalPrice(total);
        order.setTotalPriceWithGst(total * 1.18);
        order.setItems(items);

        Order saved = orderRepo.save(order);

        return new OrderResponseDto(
                saved.getId(),
                saved.getTotalPrice(),
                saved.getTotalPriceWithGst()
        );
    }

    @Override
    public OrderResponseDto findById(Integer id) {

        Order order = orderRepo.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Order not found"));

        return new OrderResponseDto(
                order.getId(),
                order.getTotalPrice(),
                order.getTotalPriceWithGst()
        );
    }
}