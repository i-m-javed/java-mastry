package com.example.StockManagementProject.entity;

import com.example.StockManagementProject.entity.Order;
import com.example.StockManagementProject.entity.Product;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderHistory {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Integer id;

    @ManyToOne
    private Order order;

    @ManyToOne
    private Product product;
}