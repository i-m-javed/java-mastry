package com.capgi.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Entity
@Data
public class Person {
    @Id
    private int id;
    private String name;
    @OneToOne
    private Pan pan;
}
