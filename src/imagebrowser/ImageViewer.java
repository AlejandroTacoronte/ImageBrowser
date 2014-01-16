package imagebrowser;

public abstract class ImageViewer {
    
    private Image image;
    public Image getImage() {
        return image;
    }

    public void setImage(Image image, ImagePanel imagePanel) {
        this.image = image;
        refresh(imagePanel);
    }
    
    public abstract void refresh(ImagePanel imagePanel);

}
