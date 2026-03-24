import java.io.File;

public class CreateFolder {

    static void main() {

        File folder = new File("DATA");

        if (!folder.exists()) {
            boolean created = folder.mkdir();

            if (created) {
                System.out.println("Folder Created Successfully");
            } else {
                System.out.println("Folder Creation failed");
            }
        } else {
            System.out.println("Folder Already exists");
        }
    }
}
