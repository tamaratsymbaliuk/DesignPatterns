package behavioral.ChainOfResponsibility;

public class Dollar10Dispenser implements DispenseChain {
    private DispenseChain nextChain;
    @Override
    public void setNextChain(DispenseChain nextChain) {
        this.nextChain = nextChain;
    }

    @Override
    public void dispense(Currency currency) {
        if (currency.getAmount() >= 10) {
            int num = currency.getAmount() / 10;
            int remainder = currency.getAmount() % 10;
            System.out.println("Dispensing " + num + " 10$ note" + (num > 1 ? "s" : ""));
            if (remainder != 0 && nextChain != null) {
                this.nextChain.dispense(new Currency(remainder));
            }
        } else if (nextChain != null) {
            nextChain.dispense(currency);
        }
    }
}
