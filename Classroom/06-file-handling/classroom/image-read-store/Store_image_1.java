

/* COPY or SAVE IMAGE
 We read image as bytes → write bytes into another file.
 Source image → Destination image
 */


import java.io.FileInputStream;
import java.io.FileOutputStream;

public class Store_image_1 {
    static void main() {

        String sourcePath = "06-file-handling/classroom/IMAGES/input/image_1.jpeg";
        String destinationPath = "06-file-handling/classroom/IMAGES/output/copied.png"; // or jpeg

        try (FileInputStream fis = new FileInputStream(sourcePath);
             FileOutputStream fos = new FileOutputStream(destinationPath)) {

            int b;
            while ((b = fis.read()) != -1) {
                fos.write(b);
            }

            System.out.println("Image copied");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
