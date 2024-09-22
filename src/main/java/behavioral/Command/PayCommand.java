package behavioral.Command;

public class PayCommand implements RestarauntCommand {
    private Phone phone;

    public PayCommand(Phone phone) {
        this.phone = phone;
    }
    @Override
    public String execute() {
        return phone.pay(); // return success or fail
    }
}
