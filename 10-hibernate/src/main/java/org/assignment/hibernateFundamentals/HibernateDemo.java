package org.assignment.hibernateFundamentals;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateDemo {

    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure()
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            Student student = new Student("Javed", 25);

            session.beginTransaction();

            session.persist(student);

            session.getTransaction().commit();

            System.out.println("Saved successfully!");

        } finally {
            factory.close();
        }
    }
}