package behavioral.State;

public class OffState implements FanState {
    @Override
    public void handleRequest(Fan fan) {
        System.out.println("Fan turned on low.");
        fan.setState(new LowState());
    }

    @Override
    public void undoRequest(Fan fan) {
        System.out.println("Fan remains off.");
    }
}
