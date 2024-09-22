package behavioral.ChainOfResponsibility;

// Dispenser class for 50$ notes
public class Dollar50Dispenser implements DispenseChain {
    private DispenseChain nextChain;

    @Override
    public void setNextChain(DispenseChain nextChain) {
        this.nextChain = nextChain;
    }

    @Override
    public void dispense(Currency currency) {
        if (currency.getAmount() >= 50) {
            int num = currency.getAmount() / 50;
            int remainder = currency.getAmount() % 50;
            System.out.println("Dispensing " + num + " 50$ note" + (num > 1 ? "s" : ""));
            if (remainder != 0 && nextChain != null) {
                nextChain.dispense(new Currency(remainder));
            }
        } else if (nextChain != null) {
            nextChain.dispense(currency);
        }
    }
}