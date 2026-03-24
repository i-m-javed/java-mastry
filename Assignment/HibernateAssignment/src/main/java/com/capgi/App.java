package com.capgi;

import com.capgi.dao.StudentDAO;
import com.capgi.dao.StudentDAOImpl;
import com.capgi.entity.Student;

public class App {

    public static void main(String[] args) {

        StudentDAO dao = new StudentDAOImpl();

//        dao.save(new Student("Krishna Pratap Singh", "CSAI", 21, 85));
//        dao.save(new Student("Mayank", "CSAI", 22, 90));
//        dao.save(new Student("Anubhav", "CS", 21, 85));
//        dao.save(new Student("Abhishek", "IT", 23, 42));
        dao.getAllStudent().forEach(System.out::println);

        System.out.println(dao.getStudentById(1));

        dao.updateMarks(1, 95);

        dao.nativeUpdateMarks(2, 91);
        ;
        dao.sortBymarks().forEach(System.out::println);

        dao.sortByAgeDesc().forEach(System.out::println);

        dao.filterByDept("CSAI").forEach(System.out::println);

        dao.nativeFetch().forEach(System.out::println);
    }
}
