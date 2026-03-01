import java.io.EOFException;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.Serializable;

public class Object_Read {
    static void main() {
        try (
                ObjectInputStream ois = new ObjectInputStream(new FileInputStream("06-file-handling/classroom/DATA/student_object.ser"));
        ) {
            while (true) {
                Student s = (Student) ois.readObject();
                System.out.println(s.getName() + " : " + s.getId());
            }

        } catch (EOFException e) {
            System.out.println("Finished reading file");
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

