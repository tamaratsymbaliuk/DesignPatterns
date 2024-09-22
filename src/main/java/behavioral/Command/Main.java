package behavioral.Command;

public class Main {
    public static void main(String[] args) {
        Phone phone = new Phone();
        RestaurantCommandExecutor executor = new RestaurantCommandExecutor();

        executor.executeOperation(new OrderFoodCommand());
        executor.executeOperation(new PayCommand(phone));
    }
}
