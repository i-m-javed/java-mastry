package org.assignment.crudOperationAndSession;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateCrudDemo {

    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure()
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {

            // -----------------
            // CREATE
            // -----------------
            session.beginTransaction();

            Student student = new Student("Javed", 25);
            session.persist(student);

            session.getTransaction().commit();

            System.out.println("Saved with ID: " + student.getId());


            // -----------------
            // READ
            // -----------------
            session = factory.getCurrentSession();
            session.beginTransaction();

            Student fetched = session.get(Student.class, student.getId());
            System.out.println("Fetched: " + fetched.getName());

            session.getTransaction().commit();


            // -----------------
            // UPDATE (Dirty Checking)
            // -----------------
            session = factory.getCurrentSession();
            session.beginTransaction();

            Student updateStudent =
                    session.get(Student.class, student.getId());

            updateStudent.setName("Updated Name");

            session.getTransaction().commit();


            // -----------------
            // DELETE
            // -----------------
            session = factory.getCurrentSession();
            session.beginTransaction();

            Student deleteStudent =
                    session.get(Student.class, student.getId());

            session.remove(deleteStudent);

            session.getTransaction().commit();

        } finally {
            factory.close();
        }
    }
}