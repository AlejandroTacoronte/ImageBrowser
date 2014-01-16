package imagebrowser;

import java.awt.event.ActionEvent;

public class PrevImageCommand implements Command {
    
    private final ImageViewer viewer;

    public ImageViewer getViewer() {
        return viewer;
    }
    private final ImagePanel imagePanel;

    public PrevImageCommand(ImageViewer viewer, ImagePanel imagePanel) {
        this.viewer = viewer;
        this.imagePanel=imagePanel;
    }

    @Override
    public void execute() {
        this.viewer.setImage(this.viewer.getImage().getPrev(),imagePanel);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        execute();
    }
}
