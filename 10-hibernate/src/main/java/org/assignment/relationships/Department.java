package org.assignment.relationships;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "departments")
@Data
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "dept_seq")
    @SequenceGenerator(
            name = "dept_seq",
            sequenceName = "department_sequence",
            allocationSize = 1
    )
    private Long id;

    private String name;

    @OneToMany(mappedBy = "department",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY)
    private List<Student> students = new ArrayList<>();

    public Department() {
    }

    public Department(String name) {
        this.name = name;
    }

    public void addStudent(Student student) {
        students.add(student);
        student.setDepartment(this);
    }
}
