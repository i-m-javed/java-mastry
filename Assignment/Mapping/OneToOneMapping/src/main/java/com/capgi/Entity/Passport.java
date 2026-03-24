package com.capgi.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Entity
@Data
public class Passport {
    @Id
    private int passportId;
    private String country;
    private String passportNumber;
    @OneToOne(mappedBy = "passport")
    private Human human;
}
