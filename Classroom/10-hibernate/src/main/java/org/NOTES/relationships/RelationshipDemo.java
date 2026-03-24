package org.NOTES.relationships;

import org.hibernate.Session;


public class RelationshipDemo {

    public static void main(String[] args) {

        Session session = HibernateUtil.getSessionFactory().getCurrentSession();

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
            HibernateUtil.getSessionFactory().close();
        }
    }
}