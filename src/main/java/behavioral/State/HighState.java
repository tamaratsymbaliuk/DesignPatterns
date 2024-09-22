package behavioral.State;

public class HighState implements FanState {
    @Override
    public void handleRequest(Fan fan) {
        System.out.println("Fan turned off.");
        fan.setState(new OffState());
    }

    @Override
    public void undoRequest(Fan fan) {
        System.out.println("Fan turned to medium speed.");
        fan.setState(new MediumState());
    }
}