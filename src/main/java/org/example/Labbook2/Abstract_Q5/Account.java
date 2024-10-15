package org.example.Labbook2.Abstract_Q5;

// Abstract Account Class
public abstract class Account {
    protected double balance;

    public Account(double initialBalance) {
        this.balance = initialBalance;
    }

    // Common method for depositing amount
    public void deposit(double amount) {
        balance += amount;
    }

    // Abstract method for withdraw, to be implemented by derived classes
    public abstract void withdraw(double amount);

    // Common method for checking balance
    public double getBalance() {
        return balance;
    }

}
