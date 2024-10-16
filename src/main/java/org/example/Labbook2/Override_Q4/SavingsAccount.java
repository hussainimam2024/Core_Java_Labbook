package org.example.Labbook2.Override_Q4;

import org.example.Labbook2.package_Q3.bean.Employee;

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

    @Override
    public void getEmployeeDetails(Employee employee) {
        System.out.println(employee);
    }
    @Override
    public String findInsuranceScheme(Employee employee) {
        return employee.getInsuranceScheme();
    }
}
