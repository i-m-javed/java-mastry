package org.NOTES.entityMapping;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class FullName {
    private String fname;
    private String mname;
    private String lname;


    public FullName(String fname, String lname) {
        this.fname = fname;
        this.lname = lname;
    }

}
