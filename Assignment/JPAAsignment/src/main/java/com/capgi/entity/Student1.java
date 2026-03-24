package com.capgi.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.Data;
import lombok.ToString;

@Entity
@Data
public class Student1 {
    @Id
    private int id;
    private String name;
    private String course;
    @OneToOne
    @JoinColumn(name="laptop_id")
    @ToString.Exclude
    private Laptop laptop;
}
