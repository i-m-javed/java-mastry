package com.example.StockManagementProject.repository;

import com.example.StockManagementProject.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepo extends JpaRepository<Order, Integer> {}