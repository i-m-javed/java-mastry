import java.io.BufferedReader;
import java.io.FileReader;

public class Read_from_File_2 {
    static void main() throws Exception {

        try (BufferedReader br = new BufferedReader(new FileReader("06-file-handling/classroom/DATA/students.txt"))) {
            String line;

      while ((line = br.readLine()) != null) {
               System.out.println(line);
      }
        }

        System.out.println("FILE Read completed");
    }
}
