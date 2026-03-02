package org.classroom.dao;

import org.classroom.entity.Student;

import java.util.List;

public interface StudentDAO {
    void save(Student student);

    List<Student> fetchAll();

    Student fetchById(int id);

    void updateMarks(int id, double marks);

    void delete(int id);

    List<Student> sortByMarks();

    List<Student> sortByAgeDesc();

    List<Student> filterByDept(String dept);

    List<Student> nativeFetch();

    void nativeUpdateMarks(int id, double marks);
}
