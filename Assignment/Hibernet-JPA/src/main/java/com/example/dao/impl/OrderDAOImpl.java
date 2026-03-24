package com.example.dao.impl;

import com.example.dao.OrderDAO;
import com.example.entity.Order;
import javax.persistence.*;

public class OrderDAOImpl implements OrderDAO {

    private EntityManager entityManager;

    public OrderDAOImpl() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("CustomerOrderPU");
        this.entityManager = emf.createEntityManager();
    }

    @Override
    public String saveOrder(Order order) {
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.persist(order);
            transaction.commit();
            return "Order saved successfully with ID: " + order.getId();
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            return "Error saving order: " + e.getMessage();
        }
    }

    @Override
    public String updateOrder(Order order) {
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.merge(order);
            transaction.commit();
            return "Order updated successfully";
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            return "Error updating order: " + e.getMessage();
        }
    }

    @Override
    public String deleteOrderById(int id) {
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            Order order = entityManager.find(Order.class, id);
            if (order != null) {
                entityManager.remove(order);
                transaction.commit();
                return "Order deleted successfully";
            } else {
                transaction.rollback();
                return "Order not found with ID: " + id;
            }
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            return "Error deleting order: " + e.getMessage();
        }
    }

    @Override
    public Order getOrderById(int id) {
        try {
            return entityManager.find(Order.class, id);
        } catch (Exception e) {
            System.err.println("Error getting order by ID: " + e.getMessage());
            return null;
        }
    }

    public void close() {
        if (entityManager != null && entityManager.isOpen()) {
            entityManager.close();
        }
    }
}
