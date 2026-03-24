package com.krishna.stockmanagement.controller;

import com.krishna.stockmanagement.constant.OrderConstant;
import com.krishna.stockmanagement.entity.dto.CartItemDto;
import com.krishna.stockmanagement.entity.dto.OrderResponseDto;
import com.krishna.stockmanagement.entity.dto.ResponseDto;
import com.krishna.stockmanagement.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    // 🔹 Create Bill
    @PostMapping("/create")
    public ResponseEntity<ResponseDto> createOrder(
            @RequestBody List<CartItemDto> cart) {

        OrderResponseDto dto =
                orderService.createOrder(cart);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new ResponseDto(
                        OrderConstant.STATUS_201,
                        OrderConstant.MESSAGE_CREATE,
                        dto
                ));
    }


    @GetMapping("/findById/{id}")
    public ResponseEntity<ResponseDto> findById(
            @PathVariable Integer id) {

        OrderResponseDto dto =
                orderService.findById(id);

        return ResponseEntity.status(HttpStatus.OK)
                .body(new ResponseDto(
                        OrderConstant.STATUS_200,
                        OrderConstant.MESSAGE_GET,
                        dto
                ));
    }
}