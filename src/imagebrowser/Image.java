package imagebrowser;

public abstract class Image {
    
    private String name;
    public Image(String name) {
        this.name = name;
    }
    public abstract Dimension getDimension();
    public abstract Image getNext();
    public abstract Image getPrev();
    
    public abstract void setNext(Image image);
    public abstract void setPrev(Image image);
    public String getName() {
        return name;
    }
    
}
