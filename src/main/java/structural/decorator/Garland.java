package structural.decorator;

public class Garland extends TreeDecorator {

    public Garland(ChristmasTree tree) {
        super(tree);
    }

    @Override
    public String decorate() {
        return super.decorate() + decorateWithCarland();
    }

    private String decorateWithCarland() {
        return " with Garland";
    }
}
