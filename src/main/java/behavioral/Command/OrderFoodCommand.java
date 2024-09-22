package behavioral.Command;

import java.util.ArrayList;
import java.util.List;

public class OrderFoodCommand implements RestarauntCommand {
    private String order(List<String> dishes) {
        return String.join(",", dishes);
    }
    @Override
    public String execute() {
        List<String> dishes = new ArrayList<>();
        dishes.add("fish");
        return order(dishes);
    }
}
