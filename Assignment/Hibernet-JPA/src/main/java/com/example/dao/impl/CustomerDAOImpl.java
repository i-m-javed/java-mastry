package com.example.dao.impl;

import com.example.dao.CustomerDAO;
import com.example.entity.Customer;
import javax.persistence.*;

import java.util.List;

public class CustomerDAOImpl implements CustomerDAO {

    private EntityManager entityManager;

    public CustomerDAOImpl() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("CustomerOrderPU");
        this.entityManager = emf.createEntityManager();
    }

    @Override
    public String saveCustomer(Customer customer) {
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.persist(customer);
            transaction.commit();
            return "Customer saved successfully with ID: " + customer.getId();
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            return "Error saving customer: " + e.getMessage();
        }
    }

    @Override
    public String updateCustomer(Customer customer) {
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.merge(customer);
            transaction.commit();
            return "Customer updated successfully";
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            return "Error updating customer: " + e.getMessage();
        }
    }

    @Override
    public String deleteCustomerById(int id) {
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            Customer customer = entityManager.find(Customer.class, id);
            if (customer != null) {
                entityManager.remove(customer);
                transaction.commit();
                return "Customer deleted successfully";
            } else {
                transaction.rollback();
                return "Customer not found with ID: " + id;
            }
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            return "Error deleting customer: " + e.getMessage();
        }
    }

    @Override
    public Customer getCustomerById(int id) {
        try {
            return entityManager.find(Customer.class, id);
        } catch (Exception e) {
            System.err.println("Error getting customer by ID: " + e.getMessage());
            return null;
        }
    }

    @Override
    public List<Customer> getAllCustomers() {
        try {
            return entityManager.createQuery("FROM Customer", Customer.class).getResultList();
        } catch (Exception e) {
            System.err.println("Error getting all customers: " + e.getMessage());
            return null;
        }
    }

    @Override
    public Customer getCustomerByEmail(String email) {
        try {
            return entityManager.createQuery(
                    "FROM Customer WHERE email = :email", Customer.class)
                    .setParameter("email", email)
                    .getSingleResult();
        } catch (NoResultException e) {
            System.err.println("No customer found with email: " + email);
            return null;
        } catch (Exception e) {
            System.err.println("Error getting customer by email: " + e.getMessage());
            return null;
        }
    }

    public void close() {
        if (entityManager != null && entityManager.isOpen()) {
            entityManager.close();
        }
    }
}
