package org.assignment.hibernateFundamentals;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class HibernateDemo {

    public static void main(String[] args) {

        // Finally Configuration is the class therefore object can be made.
        Configuration con = new Configuration().configure().addAnnotatedClass(Student.class);

        // Again SessionFactory is the interface --> go to Configuration
        SessionFactory factory = con.buildSessionFactory();

        //Session is the interface --> go to SessionFactory
        Session session = factory.openSession();


        try {

            Student student = new Student("Javed", 23);
            Transaction tx = session.beginTransaction();
            session.beginTransaction();
            session.save(student);
            tx.commit();

        } finally {
            factory.close();
        }
    }
}