package structural.facade;

public class Garland implements ChristmasTree {
    private ChristmasTree tree;
    public Garland(ChristmasTree tree) {
        this.tree = tree;
    }
    @Override
    public String decorate() {
        return tree.decorate() + " with Garland";
    }
}
