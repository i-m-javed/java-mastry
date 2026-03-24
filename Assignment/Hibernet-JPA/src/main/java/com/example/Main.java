package com.example;

import com.example.dao.impl.CustomerDAOImpl;
import com.example.dao.impl.OrderDAOImpl;
import com.example.entity.Customer;
import com.example.entity.Order;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        CustomerDAOImpl customerDAO = new CustomerDAOImpl();
        OrderDAOImpl orderDAO = new OrderDAOImpl();

        try {
            // Test operations
            System.out.println("=== Testing CRUD Operations ===");

            // 1. Insert a new customer with order
            System.out.println("\n1. Inserting new customer with order...");
            Customer customer = new Customer("John Doe", "john.doe@example.com", "Male", 1234567890L, LocalDate.now());
            Order order = new Order("ORD-001", "Laptop", 1, 999.99, LocalDate.now());
            
            // Set the bidirectional relationship
            customer.setOrder(order);
            order.setCustomer(customer);
            
            String saveResult = customerDAO.saveCustomer(customer);
            System.out.println(saveResult);

            // 2. Update customer details
            System.out.println("\n2. Updating customer details...");
            customer.setCustomerName("John Smith");
            customer.setPhone(9876543210L);
            String updateResult = customerDAO.updateCustomer(customer);
            System.out.println(updateResult);

            // 3. Fetch customer by id
            System.out.println("\n3. Fetching customer by ID...");
            Customer fetchedCustomer = customerDAO.getCustomerById(customer.getId());
            if (fetchedCustomer != null) {
                System.out.println("Found customer: " + fetchedCustomer);
            }

            // 4. Fetch all customers
            System.out.println("\n4. Fetching all customers...");
            customerDAO.getAllCustomers().forEach(System.out::println);

            // 5. JPQL Query: Fetch Customer by email
            System.out.println("\n5. JPQL Query - Fetching customer by email...");
            Customer customerByEmail = customerDAO.getCustomerByEmail("john.doe@example.com");
            if (customerByEmail != null) {
                System.out.println("Customer found by email: " + customerByEmail);
            }

            // 6. Update order details
            System.out.println("\n6. Updating order details...");
            order.setQuantity(2);
            order.setPrice(1999.98);
            String orderUpdateResult = orderDAO.updateOrder(order);
            System.out.println(orderUpdateResult);

            // 7. Fetch order by id
            System.out.println("\n7. Fetching order by ID...");
            Order fetchedOrder = orderDAO.getOrderById(order.getId());
            if (fetchedOrder != null) {
                System.out.println("Found order: " + fetchedOrder);
            }

            // 8. Delete customer by id (this will also delete the associated order due to cascade)
            System.out.println("\n8. Deleting customer by ID...");
            String deleteResult = customerDAO.deleteCustomerById(customer.getId());
            System.out.println(deleteResult);

        } catch (Exception e) {
            System.err.println("Error during operations: " + e.getMessage());
            e.printStackTrace();
        } finally {
            customerDAO.close();
            orderDAO.close();
        }
    }
}
