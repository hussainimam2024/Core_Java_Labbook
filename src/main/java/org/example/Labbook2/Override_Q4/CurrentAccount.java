package org.example.Labbook2.Override_Q4;

// Current Account Class
public class CurrentAccount implements Override_Q4 {

    private double balance;

    @Override
    public void deposit(double amount) {
        balance += amount;
    }

    @Override
    public void withdraw(double amount) {
        balance -= amount;  // No restriction for overdraft
    }

    @Override
    public double getBalance() {
        return balance;
    }
}
