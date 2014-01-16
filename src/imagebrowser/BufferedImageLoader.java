package imagebrowser;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class BufferedImageLoader {
    public static BufferedImage load(String filename){
        try {
            return ImageIO.read(new File(filename));
        } catch (IOException ex) {
            return null;
        }
    }
}
