import java.io.FileReader;

public class Read_from_File_1 {
    static void main() throws Exception {
        FileReader fr = new FileReader("06-file-handling/classroom/DATA/students.txt");
        int ch;
        while ((ch = fr.read()) != -1) {
            System.out.print((char) ch);
        }

        fr.close();
    }
}
