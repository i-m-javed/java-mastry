package org.example;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import org.example.entity.Department;
import org.example.entity.Employee;

import java.util.Arrays;

public class App {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("aman");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();

        Employee e1 = new Employee();
        e1.setId(1);
        e1.setName("Aniket");

        Employee e2 = new Employee();
        e2.setId(2);
        e2.setName("Rahul");

        Department dept = new Department();
        dept.setId(1);
        dept.setName("IT");

        dept.setEmployees(Arrays.asList(e1, e2));

        em.persist(dept);

        tx.commit();

        em.close();
        emf.close();
    }
}