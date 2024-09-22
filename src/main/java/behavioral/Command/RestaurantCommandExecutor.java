package behavioral.Command;

public class RestaurantCommandExecutor {
    public String executeOperation(RestarauntCommand restarauntCommand) {
        return restarauntCommand.execute();
    }
}
