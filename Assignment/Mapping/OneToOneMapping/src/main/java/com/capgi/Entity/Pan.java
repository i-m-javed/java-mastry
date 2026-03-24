package com.capgi.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Entity
@Data
public class Pan {
    @Id
    private int panNumber;
    private String panAddress;
    @OneToOne
   private Person person;
}
