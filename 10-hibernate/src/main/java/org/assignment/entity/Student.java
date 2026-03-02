package org.assignment.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "students")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class Student implements Comparable<Student> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 100)
    private String name;

    private Integer age;

    private String dept;

    private Double mark;

    // Natural Sorting by mark (Descending)
    @Override
    public int compareTo(Student other) {
        return other.getMark().compareTo(this.mark);
    }
}
