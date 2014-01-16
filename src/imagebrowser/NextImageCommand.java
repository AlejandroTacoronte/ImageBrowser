package imagebrowser;

import java.awt.event.ActionEvent;

public class NextImageCommand implements Command {
    
    private final ImageViewer viewer;
    private final ImagePanel imagePanel;

    public NextImageCommand(ImageViewer viewer,ImagePanel imagePanel) {
        this.viewer = viewer;
        this.imagePanel = imagePanel;
    }

    @Override
    public void execute() {
        this.viewer.setImage(this.viewer.getImage().getNext(),imagePanel);
    }

    public ImageViewer getViewer() {
        return viewer;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        execute();
    }
}
