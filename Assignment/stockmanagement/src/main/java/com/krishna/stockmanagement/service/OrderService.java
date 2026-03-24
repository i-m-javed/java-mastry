package com.krishna.stockmanagement.service;

import com.krishna.stockmanagement.entity.Order;
import com.krishna.stockmanagement.entity.dto.CartItemDto;
import com.krishna.stockmanagement.entity.dto.OrderResponseDto;
import jakarta.transaction.Transactional;

import java.util.List;

public interface OrderService {

    OrderResponseDto createOrder(List<CartItemDto> cart);

    OrderResponseDto findById(Integer id);
}