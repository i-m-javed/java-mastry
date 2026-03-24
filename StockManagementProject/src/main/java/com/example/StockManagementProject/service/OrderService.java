package com.example.StockManagementProject.service;


import com.example.StockManagementProject.dto.OrderRequestDto;
import com.example.StockManagementProject.entity.Order;

public interface OrderService {
    Order createOrder(OrderRequestDto dto);
}