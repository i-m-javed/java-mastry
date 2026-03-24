package com.capgi;

import com.capgi.Entity.Human;
import com.capgi.Entity.Pan;
import com.capgi.Entity.Passport;
import com.capgi.Entity.Person;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
//        Person person=new Person();
//        person.setId(1);
//        person.setName("Kapil Dev");
//
//        Pan pan= new Pan();
//        pan.setPanNumber(1);
//        pan.setPanAddress("Greater Noida");
//        person.setPan(pan);
//        pan.setPerson(person);

        Human human= new Human();
        human.setId(33);
        human.setName("Hardik Pandya");
        human.setAddress("Gujarat");

        Passport passport=new Passport();
        passport.setPassportId(1);
        passport.setCountry("India");
        passport.setPassportNumber("QA124");

        human.setPassport(passport);

        EntityManagerFactory entityManagerFactory= Persistence.createEntityManagerFactory("jpa-example");
        EntityManager entityManager= entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction=entityManager.getTransaction();
        entityTransaction.begin();

        entityManager.persist(human);
        entityManager.persist(passport);
        entityTransaction.commit();
    }
}
