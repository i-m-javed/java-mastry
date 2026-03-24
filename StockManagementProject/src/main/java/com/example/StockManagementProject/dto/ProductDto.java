package com.example.StockManagementProject.dto;

import lombok.Data;

@Data
public class ProductDto {
    private String name;
    private String category;
    private String company;
    private int quantity;
    private double price;
}