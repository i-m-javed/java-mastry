import java.io.PrintWriter;

public class Write_in_File_3 {

    static void main() {
        try {

            PrintWriter pw = new PrintWriter("06-file-handling/classroom/DATA/student_printWrite.txt"); // --> true : append


            pw.println("Name : javed");
            pw.println("Course : sprint");
            pw.println("Marks : 90");

            pw.close();
            System.out.println("Data written successfully with the PrintWriter!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
