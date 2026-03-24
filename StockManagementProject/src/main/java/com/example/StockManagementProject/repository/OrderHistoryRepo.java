package com.example.StockManagementProject.repository;

import com.example.StockManagementProject.entity.OrderHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderHistoryRepo extends JpaRepository<OrderHistory, Integer> {}