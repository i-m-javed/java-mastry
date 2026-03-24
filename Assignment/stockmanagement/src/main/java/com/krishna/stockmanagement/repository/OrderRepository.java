package com.krishna.stockmanagement.repository;

import com.krishna.stockmanagement.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Integer> {}