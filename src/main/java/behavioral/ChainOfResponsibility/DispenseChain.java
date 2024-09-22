package behavioral.ChainOfResponsibility;

// DispenseChain interface defining the methods for setting the chain and dispensing currency
public interface DispenseChain {
    void setNextChain(DispenseChain nextChain);
    void dispense(Currency currency);
}
