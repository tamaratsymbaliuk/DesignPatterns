package behavioral.State;

public class Main {
    public static void main(String[] args) {
        Fan fan = new Fan();
        fan.request();
        fan.request();
        fan.request();
        fan.cancel();
        fan.request();
    }
}
