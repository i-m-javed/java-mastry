package NOTES.jpaFundamentals;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "students")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "student_seq")
    @SequenceGenerator(
            name = "student_seq",
            sequenceName = "student_sequence",
            allocationSize = 1
    )
    private Long id;

    private String name;
    private int age;

    @Version
    private int version;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }
    
}