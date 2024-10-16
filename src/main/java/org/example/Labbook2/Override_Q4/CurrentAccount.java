package org.example.Labbook2.Override_Q4;

// Current Account Class
abstract class CurrentAccount implements Override_Q4 {

    private double balance;
    @Override
    public void deposit(double amount) {
        balance += amount;
    }
    @Override
    public void withdraw(double amount) {
        balance -= amount;
    }

    @Override
    public double getBalance() {
        return balance;
    }
}
