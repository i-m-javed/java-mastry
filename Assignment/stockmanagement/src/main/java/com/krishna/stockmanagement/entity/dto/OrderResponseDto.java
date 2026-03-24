package com.krishna.stockmanagement.entity.dto;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class OrderResponseDto {

    private Integer orderId;
    private Double totalPrice;
    private Double totalPriceWithGst;
}
