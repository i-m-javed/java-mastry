package org.assignment;

import org.assignment.dao.StudentDAO;
import org.assignment.dao.StudentDAOImpl;
import org.assignment.entity.Student;
import org.assignment.repository.StudentRepository;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        StudentDAO studentDAO = new StudentDAOImpl();


        // SAVE

        Student s1 = Student.builder()
                .name("Javed")
                .age(23)
                .dept("IT")
                .mark(88.5)
                .build();

        Student s2 = Student.builder()
                .name("Rahul")
                .age(21)
                .dept("CS")
                .mark(92.0)
                .build();

        studentDAO.save(s1);
        studentDAO.save(s2);


        // FETCH ALL

        System.out.println("\nAll Students:");
        List<Student> students = studentDAO.fetchAll();
        students.forEach(System.out::println);


        // FETCH BY ID

        System.out.println("\nFetch By ID (1):");
        System.out.println(studentDAO.fetchById(1));


        // UPDATE MARKS

        studentDAO.updateMarks(1, 95.0);

        System.out.println("\nAfter Update:");
        System.out.println(studentDAO.fetchById(1));


        // SORT BY MARKS (Comparable)

        System.out.println("\nSorted By Marks:");
        studentDAO.sortByMarks()
                .forEach(System.out::println);


        // FILTER BY DEPARTMENT

        System.out.println("\nFilter By Dept (IT):");
        studentDAO.filterByDept("IT")
                .forEach(System.out::println);


        // NATIVE FETCH

        System.out.println("\nNative Fetch:");
        studentDAO.nativeFetch()
                .forEach(System.out::println);


        // DELETE

        studentDAO.delete(2);

        System.out.println("\nAfter Delete:");
        studentDAO.fetchAll()
                .forEach(System.out::println);

        // Shutdown Hibernate
        StudentRepository.shutdown();
    }
}