package imagebrowser;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

public class ConsoleImageViewer extends ImageViewer {
    
    @Override
    public void refresh(ImagePanel imagePanel) {
        System.out.print(getImage().getDimension().getWidth());
        System.out.print("x");
        System.out.print(getImage().getDimension().getHeight());
        System.out.println("");
        ProxyImage proxy = (ProxyImage)getImage();
        System.out.println("ImageName: " + proxy.getName());
        try {
            imagePanel.setRotation(ImageIO.read(new File("C:\\Users\\Public\\Pictures\\Sample Pictures" + "\\" + proxy.getNext().getName())), ImageIO.read(new File("C:\\Users\\Public\\Pictures\\Sample Pictures" + "\\" + proxy.getPrev().getName())));
        } catch (IOException ex) {
            Logger.getLogger(ConsoleImageViewer.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        imagePanel.setImage(BufferedImageLoader.load("C:\\Users\\Public\\Pictures\\Sample Pictures" + "\\" + proxy.getName()));
    }

}
