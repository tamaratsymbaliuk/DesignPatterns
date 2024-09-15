package structural.facade;

public class Facade {
    private ChristmasTree tree;
    public Facade() {
        this.tree = new ChristmasTreeImpl(); // Start with a basic tree
    }
    public void addGarland() {
        tree = new Garland(tree);
    }
    public void addBubbleLights() {
        tree = new BubbleLights(tree);
    }
    public String decorate() {
        return tree.decorate();
    }
}
