package org.NOTES.crudOperationAndSession;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateCrudDemo {

    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure()
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session = null;

        try {

            // -----------------
            // CREATE
            // -----------------
//            session = factory.getCurrentSession(); // openSession
//            session.beginTransaction();

//            Student student = new Student("Javed", 25);
//            session.persist(student);
//
//            session.getTransaction().commit();
//
//            System.out.println("Saved with ID: " + student.getId());


            // -----------------
            // READ
            // ----------------

            session = factory.getCurrentSession();
            session.beginTransaction();

            long fetch_id = 2L;

            Student fetched = session.get(Student.class, fetch_id);
            System.out.println("Fetched: " + fetched.getName() + "Age : " + fetched.getAge());

            session.getTransaction().commit();


            // -----------------
            // UPDATE (Dirty Checking)
            // -----------------
//            session = factory.getCurrentSession();
//            session.beginTransaction();
//
//            long update_id = 2L;
//            Student updateStudent =
//                    session.get(Student.class, update_id);
//
//            updateStudent.setName("Updated Name");
//
//            session.getTransaction().commit();


            // -----------------
            // DELETE
            // -----------------
//            session = factory.getCurrentSession();
//            session.beginTransaction();
//
//            Long delete_id = 2L;
//
//            Student deleteStudent =
//                    session.get(Student.class, delete_id);
//
//            session.remove(deleteStudent);
//
//            session.getTransaction().commit();

        } finally {
            factory.close();
        }
    }
}