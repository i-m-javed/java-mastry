package com.krishna.stockmanagement.repository;

import com.krishna.stockmanagement.entity.OrderHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderHistoryRepository extends JpaRepository<OrderHistory, Integer> {}