package com.capgi.dao;

import com.capgi.entity.Student;
import com.capgi.repository.StudentRepository;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class StudentDAOImpl implements StudentDAO{

    @Override
    public void save(Student s) {
        Session session= StudentRepository.getSession();
        Transaction transaction= session.beginTransaction();
        session.persist(s);
        transaction.commit();
        session.close();
    }

    @Override
    public void deleteStudent(Student s) {
        Session session= StudentRepository.getSession();
        Transaction transaction= session.beginTransaction();
        session.remove(s);
        transaction.commit();
        session.close();
    }


    @Override
    public Student getStudentById(int id) {
        Session session= StudentRepository.getSession();
        Student student=session.get(Student.class,id);
        session.close();
        return student;
    }

    @Override
    public List<Student> getAllStudent() {
        Session session= StudentRepository.getSession();
        List<Student> list=session.createQuery("from Student", Student.class)
                .list();
        session.close();
        return list;
    }

    @Override
    public void updateMarks(int id, double marks) {
        Session session= StudentRepository.getSession();
        Transaction transaction= session.beginTransaction();
        Student student=session.get(Student.class,id);
        student.setMarks(marks);
        session.merge(student);
        transaction.commit();
        session.close();
    }

    @Override
    public List<Student> sortBymarks() {
        Session session= StudentRepository.getSession();
        List<Student> list=session.createQuery("from Student s order by s.marks", Student.class).list();
        session.close();
        return list;
    }

    @Override
    public List<Student> sortByAgeDesc() {
        Session session= StudentRepository.getSession();
        List<Student> list=session.createQuery("from Student s order by s.age desc", Student.class).list();
        session.close();
        return list;
    }

    @Override
    public List<Student> filterByDept(String dept) {
        Session session= StudentRepository.getSession();
        Query<Student> query=session.createQuery("from Student where dept=:d", Student.class);
        query.setParameter("d",dept);
        List<Student> list=query.getResultList();
        session.close();
        return list;
    }

    @Override
    public List<Student> nativeFetch() {
        Session session= StudentRepository.getSession();
        List<Student> list=session.createNativeQuery("Select * from Student", Student.class).list();
        return list;
    }

    @Override
    public void nativeUpdateMarks(int id, double marks) {
        Session session= StudentRepository.getSession();
        Transaction transaction= session.beginTransaction();
        Query query= session.createNativeQuery("Update Student set marks= :m where id= :id", Student.class);
        query.setParameter("m",marks);
        query.setParameter("id",id);
        transaction.commit();
        session.close();
    }
}
