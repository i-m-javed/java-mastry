import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;

// Read and display the images : bufferedImages
public class Read_image_2 {
    static void main() throws Exception {

        BufferedImage image = ImageIO.read(new File("06-file-handling/classroom/IMAGES/input/image_1.jpeg"));

        System.out.println("width:" + image.getWidth());
        System.out.println("height: " + image.getHeight());

//        ImageIcon icon = new ImageIcon(image);
//
//        // 3. Create label
//        JLabel label = new JLabel(icon);
//
//        // 4. Create frame
//        JFrame frame = new JFrame("Image Viewer");
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.getContentPane().add(label);
//        frame.pack();
//        frame.setVisible(true);

    }
}
