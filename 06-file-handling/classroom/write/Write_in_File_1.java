import java.io.FileWriter;
import java.io.IOException;

public class Write_in_File_1 {
    static void main() {
        try {
            doWrite();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void doWrite() throws IOException {

        FileWriter writer = new FileWriter("06-file-handling/classroom/DATA/student.txt", true);
        writer.write("\nName : Javed");
        writer.write("\nCourse : Spring");
        writer.write("\nMark : 90");

        writer.close();

        System.out.println("Data written using FileWriter.");
    }
}

