package lab3.files;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.nio.file.Path;

public class ImageFile extends File {
    public ImageFile(Path filePath) throws IOException {
        super(filePath);
    }

    @Override
    public void info() {
        printBasicInfo();

        try {
            BufferedImage image = ImageIO.read(filePath.toFile());
            if (image != null) {
                int width = image.getWidth();
                int height = image.getHeight();
                System.out.println("image size: " + width + "*" + height);
            } else {
                System.out.println("failed to read image size.");
            }
        } catch (IOException e) {
            System.out.println("error reading image: " + e.getMessage());
        }
    }


}

