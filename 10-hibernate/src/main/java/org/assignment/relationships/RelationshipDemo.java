package org.assignment.relationships;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class RelationshipDemo {

    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure()
                .addAnnotatedClass(Student.class)
                .addAnnotatedClass(Department.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {

            session.beginTransaction();

            Department dept = new Department("Computer Science");

            Student s1 = new Student("Javed", 25);
            Student s2 = new Student("Aman", 22);

            dept.addStudent(s1);
            dept.addStudent(s2);

            session.persist(dept);

            session.getTransaction().commit();

            System.out.println("Relationship saved successfully!");

        } finally {
            factory.close();
        }
    }
}