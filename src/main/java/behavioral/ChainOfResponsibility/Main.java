package behavioral.ChainOfResponsibility;

import java.util.Scanner;

// Main class to test the ATM dispense chain
public class Main {
    public static void main(String[] args) {
        ATMDispenseChain atmDispenseChain = new ATMDispenseChain();

        while (true) {
            System.out.println("Enter amount to dispense:");
            Scanner input = new Scanner(System.in);
            int amount = input.nextInt();

            if (amount % 10 != 0) {
                System.out.println("Amount should be in multiples of 10.");
                continue;
            }

            // Process the request
            atmDispenseChain.c1.dispense(new Currency(amount));
        }
    }
}
