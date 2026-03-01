import java.io.*;
import java.nio.file.*;
import java.util.List;

class Employee implements Serializable {

    private static final long serialVersionUID = 1L;

    private int id;
    private String name;

    public Employee(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return id + " - " + name;
    }
}

public class FileHandling {

    public static void main(String[] args) {

        System.out.println("==== WRITE USING BUFFERED WRITER ====");
        writeFile();

        System.out.println("\n==== READ USING BUFFERED READER ====");
        readFile();

        System.out.println("\n==== NIO FILE READ ====");
        nioRead();

        System.out.println("\n==== SERIALIZATION DEMO ====");
        serializeObject();
        deserializeObject();
    }

    private static void writeFile() {

        try (BufferedWriter writer =
                     new BufferedWriter(new FileWriter("data.txt"))) {

            writer.write("Java File Handling");
            writer.newLine();
            writer.write("Using BufferedWriter");

        } catch (IOException e) {
            System.out.println("Write Error: " + e.getMessage());
        }
    }

    private static void readFile() {

        try (BufferedReader reader =
                     new BufferedReader(new FileReader("data.txt"))) {

            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

        } catch (IOException e) {
            System.out.println("Read Error: " + e.getMessage());
        }
    }

    private static void nioRead() {

        try {
            Path path = Paths.get("data.txt");
            List<String> lines = Files.readAllLines(path);
            lines.forEach(System.out::println);

        } catch (IOException e) {
            System.out.println("NIO Error: " + e.getMessage());
        }
    }

    private static void serializeObject() {

        Employee emp = new Employee(1, "Javed");

        try (ObjectOutputStream out =
                     new ObjectOutputStream(
                             new FileOutputStream("employee.ser"))) {

            out.writeObject(emp);

        } catch (IOException e) {
            System.out.println("Serialization Error: " + e.getMessage());
        }
    }

    private static void deserializeObject() {

        try (ObjectInputStream in =
                     new ObjectInputStream(
                             new FileInputStream("employee.ser"))) {

            Employee emp = (Employee) in.readObject();
            System.out.println(emp);

        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Deserialization Error: " + e.getMessage());
        }
    }
}