interface Picture {
    void show();
}

// Implement Real Subject Class
class HighResolutionImage implements Picture {
    private String fileName;

    public HighResolutionImage(String fileName) {
        this.fileName = fileName;
        loadFromDisk();
    }

    private void loadFromDisk() {
        System.out.println("Loading image from disk: " + fileName);
    }

    public void show() {
        System.out.println("Displaying image: " + fileName);
    }
}

// Implement Proxy Class
class ImageProxy implements Picture {
    private String fileName;
    private HighResolutionImage highResolutionImage;

    public ImageProxy(String fileName) {
        this.fileName = fileName;
    }

    public void show() {
        if (highResolutionImage == null) {
            highResolutionImage = new HighResolutionImage(fileName);
        }
        highResolutionImage.show();
    }
}

// Test the Proxy Implementation
public class ProxyPatternDemo {
    public static void main(String[] args) {
        Picture pic1 = new ImageProxy("photo1.jpg");
        Picture pic2 = new ImageProxy("photo2.jpg");

        // Image will be loaded from disk
        pic1.show();
        System.out.println("");

        // Image will not be loaded from disk as it is already loaded
        pic1.show();
        System.out.println("");

        // Image will be loaded from disk
        pic2.show();
        System.out.println("");

        // Image will not be loaded from disk as it is already loaded
        pic2.show();
    }
}
