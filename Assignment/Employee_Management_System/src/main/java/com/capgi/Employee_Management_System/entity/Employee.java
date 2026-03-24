package com.capgi.Employee_Management_System.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
public class Employee implements Comparable<Employee> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer empId;

    private String name;

    @Column(unique = true, nullable = false)
    private String email;

    private String phone;

    private LocalDateTime joinDate;

    private Double salary;

    private String address;

    private String deptName;

    private String role;

    private String password;

    private Integer age;

    private String gender;

    private Boolean active;

    private Double bonus;

    private Integer experienceYears;

    private String designation;

    @Override
    public int compareTo(Employee o) {
        return this.salary.compareTo(o.salary);
    }
}
