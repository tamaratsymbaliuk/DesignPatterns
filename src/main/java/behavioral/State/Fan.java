package behavioral.State;

// Fan class that uses different states to control behavior
// The Fan class acts as the context in the State pattern.
public class Fan {
    private FanState currentState;
    public Fan() {
        this.currentState = new OffState();
    }
    public void setState(FanState state) {
        this.currentState = state;
    }
    public void request() {
        currentState.handleRequest(this);
    }
    public void cancel() {
        currentState.undoRequest(this);
    }
}
