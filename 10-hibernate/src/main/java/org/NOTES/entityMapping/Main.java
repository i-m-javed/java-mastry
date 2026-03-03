package org.NOTES.entityMapping;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Main {

    public static void main(String[] args) {

        SessionFactory sessionFactory = new Configuration()
                .configure()
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session = sessionFactory.getCurrentSession();

        Transaction tx = session.beginTransaction();

        Student student = new Student(new FullName("Mohammad", "javed"),
                25,
                "javed@gmail",
                Department.COMPUTER_SCIENCE);

        session.persist(student);

        tx.commit();

        System.out.println("Saved successfully");
    }

}
