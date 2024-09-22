package behavioral.State;

public interface FanState {
    void handleRequest(Fan fan);
    void undoRequest(Fan fan);
}
