package org.example.respository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Repository {

    private static final EntityManagerFactory emf =
            Persistence.createEntityManagerFactory("aman");

    public static EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public static void closeFactory() {
        emf.close();
    }
}