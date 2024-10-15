package org.example.Labbook2.Abstract_Q5;

// CurrentAccount Class
public class CurrentAccount extends Account {

    private static final double OVERDRAFT_LIMIT = 5000.0;

    public CurrentAccount(double initialBalance) {
        super(initialBalance);
    }

    @Override
    public void withdraw(double amount) {
        if (balance - amount >= -OVERDRAFT_LIMIT) {
            balance -= amount;
        } else {
            System.out.println("Withdrawal denied! Overdraft limit exceeded.");
        }
    }
}
