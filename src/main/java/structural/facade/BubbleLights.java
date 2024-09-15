package structural.facade;

public class BubbleLights implements ChristmasTree {
    private ChristmasTree tree;
    public BubbleLights(ChristmasTree tree) {
        this.tree = tree;
    }
    @Override
    public String decorate() {
        return tree.decorate() + " with Bubble Lights";
    }
}
