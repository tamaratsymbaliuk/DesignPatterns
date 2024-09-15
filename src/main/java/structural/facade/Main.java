package structural.facade;

public class Main {
    public static void main(String[] args) {
    // Facade simplifies adding multiple decorations
        Facade facade = new Facade();

        // Add decorations
        facade.addGarland();
        facade.addBubbleLights();

        // Print the final decorated tree
        System.out.println(facade.decorate());
    }
}
