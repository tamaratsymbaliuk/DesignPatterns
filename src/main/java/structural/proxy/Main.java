package structural.proxy;

public class Main {
    public static void main(String[] args) {
        Image image1 = new ProxyImage("image1.jpg");
        Image image2 = new ProxyImage("image2.jpg");

        image1.display(); // Image1 will be loaded and displayed
        image2.display(); // Image2 will be loaded and displayed

        image1.display(); // Image1 is already loaded, so it will be displayed without loading again
    }
}
