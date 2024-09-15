package structural.composite;

public class Leaf implements Component {
    String name;
    private double price;
    public Leaf(){};

    public Leaf(String name, double price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public void showPrice() {
        System.out.println(this.price);
    }
}
