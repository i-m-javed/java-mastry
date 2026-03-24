package com.krishna.stockmanagement.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductResponseDto {

    private Integer id;
    private String name;
    private String category;
    private String company;
    private Integer quantity;
    private Double price;
}
