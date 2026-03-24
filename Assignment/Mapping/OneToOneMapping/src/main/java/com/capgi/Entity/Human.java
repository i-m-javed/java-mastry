package com.capgi.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Entity
@Data
public class Human {
    @Id
    private int id;
    private String name;
    private String address;
    @OneToOne
    private Passport passport;
}
