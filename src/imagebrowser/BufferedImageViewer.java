
package imagebrowser;

public class BufferedImageViewer extends ImageViewer{
    ImagePanel imagePanel =null;

    @Override
    public void refresh(ImagePanel imagePanel) {
        setCurrentImage(getImage());
    }
    
    private void setCurrentImage(Image image){
        ProxyImage proxyImage = (ProxyImage)getImage();
        RealImage realImage = (RealImage)proxyImage.getRealImage();
        System.out.println("C:\\Users\\Public\\Pictures\\Sample Pictures" + "\\" + realImage.getName());
    }
    
}
