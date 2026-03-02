package org.assignment.dao;


import org.assignment.entity.Student;
import org.assignment.repository.StudentRepository;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.Collections;
import java.util.List;

public class StudentDAOImpl implements StudentDAO {

    @Override
    public void save(Student student) {

        Transaction tx = null;

        try (Session session = StudentRepository.getSession()) {

            tx = session.beginTransaction();
            session.persist(student);
            tx.commit();

        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        }
    }

    @Override
    public List<Student> fetchAll() {

        try (Session session = StudentRepository.getSession()) {
            return session.createQuery("FROM Student", Student.class).list();
        }
    }

    @Override
    public void nativeUpdateMarks(int id, double marks) {

        Transaction tx = null;

        try (Session session = StudentRepository.getSession()) {

            tx = session.beginTransaction();

            session.createNativeQuery(
                            "UPDATE students SET mark = :marks WHERE id = :id"
                    )
                    .setParameter("marks", marks)
                    .setParameter("id", id)
                    .executeUpdate();

            tx.commit();

        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        }
    }

    @Override
    public Student fetchById(int id) {

        try (Session session = StudentRepository.getSession()) {
            return session.get(Student.class, id);
        }
    }

    @Override
    public void updateMarks(int id, double marks) {

        Transaction tx = null;

        try (Session session = StudentRepository.getSession()) {

            tx = session.beginTransaction();

            Student student = session.get(Student.class, id);
            if (student != null) {
                student.setMark(marks);
            }

            tx.commit();

        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {

        Transaction tx = null;

        try (Session session = StudentRepository.getSession()) {

            tx = session.beginTransaction();

            Student student = session.get(Student.class, id);
            if (student != null) {
                session.remove(student);
            }

            tx.commit();

        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        }
    }

    @Override
    public List<Student> sortByMarks() {
        List<Student> students = fetchAll();
        Collections.sort(students);   // Uses Comparable
        return students;
    }

    @Override
    public List<Student> sortByAgeDesc() {

        try (Session session = StudentRepository.getSession()) {
            return session.createQuery(
                    "FROM Student s ORDER BY s.age DESC",
                    Student.class
            ).list();
        }
    }

    @Override
    public List<Student> filterByDept(String dept) {

        try (Session session = StudentRepository.getSession()) {
            return session.createQuery(
                            "FROM Student s WHERE s.dept = :dept",
                            Student.class
                    )
                    .setParameter("dept", dept)
                    .list();
        }
    }

    @Override
    public List<Student> nativeFetch() {

        try (Session session = StudentRepository.getSession()) {
            return session.createNativeQuery(
                    "SELECT * FROM students",
                    Student.class
            ).list();
        }
    }
}