package com.example.StockManagementProject.controller;

import com.example.StockManagementProject.dto.OrderRequestDto;
import com.example.StockManagementProject.dto.ResponseDto;
import com.example.StockManagementProject.entity.Order;
import com.example.StockManagementProject.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @PostMapping
    public ResponseEntity<ResponseDto> createOrder(@RequestBody OrderRequestDto dto) {

        Order order = orderService.createOrder(dto);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new ResponseDto("201", "Order created", order));
    }
}