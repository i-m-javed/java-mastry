
import java.io.BufferedWriter;
import java.io.FileWriter;

public class Write_in_File_2 {
    static void main() {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("06-file-handling/classroom/DATA/student_buffered.txt")); // true --> append

            writer.write("\nName : Javed");
            writer.newLine();
            writer.write("Course : Spring");
            writer.newLine();
            writer.write("Marks : 90");
            writer.close();
            System.out.println("Data written using BufferedWriter.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
