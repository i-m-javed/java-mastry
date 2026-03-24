package org.capg.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity
public class Book {
    @Id
    private int id;
    private String title;
    private double price;
    private int publicationYear;

    @ManyToOne
    private Author author;
}
