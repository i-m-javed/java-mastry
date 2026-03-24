package com.capgi.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.Data;
import lombok.ToString;

@Entity
@Data
public class Laptop {
    @Id
    private int id;
    private String brand;
    private double price;
    @OneToOne (mappedBy = "laptop")
    @ToString.Exclude
    private Student1 student;
}
