package org.example.Labbook2.Abstract_Q5;

// SavingsAccount Class
public class SavingsAccount extends Account {

    private static final double MIN_BALANCE = 1000.0;

    public SavingsAccount(double initialBalance) {
        super(initialBalance);
    }

    @Override
    public void withdraw(double amount) {
        if (balance - amount >= MIN_BALANCE) {
            balance -= amount;
        } else {
            System.out.println("Withdrawal denied! Minimum balance must be maintained.");
        }
    }
}
