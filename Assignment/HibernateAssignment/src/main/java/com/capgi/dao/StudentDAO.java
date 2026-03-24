package com.capgi.dao;

import com.capgi.entity.Student;

import java.util.List;

public interface StudentDAO {
    void save(Student s);
    void deleteStudent(Student s);
    Student getStudentById(int id);
    List<Student> getAllStudent();
    void updateMarks(int id,double marks);
    List<Student> sortBymarks();
    List<Student> sortByAgeDesc();
    List<Student> filterByDept(String dept);
    List<Student> nativeFetch();
    void nativeUpdateMarks(int id,double marks);
}
