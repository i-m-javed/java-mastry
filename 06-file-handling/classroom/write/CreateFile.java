import java.io.File;

public class CreateFile {
    static void main() {
        File file = new File("06-file-handling/classroom/DATA/student.txt");

        try {
            if (file.createNewFile()) {
                System.out.println("File Created successfully!");
            } else {
                System.out.println("File Already exists!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
