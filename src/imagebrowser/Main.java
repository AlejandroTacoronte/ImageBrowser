package imagebrowser;

import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        new Main().execute();
    }

    private void execute() throws IOException {
        ApplicationFrame applicationFrame = createApplicationFrame();
        Image[] images = linkImages(createImages()); 
        ImageViewer viewer = createImageViewer(images[0],applicationFrame.getImagePanel());
        applicationFrame.createComponents(createCommands(viewer,applicationFrame.getImagePanel()));
    }

    private Image[] createImages() {
        String name[] = getFiles("C:\\Users\\Public\\Pictures\\Sample Pictures");
        Image[] images = new Image[name.length];
        for (int i = 0; i < images.length; i++) {
            images[i] = createImage(name[i]);
        }
        return images;
    }

    private Image createImage(final String name) {
        return new ProxyImage(new ImageLoader() {
            @Override
            public Image load() {
                return new RealImage(new Dimension(1024, 800),name);
            }
        }, name);
    }

    private Image[] linkImages(Image[] images) {
        for (int i = 0; i < images.length; i++) {
            Image image = images[i];
            Image next = images[(i + 1) % images.length];
            Image prev = images[(i + images.length - 1) % images.length];
            image.setNext(next);
            image.setPrev(prev);
        }
        return images;
    }

    private ImageViewer createImageViewer(Image image, ImagePanel imagePanel) {
        ImageViewer viewer = new ConsoleImageViewer();
        viewer.setImage(image,imagePanel);
        return viewer;
    }

    private ApplicationFrame createApplicationFrame() {
        return new ApplicationFrame();
    }
    
    private ActionListener[] createCommands(ImageViewer viewer,ImagePanel imagePanel) {
        return new ActionListener[] {
            new PrevImageCommand(viewer,imagePanel),
            new NextImageCommand(viewer,imagePanel)
        };
    }
    
    private String[] getFiles(String ROOT) {
        File directory = new File (ROOT); 
        File[] files = directory.listFiles(); 
        String[] name = new String[files.length]; 
        int i=0;
        for(File file:files) 
        { 
            name [i]= file.getName(); 
            i++;
        } 
        return name;
    }
    
}
