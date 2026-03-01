import java.io.File;
import java.util.Scanner;

public class Read_from_file_3 {
    static void main() throws Exception {

        File file = new File("06-file-handling/classroom/DATA/students.txt");
        Scanner sc = new Scanner(file);

        while (sc.hasNextLine()) {
            System.out.println(sc.nextLine());
        }

        System.out.println("FILE Read completed");

        sc.close();
    }
}
