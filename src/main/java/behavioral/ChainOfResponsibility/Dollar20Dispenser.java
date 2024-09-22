package behavioral.ChainOfResponsibility;

public class Dollar20Dispenser implements DispenseChain {
    private DispenseChain nextChain;

    @Override
    public void setNextChain(DispenseChain nextChain) {
        this.nextChain = nextChain;
    }

    @Override
    public void dispense(Currency currency) {
        if (currency.getAmount() >= 20) {
            int num = currency.getAmount() / 20;
            int remainder = currency.getAmount() % 20;
            System.out.println("Dispensing " + num + " 20$ note" + (num > 1 ? "s" : ""));
            if (remainder != 0 && nextChain != null) {
                nextChain.dispense(new Currency(remainder));
            }
        } else if (nextChain != null) {
            nextChain.dispense(currency);
        }
    }
}