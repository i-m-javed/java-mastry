package com.example.StockManagementProject.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseDto {

    private String status;   // e.g. "200", "201"
    private String message;  // e.g. "Success", "Created successfully"
    private Object data;     // actual response data (Product, Order, etc.)
}