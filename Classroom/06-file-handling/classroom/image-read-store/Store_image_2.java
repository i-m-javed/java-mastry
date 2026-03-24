import java.io.FileInputStream;
import java.io.FileOutputStream;

/* same as Store Image 1 but it is much faster than that */

public class Store_image_2 {
    static void main() {

        String sourcePath = "/Users/mohammadjaved/Desktop/test/FILE/images_input/Video.mov";
        String destinationPath = "/Users/mohammadjaved/Desktop/test/FILE/image_output/video.mov"; // or jpeg

        try (FileInputStream fis = new FileInputStream(sourcePath);
             FileOutputStream fos = new FileOutputStream(destinationPath)) {

            byte[] buffer = new byte[1024]; // chunk size decided by buffer that is 1KB every time and size is upto us.
//            byte[] buffer = new byte[1024 * 1024]; // 1MB
//            byte[] buffer = new byte[1024 * 1024 * 1024]; // 1 GB
            int b;

            while ((b = fis.read(buffer)) != -1) {
                fos.write(buffer, 0, b);
            }

            System.out.println("Image copied");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

