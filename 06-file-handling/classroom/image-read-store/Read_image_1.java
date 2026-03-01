/*
There are 2 meanings of “read image”.
👉 1. Read image as bytes (processing)
👉 2. Display image (GUI)
    Used for:
    Upload APIs
    DB storage
    Compression
    Encryption
 */

import java.io.FileInputStream;

public class Read_image_1 {
    static void main() throws Exception {

        FileInputStream fis = new FileInputStream("06-file-handling/classroom/IMAGES/input/image_1.jpeg");

        byte[] data = fis.readAllBytes();
        fis.close();

        System.out.println("Image Size:" + data.length / 1024 + " kB");
    }
}
