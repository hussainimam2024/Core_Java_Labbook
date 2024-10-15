package org.example.Labbook2.Override_Q4;

// Savings Account Class
public class SavingsAccount implements Override_Q4 {

    private double balance;

    @Override
    public void deposit(double amount) {
        balance += amount;
    }

    @Override
    public void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
        }
    }

    @Override
    public double getBalance() {
        return balance;
    }
}
