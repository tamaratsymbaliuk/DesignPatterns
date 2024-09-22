package behavioral.ChainOfResponsibility;

// Main ATMDispenseChain class to handle the setup of the dispensing chain
public class ATMDispenseChain {
    protected DispenseChain c1;

    public ATMDispenseChain() {
        // Initialize the chain of responsibility
        this.c1 = new Dollar50Dispenser(); // Add a 50$ dispenser at the start
        DispenseChain c2 = new Dollar20Dispenser();
        DispenseChain c3 = new Dollar10Dispenser();

        // Set the chain of responsibility
        c1.setNextChain(c2);
        c2.setNextChain(c3);
    }
}

