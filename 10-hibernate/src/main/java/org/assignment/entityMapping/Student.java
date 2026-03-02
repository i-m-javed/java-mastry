package org.assignment.entityMapping;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(columnDefinition = "uuid")
    private UUID id;

    /*
    If using UUID:
    Make sure PostgreSQL extension is enabled:
    CREATE EXTENSION IF NOT EXISTS "uuid-ossp";
    It enables a PostgreSQL extension that allows the database to generate UUID values.
    UUID = Universally Unique Identifier
    It has:
        32 hexadecimal characters
        Divided into 5 sections
        128 bits
        ex- 3f50c7a1-6d23-4c19-9d2f-91c7a2b9f4a1
     */

    @Column(name = "student_name", nullable = false, length = 100)
    private String name;

    @Column(nullable = false)
    private int age;

    @Column(unique = true)
    private String email;

    @Enumerated(EnumType.STRING)
    private Department department;

    @Column(name = "admission_date")
    private LocalDate admissionDate;

    @Lob
    private String description;

    @Transient
    private String temporaryField;

    public Student() {
    }

    public Student(String name, int age, String email, Department department) {
        this.name = name;
        this.age = age;
        this.email = email;
        this.department = department;
        this.admissionDate = LocalDate.now();
    }

    // getters and setters
}