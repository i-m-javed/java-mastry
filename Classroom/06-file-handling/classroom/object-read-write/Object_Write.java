import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;



public class Object_Write {
    static void main() {
        Student s1 = new Student(1, "Mohammad");
        Student s2 = new Student(2, "javed");
        Student s3 = new Student(3, "raj");

        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("06-file-handling/classroom/DATA/student_object.ser", true))) {
            out.writeObject(s1);
            out.writeObject(s2);
            out.writeObject(s3);

            System.out.println("Object saved succesfully");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}



class Student implements Serializable {
    private Integer id;
    private String name;

    public Student(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}