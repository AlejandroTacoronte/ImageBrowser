package imagebrowser;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.swing.JPanel;

public class ImagePanel extends JPanel {

    private BufferedImage image;
    private int initialX;
    private int offset;
    private NextImageCommand nextImageCommand;
    private PrevImageCommand prevImageCommand;
    private BufferedImage nextImage;
    private BufferedImage prevImage;
    
    public ImagePanel() {
        super();
        this.offset = 0;
        this.hookEvents();
    }

    public void setImage(BufferedImage image) {
        this.image = image;
        repaint();
    }

    @Override
    public void paint(Graphics graphics) {
        if (image == null) {
            return;
        }
        graphics.clearRect(0, 0, this.getWidth(), this.getHeight());
        graphics.drawImage(image, offset, 0, null);
        if(offset == 0)
            return;
        if(offset < 0)
            graphics.drawImage(nextImage, image.getWidth() + offset, 0, null);
        else
            graphics.drawImage(prevImage, offset - image.getWidth(), 0, null);
    }

    private void hookEvents() {
        this.hookMouseListener();
        this.hookMouseMotionListener();
    }

    private void hookMouseListener() {
        this.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent me) {
                System.out.println("clicked" + me.getX());
            }

            @Override
            public void mousePressed(MouseEvent me) {
                System.out.println("pressed" + me.getX());
                initialX = me.getX();
            }

            @Override
            public void mouseReleased(MouseEvent me) {
                System.out.println("released" + me.getX());
                if(offset > image.getWidth() / 2)
                    prevImageCommand.execute();
                if(offset < -image.getWidth() / 2)
                    nextImageCommand.execute();
                offset = 0;
                repaint();
            }

            @Override
            public void mouseEntered(MouseEvent me) {
                System.out.println("entered" + me.getX());
            }

            @Override
            public void mouseExited(MouseEvent me) {
                System.out.println("exited");
            }
        });
    }

    private void hookMouseMotionListener() {
        this.addMouseMotionListener(new MouseMotionListener() {

            @Override
            public void mouseDragged(MouseEvent me) {
                System.out.println("dragging " + me.getX());
                offset = me.getX() - initialX;
                repaint();
            }

            @Override
            public void mouseMoved(MouseEvent me) {
                System.out.println("moving " + me.getX());
            }
        });
    }
    
    public void setDrag(NextImageCommand next, PrevImageCommand prev) throws IOException {
        nextImageCommand = next;
        prevImageCommand = prev;
    }
    
    public void setRotation(BufferedImage nextImage, BufferedImage prevImage) {
        this.nextImage = nextImage;
        this.prevImage = prevImage;
    }
}