package com.example;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TestConnection {
    public static void main(String[] args) {
        try {
            System.out.println("Testing JPA connection...");
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("CustomerOrderPU");
            EntityManager em = emf.createEntityManager();
            
            System.out.println("Connection successful! EntityManager created.");
            
            em.close();
            emf.close();
            System.out.println("Resources closed successfully.");
            
        } catch (Exception e) {
            System.err.println("Connection failed: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
